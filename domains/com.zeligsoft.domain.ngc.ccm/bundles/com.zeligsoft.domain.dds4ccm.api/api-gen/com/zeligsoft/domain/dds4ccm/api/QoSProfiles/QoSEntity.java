package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface QoSEntity extends NamedElement {
QoSForEntity getType();
void setType(QoSForEntity val)
;
org.eclipse.uml2.uml.Property asProperty();
/**
 * A predicate which returns true if the Object is an
 * instance of QoSEntity
 */
static final TypeSelectPredicate<QoSEntity> type = 
    new TypeSelectPredicate<QoSEntity>(
        "DDS4CCM::QoSProfiles::QoSEntity", //$NON-NLS-1$
        QoSEntity.class); 
}
