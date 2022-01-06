package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature;
import java.util.ArrayList;
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
public class JavaImplementationGenerator {
  @Inject
  @Extension
  private GenDomainConceptExtensions _genDomainConceptExtensions;
  
  @Inject
  @Extension
  private GenDomainStructuralFeatureExtensions _genDomainStructuralFeatureExtensions;
  
  @Inject
  @Extension
  private JavaMethodSignaturesExtensions _javaMethodSignaturesExtensions;
  
  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;
  
  @Inject
  @Extension
  private JavaImportExtensions _javaImportExtensions;
  
  @Inject
  @Named("Root Package")
  private String rootPackage;
  
  @Inject
  @Named("Implementation SubPackage")
  private String implSubPackage;
  
  @Inject
  @Named("Implementation Suffix")
  private String implSuffix;
  
  protected CharSequence _compileImplementation(final GenDomainClassifier concept, final String pkg) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _compileImplementation(final GenDomainConcept concept, final String pkg) {
    CharSequence _xblockexpression = null;
    {
      final EList<GenDomainConcept> baseConcepts = concept.getGenerals();
      final GenDomainConcept firstBaseConcept = IterableExtensions.<GenDomainConcept>head(baseConcepts);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �concept.block.implementationJavaPackage�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�concept.implementationImports�");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("public �IF concept.domainConcept.isAbstract�abstract �ENDIF�class �concept.javaImplementationName�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�IF firstBaseConcept != null�extends �firstBaseConcept.javaImplementationName� �ELSE�extends ZObjectImpl �ENDIF�implements �concept.javaInterfaceName�{");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�concept.implementationStandardFields�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�concept.implementationFields�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�concept.implementationConstructor�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�concept.implementationStandardAccessors�");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�FOR feature:concept.allFeaturesToImplement�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�feature.compileImplementation� ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�IF feature.isInconsistentOverride�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�FOR overriden : feature.overridenGenFeatures�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�overriden.compileOverridenImplementation�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�concept.umlMappingImplementationMethods�");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence compileImplementation(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�feature.accessorImplementation�");
    _builder.newLine();
    _builder.append("�feature.modifierImplementation�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _accessorImplementation(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _accessorImplementation(final GenDomainAttribute feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public �feature.featureAccessorReturnType� get�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(){");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�IF !feature.domainAttribute.multivalued && feature.hasPrimitiveType�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("final Object rawValue =");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), \"�feature.conceptQualifiedName�\", \"�feature.name�\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (�feature.typeAsString�) rawValue;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�ELSEIF !feature.domainAttribute.multivalued && feature.hasUMLType�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("final Object rawValue =");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), \"�feature.conceptQualifiedName�\", \"�feature.name�\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (�feature.typeAsString�) rawValue;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("final Object rawValue =");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), \"�feature.conceptQualifiedName�\", \"�feature.name�\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(�feature.featureFieldName� == null) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�IF feature.domainAttribute.multivalued�");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�feature.featureFieldName� = new java.util.ArrayList<�feature.typeAsString�>();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("for(Object next : rawList) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�IF feature.hasPrimitiveType�");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�feature.featureFieldName�.add((�feature.typeAsString�) next);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�ELSEIF feature.type instanceof GenDomainEnum�");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if(next instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("�feature.typeAsString� nextWrapper = ");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("�feature.typeAsString�.create((org.eclipse.emf.ecore.EObject) next);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("�feature.featureFieldName�.add(nextWrapper);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�ELSEIF feature.hasZDLType�");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("if(next instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("�feature.typeAsString� nextWrapper = ");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, �feature.typeAsString�.class);");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("�feature.featureFieldName�.add(nextWrapper);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�ELSEIF feature.hasUMLType�");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�feature.featureFieldName�.add((�feature.typeAsString�) next);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("                 ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�IF feature.type instanceof GenDomainEnum�");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if(rawValue instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�feature.featureFieldName� = �feature.typeAsString�.create((org.eclipse.emf.ecore.EObject) rawValue);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�ELSEIF feature.hasZDLType�");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if(rawValue instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("�feature.featureFieldName� = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, �feature.typeAsString�.class);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return �feature.featureFieldName�;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
  
  private CharSequence _accessorImplementation(final GenDomainReference feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public �feature.featureAccessorReturnType� get�feature.domainAttribute.name.toFirstUpper��IF feature.isInconsistentOverride��feature.inconsistentOverrideString��ENDIF�(){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if(�feature.featureFieldName� == null) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("final Object rawValue = ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), \"�feature.conceptQualifiedName�\", \"�feature.domainAttribute.name�\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�IF feature.domainAttribute.multivalued�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�feature.featureFieldName� = new java.util.ArrayList<�feature.typeAsString�>();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("for(Object next : rawList) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if(next instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�feature.typeAsString� nextWrapper = ");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next, �feature.typeAsString�.class);");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("�feature.featureFieldName�.add(nextWrapper);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}   ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(rawValue instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("�feature.featureFieldName� = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject)rawValue, �feature.typeAsString�.class);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return �feature.featureFieldName�;");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence compileOverridenImplementation(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public �feature.featureAccessorReturnType� get�feature.domainAttribute.name.toFirstUpper��feature.inconsistentOverrideString�(){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throw new UnsupportedOperationException();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("�feature.modifierImplementationOverriden�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _modifierImplementation(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _modifierImplementationOverriden(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _modifierImplementation(final GenDomainAttribute feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          _switchResult = this.compositeModifierImplementation(feature);
          break;
        case AggregationKind.SHARED:
          _switchResult = this.sharedModifierImplementation(feature);
          break;
        case AggregationKind.NONE:
          _switchResult = this.noneModifierImplementation(feature);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _switchResult = _builder.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  private CharSequence _modifierImplementationOverriden(final GenDomainAttribute feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          _switchResult = this.compositeModifierImplementationOverriden(feature);
          break;
        case AggregationKind.SHARED:
          _switchResult = this.sharedModifierImplementationOverriden(feature);
          break;
        case AggregationKind.NONE:
          _switchResult = this.noneModifierImplementationOverriden(feature);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _switchResult = _builder.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  private CharSequence _modifierImplementation(final GenDomainReference feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          _switchResult = this.compositeModifierImplementation(feature);
          break;
        case AggregationKind.SHARED:
          _switchResult = this.sharedModifierImplementation(feature);
          break;
        case AggregationKind.NONE:
          _switchResult = this.noneModifierImplementation(feature);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _switchResult = _builder.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  private CharSequence _modifierImplementationOverriden(final GenDomainReference feature) {
    String _xifexpression = null;
    boolean _isReadOnly = feature.getDomainAttribute().isReadOnly();
    boolean _not = (!_isReadOnly);
    if (_not) {
      String _switchResult = null;
      int _ordinal = feature.getDomainAttribute().getAggregation().ordinal();
      switch (_ordinal) {
        case AggregationKind.COMPOSITE:
          _switchResult = this.compositeModifierImplementationOverriden(feature);
          break;
        case AggregationKind.SHARED:
          _switchResult = this.sharedModifierImplementationOverriden(feature);
          break;
        case AggregationKind.NONE:
          _switchResult = this.noneModifierImplementationOverriden(feature);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _switchResult = _builder.toString();
          break;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  private String compositeModifierImplementation(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.compositeMultivaluedAddExistingSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// make sure the �feature.featureName� list is created");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�feature.accessorName�();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final Object rawValue = ZDLUtil.getValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@SuppressWarnings(\"unchecked\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rawList.add(val.eObject());");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(�feature.featureFieldName� != null) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�feature.featureFieldName�.add(val);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("public �feature.compositeMultivaluedAddParemeterizedSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// make sure the �feature.domainAttribute.name� list is created");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�feature.accessorName�();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.ecore.EObject newConcept = ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ZDLUtil.createZDLConcept(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", concept);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("T element = ZDLFactoryRegistry.INSTANCE");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append(".create((org.eclipse.emf.ecore.EObject) newConcept,");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("typeToCreate);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(�feature.featureFieldName� != null) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�feature.featureFieldName�.add(element);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return element;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("�IF ! feature.typeIsAbstract�public �feature.compositeMultivalueAddSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// make sure the �feature.featureName� list is created");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�feature.accessorName�();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.ecore.EObject newConcept = ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ZDLUtil.createZDLConcept(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", \"�feature.featureTypeQualifiedName�\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�feature.featureModifierType� element = ZDLFactoryRegistry.INSTANCE");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append(".create((org.eclipse.emf.ecore.EObject) newConcept,");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�feature.featureModifierType�.class);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if(�feature.featureFieldName� != null) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�feature.featureFieldName�.add(element);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return element;");
      _builder.newLine();
      _builder.append("}�ENDIF�");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.compositeAddExistingSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("�IF feature.hasPrimitiveType || feature.hasEnumerationType || feature.hasUMLType�");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("�ELSE�");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val.eObject());");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("�ENDIF�");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("public �feature.compositeAddParemeterizedSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.ecore.EObject newConcept = ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("ZDLUtil.createZDLConcept(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", concept);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("T element = ZDLFactoryRegistry.INSTANCE");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append(".create((org.eclipse.emf.ecore.EObject) newConcept,");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("typeToCreate);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return element;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("�IF ! feature.typeIsAbstract�public �feature.compositeAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.ecore.EObject newConcept = ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("ZDLUtil.createZDLConcept(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", \"�feature.featureTypeQualifiedName�\");");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("�feature.featureModifierType� element = ZDLFactoryRegistry.INSTANCE");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append(".create((org.eclipse.emf.ecore.EObject) newConcept,");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("�feature.featureModifierType�.class);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return element;");
      _builder_1.newLine();
      _builder_1.append("}�ENDIF�");
      _builder_1.newLine();
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  private String compositeModifierImplementationOverriden(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.compositeMultivaluedAddExistingSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("throw new UnsupportedOperationException();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("public �feature.compositeMultivaluedAddParemeterizedSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("throw new UnsupportedOperationException();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("�IF ! feature.typeIsAbstract�public �feature.compositeMultivalueAddSignature�{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("throw new UnsupportedOperationException();");
      _builder.newLine();
      _builder.append("}�ENDIF�");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.compositeAddExistingSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("throw new UnsupportedOperationException();");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("public �feature.compositeAddParemeterizedSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("throw new UnsupportedOperationException();");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("�IF ! feature.typeIsAbstract�public �feature.compositeAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("throw new UnsupportedOperationException();");
      _builder_1.newLine();
      _builder_1.append("}�ENDIF�");
      _builder_1.newLine();
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  private String sharedModifierImplementation(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.sharedMultivaluedAddSignature�{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// make sure the �feature.featureName� list is created");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�feature.accessorName�();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("final Object rawValue = ZDLUtil.getValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("@SuppressWarnings(\"unchecked\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("rawList.add(val.eObject());");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if(�feature.featureFieldName� != null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�feature.featureFieldName�.add(val);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.sharedAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�IF feature.hasPrimitiveType || feature.hasUMLType�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ELSEIF feature.hasEnumerationType�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val.eObject(element));");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ELSE�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val.eObject());");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ENDIF�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  private String sharedModifierImplementationOverriden(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.sharedMultivaluedAddSignature�{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("throw new UnsupportedOperationException();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.sharedAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("throw new UnsupportedOperationException();");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  private String noneModifierImplementation(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.noneMultivaluedAddSignature�{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// make sure the �feature.featureName� list is created");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�feature.accessorName�();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("final Object rawValue = ZDLUtil.getValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("@SuppressWarnings(\"unchecked\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF feature.hasPrimitiveType �");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("rawList.add(val);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ELSEIF feature.hasEnumerationType�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("rawList.add(val.eObject(element));");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("rawList.add(val.eObject());");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if(�feature.featureFieldName� != null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�feature.featureFieldName�.add(val);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.noneAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�IF feature.hasPrimitiveType || feature.hasUMLType�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val);");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ELSEIF feature.hasEnumerationType�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val.eObject(element));");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ELSE�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("ZDLUtil.setValue(element, \"�feature.conceptQualifiedName�\", \"�feature.featureName�\", val.eObject());");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("�ENDIF�");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  private String noneModifierImplementationOverriden(final GenDomainStructuralFeature feature) {
    String _xifexpression = null;
    boolean _isMultivalued = feature.getDomainAttribute().isMultivalued();
    if (_isMultivalued) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public �feature.noneMultivaluedAddSignature�{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("throw new UnsupportedOperationException();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public �feature.noneAddSignature�{");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("throw new UnsupportedOperationException();");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  public CharSequence implementationImports(final GenDomainConcept concept) {
    CharSequence _xblockexpression = null;
    {
      final GenDomainConcept firstBaseConcept = IterableExtensions.<GenDomainConcept>head(concept.getGenerals());
      final ArrayList<GenDomainConcept> baseConceptsToImplement = this._genDomainConceptExtensions.baseDomainConceptsToImplement(concept);
      final Function1<GenDomainStructuralFeature, GenDomainClassifier> _function = (GenDomainStructuralFeature feature) -> {
        return this._genDomainStructuralFeatureExtensions.featureType(feature);
      };
      final List<GenDomainClassifier> featureTypes = ListExtensions.<GenDomainStructuralFeature, GenDomainClassifier>map(concept.getFeatures(), _function);
      final Function1<GenDomainStructuralFeature, Boolean> _function_1 = (GenDomainStructuralFeature feature) -> {
        return Boolean.valueOf(this._genDomainStructuralFeatureExtensions.isInconsistentOverride(feature));
      };
      final Function1<GenDomainStructuralFeature, Set<GenDomainStructuralFeature>> _function_2 = (GenDomainStructuralFeature overriden) -> {
        return this._genDomainStructuralFeatureExtensions.overridenGenFeatures(overriden);
      };
      final Function1<GenDomainStructuralFeature, GenDomainClassifier> _function_3 = (GenDomainStructuralFeature baseFeature) -> {
        return this._genDomainStructuralFeatureExtensions.featureType(baseFeature);
      };
      final Iterable<GenDomainClassifier> inconsistentOverrideInterfaces = IterableExtensions.<GenDomainStructuralFeature, GenDomainClassifier>map(Iterables.<GenDomainStructuralFeature>concat(IterableExtensions.<GenDomainStructuralFeature, Set<GenDomainStructuralFeature>>map(IterableExtensions.<GenDomainStructuralFeature>filter(concept.getFeatures(), _function_1), _function_2)), _function_3);
      final Function1<GenDomainConcept, List<GenDomainClassifier>> _function_4 = (GenDomainConcept baseConcept) -> {
        final Function1<GenDomainStructuralFeature, GenDomainClassifier> _function_5 = (GenDomainStructuralFeature feature) -> {
          return this._genDomainStructuralFeatureExtensions.featureType(feature);
        };
        return ListExtensions.<GenDomainStructuralFeature, GenDomainClassifier>map(baseConcept.getFeatures(), _function_5);
      };
      final Iterable<GenDomainClassifier> baseFeatureTypes = Iterables.<GenDomainClassifier>concat(ListExtensions.<GenDomainConcept, List<GenDomainClassifier>>map(baseConceptsToImplement, _function_4));
      Set<GenDomainClassifier> allInclusions = new HashSet<GenDomainClassifier>();
      allInclusions.addAll(featureTypes);
      Iterables.<GenDomainClassifier>addAll(allInclusions, baseFeatureTypes);
      Iterables.<GenDomainClassifier>addAll(allInclusions, inconsistentOverrideInterfaces);
      allInclusions.remove(concept);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;");
      _builder.newLine();
      _builder.append("�IF firstBaseConcept == null�");
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import �concept.qualifiedName�;");
      _builder.newLine();
      _builder.append("�IF firstBaseConcept != null�import �firstBaseConcept.implementationQualifiedName�;�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR inclusion: allInclusions.filterNull�");
      _builder.newLine();
      _builder.append("�inclusion.inclusionHelper�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.util.ZDLUtil;");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence inclusionHelper(final GenDomainClassifier type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�type.generateImport�");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence umlMappingImplementationMethods(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR umlClass:concept.allMetaclassesToImplementAccessorsFor�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public org.eclipse.uml2.uml.�umlClass.name� as�umlClass.name.toFirstUpper�() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (org.eclipse.uml2.uml.�umlClass.name�) eObject();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�ENDFOR�");
    return _builder;
  }
  
  public CharSequence implementationStandardFields(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence implementationStandardAccessors(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence implementationConstructor(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public �concept.javaImplementationName�(org.eclipse.emf.ecore.EObject element) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("super(element);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence implementationFields(final GenDomainConcept concept) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR feature : concept.allFeaturesToImplement�");
    _builder.newLine();
    _builder.append("�feature.implementationField�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence implementationField(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF feature.domainAttribute.multivalued�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected java.util.List<�feature.typeAsString�> �feature.featureFieldName�;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�ELSEIF !(feature.hasPrimitiveType)�");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected �feature.typeAsString� �feature.featureFieldName�;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("�ENDIF�");
    _builder.newLine();
    return _builder;
  }
  
  private String featureFieldName(final GenDomainStructuralFeature feature) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_�UML2Util::getValidJavaIdentifier(feature.domainAttribute.name)�");
    return _builder.toString();
  }
  
  public CharSequence compileImplementation(final GenDomainClassifier concept, final String pkg) {
    if (concept instanceof GenDomainConcept) {
      return _compileImplementation((GenDomainConcept)concept, pkg);
    } else if (concept != null) {
      return _compileImplementation(concept, pkg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(concept, pkg).toString());
    }
  }
  
  private CharSequence accessorImplementation(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _accessorImplementation((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _accessorImplementation((GenDomainReference)feature);
    } else if (feature != null) {
      return _accessorImplementation(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  private CharSequence modifierImplementation(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _modifierImplementation((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _modifierImplementation((GenDomainReference)feature);
    } else if (feature != null) {
      return _modifierImplementation(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
  
  private CharSequence modifierImplementationOverriden(final GenDomainStructuralFeature feature) {
    if (feature instanceof GenDomainAttribute) {
      return _modifierImplementationOverriden((GenDomainAttribute)feature);
    } else if (feature instanceof GenDomainReference) {
      return _modifierImplementationOverriden((GenDomainReference)feature);
    } else if (feature != null) {
      return _modifierImplementationOverriden(feature);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(feature).toString());
    }
  }
}
