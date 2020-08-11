package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaNamingExtensions;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaImportExtensions {
  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;
  
  protected CharSequence _generateImport(final GenDomainClassifier concept) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateImport(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    String _qualifiedName = this._javaNamingExtensions.qualifiedName(concept);
    _builder.append(_qualifiedName);
    _builder.append(";");
    return _builder;
  }
  
  protected CharSequence _generateImport(final GenDomainEnum denum) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    String _qualifiedName = this._javaNamingExtensions.qualifiedName(denum);
    _builder.append(_qualifiedName);
    _builder.append(";");
    return _builder;
  }
  
  protected CharSequence _generateImplementationImport(final GenDomainClassifier concept) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateImplementationImport(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    CharSequence _implementationQualifiedName = this._javaNamingExtensions.implementationQualifiedName(concept);
    _builder.append(_implementationQualifiedName);
    _builder.append(";");
    return _builder;
  }
  
  public CharSequence generateImport(final GenDomainClassifier denum) {
    if (denum instanceof GenDomainEnum) {
      return _generateImport((GenDomainEnum)denum);
    } else if (denum instanceof GenDomainConcept) {
      return _generateImport((GenDomainConcept)denum);
    } else if (denum != null) {
      return _generateImport(denum);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(denum).toString());
    }
  }
  
  public CharSequence generateImplementationImport(final GenDomainClassifier concept) {
    if (concept instanceof GenDomainConcept) {
      return _generateImplementationImport((GenDomainConcept)concept);
    } else if (concept != null) {
      return _generateImplementationImport(concept);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(concept).toString());
    }
  }
}
