package apps.ccm.wizard;

public interface INewCCMComponentCompositeController {

	String computeDefaultPackageName(String text);

	String computeDefaultComponentDiagramName(String text);

	String computeDefaultAssemblyName(String text);

	String computeDefaultStructureDiagramName(String text);

	void onComplete(String componentName, String componentPackageName,
			String componentDiagramName, String assemblyName,
			String structureDiagramName);

}
