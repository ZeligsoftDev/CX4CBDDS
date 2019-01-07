package com.prismtech.domain.sca.ppls.ui.decorators;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.uml2.uml.Model;

import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.prismtech.domain.sca.ppls.utils.PLMUtil;
import com.zeligsoft.base.ui.utils.OverlayImageDescriptor;

public class GeneratedModelDecorator extends LabelProvider implements
		ILabelDecorator {

	private static final String OVERLAY_IMAGE_PATH = "/icons/obj16/GeneratedModel.gif"; //$NON-NLS-1$

	private static ImageDescriptor overlayImageDesc = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, OVERLAY_IMAGE_PATH);

	private static Image overlayedIcon = null;
	
	public static GeneratedModelDecorator getSourceModelDecorator() {
		IDecoratorManager decoratorManager = Activator.getDefault()
				.getWorkbench().getDecoratorManager();
		if (decoratorManager
				.getEnabled("com.prismtech.domain.sca.ppls.ui.decorators.GeneratedModelDecorator")) { //$NON-NLS-1$
			return (GeneratedModelDecorator) decoratorManager
					.getLabelDecorator("com.prismtech.domain.sca.ppls.ui.decorators.GeneratedModelDecorator"); //$NON-NLS-1$
		}
		return null;
	}
	
	@Override
	public Image decorateImage(Image image, Object element) {
		if(element instanceof IAdaptable){
			EObject eo = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			if(eo instanceof Model){
				if(!PLMUtil.isPLMCapabilityEnabled((Model)eo) && PLMUtil.getAnnotation((Model)eo, PLMNames.MODEL_ANNOTATION) != null ){
					if (overlayedIcon == null) {
						OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
								image, overlayImageDesc);
						overlayImageDescriptor
								.setOverlayPosition(PositionConstants.NORTH_EAST);
						overlayedIcon = overlayImageDescriptor.createImage();	
						
					}					
					return overlayedIcon;
				}									
			}
		}
		
		return image;
	}

	@Override
	public String decorateText(String text, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void refresh() {

		final GeneratedModelDecorator decorator = getSourceModelDecorator();
		if (decorator == null) {
			return;
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					fireLabelProviderChanged(new LabelProviderChangedEvent(
							decorator));
				}
			});
		}
	}
}
