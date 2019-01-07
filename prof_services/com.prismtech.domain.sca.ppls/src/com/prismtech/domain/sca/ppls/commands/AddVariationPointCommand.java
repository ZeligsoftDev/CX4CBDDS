package com.prismtech.domain.sca.ppls.commands;

import org.eclipse.emf.ecore.EObject;

import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;

public class AddVariationPointCommand extends AbstractAddVariationPointCommand
{
    public AddVariationPointCommand( EObject eobject )
    {
        super( Messages.CreateVariationPointLabel, PLMNames.VARIATION_POINT, eobject );
    }

    @Override
    protected boolean canElementBeConstrained( EObject eobject )
    {
        return ZDLUtil.isZDLConcept(eobject, SCANames.SCAPORT)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCACOMPONENT_PART)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCANODE_PART)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCAOPERATING_SYSTEM_DEPENDENCY)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCAPROCESSOR_DEPENDENCY)
        	|| ZDLUtil.isZDLConcept(eobject, SCANames.SCACONNECTOR);
    }
}
