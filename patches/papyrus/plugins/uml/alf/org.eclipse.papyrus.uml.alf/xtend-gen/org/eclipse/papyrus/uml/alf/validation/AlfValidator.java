/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Jeremie Tatibouet - Initial Implementation
 */
package org.eclipse.papyrus.uml.alf.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.NameBinding;
import org.eclipse.papyrus.uml.alf.PropertyAccessExpression;
import org.eclipse.papyrus.uml.alf.SequenceAccessExpression;
import org.eclipse.xtext.validation.Check;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class AlfValidator extends AbstractAlfValidator {
  @Override
  public List<EPackage> getEPackages() {
    final ArrayList<EPackage> list = new ArrayList<EPackage>();
    list.add(AlfPackage.eINSTANCE);
    return list;
  }

  @Check
  public void checkFeatureReference(final FeatureReference featureReference) {
    NameBinding _nameBinding = featureReference.getNameBinding();
    boolean _equals = Objects.equal(_nameBinding, null);
    if (_equals) {
      Expression expression = featureReference.getExpression();
      if ((expression instanceof SequenceAccessExpression)) {
        expression = ((SequenceAccessExpression) expression).getPrimary();
      }
      if ((!(expression instanceof PropertyAccessExpression))) {
        this.error("Not a legal left-hand side", 
          AlfPackage.eINSTANCE.getFeatureReference_Expression());
      }
    }
  }

  @Check
  public void checkAnnotatedStatement(final AnnotatedStatement statement) {
    EList<String> _annotation = statement.getAnnotation();
    for (final String text : _annotation) {
      Boolean _isAnnotation = AlfValidator.isAnnotation(text);
      boolean _not = (!(_isAnnotation).booleanValue());
      if (_not) {
        this.error("Invalid annotation", 
          AlfPackage.eINSTANCE.getAnnotatedStatement_Annotation());
      }
    }
  }

  public static Boolean isAnnotation(final String text) {
    String[] _split = text.replaceAll("[ \f\r\t\n]", "").substring(3).split("@", (-1));
    for (final String annotation : _split) {
      {
        final int i = annotation.indexOf("(");
        String _xifexpression = null;
        if ((i < 0)) {
          _xifexpression = annotation;
        } else {
          _xifexpression = annotation.substring(0, i);
        }
        final String identifier = _xifexpression;
        Boolean _isIdentifier = AlfValidator.isIdentifier(identifier);
        boolean _not = (!(_isIdentifier).booleanValue());
        if (_not) {
          return Boolean.valueOf(false);
        }
        if ((i >= 0)) {
          final int j = annotation.indexOf(")");
          int _length = annotation.length();
          int _minus = (_length - 1);
          boolean _notEquals = (j != _minus);
          if (_notEquals) {
            return Boolean.valueOf(false);
          }
          String[] _split_1 = annotation.substring((i + 1), j).split(",", (-1));
          for (final String argument : _split_1) {
            boolean _not_1 = (!((AlfValidator.isIdentifier(argument)).booleanValue() || (AlfValidator.isUnrestrictedName(argument)).booleanValue()));
            if (_not_1) {
              return Boolean.valueOf(false);
            }
          }
        }
      }
    }
    return Boolean.valueOf(true);
  }

  public static Boolean isIdentifier(final String text) {
    return Boolean.valueOf(text.matches("[a-zA-z_][a-zA-z_0-9]*"));
  }

  public static Boolean isUnrestrictedName(final String text) {
    return Boolean.valueOf(text.matches("\'(\\\\[btnfr\"\'\\\\]|[^\\\\\']*)\'"));
  }
}
