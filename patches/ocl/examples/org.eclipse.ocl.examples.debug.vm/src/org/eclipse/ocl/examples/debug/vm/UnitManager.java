/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.IModuleSourceInfo;
import org.eclipse.ocl.examples.debug.vm.utils.LineNumberProvider;
import org.eclipse.ocl.pivot.NamedElement;

public class UnitManager
{
	private static final Logger logger = LogManager.getLogger(UnitManager.class);

	public static void collectAllImports(CompiledUnit mainUnit,
			HashSet<CompiledUnit> allUnits) {
		// TODO Auto-generated method stub
		
	}

	private final @NonNull CompiledUnit fMainUnit;
	private Map<URI, UnitEntry> fUri2UnitMap;
	
	UnitManager(@NonNull CompiledUnit mainUnit) {
		fMainUnit = mainUnit;
		try {
			fUri2UnitMap = createURI2UnitMap(mainUnit);
		} catch (IOException e) {
			fUri2UnitMap = Collections.emptyMap();			
			logger.error(e);
		}
	}	
	
	public @NonNull CompiledUnit getMainUnit() {
		return fMainUnit;
	}
	
	public @Nullable CompiledUnit getCompiledModule(@NonNull URI unitURI) {
		UnitEntry numberProvider = fUri2UnitMap.get(unitURI);
		if(numberProvider != null) {
			return numberProvider.getCompiledModule();
		}
		
		return null;
	}
	
	public @Nullable LineNumberProvider getLineNumberProvider(@NonNull URI unitURI) {
		return fUri2UnitMap.get(unitURI);
	}
	
    public @Nullable CompiledUnit findUnitForModule(@NonNull NamedElement module) {
    	return findCompiledModuleRec(fMainUnit, module);
    }

    private @Nullable CompiledUnit findCompiledModuleRec(@NonNull CompiledUnit rootModule, @NonNull NamedElement module) {
    	if (rootModule.getModules().contains(module)) {
    		return rootModule;
    	}
    	
    	for (CompiledUnit impModule : rootModule.getCompiledImports()) {
    		if (impModule != null) {
    			CompiledUnit findModule = findCompiledModuleRec(impModule, module);
        		if (findModule != null) {
        			return findModule;
        		}
    		}
    	}
    	return null;
    }	
	
	private @NonNull Map<URI, UnitEntry> createURI2UnitMap(@NonNull CompiledUnit mainUnit) throws IOException {
		HashSet<CompiledUnit> allUnits = new HashSet<CompiledUnit>();
		allUnits.add(mainUnit);
		collectAllImports(mainUnit, allUnits);
		Map<URI, UnitEntry> file2Unit = new HashMap<URI, UnitEntry>();
		
		for (CompiledUnit nextUnit : allUnits) {
			if (nextUnit != null) {
				for (NamedElement module : nextUnit.getModules()) {
					if (module != null) {
						IModuleSourceInfo sourceBinding = ASTBindingHelper.getModuleSourceBinding(module);
						if(sourceBinding != null) {
							UnitEntry entry = new UnitEntry(nextUnit, sourceBinding.getLineNumberProvider());
							file2Unit.put(nextUnit.getURI(), entry);
						}
					}
				}
			}
		}
		
		return file2Unit;
	}
	    
    private static class UnitEntry implements LineNumberProvider {
    	
        private final @NonNull CompiledUnit fModule;  
        private final @NonNull LineNumberProvider fProvider;    	

        public UnitEntry(@NonNull CompiledUnit unit, @NonNull LineNumberProvider lineNumberProvider) {
            fModule = unit;
    		fProvider = lineNumberProvider;
        }
        
        public @NonNull CompiledUnit getCompiledModule() {
            return fModule;
        }
        
        public int getLineEnd(int lineNumber) {
            return fProvider.getLineEnd(lineNumber);
        }

        public int getLineCount() {
            return fProvider.getLineCount();
        }

        public int getLineNumber(int offset) {
            return fProvider.getLineNumber(offset);
        } 
    }    
}
