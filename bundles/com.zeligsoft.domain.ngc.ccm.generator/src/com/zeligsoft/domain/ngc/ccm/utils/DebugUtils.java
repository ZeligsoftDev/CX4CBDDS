package com.zeligsoft.domain.ngc.ccm.utils;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.Module;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;

public class DebugUtils {

	@SuppressWarnings("rawtypes")
	public static Object printIDLSpecs(String name, List objs) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return objs;
		System.out.println("List of Specifications for " + name);
		for (Object obj : objs) {
			if (obj instanceof Specification) {
				printIDLSpec(name, (Specification)obj);
			}
		}
		System.out.println("End of List of Specifications for " + name);
		
		return objs;
	}
	
	public static Object printIDLSpec(String label, Specification spec) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return spec;
		System.out.println("(" + label + ") Specification " + spec.toString());
		printEAnnotations(0, spec);
		System.out.println("Definitions:");
		printDefinitions(0, spec.getDefinitions());
		return spec;
	}

	public static Object printIDLSpec(String label, Object spec) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return spec;
		if (spec instanceof Specification) {
			printIDLSpec(label, (Specification)spec);
		}
		return spec;
	}
	
	private static void printDefinitions(int i, EList<Definition> definitions) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return;
		for (Definition def : definitions) {
			indent(i + 2);
			System.out.println("Definition " + def.toString());
			printDefinition(i, def);
		}
	}
	
	public static void printDefinition(int i, Definition def) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return;
		if (def instanceof Module) {
			printModule(i + 2, "def", (Module)def);
		} else if (def instanceof TypeDecl) {
			printTypeDecl(i + 2, (TypeDecl)def);
		}
		
	}
	
	public static void printTypeDecl(int i, TypeDecl tdecl) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return;
		indent(i + 2);
		System.out.println("TypeDecl " + tdecl.toString());
		printEAnnotations(i + 4, tdecl);
	}

	private static void printEAnnotations(int i, EObject eobj) {
		indent(i);
		System.out.println("EAnnotations for " + eobj.toString());
		if (eobj instanceof StructType) {
			indent(i);
			System.out.println("StructType EAnnotations:");
			StructType st = (StructType) eobj;
			EList<EAnnotation> annotations = st.getEAnnotations();
			if (annotations != null) {
				for (EAnnotation a : annotations) {
					indent(i);
					System.out.println("EAnnotation " + a.toString());
					printDetails(i + 2, a.getDetails());
				}
			}
		}
	}

	private static void printDetails(int i, EMap<String, String> emap) {
		if (emap == null || emap.keySet() == null) return;
		for (String key : emap.keySet()) {
			indent(i);
			System.out.println("key = " + key + " val = " + emap.get(key));
		}
	}
	
	public static Object printModuleAndReturn(Integer i, String label, Module mod, Object obj) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return obj;
		printModule(i, label, mod);
		return obj;
	}
	
	public static Object printModule(Integer i, String label, Module mod) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return mod;
		indent(i + 2);
		System.out.println("(" + label + ") Module " + mod.getName() + " (" + mod.toString() + ")");
		printDefinitions(i + 4, mod.getDefinitions());
		return mod;
	}

	public static Object printModule(Integer i, String label, Object mod) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return mod;
		if (mod instanceof Module) {
			printModule(i, label, (Module)mod);
		}
		return mod;
	}
	
	public static Object printStructType(Integer i, String label, StructType st) {
		if (!com.zeligsoft.cx.codegen.internal.OawDebug.isDebugEnabled())
			return st;
		indent(i + 2);
		System.out.println("(" + label + ") StructType " + st.getName() + " (" + st.toString() + ")");
		printEAnnotations(i + 4, st);
		return st;
	}


	private static void indent(int i) {
		for (int j = 0; j < 2 * i; j++) 
			System.out.print(' ');
	}
}
