package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.constraints.ZDLMultiplicityConstraint;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.kryo.KryoReadUtil;
import com.zeligsoft.domain.dds4ccm.rhapsody.kryo.ValidationHelper;
import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.LocalRhapsodyProjectLocator;

public class ValidateIndicatorWithProgress extends IndicationWithMonitoring {
	
	private Map<String, Set<String>> resultMap;

	public ValidateIndicatorWithProgress(
			ModelServicesServerProtocol protocol) {
		super(protocol, EclipseServerSignals.Validate);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in, OMMonitor monitor)
			throws Exception {
		final String modelElementQualifiedName = in.readString();

		// pull model...
		final String modelName = in.readString();
		final Object project = KryoReadUtil.readModel(in);
		
		ModelServicesImpl msi = new ModelServicesImpl();
		
		final LocalRhapsodyProjectLocator projectLocator = new LocalRhapsodyProjectLocator(
				project);

		
		new JobQueueMonitor.Builder()
			.job(msi.getCreateUml2ModelJob(modelName), 100)
			.job(msi.getTransformToUml2Job(projectLocator), 200)
			.job(msi.getModelValidationJob(modelElementQualifiedName), 300)
			.build()
			.run(monitor);
		
		resultMap = processResults(msi.getValidationStatus());
	}

	private Map<String, Set<String>> processResults(IStatus result) {
		if(result == null) {
			return Collections.emptyMap();
		}
		final IStatus[] validationResults = result.isMultiStatus() ? result.getChildren() : new IStatus[] { result };
		final Map<String, Set<String>> resultMap = new HashMap<String, Set<String>>(validationResults.length);
		for (IStatus status : validationResults) {
			if(status instanceof IConstraintStatus) {
				final IConstraintStatus constraintStatus = (IConstraintStatus) status;
				final EObject target = constraintStatus.getTarget();
				if(target instanceof NamedElement) {
					final NamedElement namedElement = (NamedElement) target;
					final String fqn = rpQualifiedNameFor(namedElement);
					if(fqn == null) {
						// XXX For now, skip...
						continue;
					}
					final Set<String> list;
					if(resultMap.containsKey(fqn)) {
						list = resultMap.get(fqn);
					} else {
						list = new HashSet<String>();
						resultMap.put(fqn, list);
					}
					
					final IModelConstraint constraint = constraintStatus.getConstraint();
					final String constraintId;
					if(constraint instanceof ZDLMultiplicityConstraint) {
						// ZDLMultiplicityConstraint are too complex for Rhapsody to deal with.
						// Split them into specializations by appending concept and attribute name.
						ZDLMultiplicityConstraint multConstraint = (ZDLMultiplicityConstraint) constraint;
						final Class zdlConcept = ZDLUtil.getZDLConcept(constraintStatus.getTarget());
						final String conceptNameParts[] = zdlConcept.getName().split("::");
						final String conceptName = conceptNameParts[conceptNameParts.length - 1];
						final String attributeName = multConstraint.getDomainAttribute().getName();
						
						constraintId = ZDLMultiplicityConstraint.class.getCanonicalName() + "_" + conceptName + "_" + attributeName;
						
						System.out.println("ZDLMultiplicityConstraint: " + constraintId + ", target " + fqn);
						
					} else {
						constraintId = constraint.getDescriptor().getId();
						list.add(constraintId);
					}
					list.add(constraintId);
				}
			}
		}
		return resultMap;
	}

	private String rpQualifiedNameFor(NamedElement namedElement) {
		final String uml2QName = namedElement.getQualifiedName();
		if(uml2QName == null) {
			return null;
		}
		final int firstSeparator = uml2QName.indexOf("::");
		final String rpQNameCandidate = firstSeparator > 0 ? uml2QName.substring(firstSeparator + 2) : uml2QName;
		final String rpQName;
		if((namedElement instanceof Property && !(namedElement instanceof Port)) || namedElement instanceof Connector) {
			final int lastSeparator = rpQNameCandidate.lastIndexOf("::");
			rpQName = rpQNameCandidate.substring(0, lastSeparator) + "." + rpQNameCandidate.substring(lastSeparator + 2);
		} else {
			rpQName = rpQNameCandidate;
		}
		return rpQName;
	}

	@Override
	protected void responding(ExtendedDataOutputStream out, OMMonitor monitor)
			throws Exception {
		
		ValidationHelper.sendBackValidationResults(out, resultMap);

	}

}
