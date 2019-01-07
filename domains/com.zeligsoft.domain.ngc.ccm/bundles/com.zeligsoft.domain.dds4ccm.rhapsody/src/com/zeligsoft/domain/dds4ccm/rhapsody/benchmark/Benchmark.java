/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.domain.dds4ccm.rhapsody.benchmark;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.RhapsodyAppServer;

public class Benchmark {
	
	public static class TestResult{
		public static String summarize(List<TestResult> testResults) {
			long average = 0; 
			long worst = 0;
			long best = Long.MAX_VALUE;
			long numElements = 0;
			for (TestResult testResult : testResults) {
				final long totalTime = testResult.getTotalTime();
				average += totalTime;
				worst = Math.max(worst, totalTime);
				best = Math.min(best, totalTime);
				numElements = Math.max(numElements, testResult.totalTimers);
			}
			average = average / testResults.size();
			
			// convert to ms from ns:
			average /= 1000000;
			best /= 1000000;
			worst /= 1000000;
			
			return "average = " + average 
					+ "ms, best = " + best 
					+ "ms, worst = " + worst
					+ "ms, numElements = " + numElements;
		}

		long timer;
		long totalTime;
		long totalTimers;
	
		public void startTimer() {
			timer = System.nanoTime();
		}
	
		public void stopTimer() {
			final long stopTime = System.nanoTime();
			totalTime += stopTime - timer;
			totalTimers++;
		}
	
		public long getTotalTime() {
			return totalTime;
		}
		
	}

	private final IRPModelElement rootElement;
	private final int testRuns;

	public Benchmark(Object rootElement, int testRuns) {
		this.rootElement = (IRPModelElement) rootElement;
		this.testRuns = testRuns;
	}
	
	public List<TestResult> benchmark(IProgressMonitor monitor) {
		final List<TestResult> testResults = new ArrayList<TestResult>(testRuns);
		final SubMonitor progress = SubMonitor.convert(monitor, "Profiling model traversal", testRuns);
		
		for(int i = 0; i < testRuns; i++) {
			testResults.add(timeTraversal(rootElement));
			progress.worked(1);
		}
		
//		String message = TestResult.summarize(testResults);
		return testResults;
	}

	protected TestResult timeTraversal(IRPModelElement element) {
		final TestResult testResult = new TestResult();
		
		traverse(element, testResult);
		
		return testResult;
	}

	private void traverse(IRPModelElement element, TestResult testResult) {
		testResult.startTimer();
		@SuppressWarnings("unchecked")
		final List<IRPModelElement> nestedElements = element.getNestedElements().toList();
		testResult.stopTimer();
		for (IRPModelElement childElement : nestedElements) {
			traverse(childElement, testResult);
		}
	}

	public static Object getActiveProject() {
		return RhapsodyAppServer.getActiveRhapsodyApplication().activeProject();
	}

}
