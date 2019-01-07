package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TopicQoS extends QoSForEntity {
/**
 * A predicate which returns true if the Object is an
 * instance of TopicQoS
 */
static final TypeSelectPredicate<TopicQoS> type = 
    new TypeSelectPredicate<TopicQoS>(
        "DDS4CCM::QoSProfiles::TopicQoS", //$NON-NLS-1$
        TopicQoS.class); 
}
