package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaEnumerationGenerator {
  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;
  
  protected CharSequence _compileEnumeration(final GenDomainEnum element, final String pkg) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package �element.block.interfaceJavaPackage�;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("�element.generateEnumerationImports�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* An enumeration for �element.domainElement.qualifiedName�");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author ZDL API Generator");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public enum �UML2Util::getValidJavaIdentifier(element.name)� {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�FOR literal : element.literals SEPARATOR \",\\n\"�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("�FOR comment : literal.domainElement.ownedComments�");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* �comment.body�");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("*");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�literal.name.toUpperCase� {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("public EObject eObject(EObject context) {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("return ZDLUtil.getZDLEnumLiteral(context,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"�element.domainElement.qualifiedName�\", \"�literal.name�\");");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("return eObject(context.eObject());");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�ENDFOR��IF !element.literals.empty�,�ENDIF�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("* Literal for cases when the value is UNKNOWN");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("UNKNOWN {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("public EObject eObject(EObject context) {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("public EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context) {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�element.generateCreateMethod�");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public abstract EObject eObject(EObject context);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public abstract EObject eObject(com.zeligsoft.base.zdl.staticapi.core.ZObject context);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compileEnumeration(final GenDomainClassifier element, final String pkg) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence generateEnumerationImports(final GenDomainEnum element) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.zeligsoft.base.zdl.util.ZDLUtil;");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateCreateMethod(final GenDomainEnum element) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param literal");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*    the raw object to create the instance from");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*    an instance of this enumeration based on the literal passed in and");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*    UNKNOWN if the literal is unrecognized");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public static �UML2Util::getValidJavaIdentifier(element.name)� create(EObject literal) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�FOR literal : element.literals BEFORE \"if \" SEPARATOR \" else if \"�(literal == ZDLUtil.getZDLEnumLiteral(literal, \"�element.domainElement.qualifiedName�\", \"�literal.name�\")) { //$NON-NLS-1$//$NON-NLS-2$");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return �literal.name.toUpperCase�;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�ENDFOR��IF element.literals.empty�return UNKNOWN;�ELSE� else {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return UNKNOWN;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}�ENDIF�");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileEnumeration(final GenDomainClassifier element, final String pkg) {
    if (element instanceof GenDomainEnum) {
      return _compileEnumeration((GenDomainEnum)element, pkg);
    } else if (element != null) {
      return _compileEnumeration(element, pkg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, pkg).toString());
    }
  }
}
