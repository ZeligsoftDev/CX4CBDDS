/*
 * «codeGenHelper.getCopyright(' * ')»
 *************************************************************************
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 */

package org.eclipse.ocl.xtext.oclstdlibcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSContainmentVisitor;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;

public class AutoOCLstdlibContainmentVisitor
	extends EssentialOCLCSContainmentVisitor
	implements OCLstdlibCSVisitor<Continuation<?>>
{

    protected final @NonNull CS2AS converter;
    protected final @NonNull IdResolver idResolver;

    /**
     * Initializes me with an initial value for my result.
     *
     * @param context my initial result value
     */
    public AutoOCLstdlibContainmentVisitor(@NonNull CS2ASConversion context) {
        super(context);
        this.converter = context.getConverter();
        this.idResolver = converter.getEnvironmentFactory().getIdResolver();
    }

    @Override
	public @Nullable Continuation<?> visitJavaClassCS(@NonNull JavaClassCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitJavaImplementationCS(@NonNull JavaImplementationCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibClassCS(@NonNull LibClassCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibCoercionCS(@NonNull LibCoercionCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibConstraintCS(@NonNull LibConstraintCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibIterationCS(@NonNull LibIterationCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibOperationCS(@NonNull LibOperationCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibOppositeCS(@NonNull LibOppositeCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibPackageCS(@NonNull LibPackageCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibPropertyCS(@NonNull LibPropertyCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitLibRootPackageCS(@NonNull LibRootPackageCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitMetaclassNameCS(@NonNull MetaclassNameCS self) {
        throw new UnsupportedOperationException();
    }

    @Override
	public @Nullable Continuation<?> visitPrecedenceCS(@NonNull PrecedenceCS self) {
        throw new UnsupportedOperationException();
    }
}
