package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ZDLFilterUtil {
  public void findConcepts(final org.eclipse.uml2.uml.Package pkg, final String concept) {
    final Function1<EObject, Boolean> _function = (EObject eobj) -> {
      return Boolean.valueOf(ZDLUtil.isZDLConcept(eobj, concept));
    };
    final Iterable<PackageableElement> conceptElements = IterableExtensions.<PackageableElement>filter(pkg.getPackagedElements(), _function);
    final Function1<EObject, EObject> _function_1 = (EObject eobj) -> {
      return eobj;
    };
    final Iterable<EObject> result = IterableExtensions.<PackageableElement, EObject>map(conceptElements, _function_1);
  }
}
