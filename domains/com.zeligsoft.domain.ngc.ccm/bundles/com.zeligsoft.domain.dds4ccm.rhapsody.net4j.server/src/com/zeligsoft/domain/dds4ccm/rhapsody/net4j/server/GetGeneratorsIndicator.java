package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;
import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;

public class GetGeneratorsIndicator extends IndicationWithResponse {

	private List<String> result = new ArrayList<String>();

	public GetGeneratorsIndicator(
			ModelServicesServerProtocol modelServicesServerProtocol) {
		super(modelServicesServerProtocol, EclipseServerSignals.GetGenerators);
	}

	@Override
	protected void indicating(ExtendedDataInputStream in) throws Exception {
		final String zdlConcept = in.readString();

		final List<WorkflowEntry> workflows = WorkflowEntry.getWorkflows(zdlConcept, null);
		final boolean addAll = workflows.size() > 1;
		if(addAll) {
			result.add("All");
		}
		if(workflows.size() == 0 && "Package".equals(zdlConcept)) {
			// hack for packages...
			result.add("IDL");
		}
		for (WorkflowEntry entry : workflows) {
			result.add(entry.getDisplayLabel());
		}
	}

	@Override
	protected void responding(ExtendedDataOutputStream out) throws Exception {
		out.writeInt(result.size());
		for (String entry : result) {
			out.writeString(entry);
		}
	}

}
