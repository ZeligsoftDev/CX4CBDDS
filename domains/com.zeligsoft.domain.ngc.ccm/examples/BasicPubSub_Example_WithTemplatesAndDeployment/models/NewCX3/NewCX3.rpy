I-Logix-RPY-Archive version 8.9.0 C++ 7139044
{ IProject 
	- _id = GUID 4c4dc143-339d-4fe3-a875-a8577265ca08;
	- _myState = 8192;
	- _name = "NewCX3";
	- _modifiedTimeWeak = 7.18.2014::19:15:15;
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
		- _id = GUID b49c807f-64bc-43bb-bb66-aaa5e1aced9d;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID f5fb1940-0c3e-4d96-a0a3-e546ada4cb57;
	}
	- Multiplicities = { IRPYRawContainer 
		- size = 4;
		- value = 
		{ IMultiplicityItem 
			- _name = "1";
			- _count = 10;
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
		- size = 5;
		- value = 
		{ ISubsystem 
			- fileName = "Default";
			- _id = GUID b49c807f-64bc-43bb-bb66-aaa5e1aced9d;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "$OMROOT\\Profiles\\cxDDS4CCM";
			- _id = GUID 10830a6d-cd54-4f3b-b1ea-99243f80fe60;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "IDLPrimitives";
			- _persistAs = "$OMROOT\\Profiles\\cxDDS4CCM";
			- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "CCM_DDS";
			- _persistAs = "$OMROOT\\Profiles\\cxDDS4CCM";
			- _id = GUID 073f877f-cf70-473c-bfbc-df3202c99fb4;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "Examples";
			- _id = GUID 51ac647e-40f4-4d8f-aa28-4a67045e0656;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID 60434789-a5f4-4f88-ac07-8c99a708cb90;
			- _myState = 8192;
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "7.18.2014::19:15:5";
			- _graphicChart = { CGIClassChart 
				- _id = GUID d05a79f2-f996-4edd-97ec-b52ae3c958e1;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID 60434789-a5f4-4f88-ac07-8c99a708cb90;
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
					- _id = GUID 3a07e94a-fced-44ef-8212-518855082603;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "Default.sbs";
						- _subsystem = "Default";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 755cb36b-d6c7-42a2-9b81-270c4b5eda9e;
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
				- m_pRoot = GUID 3a07e94a-fced-44ef-8212-518855082603;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "Default.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "Default";
				- _id = GUID b49c807f-64bc-43bb-bb66-aaa5e1aced9d;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID f5fb1940-0c3e-4d96-a0a3-e546ada4cb57;
		}
	}
}

