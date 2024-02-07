package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaUMLPackageTypeSelectUtilGenerator {
  @Inject
  @Extension
  private GenDomainModelExtensions _genDomainModelExtensions;

  @Inject
  @Extension
  private JavaNamingExtensions _javaNamingExtensions;

  @Inject
  @Extension
  private JavaImportExtensions _javaImportExtensions;

  public CharSequence generateJavaUMLPackageTypeSelectUtil(final GenDomainModel model) {
    CharSequence _xblockexpression = null;
    {
      final Iterable<GenDomainClassifier> packageableElementTypes = this.packageableElementTypes(model);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _rootPackage = model.getRootPackage();
      _builder.append(_rootPackage);
      _builder.append(".");
      String _name = model.getName();
      _builder.append(_name);
      _builder.append(".util;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Collection;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.uml2.uml.PackageableElement;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.google.common.collect.Collections2;");
      _builder.newLine();
      _builder.append("import com.google.common.collect.ImmutableList;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.predicate.IsZDLConcept;");
      _builder.newLine();
      _builder.append("import com.zeligsoft.base.zdl.staticapi.functions.CreateZDLWrapper;");
      _builder.newLine();
      _builder.newLine();
      {
        for(final GenDomainClassifier type : packageableElementTypes) {
          CharSequence _generateImport = this._javaImportExtensions.generateImport(type);
          _builder.append(_generateImport);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      String _name_1 = model.getName();
      _builder.append(_name_1);
      _builder.append("TypeSelectUtil {");
      _builder.newLineIfNotEmpty();
      {
        for(final GenDomainClassifier type_1 : packageableElementTypes) {
          _builder.append("    ");
          _builder.append("public List<");
          String _javaInterfaceName = this._javaNamingExtensions.javaInterfaceName(type_1);
          _builder.append(_javaInterfaceName, "    ");
          _builder.append("> select");
          String _firstUpper = StringExtensions.toFirstUpper(type_1.getName());
          _builder.append(_firstUpper, "    ");
          _builder.append("(org.eclipse.uml2.uml.Package pkg) {");
          _builder.newLineIfNotEmpty();
          _builder.append("    ");
          _builder.append("    ");
          _builder.append("final Collection<PackageableElement> elements = ");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("        ");
          _builder.append("Collections2.filter(pkg.getPackagedElements(),");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("            ");
          _builder.append("new IsZDLConcept(\"");
          String _qualifiedName = type_1.getDomainElement().getQualifiedName();
          _builder.append(_qualifiedName, "                ");
          _builder.append("\"));");
          _builder.newLineIfNotEmpty();
          _builder.append("    ");
          _builder.append("    ");
          _builder.append("final Collection<");
          String _javaInterfaceName_1 = this._javaNamingExtensions.javaInterfaceName(type_1);
          _builder.append(_javaInterfaceName_1, "        ");
          _builder.append("> result = ");
          _builder.newLineIfNotEmpty();
          _builder.append("    ");
          _builder.append("        ");
          _builder.append("Collections2.transform(elements, CreateZDLWrapper.create(");
          String _javaInterfaceName_2 = this._javaNamingExtensions.javaInterfaceName(type_1);
          _builder.append(_javaInterfaceName_2, "            ");
          _builder.append(".class));");
          _builder.newLineIfNotEmpty();
          _builder.append("    ");
          _builder.append("    ");
          _builder.append("return new ImmutableList.Builder<");
          String _javaInterfaceName_3 = this._javaNamingExtensions.javaInterfaceName(type_1);
          _builder.append(_javaInterfaceName_3, "        ");
          _builder.append(">().addAll(result).build();");
          _builder.newLineIfNotEmpty();
          _builder.append("    ");
          _builder.append("    ");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("    ");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public Iterable<GenDomainClassifier> packageableElementTypes(final GenDomainModel model) {
    final Function1<GenDomainBlock, Iterable<GenDomainClassifier>> _function = (GenDomainBlock block) -> {
      return this.packageableElementTypes(block);
    };
    return Iterables.<GenDomainClassifier>concat(IterableExtensions.<GenDomainBlock, Iterable<GenDomainClassifier>>map(this._genDomainModelExtensions.domainBlocks(model), _function));
  }

  public Iterable<GenDomainClassifier> packageableElementTypes(final GenDomainBlock block) {
    final Function1<GenDomainClassifier, Boolean> _function = (GenDomainClassifier classifier) -> {
      return Boolean.valueOf(this.mapsToPackageableElement(classifier));
    };
    return IterableExtensions.<GenDomainClassifier>filter(block.getClassifiers(), _function);
  }

  private boolean _mapsToPackageableElement(final GenDomainClassifier classifier) {
    return false;
  }

  private boolean _mapsToPackageableElement(final GenDomainConcept classifier) {
    boolean _xblockexpression = false;
    {
      boolean result = false;
      final Function1<org.eclipse.uml2.uml.Class, Boolean> _function = (org.eclipse.uml2.uml.Class base) -> {
        return Boolean.valueOf((base.getName().equals("PackageableElement") || IterableExtensions.<Classifier>exists(base.allParents(), ((Function1<Classifier, Boolean>) (Classifier parent) -> {
          return Boolean.valueOf(parent.getName().equals("PackageableElement"));
        }))));
      };
      result = IterableExtensions.<org.eclipse.uml2.uml.Class>exists(this.umlMetaclassMapping(classifier), _function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  private Set<org.eclipse.uml2.uml.Class> umlMetaclassMapping(final GenDomainConcept concept) {
    Set<org.eclipse.uml2.uml.Class> _xblockexpression = null;
    {
      final Set<org.eclipse.uml2.uml.Class> metaclasses = CollectionLiterals.<org.eclipse.uml2.uml.Class>newHashSet();
      final Function1<GenDomainConcept, EList<org.eclipse.uml2.uml.Class>> _function = (GenDomainConcept base) -> {
        return base.getUmlMetaclasses();
      };
      final Iterable<org.eclipse.uml2.uml.Class> baseMetaclasses = Iterables.<org.eclipse.uml2.uml.Class>concat(ListExtensions.<GenDomainConcept, EList<org.eclipse.uml2.uml.Class>>map(concept.allGenerals(), _function));
      metaclasses.addAll(concept.getUmlMetaclasses());
      Iterables.<org.eclipse.uml2.uml.Class>addAll(metaclasses, baseMetaclasses);
      _xblockexpression = metaclasses;
    }
    return _xblockexpression;
  }

  private boolean mapsToPackageableElement(final GenDomainClassifier classifier) {
    if (classifier instanceof GenDomainConcept) {
      return _mapsToPackageableElement((GenDomainConcept)classifier);
    } else if (classifier != null) {
      return _mapsToPackageableElement(classifier);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(classifier).toString());
    }
  }
}
