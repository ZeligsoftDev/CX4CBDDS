package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.spi.net4j.ServerProtocolFactory;

import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.EclipseServerSignals;

public class ModelServicesServerProtocol extends SignalProtocol<CXServerInfrastructure> {

	public static class Factory extends ServerProtocolFactory {

		public Factory() {
			super(EclipseServerSignals.PROTOCOL_NAME);
		}

		@Override
		public Object create(String description)
				throws ProductCreationException {
			return new ModelServicesServerProtocol();
		}

	}

	public ModelServicesServerProtocol() {
		super(EclipseServerSignals.PROTOCOL_NAME);
	}

	@Override
	protected SignalReactor createSignalReactor(short signalID) {
		switch(EclipseServerSignals.values()[signalID]) {
		case TransformToUml2:
//			return new TransformToUml2Indicator(this);
			return new TransformToUml2IndicatorWithProgress(this);
			
		case Generate:
			return new GenerateIndicatorWithProgress(this);
			
		case Validate:
			// TODO
			return new ValidateIndicatorWithProgress(this);
			
		case Benchmark:
			return new BenchmarkIndicatorWithProgress(this);
			
		case FastTransform:
			return new FastTransformToUml2IndicatorWithProgress(this);			
			
		case GetGenerators:
			return new GetGeneratorsIndicator(this);
			
		default:
			return super.createSignalReactor(signalID);
		}
	}

}
