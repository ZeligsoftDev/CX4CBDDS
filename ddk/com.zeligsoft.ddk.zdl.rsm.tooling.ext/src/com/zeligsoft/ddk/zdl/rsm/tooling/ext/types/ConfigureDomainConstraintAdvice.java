/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.rsm.tooling.ext.types;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.ddk.zdl.rsm.tooling.ext.l10n.Messages;

/**
 * <p>
 * Advice to configure certain routine meta-data on a <tt>DomainConstraint</tt>
 * the first time that its name is changed by the user. The meta-data affected
 * are those that support reasonable default values based on the constraint's
 * name:
 * </p>
 * <ul>
 * <li>Constraint ID</li>
 * <li>Localization key for Constraint Description</li>
 * <li>Localization key for Constraint Message</li>
 * </ul>
 * <p>
 * These properties are only modified if they are blank.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ConfigureDomainConstraintAdvice
		extends TriggerListener {

	/**
	 * Singleton instance of the advice trigger listener.
	 */
	public static final ConfigureDomainConstraintAdvice INSTANCE = new ConfigureDomainConstraintAdvice();

	/**
	 * Initializes me.
	 */
	public ConfigureDomainConstraintAdvice() {
		super(NotificationFilter.createFeatureFilter(Constraint.class,
			UMLPackage.NAMED_ELEMENT__NAME));
	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain,
			Notification notification) {

		Constraint constraint = (Constraint) notification.getNotifier();
		if (ZDLUtil.isZDLConcept(constraint, ZDLNames.DOMAIN_CONSTRAINT)) {
			String newName = (String) notification.getNewValue();
			String oldName = (String) notification.getOldValue();

			// don't process the initial setting of the name by RSM
			if (!UML2Util.isEmpty(oldName) && !UML2Util.isEmpty(newName)) {
				return new SetDefaultMetadataCommand(domain,
					Messages.ConfigureDomainConstraintAdvice_label, constraint);
			}
		}

		return null;
	}

	/**
	 * A command that encapsulates the setting of the default constraint
	 * meta-data that this advice configures.
	 * 
	 * @author Christian W. Damus (Zeligsoft)
	 */
	private static class SetDefaultMetadataCommand
			extends RecordingCommand {

		private Constraint constraint;

		/**
		 * Initializes me with the constraint that I configure.
		 * 
		 * @param domain
		 *            the editing domain in which I execute
		 * @param label
		 *            my localized label
		 * @param constraint
		 *            the constraint that I configure
		 */
		SetDefaultMetadataCommand(TransactionalEditingDomain domain,
				String label, Constraint constraint) {
			super(domain, label, null);

			this.constraint = constraint;
		}

		@Override
		protected void doExecute() {
			// configure the default ID, if one is not already specified
			String id = (String) ZDLUtil.getValue(constraint,
				ZDLNames.DOMAIN_CONSTRAINT, ZDLNames.DOMAIN_CONSTRAINT__ID);
			if (UML2Util.isEmpty(id)) {
				StringBuilder buf = new StringBuilder();
				buf.append(getProjectName(constraint)).append('.');
				buf.append(
					UML2Util.getValidJavaIdentifier(constraint.getNamespace()
						.getName())).append('.');
				buf.append(UML2Util
					.getValidJavaIdentifier(constraint.getName()));
				ZDLUtil.setValue(constraint, ZDLNames.DOMAIN_CONSTRAINT,
					ZDLNames.DOMAIN_CONSTRAINT__ID, buf.toString());
			}

			// compute the Java-fied qualified name of the constraint as the
			// UML2 API does for localized name keys in model localization. Use
			// it to create default localization of the message and description
			// of a constraint, but only if there is a qname that we can use
			String cleanConstraintQName = constraint.getQualifiedName();
			if (cleanConstraintQName != null) {
				cleanConstraintQName = UML2Util
					.getValidJavaIdentifier(cleanConstraintQName.replace(':',
						'_'));

				// compute and set the default constraint message, if necessary
				String message = (String) ZDLUtil.getValue(constraint,
					ZDLNames.DOMAIN_CONSTRAINT,
					ZDLNames.DOMAIN_CONSTRAINT__MESSAGE);
				if (UML2Util.isEmpty(message)) {
					StringBuilder buf = new StringBuilder();
					buf.append('%');
					buf
						.append(Messages.ConfigureDomainConstraintAdvice_mesgPrefix);
					buf.append(cleanConstraintQName);
					ZDLUtil.setValue(constraint, ZDLNames.DOMAIN_CONSTRAINT,
						ZDLNames.DOMAIN_CONSTRAINT__MESSAGE, buf.toString());
				}

				// compute and set the default constraint description, if
				// necessary
				if (!constraint.getOwnedComments().isEmpty()) {
					Comment comment = constraint.getOwnedComments().get(0);
					if (UML2Util.isEmpty(comment.getBody())) {
						StringBuilder buf = new StringBuilder();
						buf.append('%');
						buf
							.append(Messages.ConfigureDomainConstraintAdvice_descPrefix);
						buf.append(cleanConstraintQName);
						comment.setBody(buf.toString());
					}
				}
			}
		}
	}

	/**
	 * Gets the name of the project in which the specified object is defined,
	 * otherwise a reasonable default name.
	 * 
	 * @param eObject
	 *            an object in a workspace project
	 * @return the workspace project name, or a default if no project could be
	 *         determined
	 */
	private static String getProjectName(EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null) {
			IFile file = WorkspaceSynchronizer.getFile(res);
			if (file != null) {
				return file.getProject().getName();
			}
		}

		return Messages.ConfigureDomainConstraintAdvice_dfltProject;
	}
}
