package com.zeligsoft.domain.idl3plus.api.Generics;

 import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ModuleBinding extends ZObject {
TemplateSignature getTemplate();
void setTemplate(TemplateSignature val)
;
java.util.List<ParameterBinding> getParameterBinding();
void addParameterBinding(ParameterBinding val);
<T extends ParameterBinding> T addParameterBinding(Class<T> typeToCreate, String concept);
ParameterBinding addParameterBinding();
ModuleInstantiation getBoundElement();
void setBoundElement(ModuleInstantiation val)
;
org.eclipse.uml2.uml.TemplateBinding asTemplateBinding();
/**
 * A predicate which returns true if the Object is an
 * instance of ModuleBinding
 */
static final TypeSelectPredicate<ModuleBinding> type = 
    new TypeSelectPredicate<ModuleBinding>(
        "IDL3Plus::Generics::ModuleBinding", //$NON-NLS-1$
        ModuleBinding.class); 
}
