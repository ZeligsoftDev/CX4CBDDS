I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID e3f38e8d-d06d-402f-8606-1d3c5a1a5353;
	- _myState = 8192;
	- _name = "BasicPubSub";
	- _modifiedTimeWeak = 4.18.2014::16:16:4;
	- _lastID = 4;
	- _UserColors = { IRPYRawContainer 
		- size = 16;
		- value = 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 
	}
	- _defaultSubsystem = { ISubsystemHandle 
		- _m2Class = "ISubsystem";
		- _filename = "BasicPubSub.sbs";
		- _subsystem = "";
		- _class = "";
		- _name = "BasicPubSub";
		- _id = GUID ef2a1be4-9363-442e-a6b4-ddcd6af26aa6;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID e681fdcf-25e5-4a41-844f-96b8fb85e737;
	}
	- Multiplicities = { IRPYRawContainer 
		- size = 4;
		- value = 
		{ IMultiplicityItem 
			- _name = "1";
			- _count = 30;
		}
		{ IMultiplicityItem 
			- _name = "*";
			- _count = 0;
		}
		{ IMultiplicityItem 
			- _name = "0,1";
			- _count = -1;
		}
		{ IMultiplicityItem 
			- _name = "1..*";
			- _count = -1;
		}
	}
	- Subsystems = { IRPYRawContainer 
		- size = 2;
		- value = 
		{ ISubsystem 
			- fileName = "BasicPubSub";
			- _id = GUID ef2a1be4-9363-442e-a6b4-ddcd6af26aa6;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "D:\\workspaces9\\runtime-NGC\\com.prismtech.domain.dds4ccm.rhapsody.example\\profiles\\DDS4CCM\\DDS4CCM_rpy";
			- _id = GUID 681c1aed-988c-425a-9396-45149ca070ca;
			- _isReference = 1;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 0;
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID e681fdcf-25e5-4a41-844f-96b8fb85e737;
		}
	}
}

