/**
 * Copyright 2018 ADLINK Technology Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zeligsoft.base.zdl.staticapi.xtend;

import com.google.common.base.Objects;
import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

@SuppressWarnings("all")
public class ZDLStandardLibrary {
  /**
   * Returns the container of the passed UML element. If this container has a ZDL concept, it is
   * returned wrapped as a ZObject.
   */
  public Object zContainer(final Element self) {
    Object zContainer = null;
    EObject _eContainer = self.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eContainer_1 = self.eContainer();
      Object _create = ZDLFactoryRegistry.INSTANCE.<Object>create(_eContainer_1, Object.class);
      zContainer = _create;
    }
    boolean _equals = Objects.equal(zContainer, null);
    if (_equals) {
      EObject _eContainer_2 = self.eContainer();
      zContainer = _eContainer_2;
    }
    return zContainer;
  }
  
  /**
   * Return passed element wrapped as a ZObject.
   */
  public ZObject zObject(final Element self) {
    return ZDLFactoryRegistry.INSTANCE.<ZObject>create(self, ZObject.class);
  }
  
  /**
   * Returns a filtered list from the passed UML element list, containing only those elements which
   * have ZDL concepts, wrapped as ZObjects.
   */
  public List<ZObject> zWrapFilteredList(final List<? extends Element> elements) {
    List<ZObject> _xblockexpression = null;
    {
      ZObject zWrapper = null;
      List<ZObject> retVal = new ArrayList<ZObject>();
      for (final Element next : elements) {
        {
          ZObject _create = ZDLFactoryRegistry.INSTANCE.<ZObject>create(next, ZObject.class);
          zWrapper = _create;
          boolean _notEquals = (!Objects.equal(zWrapper, null));
          if (_notEquals) {
            retVal.add(zWrapper);
          }
        }
      }
      _xblockexpression = retVal;
    }
    return _xblockexpression;
  }
  
  /**
   * Given a list of UML elements passed in, returns a new list in which any element having a ZDL
   * concept is wrapped as a ZObject.
   */
  public List<Object> zWrapList(final List<? extends Element> elements) {
    List<Object> _xblockexpression = null;
    {
      List<Object> retVal = new ArrayList<Object>();
      for (final Element next : elements) {
        {
          ZObject zWrapper = ZDLFactoryRegistry.INSTANCE.<ZObject>create(next, ZObject.class);
          boolean _notEquals = (!Objects.equal(zWrapper, null));
          if (_notEquals) {
            retVal.add(zWrapper);
          } else {
            retVal.add(next);
          }
        }
      }
      _xblockexpression = retVal;
    }
    return _xblockexpression;
  }
  
  /**
   * Given a list that may contain elements which are themselves lists, returns a single flattened list
   * of all contents.
   */
  public List flatten(final List initialList) {
    List _xblockexpression = null;
    {
      List retVal = new ArrayList<Object>();
      for (final Object element : initialList) {
        if ((element instanceof List)) {
          List _flatten = this.flatten(((List) element));
          retVal.addAll(_flatten);
        } else {
          retVal.add(element);
        }
      }
      _xblockexpression = retVal;
    }
    return _xblockexpression;
  }
}
