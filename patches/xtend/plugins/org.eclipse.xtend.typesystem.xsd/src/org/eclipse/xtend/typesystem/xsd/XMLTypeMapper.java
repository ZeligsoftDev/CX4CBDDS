/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLTypeMapper {

	public enum BasicType {
		STRING, INT, REAL, BOOL, OBJECT, DATE, DURATION, QNAME, LIST, UNHANDLED
	}

	private HashMap<EClassifier, BasicType> emap = new HashMap<EClassifier, BasicType>();
	private HashMap<Class<?>, BasicType> jmap = new HashMap<Class<?>, BasicType>();

	private XMLTypeMapper() {
		createEMap();
		createJMap();
	}

	public BasicType getBasicTypeFromAllMaps(Object clazz) {
		BasicType r = emap.get(clazz);
		if (r != null)
			return r;
		return jmap.get(clazz);
	}

	protected void createJMap() {
		// [type::Base64Binary, type::HexBinary]
		jmap.put(byte[].class, BasicType.STRING);

		// [type::Boolean]
		jmap.put(boolean.class, BasicType.BOOL);

		// [type::Byte]
		jmap.put(byte.class, BasicType.INT);

		// [type::Double]
		jmap.put(double.class, BasicType.REAL);

		// [type::Float]
		jmap.put(float.class, BasicType.REAL);

		// [type::Int, type::UnsignedShort]
		jmap.put(int.class, BasicType.INT);

		// [type::BooleanObject]
		jmap.put(java.lang.Boolean.class, BasicType.BOOL);

		// [type::ByteObject]
		jmap.put(java.lang.Byte.class, BasicType.INT);

		// [type::DoubleObject]
		jmap.put(java.lang.Double.class, BasicType.REAL);

		// [type::FloatObject]
		jmap.put(java.lang.Float.class, BasicType.REAL);

		// [type::IntObject, type::UnsignedShortObject]
		jmap.put(java.lang.Integer.class, BasicType.INT);

		// [type::LongObject, type::UnsignedIntObject]
		jmap.put(java.lang.Long.class, BasicType.INT);

		// [xsd::Value, type::AnySimpleType]
		jmap.put(java.lang.Object.class, BasicType.OBJECT);

		// [type::ShortObject, type::UnsignedByteObject]
		jmap.put(java.lang.Short.class, BasicType.REAL);

		// [type::AnyURI, type::ENTITY, type::ID, type::IDREF, type::Language,
		// type::Name, type::NCName, type::NMTOKEN, type::NormalizedString,
		// type::String, type::Token, namespace::LangType,
		// namespace::LangTypeNull]
		jmap.put(java.lang.String.class, BasicType.STRING);

		// [type::Decimal]
		jmap.put(java.math.BigDecimal.class, BasicType.STRING);

		// [type::Integer, type::NegativeInteger, type::NonNegativeInteger,
		// type::NonPositiveInteger, type::PositiveInteger, type::UnsignedLong]
		jmap.put(java.math.BigInteger.class, BasicType.INT);

		// [type::ENTITIES, type::ENTITIESBase, type::IDREFS, type::IDREFSBase,
		// type::NMTOKENS, type::NMTOKENSBase]
		jmap.put(java.util.List.class, BasicType.LIST);

		// [type::Duration]
		jmap.put(javax.xml.datatype.Duration.class, BasicType.DURATION);

		// [type::Date, type::DateTime, type::GDay, type::GMonth,
		// type::GMonthDay, type::GYear, type::GYearMonth, type::Time]
		jmap.put(javax.xml.datatype.XMLGregorianCalendar.class, BasicType.DATE);

		// [type::NOTATION, type::QName]
		jmap.put(javax.xml.namespace.QName.class, BasicType.QNAME);

		// [type::Long, type::UnsignedInt]
		jmap.put(long.class, BasicType.INT);

		// [xsd::DOMAttr]
		jmap.put(org.w3c.dom.Attr.class, BasicType.UNHANDLED);

		// [xsd::DOMDocument]
		jmap.put(org.w3c.dom.Document.class, BasicType.UNHANDLED);

		// [xsd::DOMElement]
		jmap.put(org.w3c.dom.Element.class, BasicType.UNHANDLED);

		// [xsd::DOMNode]
		jmap.put(org.w3c.dom.Node.class, BasicType.UNHANDLED);

		// [type::Short, type::UnsignedByte]
		jmap.put(short.class, BasicType.REAL);
	}

	protected void createEMap() {
		// this handles every type from
		// org.eclipse.emf.ecore.xml.type.impl.XMLTypePackageImpl.initializePackageContents()

		XMLTypePackage x = XMLTypePackage.eINSTANCE;
		emap.put(x.getAnySimpleType(), BasicType.OBJECT); // Object.class
		emap.put(x.getAnyURI(), BasicType.STRING); // String.class
		emap.put(x.getBase64Binary(), BasicType.STRING); // byte[].class
		emap.put(x.getBoolean(), BasicType.BOOL); // boolean.class
		emap.put(x.getBooleanObject(), BasicType.BOOL); // Boolean.class
		emap.put(x.getByte(), BasicType.INT); // byte.class
		emap.put(x.getByteObject(), BasicType.INT);// Byte.class
		emap.put(x.getDate(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getDateTime(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getDecimal(), BasicType.INT); // BigDecimal.class
		emap.put(x.getDouble(), BasicType.REAL); // double.class
		emap.put(x.getDoubleObject(), BasicType.REAL); // Double.class
		emap.put(x.getDuration(), BasicType.DURATION); // Duration.class
		emap.put(x.getENTITIES(), BasicType.LIST);// List.class
		emap.put(x.getENTITIESBase(), BasicType.LIST); // List.class
		emap.put(x.getENTITY(), BasicType.STRING); // String.class
		emap.put(x.getFloat(), BasicType.REAL); // float.class
		emap.put(x.getFloatObject(), BasicType.REAL); // Float.class
		emap.put(x.getGDay(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getGMonth(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getGMonthDay(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getGYear(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getGYearMonth(), BasicType.DATE); // XMLGregorianCalendar.class
		emap.put(x.getHexBinary(), BasicType.STRING); // byte[].class
		emap.put(x.getID(), BasicType.STRING); // String.class
		emap.put(x.getIDREF(), BasicType.STRING); // String.class
		emap.put(x.getIDREFS(), BasicType.LIST); // List.class
		emap.put(x.getIDREFSBase(), BasicType.LIST);// List.class
		emap.put(x.getInt(), BasicType.INT);// int.class
		emap.put(x.getInteger(), BasicType.INT);// BigInteger.class
		emap.put(x.getIntObject(), BasicType.INT); // Integer.class
		emap.put(x.getLanguage(), BasicType.STRING);// String.class
		emap.put(x.getLong(), BasicType.INT);// long.class
		emap.put(x.getLongObject(), BasicType.INT);// Long.class
		emap.put(x.getName_(), BasicType.STRING);// String.class
		emap.put(x.getNCName(), BasicType.STRING);// String.class
		emap.put(x.getNegativeInteger(), BasicType.INT);// BigInteger.class
		emap.put(x.getNMTOKEN(), BasicType.STRING);// String.class
		emap.put(x.getNMTOKENS(), BasicType.LIST);// List.class
		emap.put(x.getNMTOKENSBase(), BasicType.LIST);// List.class
		emap.put(x.getNonNegativeInteger(), BasicType.INT);// BigInteger.class
		emap.put(x.getNonPositiveInteger(), BasicType.INT);// BigInteger.class
		emap.put(x.getNormalizedString(), BasicType.STRING);// String.class
		emap.put(x.getNOTATION(), BasicType.STRING);// QName.class
		emap.put(x.getPositiveInteger(), BasicType.INT);// BigInteger.class
		emap.put(x.getQName(), BasicType.QNAME);// QName.class
		emap.put(x.getShort(), BasicType.INT);// short.class
		emap.put(x.getShortObject(), BasicType.INT);// Short.class
		emap.put(x.getString(), BasicType.STRING);// String.class
		emap.put(x.getTime(), BasicType.DATE);// XMLGregorianCalendar.class
		emap.put(x.getToken(), BasicType.STRING);// String.class
		emap.put(x.getUnsignedByte(), BasicType.INT);// short.class
		emap.put(x.getUnsignedByteObject(), BasicType.INT);// Short.class
		emap.put(x.getUnsignedInt(), BasicType.INT);// long.class
		emap.put(x.getUnsignedIntObject(), BasicType.INT);// Long.class
		emap.put(x.getUnsignedLong(), BasicType.INT);// BigInteger.class
		emap.put(x.getUnsignedShort(), BasicType.INT);// int.class
		emap.put(x.getUnsignedShortObject(), BasicType.INT);// Integer.class
	}

	private static XMLTypeMapper instance;

	public static XMLTypeMapper instance() {
		if (instance == null)
			instance = new XMLTypeMapper();
		return instance;
	}

	public Type get(XSDMetaModel mm, EClassifier classifier, TypeSystem typesystem) {
		if (classifier == null)
			return null;

		BasicType type = emap.get(classifier);
		if (type == null && classifier.getInstanceClass() != null) {
			type = jmap.get(classifier.getInstanceClass());
			if (type == null && classifier.getInstanceClass().isEnum())
				type = BasicType.UNHANDLED; // TODO: implement enum type for
			// org.eclipse.emf.common.util.Enumerator
		}
		if (type == null)
			return null;

		switch (type) {
			case BOOL:
				return typesystem.getBooleanType();
			case INT:
				return typesystem.getIntegerType();
			case REAL:
				return typesystem.getRealType();
			case STRING:
				return typesystem.getStringType();
			case OBJECT:
				return typesystem.getObjectType();
			case QNAME:
				return mm.getQNameType();
			case LIST:
			case DATE:
			case DURATION:
			case UNHANDLED:
				if (classifier instanceof EDataType)
					return typesystem.getTypeForName(classifier.getInstanceClassName().replace(".", "::"));
		}
		return typesystem.getObjectType();
	}

}
