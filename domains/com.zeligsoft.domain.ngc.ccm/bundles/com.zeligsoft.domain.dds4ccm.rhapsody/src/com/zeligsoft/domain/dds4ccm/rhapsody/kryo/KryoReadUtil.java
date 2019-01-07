package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.io.InputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;


import com.telelogic.rhapsody.core.IRPArgument;
import com.telelogic.rhapsody.core.IRPAttribute;
import com.telelogic.rhapsody.core.IRPClass;
import com.telelogic.rhapsody.core.IRPComponentDiagram;
import com.telelogic.rhapsody.core.IRPDependency;
import com.telelogic.rhapsody.core.IRPEnumerationLiteral;
import com.telelogic.rhapsody.core.IRPGeneralization;
import com.telelogic.rhapsody.core.IRPInstance;
import com.telelogic.rhapsody.core.IRPInstanceValue;
import com.telelogic.rhapsody.core.IRPLink;
import com.telelogic.rhapsody.core.IRPLiteralSpecification;
import com.telelogic.rhapsody.core.IRPOperation;
import com.telelogic.rhapsody.core.IRPPackage;
import com.telelogic.rhapsody.core.IRPPort;
import com.telelogic.rhapsody.core.IRPProfile;
import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.IRPStereotype;
import com.telelogic.rhapsody.core.IRPStructureDiagram;
import com.telelogic.rhapsody.core.IRPTag;
import com.telelogic.rhapsody.core.IRPTemplateInstantiation;
import com.telelogic.rhapsody.core.IRPTemplateInstantiationParameter;
import com.telelogic.rhapsody.core.IRPTemplateParameter;
import com.telelogic.rhapsody.core.IRPType;

public class KryoReadUtil {

	public static Object readModel(InputStream in) {
		final Kryo kryo = getKryo();
		final Input input = new Input(in);
		IRPProject project;
		try {
			project = kryo.readObject(input, IRPProject.class);
		} finally {
//			input.close();
		}
		return project;
	}

	private static Kryo getKryo() {
		final Kryo kryo = new Kryo();
		
//		kryo.setRegistrationRequired(true);
		kryo.setDefaultSerializer(RPDefaultDeserializer.class);
		
		kryo.register(RPDefaultDeserializer.UnknownRPModelElement.class);
		
		kryo.register(java.util.LinkedList.class);
		kryo.register(java.util.HashMap.class);
		
		kryo.register(IRPArgument.class, new ProxyDrivenDeserializer<IRPArgument>(RPArgumentHandler.class));
		kryo.register(IRPAttribute.class, new ProxyDrivenDeserializer<IRPAttribute>(RPAttributeHandler.class));
		kryo.register(IRPClass.class, new ProxyDrivenDeserializer<IRPClass>(RPClassHandler.class));
		kryo.register(IRPComponentDiagram.class, new ProxyDrivenDeserializer<IRPComponentDiagram>(RPComponentDiagramHandler.class));
		kryo.register(IRPDependency.class, new ProxyDrivenDeserializer<IRPDependency>(RPDependencyHandler.class));
		kryo.register(IRPEnumerationLiteral.class, new ProxyDrivenDeserializer<IRPEnumerationLiteral>(RPEnumerationLiteralHandler.class));
		kryo.register(IRPGeneralization.class, new ProxyDrivenDeserializer<IRPGeneralization>(RPGeneralizationHandler.class));
		kryo.register(IRPInstance.class, new ProxyDrivenDeserializer<IRPInstance>(RPInstanceHandler.class));
		kryo.register(IRPInstanceValue.class, new ProxyDrivenDeserializer<IRPInstanceValue>(RPInstanceValueHandler.class));
		kryo.register(IRPLink.class, new ProxyDrivenDeserializer<IRPLink>(RPLinkHandler.class));
		kryo.register(IRPLiteralSpecification.class, new ProxyDrivenDeserializer<IRPLiteralSpecification>(RPLiteralSpecificationHandler.class));
		kryo.register(IRPOperation.class, new ProxyDrivenDeserializer<IRPOperation>(RPOperationHandler.class));
		kryo.register(IRPPackage.class, new ProxyDrivenDeserializer<IRPPackage>(RPPackageHandler.class));
		kryo.register(IRPPort.class, new ProxyDrivenDeserializer<IRPPort>(RPPortHandler.class));
		kryo.register(IRPProfile.class, new ProxyDrivenDeserializer<IRPProfile>(RPProfileHandler.class));
		kryo.register(IRPProject.class, new ProxyDrivenDeserializer<IRPProject>(RPProjectHandler.class));
		kryo.register(IRPStereotype.class, new ProxyDrivenDeserializer<IRPStereotype>(RPStereotypeHandler.class));
		kryo.register(IRPStructureDiagram.class, new ProxyDrivenDeserializer<IRPStructureDiagram>(RPStructureDiagramHandler.class));
		kryo.register(IRPTag.class, new ProxyDrivenDeserializer<IRPTag>(RPTagHandler.class));
		kryo.register(IRPTemplateInstantiation.class, new ProxyDrivenDeserializer<IRPTemplateInstantiation>(RPTemplateInstantiationHandler.class));
		kryo.register(IRPTemplateInstantiationParameter.class, new ProxyDrivenDeserializer<IRPTemplateInstantiationParameter>(RPTemplateInstantiationParameterHandler.class));
		kryo.register(IRPTemplateParameter.class, new ProxyDrivenDeserializer<IRPTemplateParameter>(RPTemplateParameterHandler.class));
		kryo.register(IRPType.class, new ProxyDrivenDeserializer<IRPType>(RPTypeHandler.class));

		return kryo;
	}

}
