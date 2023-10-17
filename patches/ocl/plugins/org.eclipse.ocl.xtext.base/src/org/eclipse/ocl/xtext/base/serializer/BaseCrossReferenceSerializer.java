/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.serializer;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

// FIXME Temporary workaround for Bug 361577
@SuppressWarnings("restriction")
public class BaseCrossReferenceSerializer extends CrossReferenceSerializer
{
	protected class AcceptorHelper
	{
		protected final EObject semanticObject;
		protected final CrossReference crossref;
		protected final EObject target;
		protected final IScope scope;
		protected final @Nullable Acceptor errors;
		private @Nullable List<ISerializationDiagnostic> recordedErrors = null;

		public AcceptorHelper(EObject semanticObject, CrossReference crossref, EObject target, IScope scope, @Nullable Acceptor errors) {
			this.semanticObject = semanticObject;
			this.crossref = crossref;
			this.target = target;
			this.scope = scope;
			this.errors = errors;
		}

		public @Nullable String convert(String unconverted, String ruleName) {
			try {
				return valueConverter.toString(unconverted, ruleName);
			} catch (ValueConverterException e) {
				record(unconverted, e);
				return null;
			}
		}

		protected @Nullable String convert(List<String> segments, String ruleName) {
			int iMax = segments.size();
			String[] converted = new String[iMax];
			String unconverted = null;
			try {
				for (int i = 0; i < iMax; i++) {
					unconverted = segments.get(i);
					if ((i > 0) && "UnrestrictedName".equals(ruleName)) {
						converted[i] = valueConverter.toString(unconverted, "UnreservedName");
					}
					else {
						converted[i] = valueConverter.toString(unconverted, ruleName);
					}
				}
				return qualifiedNameConverter.toString(new QualifiedName(converted) {});
			} catch (ValueConverterException e) {
				record(unconverted, e);
				return null;
			}
		}

		protected void record(String unconverted, @NonNull ValueConverterException e) {
			if (errors != null) {
				List<ISerializationDiagnostic> recordedErrors2 = recordedErrors;
				if (recordedErrors2 == null)
					recordedErrors = recordedErrors2 = Lists.newArrayList();
				recordedErrors2.add(diagnostics.getValueConversionExceptionDiagnostic(semanticObject, crossref, unconverted, e));
			}
		}

		protected void report(boolean foundOne) {
			Acceptor errors2 = errors;
			if (errors2 != null) {
				if (recordedErrors != null)
					for (ISerializationDiagnostic diag : recordedErrors)
						errors2.accept(diag);
				if (!foundOne)
					errors2.accept(diagnostics.getNoEObjectDescriptionFoundDiagnostic(semanticObject, crossref, target, scope));
			}
		}
	}


	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IValueConverterService valueConverter;

	public BaseCrossReferenceSerializer() {
		super();
	}

	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject,
			CrossReference crossref, EObject target, IScope scope, Acceptor errors) {
		AcceptorHelper helper = new AcceptorHelper(semanticObject, crossref, target, scope, errors);
		boolean foundOne = false;
		final String ruleName = linkingHelper.getRuleNameFrom(crossref);
		if ("URI".equals(ruleName)) {
			if (semanticObject instanceof PathElementWithURICS) {
				PathElementWithURICS pathElementWithURICS = (PathElementWithURICS)semanticObject;
				String uri = pathElementWithURICS.getUri();
				if (uri != null) {
					String converted = helper.convert(uri, ruleName);
					if (converted != null) {
						return converted;
					}
				}
			}
			// This fallback is used, but perhaps only erroneously tests show one PathElementWithURICS and one IncludeCS
			//System.out.println(ruleName + " 1=> " + semanticObject.eClass().getName());
			Iterable<IEObjectDescription> elements = scope.getElements(target);
			for (IEObjectDescription desc : elements) {
				URI uri = URI.createURI(desc.getName().toString());
				URI baseURI = semanticObject.eResource().getURI();
				URI deresolvedURI = URIUtil.deresolve(uri, baseURI);
				String unconverted = deresolvedURI.toString();
				String converted = helper.convert(unconverted, ruleName);
				if (converted != null) {
					return converted;
				}
			}
		}
		else if (semanticObject instanceof PathElementCS) {
			// UnrestrictedName or UnreservedName
			PathElementCS pathElement = (PathElementCS)semanticObject;
			PathNameCS pathName = pathElement.getOwningPathName();
			int index = pathName.getOwnedPathElements().indexOf(pathElement);
			Element element = pathElement.getReferredElement();
			if ((element != null) && !element.eIsProxy()) {
				Resource csResource = pathElement.eResource();
				assert csResource != null;
				NamedElement namedElement = csResource instanceof BaseCSResource ? ((BaseCSResource)csResource).isPathable(element) : null;
				if (namedElement != null) {
					String name = namedElement.getName();
					if ((index == 0) && (namedElement instanceof org.eclipse.ocl.pivot.Package)) {
						EObject root = EcoreUtil.getRootContainer(semanticObject);
						Resource asResource = null;
						if (root instanceof RootPackageCS) {
							EObject root2 = ((RootPackageCS)root).getPivot();
							asResource = EcoreUtil.getRootContainer(root2).eResource();
						}
						Resource elementResource = namedElement.eResource();
						if ((elementResource != csResource) && (elementResource != asResource)) {
							AliasAnalysis adapter = AliasAnalysis.getAdapter(csResource);
							String alias = adapter.getAlias(namedElement, null);
							if (alias != null) {
								name = alias;
							}
						}
					}
					String converted = helper.convert(name, ruleName);
					if (converted != null) {
						return converted;
					}
				}
				else {
					URI uri;
					EObject eTarget = element.getESObject();
					if (eTarget != null) {
						uri = EcoreUtil.getURI(eTarget);
					}
					else {
						uri = EcoreUtil.getURI(element);
					}
					URI baseURI = semanticObject.eResource().getURI();
					URI deresolvedURI = URIUtil.deresolve(uri, baseURI);
					String unconverted = deresolvedURI.toString();
					String converted = helper.convert(unconverted, ruleName);
					if (converted != null) {
						return converted;
					}
				}
			}
			// Never get here
			//System.out.println(ruleName + " 2=> " + semanticObject.eClass().getName());
		}
		else {
			if (target instanceof org.eclipse.ocl.pivot.Package) {
				EObject semanticRoot = EcoreUtil.getRootContainer(semanticObject);
				if (semanticRoot instanceof RootPackageCS) {
					for (ImportCS csImport : ((RootPackageCS)semanticRoot).getOwnedImports()) {
						Element asElement = csImport.getPivot();
						if  (asElement instanceof Import) {
							Import asImport = (Import)asElement;
							String aliasName = asImport.getName();
							if ((aliasName != null) && (asImport.getImportedNamespace() == target)) {
								return aliasName;
							}
						}
					}
				}
			}
			// Always UnrestrictedName => ReferenceCS
			//System.out.println(ruleName + " 3=> " + semanticObject.eClass().getName());
			Iterable<IEObjectDescription> elements = scope.getElements(target);
			for (IEObjectDescription desc : elements) {
				foundOne = true;
				QualifiedName name = desc.getName();
				if (name.getSegmentCount() > 0) {
					String unconverted = name.getLastSegment();
					String converted = helper.convert(unconverted, ruleName);
					if (converted != null) {
						return converted;
					}
				}
			}
			if (target instanceof Nameable) {			// OCLstdlib MetaclassNameCS
				return ((Nameable)target).getName();
			}
		}
		helper.report(foundOne);
		return null;
	}
}
