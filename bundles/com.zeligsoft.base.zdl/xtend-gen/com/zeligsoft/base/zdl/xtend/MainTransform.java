package com.zeligsoft.base.zdl.xtend;

import com.google.common.base.Objects;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.AbstractMatcherConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory;
import org.eclipse.papyrus.infra.types.IconEntry;
import org.eclipse.papyrus.infra.types.InheritanceKind;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceFactory;
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.StereotypeToApply;
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherConfiguration;
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherFactory;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class MainTransform {
  private ElementTypeSetConfiguration umlElementType;
  
  private IClientContext clientCtx;
  
  private Profile profile;
  
  private ElementTypeSetConfiguration typeSet;
  
  private List<org.eclipse.uml2.uml.Class> processedConcepts = new ArrayList<org.eclipse.uml2.uml.Class>();
  
  public void mainTransform(final Profile profile, final ElementTypeSetConfiguration umlType, final ElementTypeSetConfiguration typeSet) {
    this.profile = profile;
    this.umlElementType = umlType;
    this.clientCtx = ClientContextManager.getInstance().getClientContextFor(profile);
    this.typeSet = typeSet;
    String _name = profile.getName();
    String _plus = (_name + " Element Type Set Configuration");
    typeSet.setDescription(_plus);
    String _lowerCase = profile.getName().toLowerCase();
    String _plus_1 = ("com.zeligsoft.domain." + _lowerCase);
    String _plus_2 = (_plus_1 + ".elementTypeSet");
    typeSet.setIdentifier(_plus_2);
    typeSet.setMetamodelNsURI("http://www.eclipse.org/uml2/5.0.0/UML");
    typeSet.setName(profile.getName());
    final TreeIterator<EObject> iter = profile.eAllContents();
    while (iter.hasNext()) {
      {
        final EObject next = iter.next();
        if ((next instanceof Stereotype)) {
          List<NamedElement> _zDLDefinition = ZDLUtil.getZDLDefinition(((NamedElement)next));
          for (final NamedElement concept : _zDLDefinition) {
            if ((concept instanceof org.eclipse.uml2.uml.Class)) {
              final org.eclipse.uml2.uml.Class metaClass = ZDLUtil.getBaseMetaclass(profile, ((org.eclipse.uml2.uml.Class)concept));
              if (((metaClass != null) && (!((org.eclipse.uml2.uml.Class)concept).isAbstract()))) {
                this.processConcept(((org.eclipse.uml2.uml.Class)concept));
              }
            }
          }
        }
      }
    }
  }
  
  public ElementTypeConfiguration processConcept(final org.eclipse.uml2.uml.Class concept) {
    final String speId = ZDLElementTypeUtil.getZDLSpecializationElementTypeId(this.profile, concept);
    final SpecializationTypeConfiguration config = this.findSpecializationTypeConfiguration(speId);
    boolean _contains = this.processedConcepts.contains(concept);
    if (_contains) {
      return config;
    }
    this.processedConcepts.add(concept);
    ElementTypeConfiguration result = null;
    if ((config != null)) {
      this.configureSpecializationType(config, concept);
      result = config;
    } else {
      result = this.createSpecializedType(concept);
    }
    final ApplyStereotypeAdviceConfiguration advice = this.findApplyStereotypeAdviceConfiguration(this.getApplyStereotypeAdviceConfigurationId(concept));
    if ((advice != null)) {
      this.configureApplyStereotypeAdviceConfiguration(advice, concept, result);
    } else {
      this.createApplyStereotypeAdvice(concept, result);
    }
    return result;
  }
  
  public ApplyStereotypeAdviceConfiguration findApplyStereotypeAdviceConfiguration(final String id) {
    EList<AbstractAdviceBindingConfiguration> _adviceBindingsConfigurations = this.typeSet.getAdviceBindingsConfigurations();
    for (final AbstractAdviceBindingConfiguration advice : _adviceBindingsConfigurations) {
      String _identifier = advice.getIdentifier();
      boolean _equals = Objects.equal(_identifier, id);
      if (_equals) {
        return ((ApplyStereotypeAdviceConfiguration) advice);
      }
    }
    return null;
  }
  
  public SpecializationTypeConfiguration findSpecializationTypeConfiguration(final String id) {
    EList<ElementTypeConfiguration> _elementTypeConfigurations = this.typeSet.getElementTypeConfigurations();
    for (final ElementTypeConfiguration et : _elementTypeConfigurations) {
      String _identifier = et.getIdentifier();
      boolean _equals = Objects.equal(_identifier, id);
      if (_equals) {
        return ((SpecializationTypeConfiguration) et);
      }
    }
    return null;
  }
  
  public void configureSpecializationType(final SpecializationTypeConfiguration type, final org.eclipse.uml2.uml.Class concept) {
    final org.eclipse.uml2.uml.Class metaclass = ZDLUtil.getBaseMetaclass(this.profile, concept);
    EClassifier _eClassifier = UMLPackage.eINSTANCE.getEClassifier(metaclass.getName());
    final EClass eclass = ((EClass) _eClassifier);
    final IElementType umlType = ElementTypeRegistry.getInstance().getElementType(eclass, this.clientCtx);
    type.setName(concept.getLabel());
    type.setIdentifier(ZDLElementTypeUtil.getZDLSpecializationElementTypeId(this.profile, concept));
    type.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");
    if ((umlType != null)) {
      final String id = umlType.getId();
      EList<ElementTypeConfiguration> _elementTypeConfigurations = this.umlElementType.getElementTypeConfigurations();
      for (final ElementTypeConfiguration etc : _elementTypeConfigurations) {
        {
          final String umlid = etc.getIdentifier();
          boolean _equals = Objects.equal(umlid, id);
          if (_equals) {
            type.getSpecializedTypes().add(etc);
          }
        }
      }
    }
    IconEntry _iconEntry = type.getIconEntry();
    boolean _tripleNotEquals = (_iconEntry != null);
    if (_tripleNotEquals) {
      EcoreUtil.delete(type.getIconEntry());
    }
    AbstractMatcherConfiguration _matcherConfiguration = type.getMatcherConfiguration();
    boolean _tripleNotEquals_1 = (_matcherConfiguration != null);
    if (_tripleNotEquals_1) {
      EcoreUtil.delete(type.getMatcherConfiguration());
    }
    final URL iconURL = ZDLUtil.getIcon(concept);
    if ((iconURL != null)) {
      type.setIconEntry(this.createIconEntry(iconURL));
    } else {
      EList<ElementTypeConfiguration> _specializedTypes = type.getSpecializedTypes();
      for (final ElementTypeConfiguration st : _specializedTypes) {
        if (((st.getIconEntry() != null) && (type.getIconEntry() == null))) {
          type.setIconEntry(this.createIconEntry(st.getIconEntry()));
        }
      }
    }
    type.setMatcherConfiguration(this.createStereotypeMatcher(concept));
  }
  
  public SpecializationTypeConfiguration createSpecializedType(final org.eclipse.uml2.uml.Class concept) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(concept);
    final SpecializationTypeConfiguration _result;
    synchronized (_createCache_createSpecializedType) {
      if (_createCache_createSpecializedType.containsKey(_cacheKey)) {
        return _createCache_createSpecializedType.get(_cacheKey);
      }
      SpecializationTypeConfiguration _createSpecializationTypeConfiguration = ElementTypesConfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();
      _result = _createSpecializationTypeConfiguration;
      _createCache_createSpecializedType.put(_cacheKey, _result);
    }
    _init_createSpecializedType(_result, concept);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, SpecializationTypeConfiguration> _createCache_createSpecializedType = CollectionLiterals.newHashMap();
  
  private void _init_createSpecializedType(final SpecializationTypeConfiguration result, final org.eclipse.uml2.uml.Class concept) {
    this.typeSet.getElementTypeConfigurations().add(result);
    this.configureSpecializationType(result, concept);
  }
  
  public IconEntry createIconEntry(final IconEntry iconEntry) {
    IconEntry result = ElementTypesConfigurationsFactory.eINSTANCE.createIconEntry();
    result.setBundleId(iconEntry.getBundleId());
    Path path = Paths.get(iconEntry.getIconPath());
    result.setIconPath(path.normalize().toString());
    return result;
  }
  
  public IconEntry createIconEntry(final URL url) {
    IconEntry result = ElementTypesConfigurationsFactory.eINSTANCE.createIconEntry();
    final String temp = url.toString().substring("platform:/plugin/".length());
    final int index = temp.indexOf("/");
    final String bundle = temp.substring(0, index);
    final String path = temp.substring(index);
    result.setBundleId(bundle);
    result.setIconPath(path);
    return result;
  }
  
  public String domainQualifiedName(final String qn) {
    final int index = qn.lastIndexOf("::");
    String _name = this.profile.getName();
    String _substring = qn.substring(index);
    final String result = (_name + _substring);
    return result;
  }
  
  public StereotypeApplicationMatcherConfiguration createStereotypeMatcher(final org.eclipse.uml2.uml.Class concept) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(concept);
    final StereotypeApplicationMatcherConfiguration _result;
    synchronized (_createCache_createStereotypeMatcher) {
      if (_createCache_createStereotypeMatcher.containsKey(_cacheKey)) {
        return _createCache_createStereotypeMatcher.get(_cacheKey);
      }
      StereotypeApplicationMatcherConfiguration _createStereotypeApplicationMatcherConfiguration = StereotypeApplicationMatcherFactory.eINSTANCE.createStereotypeApplicationMatcherConfiguration();
      _result = _createStereotypeApplicationMatcherConfiguration;
      _createCache_createStereotypeMatcher.put(_cacheKey, _result);
    }
    _init_createStereotypeMatcher(_result, concept);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, StereotypeApplicationMatcherConfiguration> _createCache_createStereotypeMatcher = CollectionLiterals.newHashMap();
  
  private void _init_createStereotypeMatcher(final StereotypeApplicationMatcherConfiguration result, final org.eclipse.uml2.uml.Class concept) {
    final String qn = this.domainQualifiedName(concept.getQualifiedName());
    result.getStereotypesQualifiedNames().add(qn);
  }
  
  public boolean configureApplyStereotypeAdviceConfiguration(final ApplyStereotypeAdviceConfiguration adviceConfig, final org.eclipse.uml2.uml.Class concept, final ElementTypeConfiguration et) {
    boolean _xblockexpression = false;
    {
      adviceConfig.setIdentifier(this.getApplyStereotypeAdviceConfigurationId(concept));
      adviceConfig.setInheritance(InheritanceKind.NONE);
      adviceConfig.setTarget(et);
      boolean _isEmpty = adviceConfig.getStereotypesToApply().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        EcoreUtil.delete(adviceConfig.getStereotypesToApply().remove(0));
      }
      _xblockexpression = adviceConfig.getStereotypesToApply().add(this.createStereotypeToApply(concept));
    }
    return _xblockexpression;
  }
  
  public String getApplyStereotypeAdviceConfigurationId(final org.eclipse.uml2.uml.Class concept) {
    String _name = this.profile.getName();
    String _plus = ("com.zeligsoft.domain." + _name);
    String _plus_1 = (_plus + ".apply");
    String _replaceAll = this.domainQualifiedName(concept.getQualifiedName()).replaceAll("::", ".");
    String _plus_2 = (_plus_1 + _replaceAll);
    return (_plus_2 + "Stereotype");
  }
  
  public ApplyStereotypeAdviceConfiguration createApplyStereotypeAdvice(final org.eclipse.uml2.uml.Class concept, final ElementTypeConfiguration et) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(concept, et);
    final ApplyStereotypeAdviceConfiguration _result;
    synchronized (_createCache_createApplyStereotypeAdvice) {
      if (_createCache_createApplyStereotypeAdvice.containsKey(_cacheKey)) {
        return _createCache_createApplyStereotypeAdvice.get(_cacheKey);
      }
      ApplyStereotypeAdviceConfiguration _createApplyStereotypeAdviceConfiguration = ApplyStereotypeAdviceFactory.eINSTANCE.createApplyStereotypeAdviceConfiguration();
      _result = _createApplyStereotypeAdviceConfiguration;
      _createCache_createApplyStereotypeAdvice.put(_cacheKey, _result);
    }
    _init_createApplyStereotypeAdvice(_result, concept, et);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, ApplyStereotypeAdviceConfiguration> _createCache_createApplyStereotypeAdvice = CollectionLiterals.newHashMap();
  
  private void _init_createApplyStereotypeAdvice(final ApplyStereotypeAdviceConfiguration result, final org.eclipse.uml2.uml.Class concept, final ElementTypeConfiguration et) {
    this.typeSet.getAdviceBindingsConfigurations().add(result);
    this.configureApplyStereotypeAdviceConfiguration(result, concept, et);
    boolean _isEmpty = result.getStereotypesToApply().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EcoreUtil.delete(result.getStereotypesToApply().remove(0));
    }
    result.getStereotypesToApply().add(this.createStereotypeToApply(concept));
  }
  
  public StereotypeToApply createStereotypeToApply(final org.eclipse.uml2.uml.Class concept) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(concept);
    final StereotypeToApply _result;
    synchronized (_createCache_createStereotypeToApply) {
      if (_createCache_createStereotypeToApply.containsKey(_cacheKey)) {
        return _createCache_createStereotypeToApply.get(_cacheKey);
      }
      StereotypeToApply _createStereotypeToApply = ApplyStereotypeAdviceFactory.eINSTANCE.createStereotypeToApply();
      _result = _createStereotypeToApply;
      _createCache_createStereotypeToApply.put(_cacheKey, _result);
    }
    _init_createStereotypeToApply(_result, concept);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, StereotypeToApply> _createCache_createStereotypeToApply = CollectionLiterals.newHashMap();
  
  private void _init_createStereotypeToApply(final StereotypeToApply result, final org.eclipse.uml2.uml.Class concept) {
    final String qn = this.domainQualifiedName(concept.getQualifiedName());
    result.getRequiredProfiles().add(this.profile.getName());
    result.setStereotypeQualifiedName(qn);
    result.setUpdateName(true);
  }
}
