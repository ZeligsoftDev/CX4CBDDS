/**
 * Copyright (c) 2015, 20201 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * Templates for generating the common language infrastructure.
 */
@Singleton
@SuppressWarnings("all")
public class XtextGeneratorTemplates {
  @Inject
  private CodeConfig codeConfig;

  @Inject
  private FileAccessFactory fileAccessFactory;

  @Inject
  @Extension
  private XtextGeneratorNaming naming;

  public JavaFileAccess createRuntimeSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _runtimeSetup = this.naming.getRuntimeSetup(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages without Equinox extension registry.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �runtimeSetup.simpleName� extends �runtimeGenSetup� {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("def static void doSetup() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("new �runtimeSetup.simpleName�().createInjectorAndDoEMFRegistration()");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_runtimeSetup, _client);
    } else {
      TypeReference _runtimeSetup_1 = this.naming.getRuntimeSetup(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages without Equinox extension registry.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �runtimeSetup.simpleName� extends �runtimeGenSetup� {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public static void doSetup() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("new �runtimeSetup.simpleName�().createInjectorAndDoEMFRegistration();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_runtimeSetup_1, _client_1);
    }
  }

  @Deprecated
  private static void addBackwardsCompabibleImportsTo(final IXtextGeneratorLanguage langConfig, final GeneratedJavaFileAccess file) {
    Set<TypeReference> _imports = langConfig.getRuntimeGenSetup().getImports();
    for (final TypeReference type : _imports) {
      file.importType(type);
    }
  }

  public JavaFileAccess createRuntimeGenSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getRuntimeGenSetup(it));
    XtextGeneratorTemplates.addBackwardsCompabibleImportsTo(langConfig, file);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class �runtimeGenSetup.simpleName� implements �ISetup� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �Injector� createInjectorAndDoEMFRegistration() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR usedGrammar : langConfig.grammar.usedGrammars�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�usedGrammar.runtimeSetup�.doSetup();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF langConfig.grammar.usedGrammars.isEmpty�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("// register default ePackages");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (!�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"ecore\"))");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("\"ecore\", new �\'org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl\'.typeRef�());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (!�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xmi\"))");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("\"xmi\", new �\'org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl\'.typeRef�());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (!�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(\"xtextbin\"))");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�Resource.typeRef�.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("\"xtextbin\", new �BinaryGrammarResourceFactoryImpl�());");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (!�EPackage.typeRef�.Registry.INSTANCE.containsKey(�XtextPackage�.eNS_URI))");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�EPackage.typeRef�.Registry.INSTANCE.put(�XtextPackage�.eNS_URI, �XtextPackage�.eINSTANCE);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDIF�");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�Injector� injector = createInjector();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("register(injector);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return injector;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �Injector� createInjector() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return �Guice�.createInjector(new �runtimeModule�());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void register(�Injector� injector) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR reg : langConfig.runtimeGenSetup.registrations�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�reg�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    return file;
  }

  private CharSequence getBindMethodName(final GuiceModuleAccess.Binding it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF !value.provider && value.statements.isEmpty");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�bind�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ELSEIF value.statements.isEmpty");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�provide�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ELSE");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�configure�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ENDIF");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("��key.name?.replace(\'.\', \'$\') ?: key.type.simpleMethodName");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("��IF value.expression !== null && !value.provider�ToInstance�ENDIF�");
    return _builder;
  }

  private String getSimpleMethodName(final TypeReference type) {
    String _join = IterableExtensions.join(type.getSimpleNames(), "$");
    final Function1<TypeReference, CharSequence> _function = (TypeReference it) -> {
      return this.getSimpleMethodName(it);
    };
    String _join_1 = IterableExtensions.<TypeReference>join(type.getTypeArguments(), "$", "$", "", _function);
    return (_join + _join_1);
  }

  private StringConcatenationClient createBindingMethod(final GuiceModuleAccess.Binding it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("�IF !value.provider && value.statements.isEmpty�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// contributed by �contributedBy�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�IF key.singleton�@�SingletonBinding��IF key.eagerSingleton�(eager=true)�ENDIF��ENDIF�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �IF value.expression === null�Class<? extends �key.type�>�ELSE��key.type��ENDIF� �bindMethodName�() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return �IF value.expression !== null��value.expression��ELSE��value.type�.class�ENDIF�;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("�ELSEIF value.statements.isEmpty�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// contributed by �contributedBy�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�IF key.singleton�@�SingletonBinding��IF key.eagerSingleton�(eager=true)�ENDIF��ENDIF�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �IF value.expression===null�Class<? extends �Provider�<? extends �key.type�>>�ELSE��Provider�<? extends �key.type�>�ENDIF� �bindMethodName�() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return �IF value.expression!==null��value.expression��ELSE��value.type�.class�ENDIF�;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("�ELSE�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// contributed by �contributedBy�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void �bindMethodName�(�Binder� binder) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR statement : value.statements�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�statement�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("�ENDIF�");
        _builder.newLine();
      }
    };
    return _client;
  }

  public JavaFileAccess createRuntimeModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _runtimeModule = this.naming.getRuntimeModule(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register components to be used at runtime / without the Equinox extension registry.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �runtimeModule.simpleName� extends �runtimeGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_runtimeModule, _client);
    } else {
      TypeReference _runtimeModule_1 = this.naming.getRuntimeModule(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register components to be used at runtime / without the Equinox extension registry.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �runtimeModule.simpleName� extends �runtimeGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_runtimeModule_1, _client_1);
    }
  }

  public JavaFileAccess createRuntimeGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    TypeReference _superClass = langConfig.getRuntimeGenModule().getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _runtimeDefaultModule = this.naming.getRuntimeDefaultModule(it);
      _elvis = _runtimeDefaultModule;
    }
    final TypeReference superClass = _elvis;
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getRuntimeGenModule(it));
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link �runtimeModule.simpleName�}.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class �runtimeGenModule.simpleName� extends �superClass� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �Properties� properties = null;");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configure(�Binder� binder) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("properties = tryBindProperties(binder, \"�langConfig.grammar.name.replaceAll(\"\\\\.\",\"/\")�.properties\");");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.configure(binder);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureLanguageName(�Binder� binder) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(�Names�.named(�Constants�.LANGUAGE_NAME)).toInstance(\"�langConfig.grammar.name�\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void configureFileExtensions(�Binder� binder) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("binder.bind(String.class).annotatedWith(�Names�.named(�Constants�.FILE_EXTENSIONS)).toInstance(\"�langConfig.fileExtensions.join(\',\')�\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR binding : langConfig.runtimeGenModule.bindings�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�binding.createBindingMethod�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }

  public JavaFileAccess createIdeModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _genericIdeModule = this.naming.getGenericIdeModule(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register ide components.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �genericIdeModule.simpleName� extends �genericIdeGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_genericIdeModule, _client);
    } else {
      TypeReference _genericIdeModule_1 = this.naming.getGenericIdeModule(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register ide components.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �genericIdeModule.simpleName� extends �genericIdeGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_genericIdeModule_1, _client_1);
    }
  }

  public JavaFileAccess createIdeGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    TypeReference _superClass = langConfig.getIdeGenModule().getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _genericIdeDefaultModule = this.naming.getGenericIdeDefaultModule(it);
      _elvis = _genericIdeDefaultModule;
    }
    final TypeReference superClass = _elvis;
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getGenericIdeGenModule(it));
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link �genericIdeModule.simpleName�}.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class �genericIdeGenModule.simpleName� extends �superClass� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR binding : langConfig.ideGenModule.bindings�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�binding.createBindingMethod�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }

  public JavaFileAccess createIdeSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _genericIdeSetup = this.naming.getGenericIdeSetup(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages as language servers.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �genericIdeSetup.simpleName� extends �runtimeSetup� {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("override createInjector() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�Guice�.createInjector(�Modules2�.mixin(new �runtimeModule�, new �genericIdeModule�))");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_genericIdeSetup, _client);
    } else {
      TypeReference _genericIdeSetup_1 = this.naming.getGenericIdeSetup(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages as language servers.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �genericIdeSetup.simpleName� extends �runtimeSetup� {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public �Injector� createInjector() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return �Guice�.createInjector(�Modules2�.mixin(new �runtimeModule�(), new �genericIdeModule�()));");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_genericIdeSetup_1, _client_1);
    }
  }

  public JavaFileAccess createEclipsePluginModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _eclipsePluginModule = this.naming.getEclipsePluginModule(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register components to be used within the Eclipse IDE.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("@�FinalFieldsConstructor�");
          _builder.newLine();
          _builder.append("class �eclipsePluginModule.simpleName� extends �eclipsePluginGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_eclipsePluginModule, _client);
    } else {
      TypeReference _eclipsePluginModule_1 = this.naming.getEclipsePluginModule(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register components to be used within the Eclipse IDE.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �eclipsePluginModule.simpleName� extends �eclipsePluginGenModule� {");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public �eclipsePluginModule.simpleName�(�\'org.eclipse.ui.plugin.AbstractUIPlugin\'.typeRef� plugin) {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("super(plugin);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_eclipsePluginModule_1, _client_1);
    }
  }

  public JavaFileAccess createEclipsePluginGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    TypeReference _superClass = langConfig.getEclipsePluginGenModule().getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _eclipsePluginDefaultModule = this.naming.getEclipsePluginDefaultModule(it);
      _elvis = _eclipsePluginDefaultModule;
    }
    final TypeReference superClass = _elvis;
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getEclipsePluginGenModule(it));
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link �eclipsePluginModule.simpleName�}.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class �eclipsePluginGenModule.simpleName� extends �superClass� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �eclipsePluginGenModule.simpleName�(�\'org.eclipse.ui.plugin.AbstractUIPlugin\'.typeRef� plugin) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super(plugin);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR binding : langConfig.eclipsePluginGenModule.bindings�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�binding.createBindingMethod�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }

  public JavaFileAccess createWebModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _webModule = this.naming.getWebModule(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register additional components to be used within the web application.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �webModule.simpleName� extends �webGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_webModule, _client);
    } else {
      TypeReference _webModule_1 = this.naming.getWebModule(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Use this class to register additional components to be used within the web application.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �webModule.simpleName� extends �webGenModule� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_webModule_1, _client_1);
    }
  }

  public JavaFileAccess createWebGenModule(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    TypeReference _elvis = null;
    TypeReference _superClass = langConfig.getWebGenModule().getSuperClass();
    if (_superClass != null) {
      _elvis = _superClass;
    } else {
      TypeReference _webDefaultModule = this.naming.getWebDefaultModule(it);
      _elvis = _webDefaultModule;
    }
    final TypeReference superClass = _elvis;
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getWebGenModule(it));
    file.setImportNestedTypeThreshold(JavaFileAccess.DONT_IMPORT_NESTED_TYPES);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* Manual modifications go to {@link �webModule.simpleName�}.");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    List<IClassAnnotation> _annotations = file.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public abstract class �webGenModule.simpleName� extends �superClass� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR binding : langConfig.webGenModule.bindings�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�binding.createBindingMethod�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    file.setMarkedAsGenerated(true);
    return file;
  }

  public JavaFileAccess createWebSetup(final IXtextGeneratorLanguage langConfig) {
    final Grammar it = langConfig.getGrammar();
    boolean _isPreferXtendStubs = this.codeConfig.isPreferXtendStubs();
    if (_isPreferXtendStubs) {
      TypeReference _webSetup = this.naming.getWebSetup(it);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages in web applications.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("class �webSetup.simpleName� extends �runtimeSetup� {");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("override �Injector� createInjector() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return �Guice�.createInjector(�Modules2�.mixin(new �runtimeModule�, new �genericIdeModule�, new �webModule�))");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createXtendFile(_webSetup, _client);
    } else {
      TypeReference _webSetup_1 = this.naming.getWebSetup(it);
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Initialization support for running Xtext languages in web applications.");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("public class �webSetup.simpleName� extends �runtimeSetup� {");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public �Injector� createInjector() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return �Guice�.createInjector(�Modules2�.mixin(new �runtimeModule�(), new �genericIdeModule�(), new �webModule�()));");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      return this.fileAccessFactory.createJavaFile(_webSetup_1, _client_1);
    }
  }

  public JavaFileAccess createEclipsePluginExecutableExtensionFactory(final IXtextGeneratorLanguage langConfig, final IXtextGeneratorLanguage activatorLanguage) {
    final Grammar grammar = langConfig.getGrammar();
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(this.naming.getEclipsePluginExecutableExtensionFactory(grammar));
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class was generated. Customizations should only happen in a newly");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* introduced subclass. ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class �grammar.eclipsePluginExecutableExtensionFactory.simpleName� extends �\'org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory\'.typeRef� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �\'org.osgi.framework.Bundle\'.typeRef� getBundle() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return �\'org.osgi.framework.FrameworkUtil\'.typeRef�.getBundle(�eclipsePluginActivator�.class);");
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
        _builder.append("protected �Injector� getInjector() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�eclipsePluginActivator� activator = �eclipsePluginActivator�.getInstance();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return activator != null ? activator.getInjector(�eclipsePluginActivator�.�langConfig.grammar.name.toUpperCase.replaceAll(\'\\\\.\', \'_\')�) : null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    return file;
  }

  public JavaFileAccess createEclipsePluginActivator(final IXtextProjectConfig projectConfig, final List<? extends IXtextGeneratorLanguage> langConfigs) {
    final TypeReference activator = this.naming.getEclipsePluginActivator();
    final GeneratedJavaFileAccess file = this.fileAccessFactory.createGeneratedJavaFile(activator);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* This class was generated. Customizations should only happen in a newly");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* introduced subclass. ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
      }
    };
    file.setTypeComment(_client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class �activator.simpleName� extends �\'org.eclipse.ui.plugin.AbstractUIPlugin\'.typeRef� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static final String PLUGIN_ID = \"�projectConfig.eclipsePlugin.name�\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR lang : langConfigs�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public static final String �lang.grammar.name.toUpperCase.replaceAll(\'\\\\.\', \'_\')� = \"�lang.grammar.name�\";");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final �Logger� logger = �Logger�.getLogger(�activator.simpleName�.class);");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static �activator.simpleName� INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private �Map�<String, �Injector�> injectors = �Collections�.synchronizedMap(�Maps�.<String, �Injector�> newHashMapWithExpectedSize(1));");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void start(�\'org.osgi.framework.BundleContext\'.typeRef� context) throws Exception {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.start(context);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = this;");
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
        _builder.append("public void stop(�\'org.osgi.framework.BundleContext\'.typeRef� context) throws Exception {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("injectors.clear();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("INSTANCE = null;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.stop(context);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static �activator.simpleName� getInstance() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public �Injector� getInjector(String language) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("synchronized (injectors) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�Injector� injector = injectors.get(language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (injector == null) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("injectors.put(language, injector = createInjector(language));");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return injector;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �Injector� createInjector(String language) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�Module� runtimeModule = getRuntimeModule(language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�Module� sharedStateModule = getSharedStateModule();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�Module� uiModule = getUiModule(language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�Module� mergedModule = �Modules2�.mixin(runtimeModule, sharedStateModule, uiModule);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return �Guice�.createInjector(mergedModule);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("} catch (Exception e) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(\"Failed to create injector for \" + language);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("logger.error(e.getMessage(), e);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("throw new RuntimeException(\"Failed to create injector for \" + language, e);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �Module� getRuntimeModule(String grammar) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR lang : langConfigs�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (�lang.grammar.name.toUpperCase.replaceAll(\'\\\\.\', \'_\')�.equals(grammar)) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return new �getRuntimeModule(lang.grammar)�();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �Module� getUiModule(String grammar) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR lang : langConfigs�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (�lang.grammar.name.toUpperCase.replaceAll(\'\\\\.\', \'_\')�.equals(grammar)) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("return new �getEclipsePluginModule(lang.grammar)�(this);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("throw new IllegalArgumentException(grammar);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �Module� getSharedStateModule() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return new �\'org.eclipse.xtext.ui.shared.SharedStateModule\'.typeRef�();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client_1);
    return file;
  }

  public TextFileAccess createMetaInfServices(final List<? extends IXtextGeneratorLanguage> languageConfigs) {
    TextFileAccess _xblockexpression = null;
    {
      final TextFileAccess file = new TextFileAccess();
      file.setPath("META-INF/services/org.eclipse.xtext.ISetup");
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("�FOR lang : languageConfigs�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�naming.getGenericIdeSetup(lang.grammar)�");
          _builder.newLine();
          _builder.append("�ENDFOR�");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
}
