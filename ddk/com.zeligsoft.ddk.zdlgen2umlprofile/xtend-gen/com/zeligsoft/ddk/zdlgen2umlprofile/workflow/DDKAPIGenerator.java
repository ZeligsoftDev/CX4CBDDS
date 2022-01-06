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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

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
        _builder.append("�rootDirectory�/�concept.javaInterfaceName�.java");
        this.fileSystemAccess.generateFile(
          _builder.toString(), 
          this._javaInterfaceGenerator.compileInterface(concept));
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("�implDirectory�/�concept.javaImplementationName�.java");
        this.fileSystemAccess.generateFile(
          _builder_1.toString(), 
          this._javaImplementationGenerator.compileImplementation(concept, blockName));
      }
    }
    Iterable<GenDomainEnum> _filter_1 = Iterables.<GenDomainEnum>filter(block.getClassifiers(), GenDomainEnum.class);
    for (final GenDomainEnum element : _filter_1) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�rootDirectory�/�UML2Util::getValidJavaIdentifier(element.javaInterfaceName)�.java");
      this.fileSystemAccess.generateFile(
        _builder.toString(), 
        this._javaEnumerationGenerator.compileEnumeration(element, blockName));
    }
  }
  
  public void compileTypeSelectClass(final GenDomainModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�model.rootPackage.replace(\".\", \"/\")�/�model.name�/util/�model.name�TypeSelectUtil.java");
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
    _builder.append("�domainModel.rootPackage.replace(\".\", \"/\")�/�domainModel.name�/util/�model.name�FactoryImpl.java");
    this.fileSystemAccess.generateFile(_builder.toString(), this.compileFactoryClassHelper(model));
  }
  
  private CharSequence compileFactoryClassHelper(final GenDomainSpecialization model) {
    CharSequence _xblockexpression = null;
    {
      final GenDomainModel domainModel = this._zDLGenExtensions.domainModel(model.eContainer());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �domainModel.rootPackage�.�domainModel.name�.util;");
      _builder.newLine();
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
      _builder.append("public class �model.name�FactoryImpl extends AbstractBaseZDLFactory {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected java.util.Map<String, Class<?>> registry ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("= Maps.newHashMap();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �model.name�FactoryImpl() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR concept : model.domainConcepts.filter(GenDomainConcept concept | !concept.domainConcept.isAbstract)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("registry.put(\"�concept.domainElement.qualifiedName�\", ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�concept.implementationQualifiedName�.class);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
