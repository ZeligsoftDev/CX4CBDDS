package apps.utils;

import com.ibm.rhapsody.apps.utils.Reporter;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPStereotype;

public class CXRhapsodyUtils {

	public static final String ZDL_CONCEPT_PROPERTY = "CX.DomainModel.DefiningConcept";

	public static String getZdlConcept(IRPModelElement self) {
		for (Object o : self.getStereotypes().toList()) {
			IRPStereotype st = (IRPStereotype) o;
			try {
				String concept = st
						.getPropertyValueExplicit(ZDL_CONCEPT_PROPERTY);
				if (concept != null && concept.length() != 0) {
					return concept;
				}
			} catch (Exception e) {
				return "";
			}
		}

		return "";
	}

	public static void println(String text) {
		Reporter.report(text + "\n");
	}
}
