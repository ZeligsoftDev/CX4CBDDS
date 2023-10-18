/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.BasicOCLExecutor;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

public class OCLVMExecutor extends BasicOCLExecutor implements VMExecutor
{
	private static @NonNull EObject loadContext(@NonNull EnvironmentFactory environmentFactory, @NonNull URI contextURI) throws IOException {
		EObject eObject = environmentFactory.getResourceSet().getEObject(contextURI, true);
		if (eObject == null) {
			throw new IOException("Nothing loadable as '" + contextURI + "'");
		}
		return eObject;
	}

	private static @NonNull ExpressionInOCL loadExpression(@NonNull EnvironmentFactory environmentFactory, @NonNull URI constraintURI, boolean keepDebug) throws IOException, ParserException {
		MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		EObject eObject = metamodelManager.getASResourceSet().getEObject(constraintURI, true);
		return loadExpression(environmentFactory, eObject, constraintURI);
	}

	private static @NonNull ExpressionInOCL loadExpression(@NonNull EnvironmentFactory environmentFactory, EObject eObject, URI constraintURI) throws IOException, ParserException {
		if (eObject == null) {
			throw new IOException("Nothing loadable as '" + constraintURI + "'");
		}
		if (!(eObject instanceof Constraint)) {
			throw new IOException("Constraint rather than " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
		}
		LanguageExpression specification = ((Constraint)eObject).getOwnedSpecification();
		if (specification == null) {
			throw new IOException("Missing OCL expression " + eObject.eClass().getName() + " expected as '" + constraintURI + "'");
		}
		return ((EnvironmentFactoryInternalExtension)environmentFactory).parseSpecification(specification);
	}

	protected final @NonNull IVMContext vmContext;
	protected final @NonNull ExpressionInOCL expressionInOCL;
	protected final @Nullable EObject context;
	private boolean suspendOnStartup = false;
	private long envId = 0;

	public OCLVMExecutor(IVMContext vmContext, @NonNull URI oclURI, @Nullable URI contextURI) throws IOException, ParserException {
		this(vmContext, loadExpression(vmContext.getEnvironmentFactory(), oclURI, vmContext.keepDebug()), contextURI != null ? loadContext(vmContext.getEnvironmentFactory(), contextURI) : null);
	}

	public OCLVMExecutor(@NonNull IVMContext vmContext, @NonNull ExpressionInOCL expressionInOCL, @Nullable EObject context) {
		super(vmContext.getEnvironmentFactory(), new OCLVMModelManager(vmContext.getEnvironmentFactory().getMetamodelManager()));
		this.vmContext = vmContext;
		this.expressionInOCL = expressionInOCL;
		this.context = context;
	}

	@Override
	protected EvaluationVisitor.@NonNull EvaluationVisitorExtension createEvaluationVisitor() {
		OCLEvaluationVisitor evaluationVisitor = new OCLEvaluationVisitor(this);
		OCLVMEvaluationStepper vmEvaluationStepper = new OCLVMEvaluationStepper(evaluationVisitor, vmContext);
		return new OCLVMEvaluationVisitor(vmEvaluationStepper, evaluationVisitor);
	}

	@Override
	protected @NonNull OCLVMEvaluationEnvironment createNestedEvaluationEnvironment(EvaluationEnvironment.@NonNull EvaluationEnvironmentExtension evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		return new OCLVMNestedEvaluationEnvironment((OCLVMEvaluationEnvironment) evaluationEnvironment, executableObject, caller, ++envId);
	}

	@Override
	protected @NonNull OCLVMEvaluationEnvironment createRootEvaluationEnvironment(@NonNull NamedElement executableObject) {
		return new OCLVMRootEvaluationEnvironment(this, (ExpressionInOCL)executableObject, ++envId);
	}

	@Override
	public Object execute() {
		ThreadLocalExecutor.setExecutor(this);
		try {
			initializeEvaluationEnvironment(expressionInOCL);
			getRootEvaluationEnvironment();
			Variable contextVariable = expressionInOCL.getOwnedContext();
			if (contextVariable != null) {
				add(contextVariable, context);
			}
			OCLVMEvaluationVisitor visitor = (OCLVMEvaluationVisitor) getEvaluationVisitor();
			VMEvaluationStepper vmStepper = visitor.getVMEvaluationStepper();
			vmStepper.start(suspendOnStartup);
			return expressionInOCL.accept(visitor);
		}
		finally {
			ThreadLocalExecutor.setExecutor(null);
		}
	}

	@Override
	public @NonNull ExpressionInOCL getDebuggable() {
		return expressionInOCL;
	}

	@Override
	public @NonNull String getPluginId() {
		return OCLDebugPlugin.PLUGIN_ID;
	}

	@Override
	public void saveModels() {}

	@Override
	public void setSuspendOnStartUp(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}
}
