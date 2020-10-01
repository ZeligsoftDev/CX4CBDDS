package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

public class CreateCXModelFromUMLModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = service.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();

			IFile file = (IFile) Platform.getAdapterManager().getAdapter(selected, IFile.class);
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
				String modelType = "atcd";
				while (reader.ready()) {
					String line = reader.readLine();
					if (line.contains("dds4ccm:DDS4CCMModel")) {
						if (line.contains("modelType=\"AXCIOMA\"")) {
							modelType = "axcioma";
						}
						break;
					}
				}
				String modelName = file.getFullPath().removeFileExtension().lastSegment();
				IContainer container = file.getParent();
				IFile diFile;
				if (container instanceof IProject) {
					diFile = ((IProject) container).getFile(modelName + ".di");
				} else {
					diFile = ((IFolder) container).getFile(modelName + ".di");
				}

				if (!diFile.exists()) {
					String diContents = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
							+ "<architecture:ArchitectureDescription xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:architecture=\"http://www.eclipse.org/papyrus/infra/core/architecture\" contextId=\"com.zeligsoft.domain.cbdds."
							+ modelType + ".architecture\"/>\r\n" + "";
					byte[] bytes = diContents.getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					diFile.create(source, IResource.FORCE, null);
				}

				IFile noFile;
				if (container instanceof IProject) {
					noFile = ((IProject) container).getFile(modelName + ".notation");
				} else {
					noFile = ((IFolder) container).getFile(modelName + ".notation");
				}
				if (!noFile.exists()) {
					String noContents = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
							+ "<xmi:XMI xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\"/>\r\n" + "";
					byte[] bytes = noContents.getBytes();
					InputStream source = new ByteArrayInputStream(bytes);
					noFile.create(source, IResource.FORCE, null);
				}

				// Replace CORBA to CX prefix
				migrateCORBAToCX(file);

			} catch (CoreException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * Open file and replace CORBA prefix with CX
	 * 
	 * @param file
	 */
	private void migrateCORBAToCX(IFile file) {

		try {
			boolean found = false;
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			StringBuffer outBuffer = new StringBuffer();
			while (reader.ready()) {
				String line = reader.readLine();
				String outLine = line;
				
				// Replace CORBA to CX string
				int startIndex = outLine.indexOf("dds4ccm:CORBA");
				if (startIndex > 0) {
					found = true;
					outLine = outLine.replaceFirst("dds4ccm:CORBA", "dds4ccm:CX");
				}
				// Replace CCM_LIBRARY to DDS4CCM_LIBRARY
				startIndex = outLine.indexOf("/CCM_LIBRARIES");
				if (startIndex > 0) {
					found = true;
					outLine = outLine.replaceFirst("/CCM_LIBRARIES", "/DDS4CCM_LIBRARIES");
				}				
				
				outBuffer.append(outLine).append(System.lineSeparator());
			}
			reader.close();

			if (found) {
				// produce output if CORBA keyword is found
				String outContents = outBuffer.toString();
				byte[] bytes = outContents.getBytes();
				InputStream source = new ByteArrayInputStream(bytes);
				file.setContents(source, IResource.FORCE, new NullProgressMonitor());
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
