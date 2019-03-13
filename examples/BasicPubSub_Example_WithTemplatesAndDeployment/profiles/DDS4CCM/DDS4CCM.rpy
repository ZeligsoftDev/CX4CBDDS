I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID 76bfb35a-a327-440a-8903-7f8be2a2c5b8;
	- _myState = 8192;
	- _name = "DDS4CCM";
	- _modifiedTimeWeak = 7.15.2014::16:31:37;
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
		- _id = GUID 401d59a5-4e91-446f-9ef8-9f3d7ad7b841;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID 8db05514-1736-4c0a-a036-62f57c9af517;
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
			- _id = GUID 401d59a5-4e91-446f-9ef8-9f3d7ad7b841;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _id = GUID a6a6e7f8-334e-4c1c-bfbb-9a7608dd05c5;
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
			- _id = GUID 8db05514-1736-4c0a-a036-62f57c9af517;
		}
	}
}

