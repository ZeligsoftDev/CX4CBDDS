package apps.utils;

import com.telelogic.rhapsody.core.IRPArgument;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPClassifier;
import com.telelogic.rhapsody.core.IRPCollection;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPOperation;
import com.telelogic.rhapsody.core.IRPPort;

/**
 * Rhapsody element copier
 * 
 * @author ysroh
 * 
 */
public class Copier {

	public static void copy(IRPModelElement source, IRPModelElement target) {
		// to do
	}

	/**
	 * Copy references
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyReferences(IRPModelElement source,
			IRPModelElement target) {

		String sourcePath = source.getFullPathName();

		IRPCollection allChild = target.getNestedElementsRecursive();
		for (int i = 1; i <= allChild.getCount(); i++) {
			IRPModelElement e = (IRPModelElement) allChild.getItem(i);
			if (e instanceof IRPGeneralization) {
				IRPGeneralization g = (IRPGeneralization) e;
				IRPClassifier base = g.getBaseClass();
				IRPClassifier clone = (IRPClassifier) getClone(sourcePath,
						base, target);
				if (clone != null) {
					g.setBaseClass(clone);
				}
			} else if (e instanceof IRPPort) {
				IRPPort p = (IRPPort) e;
				IRPClass contract = p.getContract();
				IRPClass clone = (IRPClass) getClone(sourcePath, contract,
						target);
				if (clone != null) {
					p.setContract(clone);
				}
			} else if (e instanceof IRPAttribute) {
				IRPAttribute a = (IRPAttribute) e;
				IRPClassifier type = a.getType();
				IRPClassifier clone = (IRPClassifier) getClone(sourcePath,
						type, target);
				if (clone != null) {
					a.setType(clone);
				}
			} else if (e instanceof IRPOperation) {
				IRPOperation o = (IRPOperation) e;
				IRPClassifier type = o.getReturns();
				IRPClassifier clone = (IRPClassifier) getClone(sourcePath,
						type, target);
				if (clone != null) {
					o.setReturns(clone);
				}
			} else if (e instanceof IRPArgument) {
				IRPArgument a = (IRPArgument) e;
				IRPClassifier type = a.getType();
				IRPClassifier clone = (IRPClassifier) getClone(sourcePath,
						type, target);
				if (clone != null) {
					a.setType(clone);
				}
			} else if (e instanceof IRPDependency) {
				IRPDependency dep = (IRPDependency) e;
				String depName = dep.getName();
				IRPModelElement dependsOn = dep.getDependsOn();
				IRPModelElement clone = getClone(sourcePath, dependsOn, target);
				if (clone != null) {
					dep.setDependsOn(clone);
					dep.setName(depName);
				}
			}
		}
	}

	private static IRPModelElement getClone(String sourcePath,
			IRPModelElement element, IRPModelElement target) {
		String basePath = element.getFullPathName();
		if (basePath.startsWith(sourcePath)) {
			String relPath = basePath.substring(sourcePath.length() + 2);
			IRPClassifier clone = (IRPClassifier) target
					.findElementsByFullName(
							relPath + " in " + target.getFullPathName(),
							element.getMetaClass());
			return clone;
		}
		return null;

	}
}
