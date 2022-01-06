package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaMethodSignaturesExtensions {
  @Inject
  @Extension
  private GenDomainStructuralFeatureExtensions _genDomainStructuralFeatureExtensions;
  
  protected String _compositeMultivaluedAddExistingSignature(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _compositeMultivaluedAddExistingSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    return _builder.toString();
  }
  
  protected String _compositeMultivaluedAddExistingSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    return _builder.toString();
  }
  
  protected String _compositeMultivaluedAddParemeterizedSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<T extends �feature.featureModifierType�> T add�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(Class<T> typeToCreate, String concept)");
    return _builder.toString();
  }
  
  protected String _compositeMultivaluedAddParemeterizedSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<T extends �feature.featureModifierType�> T add�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(Class<T> typeToCreate, String concept)");
    return _builder.toString();
  }
  
  protected String _compositeMultivalueAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureModifierType� add�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�()");
    return _builder.toString();
  }
  
  protected String _compositeMultivalueAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureModifierType� add�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�()");
    return _builder.toString();
  }
  
  protected String _compositeAddExistingSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _compositeAddExistingSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _compositeAddParemeterizedSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<T extends �feature.featureModifierType�> T create�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(Class<T> typeToCreate, String concept)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _compositeAddParemeterizedSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<T extends �feature.featureModifierType�> T create�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(Class<T> typeToCreate, String concept)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _compositeAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureModifierType� create�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�()");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _compositeAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureModifierType� create�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�()");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _sharedMultivaluedAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _sharedMultivaluedAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _sharedAddSignature(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _sharedAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _sharedAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _noneMultivaluedAddSignature(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _noneMultivaluedAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _noneMultivaluedAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void add�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _noneAddSignature(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _noneAddSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _noneAddSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void set�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(�feature.featureModifierType� val)");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _accessorSignature(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _accessorSignature(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureAccessorReturnType� �feature.accessorName�()");
    return _builder.toString();
  }
  
  protected String _accessorSignature(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.featureAccessorReturnType� �feature.accessorName�()");
    return _builder.toString();
  }
  
  protected String _accessorName(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  protected String _accessorName(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get�feature.domainElement.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�");
    return _builder.toString();
  }
  
  protected String _accessorName(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�");
    return _builder.toString();
  }
  
  public String compositeMultivaluedAddExistingSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeMultivaluedAddExistingSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeMultivaluedAddExistingSignature((GenDomainReference)feature);
    } else if (feature != null) {
      return _compositeMultivaluedAddExistingSignature(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String compositeMultivaluedAddParemeterizedSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeMultivaluedAddParemeterizedSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeMultivaluedAddParemeterizedSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String compositeMultivalueAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeMultivalueAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeMultivalueAddSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String compositeAddExistingSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeAddExistingSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeAddExistingSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String compositeAddParemeterizedSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeAddParemeterizedSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeAddParemeterizedSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String compositeAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compositeAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compositeAddSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String sharedMultivaluedAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _sharedMultivaluedAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _sharedMultivaluedAddSignature((GenDomainReference)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String sharedAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _sharedAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _sharedAddSignature((GenDomainReference)feature);
    } else if (feature != null) {
      return _sharedAddSignature(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String noneMultivaluedAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _noneMultivaluedAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _noneMultivaluedAddSignature((GenDomainReference)feature);
    } else if (feature != null) {
      return _noneMultivaluedAddSignature(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String noneAddSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _noneAddSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _noneAddSignature((GenDomainReference)feature);
    } else if (feature != null) {
      return _noneAddSignature(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String accessorSignature(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _accessorSignature((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _accessorSignature((GenDomainReference)feature);
    } else if (feature != null) {
      return _accessorSignature(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  public String accessorName(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _accessorName((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _accessorName((GenDomainReference)feature);
    } else if (feature != null) {
      return _accessorName(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
}
