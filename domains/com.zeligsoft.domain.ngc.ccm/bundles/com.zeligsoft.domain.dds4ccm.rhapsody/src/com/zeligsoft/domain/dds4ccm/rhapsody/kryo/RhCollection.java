package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPGraphElement;
import com.telelogic.rhapsody.core.IRPModelElement;

public class RhCollection<T> implements IRPCollection {

	private final List<T> elements;
	
	public RhCollection(Collection<T> elements) {
		this.elements =new ArrayList<T>(elements);
	}

	@Override
	public int getCount() {
		return elements.size();
	}

	@Override
	public T getItem(int index) {
		return elements.get(index);
	}

	@Override
	public void addItem(IRPModelElement newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGraphicalItem(IRPGraphElement newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> toList() {
		return Collections.unmodifiableList(elements);
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setString(int index, String val) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModelElement(int index, IRPModelElement val) {
		// TODO Auto-generated method stub

	}

	@Override
	public void empty() {
		// TODO Auto-generated method stub

	}

}
