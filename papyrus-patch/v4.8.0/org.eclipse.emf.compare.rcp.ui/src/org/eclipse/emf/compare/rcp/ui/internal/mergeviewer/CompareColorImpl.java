/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.ICompareColor;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Default implementation that use a cache to store created Color and that is listening to a preference store
 * for color configuration.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class CompareColorImpl implements RemovalListener<RGB, Color>, ICompareColor {

	/** Min component for RGB. */
	private static final int MIN_RGB_COMPONENT = 0;

	/** Max component for RGB. */
	private static final int MAX_RGB_COMPONENT = 255;

	/** Loaded color cache size */
	private static final int MAX_CACHE_SIZE = 16;

	/** Gray color component */
	private static final int MED_RGB_COMPONENT = 128;

	/** Scale factor */
	private static final double INTERPOLATION_SCALE_1 = 0.6;

	/** Scale factor */
	private static final double INTERPOLATION_SCALE_2 = 0.97;

	/** Scale factor to compute the color of border. */
	private static final double DARKER_BORDER_SCALE_FACTOR = -0.5;

	/** Incoming color key in theme */
	public static final String INCOMING_CHANGE_COLOR_THEME_KEY = "org.eclipse.emf.compare.incomingChangeColor";//$NON-NLS-1$

	/** Conflicting color key in theme */
	public static final String CONFLICTING_CHANGE_COLOR_THEME_KEY = "org.eclipse.emf.compare.conflictingChangeColor";//$NON-NLS-1$

	/** Outgoing color key in theme */
	public static final String OUTGOING_CHANGE_COLOR_THEME_KEY = "org.eclipse.emf.compare.outgoingChangeColor";//$NON-NLS-1$

	/** Required difference color key in theme */
	public static final String REQUIRED_DIFF_COLOR_THEME_KEY = "org.eclipse.emf.compare.requiredChangeColor";//$NON-NLS-1$

	/** Unmergeable difference color key in theme */
	public static final String UNMERGEABLE_DIFF_COLOR_THEME_KEY = "org.eclipse.emf.compare.unmergeableChangeColor";//$NON-NLS-1$

	private final LoadingCache<RGB, Color> fColors;

	private final Display fDisplay;

	private final ColorRegistry fColorRegistry;

	private final boolean fLeftIsLocal;

	private RGB incomingSelected;

	private RGB incoming;

	private RGB incomingFill;

	private RGB conflictSelected;

	private RGB conflict;

	private RGB conflictFill;

	private RGB outgoingSelected;

	private RGB outgoing;

	private RGB outgoingFill;

	private RGB requiredColor;

	private RGB requiredBorderColor;

	private RGB unmergeableColor;

	private RGB unmergeableBorderColor;

	/**
	 * Constructor. With this constructor the colors will disposed at the same as the control.
	 * 
	 * @param control
	 *            Use for get {@link Display}. The colors will be disposed with the control.
	 * @param leftIsLocal
	 * @param colorRegistry
	 *            ColorRegistry where to find all needed color. Those color will be available through the
	 *            constants: (UNMERGEABLE_DIFF_COLOR_THEME_KEY, REQUIRED_DIFF_COLOR_THEME_KEY,
	 *            RESOLVED_CHANGE_COLOR_THEME_KEY, OUTGOING_CHANGE_COLOR_THEME_KEY,
	 *            CONFLICTING_CHANGE_COLOR_THEME_KEY, INCOMING_CHANGE_COLOR_THEME_KEY)
	 */
	public CompareColorImpl(Display fDisplay, boolean leftIsLocal, ColorRegistry colorRegistry) {
		this.fDisplay = fDisplay;
		this.fLeftIsLocal = leftIsLocal;
		this.fColors = CacheBuilder.newBuilder().maximumSize(MAX_CACHE_SIZE).removalListener(this)
				.build(new CacheLoader<RGB, Color>() {
					@Override
					public Color load(RGB rgb) throws Exception {
						return new Color(CompareColorImpl.this.fDisplay, rgb);
					}
				});
		this.fColorRegistry = colorRegistry;
		updateColors();
	}

	public final void onRemoval(RemovalNotification<RGB, Color> notification) {
		Color color = notification.getValue();
		if (!color.isDisposed()) {
			color.dispose();
		}
	}

	private Color getColor(RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return fColors.getUnchecked(rgb);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.util.ICompareColor#getFillColor(org.eclipse.emf.compare.Diff,
	 *      boolean, boolean, boolean)
	 */
	public Color getFillColor(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected) {
		return getColor(getFillRGB(diff, isThreeWay, isIgnoreAncestor, selected));
	}

	private RGB getFillRGB(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected) {
		RGB selectedFill = getBackground();
		if (isThreeWay && !isIgnoreAncestor) {
			boolean requiredConflictForWayOfMerge = false;

			if (diff.getConflict() == null && !requiredConflictForWayOfMerge) {
				switch (diff.getSource()) {
					case RIGHT:
						if (fLeftIsLocal) {
							return selected ? selectedFill : incomingFill;
						}
						return selected ? selectedFill : outgoingFill;
					case LEFT:
						if (fLeftIsLocal) {
							return selected ? selectedFill : outgoingFill;
						}
						return selected ? selectedFill : incomingFill;
				}
			} else {
				return selected ? selectedFill : conflictFill;
			}
			return selected ? selectedFill : conflictFill;
		}
		return selected ? selectedFill : outgoingFill;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.util.ICompareColor#getStrokeColor(org.eclipse.emf.compare.Diff,
	 *      boolean, boolean, boolean)
	 */
	public Color getStrokeColor(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected) {
		return getColor(getStrokeRGB(diff, isThreeWay, isIgnoreAncestor, selected));
	}

	private RGB getStrokeRGB(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected) {
		if (isThreeWay && !isIgnoreAncestor) {
			boolean requiredConflictForWayOfMerge = false;

			if (diff != null && diff.getConflict() == null && !requiredConflictForWayOfMerge) {
				switch (diff.getSource()) {
					case RIGHT:
						if (fLeftIsLocal) {
							return selected ? incomingSelected : incoming;
						}
						return selected ? outgoingSelected : outgoing;
					case LEFT:
						if (fLeftIsLocal) {
							return selected ? outgoingSelected : outgoing;
						}
						return selected ? incomingSelected : incoming;
				}
			} else {
				return selected ? conflictSelected : conflict;
			}
			return selected ? conflictSelected : conflict;
		}
		return selected ? outgoingSelected : outgoing;
	}

	protected final void updateColors() {
		RGB background = getBackground();

		unmergeableColor = fColorRegistry.getRGB(UNMERGEABLE_DIFF_COLOR_THEME_KEY);
		if (unmergeableColor == null) {
			unmergeableColor = new RGB(255, 205, 180);
		}
		unmergeableBorderColor = interpolate(unmergeableColor, background, DARKER_BORDER_SCALE_FACTOR);

		requiredColor = fColorRegistry.getRGB(REQUIRED_DIFF_COLOR_THEME_KEY);
		if (requiredColor == null) {
			requiredColor = new RGB(215, 255, 200);
		}
		requiredBorderColor = interpolate(requiredColor, background, DARKER_BORDER_SCALE_FACTOR);

		conflictSelected = fColorRegistry.getRGB(CONFLICTING_CHANGE_COLOR_THEME_KEY);
		if (conflictSelected == null) {
			conflictSelected = new RGB(MAX_RGB_COMPONENT, 0, 0); // RED
		}
		conflict = interpolate(conflictSelected, background, INTERPOLATION_SCALE_1);
		conflictFill = interpolate(conflictSelected, background, INTERPOLATION_SCALE_2);

		outgoingSelected = fColorRegistry.getRGB(OUTGOING_CHANGE_COLOR_THEME_KEY);
		if (outgoingSelected == null) {
			outgoingSelected = new RGB(0, 0, 0); // BLACK
		}
		outgoing = interpolate(outgoingSelected, background, INTERPOLATION_SCALE_1);
		outgoingFill = interpolate(outgoingSelected, background, INTERPOLATION_SCALE_2);

		incomingSelected = fColorRegistry.getRGB(INCOMING_CHANGE_COLOR_THEME_KEY);
		if (incomingSelected == null) {
			incomingSelected = new RGB(0, 0, MAX_RGB_COMPONENT); // BLUE
		}
		incoming = interpolate(incomingSelected, background, INTERPOLATION_SCALE_1);
		incomingFill = interpolate(incomingSelected, background, INTERPOLATION_SCALE_2);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.contentmergeviewer.util.ICompareColor#dispose()
	 */
	public void dispose() {
		fColors.invalidateAll();
	}

	/**
	 * Get the background of the current display
	 * 
	 * @param fDisplay
	 * @return
	 */
	private RGB getBackground() {
		return fDisplay.getSystemColor(SWT.COLOR_LIST_BACKGROUND).getRGB();
	}

	/**
	 * Interpolate two colors using a scale factor
	 * 
	 * @param fg
	 *            Foreground color
	 * @param bg
	 *            Background color
	 * @param scale
	 *            Scale factor
	 * @return resulting {@link RGB}
	 */
	private static RGB interpolate(RGB fg, RGB bg, double scale) {
		final RGB ret;
		if (fg != null && bg != null) {
			int red = (int)((1.0 - scale) * fg.red + scale * bg.red);
			int green = (int)((1.0 - scale) * fg.green + scale * bg.green);
			int blue = (int)((1.0 - scale) * fg.blue + scale * bg.blue);
			ret = new RGB(getValidComponent(red), getValidComponent(green), getValidComponent(blue));
		} else if (fg != null) {
			ret = fg;
		} else if (bg != null) {
			ret = bg;
		} else {
			ret = new RGB(MED_RGB_COMPONENT, MED_RGB_COMPONENT, MED_RGB_COMPONENT); // a gray
		}

		return ret;
	}

	/**
	 * Check that the component if valid for RGB object (0 < component < 255)
	 * 
	 * @param colorComponent
	 *            Input component
	 * @return A valid component
	 */
	private static int getValidComponent(int colorComponent) {
		int validvalue = colorComponent;
		if (colorComponent > MAX_RGB_COMPONENT) {
			return MAX_RGB_COMPONENT;
		} else if (colorComponent < MIN_RGB_COMPONENT) {
			return MIN_RGB_COMPONENT;
		}
		return validvalue;
	}

	/**
	 * {@inheritDoc}
	 */
	public Color getRequiredFillColor() {
		return getColor(requiredColor);
	}

	/**
	 * {@inheritDoc}
	 */
	public Color getUnmergeableFillColor() {
		return getColor(unmergeableColor);
	}

	/**
	 * {@inheritDoc}
	 */
	public Color getRequiredStrokeColor() {
		return getColor(requiredBorderColor);
	}

	/**
	 * {@inheritDoc}
	 */
	public Color getUnmergeableStrokeColor() {
		return getColor(unmergeableBorderColor);
	}

}
