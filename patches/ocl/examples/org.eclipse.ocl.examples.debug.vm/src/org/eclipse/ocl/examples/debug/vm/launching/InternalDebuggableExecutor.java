/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.launching;

import java.io.IOException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.examples.debug.vm.messages.VMMessages;
import org.eclipse.ocl.examples.debug.vm.request.VMStartRequest;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.EmfUtil;
import org.eclipse.ocl.examples.debug.vm.utils.ExecutionDiagnostic;
import org.eclipse.ocl.examples.debug.vm.utils.ExecutionDiagnosticImpl;
import org.eclipse.ocl.examples.debug.vm.utils.Log;
import org.eclipse.ocl.examples.debug.vm.utils.Messages;
import org.eclipse.ocl.examples.debug.vm.utils.VMException;
import org.eclipse.ocl.examples.debug.vm.utils.VMInterruptedExecutionException;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.utils.VMStackOverFlowError;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.osgi.util.NLS;

/**
 * Internal transformation executor
 */
public abstract class InternalDebuggableExecutor
{
	private static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity == Diagnostic.OK || severity == Diagnostic.WARNING
				|| severity == Diagnostic.INFO;
	}

	protected final @NonNull IVMContext vmContext;
	protected final @NonNull URI debuggableURI;
//	private EPackage.Registry fPackageRegistry;
	private @Nullable CompiledUnit fCompiledUnit;
	private ResourceSet fCompilationRs;
	private ExecutionDiagnosticImpl fLoadDiagnostic;
//	private Transformation fTransformation;
	private @Nullable VMExecutor vmExecutor;
//	private @Nullable Trace fTraces;


	/**
	 * Constructs the executor for the given transformation URI.
	 * <p>
	 * No attempt to resolve and load the transformation is done at this step
	 */
	protected InternalDebuggableExecutor(@NonNull IVMContext vmContext, @NonNull URI debuggableURI) {
		this.vmContext = vmContext;
		this.debuggableURI = debuggableURI;
	}

/*	private void checkLegalModelParams(ModelExtent[] extents)
			throws IllegalArgumentException {
		if (extents == null) {
			throw new IllegalArgumentException("Null model parameters"); //$NON-NLS-1$
		}

		for (int i = 0; i < extents.length; i++) {
			if (extents[i] == null) {
				throw new IllegalArgumentException(
						"Null model parameter[" + i + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	} */
	
	public void cleanup() {
//		setEnvironmentFactory(null);
		if (fCompilationRs != null) {
			EmfUtil.cleanupResourceSet(fCompilationRs);
		}
	}

	private static ExecutionDiagnostic createExecutionFailure(@NonNull InvalidValueException vmRuntimeException) {
		int code = 0;
		int severity = Diagnostic.ERROR;
		String message = vmRuntimeException.getLocalizedMessage();
		Object[] data = null;

		if (vmRuntimeException instanceof VMException) {
			code = /*((VMException) vmRuntimeException).getExceptionType() == QvtOperationalStdLibrary.INSTANCE.getAssertionFailedClass() ?
					ExecutionDiagnostic.FATAL_ASSERTION :*/ ExecutionDiagnostic.EXCEPTION_THROWN;
		} else if (vmRuntimeException instanceof VMInterruptedExecutionException) {
			code = ExecutionDiagnostic.USER_INTERRUPTED;
			severity = Diagnostic.CANCEL;
		} else {
			code = ExecutionDiagnostic.EXCEPTION_THROWN;
			if (vmRuntimeException instanceof VMStackOverFlowError == false) {
				Throwable cause = vmRuntimeException.getCause();
				data = new Object[] { cause != null ? cause : vmRuntimeException };
			} else {
				message = Messages.StackTraceOverFlowError;
			}
		}

		if (message == null) {
			message = NLS.bind(Messages.VMRuntimeExceptionCaught,
					vmRuntimeException.getClass().getName());
		}
		ExecutionDiagnosticImpl diagnostic = new ExecutionDiagnosticImpl(severity, code, message, data);
		if (vmRuntimeException instanceof VMRuntimeException) {
			diagnostic.setStackTrace(((VMRuntimeException)vmRuntimeException).getVMStackTrace());
		}
		return diagnostic;
	}

	private @NonNull EvaluationContext createInternalContext(@NonNull EvaluationContext evaluationContext) {
		EvaluationContext ctx = evaluationContext; //new Context();
//		ctx.setLog(xtextEvaluator.getLog());
//		ctx.setMonitor(xtextEvaluator.getMonitor());

//		for (String key : xtextEvaluator.getConfigPropertyNames()) {
//			String value = xtextEvaluator.getConfigProperty(key);
//			ctx.setConfigProperty(key, value);
//		}

		return ctx;
	}

	protected abstract @NonNull VMExecutor createVMExecutor() throws IOException, ParserException;

	private ExecutionDiagnostic doExecute(@NonNull VMStartRequest startRequest, /*ModelExtent[] args,*/ @NonNull EvaluationContext evaluationContext) throws IOException {
//		QvtOperationalEnvFactory factory = getEnvironmentFactory();
//		QVTiXtextEvaluator evaluator = null; //evaluationContext.getEvaluator();
		
		
//		ExecutionDiagnostic modelParamsDiagnostic = initArguments(evaluationEnv, fTransformation, args);
//		if (modelParamsDiagnostic.getSeverity() != Diagnostic.OK) {
//			return modelParamsDiagnostic;
//		}

//		QvtOperationalFileEnv rootEnv = factory.createEnvironment(fCompiledUnit.getURI());
//		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> evaluator = factory
//				.createEvaluationVisitor(rootEnv, evaluationEnv, null);

		// perform the actual execution
//		assert evaluator instanceof InternalEvaluator : "expecting InternalEvaluator implementation"; //$NON-NLS-1$
//		InternalEvaluator rawEvaluator = (InternalEvaluator) evaluator;

		VMExecutor vmEvaluator2 = vmExecutor;
		if (vmEvaluator2 != null) {
			vmEvaluator2.setSuspendOnStartUp(startRequest.suspendOnStartup);
			vmEvaluator2.execute();
		}

		// unpack the internal extents into the passed model parameters
/*		List<Object> resultArgs = evaluationEnv.getOperationArgs();
		int i = 0;
		for (Object nextResultArg : resultArgs) {
			ModelInstance modelInstance = (ModelInstance) nextResultArg;
			ModelParameterExtent extent = modelInstance.getExtent();

			List<EObject> allRootElements = extent.getContents().getAllRootElements();
			try {
				args[i++].setContents(allRootElements);
			} catch (UnsupportedOperationException e) {
				return new ExecutionDiagnosticImpl(Diagnostic.ERROR,
						ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, NLS
								.bind(Messages.ReadOnlyExtentModificationError,
										i - 1));
			}
		} */

		// do some handy processing with traces
//		Trace traces = evaluationEnv.getAdapter(InternalEvaluationEnv.class).getTraces();
//		handleExecutionTraces(traces);
		
		return ExecutionDiagnostic.OK_INSTANCE;
	}
	
	private void doLoad() {
		fLoadDiagnostic = ExecutionDiagnosticImpl.OK_INSTANCE;
		try {
			VMExecutor vmExecutor2 = createVMExecutor();
			vmExecutor = vmExecutor2;
			fCompiledUnit = new CompiledUnit(vmExecutor2.getDebuggable());
		} catch (Exception e) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.FailedToCompileUnitError, debuggableURI));
	
			fLoadDiagnostic.merge(BasicDiagnostic.toDiagnostic(e));
		}
/*		UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(fURI);
		if (unit == null) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.UnitNotFoundError, fURI));
			return;
		}

		OCLCompiler compiler = createCompiler();
		try {
			fCompiledUnit = compiler.compile(unit, null, null);
			fCompilationRs = compiler.getResourceSet();
		//	fCompilerKernel = compiler.getKernel();

			fLoadDiagnostic = createCompilationDiagnostic(fCompiledUnit);

		} catch (MdaException e) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.FailedToCompileUnitError, fURI));

			fLoadDiagnostic.merge(BasicDiagnostic.toDiagnostic(e));
		}

		if (fCompiledUnit != null
				&& fLoadDiagnostic.getSeverity() == Diagnostic.OK) {
			fTransformation = getTransformation();
			if (fTransformation == null) {
				fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
						ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS
								.bind(Messages.NotTransformationInUnitError,
										fURI));
				return;
			}

			ExecutionDiagnosticImpl validForExecution = checkIsExecutable(fTransformation);
			if (validForExecution.getSeverity() != Diagnostic.OK) {
				fLoadDiagnostic = validForExecution;
			}
		} */
	}

	/**
	 * Executes the transformation referred by this executor using the given
	 * model parameters and execution context.
	 * 
	 * @return the diagnostic object indicating the execution result status,
	 *         also keeping the details of possible problems
	 * @throws IllegalArgumentException
	 *             if the context or any of the model parameters is
	 *             <code>null</code>
	 */
	public ExecutionDiagnostic execute(@NonNull VMStartRequest startRequest, @NonNull EvaluationContext evaluationContext/*, ModelExtent... modelParameters*/) {
//		checkLegalModelParams(modelParameters);

		// ensure transformation unit is loaded
		loadDebuggable();

		// check if we have successfully loaded the transformation unit
		if (!isSuccess(fLoadDiagnostic)) {
			return fLoadDiagnostic;
		}

		try {
			return doExecute(startRequest, /*modelParameters,*/ createInternalContext(evaluationContext));
		} catch (InvalidValueException e) {
			Log logger = evaluationContext.getLog();
			if (logger != null) {
				logger.log(VMMessages.TerminatingExecution);
			}
			return createExecutionFailure(e);
//		} catch (VMRuntimeException e) {
//			Log logger = evaluationContext.getLog();
//			if (logger != null) {
//				logger.log(EvaluationMessages.TerminatingExecution);
//			}
//			return createExecutionFailure(e);
		} catch (Exception e) {
			Log logger = evaluationContext.getLog();
			if (logger != null) {
				logger.log(VMMessages.TerminatingExecution);
			}
			return createExecutionFailure(new VMRuntimeException("Execution failed", e));
		}
	}

	public @Nullable NamedElement getDebuggable() {
		// TODO - cached the transformation selected as main
//		if (fCompiledUnit == null) {
//			return null;
//		}
		
//		List<Module> allModules = fCompiledUnit.getModules();
//		for (Module module : allModules) {
//			if (module instanceof OperationalTransformation) {
//				return (OperationalTransformation) module;
//			}
//		}

		VMExecutor xtextEvaluator2 = vmExecutor;
		return xtextEvaluator2 != null ? xtextEvaluator2.getDebuggable() : null;
	}
	
	public ResourceSet getResourceSet() {
		return fCompilationRs;
	}
	
	public @NonNull URI getURI() {
		return debuggableURI;
	}
	
	/**
	 * Retrieves compiled unit if the referencing URI gets successfully resolved
	 * <p>
	 * <b>Remark</b>: This method invocation causes the referenced transformation to
	 * load if not already done before by direct call to
	 * {@linkplain #loadDebuggable()} or
	 * 
	 * @return compiled unit or <code>null</code> if it failed to be obtained
	 */
	public @Nullable CompiledUnit getUnit() {
		loadDebuggable();
		return fCompiledUnit;
	}	

	public @NonNull IVMContext getVMContext() {
		return vmContext;
	}

	public VMExecutor getVMExecutor() {
		return vmExecutor;
	}
		
	/**
	* Attempts to load the transformation referred by this executor and checks
	* if it is valid for execution.
	* <p>
	* <b>Remark:</b><br> Only the first performs the actual transformation
	* loading, subsequent calls to this method will return the existing
	* diagnostic.
	* 
	* @return the diagnostic indicating possible problems of the load action
	*/
	public Diagnostic loadDebuggable() {
		if (fLoadDiagnostic == null) {
			doLoad();
		}
		return fLoadDiagnostic;
	}

	@Override
	public String toString() {
		return "OCL-Executor: " + debuggableURI; //$NON-NLS-1$
	}
}
