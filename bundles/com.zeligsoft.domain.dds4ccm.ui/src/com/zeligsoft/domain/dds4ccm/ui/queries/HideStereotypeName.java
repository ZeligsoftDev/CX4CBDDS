package com.zeligsoft.domain.dds4ccm.ui.queries;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.providers.DelegatingItemLabelProvider;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.filters.DDS4CCMDomainFilter;

public class HideStereotypeName implements IJavaQuery2<NamedElement, String> {

	public static final int SHOW_LABEL = 0x1;

	public static final int SHOW_METACLASS = 0x2;

	private static final IItemLabelProvider labelProvider = new DelegatingItemLabelProvider(
			Activator.getDefault().getItemProviderAdapterFactory(), SHOW_LABEL | SHOW_METACLASS);
	private static final IItemLabelProvider defaultLabelProvider = new DelegatingItemLabelProvider();

	public String evaluate(NamedElement source, IParameterValueList2 parameterValues, IFacetManager facetManager)
			throws DerivedTypedElementException {
		if (ZDLUtil.isZDLProfile(source, DDS4CCMDomainFilter.DDS4CCM_PROFILE_NAME)) {
			return labelProvider.getText(source);
		}
		return defaultLabelProvider.getText(source);
	}
}
