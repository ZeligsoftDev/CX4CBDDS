package com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.DataReaderWriterQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl.QoSForEntityZImpl;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class DataReaderWriterQoSZImpl
    extends QoSForEntityZImpl implements DataReaderWriterQoS{
    public DataReaderWriterQoSZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
}
