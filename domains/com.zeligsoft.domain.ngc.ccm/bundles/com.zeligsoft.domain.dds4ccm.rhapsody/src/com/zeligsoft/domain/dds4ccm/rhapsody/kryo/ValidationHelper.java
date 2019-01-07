package com.zeligsoft.domain.dds4ccm.rhapsody.kryo;

import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.IMissingFunctionCollector;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.MissingFunctionCollector;

public class ValidationHelper {

	public static void sendBackValidationResults(
			OutputStream out, Map<String, Set<String>> resultMap) {
		IMissingFunctionCollector missingFunctions = MissingFunctionCollector.getInstance();
		final Kryo kryo = new Kryo();
		final Output output = new Output(out);
		kryo.writeObject(output, resultMap);
		kryo.writeObject(output, missingFunctions.getAllMissingGetters());
		kryo.writeObject(output, missingFunctions.getAllMissing1ArgMethods());
		kryo.writeObject(output, missingFunctions.getCollectedElements());
		output.flush();
		missingFunctions.reset();
	}

}
