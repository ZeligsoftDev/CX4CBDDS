I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID f056654a-c3f4-47a9-b768-80a5308083a3;
	- _myState = 8192;
	- _name = "DDS4CCM";
	- _modifiedTimeWeak = 6.6.2014::15:17:8;
	- _UserColors = { IRPYRawContainer 
		- size = 16;
		- value = 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 
	}
	- _defaultSubsystem = { ISubsystemHandle 
		- _m2Class = "ISubsystem";
		- _filename = "Default.sbs";
		- _subsystem = "";
		- _class = "";
		- _name = "Default";
		- _id = GUID b75e69a4-1593-40dd-bcc0-00605fcf3aba;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID 22275eed-4640-45a7-86f8-9d9867647cbe;
	}
	- Multiplicities = { IRPYRawContainer 
		- size = 4;
		- value = 
		{ IMultiplicityItem 
			- _name = "1";
			- _count = -1;
		}
		{ IMultiplicityItem 
			- _name = "*";
			- _count = -1;
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
			- fileName = "Default";
			- _id = GUID b75e69a4-1593-40dd-bcc0-00605fcf3aba;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _id = GUID 14fbef4a-9537-4a12-8f78-790ffcd8b2f6;
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
			- _id = GUID 22275eed-4640-45a7-86f8-9d9867647cbe;
		}
	}
}

