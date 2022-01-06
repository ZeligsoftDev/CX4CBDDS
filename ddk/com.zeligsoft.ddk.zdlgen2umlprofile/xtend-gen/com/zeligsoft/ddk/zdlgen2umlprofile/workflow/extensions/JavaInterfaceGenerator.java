package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainDataType;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
    _builder.append("package �concept.block.interfaceJavaPackage�;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface �concept.javaInterfaceName� {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compileInterface(final GenDomainConcept concept) {
    CharSequence _xblockexpression = null;
    {
      final List<GenDomainClassifier> importedTypes = this.interfaceImports(concept);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �concept.block.interfaceJavaPackage�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append(" ");
      _builder.append("�IF concept.baseDomainConcepts.isEmpty�");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("import com.zeligsoft.base.zdl.staticapi.core.ZObject;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;");
      _builder.newLine();
      _builder.append("�FOR importedType:importedTypes.filterNull�");
      _builder.newLine();
      _builder.append("�IF importedType.block != concept.block�");
      _builder.newLine();
      _builder.append("�importedType.generateImport�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface �concept.domainElement.name��IF concept.baseDomainConcepts.isEmpty� extends ZObject�ENDIF��FOR general:concept.baseDomainConcepts BEFORE \' extends \' SEPARATOR \', \'��general.name��ENDFOR� {");
      _builder.newLine();
      _builder.append("�FOR feature:concept.features�");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("�feature.compileInterface�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("�concept.umlMappingInterfaceMethods�");
      _builder.newLine();
      _builder.append("�concept.typeSelectFields�");
      _builder.newLine();
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
    _builder.append("�attributeAccessor(feature)�");
    _builder.newLine();
    _builder.append("�attributeModifier(feature)�");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence attributeAccessor(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.accessorSignature�;");
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
            _builder.append("�feature.compositeMultivaluedAddExistingSignature�;");
            _builder.newLine();
            _builder.append("�feature.compositeMultivaluedAddParemeterizedSignature�;");
            _builder.newLine();
            _builder.append("�IF ! feature.typeIsAbstract��feature.compositeMultivalueAddSignature�;�ENDIF�");
            _builder.newLine();
            _xifexpression_1 = _builder.toString();
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("�feature.compositeAddExistingSignature�;");
            _builder_1.newLine();
            _builder_1.append("�feature.compositeAddParemeterizedSignature�;");
            _builder_1.newLine();
            _builder_1.append("�IF ! feature.typeIsAbstract��feature.compositeAddSignature�;�ENDIF�");
            _builder_1.newLine();
            _xifexpression_1 = _builder_1.toString();
          }
          _switchResult = _xifexpression_1;
          break;
        case AggregationKind.SHARED:
          String _xifexpression_2 = null;
          boolean _isMultivalued_1 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_1) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("�feature.sharedMultivaluedAddSignature�;");
            _xifexpression_2 = _builder_2.toString();
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("�feature.sharedAddSignature�;");
            _xifexpression_2 = _builder_3.toString();
          }
          _switchResult = _xifexpression_2;
          break;
        case AggregationKind.NONE:
          String _xifexpression_3 = null;
          boolean _isMultivalued_2 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_2) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("�feature.noneMultivaluedAddSignature�;");
            _xifexpression_3 = _builder_4.toString();
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("�feature.noneAddSignature�;");
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
            _builder.append("�feature.compositeMultivaluedAddExistingSignature�;");
            _builder.newLine();
            _builder.append("�feature.compositeMultivaluedAddParemeterizedSignature�;");
            _builder.newLine();
            _builder.append("�IF ! feature.typeIsAbstract��feature.compositeMultivalueAddSignature�;�ENDIF�");
            _builder.newLine();
            _xifexpression_1 = _builder.toString();
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("�feature.compositeAddExistingSignature�;");
            _builder_1.newLine();
            _builder_1.append("�feature.compositeAddParemeterizedSignature�;");
            _builder_1.newLine();
            _builder_1.append("�IF ! feature.typeIsAbstract��feature.compositeAddSignature�;�ENDIF�");
            _builder_1.newLine();
            _xifexpression_1 = _builder_1.toString();
          }
          _switchResult = _xifexpression_1;
          break;
        case AggregationKind.SHARED:
          String _xifexpression_2 = null;
          boolean _isMultivalued_1 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_1) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("�feature.sharedMultivaluedAddSignature�;");
            _xifexpression_2 = _builder_2.toString();
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("�feature.sharedAddSignature�;");
            _xifexpression_2 = _builder_3.toString();
          }
          _switchResult = _xifexpression_2;
          break;
        case AggregationKind.NONE:
          String _xifexpression_3 = null;
          boolean _isMultivalued_2 = feature.getDomainAttribute().isMultivalued();
          if (_isMultivalued_2) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("�feature.noneMultivaluedAddSignature�;");
            _xifexpression_3 = _builder_4.toString();
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("�feature.noneAddSignature�;");
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
    _builder.append("�referenceAccessor(feature)�");
    _builder.newLine();
    _builder.append("�referenceModifier(feature)�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence referenceAccessor(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.accessorSignature�;");
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
    _builder.append("�FOR umlClass:concept.umlMetaclasses�");
    _builder.newLine();
    _builder.append("org.eclipse.uml2.uml.�umlClass.name� as�umlClass.name.toFirstUpper�();");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
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
    _builder.append("* instance of �concept.javaInterfaceName�");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("static final TypeSelectPredicate<�concept.javaInterfaceName�> type = ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new TypeSelectPredicate<�concept.javaInterfaceName�>(");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"�concept.domainElement.qualifiedName�\", //$NON-NLS-1$");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�concept.javaInterfaceName�.class); ");
    _builder.newLine();
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
