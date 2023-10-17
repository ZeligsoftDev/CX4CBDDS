/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.Inject;

public class DeclarativeSerializer extends Serializer // implements ISerializer //extends Serializer
{
	@Inject
	private @NonNull UserModelAnalysis modelAnalysis;

	@Inject
	private @NonNull SerializationBuilder serializationBuilder;

	@Override
	public void serialize(EObject eObject, Writer writer, SaveOptions options) throws IOException {

		checkNotNull(eObject, "eObject must not be null.");
		checkNotNull(writer, "writer must not be null.");
		checkNotNull(options, "options must not be null.");
	//	modelAnalysis.getInjectedGrammarAnalysis().analyze();
	//	String s1 = grammarAnalysis.toString();
	//	System.out.println(s1);
	//	System.out.println("\n");

		// See Bug 439440 for the inability to pass useful EMF save options via SaveOptions
		//	if (options != null) {
		//	String lineDelimiter = options.get(Resource.OPTION_LINE_DELIMITER);
		//	if (lineDelimiter != null) {
		//		serializationBuilder.setLineDelimiter(lineDelimiter);
		//  	String Resource.OPTION_LINE_DELIMITER = "LINE_DELIMITER";
		//		String XMLResource.OPTION_FORMATTED = "LINE_WIDTH";
		//		String XMLResource.OPTION_LINE_WIDTH = "LINE_WIDTH";
		//		tabWidth
		//		indentation
		//	}

		//
		//	Analyze each element of the user model to determine the applicabale serialization rule(s).
		//
		modelAnalysis.analyze(eObject);
	//	String s2 = modelAnalysis.toString();
	//	System.out.println(s2);
		//
		//	Serialize the user model tree as a (virtual) String concatenation to the serializationBuilder.
		//
		modelAnalysis.serialize(serializationBuilder, eObject, null);
	//	System.out.println(modelAnalysis.diagnose());
		//
		//	Render the (virtual) String concatenation as a pure string for output.
		//
		serializationBuilder.close();
		String serializedOutput = serializationBuilder.toString();
	//	System.out.println(serializedOutput);
		writer.append(serializedOutput);
		writer.flush();
		Iterable<@NonNull String> errors = serializationBuilder.getErrors();
		if (errors != null) {
			StringBuilder s = new StringBuilder();
			s.append("Failed to serialize '" + EcoreUtil.getURI(eObject) + "'");
			for (@NonNull String error : errors) {
				s.append("\n\t");
				s.append(error);
			}
			throw new IOException(s.toString());
		}
	}

	@Override
	public String serialize(EObject obj) {
		// xx
		// TODO Auto-generated method stub
		return super.serialize(obj);
	}

	@Override
	protected void serialize(EObject semanticObject, EObject context,
			ISequenceAcceptor tokens, Acceptor errors) {
		// TODO Auto-generated method stub
		super.serialize(semanticObject, context, tokens, errors);
	}

	@Override
	protected void serialize(ISerializationContext context,
			EObject semanticObject, ISequenceAcceptor tokens, Acceptor errors) {
		// TODO Auto-generated method stub
		super.serialize(context, semanticObject, tokens, errors);
	}

	@Override
	protected void serialize(EObject obj, ITokenStream tokenStream,
			SaveOptions options)
			throws IOException {
		// TODO Auto-generated method stub
		super.serialize(obj, tokenStream, options);
	}

	@Override
	public ITextRegionAccess serializeToRegions(EObject obj) {
		// TODO Auto-generated method stub
		return super.serializeToRegions(obj);
	}

	@Override
	protected void serialize(EObject obj, Appendable appendable,
			SaveOptions options)
			throws IOException {
		// TODO Auto-generated method stub
		super.serialize(obj, appendable, options);
	}

	@Override
	public String serialize(EObject obj, SaveOptions options) {
		// TODO Auto-generated method stub
		return super.serialize(obj, options);
	}

	@Override
	public ReplaceRegion serializeReplacement(EObject obj,
			SaveOptions options) {
		// TODO Auto-generated method stub
		return super.serializeReplacement(obj, options);
	}

/*	@Override
	public String serialize(EObject obj) {
		checkNotNull(obj, "obj must not be null.");
		return serialize(obj, SaveOptions.defaultOptions());
	}

	@Override
	public String serialize(EObject obj, SaveOptions options) {
		checkNotNull(obj, "obj must not be null.");
		checkNotNull(options, "options must not be null.");
		try {
		//	if (formatter2Provider != null) {
				StringBuilder builder = new StringBuilder();
				serialize(obj, builder, options);
				return builder.toString();
		//	} else {
				TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
				serialize(obj, tokenStringBuffer, options);
				return tokenStringBuffer.toString();
		//	}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options) {
		throw new UnsupportedOperationException();
	} */
}
