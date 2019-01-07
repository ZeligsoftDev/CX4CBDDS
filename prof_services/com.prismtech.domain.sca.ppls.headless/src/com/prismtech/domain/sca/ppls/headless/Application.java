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

package com.prismtech.domain.sca.ppls.headless;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.commands.GenerateFinalModelCommand;
import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.zeligsoft.domain.sca.generation.base.util.CodeGenerationUtilities;
import com.zeligsoft.domain.sca.headless.HeadlessUtil;

/**
 * PLM Headless
 * 
 * @author mciobanu
 * 
 */
public class Application implements IApplication {

	private String fileExtension = "vpm";
	private IPath workingDirectory = null;
	private String modelPath = "";
	private IPath modelProjectDirectory = null;
	private Map<String, String> argMap;
	private boolean generateXML = false;

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		if (Activator.checkLicense().isOK()) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceDescription desc = workspace.getDescription();
			ResourceSet rset = UMLModeler.getEditingDomain().getResourceSet();
			desc.setAutoBuilding(false);
			workspace.setDescription(desc);
			String[] args = (String[]) context.getArguments().get(
					"application.args"); //$NON-NLS-1$
			argMap = HeadlessUtil.buildArgMap(args);
			workingDirectory = workspace.getRoot().getLocation();
			if (argMap.containsKey("-model")) { //$NON-NLS-1$
				modelPath = argMap.get("-model");
				File f = new File(workingDirectory.append(modelPath).toOSString());
				// Check if the file exists
				if (!f.exists()) {
					System.err.println("Specified " + fileExtension + " model \"" 
							+ modelPath + "\" does not exist");
					displayHelp();
					return false;
				}
				// Check if it is the right file extension
				if (!HeadlessUtil.isFileExtension(f, fileExtension)) {
					System.err.println("Specified model extension\""
							+ modelPath.substring(modelPath.lastIndexOf("."))
							+ "\" is invalid. Expected extension: "
							+ fileExtension + ".");
					displayHelp();
					return false;
				}
				// Create the resource based on the valid path
				Resource resource = ResourceUtil.getResourceSet().getResource(
						URI.createFileURI(f.getPath()), true);
				modelProjectDirectory = new Path(f.getParent());
				if (resource != null) {
					EObject model = resource.getContents().get(0);
					if (model instanceof VPModel) {
						if (argMap.containsKey("-vpmconfiguration")) { //$NON-NLS-1$
							String configurationName = argMap
									.get("-vpmconfiguration");
							String regex = "";
							if (UML2Util.isEmpty(configurationName)) {
								System.err.println("Unspecified configuration");
								displayHelp();
								return false;
							}
							// check if it is a regular expression
							if (configurationName.startsWith("\\")) {
								regex = configurationName.substring(2);
								if (!HeadlessUtil.isValidRegex(regex)) {
								System.err.println("Invalid regular expression:" + regex);
									displayHelp();
									return false;
								}
							}
							if (argMap.containsKey("-xml")) {
								generateXML = true;
							}
							for (Configuration c : ((VPModel) model)
									.getConfigurations()) {
								if (c.getName().equals(configurationName)
										|| (!UML2Util.isEmpty(regex) && Pattern
												.matches(regex, c.getName()))) {
									ICommand command = new GenerateFinalModelCommand(
											UMLModeler.getEditingDomain(),
											Messages.GenerateModelLabel,
											Collections.EMPTY_MAP, null, c);
									try {
									System.out.println("Generating configuration: " + c.getName());
										OperationHistoryFactory
												.getOperationHistory().execute(
														command, null, null);
										if (generateXML == true) {
											if (!c.isGenerateDescriptors()) {
												URI targetModelURI = URI
													.createFileURI(modelProjectDirectory
															.append(c.getName())
																+ ".emx"); //$NON-NLS-1$
												Resource newGenModelResource = rset
														.getResource(
																targetModelURI,
																true);
											System.out.println("Generating XML Descriptors for configuration: " + c.getName());
												CodeGenerationUtilities
														.generateDescriptors((Model) ((Package) newGenModelResource
																.getContents()
																.get(0)));
											}
										}
									} catch (ExecutionException e) {
										System.err
												.println(Messages.GenerateModelError);
										e.printStackTrace();
									}
								}
							}

							return true;
						}
					}
				}
			}
		} else {
			System.err.println(Messages.FeatureNotLicensedWarning);
		}

		displayHelp();
		return false;
	}

	/**
	 * Helper function to print out to the console options of the specific
	 * headless generation implementation based on its file extension type
	 * 
	 */
	private void displayHelp() {
		System.out
				.println("Usage: eclipse -nosplash [-data pathToWorkspace] -application com.prismtech.domain.sca.ppls.PVMGen -model pathToModelFile -vpmconfiguration configurationNameInVPModel");
		System.out
				.println("Example: /opt/IBM/SDP/eclipse -nosplash -data /home/user/IBM/rationalsdp/workspace/ -application com.prismtech.domain.sca.ppls.PVMGen -model CXTutorial_Model_src/CXTutorial_Model.vpm -vpmconfiguration ARM_RELEASE -xml");
		HeadlessUtil.displayHelp(fileExtension);
		System.out.println("\n\tPLM Specific Arguments: \n");
		System.out
				.println("\t\t-vpmconfiguration <name|regex>\tSpecify the name of a configuration in the specified VPModel or use Java regular expressions to specify multiple configurations. Supports Use \\\\ to begin a regular expression. Use \\\\.* for all configurations.");
		System.out
				.println("\t\t-xml\t\t\t\tThe option of forcing the generation of XML descriptors for all the model variants generated from configurations in VPModel specified in -vpmconfiguration");

	}

	@Override
	public void stop() {
	}

}
