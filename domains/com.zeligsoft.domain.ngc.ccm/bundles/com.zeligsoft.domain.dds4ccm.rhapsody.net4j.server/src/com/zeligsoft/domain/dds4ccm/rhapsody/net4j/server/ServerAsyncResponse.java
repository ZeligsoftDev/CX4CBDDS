package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.RhapsodyClientSignals;

public class ServerAsyncResponse extends Request {

	
	private final String title;
	private final String message;

	public ServerAsyncResponse(SignalProtocol<?> protocol, String title,
			String message) {
		super(protocol, RhapsodyClientSignals.AsyncResult);
		this.title = title;
		this.message = message;
	}

	@Override
	protected void requesting(ExtendedDataOutputStream out) throws Exception {
		out.writeString(title);
		out.writeString(message);
	}

}
