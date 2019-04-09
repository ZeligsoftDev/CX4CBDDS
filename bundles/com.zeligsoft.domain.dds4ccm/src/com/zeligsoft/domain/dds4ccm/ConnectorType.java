package com.zeligsoft.domain.dds4ccm;

public enum ConnectorType {
	AMI4CCM_Connector(true, true),
	CORBA4CCM_Connector(false, true);
	
	private final boolean isAsyncCapable;
	private final boolean isSyncCapable;
	
	private ConnectorType(boolean isAsyncCapable, boolean isSyncCapable) {
		this.isAsyncCapable = isAsyncCapable;
		this.isSyncCapable = isSyncCapable;
	}
	
	public boolean isAsyncCapable() {
		return isAsyncCapable;
	}
	
	public boolean isSyncCapable() {
		return isSyncCapable;
	}
}
