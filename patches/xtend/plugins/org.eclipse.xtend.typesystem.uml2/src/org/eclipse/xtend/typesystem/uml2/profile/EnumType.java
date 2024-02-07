/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.typesystem.uml2.profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

/**
 * Represents an enumeration within a profile.
 * @since 4.1
 */
public class EnumType extends AbstractTypeImpl {
	/** The Enumeration represented by this. */
    private Enumeration enumeration;

    public EnumType(TypeSystem ts, String name, Enumeration en) {
        super(ts, name);
        this.enumeration = en;
    }

    /**
     * An enumeration features its literals. Literals are represented by a {@link org.eclipse.internal.xtend.type.StaticProperty}.
     */
    @Override
    public Feature[] getContributedFeatures() {
        List<Feature> result = new ArrayList<Feature>();
        List<EnumerationLiteral> l = enumeration.getOwnedLiterals();
        // Create a StaticProperty for each EnumerationLiteral in the Enumeration
        for (Iterator<EnumerationLiteral> iter = l.iterator(); iter.hasNext();) {
            final EnumerationLiteral el = iter.next();
            result.add(new StaticPropertyImpl(this, el.getName(), this) {
                public Object get() {
                    return el;
                }
            });
        }
        // Add a property 'name' which resolves the literal name
        result.add(new PropertyImpl(this, "name", getTypeSystem().getStringType()) {
			public Object get(Object target) {
				if (target==null) {
					return null;
				}
				EObject obj = (EObject) target;
				return obj.eGet(obj.eClass().getEStructuralFeature("name"));
			}

			@Override
			public String getDocumentation() {
				return "Retrieves the name of the enumeration literal.";
			}
			
        });
        return result.toArray(new Feature[result.size()]);
    }

    /**
     * For enumerations the behaviour of <tt>isInstance()</tt> is slightly different. Instances can only be instances of {@link EnumerationLiteral}.
     * A literal is of this instance if the referenced Enumeration is the same as the Enumeration represented by this type.
     */
    public boolean isInstance(Object o) {
        return (o instanceof EnumerationLiteral) && ((EnumerationLiteral) o).getEnumeration().equals(enumeration);
    }

    /** Enums cannot be instantiated, thus an {@link UnsupportedOperationException} is thrown. */
    public Object newInstance() {
        throw new UnsupportedOperationException();
    }
    
    public Enumeration getEnumeration () {
    	return enumeration;
    }
    
}
