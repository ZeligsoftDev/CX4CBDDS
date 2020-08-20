package com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdlgen2umlprofile.workflow.extensions.ZDLGenExtensions;
import java.util.Arrays;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaNamingExtensions {
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
  @Extension
  private ZDLGenExtensions _zDLGenExtensions;
  
  public String interfaceJavaPackage(final GenDomainBlock block) {
    String _xblockexpression = null;
    {
      final String blockName = UML2Util.getValidJavaIdentifier(block.getName());
      _xblockexpression = this.interfaceJavaPackage(this.rootPackage, blockName);
    }
    return _xblockexpression;
  }
  
  private String interfaceJavaPackage(final String theRootPackage, final String theBlockName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(theRootPackage);
    _builder.append(".");
    _builder.append(theBlockName);
    return _builder.toString();
  }
  
  public String qualifiedName(final GenDomainConcept concept) {
    String _xblockexpression = null;
    {
      final GenDomainBlock block = concept.getBlock();
      final GenDomainModel domain = this._zDLGenExtensions.domainModel(block);
      String _xifexpression = null;
      boolean _equals = Objects.equal(domain, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = this.qualifiedName(domain.getRootPackage(), block.getName(), concept.getName());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String qualifiedName(final GenDomainEnum concept) {
    String _xblockexpression = null;
    {
      final GenDomainBlock block = concept.getBlock();
      final GenDomainModel domain = this._zDLGenExtensions.domainModel(block);
      String _xifexpression = null;
      boolean _equals = Objects.equal(domain, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = this.qualifiedName(domain.getRootPackage(), block.getName(), concept.getName());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private String qualifiedName(final String theRootPackage, final String blockName, final String conceptName) {
    StringConcatenation _builder = new StringConcatenation();
    String _interfaceJavaPackage = this.interfaceJavaPackage(theRootPackage, blockName);
    _builder.append(_interfaceJavaPackage);
    _builder.append(".");
    _builder.append(conceptName);
    return _builder.toString();
  }
  
  public CharSequence implementationQualifiedName(final GenDomainConcept concept) {
    CharSequence _xblockexpression = null;
    {
      final GenDomainBlock block = concept.getBlock();
      final GenDomainModel domain = this._zDLGenExtensions.domainModel(block);
      CharSequence _xifexpression = null;
      boolean _equals = Objects.equal(domain, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        _xifexpression = this.qualifiedName(domain.getRootPackage(), block.getName(), concept.getName(), 
          domain.getImplementationSubPackage(), domain.getImplSuffix());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private CharSequence qualifiedName(final String theRootPackage, final String blockName, final String conceptName, final String theImplSubPackage, final String theImplSuffix) {
    StringConcatenation _builder = new StringConcatenation();
    String _implementationJavaPackage = this.implementationJavaPackage(theRootPackage, blockName, theImplSubPackage);
    _builder.append(_implementationJavaPackage);
    _builder.append(".");
    _builder.append(conceptName);
    _builder.append(theImplSuffix);
    return _builder;
  }
  
  public String implementationJavaPackage(final GenDomainBlock block) {
    String _xblockexpression = null;
    {
      final String blockName = UML2Util.getValidJavaIdentifier(block.getName());
      _xblockexpression = this.implementationJavaPackage(this.rootPackage, blockName, this.implSubPackage);
    }
    return _xblockexpression;
  }
  
  private String implementationJavaPackage(final String theRootPackage, final String theBlockName, final String theImplSubPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(theRootPackage);
    _builder.append(".");
    _builder.append(theBlockName);
    _builder.append(".");
    _builder.append(theImplSubPackage);
    return _builder.toString();
  }
  
  protected String _javaInterfaceName(final GenDomainConcept concept) {
    return UML2Util.getValidJavaIdentifier(concept.getName());
  }
  
  protected String _javaInterfaceName(final GenDomainEnum genum) {
    return UML2Util.getValidJavaIdentifier(genum.getName());
  }
  
  protected String _javaImplementationName(final GenDomainEnum genum) {
    String _xblockexpression = null;
    {
      final GenDomainBlock block = genum.getBlock();
      final GenDomainModel domain = this._zDLGenExtensions.domainModel(block);
      String _xifexpression = null;
      boolean _equals = Objects.equal(domain, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        String _xblockexpression_1 = null;
        {
          final String implSuffix = domain.getImplSuffix();
          StringConcatenation _builder = new StringConcatenation();
          String _validJavaIdentifier = UML2Util.getValidJavaIdentifier(genum.getName());
          _builder.append(_validJavaIdentifier);
          _builder.append(implSuffix);
          _xblockexpression_1 = _builder.toString();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String _javaImplementationName(final GenDomainConcept concept) {
    String _xblockexpression = null;
    {
      final GenDomainBlock block = concept.getBlock();
      final GenDomainModel domain = this._zDLGenExtensions.domainModel(block);
      String _xifexpression = null;
      boolean _equals = Objects.equal(domain, null);
      if (_equals) {
        _xifexpression = "";
      } else {
        String _xblockexpression_1 = null;
        {
          final String implSuffix = domain.getImplSuffix();
          StringConcatenation _builder = new StringConcatenation();
          String _validJavaIdentifier = UML2Util.getValidJavaIdentifier(concept.getName());
          _builder.append(_validJavaIdentifier);
          _builder.append(implSuffix);
          _xblockexpression_1 = _builder.toString();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String javaInterfaceName(final GenDomainClassifier genum) {
    if (genum instanceof GenDomainEnum) {
      return _javaInterfaceName((GenDomainEnum)genum);
    } else if (genum instanceof GenDomainConcept) {
      return _javaInterfaceName((GenDomainConcept)genum);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(genum).toString());
    }
  }
  
  public String javaImplementationName(final GenDomainClassifier genum) {
    if (genum instanceof GenDomainEnum) {
      return _javaImplementationName((GenDomainEnum)genum);
    } else if (genum instanceof GenDomainConcept) {
      return _javaImplementationName((GenDomainConcept)genum);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(genum).toString());
    }
  }
}
