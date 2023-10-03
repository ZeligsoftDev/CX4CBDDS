package org.eclipse.papyrus.uml.alf.naming;

public class ALFIDConverter {

	public static final String QUOTATION = "'";

	/**
	 * Wraps a name that contains whitespace as allowed in ALF into quotations.
	 *
	 * @param name
	 * @return
	 */
	public static String nameToID(String name) {
		if (name == null) {
			return "";
		}
		if (name.contains(" ")) {
			StringBuilder builder = new StringBuilder(QUOTATION);
			builder.append(name);
			builder.append(QUOTATION);
			return builder.toString();
		}
		return name;
	}

	/**
	 * Removes the quotations for the name
	 *
	 * @param id
	 * @return
	 */
	public static String IDtoName(String id) {
		if (id == null) {
			return null;
		}
		return id.replaceAll(QUOTATION, "");
	}

}
