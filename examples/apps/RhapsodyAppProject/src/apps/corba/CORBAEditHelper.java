package apps.corba;

import apps.ITriggerRunner;

import com.ibm.rhapsody.apps.TriggerAdapter.Trigger;
import com.telelogic.rhapsody.core.IRPApplication;
import com.telelogic.rhapsody.core.IRPModelElement;
import com.telelogic.rhapsody.core.IRPType;

public class CORBAEditHelper implements ITriggerRunner {

	public static final CORBAEditHelper INSTANCE = new CORBAEditHelper();

	CORBAEditHelper() {

	}

	@Override
	public void eventTriggered(Trigger trigger, IRPApplication rhapsody,
			IRPModelElement selected, String concept) {
		if (CORBADomainNames.CORBAARRAY.equals(concept)) {
			IRPType type = (IRPType) selected;
			type.setKind("Typedef");
		}else if(CORBADomainNames.CORBAENUM.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("enumeration");
		}else if(CORBADomainNames.CORBASEQUENCE.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Typedef");
		}else if(CORBADomainNames.CORBASTRUCT.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Structure");
		}else if(CORBADomainNames.CORBATYPE_DEF.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Typedef");
		}else if(CORBADomainNames.CORBAUNION.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Union");
		}else if(CORBADomainNames.CORBAEXCEPTION.equals(concept)){
			IRPType type = (IRPType) selected;
			type.setKind("Structure");
		}
	}
}
