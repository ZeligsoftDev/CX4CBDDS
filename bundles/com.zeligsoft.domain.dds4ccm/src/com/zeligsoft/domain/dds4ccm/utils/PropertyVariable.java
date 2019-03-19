package com.zeligsoft.domain.dds4ccm.utils;
// PropertyVariable.NODE_IOR.matches(sp.getName(), modelType)
public enum PropertyVariable {
	COMPONENT_FACTORY("component factory", "nl.remedy.it.DnCX11.Executor.Factory"),
	NODE_IOR("edu.vanderbilt.dre.DAnCE.StringIOR", "nl.remedy.it.DnCX11.StringIOR"),
	NODE_RESOURCE_TYPE("edu.vanderbilt.dre.DAnCE.NodeAddress", "nl.remedy.it.DnCX11.NodeAddress"),
	REGISTER_NAMING("edu.vanderbilt.dre.DAnCE.RegisterNaming", "nl.remedy.it.DnCX11.RegisterNaming"),
	COMPONENT_HOME("edu.vanderbilt.dre.CIAO.ComponentHomeId", "nl.remedy.it.DnCX11.ComponentHomeId"),
	EXEC_ARTIFACT("edu.vanderbilt.dre.CIAO.ExecutorArtifact", "nl.remedy.it.DnCX11.Executor.Artifact"),
	SVNT_ENTRYPT("edu.vanderbilt.dre.CIAO.ServantEntrypoint", "nl.remedy.it.DnCX11.Servant.Factory"),
	SVNT_ARTIFACT("edu.vanderbilt.dre.CIAO.ServantArtifact", "nl.remedy.it.DnCX11.Servant.Artifact"),
	IMPL_TYPE("edu.vanderbilt.dre.DAnCE.ImplementationType", "nl.remedy.it.DnCX11.ImplementationType"),
	CCM_COMPONENT("edu.vanderbilt.dre.CCM.Component", "nl.remedy.it.CCM.Component"),
	CCM_HOMEDCOMPONENT("edu.vanderbilt.dre.CCM.HomedComponent", "nl.remedy.it.CCM.HomedComponent"),
	CCM_CONNECTOR("edu.vanderbilt.dre.CCM.Connector", "nl.remedy.it.CCM.Connector"),
	DANCE_LOCALITYMANAGER("edu.vanderbilt.dre.DAnCE.LocalityManager", "nl.remedy.it.DnCX11.LocalityManager"),
	CCM_HOME("edu.vanderbilt.dre.CCM.Home", "nl.remedy.it.CCM.Home"),
	CCM_CONTAINER("edu.vanderbilt.dre.CCM.Container", "nl.remedy.it.CCM.Container"),
	DANCE_LM_CPUAFFINITY("edu.vanderbilt.dre.DAnCE.LocalityManager.CPUAffinity", "nl.remedy.it.DnCX11.LocalityManager.CPUAffinity"),
	DANCE_LM_PROCESSNAME("edu.vanderbilt.dre.DAnCE.LocalityManager.ProcessName", "nl.remedy.it.DnCX11.LocalityManager.ProcessName"),
	DANCE_LM_PROCESSPRIORITY("edu.vanderbilt.dre.DAnCE.LocalityManager.ProcessPriority", "nl.remedy.it.DnCX11.LocalityManager.ProcessPriority"),
	LOCALITY_ARGUMENTS("edu.vanderbilt.dre.DAnCE.LocalityArguments", "nl.remedy.it.DnCX11.LocalityArguments");

	private final String axciomaName;
	private final String atcdName;
	
	private PropertyVariable(String atcdName, String axciomaName) {
		this.atcdName = atcdName;
		this.axciomaName = axciomaName;
		
	}
	
	public String getName(String modelType) {
		if(ModelTypeDDS4CCM.valueOf(modelType).equals(ModelTypeDDS4CCM.ATCD)) {
			return atcdName;
		} else {
			return axciomaName;
		}
	}
	
	public String getMigratedName() {
		return axciomaName;
	}
	
	public boolean matches(String foundName, String modelType) {// "edu.vanderbilt.dre.DAnCE.StringIOR", "ATCD"
		return foundName.equals(getName(modelType));
	}
	
}
