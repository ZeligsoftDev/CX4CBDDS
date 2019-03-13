package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DataWriterQoS extends DataReaderWriterQoS {
/**
 * A predicate which returns true if the Object is an
 * instance of DataWriterQoS
 */
static final TypeSelectPredicate<DataWriterQoS> type = 
    new TypeSelectPredicate<DataWriterQoS>(
        "DDS4CCM::QoSProfiles::DataWriterQoS", //$NON-NLS-1$
        DataWriterQoS.class); 
}
