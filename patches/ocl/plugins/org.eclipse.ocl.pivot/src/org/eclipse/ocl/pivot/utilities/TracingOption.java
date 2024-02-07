/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.PivotPlugin;

public final class TracingOption implements Appendable
{
	public static final TracingOption DEBUG = new TracingOption(PivotPlugin.PLUGIN_ID, "debug"); //$NON-NLS-1$

	private static Set<@NonNull TracingOption> allOptions = null;

	/**
	 * Helper routine to append string to an appendable without throwing an exception.
	 * @param appendable
	 * @param string
	 */
	public static void println(@NonNull Appendable appendable, @NonNull String string) {
		try {
			appendable.append(string);
			appendable.append("\n");
		} catch (IOException e) {}
	}

	/**
	 * Reset all constructed tracing options. Typically used at the start/end of a test to avoid inter-test interference.
	 *
	 * @since 1.6
	 */
	public static void resetAll() {
		if (allOptions != null) {
			for (@NonNull TracingOption option : allOptions) {
				option.reset();
			}
		}
	}

	private final @NonNull String option;
	private boolean resolved = false;		// true once .options state determined by resolveState
	private boolean state = false;			// true/false once .options state determined resolveState

	public TracingOption(@NonNull String option) {
		this(PivotPlugin.PLUGIN_ID, option);
	}

	public TracingOption(String pluginId, String option) {
		if (allOptions == null) {
			allOptions = new HashSet<>();
		}
		allOptions.add(this);
		this.option = pluginId + "/" + option;
	}

	@Override
	public @NonNull Appendable append(CharSequence csq) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(csq);
		return this;
	}

	@Override
	public @NonNull Appendable append(CharSequence csq, int start, int end) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(csq, start, end);
		return this;
	}

	@Override
	public @NonNull Appendable append(char c) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.append(c);
		return this;
	}

	public boolean isActive() {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		return state;
	}

	public void println(@Nullable String string) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.println(option + " : " + string);
	}

	public void println(@NonNull Class<?> clazz, @Nullable String string) {
		if (!resolved) {
			state = resolveState();
			resolved = true;
		}
		if (state)
			System.out.println(option + " : " + clazz.getSimpleName() + " : " + string);
	}

	/**
	 * @since 1.6
	 */
	public void reset() {
		state = false;
		resolved = false;
	}

	public boolean resolveState() {
		try {
			String debugOption = System.getProperty(option);
			if (debugOption == null) {
				debugOption = Platform.getDebugOption(option);
			}
			return Boolean.TRUE.toString().equalsIgnoreCase(debugOption);
		}
		catch (Throwable e) {
			return false;
		}
	}

	/**
	 * Set the state explicitly, typically for use in a standalone environment
	 * such as a JUnit test that does not read the .options file.
	 */
	public void setState(boolean state) {
		this.state = state;
		resolved = true;
	}

	@Override
	public String toString() {
		return option + "=" + state;
	}
}
