package com.zeligsoft.domain.zml.api.ZML_Component;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface WorkerFunctionIdentifiable extends ZObject {
String getUuid();
void setUuid(String val)
;
/**
 * A predicate which returns true if the Object is an
 * instance of WorkerFunctionIdentifiable
 */
static final TypeSelectPredicate<WorkerFunctionIdentifiable> type = 
    new TypeSelectPredicate<WorkerFunctionIdentifiable>(
        "ZMLMM::ZML_Component::WorkerFunctionIdentifiable", //$NON-NLS-1$
        WorkerFunctionIdentifiable.class); 
}
