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
      _builder.append("package �model.rootPackage�.�model.name�.util;");
      _builder.newLine();
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
      _builder.append("�FOR type : packageableElementTypes�");
      _builder.newLine();
      _builder.append("�type.generateImport�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �model.name�TypeSelectUtil {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�FOR type : packageableElementTypes�");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public List<�type.javaInterfaceName�> select�type.name.toFirstUpper�(org.eclipse.uml2.uml.Package pkg) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("final Collection<PackageableElement> elements = ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("Collections2.filter(pkg.getPackagedElements(),");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("new IsZDLConcept(\"�type.domainElement.qualifiedName�\"));");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("final Collection<�type.javaInterfaceName�> result = ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("Collections2.transform(elements, CreateZDLWrapper.create(�type.javaInterfaceName�.class));");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return new ImmutableList.Builder<�type.javaInterfaceName�>().addAll(result).build();");
      _builder.newLine();
      _builder.append("        ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
