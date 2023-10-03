/*****************************************************************************
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.validation

import org.eclipse.papyrus.uml.alf.FeatureReference
import org.eclipse.xtext.validation.Check
import org.eclipse.papyrus.uml.alf.SequenceAccessExpression
import org.eclipse.papyrus.uml.alf.AlfPackage
import org.eclipse.papyrus.uml.alf.PropertyAccessExpression
import java.util.List
import org.eclipse.emf.ecore.EPackage
import java.util.ArrayList
import org.eclipse.papyrus.uml.alf.AnnotatedStatement

//import org.eclipse.xtext.validation.Check

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class AlfValidator extends AbstractAlfValidator {

  override List<EPackage> getEPackages() {
    val list = new ArrayList<EPackage>()
    list.add(AlfPackage.eINSTANCE)
    return list
  }

  @Check
  def checkFeatureReference(FeatureReference featureReference) {
    if (featureReference.nameBinding == null) {
      var expression = featureReference.expression
      if (expression instanceof SequenceAccessExpression) {
        expression = (expression as SequenceAccessExpression).primary
      }
      if (!(expression instanceof PropertyAccessExpression)) {
        error("Not a legal left-hand side",
          AlfPackage.eINSTANCE.featureReference_Expression
        )
      }
    }
  }
  
  @Check
  def checkAnnotatedStatement(AnnotatedStatement statement) {
    for (text: statement.annotation) {
      if (!isAnnotation(text)) {
        error("Invalid annotation", 
          AlfPackage.eINSTANCE.annotatedStatement_Annotation
        )
      }
    }
  }
  
  def static Boolean isAnnotation(String text) {
    for (annotation: text.replaceAll("[ \f\r\t\n]","").substring(3).split("@",-1)) {
      val i = annotation.indexOf("(")
      val identifier = if (i < 0) annotation else annotation.substring(0,i)
      if (!isIdentifier(identifier)) {
        return false
      }
      if (i >= 0) {
        val j = annotation.indexOf(")");
        if (j != annotation.length-1) {
          return false
        }
        for (argument: annotation.substring(i+1, j).split(",",-1)) {
          if (!(isIdentifier(argument) || isUnrestrictedName(argument))) {
            return false
          }
        }
      }
    }
    return true
  }
  
  def static Boolean isIdentifier(String text) {
    return text.matches("[a-zA-z_][a-zA-z_0-9]*")
  }
  
  def static Boolean isUnrestrictedName(String text) {
    return text.matches("'(\\\\[btnfr\"'\\\\]|[^\\\\']*)'");
  }
  
}
