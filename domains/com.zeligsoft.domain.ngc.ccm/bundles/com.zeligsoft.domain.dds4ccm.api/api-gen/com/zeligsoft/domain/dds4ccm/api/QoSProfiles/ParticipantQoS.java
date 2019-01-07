package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ParticipantQoS extends QoSForEntity {
/**
 * A predicate which returns true if the Object is an
 * instance of ParticipantQoS
 */
static final TypeSelectPredicate<ParticipantQoS> type = 
    new TypeSelectPredicate<ParticipantQoS>(
        "DDS4CCM::QoSProfiles::ParticipantQoS", //$NON-NLS-1$
        ParticipantQoS.class); 
}
