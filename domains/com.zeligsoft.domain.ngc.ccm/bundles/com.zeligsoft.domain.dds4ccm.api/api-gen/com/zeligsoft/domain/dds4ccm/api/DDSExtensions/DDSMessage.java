package com.zeligsoft.domain.dds4ccm.api.DDSExtensions;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAStruct;

public interface DDSMessage extends CORBAStruct {
java.util.List<MessageField> getFields();
void addFields(MessageField val);
<T extends MessageField> T addFields(Class<T> typeToCreate, String concept);
MessageField addFields();
/**
 * A predicate which returns true if the Object is an
 * instance of DDSMessage
 */
static final TypeSelectPredicate<DDSMessage> type = 
    new TypeSelectPredicate<DDSMessage>(
        "DDS4CCM::DDSExtensions::DDSMessage", //$NON-NLS-1$
        DDSMessage.class); 
}
