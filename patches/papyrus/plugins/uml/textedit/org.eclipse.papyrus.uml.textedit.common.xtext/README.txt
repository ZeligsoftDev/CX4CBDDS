INMPORTANT:

I have renamed the Epackage http://www.eclipse.org/uml2/4.0.0/Types to http://www.eclipse.org/uml2/4.0.0/common/Types in the generated code.

It has been renamed in the:
	/org.eclipse.papyrus.uml.textedit.common.xtext/src-gen/org/eclipse/papyrus/uml/textedit/common/xtext/UmlCommon.genmodel
	/org.eclipse.papyrus.uml.textedit.common.xtext/src-gen/types/TypesPackage.java
	/org.eclipse.papyrus.uml.textedit.common.xtext/src-gen/types/impl/TypesFactoryImpl.java
	
why?
Several xtext project generates the same epackage. So when xtext tries to lad the type package for common, it don't find the good and generate
 a class cast exception
 
 When you try to reuse this package, maybe you will have a compilation error with the serializer.
 It want the concrete class "UmlCommonSemanticSequencer" that not exist. So replace it by the abstract class AbstractUmlCommonSemanticSequencer.
 
 I don't know how to solve it without modify the generated code
 
 
 