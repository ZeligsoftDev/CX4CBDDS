package com.zeligsoft.codegeneration.test;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import java.lang.System;

public class CreateUMLModel {
	
	protected static Model createModel(String name) {

        Model model = UMLFactory.eINSTANCE.createModel();

        model.setName(name);



        System.out.println(
        		"Model '" + model.getQualifiedName() + "' created.");



        return model;

    }
	
	

}
