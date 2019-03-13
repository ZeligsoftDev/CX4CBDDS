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

import static org.junit.Assert.fail;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.junit.Before;

/**
 * Abstract test framework for the workflow components.
 * 
 * @param <C>
 *            the type of the workflow component being tested
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class AbstractWorkflowComponentTest<C extends WorkflowComponent> {

	protected WorkflowContext ctx;

	protected Issues issues;

	protected ProgressMonitor monitor;

	protected C fixture;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public AbstractWorkflowComponentTest() {
		// Default constructor
	}

	//
	// Test framework methods
	//

	@Before
	public void setUp()
			throws Exception {

		fixture = createFixture();

		ctx = new WorkflowContextDefaultImpl();
		issues = new IssuesImpl();
		monitor = new NullProgressMonitor();
	}

	/**
	 * Implemented by subclasses to create an instance of the fixture component.
	 * 
	 * @return the new fixture
	 */
	protected abstract C createFixture();

	/**
	 * Sets a slot in the workflow context.
	 * 
	 * @param name
	 *            the slot name
	 * @param value
	 *            the slot value
	 */
	protected void setSlot(String name, Object value) {
		ctx.set(name, value);
	}

	/**
	 * Gets a slot value from the workflow context.
	 * 
	 * @param <T>
	 *            the expected type of the slot
	 * @param name
	 *            the slot name to get
	 * @return the slot value, or <code>null</code> if no such slot
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getSlot(String name) {
		return (T) ctx.get(name);
	}

	/**
	 * Sets a property of the workflow component.
	 * 
	 * @param name
	 *            the property name
	 * @param value
	 *            the property value string
	 */
	protected void setProperty(String name, String value) {
		BeanInfo info = getBeanInfo();
		PropertyDescriptor[] properties = info.getPropertyDescriptors();
		for (PropertyDescriptor next : properties) {
			if (name.equals(next.getName())) {
				try {
					Method setter = next.getWriteMethod();
					setter.invoke(fixture, value);
					return;
				} catch (Exception e) {
					fail(String.format(
						"Failed to set component property %s: %s", name, e
							.getLocalizedMessage()));
				}
			}
		}

		fail("Property not found in workflow component: " + name);
	}

	/**
	 * Invokes the <tt>fixture</tt> component and asserts that it recorded no
	 * errors in the <tt>issues</tt>.
	 */
	protected void invokeFixture() {
		try {
			fixture.invoke(ctx, monitor, issues);
		} catch (Exception e) {
			fail("Exception in fixture invocation: " + e.getLocalizedMessage());
		}

		MWEDiagnostic[] errors = issues.getErrors();
		if ((errors != null) && (errors.length > 0)) {
			for (MWEDiagnostic next : errors) {
				System.err.printf("Error: %s\n", next.getMessage());
			}

			fail("Fixture invocation failed with errors (see stderr for details)");
		}
	}

	private BeanInfo getBeanInfo() {
		BeanInfo result = null;

		try {
			result = Introspector.getBeanInfo(fixture.getClass());
		} catch (Exception e) {
			fail("Failed to introspect the workflow component: "
				+ e.getLocalizedMessage());
		}

		return result;
	}
}
