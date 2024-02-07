/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * A memory efficient structure to store qualified names composed of String segments which are (optionally) separated by a delimiter. QualifiedNames
 * must be constructed through one its create methods. The structure uses String pooling to store the single segments. Further it maintains a pool of
 * QualifiedName instances itself, so that each QualifiedName exists only once.
 * 
 * @author Karsten Thoms
 */
public final class QualifiedName {
	protected final int hash;
	protected String[] segments;
	protected WeakReference<String> toString;

	protected static final QualifiedNameCache CACHE = new QualifiedNameCache();

	/**
	 * Constructor
	 * 
	 * @param segments
	 *            Segments of the Identifier.
	 * @param delimiter
	 *            A delimiter string for the construction of a String representation with {@link #toString()}. Can be <code>null</code>.
	 */
	protected QualifiedName(final String[] segments, final int hashCode) {
		this.segments = segments;
		hash = hashCode;
	}

	/**
	 * Append another Identifier to this instance
	 * 
	 * @param t
	 *            An identifier.
	 * @return Will return <code>this</code> extended by the segments of <code>t</code>
	 */
	public QualifiedName append(final QualifiedName t) {
		return CACHE.intern(segments, t.segments);
	}

	/**
	 * Returns a canonical String representation of this.
	 */
	@Override
	public String toString() {
		int segmentCount = segments.length;
		switch (segmentCount) {
		case 0:
			return "";
		case 1:
			return segments[0];
		default:
			String result = toString != null ? toString.get() : null;
			if (result == null) {
				StringBuilder builder = new StringBuilder(segmentCount * 8);
				for (String segment : segments) {
					builder.append(segment);
				}
				result = builder.toString();
				toString = new WeakReference<String>(result);
			}
			return result;
		}
	}

	/**
	 * Returns a canonical String representation of this using the specified delimiter. This method will perform less than {@link #toString()}, since
	 * the result cannot be cached.
	 * 
	 * @param delimiter
	 *            A delimiter to insert between segments.
	 */
	public String toString(final String delimiter) {
		int segmentCount = segments.length;
		if (segmentCount < 2) {
			return toString();
		}
		// at least 2 segments
		final StringBuilder builder = new StringBuilder(segmentCount * (8 + delimiter.length()));
		for (String segment : segments) {
			if (segment != segments[0]) {
				builder.append(delimiter);
			}
			builder.append(segment);
		}
		return builder.toString();
	}

	public int getSegmentCount() {
		return segments.length;
	}

	public String getSegment(final int index) {
		return segments[index];
	}

	public String getLastSegment() {
		return segments[segments.length - 1];
	}

	public String getFirstSegment() {
		return segments[0];
	}

	/**
	 * Note that there's no override of {@link Object#equals(Object)} because all instances are interned and therefore there's at most one possible
	 * instance for sequence of segments.
	 */
	@Override
	public int hashCode() {
		return hash;
	}

	private static class QualifiedNameCache extends WeakInterningHashSet<QualifiedName> {
		private static final long serialVersionUID = 1L;

		protected int hashCode(final int initialHashCode, final String[] segments) {
			int length = segments.length;
			if (length == 0) {
				return 0;
			}
			int hashCode = initialHashCode;
			for (String segment : segments) {
				hashCode = (31 * hashCode) + segment.hashCode();
			}
			return hashCode;
		}

		@Override
		protected boolean equals(final Object object, final Object otherObject) {
			return object == otherObject;
		}

		protected int hashCode(final String[] segments) {
			return hashCode(1, segments);
		}

		protected int hashCode(final String[] segments1, final String[] segments2) {
			return hashCode(hashCode(segments1), segments2);
		}

		public QualifiedName intern(final String[] segments1, final String[] segments2) {
			int length1 = segments1.length;
			int length2 = segments2.length;
			int length = length1 + length2;
			int hashCode = hashCode(segments1, segments2);
			LOOP: for (Entry<QualifiedName> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
				QualifiedName qualifiedName = entry.get();
				if (qualifiedName != null) {
					String[] segments = qualifiedName.segments;
					if (length != segments.length) {
						break;
					}
					int i = 0;
					for (; i < length1; ++i) {
						if (segments[i] != segments1[i]) {
							continue LOOP;
						}
					}
					for (int j = 0; j < length2; ++i, ++j) {
						if (segments[i] != segments2[j]) {
							continue LOOP;
						}
					}
					return qualifiedName;
				}
			}

			String[] newSegments = new String[length];
			System.arraycopy(segments1, 0, newSegments, 0, length1);
			System.arraycopy(segments2, 0, newSegments, length1, length2);
			QualifiedName qualifiedName = new QualifiedName(newSegments, hashCode);
			addEntry(createEntry(qualifiedName, hashCode));
			return qualifiedName;
		}

		public QualifiedName intern(final String segment) {
			int hashCode = 31 + segment.hashCode();
			for (Entry<QualifiedName> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
				QualifiedName qualifiedName = entry.get();
				if (qualifiedName != null) {
					String[] segments = qualifiedName.segments;
					if ((segments.length == 1) && segments[0].equals(segment)) {
						return qualifiedName;
					}
				}
			}

			QualifiedName qualifiedName = new QualifiedName(new String[] { StringCache.get(segment) }, hashCode);
			addEntry(createEntry(qualifiedName, hashCode));
			return qualifiedName;
		}

		public QualifiedName intern(final String[] segments) {
			int hashCode = hashCode(segments);
			for (Entry<QualifiedName> entry = getEntry(hashCode); entry != null; entry = entry.getNextEntry()) {
				QualifiedName qualifiedName = entry.get();
				if (qualifiedName != null) {
					if (equals(qualifiedName.segments, segments)) {
						return qualifiedName;
					}
				}
			}

			for (int i = 0; i < segments.length; i++) {
				segments[i] = StringCache.get(segments[i]);
			}

			QualifiedName qualifiedName = new QualifiedName(segments, hashCode);
			addEntry(createEntry(qualifiedName, hashCode));
			return qualifiedName;
		}

		private boolean equals(final String[] segments1, final String[] segments2) {
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
	 * Factory method.
	 * 
	 * @param segments
	 *            segments the segments of the to-be-created qualified name.
	 * @return a {@link QualifiedName}. When the factory method was already invoked with the same arguments the same instance as the previous call
	 *         will be returned.
	 */
	public static QualifiedName create(final String[] segments) {
		return CACHE.intern(segments);
	}

	/**
	 * Factory method. A name with a single segment.
	 * 
	 * @param segment
	 *            The string segment of the qualified name.
	 * @return a {@link QualifiedName}. When the factory method was already invoked with the same arguments the same instance as the previous call
	 *         will be returned.
	 */
	public static QualifiedName create(final String segment) {
		return CACHE.intern(segment);
	}

	/**
	 * Factory method. A name separated by a delimiter.
	 * 
	 * @param segments
	 *            The string segment of the qualified name.
	 * @param delimiter
	 *            The delimiter which separates the segments.
	 * @return a {@link QualifiedName}. When the factory method was already invoked with the same arguments the same instance as the previous call
	 *         will be returned.
	 */
	public static QualifiedName create(final String segments, final String delimiter) {
		final List<String> segmentList = StringHelper.split(segments, delimiter);
		if (segmentList.size() == 1) { // only simple name
			return CACHE.intern(segments);
		}
		final String[] segmented = segmentList.toArray(new String[segmentList.size()]);
		return CACHE.intern(segmented);
	}

}
