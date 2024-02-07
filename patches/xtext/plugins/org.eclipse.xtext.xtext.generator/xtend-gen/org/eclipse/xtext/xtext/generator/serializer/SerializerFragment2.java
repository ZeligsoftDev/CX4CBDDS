/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation;
import org.eclipse.xtext.xtext.generator.model.annotations.SuppressWarningsAnnotation;
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2;
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector;

@SuppressWarnings("all")
public class SerializerFragment2 extends AbstractStubGeneratingFragment {
  private static final Logger LOG = LogManager.getLogger(SerializerFragment2.class);

  private static <K extends Object, V extends Object> Map<K, V> toMap(final Iterable<Pair<K, V>> items) {
    LinkedHashMap<K, V> _xblockexpression = null;
    {
      final LinkedHashMap<K, V> result = CollectionLiterals.<K, V>newLinkedHashMap();
      for (final Pair<K, V> i : items) {
        result.put(i.getKey(), i.getValue());
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;

  @Inject
  @Extension
  private SemanticSequencerExtensions _semanticSequencerExtensions;

  @Inject
  @Extension
  private SyntacticSequencerExtensions _syntacticSequencerExtensions;

  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;

  @Inject
  @Extension
  private SyntheticTerminalDetector syntheticTerminalDetector;

  @Inject
  @Extension
  private IGrammarConstraintProvider _iGrammarConstraintProvider;

  @Inject
  private DebugGraphGenerator debugGraphGenerator;

  @Inject
  private FileAccessFactory fileAccessFactory;

  @Accessors
  private boolean generateDebugData = false;

  @Accessors
  private boolean generateSupportForDeprecatedContextEObject = false;

  private boolean detectSyntheticTerminals = true;

  /**
   * Set to false if synthetic terminal should be ignored. Synthetic terminals
   * have the form {@code terminal ABC: 'synthetic:ABC';} in the grammar
   * and require a customized {@link AbstractSplittingTokenSource token source}.
   */
  public void setDetectSyntheticTerminals(final boolean detectSyntheticTerminals) {
    this.detectSyntheticTerminals = detectSyntheticTerminals;
  }

  protected String getSerializerBasePackage(final Grammar grammar) {
    String _runtimeBasePackage = this._xtextGeneratorNaming.getRuntimeBasePackage(grammar);
    return (_runtimeBasePackage + ".serializer");
  }

  protected TypeReference getSemanticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "SemanticSequencer");
    return new TypeReference(_serializerBasePackage, _plus);
  }

  protected TypeReference getSyntacticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "SyntacticSequencer");
    return new TypeReference(_serializerBasePackage, _plus);
  }

  protected TypeReference getAbstractSemanticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "SemanticSequencer");
    return new TypeReference(_serializerBasePackage, _plus_1);
  }

  protected TypeReference getAbstractSyntacticSequencerClass(final Grammar grammar) {
    String _serializerBasePackage = this.getSerializerBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "SyntacticSequencer");
    return new TypeReference(_serializerBasePackage, _plus_1);
  }

  protected String getGrammarConstraintsPath(final Grammar grammar) {
    String _replace = this.getSerializerBasePackage(grammar).replace(".", "/");
    String _plus = (_replace + "/");
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "GrammarConstraints.txt");
  }

  @Override
  public void generate() {
    new GuiceModuleAccess.BindingFactory().addTypeToType(TypeReference.typeRef(ISemanticSequencer.class), this.getSemanticSequencerClass(this.getGrammar())).addTypeToType(TypeReference.typeRef(ISyntacticSequencer.class), this.getSyntacticSequencerClass(this.getGrammar())).addTypeToType(TypeReference.typeRef(ISerializer.class), TypeReference.typeRef(Serializer.class)).contributeTo(this.getLanguage().getRuntimeGenModule());
    ManifestAccess _manifest = this.getProjectConfig().getRuntime().getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      Set<String> _exportedPackages = this.getProjectConfig().getRuntime().getManifest().getExportedPackages();
      String _serializerBasePackage = this.getSerializerBasePackage(this.getGrammar());
      _exportedPackages.add(_serializerBasePackage);
      Set<String> _requiredBundles = this.getProjectConfig().getRuntime().getManifest().getRequiredBundles();
      String _xbaseLibVersionLowerBound = this.getProjectConfig().getRuntime().getXbaseLibVersionLowerBound();
      String _plus = ("org.eclipse.xtext.xbase.lib;bundle-version=\"" + _xbaseLibVersionLowerBound);
      String _plus_1 = (_plus + "\"");
      _requiredBundles.add(_plus_1);
    }
    this.generateAbstractSemanticSequencer();
    this.generateAbstractSyntacticSequencer();
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      this.generateSemanticSequencer();
      this.generateSyntacticSequencer();
    }
    if (this.generateDebugData) {
      this.generateGrammarConstraints();
      Iterable<Pair<String, String>> _generateDebugGraphs = this.debugGraphGenerator.generateDebugGraphs();
      for (final Pair<String, String> fileToContent : _generateDebugGraphs) {
        this.getProjectConfig().getRuntime().getSrcGen().generateFile(fileToContent.getKey(), fileToContent.getValue());
      }
    }
  }

  protected void generateSemanticSequencer() {
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      TypeReference _semanticSequencerClass = this.getSemanticSequencerClass(this.getGrammar());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class �grammar.semanticSequencerClass.simpleName� extends �grammar.abstractSemanticSequencerClass� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createXtendFile(_semanticSequencerClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
    } else {
      TypeReference _semanticSequencerClass_1 = this.getSemanticSequencerClass(this.getGrammar());
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class �grammar.semanticSequencerClass.simpleName� extends �grammar.abstractSemanticSequencerClass� {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createJavaFile(_semanticSequencerClass_1, _client_1).writeTo(this.getProjectConfig().getRuntime().getSrc());
    }
  }

  private CharSequence unassignedCalledTokenRuleName(final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get�rule.name�Token");
    return _builder;
  }

  protected void generateSyntacticSequencer() {
    boolean _isGenerateXtendStub = this.isGenerateXtendStub();
    if (_isGenerateXtendStub) {
      TypeReference _syntacticSequencerClass = this.getSyntacticSequencerClass(this.getGrammar());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("class �grammar.syntacticSequencerClass.simpleName� extends �grammar.abstractSyntacticSequencerClass� {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�IF detectSyntheticTerminals�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�FOR rule : GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]�");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t\t\t ");
          _builder.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
          _builder.newLine();
          _builder.append("\t\t\t ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("// TODO review the concrete syntax for the terminal");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("override �rule.unassignedCalledTokenRuleName�(�EObject� semanticObject, �RuleCall� ruleCall, �INode� node) {");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("return \'\'");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ENDIF�");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createXtendFile(_syntacticSequencerClass, _client).writeTo(this.getProjectConfig().getRuntime().getSrc());
    } else {
      TypeReference _syntacticSequencerClass_1 = this.getSyntacticSequencerClass(this.getGrammar());
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class �grammar.syntacticSequencerClass.simpleName� extends �grammar.abstractSyntacticSequencerClass� {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�IF detectSyntheticTerminals�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�FOR rule : GrammarUtil.allTerminalRules(grammar).filter[isSyntheticTerminalRule]�");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("/**");
          _builder.newLine();
          _builder.append("\t\t\t ");
          _builder.append("* Stub implementation for a synthetic terminal rule. Defaults to the empty string.");
          _builder.newLine();
          _builder.append("\t\t\t ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("// TODO review the concrete syntax for the terminal");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("public String �rule.unassignedCalledTokenRuleName�(�EObject� semanticObject, �RuleCall� ruleCall, �INode� node) {");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("return \"\";");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ENDIF�");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this.fileAccessFactory.createJavaFile(_syntacticSequencerClass_1, _client_1).writeTo(this.getProjectConfig().getRuntime().getSrc());
    }
  }

  protected void generateAbstractSemanticSequencer() {
    final Collection<IGrammarConstraintProvider.IConstraint> localConstraints = this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar());
    final Collection<IGrammarConstraintProvider.IConstraint> superConstraints = this._semanticSequencerExtensions.getGrammarConstraints(this._semanticSequencerExtensions.getSuperGrammar(this.getGrammar()));
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      return Boolean.valueOf(((it.getType() != null) && (!superConstraints.contains(it))));
    };
    final Set<IGrammarConstraintProvider.IConstraint> newLocalConstraints = IterableExtensions.<IGrammarConstraintProvider.IConstraint>toSet(IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(localConstraints, _function));
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getAbstractSemanticSequencerClass(this.getGrammar());
    } else {
      _xifexpression = this.getSemanticSequencerClass(this.getGrammar());
    }
    final TypeReference clazz = _xifexpression;
    TypeReference _xifexpression_1 = null;
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function_1 = (IGrammarConstraintProvider.IConstraint it) -> {
      return Boolean.valueOf(superConstraints.contains(it));
    };
    boolean _exists = IterableExtensions.<IGrammarConstraintProvider.IConstraint>exists(localConstraints, _function_1);
    if (_exists) {
      _xifexpression_1 = this.getSemanticSequencerClass(IterableExtensions.<Grammar>head(this.getGrammar().getUsedGrammars()));
    } else {
      _xifexpression_1 = TypeReference.typeRef(AbstractDelegatingSemanticSequencer.class);
    }
    final TypeReference superClazz = _xifexpression_1;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    javaFile.setResourceSet(this.getLanguage().getResourceSet());
    final HashSet<Object> methodSignatures = CollectionLiterals.<Object>newHashSet();
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public �IF isGenerateStub�abstract �ENDIF�class �clazz.simpleName� extends �superClazz� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@�Inject�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private �grammar.grammarAccess� grammarAccess;");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�genMethodCreateSequence�");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR c : newLocalConstraints.sort�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF methodSignatures.add(c.simpleName -> c.type)�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�genMethodSequence(c)�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ELSE�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�LOG.warn(\"Skipped generating duplicate method in \" + clazz.simpleName)�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�genMethodSequenceComment(c)�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDIF�");
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
    javaFile.setContent(_client);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }

  private Iterable<EPackage> getAccessedPackages() {
    final Function1<IGrammarConstraintProvider.IConstraint, Boolean> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      EClass _type = it.getType();
      return Boolean.valueOf((_type != null));
    };
    final Function1<IGrammarConstraintProvider.IConstraint, EPackage> _function_1 = (IGrammarConstraintProvider.IConstraint it) -> {
      return it.getType().getEPackage();
    };
    final Function1<EPackage, String> _function_2 = (EPackage it) -> {
      return it.getName();
    };
    return IterableExtensions.<EPackage, String>sortBy(IterableExtensions.<EPackage>toSet(IterableExtensions.<IGrammarConstraintProvider.IConstraint, EPackage>map(IterableExtensions.<IGrammarConstraintProvider.IConstraint>filter(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar()), _function), _function_1)), _function_2);
  }

  private Iterable<EClass> getAccessedClasses(final EPackage pkg) {
    final Function1<IGrammarConstraintProvider.IConstraint, EClass> _function = (IGrammarConstraintProvider.IConstraint it) -> {
      return it.getType();
    };
    final Function1<EClass, Boolean> _function_1 = (EClass it) -> {
      return Boolean.valueOf(((it != null) && Objects.equal(it.getEPackage(), pkg)));
    };
    final Function1<EClass, String> _function_2 = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(IterableExtensions.<EClass>toSet(IterableExtensions.<EClass>filter(IterableExtensions.<IGrammarConstraintProvider.IConstraint, EClass>map(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar()), _function), _function_1)), _function_2);
  }

  private StringConcatenationClient genMethodCreateSequence() {
    StringConcatenationClient _xblockexpression = null;
    {
      final Function1<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>> _function = (IGrammarConstraintProvider.IConstraint it) -> {
        return Pair.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>of(it, it);
      };
      final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints = SerializerFragment2.<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>toMap(IterableExtensions.<IGrammarConstraintProvider.IConstraint, Pair<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint>>map(this._semanticSequencerExtensions.getGrammarConstraints(this._semanticSequencerExtensions.getSuperGrammar(this.getGrammar())), _function));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("public void sequence(�ISerializationContext� context, �EObject� semanticObject) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�EPackage� epackage = semanticObject.eClass().getEPackage();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ParserRule� rule = context.getParserRule();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�Action� action = context.getAssignedAction();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�Set�<�Parameter�> parameters = context.getEnabledBooleanParameters();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�FOR pkg : accessedPackages.indexed�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�IF pkg.key > 0�else �ENDIF�if (epackage == �pkg.value�.�packageLiteral�)");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("switch (semanticObject.eClass().getClassifierID()) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("�FOR type : pkg.value.accessedClasses�");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("case �pkg.value�.�type.getIntLiteral(language.resourceSet)�:");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("�genMethodCreateSequenceCaseBody(superConstraints, type)�");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if (errorAcceptor != null)");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient genParameterCondition(final ISerializationContext context, final IGrammarConstraintProvider.IConstraint constraint) {
    StringConcatenationClient _xblockexpression = null;
    {
      final Set<Parameter> values = context.getEnabledBooleanParameters();
      StringConcatenationClient _xifexpression = null;
      boolean _isEmpty = values.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("�ImmutableSet�.of(�values.map[\"grammarAccess.\"+gaAccessor].join(\", \")�).equals(parameters)");
          }
        };
        _xifexpression = _client;
      } else {
        StringConcatenationClient _xifexpression_1 = null;
        final Function1<ISerializationContext, Boolean> _function = (ISerializationContext it) -> {
          boolean _isEmpty_1 = ((SerializationContext) it).getDeclaredParameters().isEmpty();
          return Boolean.valueOf((!_isEmpty_1));
        };
        boolean _exists = IterableExtensions.<ISerializationContext>exists(constraint.getContexts(), _function);
        if (_exists) {
          StringConcatenationClient _client_1 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("parameters.isEmpty()");
            }
          };
          _xifexpression_1 = _client_1;
        } else {
          StringConcatenationClient _client_2 = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            }
          };
          _xifexpression_1 = _client_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient genMethodCreateSequenceCaseBody(final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints, final EClass type) {
    StringConcatenationClient _xblockexpression = null;
    {
      final Function1<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>, String> _function = (Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> it) -> {
        return it.getKey().getName();
      };
      final List<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>> contexts = IterableExtensions.<Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>>, String>sortBy(this._semanticSequencerExtensions.getGrammarConstraints(this.getGrammar(), type).entrySet(), _function);
      final LinkedHashMultimap<EObject, IGrammarConstraintProvider.IConstraint> context2constraint = LinkedHashMultimap.<EObject, IGrammarConstraintProvider.IConstraint>create();
      for (final Map.Entry<IGrammarConstraintProvider.IConstraint, List<ISerializationContext>> e : contexts) {
        List<ISerializationContext> _value = e.getValue();
        for (final ISerializationContext ctx : _value) {
          context2constraint.put(((SerializationContext) ctx).getActionOrRule(), e.getKey());
        }
      }
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("�IF contexts.size > 1�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�FOR ctx : contexts.indexed�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�IF ctx.key > 0�else �ENDIF�if (�genCondition(ctx.value.value, ctx.value.key, context2constraint)�) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("�genMethodCreateSequenceCall(superConstraints, type, ctx.value.key)�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("else break;");
          _builder.newLine();
          _builder.append("�ELSEIF contexts.size == 1�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�genMethodCreateSequenceCall(superConstraints, type, contexts.head.key)�");
          _builder.newLine();
          _builder.append("�ELSE�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("// error, no contexts. ");
          _builder.newLine();
          _builder.append("�ENDIF�");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient genCondition(final List<ISerializationContext> contexts, final IGrammarConstraintProvider.IConstraint constraint, final Multimap<EObject, IGrammarConstraintProvider.IConstraint> ctx2ctr) {
    StringConcatenationClient _xblockexpression = null;
    {
      final List<ISerializationContext> sorted = IterableExtensions.<ISerializationContext>sort(contexts);
      final LinkedHashMultimap<EObject, ISerializationContext> index = LinkedHashMultimap.<EObject, ISerializationContext>create();
      final Consumer<ISerializationContext> _function = (ISerializationContext it) -> {
        index.put(this.getContextObject(it), it);
      };
      sorted.forEach(_function);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("�FOR obj : index.keySet SEPARATOR \"\\n\\t\\t|| \"��obj.genObjectSelector��IF ctx2ctr.get(obj).size > 1��obj.genParameterSelector(index.get(obj), constraint)��ENDIF��ENDFOR�");
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient genObjectSelector(final EObject obj) {
    StringConcatenationClient _switchResult = null;
    boolean _matched = false;
    if (obj instanceof Action) {
      _matched=true;
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("action == grammarAccess.�obj.gaAccessor�");
        }
      };
      _switchResult = _client;
    }
    if (!_matched) {
      if (obj instanceof ParserRule) {
        _matched=true;
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("rule == grammarAccess.�obj.gaAccessor�");
          }
        };
        _switchResult = _client;
      }
    }
    return _switchResult;
  }

  private StringConcatenationClient genParameterSelector(final EObject obj, final Set<ISerializationContext> contexts, final IGrammarConstraintProvider.IConstraint constraint) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(" ");
        _builder.append("&& (�FOR context : contexts SEPARATOR \"\\n\\t\\t\\t|| \"��context.genParameterCondition(constraint)��ENDFOR�)");
      }
    };
    return _client;
  }

  private EObject getContextObject(final ISerializationContext context) {
    EObject _elvis = null;
    Action _assignedAction = context.getAssignedAction();
    if (_assignedAction != null) {
      _elvis = _assignedAction;
    } else {
      ParserRule _parserRule = context.getParserRule();
      _elvis = _parserRule;
    }
    return _elvis;
  }

  private StringConcatenationClient genMethodCreateSequenceCall(final Map<IGrammarConstraintProvider.IConstraint, IGrammarConstraintProvider.IConstraint> superConstraints, final EClass type, final IGrammarConstraintProvider.IConstraint key) {
    StringConcatenationClient _xblockexpression = null;
    {
      final IGrammarConstraintProvider.IConstraint superConstraint = superConstraints.get(key);
      IGrammarConstraintProvider.IConstraint _elvis = null;
      if (superConstraint != null) {
        _elvis = superConstraint;
      } else {
        _elvis = key;
      }
      final IGrammarConstraintProvider.IConstraint constraint = _elvis;
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("sequence_�constraint.simpleName�(context, (�type�) semanticObject); ");
          _builder.newLine();
          _builder.append("return; ");
          _builder.newLine();
        }
      };
      _xblockexpression = _client;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient genMethodSequenceComment(final IGrammarConstraintProvider.IConstraint c) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("// This method is commented out because it has the same signature as another method in this class.");
        _builder.newLine();
        _builder.append("// This is probably a bug in Xtext\'s serializer, please report it here: ");
        _builder.newLine();
        _builder.append("// https://bugs.eclipse.org/bugs/enter_bug.cgi?product=TMF");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// Contexts:");
        _builder.newLine();
        _builder.append("//     �c.contexts.sort.join(\"\\n\").replaceAll(\"\\\\n\",\"\\n//     \")�");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// Constraint:");
        _builder.newLine();
        _builder.append("//     �IF c.body === null�{�c.type.name�}�ELSE��c.body.toString.replaceAll(\"\\\\n\",\"\\n//     \")��ENDIF�");
        _builder.newLine();
        _builder.append("//");
        _builder.newLine();
        _builder.append("// protected void sequence_�c.simpleName�(�ISerializationContext� context, �c.type� semanticObject) { }");
        _builder.newLine();
      }
    };
    return _client;
  }

  private StringConcatenationClient genMethodSequence(final IGrammarConstraintProvider.IConstraint c) {
    StringConcatenationClient _xblockexpression = null;
    {
      final ResourceSet rs = this.getLanguage().getResourceSet();
      StringConcatenationClient _xifexpression = null;
      boolean _isEObjectExtension = GenModelUtil2.getGenClass(c.getType(), rs).isEObjectExtension();
      if (_isEObjectExtension) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          }
        };
        _xifexpression = _client;
      } else {
        StringConcatenationClient _client_1 = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("(�EObject�) ");
          }
        };
        _xifexpression = _client_1;
      }
      final StringConcatenationClient cast = _xifexpression;
      final List<ISemanticSequencerNfaProvider.ISemState> states = this._semanticSequencerExtensions.getLinearListOfMandatoryAssignments(c);
      StringConcatenationClient _client_2 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* <pre>");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Contexts:");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*     �c.contexts.sort.join(\"\\n\").replaceAll(\"\\\\n\",\"\\n*     \")�");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Constraint:");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*     �IF c.body === null�{�c.type.name�}�ELSE��c.body.toString.replaceAll(\"\\\\n\",\"\\n*     \").replaceAll(\"<\",\"&lt;\").replaceAll(\">\", \"&gt;\")��ENDIF�");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* </pre>");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("protected void sequence_�c.simpleName�(�ISerializationContext� context, �c.type� semanticObject) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�IF states !== null�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (errorAcceptor != null) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("�FOR s : states�");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("if (transientValues.isValueTransient(�cast�semanticObject, �s.feature.EContainingClass.EPackage�.�s.feature.getFeatureLiteral(rs)�) == �ITransientValueService.ValueTransient�.YES)");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(�cast�semanticObject, �s.feature.EContainingClass.EPackage�.�s.feature.getFeatureLiteral(rs)�));");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�SequenceFeeder� feeder = createSequencerFeeder(context, �cast�semanticObject);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�FOR f: states�");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("feeder.accept(grammarAccess.�f.assignedGrammarElement.gaAccessor()�, semanticObject.�f.feature.getUnresolvingGetAccessor(rs)�);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("�ENDFOR�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("feeder.finish();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ELSE�");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("genericSequencer.createSequence(context, �cast�semanticObject);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("�ENDIF�");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("�IF generateSupportForDeprecatedContextEObject�");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Deprecated");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void sequence_�c.simpleName�(�EObject� context, �c.type� semanticObject) {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("sequence_�c.simpleName�(createContext(context, semanticObject), semanticObject);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("�ENDIF�");
          _builder.newLine();
        }
      };
      _xblockexpression = _client_2;
    }
    return _xblockexpression;
  }

  private StringConcatenationClient getUnresolvingGetAccessor(final EStructuralFeature feature, final ResourceSet resourceSet) {
    final GenFeature genFeature = GenModelUtil2.getGenFeature(feature, resourceSet);
    boolean _isResolveProxies = genFeature.isResolveProxies();
    if (_isResolveProxies) {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("eGet(�genFeature.genPackage.getEcorePackage�.�getFeatureLiteral(genFeature, resourceSet)�, false)");
        }
      };
      return _client;
    } else {
      StringConcatenationClient _client_1 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("�getGetAccessor(genFeature, resourceSet)�()");
        }
      };
      return _client_1;
    }
  }

  protected void generateAbstractSyntacticSequencer() {
    TypeReference _xifexpression = null;
    boolean _isGenerateStub = this.isGenerateStub();
    if (_isGenerateStub) {
      _xifexpression = this.getAbstractSyntacticSequencerClass(this.getGrammar());
    } else {
      _xifexpression = this.getSyntacticSequencerClass(this.getGrammar());
    }
    final TypeReference clazz = _xifexpression;
    final GeneratedJavaFileAccess javaFile = this.fileAccessFactory.createGeneratedJavaFile(clazz);
    javaFile.setResourceSet(this.getLanguage().getResourceSet());
    final List<EqualAmbiguousTransitions> elements = this._syntacticSequencerExtensions.getAllAmbiguousTransitionsBySyntax();
    final Iterable<List<EqualAmbiguousTransitions>> partitions = Iterables.<EqualAmbiguousTransitions>partition(elements, 60);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public �IF isGenerateStub�abstract �ENDIF�class �clazz.simpleName� extends �AbstractSyntacticSequencer� {");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected �grammar.grammarAccess� grammarAccess;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR group : allAmbiguousTransitionsBySyntax�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("protected �new TypeReference (\'org.eclipse.xtext.serializer.analysis\', \'GrammarAlias.AbstractElementAlias\')� match_�group.identifier�;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@�Inject�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected void init(�IGrammarAccess� access) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("grammarAccess = (�grammar.grammarAccess�) access;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF partitions.size > 1�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�FOR partition : partitions.indexed�");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("init�partition.key�();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ELSE�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�FOR group : allAmbiguousTransitionsBySyntax�");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("match_�group.identifier� = �group.elementAlias.elementAliasToConstructor�;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDIF�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�IF partitions.size > 1�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR partition : partitions.indexed�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("private void init�partition.key�() {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�FOR element : partition.value�");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("match_�element.identifier� = �element.elementAlias.elementAliasToConstructor�;");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDIF�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�genGetUnassignedRuleCallTokens�");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR rule : unassignedCalledTokenRules SEPARATOR \"\\n\"�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�genGetUnassignedRuleCallToken(rule)�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�genEmitUnassignedTokens�");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR group : allAmbiguousTransitionsBySyntax�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* <pre>");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* Ambiguous syntax:");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("*     �group.elementAlias.toString.replace(\"\\n\", \"\\n *     \").replaceAll(\"<\",\"&lt;\").replaceAll(\">\", \"&gt;\")�");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("*");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* This ambiguous syntax occurs at:");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("�FOR trans : group.transitions.map[group.ambiguityInsideTransition(it).trim].toSet.sort�");
        _builder.newLine();
        _builder.append("\t\t \t");
        _builder.append("*     �trans.toString.replace(\"\\n\", \"\\n*     \").replaceAll(\"<\",\"&lt;\").replaceAll(\">\", \"&gt;\")�");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("* </pre>");
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("protected void emit_�group.identifier�(�EObject� semanticObject, �ISyntacticSequencerPDAProvider.ISynNavigable� transition, �List�<�INode�> nodes) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("acceptNodes(transition, nodes);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
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
    javaFile.setContent(_client);
    List<IClassAnnotation> _annotations = javaFile.getAnnotations();
    SuppressWarningsAnnotation _suppressWarningsAnnotation = new SuppressWarningsAnnotation();
    _annotations.add(_suppressWarningsAnnotation);
    javaFile.writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }

  private List<AbstractRule> unassignedCalledTokenRules() {
    final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
      return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
    };
    final Iterable<AbstractRule> rules = IterableExtensions.<AbstractRule>filter(GrammarUtil.allRules(this.getGrammar()), _function);
    final Function1<AbstractRule, Iterable<RuleCall>> _function_1 = (AbstractRule it) -> {
      final Function1<RuleCall, Boolean> _function_2 = (RuleCall it_1) -> {
        return Boolean.valueOf(this.isUnassignedRuleCall(it_1));
      };
      return IterableExtensions.<RuleCall>filter(GrammarUtil.containedRuleCalls(it), _function_2);
    };
    final Iterable<RuleCall> calls = Iterables.<RuleCall>concat(IterableExtensions.<AbstractRule, Iterable<RuleCall>>map(rules, _function_1));
    final Function1<RuleCall, AbstractRule> _function_2 = (RuleCall it) -> {
      return it.getRule();
    };
    final Function1<AbstractRule, String> _function_3 = (AbstractRule it) -> {
      return it.getName();
    };
    return IterableExtensions.<AbstractRule, String>sortBy(IterableExtensions.<AbstractRule>toSet(IterableExtensions.<RuleCall, AbstractRule>map(calls, _function_2)), _function_3);
  }

  private boolean isUnassignedRuleCall(final RuleCall c) {
    boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(c);
    if (_isEObjectRuleCall) {
      return false;
    }
    final Assignment ass = GrammarUtil.containingAssignment(c);
    return ((ass == null) || GrammarUtil.isBooleanAssignment(ass));
  }

  private String defaultValue(final AbstractElement ele, final AbstractRule rule, final Set<AbstractElement> visited) {
    String _switchResult = null;
    boolean _matched = false;
    boolean _add = visited.add(ele);
    boolean _not = (!_add);
    if (_not) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(ele);
      if (_isOptionalCardinality) {
        _matched=true;
        _switchResult = "";
      }
    }
    if (!_matched) {
      if (ele instanceof Alternatives) {
        _matched=true;
        _switchResult = this.defaultValue(IterableExtensions.<AbstractElement>head(((Alternatives)ele).getElements()), rule, visited);
      }
    }
    if (!_matched) {
      if (ele instanceof Group) {
        _matched=true;
        String _xifexpression = null;
        if ((rule instanceof TerminalRule)) {
          final Function1<AbstractElement, String> _function = (AbstractElement it) -> {
            return this.defaultValue(it, rule, visited);
          };
          final Function1<String, Boolean> _function_1 = (String it) -> {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
            return Boolean.valueOf((!_isNullOrEmpty));
          };
          _xifexpression = IterableExtensions.join(IterableExtensions.<String>filter(ListExtensions.<AbstractElement, String>map(((Group)ele).getElements(), _function), _function_1));
        } else {
          final Function1<AbstractElement, String> _function_2 = (AbstractElement it) -> {
            return this.defaultValue(it, rule, visited);
          };
          final Function1<String, Boolean> _function_3 = (String it) -> {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
            return Boolean.valueOf((!_isNullOrEmpty));
          };
          _xifexpression = IterableExtensions.join(IterableExtensions.<String>filter(ListExtensions.<AbstractElement, String>map(((Group)ele).getElements(), _function_2), _function_3), " ");
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (ele instanceof Keyword) {
        _matched=true;
        _switchResult = ((Keyword)ele).getValue();
      }
    }
    if (!_matched) {
      if (ele instanceof RuleCall) {
        _matched=true;
        _switchResult = this.defaultValue(((RuleCall)ele).getRule().getAlternatives(), ((RuleCall)ele).getRule(), visited);
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }

  private StringConcatenationClient genGetUnassignedRuleCallTokens() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("protected String getUnassignedRuleCallToken(�EObject� semanticObject, �RuleCall� ruleCall, �INode� node) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�FOR rule : unassignedCalledTokenRules.indexed�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF rule.key > 0�else �ENDIF�if (ruleCall.getRule() == grammarAccess.�rule.value.gaAccessor�)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return �rule.value.unassignedCalledTokenRuleName�(semanticObject, ruleCall, node);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return \"\";");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }

  private String textWithoutComments(final INode node) {
    String _switchResult = null;
    boolean _matched = false;
    if (node instanceof ILeafNode) {
      if (((!((ILeafNode)node).isHidden()) || (((ILeafNode)node).getText().trim().length() == 0))) {
        _matched=true;
        _switchResult = ((ILeafNode)node).getText();
      }
    }
    if (!_matched) {
      if (node instanceof ICompositeNode) {
        _matched=true;
        final Function1<INode, String> _function = (INode it) -> {
          return this.textWithoutComments(it);
        };
        _switchResult = IterableExtensions.join(IterableExtensions.<INode, String>map(((ICompositeNode)node).getChildren(), _function));
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }

  private StringConcatenationClient genGetUnassignedRuleCallToken(final AbstractRule rule) {
    if ((rule instanceof TerminalRule)) {
      if ((this.detectSyntheticTerminals && this.syntheticTerminalDetector.isSyntheticTerminalRule(((TerminalRule)rule)))) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("/**");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("* Synthetic terminal rule. The concrete syntax is to be specified by clients.");
            _builder.newLine();
            _builder.append("�IF !isGenerateStub� * Defaults to the empty string.�ENDIF�");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("protected �IF isGenerateStub�abstract �ENDIF�String �rule.unassignedCalledTokenRuleName�(�EObject� semanticObject, �RuleCall� ruleCall, �INode� node)�IF isGenerateStub�;�ELSE� { return \"\"; }�ENDIF�");
            _builder.newLine();
          }
        };
        return _client;
      }
    }
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* �NodeModelUtils.getNode(rule).textWithoutComments.trim.replace(\'\\n\', \'\\n* \').replace(\'*/\',\'*&#47;\')�");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("protected String �rule.unassignedCalledTokenRuleName�(�EObject� semanticObject, �RuleCall� ruleCall, �INode� node) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (node != null)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return getTokenText(node);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return \"�Strings.convertToJavaString(rule.alternatives.defaultValue(rule, newHashSet))�\";");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client_1;
  }

  private StringConcatenationClient genEmitUnassignedTokens() {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("protected void emitUnassignedTokens(�EObject� semanticObject, �ISynTransition� transition, �INode� fromNode, �INode� toNode) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (transition.getAmbiguousSyntaxes().isEmpty()) return;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�List�<�INode�> transitionNodes = collectNodes(fromNode, toNode);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (�AbstractElementAlias� syntax : transition.getAmbiguousSyntaxes()) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�List�<�INode�> syntaxNodes = getNodesFor(transitionNodes, syntax);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�FOR group : allAmbiguousTransitionsBySyntax.indexed�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�IF group.key > 0�else �ENDIF�if (match_�group.value.identifier�.equals(syntax))");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("emit_�group.value.identifier�(semanticObject, getLastNavigableState(), syntaxNodes);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDFOR�");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF !allAmbiguousTransitionsBySyntax.empty�else �ENDIF�acceptNodes(getLastNavigableState(), syntaxNodes);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }

  protected void generateGrammarConstraints() {
    String _grammarConstraintsPath = this.getGrammarConstraintsPath(this.getGrammar());
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("�FOR e : grammar.constraints.sortedCopy.values SEPARATOR \'\\n\'�");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("�e.contexts.join(\", \")�:");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�IF e.value.body === null�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("{�e.value.type?.name�};");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ELSE�");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("�e.value.body�;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("�ENDIF�");
        _builder.newLine();
        _builder.append("�ENDFOR�");
        _builder.newLine();
      }
    };
    this.fileAccessFactory.createTextFile(_grammarConstraintsPath, _client).writeTo(this.getProjectConfig().getRuntime().getSrcGen());
  }

  @Pure
  public boolean isGenerateDebugData() {
    return this.generateDebugData;
  }

  public void setGenerateDebugData(final boolean generateDebugData) {
    this.generateDebugData = generateDebugData;
  }

  @Pure
  public boolean isGenerateSupportForDeprecatedContextEObject() {
    return this.generateSupportForDeprecatedContextEObject;
  }

  public void setGenerateSupportForDeprecatedContextEObject(final boolean generateSupportForDeprecatedContextEObject) {
    this.generateSupportForDeprecatedContextEObject = generateSupportForDeprecatedContextEObject;
  }
}
