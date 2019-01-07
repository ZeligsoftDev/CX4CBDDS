package com.zeligsoft.base.zdl.staticapi.xtend

import org.eclipse.uml2.uml.Element
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry
import com.zeligsoft.base.zdl.staticapi.core.ZObject
import java.util.List
import java.util.ArrayList

class ZDLStandardLibrary {
		
	/**
	 * Returns the container of the passed UML element. If this container has a ZDL concept, it is
	 * returned wrapped as a ZObject.
	 */
	def public Object zContainer(Element self) {		
    	var Object zContainer = null
    	if(self.eContainer != null) {
        	zContainer = ZDLFactoryRegistry::INSTANCE.create(
            	self.eContainer, typeof(Object));
		}
        if(zContainer == null) {
			zContainer = self.eContainer
		}
		return zContainer     
	}
	
	/**
     * Return passed element wrapped as a ZObject.
     */
    def public ZObject zObject(Element self) {        
        return ZDLFactoryRegistry::INSTANCE.create(self, typeof(ZObject));
    }
	
	/**
	 * Returns a filtered list from the passed UML element list, containing only those elements which
	 * have ZDL concepts, wrapped as ZObjects.
	 */
	def public List<ZObject> zWrapFilteredList(List<? extends Element> elements) {
		var ZObject zWrapper = null
		var List<ZObject> retVal = new ArrayList<ZObject>()
		for( next : elements ) {
			zWrapper = ZDLFactoryRegistry::INSTANCE.create(next, typeof(ZObject));
			if( zWrapper != null ) {
				retVal.add(zWrapper)
			}
		}
		retVal
	}
	
	/**
	 * Given a list of UML elements passed in, returns a new list in which any element having a ZDL
	 * concept is wrapped as a ZObject.
	 */
	def public List<Object> zWrapList(List< ? extends Element> elements	) {
		var List<Object> retVal = new ArrayList<Object>()
		for( next : elements ) {
			var zWrapper = ZDLFactoryRegistry::INSTANCE.create(next, typeof(ZObject));
			if( zWrapper != null ) {
				retVal.add(zWrapper)
			} else {
				retVal.add(next)
			}
		}
		retVal
	}
	
	/**
	 * Given a list that may contain elements which are themselves lists, returns a single flattened list
	 * of all contents.
	 */
	def public List flatten(List initialList) {
		var List retVal = new ArrayList()
		
		for( Object element : initialList ) {
			if( element instanceof List ) {
				retVal.addAll((element as List).flatten)
			} else {
				retVal.add(element)
			}
		}
		retVal
	}
}