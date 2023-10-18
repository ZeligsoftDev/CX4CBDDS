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
package org.eclipse.ocl.examples.debug.vm.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class VMStackFrameData implements Serializable
{
	private static final long serialVersionUID = -1055712783030253722L;

	private static class Loc implements VMLocationData
	{
		private static final long serialVersionUID = 300982114845658039L;

		private final @NonNull VMStackFrameData frame;
		
		private Loc(@NonNull VMStackFrameData frame) {
			this.frame = frame;
		}
		
		public int getCharEnd() {
			return frame.charEnd;
		}
		
		public int getCharStart() {
			return frame.charStart;
		}
	
		public int getLineNum() {
			return frame.lineNum;
		}
		
		public @NonNull String getURI() {
			return frame.uri;
		}
		
		public @NonNull String getModule() {
			return frame.module;
		}
		
		public @Nullable String getElementSignature() {
			return frame.elementSignature;
		}
	}
	
	
	public final long id;
	private final @NonNull String uri;
	private final int lineNum;	
	private final int charStart;	
	private final int charEnd;	
	public final @NonNull String module;
	public final @Nullable String elementSignature;	
	public final @NonNull VMVariableData @NonNull [] visibleVariables;
	
	private transient VMLocationData location;	
	
	public VMStackFrameData(long id, @NonNull String uri, @NonNull String module, @Nullable String elementSignature, int line, int startPosition, int endPosition, @NonNull VMVariableData @NonNull [] vars) {
		if (/*vars.length == 0 ||*/ Arrays.asList(vars).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.uri = uri;
		this.module = module;
		this.elementSignature = elementSignature;
		this.visibleVariables = vars;
		this.lineNum = line;
		this.charStart = startPosition;
		this.charEnd = endPosition == startPosition ? endPosition + 1 : endPosition;  // FIXME BUG 468878
	}
	
	public synchronized @NonNull VMLocationData getLocation() {
		VMLocationData location2 = location;
		if (location2 == null) {
			location = location2 = new Loc(this);
		}
		return location2;
	}	
	
	@SuppressWarnings("null")
	public @NonNull List<VMVariableData> getVisibleVariables() {
		return Arrays.asList(visibleVariables);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(").append(id);
		s.append(", ").append(uri);
		s.append(":").append(module);
		s.append(":").append(lineNum);
		s.append(":").append(charStart);
		s.append(", ").append(elementSignature);
		VMVariableData[] visibleVariables2 = visibleVariables;
		if (visibleVariables2 != null) {
			s.append(", {");
			for (int i = 0; i < visibleVariables2.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t\t");
				s.append(visibleVariables2[i]);
			}
			s.append("}");
		}
		s.append(")");
		return s.toString();
	}
}
