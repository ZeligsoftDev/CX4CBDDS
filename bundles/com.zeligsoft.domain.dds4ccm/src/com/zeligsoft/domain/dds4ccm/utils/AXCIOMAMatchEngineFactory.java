/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IEqualityHelperFactory;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.utils.EqualityHelper;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;

import com.google.common.cache.LoadingCache;

/**
 * @author eposse
 *
 */
public class AXCIOMAMatchEngineFactory extends MatchEngineFactoryImpl {
//	@Override
//	public org.eclipse.emf.compare.utils.IEqualityHelper createEqualityHelper() {
//	}

	/**
	 * 
	 */
	public AXCIOMAMatchEngineFactory() {
		super(DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE),
				makeComparisonFactory());
	}

	private static IComparisonFactory makeComparisonFactory() {
		return new DefaultComparisonFactory(makeEqualityHelper());
	}

	private static IEqualityHelperFactory makeEqualityHelper() {
		return new DefaultEqualityHelperFactory() {
			@Override
			public IEqualityHelper createEqualityHelper() {
				final LoadingCache<EObject, URI> cache = EqualityHelper.createDefaultCache(getCacheBuilder());
				return new EqualityHelper(cache) {
					@Override
					public boolean matchingValues(Object object1, Object object2) {
						boolean match = false;
						// First try fast pointer equivalence
						if (object1 == null && object2 == null || object1 == object2) {
							match = true;
						} else if (object1 != null && object2 != null) {
							// Try to match proxy EObjects by URI
							if (object1 instanceof EObject && object2 instanceof EObject) {
								match = matchingURIs((EObject)object1, (EObject)object2);
							}
						}
						// If neither test passed, delegate to the default matching test.
						if (!match) {
							match = super.matchingValues(object1, object2);
						}
						return match;
					}
				};
			}
		};
	}

	/**
	 * @param useIDs
	 */
	public AXCIOMAMatchEngineFactory(UseIdentifiers useIDs) {
		super(useIDs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param useIDs
	 * @param weightProviderRegistry
	 */
	public AXCIOMAMatchEngineFactory(UseIdentifiers useIDs,
			org.eclipse.emf.compare.match.eobject.WeightProvider.Descriptor.Registry weightProviderRegistry) {
		super(useIDs, weightProviderRegistry);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param useIDs
	 * @param weightProviderRegistry
	 * @param equalityHelperExtensionProviderRegistry
	 */
	public AXCIOMAMatchEngineFactory(UseIdentifiers useIDs,
			org.eclipse.emf.compare.match.eobject.WeightProvider.Descriptor.Registry weightProviderRegistry,
			org.eclipse.emf.compare.match.eobject.EqualityHelperExtensionProvider.Descriptor.Registry equalityHelperExtensionProviderRegistry) {
		super(useIDs, weightProviderRegistry, equalityHelperExtensionProviderRegistry);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param matcher
	 * @param comparisonFactory
	 */
	public AXCIOMAMatchEngineFactory(IEObjectMatcher matcher, IComparisonFactory comparisonFactory) {
		super(matcher, comparisonFactory);
		// TODO Auto-generated constructor stub
	}

}
