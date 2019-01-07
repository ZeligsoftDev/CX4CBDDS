package com.prismtech.domain.sca.ppls.commands;

import org.eclipse.emf.ecore.EObject;

import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;

public class AddVariationPointWithSettingsCommand extends AbstractAddVariationPointCommand
{
    public AddVariationPointWithSettingsCommand( EObject eobject )
    {
        super( Messages.CreateVariationPointWithSettingsLabel, PLMNames.VARIATION_POINT_WITH_SETTINGS, eobject );
    }

    @Override
    protected boolean canElementBeConstrained( EObject eobject )
    {
        return ZDLUtil.isZDLConcept(eobject, SCANames.SCAPLATFORM_ELEMENT_PART)
            || ZDLUtil.isZDLConcept(eobject, SCANames.PROPERTY_PROVIDER)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCAASSEMBLY)
            || ZDLUtil.isZDLConcept(eobject, SCANames.SCAFREE_STANDING_PORT);
    }
}
