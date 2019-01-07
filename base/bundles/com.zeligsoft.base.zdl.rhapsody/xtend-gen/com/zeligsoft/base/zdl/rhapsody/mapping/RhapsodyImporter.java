package com.zeligsoft.base.zdl.rhapsody.mapping;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPStereotype;
import com.telelogic.rhapsody.core.RhapsodyAppServer;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RhapsodyImporter {
  public void importElement(final String project, final String elementQName, final String rhapsodyMetaclass, final EObject context) {
    final IRPApplication application = RhapsodyAppServer.createRhapsodyApplication();
    try {
      boolean _notEquals = (!Objects.equal(application, null));
      if (_notEquals) {
        final IRPProject rhapsodyProject = application.openProject(project);
        this.importElement(rhapsodyProject, elementQName, rhapsodyMetaclass, context);
      }
    } finally {
      boolean _notEquals_1 = (!Objects.equal(application, null));
      if (_notEquals_1) {
        application.quit();
      }
    }
  }
  
  public void importElement(final String elementQName, final String rhapsodyMetaclass, final EObject context) {
    final IRPApplication application = RhapsodyAppServer.getActiveRhapsodyApplication();
    try {
      boolean _notEquals = (!Objects.equal(application, null));
      if (_notEquals) {
        final IRPProject rhapsodyProject = application.activeProject();
        this.importElement(rhapsodyProject, elementQName, rhapsodyMetaclass, context);
      }
    } finally {
      boolean _notEquals_1 = (!Objects.equal(application, null));
      if (_notEquals_1) {
        application.quit();
      }
    }
  }
  
  public void importElement(final IRPProject rhapsodyProject, final String elementQName, final String rhapsodyMetaclass, final EObject context) {
    boolean _notEquals = (!Objects.equal(rhapsodyProject, null));
    if (_notEquals) {
      final IRPModelElement element = rhapsodyProject.findElementsByFullName(elementQName, rhapsodyMetaclass);
      boolean _notEquals_1 = (!Objects.equal(element, null));
      if (_notEquals_1) {
        this.map(element, context);
      }
    }
  }
  
  public EObject map(final IRPModelElement self, final EObject context) {
    final IRPCollection stereotypes = self.getStereotypes();
    List _list = stereotypes.toList();
    final Function1<IRPStereotype,Boolean> _function = new Function1<IRPStereotype,Boolean>() {
        public Boolean apply(final IRPStereotype s) {
          boolean _isZDLConcept = RhapsodyImporter.this.isZDLConcept(((IRPStereotype) s));
          return Boolean.valueOf(_isZDLConcept);
        }
      };
    final IRPStereotype zdlStereotype = IterableExtensions.<IRPStereotype>findFirst(_list, _function);
    boolean _notEquals = (!Objects.equal(zdlStereotype, null));
    if (_notEquals) {
      final String zdlConcept = zdlStereotype.getPropertyValueExplicit("CX.DomainModel.DefiningConcept");
      boolean _isNullOrEmpty = Strings.isNullOrEmpty(zdlConcept);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        boolean _notEquals_1 = (!Objects.equal(context, null));
        if (_notEquals_1) {
          final EObject newObject = ZDLUtil.createZDLConcept(context, zdlConcept);
          String _plus = ("Created a new model element of type " + zdlConcept);
          System.out.println(_plus);
          return newObject;
        }
      }
    }
    return null;
  }
  
  public boolean isZDLConcept(final IRPStereotype stereotype) {
    try {
      final String zdlConcept = stereotype.getPropertyValueExplicit("CX.DomainModel.DefiningConcept");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return true;
  }
}
