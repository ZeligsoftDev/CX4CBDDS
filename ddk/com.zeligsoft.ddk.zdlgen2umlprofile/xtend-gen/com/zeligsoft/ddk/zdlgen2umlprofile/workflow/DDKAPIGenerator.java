package com.zeligsoft.ddk.zdlgen2umlprofile.workflow;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFileSystemAccess;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainConceptExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainModelExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.GenDomainStructuralFeatureExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaEnumerationGenerator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaImplementationGenerator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaInterfaceGenerator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaNamingExtensions;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.JavaUMLPackageTypeSelectUtilGenerator;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.ZDLGenExtensions;
import java.util.function.Consumer;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DDKAPIGenerator {
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
  private JavaInterfaceGenerator _javaInterfaceGenerator;

  @Inject
  @Extension
  private JavaImplementationGenerator _javaImplementationGenerator;

  @Inject
  @Extension
  private JavaEnumerationGenerator _javaEnumerationGenerator;

  @Inject
  @Extension
  private JavaUMLPackageTypeSelectUtilGenerator _javaUMLPackageTypeSelectUtilGenerator;

  @Inject
  @Extension
  private ZDLGenExtensions _zDLGenExtensions;

  @Inject
  @Extension
  private GenDomainModelExtensions _genDomainModelExtensions;

  @Inject
  @Named("Root Package")
  private String rootPackage;

  @Inject
  @Named("Implementation SubPackage")
  private String implSubPackage;

  @Inject
  @Named("Implementation Suffix")
  private String implSuffix;

  @Inject
  private IFileSystemAccess fileSystemAccess;

  public void doGenerate(final GenDomainModel model) {
    this.compileFactoryClass(model);
    this.compileTypeSelectClass(model);
    Iterable<GenDomainBlock> _domainBlocks = this._genDomainModelExtensions.domainBlocks(model);
    for (final GenDomainBlock block : _domainBlocks) {
      this.doGenerate(block);
    }
  }

  public void doGenerate(final GenDomainBlock block) {
    final String blockName = block.getName();
    final String rootDirectory = this._javaNamingExtensions.interfaceJavaPackage(block).replace(".", "/");
    final String implDirectory = this._javaNamingExtensions.implementationJavaPackage(block).replace(".", "/");
    Iterable<GenDomainConcept> _filter = Iterables.<GenDomainConcept>filter(block.getClassifiers(), GenDomainConcept.class);
    for (final GenDomainConcept concept : _filter) {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(rootDirectory);
        _builder.append("/");
        String _javaInterfaceName = this._javaNamingExtensions.javaInterfaceName(concept);
        _builder.append(_javaInterfaceName);
        _builder.append(".java");
        this.fileSystemAccess.generateFile(
          _builder.toString(), 
          this._javaInterfaceGenerator.compileInterface(concept));
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(implDirectory);
        _builder_1.append("/");
        String _javaImplementationName = this._javaNamingExtensions.javaImplementationName(concept);
        _builder_1.append(_javaImplementationName);
        _builder_1.append(".java");
        this.fileSystemAccess.generateFile(
          _builder_1.toString(), 
          this._javaImplementationGenerator.compileImplementation(concept, blockName));
      }
    }
    Iterable<GenDomainEnum> _filter_1 = Iterables.<GenDomainEnum>filter(block.getClassifiers(), GenDomainEnum.class);
    for (final GenDomainEnum element : _filter_1) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(rootDirectory);
      _builder.append("/");
      String _validJavaIdentifier = UML2Util.getValidJavaIdentifier(this._javaNamingExtensions.javaInterfaceName(element));
      _builder.append(_validJavaIdentifier);
      _builder.append(".java");
      this.fileSystemAccess.generateFile(
        _builder.toString(), 
        this._javaEnumerationGenerator.compileEnumeration(element, blockName));
    }
  }

  public void compileTypeSelectClass(final GenDomainModel model) {
    StringConcatenation _builder = new StringConcatenation();
    String _replace = model.getRootPackage().replace(".", "/");
    _builder.append(_replace);
    _builder.append("/");
    String _name = model.getName();
    _builder.append(_name);
    _builder.append("/util/");
    String _name_1 = model.getName();
    _builder.append(_name_1);
    _builder.append("TypeSelectUtil.java");
    this.fileSystemAccess.generateFile(_builder.toString(), this._javaUMLPackageTypeSelectUtilGenerator.generateJavaUMLPackageTypeSelectUtil(model));
  }

  public void compileFactoryClass(final GenDomainModel model) {
    final Iterable<GenDomainSpecialization> domainSpecializations = Iterables.<GenDomainSpecialization>filter(model.getElements(), GenDomainSpecialization.class);
    final Consumer<GenDomainSpecialization> _function = (GenDomainSpecialization spec) -> {
      this.compileFactoryClass(spec);
    };
    domainSpecializations.forEach(_function);
  }

  public void compileFactoryClass(final GenDomainSpecialization model) {
    final GenDomainModel domainModel = this._zDLGenExtensions.domainModel(model.eContainer());
    StringConcatenation _builder = new StringConcatenation();
    String _replace = domainModel.getRootPackage().replace(".", "/");
    _builder.append(_replace);
    _builder.append("/");
    String _name = domainModel.getName();
    _builder.append(_name);
    _builder.append("/util/");
    String _name_1 = model.getName();
    _builder.append(_name_1);
    _builder.append("FactoryImpl.java");
    this.fileSystemAccess.generateFile(_builder.toString(), this.compileFactoryClassHelper(model));
  }

  private CharSequence compileFactoryClassHelper(final GenDomainSpecialization model) {
    CharSequence _xblockexpression = null;
    {
      final GenDomainModel domainModel = this._zDLGenExtensions.domainModel(model.eContainer());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _rootPackage = domainModel.getRootPackage();
      _builder.append(_rootPackage);
      _builder.append(".");
      String _name = domainModel.getName();
      _builder.append(_name);
      _builder.append(".util;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.google.common.collect.Maps;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.util.AbstractBaseZDLFactory;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _name_1 = model.getName();
      _builder.append(_name_1);
      _builder.append("FactoryImpl extends AbstractBaseZDLFactory {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("protected java.util.Map<String, Class<?>> registry ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("= Maps.newHashMap();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_2 = model.getName();
      _builder.append(_name_2, "\t");
      _builder.append("FactoryImpl() {");
      _builder.newLineIfNotEmpty();
      {
        final Function1<GenDomainConcept, Boolean> _function = (GenDomainConcept concept) -> {
          boolean _isAbstract = concept.getDomainConcept().isAbstract();
          return Boolean.valueOf((!_isAbstract));
        };
        Iterable<GenDomainConcept> _filter = IterableExtensions.<GenDomainConcept>filter(model.getDomainConcepts(), _function);
        for(final GenDomainConcept concept : _filter) {
          _builder.append("\t");
          _builder.append("registry.put(\"");
          String _qualifiedName = concept.getDomainElement().getQualifiedName();
          _builder.append(_qualifiedName, "\t");
          _builder.append("\", ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _implementationQualifiedName = this._javaNamingExtensions.implementationQualifiedName(concept);
          _builder.append(_implementationQualifiedName, "\t\t");
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected Map<String, Class<?>> getRegistry() {");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("return registry;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
