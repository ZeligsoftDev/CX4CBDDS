/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;

/**
 * Configuration object for plugin.xml files for use in Eclipse.
 */
@Accessors
@SuppressWarnings("all")
public class PluginXmlAccess extends TextFileAccess implements IGuiceAwareGeneratorComponent {
  private static final Logger LOG = LogManager.getLogger(PluginXmlAccess.class);

  @Inject
  private CodeConfig codeConfig;

  public PluginXmlAccess() {
    this.setPath("plugin.xml");
  }

  private final List<CharSequence> entries = CollectionLiterals.<CharSequence>newArrayList();

  @Override
  public void setContent(final StringConcatenationClient content) {
    throw new UnsupportedOperationException("cannot directly set contents on a plugin.xml. Use entries property instead");
  }

  @Override
  public CharSequence getContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"�codeConfig.encoding?:\'UTF-8\'�\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR entry : entries�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�entry�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("</plugin>");
    _builder.newLine();
    return _builder;
  }

  /**
   * Merge the contents of the given plugin.xml into this one.
   */
  public boolean merge(final PluginXmlAccess other) {
    boolean _xblockexpression = false;
    {
      String _path = this.getPath();
      String _path_1 = other.getPath();
      boolean _notEquals = (!Objects.equal(_path, _path_1));
      if (_notEquals) {
        String _path_2 = this.getPath();
        String _plus = ("Merging plugin.xml files with different paths: " + _path_2);
        String _plus_1 = (_plus + ", ");
        String _path_3 = other.getPath();
        String _plus_2 = (_plus_1 + _path_3);
        PluginXmlAccess.LOG.warn(_plus_2);
      }
      _xblockexpression = this.entries.addAll(other.entries);
    }
    return _xblockexpression;
  }

  @Override
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    boolean _isEmpty = this.entries.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      super.writeTo(fileSystemAccess);
    }
  }

  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }

  @Pure
  public CodeConfig getCodeConfig() {
    return this.codeConfig;
  }

  public void setCodeConfig(final CodeConfig codeConfig) {
    this.codeConfig = codeConfig;
  }

  @Pure
  public List<CharSequence> getEntries() {
    return this.entries;
  }
}
