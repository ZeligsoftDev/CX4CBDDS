/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.zdl.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;

import com.zeligsoft.base.zdl.Activator;
import com.zeligsoft.base.zdl.l10n.Messages;
import com.zeligsoft.base.zdl.oaw.ZDLMetamodel;

/**
 * A utility class that can execute an oaW expression, when it is given a
 * descriptor for the expression that includes the object to evaluate the
 * expression on, the metamodels to use and the expression itself.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class OawEvaluationUtil {

	/**
	 * The only instance of this class.
	 */
	public static final OawEvaluationUtil INSTANCE = new OawEvaluationUtil();
	
	private Map<String, XtendFacade> facadeCache;

	/**
	 * A constructor.
	 */
	protected OawEvaluationUtil() {
		// do not create me
		facadeCache = new HashMap<String, XtendFacade>();
	}
	
	/**
	 * Evaluate the descriptor provided.
	 * 
	 * @param oed
	 * 		A descriptor for an oaw evaluation that provides the expression
	 * 		and evaluation context to evaluate it.
	 */
	public final void evaluate(OawDescriptor oed) {
		if(oed instanceof OawXtendDescriptor) {
			doEvaluate((OawXtendDescriptor) oed);
		} else if(oed instanceof OawExpressionDescriptor) {
			doEvaluate((OawExpressionDescriptor) oed);
		} 
	}

	/**
	 * Abstracts the use of the ExpressionFacade in an attempt to simplify the
	 * evaluation of an oaW expression.
	 * 
	 * @param descriptor
	 *            A description of the expression to evaluate and its context.
	 */
	protected void doEvaluate(final OawExpressionDescriptor descriptor) {
		ExecutionContextImpl ec = getExecutionContext(descriptor);

		ExpressionFacade ef = new ExpressionFacade(ec);

		ExpressionFacade efWithVariable = ef.cloneWithVariable(new Variable(
				descriptor.getVariableName(), descriptor.getObj()));

		for (String expr : descriptor.getExpression()) {
			try {
				efWithVariable.evaluate(expr);
			} catch (EvaluationException e) {
				Activator.getDefault().error(
						NLS.bind(
								Messages.OawEvaluationUtil_EvaluationException,
								expr), e);
				return;
			} catch (Exception e) {
				Activator.getDefault().error(
						NLS.bind(
							Messages.OawEvaluationUtil_UnexpectedExpression,
							expr), e);
				return;
			}
		}
	}

	/**
	 * Abstracts the use of the XtendFacade in an attempt to simplify the
	 * evaluation of an oaW extension call.
	 * 
	 * @param descriptor
	 *            A description of the extension to call and its context.
	 */
	protected void doEvaluate(final OawXtendDescriptor descriptor) {
		ExecutionContextImpl ec = getExecutionContext(descriptor);
		String extFile = descriptor.getExtFile();
		XtendFacade facade = facadeCache.get(extFile);
		
		if(null == facade) {
			facade = XtendFacade.create(ec, extFile);
			facadeCache.put(extFile, facade);
		}
		
		for(String expression : descriptor.getExpression()) {
			try {
				facade.call(expression, descriptor.getObj());
			} catch (EvaluationException e) {
				Activator.getDefault().error(
					NLS.bind(
							Messages.OawEvaluationUtil_EvaluationException,
							expression), e);
				return;
			} catch (Exception e) {
				Activator.getDefault().error(
					NLS.bind(
						Messages.OawEvaluationUtil_UnexpectedExpression,
						expression), e);
				return;
			}
		}	
	}
	
	/**
	 * Helper to build the execution context from a descriptor
	 * 
	 * @param descriptor
	 * 		The descriptor to build the execution context from
	 * @return
	 * 		A new execution context based on the descriptors values
	 */
	protected ExecutionContextImpl getExecutionContext(OawDescriptor descriptor) {
		ExecutionContextImpl ec = new ExecutionContextImpl();
		
		Collection<Profile> profiles = descriptor.obj instanceof Element ?
				ZDLUtil.getZDLProfiles((Element) descriptor.obj) :
					null;
		
		Profile profile = profiles != null && ! profiles.isEmpty() ?
				profiles.iterator().next() :
					null;
		for (String mm : descriptor.getMetamodels()) {
			ZDLMetamodel zdlMM = null;
			
			if(profile != null) {
				zdlMM = new ZDLMetamodel(mm, profile);
			} else {
				zdlMM = new ZDLMetamodel();
				zdlMM.setZdl(mm);
			}
			ec.registerMetaModel(zdlMM);
		}
		
		ec.registerMetaModel(new UML2MetaModel());
		
		return ec;
	}
	//
	// Internal classes
	//
	
	/**
	 * Describes the context for evaluating an oaW expression, Xtend or Xpand
	 */
	public static abstract class OawDescriptor {
		private EObject obj;
		private final List<String> expression;
		private final List<String> metamodels;

		/**
		 * A constructor to create me
		 * 
		 * @param obj
		 * 		The object use for evaluation
		 * @param variableName
		 * 		The name of the variable that stores the object that is the 
		 * 		context of the evaluation
		 * @param expression
		 * 		The expression to evaluate
		 * @param metamodels
		 * 		The metamodels that are used for evaluation
		 */
		public OawDescriptor(EObject obj, List<String> expression, 
				List<String> metamodels) {
			super();
			this.obj = obj;
			this.expression = expression;
			this.metamodels = metamodels;
		}

		public EObject getObj() {
			return obj;
		}

		public void setObj(EObject obj) {
			this.obj = obj;
		}

		public List<String> getExpression() {
			return expression;
		}

		public List<String> getMetamodels() {
			return metamodels;
		}
	}

	/**
	 * A specialization of the OawDescriptor specifically for expressions.
	 */
	public static class OawExpressionDescriptor extends OawDescriptor {
		private final String variableName;
		
		/**
		 * Delegates to the base class constructor.
		 * 
		 * @param obj
		 * 		The object use for evaluation
		 * @param variableName
		 * 		The name of the variable that stores the object that is the 
		 * 		context of the evaluation
		 * @param expression
		 * 		The expression to evaluate
		 * @param metamodels
		 * 		The metamodels that are used for evaluation
		 */
		public OawExpressionDescriptor(EObject obj,
				List<String> expression, List<String> metamodels, String variableName) {
			super(obj, expression, metamodels);
			this.variableName = variableName;
		}
		
		public String getVariableName() {
			return variableName;
		}
	}

	/**
	 * A specialization of the OawDescriptor specifically for Xtend.
	 */
	public static class OawXtendDescriptor extends OawDescriptor {
		private String extFile;
		
		/**
		 * Delegates to the base class constructor
		 * @param obj
		 * 		The object use for evaluation
		 * @param variableName
		 * 		The name of the variable that stores the object that is the 
		 * 		context of the evaluation
		 * @param expression
		 * 		The expression to evaluate
		 * @param metamodels
		 * 		The metamodels that are used for evaluation
		 * @param extFile
		 * 		The extension file in which the expressions will be called
		 */
		public OawXtendDescriptor(EObject obj, List<String> expression, 
				List<String> metamodels, String extFile) {
			super(obj, expression, metamodels);
			this.extFile = extFile;
		}

		public String getExtFile() {
			return extFile;
		}
	}
}
