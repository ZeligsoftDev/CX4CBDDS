/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * This type is used to support assignment of multiple stereotypes to a
 * model element. Methods from the superclass are overridden to evaluate
 * them for each wrapped stereotype.
 * @author karsten.thoms@itemis.de - maintainance
 * @author jochen.schmich@fiducia.de - Bug#388373
 * @author aarnold - type introspection
 * @author pschonbac - maintainance
 * @author bkolb - initial
 * @since oAW 4.2
 */
public final class MultipleStereotypeType extends StereotypeType {
	List<StereotypeType> stereotypes;

	public MultipleStereotypeType(TypeSystem typeSystem, List<StereotypeType> stereotypes) {
		this(typeSystem, stereotypes, null);
	}

	public MultipleStereotypeType(TypeSystem typeSystem, List<StereotypeType> stereotypes, Type umlType) {
		super(typeSystem, computeName(stereotypes), null, umlType);
		this.stereotypes = stereotypes;
	}

	/** Needed to be called within constructor */
	private static String computeName (List<StereotypeType> stereotypes) {
		String result = stereotypes.get(0).getName();
		for (int i=1; i<stereotypes.size(); i++) {
			result += ","+stereotypes.get(i).getName();
		}
		return result;
	}

	@Override
	public Feature[] getContributedFeatures() {
		List<Feature> features = new ArrayList<Feature>();
		for (StereotypeType st : stereotypes) {
			features.addAll(Arrays.asList(st.getContributedFeatures()));
		}
		return features.toArray(new Feature[stereotypes.size()]);
	}

	@Override
	public Set<Type> getSuperTypes() {
		Set<Type> superTypes = new HashSet<Type>();
		for (StereotypeType st : stereotypes) {
			superTypes.addAll(st.getSuperTypes());
		}
		return superTypes;
	}

	@Override
	public boolean isInstance(Object o) {
		for (StereotypeType st : stereotypes) {
			if (st.isInstance(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean isCompatible(Type t) {
		for (StereotypeType st : stereotypes) {
			// umlType is not relevant thus should not be considered here - false is passed in this case
			if (st.equals(t, false)) {
				return true;
			}
		}
		return false;
	}

	public List<StereotypeType> getStereotypes () {
		return stereotypes;
	}

}
