package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface PublisherSubscriberQoS extends QoSForEntity {
/**
 * A predicate which returns true if the Object is an
 * instance of PublisherSubscriberQoS
 */
static final TypeSelectPredicate<PublisherSubscriberQoS> type = 
    new TypeSelectPredicate<PublisherSubscriberQoS>(
        "DDS4CCM::QoSProfiles::PublisherSubscriberQoS", //$NON-NLS-1$
        PublisherSubscriberQoS.class); 
}
