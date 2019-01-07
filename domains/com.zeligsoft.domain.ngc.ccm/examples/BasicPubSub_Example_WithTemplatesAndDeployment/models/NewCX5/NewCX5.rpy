I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID aeda4845-42ad-46e7-ac43-08a803bc2566;
	- _myState = 8192;
	- _name = "NewCX5";
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
	- _modifiedTimeWeak = 7.30.2014::15:26:18;
	- _lastID = 1;
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
		- _id = GUID 5b63fb97-1aff-47d8-af69-cfbc31c67a61;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID faa78419-a33b-4e12-a9a7-993ae4501a44;
	}
	- Multiplicities = { IRPYRawContainer 
		- size = 4;
		- value = 
		{ IMultiplicityItem 
			- _name = "1";
			- _count = 1;
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
			- _id = GUID 5b63fb97-1aff-47d8-af69-cfbc31c67a61;
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
			- _id = GUID 6ca9c294-2349-4249-b5ed-c5b05f26e3fd;
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
			- fileName = "Example";
			- _id = GUID df4260d3-e428-4604-8f77-b39c477f739d;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID f2605a55-d176-468a-9a79-98906b67cbb6;
			- _myState = 8192;
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "7.30.2014::15:25:42";
			- _graphicChart = { CGIClassChart 
				- _id = GUID 1099d858-0b51-464d-85c9-ef08b9fd3a41;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID f2605a55-d176-468a-9a79-98906b67cbb6;
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
					- _id = GUID 8fc652c0-ebee-4e55-9d64-b7fd80f85a86;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "Default.sbs";
						- _subsystem = "Default";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 60ccfeeb-54f7-42d0-a7d2-34a082c153d1;
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
				- m_pRoot = GUID 8fc652c0-ebee-4e55-9d64-b7fd80f85a86;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "Default.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "Default";
				- _id = GUID 5b63fb97-1aff-47d8-af69-cfbc31c67a61;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID faa78419-a33b-4e12-a9a7-993ae4501a44;
		}
	}
}

