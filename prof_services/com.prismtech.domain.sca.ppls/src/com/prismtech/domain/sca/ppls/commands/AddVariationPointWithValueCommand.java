package com.prismtech.domain.sca.ppls.commands;

import org.eclipse.emf.ecore.EObject;

import com.prismtech.domain.sca.ppls.l10n.Messages;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;

public class AddVariationPointWithValueCommand extends AbstractAddVariationPointCommand
{
    public AddVariationPointWithValueCommand( EObject eobject )
    {
        super( Messages.CreateVariationPointLabel, PLMNames.VARIATION_POINT_WITH_VALUE, eobject );
    }

    @Override
    protected boolean canElementBeConstrained( EObject eobject )
    {
        return ZDLUtil.isZDLConcept(eobject, SCANames.SCAPROPERTY);
    }
}
