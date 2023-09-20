/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * A memory efficient structure to store qualified names composed of string segments separated by '/'. A QualifiedName must be constructed through one
 * its create methods. The structure uses string pooling to store the single segments. Further it maintains a pool of QualifiedName instances itself,
 * so that each QualifiedName exists only once.
 */
public final class QualifiedNameWithDelimiter {
	/**
	 * The segment separator character.
	 */
	protected final static char SLASH = '/';

	/**
	 * The instance used to represent no segments.
	 */
	protected static final String[] EMPTY_ARRAY = new String[0];

	/**
	 * The cached pool for the qualified name instances.
	 */
	protected static final QualifiedNameCache CACHE = new QualifiedNameCache();

	/**
	 * A cached for pool for strings.
	 */
	protected static final StringCache STRING_CACHE = new StringCache();

	/**
	 * The qualified name instance corresponding to the empty string.
	 */
	protected static final QualifiedNameWithDelimiter EMPTY_WITHOUT_LEADING_SLASH = CACHE.intern(false, false, false, EMPTY_ARRAY);

	/**
	 * The qualified name instance corresponding to "/".
	 */
	protected static final QualifiedNameWithDelimiter EMPTY = CACHE.intern(true, false, false, EMPTY_ARRAY);

	/**
	 * The cached hash code for this instance.
	 */
	protected final int hashCode;

	/**
	 * The segments for this instance.
	 */
	protected String[] segments;

	/**
	 * The cached value for {@link #toString()}.
	 */
	protected WeakReference<String> toString;

	/**
	 * Creates an instance with the given segments and hash code.
	 */
	protected QualifiedNameWithDelimiter(final String[] segments, final int hashCode) {
		this.segments = segments;
		this.hashCode = hashCode;
	}

	/**
	 * Returns an instance with the given additional segments.
	 */
	public QualifiedNameWithDelimiter append(final QualifiedNameWithDelimiter qualifiedName) {
		boolean hasLeadingSlash = hasLeadingSlash();

		// If the segments are empty...
		//
		if (segments == EMPTY_ARRAY) {
			// Ensure that the result has the same leading slash.
			//
			if (hasLeadingSlash == !qualifiedName.hasLeadingSlash()) {
				return CACHE.intern(hasLeadingSlash, false, false, qualifiedName.segments);
			}
			// We can just return the argument.
			//
			return qualifiedName;
		}

		// We must compose the segments.
		//
		return CACHE.intern(hasLeadingSlash, segments, qualifiedName.segments);
	}

	/**
	 * Returns an instance with the additional segment or segments, if the given segment contains '/'.
	 */
	public QualifiedNameWithDelimiter append(final String segment) {
		// If the segments are empty...
		//
		if (segments == EMPTY_ARRAY) {
			// Create an instance with the appropriate leading slash characteristic.
			//
			return hasLeadingSlash() ? create(segment) : createWithoutLeadingSlash(segment);
		}

		// If the segment contains slashes, append its corresponding qualified name.
		//
		if (segment.indexOf(SLASH) != -1) {
			return append(create(segment));
		}

		// We must find it in the cache.
		//
		return CACHE.intern(hasLeadingSlash(), segments, segment);
	}

	/**
	 * Returns a canonical string representation.
	 */
	@Override
	public String toString() {
		int segmentCount = segments.length;
		switch (segmentCount) {
		case 0:
			// If there are no segments, return the appropriate representation depending on whether there's a leading slash.
			//
			return hasLeadingSlash() ? "/" : "";
		case 1:
			// If there is no leading slash, we can just return the segment itself.
			//
			if (!hasLeadingSlash()) {
				return segments[0];
			}
			//$FALL-THROUGH$
		default:
			// If we don't have a cached result...
			//
			String result = toString != null ? toString.get() : null;
			if (result == null) {
				// Build up a result...
				//
				StringBuilder builder = new StringBuilder(segmentCount * 8);

				// If there is a leading slash, include it.
				//
				if (hasLeadingSlash()) {
					builder.append(SLASH);
				}
				// Include the first segment.
				//
				builder.append(segments[0]);

				// Include the remaining segments with a slash before each one.
				//
				for (int i = 1; i < segmentCount; i++) {
					builder.append(SLASH);
					builder.append(segments[i]);
				}
				result = builder.toString();

				// Cache the string for reuse on subsquent calls.
				//
				toString = new WeakReference<String>(result);
			}
			return result;
		}
	}

	/**
	 * Returns whether the qualified name's string representation starts with a '/'.
	 */
	public boolean hasLeadingSlash() {
		// Whether there's a leading slash is encoded in the high bit of the hash code.
		//
		return (hashCode & ~0x7FFFFFF) != 0;
	}

	/**
	 * Returns the hash code with the appropriately swizzled high bit.
	 */
	protected static int setLeadingSlash(final boolean hasLeadingSlash, final int hashCode) {
		if (hasLeadingSlash) {
			// Leading separator.
			// Mask in the high bit.
			//
			return hashCode | ~0x7FFFFFF;
		}
		// No leading separator.
		// Mask out the high bit.
		//
		return hashCode & 0x7FFFFFF;
	}

	/**
	 * Returns the number of segments in the qualified name.
	 */
	public int getSegmentCount() {
		return segments.length;
	}

	/**
	 * Returns the specified segment of the qualified name.
	 */
	public String getSegment(final int index) {
		return segments[index];
	}

	/**
	 * Returns the last segment of the qualified name.
	 */
	public String getLastSegment() {
		return segments[segments.length - 1];
	}

	/**
	 * Returns the first segment of the qualified name.
	 */
	public String getFirstSegment() {
		return segments[0];
	}

	/**
	 * Although there is an override of hash code, there is no override of {@link #equals(Object)} because the static methods for creation ensure
	 * there is at most one instance created for each unique qualified name.
	 */
	@Override
	public int hashCode() {
		return hashCode;
	}

	/**
	 * Returns true if the {@link #toString() string representation} of this qualified name is equal to the given string.
	 */
	public boolean matches(final String qualifiedName) {
		int segmentCount = segments.length;
		if (segmentCount == 0) {
			// If there are no segments, the string must either be "/" or "", as appropriate.
			//
			boolean hasLeadingSlash = hasLeadingSlash();
			int length = qualifiedName.length();
			return hasLeadingSlash ? (length == 1) && (qualifiedName.charAt(0) == SLASH) : length == 0;
		} else if (segmentCount == 1) {
			// If there is one segment, the argument must either start with "/", end with segment, and be of the correct length, or it must be equal
			// that segment, as appropriate.
			//
			boolean hasLeadingSlash = hasLeadingSlash();
			int length = qualifiedName.length();
			String segment = segments[0];
			return hasLeadingSlash ? ((segment.length() + 1) == length) && (qualifiedName.charAt(0) == SLASH) && qualifiedName.endsWith(segment)
					: segment.equals(qualifiedName);
		} else if (toString != null) {
			// If there is a cached string with a referent, it must be equal to the argument.
			//
			String string = toString.get();
			if (string != null) {
				return string.equals(qualifiedName);
			}
			toString = null;
		}

		// We need to match against all the segments.
		//
		boolean hasLeadingSlash = hasLeadingSlash();
		String segment = segments[0];
		int index = segment.length();
		if (hasLeadingSlash) {
			// If the argument doesn't start with a slash followed by the segment, return false.
			//
			if ((qualifiedName.charAt(0) != SLASH) || !qualifiedName.startsWith(segment, 1)) {
				return false;
			}
			// Skip over the slash as well.
			//
			++index;
		} else {
			// If the argument doesn't start with the segment, return false.
			//
			if (!qualifiedName.startsWith(segment)) {
				return false;
			}
		}

		// Iterate over all the remaining segments.
		//
		int length = qualifiedName.length();
		for (int i = 1; i < segmentCount; ++i) {
			// We we've gone too far or there isn't a separator as expected, return false.
			//
			if ((index >= length) || (qualifiedName.charAt(index) != SLASH)) {
				return false;
			}
			// Skip past the separator.
			//
			++index;
			// If the argument doesn't start with the segment at the current index, return false.
			//
			segment = segments[i];
			if (!qualifiedName.startsWith(segment, index)) {
				return false;
			}
			// Skip past this segment.
			//
			index += segment.length();
		}

		// The string matches, so given we don't have a cached toString, we may as well cache this one.
		//
		toString = new WeakReference<String>(qualifiedName);

		return true;
	}

	/**
	 * A cached pool of weakly referenced strings. When adding a new string, this pool will always cache a new minimally sized string.
	 */
	protected static class StringCache extends WeakInterningHashSet<String> {
		private static final long serialVersionUID = 1L;

		/**
		 * A buffer for processing characters to avoid so many calls to {@link String#charAt(int)}.
		 */
		protected char[] buffer = new char[100];

		/**
		 * Returns the interned string for the given character range and its hash code, which must be equivalent to what's computed by
		 * {@link String#hashCode()}.
		 */
		protected synchronized String intern(final char[] characters, final int offset, final int count, final int hashCode) {

			// Loop through all the entries with the given hash code.
			//
			LOOP: for (Entry<String> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
				// If the value hasn't been garbage collected...
				//
				String value = entry.get();
				if (value != null) {
					// If the value's length matches...
					//
					int length = value.length();
					if (length == count) {
						// Ensure that the bugger is big enough...
						//
						if (buffer.length < count) {
							buffer = new char[count];
						}
						// Fetch the contents of the value into the buffer.
						//
						value.getChars(0, count, buffer, 0);
						// If any of the corresponding characters aren't the same, continue with the outer loop.
						//
						for (int i = 0; i < count; ++i) {
							if (characters[offset + i] != buffer[i]) {
								break LOOP;
							}
						}
						// The value is equal, so return it.
						//
						return value;
					}
				}
			}
			// Create a new string, add it to the pool, and return it.
			//
			String value = new String(characters, offset, count);
			addEntry(new Entry<String>(value, hashCode, queue));
			return value;
		}

		@Override
		public synchronized String intern(final String object) {
			return super.intern(object);
		}

		@Override
		protected Entry<String> createEntry(final String object, final int hashCode) {
			// This ensures that we do not keep the original argument string in the pool.
			// It's expected that pooled strings will are likely to be around for a long time, and the argument string could be a substring of a much
			// larger string that would lock in the much larger underlying character array.
			// Note that the new string will share the underlying character array of the argument if that array is exactly the size of the string.
			//
			return super.createEntry(new String(object), hashCode);
		}
	}

	/**
	 * A cached pool of weakly referenced qualified names. There are several ways of interning instances, all of which seek to avoid creating new
	 * objects whenever possible. This implementation provides the hash code computations for a qualified name. It's carefully designed to ensure that
	 * a qualified name's hash code is the same as that of its string representation, except for the
	 * {@link QualifiedNameWithDelimiter#setLeadingSlash(boolean, int) encoding} of the leading slash.
	 */
	protected static class QualifiedNameCache extends WeakInterningHashSet<QualifiedNameWithDelimiter> {
		private static final long serialVersionUID = 1L;

		/**
		 * A cached array for the 31^n.
		 */
		protected static int[] POWERS_OF_31;

		/**
		 * A buffer for character level processing.
		 * 
		 */
		protected char[] buffer = new char[100];

		/**
		 * A buffer for buiding up string segments.
		 */
		protected String[] segmentBuffer = new String[100];

		/**
		 * Returns 31^n.
		 */
		protected static int powerOf31(final int n) {
			// Allocates an array of values big enough to hold at least n values.
			//
			if ((POWERS_OF_31 == null) || (POWERS_OF_31.length <= n)) {
				POWERS_OF_31 = new int[Math.max(POWERS_OF_31 == null ? 100 : POWERS_OF_31.length * 2, n + 1)];

				// Compute the power values.
				//
				int powerOf31 = 1;
				for (int i = 0; i < POWERS_OF_31.length; ++i) {
					POWERS_OF_31[i] = powerOf31;
					powerOf31 *= 31;
				}
			}
			return POWERS_OF_31[n];
		}

		/**
		 * A helper utility for computing the hash code starting with a base code and taking the given segments into account. * It emulates the
		 * computation done for {@link String#hashCode()}.
		 */
		protected static int hashCode(final int initialHashCode, final String[] segments) {
			// The hash code for no segments is just the original hash code.
			//
			int length = segments.length;
			if (length == 0) {
				return initialHashCode;
			}
			String segment = segments[0];
			int hashCode = (initialHashCode == 0 ? 0 : initialHashCode * powerOf31(segment.length())) + segment.hashCode();
			if (length > 1) {
				for (int i = 1; i < length; ++i) {
					hashCode = (hashCode * 31) + SLASH;
					segment = segments[i];
					hashCode = (hashCode * powerOf31(segment.length())) + segment.hashCode();
				}
			}
			return hashCode;
		}

		/**
		 * Computes the hash code for the segments, taking into account whether there is a leading slash.
		 */
		protected static int hashCode(final boolean hasLeadingSlash, final String[] segments) {
			return setLeadingSlash(hasLeadingSlash, hashCode(hasLeadingSlash ? SLASH : 0, segments));
		}

		/**
		 * Interns the segments, taking into account the leading slash, copying the array when needed, and interning the segments themselves, when
		 * needed.
		 */
		public QualifiedNameWithDelimiter intern(final boolean hasLeadingSlash, final boolean needsCopying, final boolean needsToIntern,
				final String[] segments) {

			// Iterate over the entries with the matching hash code.
			//
			int hashCode = hashCode(hasLeadingSlash, segments);
			synchronized (this) {

				for (Entry<QualifiedNameWithDelimiter> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
					QualifiedNameWithDelimiter qualifiedName = entry.get();
					if (qualifiedName != null) {
						// If the segments are the same, return this instance.
						// Note that because the leading slash is encoded in the hash code, we know that this qualified name has the appropriate
						// leading slash setting.
						//
						if (equals(qualifiedName.segments, segments)) {
							return qualifiedName;
						}
					}
				}

				// Copy the array and intern the segments as appropriate.
				//
				int length = segments.length;
				String[] newSegments = segments;
				if (needsCopying) {
					newSegments = new String[length];
					if (needsToIntern) {
						for (int i = 0; i < length; ++i) {
							newSegments[i] = STRING_CACHE.intern(segments[i]);
						}
					} else {
						System.arraycopy(segments, 0, newSegments, 0, length);
					}
				} else if (needsToIntern) {
					for (int i = 0; i < length; ++i) {
						segments[i] = STRING_CACHE.intern(segments[i]);
					}
				}

				// Create the new instance, add it to the pool, and return it.
				//
				QualifiedNameWithDelimiter qualifiedName = new QualifiedNameWithDelimiter(newSegments, hashCode);
				addEntry(createEntry(qualifiedName, hashCode));
				return qualifiedName;
			}
		}

		/**
		 * Computes the hash code for the segments along with the one additional segment, taking into account whether there is a leading slash.
		 */
		protected static int hashCode(final boolean hasLeadingSlash, final String[] segments, final String segment) {
			int hashCode = hashCode(hasLeadingSlash ? SLASH : 0, segments);
			hashCode = (hashCode * 31) + SLASH;
			hashCode = (hashCode * powerOf31(segment.length())) + segment.hashCode();
			return setLeadingSlash(hasLeadingSlash, hashCode);
		}

		/**
		 * Interns the segments along with the one additional segment, taking into account the leading slash and interning the additional segment. All
		 * callers of this method will already have interned the segments.
		 */
		protected QualifiedNameWithDelimiter intern(final boolean hasLeadingSlash, final String[] segments, final String segment) {

			int length1 = segments.length;
			int length = length1 + 1;
			int hashCode = hashCode(hasLeadingSlash, segments, segment);

			// Iterate over the entries with the matching hash code.
			//
			synchronized (this) {
				LOOP: for (Entry<QualifiedNameWithDelimiter> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
					QualifiedNameWithDelimiter qualifiedName = entry.get();
					if (qualifiedName != null) {
						// If the segments counts don't match, continue with the next entry.
						//
						String[] entrySegments = qualifiedName.segments;
						if (length != entrySegments.length) {
							continue LOOP;
						}

						// If the segments are not identical strings---remember, they're all interned--- continue with the next entry.
						//
						int i = 0;
						for (; i < length1; ++i) {
							if (entrySegments[i] != segments[i]) {
								continue LOOP;
							}
						}

						// If the last entry doesn't match the additional segment, continue with the next entry.
						//
						if (!segment.equals(entrySegments[i])) {
							continue LOOP;
						}

						// Otherwise it's a match, so return it.
						//
						return qualifiedName;
					}
				}

				// Allocate the new segments, fill them, including the interned additional segment, create an instance from that, add it to the cache,
				// and
				// return it.
				//
				String[] newSegments = new String[length];
				System.arraycopy(segments, 0, newSegments, 0, length1);
				newSegments[length1] = STRING_CACHE.intern(segment);
				QualifiedNameWithDelimiter qualifiedName = new QualifiedNameWithDelimiter(newSegments, hashCode);
				addEntry(createEntry(qualifiedName, hashCode));
				return qualifiedName;
			}
		}

		/**
		 * Computes the hash code for the composed segments, taking into account whether there is a leading slash.
		 */
		protected static int hashCode(final boolean hasLeadingSlash, final String[] segments1, final String[] segments2) {
			int hashCode = hashCode(hasLeadingSlash ? SLASH : 0, segments1);
			if (segments2.length > 0) {
				hashCode = (hashCode * 31) + SLASH;
				hashCode = hashCode(hashCode, segments2);
			}
			return setLeadingSlash(hasLeadingSlash, hashCode);
		}

		/**
		 * Interns the composed segments, taking into account the leading slash. All callers of this method will already have interned the segments.
		 */
		protected QualifiedNameWithDelimiter intern(final boolean hasLeadingSlash, final String[] segments1, final String[] segments2) {

			int length1 = segments1.length;
			int length2 = segments2.length;
			int length = length1 + length2;
			int hashCode = hashCode(hasLeadingSlash, segments1, segments2);

			synchronized (this) {
				// Iterate over the entries with the matching hash code.
				//
				LOOP: for (Entry<QualifiedNameWithDelimiter> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
					QualifiedNameWithDelimiter qualifiedName = entry.get();
					if (qualifiedName != null) {
						// If the segment count doesn't match, continue with the next entry.
						//
						String[] segments = qualifiedName.segments;
						if (length != segments.length) {
							continue LOOP;
						}

						// If the leading segments are not identical strings---remember, they're all interned--- continue with the next entry.
						//
						int i = 0;
						for (; i < length1; ++i) {
							if (segments[i] != segments1[i]) {
								continue LOOP;
							}
						}

						// If the remaining segments are not identical strings, continue with the next entry.
						//
						for (int j = 0; j < length2; ++i, ++j) {
							if (segments[i] != segments2[j]) {
								continue LOOP;
							}
						}

						// Otherwise it's a match, so return it.
						//
						return qualifiedName;
					}
				}

				// Allocate the new segments, fill them, create an instance from that, add it to the cache, and return it.
				//
				String[] newSegments = new String[length];
				System.arraycopy(segments1, 0, newSegments, 0, length1);
				System.arraycopy(segments2, 0, newSegments, length1, length2);
				QualifiedNameWithDelimiter qualifiedName = new QualifiedNameWithDelimiter(newSegments, hashCode);
				addEntry(createEntry(qualifiedName, hashCode));
				return qualifiedName;
			}
		}

		/**
		 * Interns the string representation of a qualified name, splitting it into appropriate segments.
		 */
		protected QualifiedNameWithDelimiter intern(final String name) {

			// The empty string maps to the special empty constant.
			//
			int length = name.length();
			if (length == 0) {
				return EMPTY_WITHOUT_LEADING_SLASH;
			}

			// Iterate over all the entries with a matching hash code.
			//
			boolean hasLeadingSlash = name.charAt(0) == SLASH;
			int hashCode = setLeadingSlash(hasLeadingSlash, name.hashCode());
			synchronized (this) {

				for (Entry<QualifiedNameWithDelimiter> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
					QualifiedNameWithDelimiter qualifiedName = entry.get();
					if (qualifiedName != null) {
						// If the qualified name of the entry matches the argument, return it.
						//
						if (qualifiedName.matches(name)) {
							return qualifiedName;
						}
					}
				}

				// Prepare the buffer to hold enough characters.
				//
				if (buffer.length < length) {
					buffer = new char[length];
				}

				// Fill the buffer with the characters; this avoids so many calls to charAt!
				//
				name.getChars(0, length, buffer, 0);

				// Keep track of how many segments we've slit out.
				//
				int segmentCount = 0;

				// Compute the hash code of each segment while we're already looking at each character anyway.
				//
				int segmentHashCode = 0;

				// Remember the starting index of the current segment, skipping past the leading slash if there is one.
				//
				int start = hasLeadingSlash ? 1 : 0;

				// Iterate over all the characters in the buffer.
				//
				for (int i = start; i < length; ++i) {
					// If we hit a slash...
					//
					char c = buffer[i];
					if (c == SLASH) {

						// Ensure that our segment buffer is big enough.
						//
						ensureSegmentCapacity(segmentCount);

						// Put the interned segment into the segment buffer.
						//
						segmentBuffer[segmentCount++] = STRING_CACHE.intern(buffer, start, i - start, segmentHashCode);

						// Mark the start of the next segment.
						//
						start = i + 1;

						// Reset the hash code for the segment.
						//
						segmentHashCode = 0;
					} else {
						// Compose the segment's hash code.
						//
						segmentHashCode = (segmentHashCode * 31) + c;
					}
				}

				// If there are remains one segment...
				//
				if (start < length) {
					// Add it to the segment buffer as well.
					//
					ensureSegmentCapacity(segmentCount);
					segmentBuffer[segmentCount++] = STRING_CACHE.intern(buffer, start, length - start, segmentHashCode);
				}

				// Allocate the new segments, fill them, create an instance from that, add it to the cache, and return it.
				// Note that we don't expect segment count ever to be zero because during static initialization we cache both instances for which
				// that's
				// possible.
				//
				String[] newSegments = new String[segmentCount];
				System.arraycopy(segmentBuffer, 0, newSegments, 0, segmentCount);
				QualifiedNameWithDelimiter qualifiedName = new QualifiedNameWithDelimiter(newSegments, hashCode);
				if ((segmentBuffer.length > 1) || hasLeadingSlash) {
					// Cache the toString if it would need to be computed later.
					//
					qualifiedName.toString = new WeakReference<String>(name);
				}
				addEntry(createEntry(qualifiedName, hashCode));
				return qualifiedName;
			}
		}

		/**
		 * Ensures that the segment buffer is give enough to hold the given number of segments.
		 * 
		 * @param segmentCount
		 */
		protected void ensureSegmentCapacity(final int segmentCount) {
			if (segmentCount <= segmentBuffer.length) {
				// Create a new one copying over the existing contents.
				//
				String[] oldSegments = segmentBuffer;
				segmentBuffer = new String[2 * segmentBuffer.length];
				System.arraycopy(oldSegments, 0, segmentBuffer, 0, segmentCount);
			}
		}

		/**
		 * Returns true if the arrays are of the same length and have equal strings.
		 */
		protected static boolean equals(final String[] segments1, final String[] segments2) {
			int length = segments1.length;
			if (segments2.length != length) {
				return false;
			}

			for (int i = 0; i < length; i++) {
				if (!segments1[i].equals(segments2[i])) {
					return false;
				}
			}

			return true;
		}
	}

	/**
	 * Returns the cached string equal to the given string. Note that the argument itself will never be added to the cache, but rather a
	 * {@link String#String(String) copy} of it, so it's safe to call this for a string that's a substring of a much larger string.
	 */
	public static String intern(final String string) {
		return STRING_CACHE.intern(string);
	}

	/**
	 * Returns the cached string with the given range of characters.
	 */
	public static String intern(final char[] characters, final int offset, final int count) {
		int hashCode = 0;
		for (int i = offset, end = offset + count; i < end; ++i) {
			hashCode = (hashCode * 31) + characters[i];
		}
		return STRING_CACHE.intern(characters, offset, count, hashCode);
	}

	/**
	 * Returns the qualified name for the argument, splitting into segments as appropriate.
	 */
	public static QualifiedNameWithDelimiter create(final String qualifiedName) {
		return CACHE.intern(qualifiedName);
	}

	/**
	 * Returns the qualified name for the given segments, splitting individual segments as appropriate. The result will have a
	 * {@link #hasLeadingSlash() leading slash}.
	 */
	public static QualifiedNameWithDelimiter create(final String... segments) {
		String[] splitSegments = split(segments);
		return CACHE.intern(true, segments == splitSegments, true, splitSegments);
	}

	/**
	 * Returns the qualified name for the given segments, splitting individual segments as appropriate. The result will not have a
	 * {@link #hasLeadingSlash() leading slash}, unless there is a leading empty string in the segments in which case that leading segment is removed
	 * and the result has a leading slash.
	 */
	public static QualifiedNameWithDelimiter createWithoutLeadingSlash(final String... segments) {
		String[] splitSegments = split(segments);
		int length = splitSegments.length;
		if ((length > 0) && "".equals(splitSegments[0])) {
			String[] trimmedSegments = new String[--length];
			System.arraycopy(splitSegments, 1, trimmedSegments, 0, length);
			return CACHE.intern(true, false, true, trimmedSegments);
		}
		return CACHE.intern(false, segments == splitSegments, true, splitSegments);
	}

	/**
	 * Splits any segment that contains a "/" and returns the composed result. If no segment contains a "/", the argument is returned.
	 */
	protected static String[] split(final String[] segments) {

		// Iterate over the segments and create a new list of segments only when needed.
		//
		List<String> expandedSegments = null;
		for (int i = 0, length = segments.length; i < length; ++i) {
			// If the segment contains a slash...
			//
			String segment = segments[i];
			if (segment.indexOf(SLASH) != -1) {
				// Create a qualified name for the segment, to reuse the efficient logic for splitting a name, and pull out the segments from that
				// result.
				//
				String[] subsegments = create(segment).segments;

				// If we haven't already created a list for the result...
				//
				if (expandedSegments == null) {
					// Create one with a suitable capacity and add all the segments we've looked at so far...
					//
					expandedSegments = new ArrayList<String>(length + subsegments.length);
					for (int j = 0; j < i; ++j) {
						expandedSegments.add(segments[j]);
					}
				}
				// Add the subsegments of this segment as well.
				//
				for (String subsegment : subsegments) {
					expandedSegments.add(subsegment);
				}
			} else if (expandedSegments != null) {
				// If we're building a new result, add this segment.
				//
				expandedSegments.add(segment);
			}
		}
		// Return either original argument, or the array from the new result, or the original argument.
		//
		return expandedSegments == null ? segments : expandedSegments.toArray(new String[expandedSegments.size()]);
	}

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		QualifiedNameWithDelimiter result = create(new String("/a/b"));
		QualifiedNameWithDelimiter result1 = create(new String("/a/b"));
		QualifiedNameWithDelimiter result2 = create(new String("a/b"));
		QualifiedNameWithDelimiter result3 = create(new String("a/b"));
		QualifiedNameWithDelimiter result4 = create(new String("a"));
		QualifiedNameWithDelimiter result5 = create(new String("a"));
		QualifiedNameWithDelimiter result6 = create(new String("/a"));
		QualifiedNameWithDelimiter result7 = create(new String("/a"));
		QualifiedNameWithDelimiter result8 = create(new String(""));
		QualifiedNameWithDelimiter result9 = create(new String(""));
		QualifiedNameWithDelimiter result10 = create(new String("/"));
		QualifiedNameWithDelimiter result11 = create(new String("/"));
		QualifiedNameWithDelimiter result12 = create();
		QualifiedNameWithDelimiter result13 = createWithoutLeadingSlash();
		QualifiedNameWithDelimiter result14 = createWithoutLeadingSlash("");
		QualifiedNameWithDelimiter result15 = create(new String[] { "/a/b" });
		QualifiedNameWithDelimiter result16 = createWithoutLeadingSlash(new String[] { "/a/b" });
		QualifiedNameWithDelimiter result17 = createWithoutLeadingSlash(new String[] { "a/b" });
		QualifiedNameWithDelimiter result18 = result4.append(create("b"));
		QualifiedNameWithDelimiter result19 = result4.append("b");
		QualifiedNameWithDelimiter result20 = result4.append("/b");
		QualifiedNameWithDelimiter result21 = create("a", "b");
		QualifiedNameWithDelimiter result22 = createWithoutLeadingSlash("a", "b");
		QualifiedNameWithDelimiter result23 = result22.append("c/d");
		QualifiedNameWithDelimiter result24 = createWithoutLeadingSlash("a", "b", "c", "d");
		System.gc();
		System.gc();
		System.out.println("###" + result1);
		System.out.println("###" + result3);
		System.out.println("###" + result4);
		System.out.println("###" + result7);
	}
}
