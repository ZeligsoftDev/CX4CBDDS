/**
 * Copyright 2021 Zeligsoft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zeligsoft.cx.codegen.ui.actions;

/**
 * An interface for all classes that report the results of a transformation.
 * This includes reporting results to the console ({@link WorkflowResultConsoleReporter})
 * or marking elements in the Model Explorer (unimplemented).
 * 
 * @author Ernesto Posse
 */
public interface WorkflowResultReporter {

	public void addResult(WorkflowResult result);
	
	public void reset();
	
	public void reportAll();
	
	public void report(WorkflowResult result);

}
