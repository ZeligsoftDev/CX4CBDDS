/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.type.impl.java.JavaMetaModel;
import org.eclipse.xtend.type.impl.java.beans.JavaBeansStrategy;

public class HigherOrder {
   @SuppressWarnings("unchecked")
   public static <T> Collection<T> select(Collection<T> col, String closure) {
       return (Collection<T>) facade().evaluate("x.select("+closure+")", Collections.singletonMap("x", col)); 
   }

   public static <T> Collection<?> collect(Collection<T> col, String closure) {
       return (Collection<?>) facade().evaluate("x.collect("+closure+")", Collections.singletonMap("x", col)); 
   }
   
   public static <T> boolean exists(Collection<T> col, String closure) {
       return (Boolean) facade().evaluate("x.select("+closure+")", Collections.singletonMap("x", col)); 
   }
   
   public static <T> boolean forAll(Collection<T> col, String closure) {
       return (Boolean)facade().evaluate("x.select("+closure+")", Collections.singletonMap("x", col)); 
   }
   
   @SuppressWarnings("unchecked")
   public static <T> T first(Collection<T> col, String closure) {
       Collection<T> re = (Collection<T>) facade().evaluate("x.select("+closure+")", Collections.singletonMap("x", col));
       if (re!=null && re.size()>0) {
           return re.iterator().next();
       }
       return null; 
   }
   
   
   
   private static ExpressionFacade facade() {
       ExecutionContextImpl ctx = new ExecutionContextImpl();
       ctx.registerMetaModel(new JavaMetaModel("java",new JavaBeansStrategy()));
       ExpressionFacade ef = new ExpressionFacade(ctx);
       return ef;
   }
}
