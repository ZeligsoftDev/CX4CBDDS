package com.zeligsoft.domain.posix.codegen.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

public class DeploymentUtils {
	
	public static Collection<String> getMultiInstanceNames(Property source){
		Collection<String> instList = new ArrayList<String>();
		int upper = source.getUpper();
		if (!source.isMultivalued())
		{
			instList.add(source.getName());
		}
		else 
		{
			for (int i = 0; i < upper; i++)
			{
				String temp = source.getName() + '_' + i;
				instList.add(temp);
			}
		}
		
		return instList;
	}
	
	public static Collection<String> getProcessCompPortIds(Port port, Property source) {
		Collection<String> idList = new ArrayList<String>();
		int totalUpper = source.getUpper() * port.getUpper();
		String name = source.getName().toUpperCase() + '_' + port.getName().toUpperCase() + '_';
		for (int i = 0; i < totalUpper; i++ )
		{
			idList.add(name + i);
		}
		return idList;
	}

	public static Collection<ConnectorEnd> getOtherAssemblyConnectorEndPart(Connector conn, Property part, Port usesEnd) {
		Collection<ConnectorEnd> connectorList = new ArrayList<ConnectorEnd>();
		
		for( ConnectorEnd end : conn.getEnds())
		{
			if( (end.getPartWithPort().equals(part)) && (end.getRole().equals(usesEnd)))
			{
				for( ConnectorEnd endInverse : conn.getEnds())
				{
					if( (!endInverse.getPartWithPort().equals(part)) || (!endInverse.getRole().equals(usesEnd)))
					{
						connectorList.add(endInverse);
					}  			
				} 
			}  			
		} 
		
		return connectorList;
	
	}
	
	public static Collection<ConnectorEnd> getOtherConnectorEndPart(NamedElement conn, Property part, Port usesEnd, Property target) {
		Collection<ConnectorEnd> sapEnds = new ArrayList<ConnectorEnd>();
		
		if (conn instanceof Connector ){
			
			return getOtherAssemblyConnectorEndPart((Connector)conn, part, usesEnd);
		}
		if (conn instanceof Port){
			Collection<ConnectorEnd> sppEnds = ((Port)conn).getEnds();
			ArrayList<Dependency> sapList = ZDeploymentUtil.getAllocationsForTargetPart(target);
			for (Dependency sapAlloc : sapList)
			{
				for (NamedElement sapClient : sapAlloc.getClients())
				{
					NamedElement sapEnd = ZDeploymentUtil.getModelElement((Property)sapClient);
					for (ConnectorEnd end : ((Port)sapEnd).getEnds())
					{
						sapEnds.add(end);
					}
				}
			}
			return getOtherSAPConnectorEndPart(sppEnds, part, usesEnd, sapEnds);
		}
		
		return null;
	}
	
	public static Collection<ConnectorEnd> getOtherSAPConnectorEndPart(Collection<ConnectorEnd> sppEnds, Property part, Port usesEnd, Collection<ConnectorEnd> sapEnds){
		Collection<ConnectorEnd> connEndList = new ArrayList<ConnectorEnd>();
		
		// first check spp
		for (ConnectorEnd end : sppEnds)
		{
			for (ConnectorEnd otherEnd : ((Connector)(end.getOwner())).getEnds() )
			{
				if( otherEnd.getPartWithPort() != null)
				{
					if( (otherEnd.getPartWithPort().equals(part)) && (otherEnd.getRole().equals(usesEnd)) )
					{
						for(ConnectorEnd sapEnd : sapEnds)
						{
							for (ConnectorEnd otherSapEnd : ((Connector)(sapEnd.getOwner())).getEnds() )
							{
								if( (otherSapEnd.getPartWithPort() != null) && (!((Port)otherSapEnd.getRole()).getProvideds().isEmpty()))
								{
									connEndList.add(otherSapEnd);
								}
							}
						}
					}
				}
			}
			
		}
		// second check sap
		for (ConnectorEnd end : sapEnds)
		{
			for (ConnectorEnd otherEnd : ((Connector)(end.getOwner())).getEnds() )
			{
				if( otherEnd.getPartWithPort() != null)
				{
					if( (otherEnd.getPartWithPort().equals(part)) && (otherEnd.getRole().equals(usesEnd)) )
					{
						for(ConnectorEnd sppEnd : sppEnds)
					
							for (ConnectorEnd otherSppEnd : ((Connector)(sppEnd.getOwner())).getEnds() )
							{
								if( (otherSppEnd.getPartWithPort() != null) && (!((Port)otherSppEnd.getRole()).getProvideds().isEmpty()))
								{
									connEndList.add(otherSppEnd);
								}
							}
						}
					}
				}
		}
			
		return connEndList;
	}
	
	public static Property getCorrespondingProperty(Property source, Collection<Property> sourceList){
		for (Property src : sourceList){
			if (src.equals(source))
				return src;
		}
		return null;
	}
	
	public static boolean getCompInstNameFromId(String idName, String instName){
		return idName.regionMatches(0, instName.toUpperCase(), 0, instName.length());
	}
	
	public static Type getParameterType(Parameter param){
		return param.getType();
	}
	
	public static Type getPropertyType(Property attr){
		return attr.getType();
	}

}
