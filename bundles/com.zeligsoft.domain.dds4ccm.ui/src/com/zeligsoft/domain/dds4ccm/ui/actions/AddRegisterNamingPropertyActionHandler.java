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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Relationship;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Refactoring action to add RegisterNaming property to components.
 * 
 * @author smcfee
 *
 */
public class AddRegisterNamingPropertyActionHandler 
	extends AbstractHandler {

		private int repairedReferenceCount = 0;

		/**
		 * Internal command used to perform the migration.
		 * 
		 * @author smcfee
		 *
		 */
		private class AddRegisterNamingPropertyCommand extends
				RecordingCommand {

			private EObject refactorObject = null;
			
			/**
			 * Constructor
			 * 
			 * @param modelToMigrate
			 * @param label
			 */
			public AddRegisterNamingPropertyCommand(EObject modelToMigrate, String label) {

				super(TransactionUtil.getEditingDomain(modelToMigrate), label);
				
				this.refactorObject = modelToMigrate;

			}

			@Override
			protected void doExecute() {
				
				List<Class> components = new ArrayList<Class>();
				
				if( ZDLUtil.isZDLConcept(refactorObject, CCMNames.CCMCOMPONENT)) {
					components.add((Component)refactorObject);
				} else if( ZDLUtil.isZDLConcept(refactorObject, CCMNames.HOME)) {
					components.add((Class)refactorObject);
				} else if( ZDLUtil.isZDLConcept(refactorObject, DDS4CCMNames.DDS4_CCMMODEL)) {
					
					for (TreeIterator<?> iter = EcoreUtil.getAllContents(refactorObject.eResource().getContents()); iter.hasNext();) {
						
						Object next = iter.next();
						
						if( next instanceof Component) {
							if( ZDLUtil.isZDLConcept((Component)next, CCMNames.CCMCOMPONENT)) {
								boolean b_add = true;
								Component comp = (Component)next;
								for( Relationship r : comp.getRelationships()) {
									if( r instanceof Generalization ) {
										Generalization g = (Generalization)r;
										if( g.getSpecific() != comp ) {
											if( ZDLUtil.isZDLConcept(g.getSpecific(), CCMNames.ASSEMBLY_IMPLEMENTATION)) {
												b_add = false;
											}
										}
									}
								}
								if( b_add ) {
									components.add((Component)next);
								}
							}
						} else if( next instanceof Class ) {
							if( ZDLUtil.isZDLConcept((EObject)next, CCMNames.HOME)) {
								components.add((org.eclipse.uml2.uml.Class)next);
							}
						}
					}
				}
				
				for( org.eclipse.uml2.uml.Class zdlClass : components ) {
					if( DDS4CCMUtil.addRegisterNamingProperty(zdlClass)) {
						repairedReferenceCount++;
					}
				}
			}

			@Override
			public boolean canExecute() {
				return (refactorObject != null);
			}
		}

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			repairedReferenceCount = 0;

			EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
			
			if( selObject != null && 
				ZDLUtil.isZDLConcept(selObject, DDS4CCMNames.DDS4_CCMMODEL) ||
				ZDLUtil.isZDLConcept(selObject, CCMNames.CCMCOMPONENT) ||
				ZDLUtil.isZDLConcept(selObject, CCMNames.HOME)) {
			
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selObject);
				Command migrationCommand = new AddRegisterNamingPropertyCommand(
						selObject,
						Messages.AddRegisterNaming_DialogTitle);
				
				if(migrationCommand.canExecute()) {
					domain.getCommandStack().execute(migrationCommand);
				}else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.Migrate_Error, "Migration Failed");
					return null;
				}
			}
			
			if( repairedReferenceCount > 0 ) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						Messages.AddRegisterNaming_DialogTitle,
						Messages.Migrate_OK);
			} else {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						Messages.AddRegisterNaming_DialogTitle,
						Messages.Migrate_Noop);
			}

			return null;
		}
}
