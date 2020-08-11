package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainConceptExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainStructuralFeatureExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaImportExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaMethodSignaturesExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaNamingExtensions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaInterfaceGenerator {
  @Inject
  @Extension
  private GenDomainConceptExtensions _genDomainConceptExtensions;
  
  @Inject
  @Extension
  private GenDomainStructuralFeatureExtensions _genDomainStructuralFeatureExtensions;
  
  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;
  
  @Inject
  @Extension
  private JavaImportExtensions _javaImportExtensions;
  
  @Inject
  @Extension
  private JavaMethodSignaturesExtensions _javaMethodSignaturesExtensions;
  
  @Inject
  @Named("Root Package")
  private String rootPackage;
  
  @Inject
  @Named("Implementation SubPackage")
  private String implSubPackage;
  
  @Inject
  @Named("Implementation Suffix")
  private String implSuffix;
  
  protected CharSequence _compileInterface(final GenDomainClassifier concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _interfaceJavaPackage = this._javaNamingExtensions.interfaceJavaPackage(concept.getBlock());
    _builder.append(_interfaceJavaPackage);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _javaInterfaceName = this._javaNamingExtensions.javaInterfaceName(concept);
    _builder.append(_javaInterfaceName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compileInterface(final GenDomainConcept concept) {
    CharSequence _xblockexpression = null;
    {
      final List<GenDomainClassifier> importedTypes = this.interfaceImports(concept);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _interfaceJavaPackage = this._javaNamingExtensions.interfaceJavaPackage(concept.getBlock());
      _builder.append(_interfaceJavaPackage);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _isEmpty = this._genDomainConceptExtensions.baseDomainConcepts(concept).isEmpty();
        if (_isEmpty) {
          _builder.append(" ");
          _builder.append("import com.zeligsoft.base.zdl.staticapi.core.ZObject;");
          _builder.newLine();
        }
      }
      _builder.append("import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;");
      _builder.newLine();
      {
        Iterable<GenDomainClassifier> _filterNull = IterableExtensions.<GenDomainClassifier>filterNull(importedTypes);
        for(final GenDomainClassifier importedType : _filterNull) {
          {
            GenDomainBlock _block = importedType.getBlock();
            GenDomainBlock _block_1 = concept.getBlock();
            boolean _notEquals = (!Objects.equal(_block, _block_1));
            if (_notEquals) {
              CharSequence _generateImport = this._javaImportExtensions.generateImport(importedType);
              _builder.append(_generateImport);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("public interface ");
      String _name = concept.getDomainElement().getName();
      _builder.append(_name);
      {
        boolean _isEmpty_1 = this._genDomainConceptExtensions.baseDomainConcepts(concept).isEmpty();
        if (_isEmpty_1) {
          _builder.append(" extends ZObject");
        }
      }
      {
        EList<Classifier> _baseDomainConcepts = this._genDomainConceptExtensions.baseDomainConcepts(concept);
        boolean _hasElements = false;
        for(final Classifier general : _baseDomainConcepts) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append(" extends ");
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _name_1 = general.getName();
          _builder.append(_name_1);
        }
      }
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        EList<GenDomainStructuralFeature> _features = concept.getFeatures();
        for(final GenDomainStructuralFeature feature : _features) {
          Object _compileInterface = this.compileInterface(feature);
          _builder.append(_compileInterface);
          _builder.newLineIfNotEmpty();
        }
      }
      CharSequence _umlMappingInterfaceMethods = this.umlMappingInterfaceMethods(concept);
      _builder.append(_umlMappingInterfaceMethods);
      _builder.newLineIfNotEmpty();
      CharSequence _typeSelectFields = this.typeSelectFields(concept);
      _builder.append(_typeSelectFields);
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _compileInterface(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _compileInterface(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _attributeAccessor = this.attributeAccessor(feature);
    _builder.append(_attributeAccessor);
    _builder.newLineIfNotEmpty();
    String _attributeModifier = this.attributeModifier(feature);
    _builder.append(_attributeModifier);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence attributeAccessor(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessorSignature = this._javaMethodSignaturesExtensions.accessorSignature(feature);
    _builder.append(_accessorSignature);
    _builder.append(";");
    return _builder;
  }
  
  public String attributeModifier(final GenDomainAttribute feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          String _xifexpression_1 = null;
          boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued) {
            StringConcatenation _builder = new StringConcatenation();
            String _compositeMultivaluedAddExistingSignature = this._javaMethodSignaturesExtensions.compositeMultivaluedAddExistingSignature(feature);
            _builder.append(_compositeMultivaluedAddExistingSignature);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            String _compositeMultivaluedAddParemeterizedSignature = this._javaMethodSignaturesExtensions.compositeMultivaluedAddParemeterizedSignature(feature);
            _builder.append(_compositeMultivaluedAddParemeterizedSignature);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            {
              boolean _typeIsAbstract = this._genDomainStructuralFeatureExtensions.typeIsAbstract(feature);
              boolean _not_1 = (!_typeIsAbstract);
              if (_not_1) {
                String _compositeMultivalueAddSignature = this._javaMethodSignaturesExtensions.compositeMultivalueAddSignature(feature);
                _builder.append(_compositeMultivalueAddSignature);
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
            _xifexpression_1 = _builder.toString();
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _compositeAddExistingSignature = this._javaMethodSignaturesExtensions.compositeAddExistingSignature(feature);
            _builder_1.append(_compositeAddExistingSignature);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            String _compositeAddParemeterizedSignature = this._javaMethodSignaturesExtensions.compositeAddParemeterizedSignature(feature);
            _builder_1.append(_compositeAddParemeterizedSignature);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            {
              boolean _typeIsAbstract_1 = this._genDomainStructuralFeatureExtensions.typeIsAbstract(feature);
              boolean _not_2 = (!_typeIsAbstract_1);
              if (_not_2) {
                String _compositeAddSignature = this._javaMethodSignaturesExtensions.compositeAddSignature(feature);
                _builder_1.append(_compositeAddSignature);
                _builder_1.append(";");
              }
            }
            _builder_1.newLineIfNotEmpty();
            _xifexpression_1 = _builder_1.toString();
          }
          _switchResult = _xifexpression_1;
          break;
        case AggregationKind.SHARED:
          String _xifexpression_2 = null;
          boolean _isMultivalued_1 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_1) {
            StringConcatenation _builder_2 = new StringConcatenation();
            String _sharedMultivaluedAddSignature = this._javaMethodSignaturesExtensions.sharedMultivaluedAddSignature(feature);
            _builder_2.append(_sharedMultivaluedAddSignature);
            _builder_2.append(";");
            _xifexpression_2 = _builder_2.toString();
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            String _sharedAddSignature = this._javaMethodSignaturesExtensions.sharedAddSignature(feature);
            _builder_3.append(_sharedAddSignature);
            _builder_3.append(";");
            _xifexpression_2 = _builder_3.toString();
          }
          _switchResult = _xifexpression_2;
          break;
        case AggregationKind.NONE:
          String _xifexpression_3 = null;
          boolean _isMultivalued_2 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_2) {
            StringConcatenation _builder_4 = new StringConcatenation();
            String _noneMultivaluedAddSignature = this._javaMethodSignaturesExtensions.noneMultivaluedAddSignature(feature);
            _builder_4.append(_noneMultivaluedAddSignature);
            _builder_4.append(";");
            _xifexpression_3 = _builder_4.toString();
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            String _noneAddSignature = this._javaMethodSignaturesExtensions.noneAddSignature(feature);
            _builder_5.append(_noneAddSignature);
            _builder_5.append(";");
            _xifexpression_3 = _builder_5.toString();
          }
          _switchResult = _xifexpression_3;
          break;
        default:
          StringConcatenation _builder_6 = new StringConcatenation();
          _switchResult = _builder_6.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  public String referenceModifier(final GenDomainReference feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          String _xifexpression_1 = null;
          boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued) {
            StringConcatenation _builder = new StringConcatenation();
            String _compositeMultivaluedAddExistingSignature = this._javaMethodSignaturesExtensions.compositeMultivaluedAddExistingSignature(feature);
            _builder.append(_compositeMultivaluedAddExistingSignature);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            String _compositeMultivaluedAddParemeterizedSignature = this._javaMethodSignaturesExtensions.compositeMultivaluedAddParemeterizedSignature(feature);
            _builder.append(_compositeMultivaluedAddParemeterizedSignature);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            {
              boolean _typeIsAbstract = this._genDomainStructuralFeatureExtensions.typeIsAbstract(feature);
              boolean _not_1 = (!_typeIsAbstract);
              if (_not_1) {
                String _compositeMultivalueAddSignature = this._javaMethodSignaturesExtensions.compositeMultivalueAddSignature(feature);
                _builder.append(_compositeMultivalueAddSignature);
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
            _xifexpression_1 = _builder.toString();
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _compositeAddExistingSignature = this._javaMethodSignaturesExtensions.compositeAddExistingSignature(feature);
            _builder_1.append(_compositeAddExistingSignature);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            String _compositeAddParemeterizedSignature = this._javaMethodSignaturesExtensions.compositeAddParemeterizedSignature(feature);
            _builder_1.append(_compositeAddParemeterizedSignature);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            {
              boolean _typeIsAbstract_1 = this._genDomainStructuralFeatureExtensions.typeIsAbstract(feature);
              boolean _not_2 = (!_typeIsAbstract_1);
              if (_not_2) {
                String _compositeAddSignature = this._javaMethodSignaturesExtensions.compositeAddSignature(feature);
                _builder_1.append(_compositeAddSignature);
                _builder_1.append(";");
              }
            }
            _builder_1.newLineIfNotEmpty();
            _xifexpression_1 = _builder_1.toString();
          }
          _switchResult = _xifexpression_1;
          break;
        case AggregationKind.SHARED:
          String _xifexpression_2 = null;
          boolean _isMultivalued_1 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_1) {
            StringConcatenation _builder_2 = new StringConcatenation();
            String _sharedMultivaluedAddSignature = this._javaMethodSignaturesExtensions.sharedMultivaluedAddSignature(feature);
            _builder_2.append(_sharedMultivaluedAddSignature);
            _builder_2.append(";");
            _xifexpression_2 = _builder_2.toString();
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            String _sharedAddSignature = this._javaMethodSignaturesExtensions.sharedAddSignature(feature);
            _builder_3.append(_sharedAddSignature);
            _builder_3.append(";");
            _xifexpression_2 = _builder_3.toString();
          }
          _switchResult = _xifexpression_2;
          break;
        case AggregationKind.NONE:
          String _xifexpression_3 = null;
          boolean _isMultivalued_2 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_2) {
            StringConcatenation _builder_4 = new StringConcatenation();
            String _noneMultivaluedAddSignature = this._javaMethodSignaturesExtensions.noneMultivaluedAddSignature(feature);
            _builder_4.append(_noneMultivaluedAddSignature);
            _builder_4.append(";");
            _xifexpression_3 = _builder_4.toString();
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            String _noneAddSignature = this._javaMethodSignaturesExtensions.noneAddSignature(feature);
            _builder_5.append(_noneAddSignature);
            _builder_5.append(";");
            _xifexpression_3 = _builder_5.toString();
          }
          _switchResult = _xifexpression_3;
          break;
        default:
          StringConcatenation _builder_6 = new StringConcatenation();
          _switchResult = _builder_6.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  protected CharSequence _compileInterface(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _referenceAccessor = this.referenceAccessor(feature);
    _builder.append(_referenceAccessor);
    _builder.newLineIfNotEmpty();
    String _referenceModifier = this.referenceModifier(feature);
    _builder.append(_referenceModifier);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence referenceAccessor(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessorSignature = this._javaMethodSignaturesExtensions.accessorSignature(feature);
    _builder.append(_accessorSignature);
    _builder.append(";");
    return _builder;
  }
  
  public List<GenDomainClassifier> interfaceImports(final GenDomainConcept concept) {
    List<GenDomainClassifier> _xblockexpression = null;
    {
      final EList<GenDomainConcept> baseInterfaces = concept.getGenerals();
      final Function1<GenDomainAttribute, GenDomainDataType> _function = (GenDomainAttribute attribute) -> {
        return attribute.getType();
      };
      final List<GenDomainDataType> attributeInterfaces = ListExtensions.<GenDomainAttribute, GenDomainDataType>map(concept.getAttributes(), _function);
      final Function1<GenDomainReference, GenDomainConcept> _function_1 = (GenDomainReference ref) -> {
        return ref.getTarget();
      };
      final List<GenDomainConcept> referenceInterfaces = ListExtensions.<GenDomainReference, GenDomainConcept>map(concept.getReferences(), _function_1);
      Set<GenDomainClassifier> allInclusions = new HashSet<GenDomainClassifier>();
      allInclusions.addAll(baseInterfaces);
      allInclusions.addAll(attributeInterfaces);
      allInclusions.addAll(referenceInterfaces);
      allInclusions.remove(concept);
      _xblockexpression = IterableExtensions.<GenDomainClassifier>toList(allInclusions);
    }
    return _xblockexpression;
  }
  
  public CharSequence umlMappingInterfaceMethods(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<org.eclipse.uml2.uml.Class> _umlMetaclasses = concept.getUmlMetaclasses();
      for(final org.eclipse.uml2.uml.Class umlClass : _umlMetaclasses) {
        _builder.append("org.eclipse.uml2.uml.");
        String _name = umlClass.getName();
        _builder.append(_name);
        _builder.append(" as");
        String _firstUpper = StringExtensions.toFirstUpper(umlClass.getName());
        _builder.append(_firstUpper);
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence typeSelectFields(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* A predicate which returns true if the Object is an");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* instance of ");
    String _javaInterfaceName = this._javaNamingExtensions.javaInterfaceName(concept);
    _builder.append(_javaInterfaceName, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("static final TypeSelectPredicate<");
    String _javaInterfaceName_1 = this._javaNamingExtensions.javaInterfaceName(concept);
    _builder.append(_javaInterfaceName_1);
    _builder.append("> type = ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("new TypeSelectPredicate<");
    String _javaInterfaceName_2 = this._javaNamingExtensions.javaInterfaceName(concept);
    _builder.append(_javaInterfaceName_2, "    ");
    _builder.append(">(");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("\"");
    String _qualifiedName = concept.getDomainElement().getQualifiedName();
    _builder.append(_qualifiedName, "        ");
    _builder.append("\", //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    String _javaInterfaceName_3 = this._javaNamingExtensions.javaInterfaceName(concept);
    _builder.append(_javaInterfaceName_3, "        ");
    _builder.append(".class); ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileInterface(final GenDomainNamedElement feature) {
    if (feature instanceof GenDomainAttribute) {
      return _compileInterface((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainConcept) {
      return _compileInterface((GenDomainConcept)feature);
    } else if (feature instanceof GenDomainReference) {
      return _compileInterface((GenDomainReference)feature);
    } else if (feature instanceof GenDomainClassifier) {
      return _compileInterface((GenDomainClassifier)feature);
    } else if (feature instanceof GenDomainStructuralFeature) {
      return _compileInterface((GenDomainStructuralFeature)feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
}
