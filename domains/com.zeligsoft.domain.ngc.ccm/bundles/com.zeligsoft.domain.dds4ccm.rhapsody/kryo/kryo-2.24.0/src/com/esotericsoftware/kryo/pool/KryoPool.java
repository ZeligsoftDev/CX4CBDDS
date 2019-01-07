package com.esotericsoftware.kryo.pool;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.esotericsoftware.kryo.Kryo;

public class KryoPool {
	
	private Queue<Kryo> queue;
	private KryoFactory factory;

	public KryoPool(KryoFactory factory) {
		this.factory = factory;
		queue = new ConcurrentLinkedQueue<Kryo>();
	}

	public int size () {
		return queue.size();
	}

	public Kryo borrow () {
      Kryo t;
      if ((t = queue.poll()) == null) {
          t = factory.create();
      }
      return t;
	}

	public void release (Kryo kryo) {
		queue.offer(kryo);
	}

	public <T> T run(KryoCallback<T> callback) {
		Kryo kryo = borrow();
		try {
			return callback.execute(kryo);
		} finally {
			release(kryo);
		}
	}
	
	public static interface KryoCallback<T> {
		T execute(Kryo kryo);
	}
	
	public static interface KryoFactory {
		Kryo create();
	}

}
