/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.compare.contentmergeviewer.provider;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.adapterfactory.context.AbstractContextTester;

import com.zeligsoft.domain.dds4ccm.ui.compare.internal.context.DDS4CCMContextUtils;

/**
 * 
 */
public class DDS4CCMContextTester extends AbstractContextTester {

	/**
	 * A weak cache of comparisons that have been already been tested.
	 */
	private final Map<Comparison, Boolean> cache = new WeakHashMap<>();

	/**
	 * {@inheritDoc}
	 */
	public boolean apply(Map<Object, Object> context) {
		Comparison comparison = getComparison(context);
		if (comparison != null) {
			Boolean result = cache.get(comparison);
			if (result == null) {
				result = Boolean.valueOf(DDS4CCMContextUtils.isDDS4CCMContext(comparison));
				cache.put(comparison, result);
			}
			return result.booleanValue();
		}
		return false;
	}

}
