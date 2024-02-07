/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.mwe.core.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.WorkflowComponentWithID;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.ao.AbstractWorkflowAdvice;
import org.eclipse.emf.mwe.core.config.FeatureComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.Mwe2Bridge;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.internal.core.Workflow;
import org.eclipse.emf.mwe.internal.core.ast.parser.Location;
import org.eclipse.emf.mwe.internal.core.util.ComponentPrinter;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * A composite <tt>WorkflowComponent</tt>.
 * 
 */
public class CompositeComponent implements WorkflowComponentWithID, IWorkflowComponent {

	private static final String COMPONENT_NAME = "Composite component";

	protected static final Logger log = LogManager.getLogger(CompositeComponent.class);

	private final String name;

	private String resource;

	private Location location;

	private Location ownLocation;

	private CompositeComponent container;

	public CompositeComponent(final String name) {
		this.name = name;
	}

	/** All components aggregated by this composite */
	protected List<WorkflowComponent> components = new ArrayList<WorkflowComponent>();

	private String id;

	/**
	 * Returns a list of aggregated components.
	 * 
	 * @return list of components
	 */
	public List<WorkflowComponent> getComponents() {
		return components;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(final String id) {
		this.id = id;
	}

	@Override
	public String getLogMessage() {
		return "CompositeComponent " + (id != null ? id : "");
	}

	/**
	 * Dispatches the invocation to all aggregated components.
	 */
	@Override
	public void invoke(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		internalInvoke(ctx, monitor, issues);
	}

	private void internalInvoke(final WorkflowContext model, final ProgressMonitor monitor, final Issues issues) {
		for (final WorkflowComponent comp : components) {
			if ((monitor != null) && monitor.isCanceled()) {
				return;
			}
			
			if ((!(comp instanceof AbstractWorkflowAdvice))) {
				comp.setContainer(this);
				if (monitor != null) {
					monitor.preTask(comp, model);
				}
				log.info(ComponentPrinter.getString(comp));
				comp.invoke(model, monitor, issues);
				if (monitor != null) {
					monitor.postTask(comp, model);
				}
			}
		}
	}

	@Override
	public void checkConfiguration(final Issues issues) throws ConfigurationException {
		for (final WorkflowComponent comp : components) {
			if (comp instanceof AbstractWorkflowAdvice) {
				final AbstractWorkflowAdvice advice = (AbstractWorkflowAdvice) comp;
				final String adviceTargetID = advice.getAdviceTarget();
				if (adviceTargetID == null) {
					issues.addError(advice, "No 'adviceTarget' given.");
					continue;
				}
				// log.info("Weaving Advice: " +
				// ComponentPrinter.getString(comp));
				final Collection<WorkflowComponent> targetComponents = findComponentByID(adviceTargetID);
				if (targetComponents.size() == 0) {
					issues.addWarning(advice, "No component with ID '" + adviceTargetID + "' found.");
				}
				if (targetComponents.size() > 1) {
					issues.addWarning(advice, "More than on component with ID '" + adviceTargetID + "' found.");
				}
				if (needsToWeave(comp, issues)) {
					for (final WorkflowComponent c : targetComponents) {
						((AbstractWorkflowAdvice) comp).weave(c, issues);
					}
				}
			}
		}
		for (final WorkflowComponent comp : components) {
			if ((!(comp instanceof AbstractWorkflowAdvice))) {
				if (log.isDebugEnabled()) {
					log.debug("Checking configuration of: " + ComponentPrinter.getString(comp));
				}
				comp.checkConfiguration(issues);
			}
		}
	}

	private boolean needsToWeave(final WorkflowComponent comp, final Issues issues) {
		try {
			WorkflowComponent current = comp;
			while (current != null) {
				if (current instanceof WorkflowConditional) {
					final WorkflowConditional cond = (WorkflowConditional) current;
					if (!cond.evaluate()) {
						return false;
					}
				}
				current = current.getContainer();
			}
			return true;
		}
		catch (final ConditionEvaluationException ex) {
			issues.addError(this, ex.getMessage());
			return false;
		}
	}

	private Collection<WorkflowComponent> findComponentByID(final String adviceTargetID) {
		final List<WorkflowComponent> hits = new ArrayList<WorkflowComponent>();
		WorkflowComponent c = this;
		while (c.getContainer() != null) {
			c = c.getContainer();
		}
		((CompositeComponent) c).resolveComponentByID(adviceTargetID, hits);
		return hits;
	}

	private void resolveComponentByID(final String adviceTargetID, final List<WorkflowComponent> hits) {
		for (final WorkflowComponent component : components) {
			if (component instanceof WorkflowComponentWithID) {
				if (adviceTargetID.equals(((WorkflowComponentWithID) component).getId())) {
					hits.add(component);
				}
			}
		}
		for (final WorkflowComponent component : components) {
			if (component instanceof CompositeComponent) {
				((CompositeComponent) component).resolveComponentByID(adviceTargetID, hits);
			}
		}
	}

	/**
	 * Returns the name of the component.
	 * 
	 * @return name of component
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the filename of the workflow.
	 * 
	 * @return the filename
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * Sets the filename of the workflow.
	 * 
	 * @param resource
	 *            the filename
	 */
	public void setResource(final String resource) {
		this.resource = resource;
	}

	/**
	 * Returns the location of the entry in the parent workflow file.
	 * 
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#getLocation()
	 */
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(final Location location) {
		this.location = location;
	}

	/**
	 * Returns the location of the start and closing tags in the actual workflow
	 * file.
	 * 
	 * @return the location
	 */
	public Location getOwnLocation() {
		return ownLocation;
	}

	/**
	 * Sets the location of the start and closing tags in the actual workflow
	 * file.
	 * 
	 * @param endLocation
	 *            the location
	 */
	// locations are set from VisitorCreator by reflection
	public void setOwnLocation(final Location endLocation) {
		this.ownLocation = endLocation;
	}

	/**
	 * Adds a bean.
	 * 
	 * @param obj
	 *            the bean
	 */
	public void addBean(final Object obj) {
		// noop
	}

	/**
	 * Sets the aggregated components of this composite.
	 * 
	 * @param component
	 *            Components to add.
	 */
	public void addComponent(final WorkflowComponent component) {
		components.add(component);
		component.setContainer(this);
	}

	/**
	 * Sets the aggregated components of this composite.
	 * 
	 * @param cartridge
	 *            cartridge to add.
	 */
	public void addCartridge(final Workflow cartridge) {
		components.add(cartridge);
		cartridge.setContainer(this);
	}

	/**
	 * adds a conditionalcompositecomponent to the list of components
	 * 
	 * @param comp
	 *            the conditional component
	 */
	public void addIf(final IfComponent comp) {
		addComponent(comp);
	}

	/**
	 * adds a feature components to the list of components
	 * 
	 * @param comp
	 *            the feature component
	 */
	public void addFeature(final FeatureComponent comp) {
		addComponent(comp);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#getContainer()
	 */
	@Override
	public CompositeComponent getContainer() {
		return container;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#setContainer(org.eclipse.emf.mwe.core.container.CompositeComponent)
	 */
	@Override
	public void setContainer(final CompositeComponent container) {
		this.container = container;
	}

	/**
	 * Adds a workflow component.
	 * 
	 * @param comp
	 *            the component
	 */
	public void put(final String name, final WorkflowComponent comp) {
		addComponent(comp);
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

	private Mwe2Bridge bridge;
	
	protected Mwe2Bridge getBridge() {
		if (bridge == null)
			bridge = new Mwe2Bridge(this);
		return bridge;
	}
	
	@Override
	public void preInvoke() {
		getBridge().preInvoke();
	}
	
	@Override
	public void invoke(final IWorkflowContext ctx) {
		getBridge().invoke(ctx);
	}

	@Override
	public void postInvoke() {
		getBridge().postInvoke();
	}
}
