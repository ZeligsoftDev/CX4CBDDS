package com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.PublisherSubscriberQoS;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl.QoSForEntityZImpl;


import com.zeligsoft.base.zdl.util.ZDLUtil;
    
public abstract class PublisherSubscriberQoSZImpl
    extends QoSForEntityZImpl implements PublisherSubscriberQoS{
    public PublisherSubscriberQoSZImpl(org.eclipse.emf.ecore.EObject element) {
        super(element);
    }
    
    
}
