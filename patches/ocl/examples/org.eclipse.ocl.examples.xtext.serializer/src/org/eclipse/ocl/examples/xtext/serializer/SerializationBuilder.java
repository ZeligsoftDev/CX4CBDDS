/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * SerializationBuilder builds the intermediate serialization from an interleaving of concrete strings and virtual
 * characters such as soft-space.  {@link append()} does the building.
 *
 * {@link close() ensures new line termination. }
 *
 * Finally   {@link toString()} returns a simple string with the virtual characters converted to concrete equivalents where
 * appropriate.
 */
public class SerializationBuilder
{
	/**
	 * The virtual character/string to start a new line, but pairs of half new lines generate one
	 * rather than two new lines.
	 */
	public static final @NonNull String HALF_NEW_LINE = new String("half-new-line");

	/**
	 * The virtual character/string to start a new line and apply the prevailing indentation to subsequent text.
	 */
	public static final @NonNull String NEW_LINE = new String("new-line");

	/**
	 * The virtual character/string to suppress soft space separation.
	 */
	public static final @NonNull String NO_SPACE = new String("no-space");

	/**
	 * The virtual character/string to pop the most recent indenttation push.
	 */
	public static final @NonNull String POP = new String("pop");

	/**
	 * The virtual character/string to emit standard ostfix comments from the Node model.
	 */
	public static final @NonNull String POST_COMMENT = new String("post-comment");

	/**
	 * The virtual character/string to emit standard prefix comments from the Node model.
	 */
	public static final @NonNull String PRE_COMMENT = new String("pre-comment");

	/**
	 * The virtual character/string to push a standard indentation on the stack.
	 */
	public static final @NonNull String PUSH = new String("push");

	/**
	 * The virtual character/string to push the next string as indentation on the stack.
	 */
	public static final @NonNull String PUSH_NEXT = new String("push-next");

	/**
	 * The virtual character/string to start a new line without applying any indentation to subsequent text.
	 * @deprecated This supports dubious legacy JUnit test behaviour that could be revised.
	 */
	@Deprecated
	public static final @NonNull String RAW_NEW_LINE = new String("raw-new-line");

	/**
	 * The virtual character/string to start a new line,  but avoid multiple new lines.
	 */
	public static final @NonNull String SOFT_NEW_LINE = new String("soft-new-line");

	/**
	 * The virtual character/string to ensure space separation but avoid redundant spacing.
	 */
	public static final @NonNull String SOFT_SPACE = new String("soft-space");

	/**
	 * The virtual character/string to output the inner value of a node.
	 */
	public static final @NonNull String VALUE = new String("value");

	/**
	 * The virtual character/string to mark the beginning of a wrap region within which either
	 * all or no wrap-here preferred wraappimg points are exploited,
	 */
	public static final @NonNull String WRAP_BEGIN_ALL = new String("wrap-begin-all");

	/**
	 * The virtual character/string to mark the beginning of a wrap region within which any
	 * all or no wrap-here preferred wraapping points are exploited,
	 */
	public static final @NonNull String WRAP_BEGIN_SOME = new String("wrap-begin-some");

	/**
	 * The virtual character/string to mark the end of a wrap region.
	 */
	public static final @NonNull String WRAP_END = new String("wrap-end");

	/**
	 * The virtual character/string to mark a preferred wrapping point.
	 */
	public static final @NonNull String WRAP_HERE = new String("wrap-here");

	/**
	 * The virtual character/string to mark the indentation anchor/reference for subsequent wraps.
	 */
	public static final @NonNull String WRAP_ANCHOR = new String("wrap-anchor");

	/**
	 * An AbstractContext identifies (the left edge of) a significant character location in the
	 * indented but not yet wrapped output text.
	 */
	protected static abstract class AbstractContext
	{
		protected final int line;
		protected final int column;
		protected final int offset;

		protected AbstractContext(@NonNull WrappingStringBuilder s) {
			this.line = s.getLine();
			this.column = s.getColumn();
			this.offset = s.getOffset();
		}

		@Override
		public @NonNull String toString() {
			return line + ":" + column + ":" + offset;
		}

		public void toString(@NonNull FinalStringBuilder s) {
			s.appendToOffset(this.offset);
		}
	}

	protected static class ChildContextIterator implements Iterator<@NonNull AbstractContext>
	{
		protected final @NonNull RegionContext regionContext;
		protected final @NonNull List<@NonNull AbstractContext> childContexts;
		protected final int size;
		private int cursor;
		private @Nullable AbstractContext currentContext = null;


		// Where (unwrapped) previous context left off
		private int currentLine;			// Absolute (Relative to start of document)
		private int currentColumn;

		private void setCurrentColumn(int currentColumn) {
			this.currentColumn = currentColumn;
		}

		// Where (wrapped) previous context left off
		private int currentWrappedLine;		// Relative (to start of region)
		private int currentWrappedColumn;

		private int currentPreAnchorWrappedColumn;		// Number of extra columns from region start column to current anchor
		private int currentPostAnchorWrappedColumn;		// Number of extra columns from current anchor to current position.
	//	int maxLocalAdvance = 0;
	//	int maxWrappedAdvance = 0;		// largest preAnchorWrappedColumn plus postAnchorWrappedColumn
	//	int maxUnwrappedAdvance = 0;	// largest preAnchorWrappedColumn plus postAnchorWrappedColumn

		// Where this (unwrapped) context starts
		private int contextLine;
		private int contextColumn;
		// Where this (unwrapped) context finishes
		private int nextLine;
		private int nextColumn;

		private void setNextColumn(int nextColumn) {
			this.nextColumn = nextColumn;
		}

		// Where this (wrapped) context finishes
		private int nextWrappedLine;
		private int nextWrappedColumn;


		private int nextPreAnchorWrappedColumn;		// Number of extra columns from region start column to current anchor
		private int nextPostAnchorWrappedColumn;		// Number of extra columns from current anchor to current position.

		/**
		 * The largest number of columns required for this region and all transitively nested regions when
		 * no wrapping is in force.
		 */
		private int requiredColumns = -1;

		/**
		 * The largest number of lines required for this region and all transitively nested regions when
		 * no wrapping is in force.
		 */
		private int requiredLines = -1;

		/**
		 * The smallest number of columns required for this region and all transitively nested regions when
		 * maximum wrapping is in force.
		 */
		private int wrappedRequiredColumns = -1;

		/**
		 * The smallest number of lines required for this region and all transitively nested regions when
		 * maximum wrapping is in force.
		 */
		private int wrappedRequiredLines = -1;

		/**
		 * The smallest number of columns required for this region when this regionis wrapped but all other
		 * transitive;y nested regions are unwrapped.
		 */
		private int locallyRequiredColumns = -1;
		private int locallyRequiredLines = -1;

		public ChildContextIterator(@NonNull RegionContext regionContext) {
			this.regionContext = regionContext;
			this.childContexts = regionContext.childContexts;
			this.size = childContexts.size();
			this.cursor = 0;
			this.currentLine = nextLine = regionContext.line;			// Absolute (Relative to start of document)
		//	this.currentColumn = nextColumn = regionContext.column;
			this.currentColumn = nextColumn = regionContext.column;
			setCurrentColumn(nextColumn);
			setNextColumn(nextColumn);
			// Where (wrapped) previous context left off
			this.currentWrappedLine = nextWrappedLine = 0;		// Relative (to start of region)
			this.currentWrappedColumn = nextWrappedColumn = 0;

			this.currentPreAnchorWrappedColumn = nextPreAnchorWrappedColumn = 0;		// Number of extra columns from region start column to current anchor
			this.currentPostAnchorWrappedColumn = nextPostAnchorWrappedColumn = 0;		// Number of extra columns from current anchor to current position.
		//	int maxLocalAdvance = 0;
		//	int maxWrappedAdvance = 0;		// largest preAnchorWrappedColumn plus postAnchorWrappedColumn
		//	int maxUnwrappedAdvance = 0;	// largest preAnchorWrappedColumn plus postAnchorWrappedColumn

			this.locallyRequiredColumns = 0;
			this.locallyRequiredLines = 0;
			this.requiredColumns = 0;
			this.requiredLines = 0;
			this.wrappedRequiredColumns = 0;
			this.wrappedRequiredLines = 0;

		}

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public @NonNull AbstractContext next() {
			if (cursor >= size) {
				throw new NoSuchElementException();
			}
			currentLine = nextLine;
			setCurrentColumn(nextColumn);
			currentWrappedLine = nextWrappedLine;
			currentWrappedColumn = nextWrappedColumn;
			currentPreAnchorWrappedColumn = nextPreAnchorWrappedColumn;
			currentPostAnchorWrappedColumn = nextPostAnchorWrappedColumn;
			@SuppressWarnings("null")
			AbstractContext currentContext = childContexts.get(cursor++);
			this.currentContext = currentContext;
			// Where this (unwrapped) context starts
			this.contextLine = currentContext.line;
			this.contextColumn = currentContext.column;
			// Where this (unwrapped) context finishes
			this.nextLine = contextLine;
			this.nextColumn = contextColumn;
			setNextColumn(contextColumn);
			// Where this (wrapped) context finishes
			this.nextWrappedLine = currentWrappedLine;
			this.nextWrappedColumn = currentWrappedColumn;
			//
			//	Track the text movement between contexts
			//
			if (contextLine != currentLine) {
				assert contextLine > currentLine;
				setNextColumn(regionContext.column + currentPreAnchorWrappedColumn);
				currentWrappedColumn = currentPreAnchorWrappedColumn;	// ?? is this relevant ?? -- yes for explicit new line character
			}
			int unwrappedColumns = contextColumn - regionContext.column;
			if (unwrappedColumns > 0) {
			//	assert contextLine == currentLine;
				if (unwrappedColumns > requiredColumns) {
					requiredColumns = unwrappedColumns;
				}
			}
			int moreColumns = contextColumn - currentColumn;
			if (moreColumns > 0) {
			//	assert contextLine == currentLine;
				currentWrappedColumn += moreColumns;
				currentPostAnchorWrappedColumn += moreColumns;
				int wrappedColumns = currentPreAnchorWrappedColumn + currentPostAnchorWrappedColumn;
				if (wrappedColumns > wrappedRequiredColumns) {
					wrappedRequiredColumns = wrappedColumns;
				}
			}

			nextWrappedColumn = currentWrappedColumn;
			nextPreAnchorWrappedColumn = currentPreAnchorWrappedColumn;		// Number of extra columns from region start column to current anchor
			nextPostAnchorWrappedColumn = currentPostAnchorWrappedColumn;		// Number of extra columns from current anchor to current position.
			//
			//	Track the next context
			//
			if (currentContext instanceof HereContext) {
				nextPreAnchorWrappedColumn = currentPreAnchorWrappedColumn;
				nextPostAnchorWrappedColumn = 0;
				nextWrappedLine = currentWrappedLine + 1;
				nextWrappedColumn = currentPreAnchorWrappedColumn;
			}
			else if (currentContext instanceof AnchorContext) {
				nextPreAnchorWrappedColumn = currentWrappedColumn;
				nextPostAnchorWrappedColumn = 0;
			}
		//	int localNextAdvance = wrappedNextAdvance;//wrappedNextColumn - wrappedCurrentColumn;
		/*	if (localNextAdvance > 0) {
				assert nextLine == currentLine;
				postAnchorWrappedColumn += wrappedNextAdvance;
				int wrappedAdvance = preAnchorWrappedColumn + postAnchorWrappedColumn;
				if (wrappedAdvance > maxWrappedAdvance) {
					maxWrappedAdvance = wrappedAdvance;
				}
				if (childContext instanceof HereContext) {
					postAnchorWrappedColumn = 0;
				}
				else if (childContext instanceof AnchorContext) {
					preAnchorWrappedColumn = wrappedAdvance;
					postAnchorWrappedColumn = 0;
				}
			} */
			if (currentContext instanceof IndentedContext) {
				//	IndentedContext indentedContext = ((IndentedContext)childContext);
				//	assert indentedContext.line == nextLine;
			}
		//	else if (childContext instanceof RawNewLineContext) {
		//		preAnchorWrappedColumn = 0;
		//		postAnchorWrappedColumn = 0;
		//	}
			else if (currentContext instanceof NewLineContext) {		// goto anchor column on new line
				nextLine = currentLine + 1;
				setNextColumn(0);
				nextWrappedLine = currentWrappedLine + 1;
				nextWrappedColumn = 0;
				nextPreAnchorWrappedColumn = 0;
				nextPostAnchorWrappedColumn = 0;
			/*	NewLineContext newLineContext = ((NewLineContext)childContext);
				if (newLineContext.column == 0) {					// Blank line may omit IndentedContext
				//	assert newLineContext.line == nextLine;
				//	nextLine = newLineContext.line + 1;
					nextColumn = 0;
				}
				else {
				//	assert newLineContext.line == nextLine;
				//	nextLine = newLineContext.line + 1;
					int wrappedColumns = newLineContext.column - nextColumn;
					assert wrappedColumns >= 0;
					int requiredColumns = AnchorWrappedColumns + wrappedColumns;
					if (requiredColumns > minimumRequiredColumns) {
						minimumRequiredColumns = requiredColumns;
					}
				}
				if (newLineContext.column > maximumRequiredColumns) {
					maximumRequiredColumns = newLineContext.column;
				} */
			}
			else if (currentContext instanceof RegionContext) {
				RegionContext nestedRegionContext = ((RegionContext)currentContext);
			//	EndContext regionEndContext = regionContext.getEndContext();
				nextLine = currentLine + nestedRegionContext.getRequiredLines();
				int nestedRequiredColumns = nestedRegionContext.getRequiredColumns();
				setNextColumn(currentColumn + nestedRequiredColumns);
				nextWrappedLine = currentWrappedLine + nestedRegionContext.getWrappedRequiredLines();
				nextWrappedColumn = currentWrappedColumn + nestedRegionContext.getWrappedLastLineColumns();
				getClass();
				int moreRequiredColumns = nestedRegionContext.column - regionContext.column + nestedRequiredColumns;
				if (moreRequiredColumns > requiredColumns) {
					requiredColumns = moreRequiredColumns;
				}
				if (nextWrappedColumn > wrappedRequiredColumns) {
					wrappedRequiredColumns = nextWrappedColumn;
				}
			//	wrappedRequiredColumns += nestedWrappedColumns;
			//	locallyRequiredColumns += nestedWrappedColumns;
			/*	int wrappedNextColumn = childContext.column;
				int wrappedNextAdvance = wrappedNextColumn - wrappedCurrentColumn;
				if (wrappedNextAdvance > 0) {
					assert nextLine == currentLine;
					postAnchorWrappedColumn += wrappedNextAdvance;
					int wrappedAdvance = preAnchorWrappedColumn + postAnchorWrappedColumn;
					if (wrappedAdvance > maxWrappedAdvance) {
						maxWrappedAdvance = wrappedAdvance;
					}
					if (childContext instanceof HereContext) {
						postAnchorWrappedColumn = 0;
					}
					else if (childContext instanceof AnchorContext) {
						preAnchorWrappedColumn = wrappedAdvance;
						postAnchorWrappedColumn = 0;
					}
				} */
			/*	assert regionContext.line == nextLine;
				int wrappedColumns = regionContext.column + regionContext.getWrappedRequiredColumns() - nextColumn;
				assert wrappedColumns >= 0;
				int nestedMinimumRequiredColumns = AnchorWrappedColumns + wrappedColumns;
				if (nestedMinimumRequiredColumns > minimumRequiredColumns) {
					minimumRequiredColumns = nestedMinimumRequiredColumns;
				}
				int nestedMaximumRequiredColumns = regionContext.getUnwrappedRequiredColumns();
				if (nestedMaximumRequiredColumns > maximumRequiredColumns) {
					maximumRequiredColumns = nestedMaximumRequiredColumns;
				} */
			}
			else {
			//	throw new UnsupportedOperationException();
			}
			requiredLines = nextLine - regionContext.line;
			wrappedRequiredLines = nextWrappedLine - 0;


			return currentContext;
		}

		public String toHeaderString() {
			StringBuilder s = new StringBuilder();
			String format0 = "%25.25s --------unwrapped----------   --------------------wrapped--------------------   --local-\n";
			s.append(String.format(format0, ""));
			String format1 = "%25.25s current   next    required    current  next     required    old-anchor-new      required\n";
			s.append(String.format(format1, ""));
			String format2 = "%25.25s Line:Col Line:Col Line:Col    Line:Col Line:Col Line:Col   Pre,Post Pre,Post    Line:Col \n";
			s.append(String.format(format2, ""));
			return s.toString();
		}

		@Override
		public String toString() {
			String format = "R%03d %18.18s   %04d:%03d %04d:%03d +%03d:+%03d   +%02d:+%03d +%02d:+%03d +%02d:+%03d  +%03d,+%03d +%03d,+%03d   +%02d:+%03d\n";
			AbstractContext context = currentContext != null ? currentContext : regionContext;
			return String.format(format, regionContext.count, context.toString(),
				contextLine, contextColumn, nextLine, nextColumn, requiredLines, requiredColumns,
				currentWrappedLine, currentWrappedColumn, nextWrappedLine, nextWrappedColumn, wrappedRequiredLines, wrappedRequiredColumns, currentPreAnchorWrappedColumn, currentPostAnchorWrappedColumn, nextPreAnchorWrappedColumn, nextPostAnchorWrappedColumn,
				locallyRequiredLines, locallyRequiredColumns);
		}
	}

	/**
	 * An AnchorContext identifies (the left edge of) text that provides a column number to be
	 * matched in subsequent wrapped text.
	 */
	protected static class AnchorContext extends AbstractContext
	{
		public AnchorContext(@NonNull WrappingStringBuilder s) {
			super(s);
		}

		@Override
		public @NonNull String toString() {
			return "WrapAnchor " + super.toString();
		}
	}

	/**
	 * An EndContext identifies (the left edge of) the first character that follows a RegionContext.
	 */
	protected static class EndContext extends AbstractContext
	{
		public EndContext(@NonNull WrappingStringBuilder s) {
			super(s);
		}

		@Override
		public @NonNull String toString() {
			return "WrapEnd " + super.toString();
		}
	}

	/**
	 * A HereContext identifies (the left edge of) text that may be preceded by a wrapping new line
	 * and compensating indentation..
	 */
	protected static class HereContext extends AbstractContext
	{
		private int wrapColumn = -1;		// Set greater than zero to actually waro to wrapColumn.

		public HereContext(@NonNull WrappingStringBuilder s) {
			super(s);
		}

		@Override
		public @NonNull String toString() {
			return "WrapHere " + super.toString();
		}

		@Override
		public void toString(@NonNull FinalStringBuilder s) {
			super.toString(s);
			if (wrapColumn >= 0) {
				s.appendToColumn(wrapColumn);
			}
		}

		public void setWrapColumn(int wrapColumn) {
			this.wrapColumn = wrapColumn;
		}
	}

	/**
	 * An IndentEndContext identifies (the left edge of) text that follows the new line indentation.
	 */
	protected static class IndentedContext extends AbstractContext
	{
		public IndentedContext(@NonNull WrappingStringBuilder s) {
			super(s);
		}

		@Override
		public @NonNull String toString() {
			return "Indented " + super.toString();
		}
	}

	/**
	 * An IndentStartContext identifies (the left edge of) a hard new line.
	 */
	protected static class NewLineContext extends AbstractContext
	{
		protected final int newLineSize;

		public NewLineContext(@NonNull WrappingStringBuilder s, int newLineSize) {
			super(s);
			this.newLineSize = newLineSize;
		}

		@Override
		public @NonNull String toString() {
			return "NewLine " + super.toString();
		}

		@Override
		public void toString(@NonNull FinalStringBuilder s) {
			s.appendToOffset(this.offset + newLineSize);
		}
	}

	/**
	 * A RegionContext identifies (the left edge of) a wrapping region within which wrap-here
	 * markers contol mapping with respect to wrpa-anchor contexts.
	 */
	protected static abstract class RegionContext extends AbstractContext
	{
		private static int counter = 0;

		private final int count;

		private @NonNull List<@NonNull AbstractContext> childContexts = new ArrayList<>();

		/**
		 * The largest number of columns required for this region and all transitively nested regions when
		 * no wrapping is in force.
		 */
	//	private int zrequiredColumns = -1;

		/**
		 * The largest number of lines required for this region and all transitively nested regions when
		 * no wrapping is in force.
		 */
	//	private int zrequiredLines = -1;

		/**
		 * The smallest number of columns required for this region and all transitively nested regions when
		 * maximum wrapping is in force.
		 */
	//	private int zwrappedRequiredColumns = -1;

		/**
		 * The smallest number of lines required for this region and all transitively nested regions when
		 * maximum wrapping is in force.
		 */
	//	private int zwrappedRequiredLines = -1;
		private int wrappedLastLineColumns = -1;

		/**
		 * The smallest number of columns required for this region when this regionis wrapped but all other
		 * transitive;y nested regions are unwrapped.
		 */
	//	private int zlocallyRequiredColumns = -1;
	//	private int zlocallyRequiredLines = -1;
		private @Nullable ChildContextIterator contextAnalysis = null;

		/**
		 * The reduction in maximum line length from wrapping everything within this region
		 * while leaving all transitively nested regions at their unwrapped maxima.
		 */
		private int wrappingGain = -1;

		protected RegionContext(@NonNull WrappingStringBuilder s) {
			super(s);
			count = counter++;
		}

		public void addContext(@NonNull AbstractContext childContext) {
			childContexts.add(childContext);
		}

		/**
		 * Analyze three scenarios.
		 *
		 * No wrapping. Every NEW_LINE starts a new line with its first column aligned to WRAP_BEGIN.
		 *
		 * Maximal wrapping. Every NEW_LINE starts a new line with its first column aligned to WRAP_BEGIN.
		 * Every WRAP_HERE starts a new line with its first column aligned to the preceding WRAP_ANCHOR else WRAP_BEGIN.
		 *
		 * Local wrapping. Maximal wrapping for this region. No wrapping for nested regions.
		 */
		protected @NonNull ChildContextIterator analyzeWrapping() {

			@NonNull ChildContextIterator contextAnalysis = new ChildContextIterator(this);

			// Where (unwrapped) previous context left off
//			int currentLine = it.currentLine;			// Absolute (Relative to start of document)
//			int currentColumn = it.currentColumn;
			// Where (wrapped) previous context left off
//			int currentWrappedLine = 0;		// Relative (to start of region)
//			int currentWrappedColumn = 0;

//			int currentPreAnchorWrappedColumn = 0;		// Number of extra columns from region start column to current anchor
//			int currentPostAnchorWrappedColumn = 0;		// Number of extra columns from current anchor to current position.
		//	int maxLocalAdvance = 0;
		//	int maxWrappedAdvance = 0;		// largest preAnchorWrappedColumn plus postAnchorWrappedColumn
		//	int maxUnwrappedAdvance = 0;	// largest preAnchorWrappedColumn plus postAnchorWrappedColumn

		//	if (count == 0) {
		//		System.out.print(contextAnalysis.toHeaderString());
		//	}
		//	System.out.print(contextAnalysis.toString());
			wrappedLastLineColumns = contextAnalysis.currentWrappedColumn;
			return contextAnalysis;
		}

		protected @NonNull ChildContextIterator getContextAnalysis() {
			ChildContextIterator contextAnalysis2 = contextAnalysis;
			if (contextAnalysis2 == null) {
				contextAnalysis = contextAnalysis2 = analyzeWrapping();
			}
			return contextAnalysis2;
		}

		public abstract @NonNull RegionContext getParentContext();

		/**
		 * Return the maximum number of columns to render this region and all its child regions
		 * using only the the as-is unwrapped indented output.
		 */
		public int getRequiredColumns() {
			return getContextAnalysis().requiredColumns;
		}

		/**
		 * Return the maximum number of lines to render this region and all its child regions
		 * using only the the as-is unwrapped indented output.
		 */
		public int getRequiredLines() {
			return getContextAnalysis().requiredLines;
		}

		protected abstract int getWrapColumn();

		private int getWrappedLastLineColumns() {
			return wrappedLastLineColumns;
		}

		/**
		 * Return the minimum number of columns to render this region and all its child regions
		 * using only the declared wrapping capabilities; i.e. without using force majeur to
		 * break at arbitrary spaces.
		 */
		public int getWrappedRequiredColumns() {
			return getContextAnalysis().wrappedRequiredColumns;
		}

		/**
		 * Return the minimum number of lines to render this region and all its child regions
		 * using only the declared wrapping capabilities; i.e. without using force majeur to
		 * break at arbitrary spaces.
		 */
		public int getWrappedRequiredLines() {
			return getContextAnalysis().wrappedRequiredLines;
		}

		protected void setWrapColumn(int wrapColumn) {
			ChildContextIterator contextAnalysis2 = contextAnalysis;
			assert contextAnalysis2 != null;
			while (contextAnalysis2.hasNext()) {
				@NonNull AbstractContext childContext = contextAnalysis2.next();
			//	System.out.print(contextAnalysis2);
			//	int wrapColumn = getWrapColumn();
				if (wrapColumn >= 0) {
					if (childContext instanceof WrappingContext) {
						((WrappingContext)childContext).setWrapColumn(wrapColumn + contextAnalysis2.currentPreAnchorWrappedColumn + contextAnalysis2.currentPostAnchorWrappedColumn);
					}
					else if (childContext instanceof HereContext) {
						((HereContext)childContext).setWrapColumn(wrapColumn + contextAnalysis2.currentPreAnchorWrappedColumn);
					}
				}
			}
		}

		@Override
		public void toString(@NonNull FinalStringBuilder s) {
			super.toString(s);
			int anchorWrappedColumns = 0;
			@NonNull ChildContextIterator contextIterator = new ChildContextIterator(this);
			while (contextIterator.hasNext()) {
				@NonNull AbstractContext childContext = contextIterator.next();
				if (childContext instanceof AnchorContext) {
					AnchorContext anchorContext = ((AnchorContext)childContext);
				//	assert anchorContext.line == nextLine;
					anchorWrappedColumns = anchorContext.column - contextIterator.nextColumn;
					assert anchorWrappedColumns >= 0;
				}
			//	else if (childContext instanceof HereContext) {
			//		childContext.toString(s);
			//		HereContext hereContext = ((HereContext)childContext);
				//	assert hereContext.line == nextLine;
				//	nextLine = hereContext.line;
				//	nextColumn = hereContext.column;
			//		s.appendString("\n");
			//	}
				else {
				//	if ((anchorWrappedColumns > 0) && !(childContext instanceof NewLineContext)) {
				//		s.appendToColumn(anchorWrappedColumns);
					//	AnchorContext anchorContext = ((AnchorContext)childContext);
					//	assert anchorContext.line == nextLine;
					//	anchorWrappedColumns = anchorContext.column - contextIterator.nextColumn;
					//	assert anchorWrappedColumns >= 0;
				//	}
					childContext.toString(s);
				}
			}
		}
	}

	/**
	 * The RootContext identifies (the left edge of) the root/orphan wrapping region starting at
	 * line 0, column 0, offset 0 and ending at the end of the output.
	 */
	protected static class RootContext extends RegionContext
	{
		public RootContext(@NonNull WrappingStringBuilder s) {
			super(s);
		}

		@Override
		protected @NonNull ChildContextIterator getContextAnalysis() {
			ChildContextIterator contextAnalysis = super.getContextAnalysis();
			setWrapColumn(0);
			return contextAnalysis;
		}

		@Override
		public @NonNull RegionContext getParentContext() {
			throw new IllegalStateException();
		}

		@Override
		protected int getWrapColumn() {
			return 0;
		}

		@Override
		public void setWrapColumn(int wrapColumn) {
			assert wrapColumn == 0;
			super.setWrapColumn(wrapColumn);
		}

		@Override
		public @NonNull String toString() {
			return "WrapRoot " + super.toString();
		}
	}

	/**
	 * A WrappingContext identifies (the left edge of) a nested wrapping region.
	 */
	protected static class WrappingContext extends RegionContext
	{
		protected final boolean isAllOrNone;
		private final @NonNull RegionContext parentContext;
		private int wrapColumn = -1;		// Set greater than zero to actually waro to wrapColumn.

		protected WrappingContext(@NonNull RegionContext parentContext, @NonNull WrappingStringBuilder s, boolean isAllOrNone) {
			super(s);
			this.isAllOrNone = isAllOrNone;
			this.parentContext = parentContext;
		}

		@Override
		public @NonNull RegionContext getParentContext() {
			return parentContext;
		}

		@Override
		protected int getWrapColumn() {
			return wrapColumn;
		}

		@Override
		public void setWrapColumn(int wrapColumn) {
			this.wrapColumn = wrapColumn;
			super.setWrapColumn(wrapColumn);
		}

		@Override
		public @NonNull String toString() {
			return "WrapBegin " + super.toString();
		}
	}

	/**
	 * The FinalStringBuilder copies characters from the input StringBuilder keeping track
	 * of the current and start of line output column so that the appropriate inentation can
	 * be re-copied to support line wrapping,
	 */
	protected static class FinalStringBuilder
	{
		private final @NonNull StringBuilder sIn;
		protected final @NonNull String newLineString;
		protected final int tabWidth;
		private final @NonNull StringBuilder sOut = new StringBuilder();
		private int currentInputOffset = 0;
		private int startOfOutputLineOffset = 0;
		private int currentOutputColumn = 0;

		protected FinalStringBuilder(@NonNull StringBuilder sIn, @NonNull String newLineString, int tabWidth) {
			this.sIn = sIn;
			this.newLineString = newLineString;
			this.tabWidth = tabWidth;
			assert tabWidth > 0;
		}

		/**
		 * Append a character eeping track of the current and start of line output column.
		 */
		private void appendChar(char c) {
			sOut.append(c);
			if (c == '\n') {
				currentOutputColumn = 0;
				startOfOutputLineOffset = sOut.length();
			}
			else if (c == '\t') {
				currentOutputColumn = ((currentOutputColumn / tabWidth) + 1) * tabWidth;
			}
			else if (c == '\r') {
				if (currentOutputColumn == 0) {
					startOfOutputLineOffset = sOut.length();
				}
			}
			else {
				currentOutputColumn++;
			}
		}

		/**
		 * Append characters from string.
		 */
		public void appendString(@NonNull String string) {
			int length = string.length();
			for (int i = 0; i < length; i++) {
				char c = string.charAt(i);
				appendChar(c);
			}
		}

		/**
		 * Copy characters from the start of the current line to advance to anchorColumn on a new line.
		 */
		public void appendToColumn(int anchorColumn) {
			assert anchorColumn <= currentOutputColumn;
			int outputOffset = startOfOutputLineOffset;
			appendString(newLineString);
			while (currentOutputColumn < anchorColumn) {
				char c = sOut.charAt(outputOffset++);
				assert c != '\n';
				assert (c != '\r') || (currentOutputColumn == 0);
				appendChar(Character.isWhitespace(c) ? c : ' ');
			}
			assert currentOutputColumn == anchorColumn;
		}

		/**
		 * Copy input characters from currentInputOffset up to the newInputOffset.
		 */
		public void appendToOffset(int newInputOffset) {
			if (newInputOffset > currentInputOffset) {
				String substring = sIn.substring(currentInputOffset, newInputOffset);
				assert substring != null;
				appendString(substring);
				currentInputOffset = newInputOffset;
			}
		}

		@Override
		public String toString() {
			return sOut.toString();
		}
	}

	protected static class WrappingStringBuilder
	{
		private final @NonNull StringBuilder s;

		/**
		 * The maximum number of characters (excluding new line characters) per line. Less than 1 for no limit.
		 */
		protected final int lineLength;

		/**
		 * The string for a new-line; typically \n unless \r\n or \n\r really wanted.
		 */
		protected final @NonNull String newLineString;

		/**
		 * The number of spaces between tab columns; typically 8..
		 */
		protected final int tabWidth;

		/**
		 * The line number for the next character - line 0 is first.
		 */
		private int nextLine = 0;

		/**
		 * The column number for the next character - column 0 is first.
		 */
		private int nextColumn = 0;

		private final @NonNull RootContext rootContext;
		private @NonNull RegionContext currentContext;

		public WrappingStringBuilder(@NonNull StringBuilder s, int lineLength, @NonNull String newLineString, int tabWidth) {
			this.s = s;
			this.lineLength = lineLength;
			this.newLineString = newLineString;
			this.tabWidth = tabWidth;
			this.rootContext = new RootContext(this);
			this.currentContext = rootContext;
		}

		public void append(@Nullable String string) {
			if (string != null) {
				if (WRAP_ANCHOR == string) {
					currentContext.addContext(new AnchorContext(this));
				}
				else if (WRAP_BEGIN_ALL == string) {
					WrappingContext childContext = new WrappingContext(currentContext, this, true);
					currentContext.addContext(childContext);
					currentContext = childContext;
				}
				else if (WRAP_BEGIN_SOME == string) {
					WrappingContext childContext = new WrappingContext(currentContext, this, false);
					currentContext.addContext(childContext);
					currentContext = childContext;
				}
				else if (WRAP_END == string) {
					currentContext.addContext(new EndContext(this));
					currentContext = currentContext.getParentContext();
				}
				else if (WRAP_HERE == string) {
					currentContext.addContext(new HereContext(this));
				}
				else {
					for (int i = 0; i < string.length(); i++) {
						char c = string.charAt(i);
						s.append(c);
						if (c == '\n') {
							nextColumn = 0;
							nextLine++;
						}
						else if (c == '\r') {
							// ignore
						}
						else if (c == '\t') {
							nextColumn = ((nextColumn / tabWidth) + 1) * tabWidth;
						}
						else {
							nextColumn++;
						}
					}
				}
			}
		}

		public void appendIndent(@NonNull String indents) {
			int size = indents.length();
			assert size > 0;
			append(indents);
			currentContext.addContext(new IndentedContext(this));
		}

		public void appendNewLine(int newLineSize) {
			currentContext.addContext(new NewLineContext(this, newLineSize));
		}

		public void close() {
		}

		public int getColumn() {
			return nextColumn;
		}

		public int getLine() {
			return nextLine;
		}

		public int getOffset() {
			return s.length();
		}

		@Override
		public @NonNull String toString() {
			int maximumRequiredColumns = rootContext.getRequiredColumns();
			int minimumRequiredColumns = rootContext.getWrappedRequiredColumns();
			if ((lineLength > 0) && (maximumRequiredColumns > lineLength)) {
				FinalStringBuilder sOut = new FinalStringBuilder(s, newLineString, tabWidth);
				rootContext.toString(sOut);
			//	assert offset == s.length();
				@SuppressWarnings("null")
				@NonNull String castString = (@NonNull String)String.valueOf(sOut);
				return castString;
			}
			else {
				@SuppressWarnings("null")
				@NonNull String castString = (@NonNull String)String.valueOf(s);
				return castString;
			}
		}
	}

	protected static class IndentingStringBuilder
	{

		/**
		 * The string for a new-line; typically \n unless \r\n or \n\r really wanted.
		 */
		protected final @NonNull String lineDelimiter;

		/**
		 * The string for an additional level of indentation; typically four spaces.
		 */
		protected final @NonNull String indentString;

		/**
		 * The string to be concatenated as indentation following a new line.
		 */
		private @NonNull Stack<@NonNull String> indents = new Stack<>();

		/**
		 * True if a new-line has been output and not followed by anything else.
		 */
		private boolean atStartOfLine = true;

		private final @NonNull WrappingStringBuilder s;

		public IndentingStringBuilder(@NonNull WrappingStringBuilder s, @NonNull String lineDelimiter, @NonNull String indentString) {
			this.s = s;
			this.lineDelimiter = lineDelimiter;
			this.indentString = indentString;
		}

		public void append(@NonNull String string) {
			s.append(string);
			if (atStartOfLine && !string.isEmpty()) {
				atStartOfLine = false;
			}
		}

		protected void appendNewLine(boolean isRaw) {
			if (atStartOfLine && !indents.isEmpty()) {
				@Nullable String indent = indents.peek();
				assert indent != null;
				int length = indent.length();
				if (length > 0) {
					char lastChar = indent.charAt(length-1);
					if (!Character.isWhitespace(lastChar)) {
						s.appendIndent(indent);
					}
				}
			}
			s.appendNewLine(lineDelimiter.length());
			append(lineDelimiter);
			atStartOfLine = !isRaw;
		}

		protected String appendString(@NonNull String string) {
			if (atStartOfLine && !string.isEmpty() && !indents.isEmpty()) {
				s.appendIndent(indents.peek());
			}
			append(string);
			return null;
		}

		public void close() {
			if (!atStartOfLine) {
				appendNewLine(false);
			}
			s.close();
		}

		public void pop() {
			indents.pop();
		}

		public void push(@NonNull String indentString) {
			if (indents.isEmpty()) {
				indents.push(indentString);
			}
			else {
				indents.push(indents.peek() + indentString);
			}
		}

		@Override
		public @NonNull String toString() {
			@SuppressWarnings("null")
			@NonNull String castString = (@NonNull String)String.valueOf(s);
			return castString;
		}
	}

	public static void reset() {
		RegionContext.counter = 0;
	}

	/**
	 * The string for a new-line; typically \n unless \r\n or \n\r really wanted.
	 */
	protected @NonNull String lineDelimiter;

	/**
	 * The string for an additional level of indentation; typically four spaces.
	 */
	protected @NonNull String indentString;

	/**
	 * The maximum number of characters (excluding new line characters) per line. Less than 1 for no limit.
	 */
	protected int lineLength;

	/**
	 * The number of spaces between tab columns; typically 8..
	 */
	protected int tabWidth;

	protected final @NonNull IndentingStringBuilder s;

	/**
	 * The serialization state hanging over from the previous append.
	 * pushingNext is the state of a two-valued concurrent state machine.
	 *
	 *</br> null - unadulterated output
	 *</br> NO_SPACE - unadulterated output greedily absorbing SOFT_SPACEs
	 *</br> SOFT_SPACE - a single space is needed and pending
	 *</br> SOFT_NEW_LINE - a single new line is needed and pending
	 *</br> HALF_NEW_LINE - a half new line is needed and pending if followed by another half new line
	 */
	private @Nullable String trailingStringState = NO_SPACE;

	/**
	 * True if the last append was PUSH_NEXT and so the next append is its argument.
	 * trailingStringState is the state of a five-valued concurrent state machine.
	 */
	private boolean pushingNext = false;

	/**
	 * Debug trace of the strings to be rendered as output.
	 */
//	private final @Nullable List<@Nullable String> debugStrings = null; // new ArrayList<>(1000);

	/**
	 * Errors embedded in the output and also here.
	 */
	private @Nullable List<@NonNull String> errors = null;

	public SerializationBuilder() {
		// See Bug 439440 for the inability to pass useful EMF save options via SaveOptions forcing in-built Xtext defaults
		this("\n", "\t", 0, 4);
	}

	public SerializationBuilder(@NonNull String lineDelimiter, @NonNull String indentString) {
		this(lineDelimiter, indentString, 0, 8);
	}

	public SerializationBuilder(@NonNull String lineDelimiter, @NonNull String indentString, int lineLength, int tabWidth) {
		this.lineDelimiter = lineDelimiter;
		this.indentString = indentString;
		this.lineLength = lineLength;
		this.tabWidth = tabWidth;
		WrappingStringBuilder sw = new WrappingStringBuilder(new StringBuilder(), lineLength, lineDelimiter, tabWidth);
		this.s = new IndentingStringBuilder(sw, lineDelimiter, indentString);
	}

	/**
	 * Append nextString, which may be a virtual character such as SOFT_SPACE, to the serialized output.
	 */
	public void append(@Nullable String nextString) {
	//	if (debugStrings != null) {
	//		debugStrings.add(nextString);
	//	}
		// == rather than String.equals() in the following to use the dedicated non-interned singletons
		if (nextString == null) {
			/* ignore */;
		}
		else if (pushingNext) {
			pushingNext = false;
			s.push(nextString);
		}
		else if (nextString == PUSH_NEXT) {
			pushingNext = true;
		}
		else if (nextString == PUSH) {
			s.push(indentString);
		}
		else if (nextString == POP) {
			s.pop();
		}
		else if (nextString == NEW_LINE) {
			s.appendNewLine(false);
			trailingStringState = NO_SPACE;
		}
		else if (nextString == RAW_NEW_LINE) {
			s.appendNewLine(true);
			trailingStringState = NO_SPACE;
		}
		else if (nextString == HALF_NEW_LINE) {
			if ((trailingStringState == SOFT_NEW_LINE) || (trailingStringState == HALF_NEW_LINE)) {
				s.appendNewLine(false);
				trailingStringState = NO_SPACE;
			}
			else {
				trailingStringState = HALF_NEW_LINE;
			}
		}
		else if (nextString == SOFT_NEW_LINE) {
			trailingStringState = SOFT_NEW_LINE;
		}
		else if (nextString == SOFT_SPACE) {
			if (trailingStringState == NO_SPACE) {
				trailingStringState = NO_SPACE;
			}
			else if ((trailingStringState == NEW_LINE) || (trailingStringState == RAW_NEW_LINE) || (trailingStringState == HALF_NEW_LINE)) {
				trailingStringState = NO_SPACE;
			}
			else if (trailingStringState == SOFT_NEW_LINE) {
				s.appendNewLine(false);
				trailingStringState = NO_SPACE;
			}
			else {	// trailingStringState == null
				trailingStringState = SOFT_SPACE;
			}
		}
		else if (nextString == NO_SPACE) {
			if (trailingStringState == SOFT_NEW_LINE) {
				s.appendNewLine(false);
			}
			trailingStringState = NO_SPACE;
		}
		else {	// nextString - hard text
			if (trailingStringState == SOFT_NEW_LINE) {
				s.appendNewLine(false);
			}
			else if ((trailingStringState == SOFT_SPACE) && !nextString.startsWith("\n")) {
				s.appendString(" ");
			}
			for (int start = 0; true; ) {
				int index = nextString.indexOf('\n', start);
				String line = nextString.substring(start, index >= 0 ? index : nextString.length());
				assert line != null;
				if (line.length() > 0) {
					s.appendString(line);
				}
				if (index >= 0) {
					s.appendNewLine(true);
					start = index+1;
				}
				else {
					break;
				}
			}
			trailingStringState = null;
		}
	}

	/**
	 * Append string to the serialized output and also to the list of errors maintained for return by {@link getErrors()}.
	 */
	public void appendError(@NonNull String string) {
		List<@NonNull String> errors2 = errors;
		if (errors2 == null) {
			errors = errors2 = new ArrayList<>();
		}
		errors2.add(string);
		append(string);
	}

	/**
	 * Ensure that the internal string buffers are terminated thereby ensuring a trainling new line.
	 */
	public void close() {
		s.close();
	}

	public @Nullable Iterable<@NonNull String> getErrors() {
		return errors;
	}

	public int getLineLength() {
		return lineLength;
	}

	public int getTabWidth() {
		return tabWidth;
	}

	public void setIndentString(@NonNull String indentString) {
		this.indentString = indentString;
	}

	public void setLineDelimiter(@NonNull String lineDelimiter) {
		this.lineDelimiter = lineDelimiter;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public void setTabWidth(int tabWidth) {
		this.tabWidth = tabWidth;
	}

/*	@Override
	public void toDebugString(@NonNull StringBuilder s, int depth) {
		if (debugStrings != null) {
			for (@Nullable String string : debugStrings) {
				s.append(string);
				if ((string == NEW_LINE) || (string == HALF_NEW_LINE) || (string == RAW_NEW_LINE) || (string == SOFT_NEW_LINE)) {
					s.append("\n");
				}
			}
		}
		else {
			s.append(this.s.toString());
			s.append("\n");
		}
	} */

	@Override
	public @NonNull String toString() {
		return s.toString();
	}
}