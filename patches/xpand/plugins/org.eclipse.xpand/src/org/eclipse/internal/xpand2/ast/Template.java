/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of
 * openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xpand2.model.XpandAdvice;
import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xpand2.model.XpandResource;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.util.QualifiedName;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandUtil;
import org.eclipse.xtend.expression.AnalysationIssue;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class Template extends SyntaxElement implements XpandResource {

  private static final ImportDeclaration[] NO_IMPORT = new ImportDeclaration[0];
  private static final ExtensionImportDeclaration[] NO_EXT_IMPORT = new ExtensionImportDeclaration[0];
  private static final Advice[] NO_ADVICE = new Advice[0];
  private final ImportDeclaration[] imports;

  private final Definition[] definitions;

  private QualifiedName fullyQualifiedName;

  private final ExtensionImportDeclaration[] extensions;

  private final Advice[] advices;

  public ExtensionImportDeclaration[] getExtensions() {
    return this.extensions;
  }

  public List<String> getImportedExtensionsAsList() {
    final List<String> result = new ArrayList<String>(this.extensions.length);
    for (ImportDeclaration ext : this.extensions) {
      result.add(ext.getImportString().toString());
    }
    return result;
  }

  public String getFullyQualifiedName() {
    return this.fullyQualifiedName != null ? this.fullyQualifiedName.toString(SyntaxConstants.NS_DELIM) : null;
  }
  
  public QualifiedName getQualifiedName () {
      return this.fullyQualifiedName;
  }

  public void setFullyQualifiedName(final String fullyQualifiedName) {
    this.fullyQualifiedName = QualifiedName.create(fullyQualifiedName, SyntaxConstants.NS_DELIM);
  }

  public Template(final ImportDeclaration[] imports, final ExtensionImportDeclaration[] extensions,
      final Definition[] definitions, final Advice[] advices) {
    this.imports = imports.length > 0 ? imports : NO_IMPORT;
    this.extensions = extensions.length > 0 ? extensions : NO_EXT_IMPORT;
    for (Definition definition : definitions) {
      definition.setOwner(this);
    }
    this.definitions = definitions;
    for (Advice advice : advices) {
      advice.setOwner(this);
    }
    this.advices = advices.length > 0 ? advices : NO_ADVICE;
  }

  public XpandDefinition[] getDefinitions() {
    return this.definitions;
  }

  public List<XpandDefinition> getDefinitionsAsList() {
    return Arrays.asList((XpandDefinition[]) this.definitions);
  }

  public AbstractDefinition[] getAllDefinitions() {
    List<AbstractDefinition> l = new ArrayList<AbstractDefinition>();
    l.addAll(Arrays.asList(this.definitions));
    l.addAll(Arrays.asList(this.advices));

    Collections.sort(l, new Comparator<SyntaxElement>() {

      public int compare(final SyntaxElement o1, final SyntaxElement o2) {
        return new Integer(o1.getStart()).compareTo(o2.getStart());
      }
    });
    return l.toArray(new AbstractDefinition[l.size()]);
  }

  public ImportDeclaration[] getImports() {
    return this.imports;
  }

  public List<ImportDeclaration> getImportsAsList() {
    return Arrays.asList(this.imports);
  }

  private String[] commonPrefixes = null;

  public void analyze(XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
    try {
      Set<AnalysationIssue> issuesFromThisResource = new HashSet<AnalysationIssue>();
      ctx = (XpandExecutionContext) ctx.cloneWithResource(this);
      if (ctx.getCallback() != null) {
        if (!ctx.getCallback().pre(this, ctx)) {
          return;
        }
      }

      for (ExtensionImportDeclaration extension : this.extensions) {
        extension.analyze(ctx, issuesFromThisResource);
      }

      checkDuplicateDefinitions(issuesFromThisResource);

      // add error marker for duplicate extension imports
      Set<Identifier> uniqueNames = new HashSet<Identifier>();
      for (ExtensionImportDeclaration imp : this.extensions) {
        if (uniqueNames.contains(imp.getImportString())) {
          final String msg = "Duplicate extension importing: " + imp.getImportString();
          issues.add(new AnalysationIssue(AnalysationIssue.SYNTAX_ERROR, msg, imp));
        }
        uniqueNames.add(imp.getImportString());
      }
      for (Definition definition : this.definitions) {
        definition.analyze(ctx, issuesFromThisResource);
      }

      for (Advice advice : this.advices) {
        advice.analyze(ctx, issuesFromThisResource);
      }

      for (ImportDeclaration importDeclaration : this.imports) {
        importDeclaration.analyze(ctx, issuesFromThisResource);
      }

      // filter all the 'Error parsing resource' issues that arised from a broken import
      Set<AnalysationIssue> issuesToRemove = new HashSet<AnalysationIssue>();
      for (AnalysationIssue issue : issuesFromThisResource) {
        if (issue.getType().equals(AnalysationIssue.RESOURCE_NOT_FOUND)) {
          ImportDeclaration importStmt = (ImportDeclaration) issue.getElement();
          for (AnalysationIssue issue2 : issuesFromThisResource) {
            if (issue2.getType().equals(AnalysationIssue.INTERNAL_ERROR) &&
                issue2.getMessage().matches("Error parsing extensions.*" + importStmt.getImportString() + "$")) {
              issuesToRemove.add(issue2);
            }
          }
        }
      }
      issuesFromThisResource.removeAll(issuesToRemove);
      issues.addAll(issuesFromThisResource);

    }
    catch (RuntimeException ex) {
      issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, ex.getMessage(), this));
    }
    finally {
      if (ctx.getCallback() != null) {
        ctx.getCallback().post(this, ctx, null);
      }
    }
  }

  public XpandDefinition[] getDefinitionsByName(final String aName) {
    final List<Definition> defs = new ArrayList<Definition>();
    for (final Definition def : this.definitions) {
      if (def.getName().equals(aName)) {
        defs.add(def);
      }
    }
    return defs.toArray(new XpandDefinition[defs.size()]);
  }

  public String[] getImportedNamespaces() {
    if (this.commonPrefixes == null) {
      final List<String> l = new ArrayList<String>();
      final String thisNs = XpandUtil.withoutLastSegment(getFullyQualifiedName());

      for (int i = 0; i < getImports().length; i++) {
        final ImportDeclaration anImport = getImports()[i];
        l.add(anImport.getImportString().toString());
      }

      if (thisNs != null) {
        l.add(thisNs);
      }

      this.commonPrefixes = l.toArray(new String[l.size()]);
    }
    return this.commonPrefixes;
  }

  public List<String> getImportedNamespacesAsList() {
    return Arrays.asList(getImportedNamespaces());
  }

  String[] importedExtensions = null;

  public String[] getImportedExtensions() {
    if (this.importedExtensions == null) {
      final List<String> l = new ArrayList<String>();
      for (int i = 0; i < getExtensions().length; i++) {
        final ImportDeclaration anImport = getExtensions()[i];
        l.add(anImport.getImportString().toString());
      }
      this.importedExtensions = l.toArray(new String[l.size()]);
    }
    return this.importedExtensions;
  }

  public XpandAdvice[] getAdvices() {
    return this.advices;
  }

  private void checkDuplicateDefinitions(final Set<AnalysationIssue> issues) {
    Set<Definition> definitionSet = new HashSet<Definition>();
    for (Definition def : this.definitions) {
      if (!definitionSet.contains(def)) {
        definitionSet.add(def);
      }
      else {
        Definition origDef = null;
        for (Definition d : definitionSet) {
          if (d.equals(def)) {
            origDef = d;
            break;
          }
        }
        issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate DEFINE definition '" +
            def.getName() + "'", def, false, def.getStart()));
        issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Duplicate DEFINE definition '" +
            (origDef != null ? origDef.getName() : "") + "'", origDef, false, origDef.getStart()));
      }
    }
  }

  @Override
  public String toString() {
    return getFileName();
  }
}
