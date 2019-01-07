package com.zeligsoft.domain.dds4ccm.rhapsody.util;

import com.google.common.base.Objects;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPStereotype;
import com.zeligsoft.domain.dds4ccm.rhapsody.util.CXRhapsodyConstants;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RhapsodyZDLUtil {
  public List getAllZdlConcept(final IRPModelElement self) {
    IRPCollection _stereotypes = self.getStereotypes();
    List _list = _stereotypes.toList();
    for (final Object o : _list) {
      {
        final IRPStereotype st = ((IRPStereotype) o);
        try {
          final String value = st.getPropertyValueExplicit(CXRhapsodyConstants.ZDL_CONCEPT_PROPERTY);
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            final String[] concepts = value.split(",");
            return IterableExtensions.<String>toList(((Iterable<? extends String>)Conversions.doWrapArray(concepts)));
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            return Collections.EMPTY_LIST;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return Collections.EMPTY_LIST;
  }
  
  public String zdlConcept(final IRPModelElement self) {
    final List concepts = this.getAllZdlConcept(self);
    int _size = concepts.size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      Object _get = concepts.get(0);
      return _get.toString();
    }
    return "";
  }
  
  public IRPStereotype zdlStereotype(final IRPModelElement self, final String concept) {
    IRPCollection _stereotypes = self.getStereotypes();
    final List stereotypes = _stereotypes.toList();
    final Function1<IRPStereotype,Boolean> _function = new Function1<IRPStereotype,Boolean>() {
        public Boolean apply(final IRPStereotype s) {
          boolean _isZDLConcept = RhapsodyZDLUtil.this.isZDLConcept(((IRPStereotype) s), concept);
          return Boolean.valueOf(_isZDLConcept);
        }
      };
    return IterableExtensions.<IRPStereotype>findFirst(stereotypes, _function);
  }
  
  public boolean isZDLConcept(final IRPModelElement self, final String concept) {
    final List concepts = this.getAllZdlConcept(self);
    for (final Object aConcept : concepts) {
      String _string = aConcept.toString();
      boolean _equals = concept.equals(_string);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
}
