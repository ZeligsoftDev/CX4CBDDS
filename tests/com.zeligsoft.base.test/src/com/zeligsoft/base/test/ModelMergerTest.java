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
 *
 */
package com.zeligsoft.base.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.util.ModelMerger;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;

/**
 * Tests for the {@link ModelMerger} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ModelMergerTest {

	ModelMerger<EObject, IHierarchicalKey> merger;

	EPackage source;

	EPackage target;

	/**
	 * @param name
	 */
	public ModelMergerTest() {
		// Default constructor
	}

	/**
	 * Tests that merge aligns the ordering of ordered containment references.
	 */
	@Test
	public void test_mergeOrderedContainment() {
		// re-order classes in the source
		EClassifier a = source.getEClassifier("A");
		EClassifier d = source.getEClassifier("D");
		source.getEClassifiers().move(3, a);
		source.getEClassifiers().move(0, d);

		merger.merge(source, target);

		List<String> names = new java.util.ArrayList<String>(5);
		for (EClassifier next : target.getEClassifiers()) {
			names.add(next.getName());
		}

		assertEquals(Arrays.asList("D", "B", "C", "A", "E"), names);
	}

	/**
	 * Tests that merge aligns the ordering of ordered features that are not
	 * containment references.
	 */
	@Test
	public void test_mergeOrderedNonContainment() {
		// re-order eKeys in the source
		EReference e1 = (EReference) ((EClass) source.getEClassifier("E"))
			.getEStructuralFeature("b");
		EAttribute b1 = (EAttribute) ((EClass) source.getEClassifier("B"))
			.getEStructuralFeature("b1");
		EAttribute b3 = (EAttribute) b1.getEContainingClass()
			.getEStructuralFeature("b3");
		e1.getEKeys().move(2, b1);
		e1.getEKeys().move(0, b3);

		merger.merge(source, target);

		// get the target version of e1
		e1 = (EReference) ((EClass) target.getEClassifier("E"))
			.getEStructuralFeature("b");

		List<String> names = new java.util.ArrayList<String>(5);
		for (EStructuralFeature next : e1.getEKeys()) {
			names.add(next.getName());
		}

		assertEquals(Arrays.asList("b3", "b2", "b1", "b4"), names);
	}

	//
	// Test framework methods
	//

	@Before
	public void setUp()
			throws Exception {

		merger = createMerger();

		source = EcoreFactory.eINSTANCE.createEPackage();
		source.setName("foo");

		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("A");
		source.getEClassifiers().add(a);

		EClass b = EcoreFactory.eINSTANCE.createEClass();
		b.setName("B");
		source.getEClassifiers().add(b);

		EAttribute b1 = EcoreFactory.eINSTANCE.createEAttribute();
		b1.setName("b1");
		b1.setEType(EcorePackage.Literals.ESTRING);
		b.getEStructuralFeatures().add(b1);

		EAttribute b2 = EcoreFactory.eINSTANCE.createEAttribute();
		b2.setName("b2");
		b2.setEType(EcorePackage.Literals.EINT);
		b.getEStructuralFeatures().add(b2);

		EAttribute b3 = EcoreFactory.eINSTANCE.createEAttribute();
		b3.setName("b3");
		b3.setEType(EcorePackage.Literals.ESTRING);
		b.getEStructuralFeatures().add(b3);

		EAttribute b4 = EcoreFactory.eINSTANCE.createEAttribute();
		b4.setName("b4");
		b4.setEType(EcorePackage.Literals.EINT);
		b.getEStructuralFeatures().add(b4);

		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName("C");
		source.getEClassifiers().add(c);

		EClass d = EcoreFactory.eINSTANCE.createEClass();
		d.setName("D");
		source.getEClassifiers().add(d);

		EClass e = EcoreFactory.eINSTANCE.createEClass();
		e.setName("E");
		source.getEClassifiers().add(e);

		EReference e1 = EcoreFactory.eINSTANCE.createEReference();
		e1.setName("b");
		e1.setEType(b);
		e.getEStructuralFeatures().add(e1);

		e1.getEKeys().add(b1);
		e1.getEKeys().add(b2);
		e1.getEKeys().add(b3);
		e1.getEKeys().add(b4);

		// clone
		target = EcoreUtil.copy(source);
	}

	protected ModelMerger<EObject, IHierarchicalKey> createMerger() {

		return new ModelMerger<EObject, IHierarchicalKey>() {

			@Override
			protected boolean isMergeableFeature(EObject owner,
					EStructuralFeature feature) {

				return (feature.getEType() != EcorePackage.Literals.EGENERIC_TYPE)
					&& super.isMergeableFeature(owner, feature);
			}

			@Override
			protected IKeyExtractor<EObject, IHierarchicalKey> createKeyExtractor() {
				return new AbstractHierarchicalKeyExtractor<EObject, IHierarchicalKey>() {

					@Override
					protected IHierarchicalKey createKey(EObject element) {
						class MyKey
								extends AbstractHierarchicalKey<MyKey> {

							String name;

							MyKey(EObject element) {
								super(element);

								name = (element instanceof ENamedElement)
									? ((ENamedElement) element).getName()
									: "<" + element.eClass().getName() + ">";
							}

							@Override
							protected int keyHash() {
								return (name == null)
									? 0
									: name.hashCode();
							}

							@Override
							protected boolean keyEquals(MyKey other) {
								return UML2Util.safeEquals(name, other.name);
							}
						}

						return new MyKey(element);
					}
				};
			}
		};
	}
}
