I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID 4e4a1bd3-87a4-4b3e-a1c9-7fd0b80a4d03;
	- _myState = 8192;
	- _name = "CCM_PSAT";
	- Stereotypes = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IHandle 
			- _m2Class = "IStereotype";
			- _filename = "$OMROOT\\Profiles\\CX\\CX.sbs";
			- _subsystem = "CX";
			- _class = "";
			- _name = "CX";
			- _id = GUID fe257762-9188-4c17-9a97-9225244b6a2f;
		}
	}
	- _modifiedTimeWeak = 8.13.2014::15:32:5;
	- _lastID = 2;
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
		- _id = GUID 5d0c0d3b-10f0-424e-b1a2-b1c5a1fe55af;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID 6031109c-8e1f-40c7-8d57-3e719938b3be;
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
		- size = 6;
		- value = 
		{ ISubsystem 
			- fileName = "Default";
			- _id = GUID 5d0c0d3b-10f0-424e-b1a2-b1c5a1fe55af;
		}
		{ IProfile 
			- fileName = "CX";
			- _persistAs = "$OMROOT\\Profiles\\CX";
			- _id = GUID 2173cb78-d7b9-4000-8aeb-c411d58d1f48;
			- _isReference = 1;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "$OMROOT/Profiles/CX/";
			- _id = GUID 772fc88d-3eaf-4cb0-98e4-c084957b6d65;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "IDLPrimitives";
			- _persistAs = "$OMROOT\\Profiles\\CX";
			- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "DDS_DCPS";
			- _persistAs = "$OMROOT\\Profiles\\CX";
			- _id = GUID 2fab8e32-403f-4402-83ca-91952c6cafd0;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "CCM_PSAT";
			- _id = GUID 6e0ec8a2-577d-405e-9e37-84b4b1e132a0;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID 3be86ed5-0f36-43c5-9ee1-d89692aa16d2;
			- _myState = 8192;
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "8.13.2014::15:24:53";
			- _graphicChart = { CGIClassChart 
				- _id = GUID fa328d4d-2d94-482f-badd-b0375762adb3;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID 3be86ed5-0f36-43c5-9ee1-d89692aa16d2;
				}
				- m_pParent = ;
				- m_name = { CGIText 
					- m_str = "";
					- m_style = "Arial" 10 0 0 0 1 ;
					- m_color = { IColor 
						- m_fgColor = 0;
						- m_bgColor = 0;
						- m_bgFlag = 0;
					}
					- m_position = 1 0 0  ;
					- m_nIdent = 0;
					- m_bImplicitSetRectPoints = 0;
					- m_nOrientationCtrlPt = 8;
				}
				- m_drawBehavior = 0;
				- m_bIsPreferencesInitialized = 0;
				- elementList = 1;
				{ CGIClass 
					- _id = GUID 33b391a3-5497-41d0-b75f-abab8bb7d875;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "Default.sbs";
						- _subsystem = "Default";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 3cc1638e-29ed-47d9-a1e0-9ac81c06d442;
					}
					- m_pParent = ;
					- m_name = { CGIText 
						- m_str = "TopLevel";
						- m_style = "Arial" 10 0 0 0 1 ;
						- m_color = { IColor 
							- m_fgColor = 0;
							- m_bgColor = 0;
							- m_bgFlag = 0;
						}
						- m_position = 1 0 0  ;
						- m_nIdent = 0;
						- m_bImplicitSetRectPoints = 0;
						- m_nOrientationCtrlPt = 5;
					}
					- m_drawBehavior = 0;
					- m_bIsPreferencesInitialized = 0;
					- m_AdditionalLabel = { CGIText 
						- m_str = "";
						- m_style = "Arial" 10 0 0 0 1 ;
						- m_color = { IColor 
							- m_fgColor = 0;
							- m_bgColor = 0;
							- m_bgFlag = 0;
						}
						- m_position = 1 0 0  ;
						- m_nIdent = 0;
						- m_bImplicitSetRectPoints = 0;
						- m_nOrientationCtrlPt = 1;
					}
					- m_polygon = 0 ;
					- m_nNameFormat = 0;
					- m_nIsNameFormat = 0;
					- Compartments = { IRPYRawContainer 
						- size = 0;
					}
					- Attrs = { IRPYRawContainer 
						- size = 0;
					}
					- Operations = { IRPYRawContainer 
						- size = 0;
					}
				}
				
				- m_access = 'Z';
				- m_modified = 'N';
				- m_fileVersion = "";
				- m_nModifyDate = 0;
				- m_nCreateDate = 0;
				- m_creator = "";
				- m_bScaleWithZoom = 1;
				- m_arrowStyle = 'S';
				- m_pRoot = GUID 33b391a3-5497-41d0-b75f-abab8bb7d875;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "Default.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "Default";
				- _id = GUID 5d0c0d3b-10f0-424e-b1a2-b1c5a1fe55af;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID 6031109c-8e1f-40c7-8d57-3e719938b3be;
		}
	}
}

