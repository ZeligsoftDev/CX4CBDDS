package org.eclipse.internal.xtend.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

/**
 * Copied from org.eclipse.emf.common.util, since it is only available in EMF >= 2.9. TODO: Remove once Target Platform allows usage of newer EMF
 * version.
 * 
 * An implementation of an {@link AbstractSet} that keeps weak references to its element. This structure is particularly well suited for maintaining a
 * cache of instances, e.g., a string pool. All the caveats about the behavior of the garbage collector that apply for a {@link WeakHashMap#keySet()
 * weak hash map} apply for this implementation as well.
 */
public class WeakInterningHashSet<E> extends AbstractSet<E> implements Serializable {
	protected static final long serialVersionUID = 1L;

	/**
	 * A special entry used by the iterator to represent the need to yield the null value for the subsequent call to next().
	 */
	protected static final Entry<Object> NULL_ENTRY = new Entry<Object>();

	/**
	 * The capacity used for the {@link #entries} of the set will always be a prime number to help ensure uniform distribution of the hash codes. Each
	 * of these prime numbers is the smallest prime larger than 2^n, except for the last, which is the largest prime < {@link Integer#MAX_VALUE}.
	 */
	protected static final int[] PRIME_CAPACITIES = new int[] {
			// 1,
			// 2,
			// 5,
			// 11,
			17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, 65537, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617,
			16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147483629 };

	/**
	 * The regular increment for the {@link #modCount} representing a structural change to the set. It is designed to preserve the lower 6 bits of the
	 * field.
	 */
	protected static final int MOD_COUNT_INCREMENT = 1 << 7;

	/**
	 * The increment for {@link #modCount} representing the addition/removal of the null value to/from the set. It's intended to preserve the lower 5
	 * bits of the field.
	 */
	protected static final int NULL_BIT_INCREMENT = 1 << 6;

	/**
	 * The mask for the lower five bits of the {@link #modCount} representing the capacity index in {@link #PRIME_CAPACITIES}.
	 */
	protected static final int CAPACITY_MASK = 0x1F;

	/**
	 * The current size of the set.
	 */
	protected int size;

	/**
	 * The mod count is used to encode several things. The lower five bits represent the capacity the {@link #entries}. The sixth low bit represents
	 * whether or not the set contains the <code>null</code> value. The remaining bits are the actual modification count.
	 */
	transient protected int modCount;

	/**
	 * The table of linked entries.
	 */
	transient protected Entry<E>[] entries;

	/**
	 * The queue used for polling garbage collected references.
	 */
	transient protected ReferenceQueue<E> queue = new ReferenceQueue<E>();

	/**
	 * A weak reference holder that caches the hash code of the referent and is chained in the {@link WeakInterningHashSet#entries} to handle
	 * collisions.
	 */
	protected static class Entry<E> extends WeakReference<E> {
		/**
		 * The cached hash code.
		 */
		public int hashCode;

		/**
		 * The next entry in the collision chain.
		 */
		public Entry<E> next;

		/**
		 * Used only to create the {@link WeakInterningHashSet#NULL_ENTRY}.
		 */
		private Entry() {
			super(null);
		}

		/**
		 * Creates an entry thats part of the set's {@link WeakInterningHashSet#queue}.
		 */
		public Entry(final E object, final int hashCode, final ReferenceQueue<? super E> q) {
			super(object, q);
			this.hashCode = hashCode;
		}

		/**
		 * Returns the next entry in the collision chain with the same {@link #hashCode}.
		 */
		public Entry<E> getNextEntry() {
			for (Entry<E> entry = next; entry != null; entry = entry.next) {
				if (entry.hashCode == hashCode) {
					return entry;
				}
			}
			return null;
		}

		/**
		 * Returns the string value of the {@link #get() referent}.
		 */
		@Override
		public String toString() {
			Object object = get();
			return object == null ? "null" : object.toString();
		}
	}

	@Override
	public int size() {
		cleanup();

		return size;
	}

	/**
	 * Ensures that the set has at least the specifies capacity. Higher capacity ensures fewer collisions hence faster lookup. Does nothing if the
	 * specified capacity is smaller than the current capacity.
	 */
	public void grow(final int minimumCapacity) {
		int capacityIndex = modCount & CAPACITY_MASK;
		int currentCapacity = PRIME_CAPACITIES[capacityIndex];
		if (currentCapacity < minimumCapacity) {
			for (int i = 0, length = PRIME_CAPACITIES.length; i < length; ++i) {
				int capacity = PRIME_CAPACITIES[i];
				if (capacity > minimumCapacity) {
					modCount &= ~CAPACITY_MASK;
					modCount += i;
					rehash(newEntries(capacity));
					break;
				}
			}
		}
	}

	/**
	 * Returns the {@link Object#hashCode() hash code} of the object. This will never be called with <code>null</code>. A derived class may specialize
	 * this to compute an alternative hash code. The default implementation simply uses the object's hash code.
	 */
	protected int hashCode(final Object object) {
		return object.hashCode();
	}

	/**
	 * Returns true if the two objects are to be considered equal. The first object will always be the one passed in as an argument to
	 * {@link #add(Object) add}, {@link #contains(Object) contains}, {@link #get(Object) get}, {@link #intern(Object)}, {@link #remove(Object)}. A
	 * derived class might specialize this to allow a different type of object to be used as a key than is actually stored in the set. The default
	 * implementation simply tests for Java {@link Object#equals(Object)} equality.
	 */
	protected boolean equals(final Object object, final Object otherObject) {
		return (object == otherObject) || object.equals(otherObject);
	}

	/**
	 * Creates a new array of {@link #entries} with the specified capacity.
	 */
	@SuppressWarnings("unchecked")
	protected Entry<E>[] newEntries(final int capacity) {
		Entry<E>[] newEntries = new Entry[capacity];
		return newEntries;
	}

	/**
	 * Ensures that 3/4 of current capacity is larger than the current size. If not, it {@link #newEntries(int)} reallocates the entries to the next
	 * {@link #PRIME_CAPACITIES prime capacity}, i.e., it approximate doubles the capacity, and {@link #rehash(Entry[])}s the set.
	 */
	protected void ensureCapacity() {
		int capacityIndex = modCount & CAPACITY_MASK;
		int capacity = PRIME_CAPACITIES[capacityIndex];
		if (entries == null) {
			entries = newEntries(capacity);
		}
		// If the current size is more the 3/4 of the current capacity...
		//
		else if (size > ((capacity >> 2) * 3)) {
			++modCount;
			rehash(newEntries(PRIME_CAPACITIES[capacityIndex + 1]));
		}
	}

	/**
	 * Rehashes the existing {#entries} into the new entries.
	 */
	protected void rehash(final Entry<E>[] newEntries) {
		Entry<E>[] oldEntries = entries;
		entries = newEntries;
		if (oldEntries != null) {
			for (Entry<E> oldEntrie : oldEntries) {
				Entry<E> entry = oldEntrie;
				while (entry != null) {
					Entry<E> nextEntry = entry.next;
					putEntry(entry);
					entry = nextEntry;
				}
			}
		}
	}

	/**
	 * Polls the {@link #queue} and {@link #removeEntry(Entry) removes} any garbage collected entries.
	 */
	protected void cleanup() {
		for (;;) {
			@SuppressWarnings("unchecked")
			Entry<E> entry = (Entry<E>) queue.poll();
			if (entry == null) {
				return;
			}
			removeEntry(entry);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(final E object) {
		cleanup();

		if (object == null) {
			// The presence of null is encoded in the modCount.
			//
			if ((modCount & NULL_BIT_INCREMENT) == 0) {
				modCount += NULL_BIT_INCREMENT;
				++size;
				return true;
			}
			return false;
		}
		int hashCode = hashCode(object);
		if (entries != null) {
			int index = index(hashCode);
			for (Entry<E> entry = entries[index]; entry != null; entry = entry.next) {
				if (hashCode == entry.hashCode) {
					E otherObject = entry.get();
					if (equals(object, otherObject)) {
						return false;
					}
				}
			}
		}

		addEntry(createEntry(object, hashCode));
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(final Object object) {
		cleanup();

		if (object == null) {
			// The presence of null is encoded in the modCount.
			//
			if ((modCount & NULL_BIT_INCREMENT) == 0) {
				return false;
			}
			modCount += NULL_BIT_INCREMENT;
			--size;
			return true;
		}
		if (entries != null) {
			int hashCode = hashCode(object);
			int index = index(hashCode);
			Entry<E> previousEntry = null;
			for (Entry<E> entry = entries[index]; entry != null; previousEntry = entry, entry = entry.next) {
				if (hashCode == entry.hashCode) {
					E otherObject = entry.get();
					if (equals(object, otherObject)) {
						if (previousEntry == null) {
							entries[index] = entry.next;
						} else {
							previousEntry.next = entry.next;
						}
						--size;
						modCount += MOD_COUNT_INCREMENT;
						return true;
					}
				}
			}
		}

		return false;
	}

	public E intern(final E object) {
		cleanup();

		if (object == null) {
			// The presence of null is encoded in the modCount.
			//
			if ((modCount & NULL_BIT_INCREMENT) == 0) {
				modCount += NULL_BIT_INCREMENT;
				++size;
			}
			return null;
		}
		int hashCode = hashCode(object);
		if (entries != null) {
			int index = index(hashCode);
			for (Entry<E> entry = entries[index]; entry != null; entry = entry.next) {
				if (hashCode == entry.hashCode) {
					E otherObject = entry.get();
					if (equals(object, otherObject)) {
						return otherObject;
					}
				}
			}
		}

		addEntry(createEntry(object, hashCode));
		return object;
	}

	public E get(final E object) {
		cleanup();

		if (object == null) {
			// Whether null is present or not, we always return null.
			//
			return null;
		}
		if (entries != null) {
			int hashCode = hashCode(object);
			int index = index(hashCode);
			for (Entry<E> entry = entries[index]; entry != null; entry = entry.next) {
				if (hashCode == entry.hashCode) {
					E otherObject = entry.get();
					if (equals(object, otherObject)) {
						return otherObject;
					}
				}
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(final Object object) {
		cleanup();

		if (object == null) {
			// The presence of null is encoded in the modCount.
			//
			return (modCount & NULL_BIT_INCREMENT) != 0;
		}
		if (entries != null) {
			int hashCode = hashCode(object);
			int index = index(hashCode);
			for (Entry<E> entry = entries[index]; entry != null; entry = entry.next) {
				if (hashCode == entry.hashCode) {
					E otherObject = entry.get();
					if (equals(object, otherObject)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		cleanup();

		return new Iterator<E>() {
			/**
			 * The expected modCount for fail fast concurrent modification testing.
			 */
			int expectedModCount = modCount;

			/**
			 * The current index in the {@link WeakInterningHashSet#entries}.
			 */
			int index;

			/**
			 * Keep a hard reference to the object in the {@link #nextEntry} to ensure it's not garbage collected.
			 */
			E nextObject;

			/**
			 * The entry for yielding the value of {@link #next}.
			 */
			Entry<E> nextEntry;

			/**
			 * Keep a hard reference to the object in the {@link #removeEntry} to ensure it's not garbage collected.
			 */
			@SuppressWarnings("unused")
			E removeObject;

			/**
			 * The entry for which the next call to {@link #remove} applies.
			 */
			Entry<E> removeEntry;

			{
				// Set up the initial next entry...
				//
				if (size > 0) {
					if ((modCount & NULL_BIT_INCREMENT) != 0) {
						// If null is in the set, prepare to yield it.
						//
						index = -1;
						nextEntry = nullEntry();
					} else {
						if (entries != null) {
							// Scan the entries for a non-null entry.
							//
							for (;;) {
								Entry<E> entry = entries[index];
								if (entry != null) {
									// If the referent isn't null, prepare to yield its value.
									//
									E object = entry.get();
									if (object != null) {
										nextObject = object;
										nextEntry = entry;
										break;
									}
								}
								// If we get to the end of the entries, terminate the loop; the set is empty.
								//
								if (++index == entries.length) {
									break;
								}
							}
						}
					}
				}
			}

			public boolean hasNext() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}

				// The preparation has already been done; so if there is an entry prepared we can return true.
				//
				return nextEntry != null;
			}

			public E next() {
				// If there is no entry prepared, the caller is iterating past the end of the set.
				//
				if (nextEntry == null) {
					throw new NoSuchElementException();
				}

				// Keep a hard reference to the remove entry's referent so polling can't remove the entry.
				//
				removeObject = nextObject;
				removeEntry = nextEntry;

				// Ensure there's a hard reference to the object we're about to yield.
				//
				E result = nextObject;

				// Prepare for the next call to hasNext.
				//
				if (entries != null) {
					// Continue with the collision chain for the correct entry.
					//
					for (Entry<E> entry = nextEntry.next;;) {
						if (entry != null) {
							E object = entry.get();
							if (object != null) {
								// If the referent isn't null, prepare to yield it; we're done the loop.
								//
								nextObject = object;
								nextEntry = entry;
								break;
							}
							// Continue the look with the next entry in the collision chain.
							//
							entry = entry.next;
							continue;
						}

						// If we proceed beyond the end of the entries, prepare to yield nothing.
						//
						if (++index == entries.length) {
							nextEntry = null;
							nextObject = null;
							break;
						}

						// Consider the next entry in the table.
						//
						entry = entries[index];
					}
				}

				return result;
			}

			public void remove() {
				if (modCount != expectedModCount) {
					throw new ConcurrentModificationException();
				}

				// If there is no remove entry, then it's invalid to try to remove something.
				//
				if (removeEntry == null) {
					throw new IllegalStateException();
				}

				// Clean up the entry and update the expected modCount to it's value after the removal.
				//
				WeakInterningHashSet.this.removeEntry(removeEntry);
				expectedModCount = WeakInterningHashSet.this.modCount;

				// Forget the remove entry and its referent.
				//
				removeObject = null;
				removeEntry = null;
			}
		};
	}

	/**
	 * Returns the index in the {@link #entries} for the given hash code.
	 */
	protected int index(final int hashCode) {
		return (hashCode & 0x7FFFFFFF) % entries.length;
	}

	/**
	 * Gets the first entry in the table with exactly the given hash code. It's very useful to call {@link Entry#getNextEntry()} to yield the next
	 * entry with exactly this same hash code.
	 */
	protected Entry<E> getEntry(final int hashCode) {
		cleanup();

		if (entries != null) {
			int index = index(hashCode);
			for (Entry<E> entry = entries[index]; entry != null; entry = entry.next) {
				if (hashCode == entry.hashCode) {
					return entry;
				}
			}
		}

		return null;
	}

	/**
	 * Returns the {@link #NULL_ENTRY singleton entry} representing the null value.
	 */
	@SuppressWarnings("unchecked")
	protected Entry<E> nullEntry() {
		return (Entry<E>) NULL_ENTRY;
	}

	/**
	 * Creates a new entry for the given referent and the given hash code.
	 */
	protected Entry<E> createEntry(final E object, final int hashCode) {
		return new Entry<E>(object, hashCode, queue);
	}

	/**
	 * Puts an new entry into the table. It does not increase the {@link #size} of the set and does not increment the {@link #modCount}. It should be
	 * used only while {@link #rehash(Entry[]) rehashing} or during {@link #readObject(ObjectInputStream) deserialization}. Use
	 * {@link #addEntry(Entry)} to properly add new entries to the set.
	 */
	protected void putEntry(final Entry<E> entry) {
		int index = index(entry.hashCode);
		Entry<E> otherEntry = entries[index];
		entries[index] = entry;
		entry.next = otherEntry;
	}

	/**
	 * Adds a new entry to the set. It {@link #ensureCapacity() ensures} the capacity is sufficient, increases the {@link #size} of the set, and
	 * increments the {@link #modCount}.
	 */
	protected void addEntry(final Entry<E> entry) {
		ensureCapacity();
		++size;
		modCount += MOD_COUNT_INCREMENT;
		putEntry(entry);
	}

	/**
	 * Remove an existing entry from the set. It decreases the {@link #size} of the set and increments the {@link #modCount}.
	 */
	protected void removeEntry(final Entry<E> entry) {
		int index = index(entry.hashCode);
		Entry<E> otherEntry = entries[index];
		--size;
		modCount += MOD_COUNT_INCREMENT;
		if (entry == otherEntry) {
			entries[index] = entry.next;
		} else {
			for (Entry<E> nextOtherEntry = otherEntry.next; nextOtherEntry != null; otherEntry = nextOtherEntry, nextOtherEntry = nextOtherEntry.next) {
				if (nextOtherEntry == entry) {
					otherEntry.next = entry.next;
					break;
				}
			}
		}

		// Make life easier for the garbage collector.
		//
		entry.next = null;
		entry.clear();
	}

	protected void dump() {
		System.out.println(toString());
		System.out.println("size = " + size);
		System.out.println("null = " + ((modCount & NULL_BIT_INCREMENT) != 0));
		if (entries != null) {
			for (int i = 0; i < entries.length; ++i) {
				System.out.print(i);
				System.out.print(": ");
				for (Entry<E> entry = entries[i]; entry != null; entry = entry.next) {
					System.out.print("(" + entry.hashCode + ", " + entry.get() + ")");
					if (entry.next != null) {
						System.out.print(" -> ");
					}
				}
				System.out.println();
			}
		}
	}

	/**
	 * Writes this set to the output stream.
	 */
	private synchronized void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
		objectOutputStream.defaultWriteObject();
		objectOutputStream.writeByte(modCount & CAPACITY_MASK);
		if (size > 0) {
			for (Object object : this) {
				objectOutputStream.writeObject(object);
			}
		}
	}

	/**
	 * Reads the set from the input stream.
	 */
	private synchronized void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
		objectInputStream.defaultReadObject();
		queue = new ReferenceQueue<E>();
		modCount = objectInputStream.readByte();
		if (size > 0) {
			ensureCapacity();
			for (int i = 0; i < size; ++i) {
				@SuppressWarnings("unchecked")
				E object = (E) objectInputStream.readObject();
				if (object == null) {
					modCount += NULL_BIT_INCREMENT;
				} else {
					putEntry(createEntry(object, hashCode(object)));
				}
			}
		}
	}

}
