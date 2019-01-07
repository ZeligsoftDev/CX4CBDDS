/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;

import com.zeligsoft.domain.dds4ccm.rhapsody.net4j.protocols.RhapsodyClientSignals;

/**
 * CXNet4j utility class for CX.
 * @author Paul Elder
 *
 */
public class CXNet4j {
	
	private static CXNet4j instance;
	
	public static void shutdown() {
		if(instance != null) {
			instance.deactivate();
			instance = null;
		}
	};
	
	/**
	 * Return the CXNet4j instance.
	 * @return the CXNet4j instance
	 * @throws IllegalStateException if {@link #startup()} has not been called.
	 */
	public static CXNet4j getInstance() {
		if(instance == null) {
			throw new IllegalStateException("instance has not been initialized. See CXNet4j.init()");
		}
		return instance;
	}

	public static void startup() {
		instance = new CXNet4j();
		instance.activate();
	}
	
	private final IManagedContainer managedContainer = IPluginContainer.INSTANCE;
	private IAcceptor acceptor;
	
	/**
	 * 
	 */
	private CXNet4j() {
		// TODO Auto-generated constructor stub
	}

	private void activate() {
		OMPlatform.INSTANCE.setDebugging(false);
		OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
		OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
		final String commandHostAndPort = System.getProperty("com.prismtech.cx.eclipse.commandHostAndPort", "localhost:9999");
		
		acceptor = Net4jUtil.getAcceptor(managedContainer, "tcp", commandHostAndPort);

	}

	private void deactivate() {
		LifecycleUtil.deactivate(acceptor);
		acceptor = null;
	}
	
	public IManagedContainer getManagedContainer() {
		return managedContainer;
	}

	public SignalProtocol<?> getClientProtocol() {
//		final IProtocol<?> clientProtocol = clientProvider.getProtocol(RhapsodyClientSignals.PROTOCOL_NAME);
		final IConnector connector = Net4jUtil.getConnector(managedContainer, "tcp",
				"localhost:9998");
		
		SignalProtocol<?> protocol = new SignalProtocol<Object>(RhapsodyClientSignals.PROTOCOL_NAME);
//		protocol.setTimeout(60 * 1000L);
		
//		final SignalProtocol<?> protocol = (SignalProtocol<?>) clientProtocol;
		protocol.open(connector);
		
		return protocol;
	}

}
