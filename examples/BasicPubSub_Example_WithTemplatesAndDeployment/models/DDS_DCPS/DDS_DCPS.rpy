I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID a419d7e9-8eb8-4050-b262-307a8ea6cc0f;
	- _myState = 8192;
	- _name = "DDS_DCPS";
	- _modifiedTimeWeak = 6.9.2014::17:11:32;
	- _lastID = 1;
	- _UserColors = { IRPYRawContainer 
		- size = 16;
		- value = 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 
	}
	- _defaultSubsystem = { ISubsystemHandle 
		- _m2Class = "ISubsystem";
		- _filename = "CCM_DDS.sbs";
		- _subsystem = "";
		- _class = "";
		- _name = "CCM_DDS";
		- _id = GUID 073f877f-cf70-473c-bfbc-df3202c99fb4;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID 25115994-be1a-4708-9d49-39f5b0a5fcb7;
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
		- size = 3;
		- value = 
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "D:\\workspaces9\\runtime-NGC\\BasicPubSub_Example_WithTemplatesAndDeployment\\profiles\\DDS4CCM\\DDS4CCM_rpy";
			- _id = GUID 14fbef4a-9537-4a12-8f78-790ffcd8b2f6;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "CCM_DDS";
			- _id = GUID 073f877f-cf70-473c-bfbc-df3202c99fb4;
		}
		{ ISubsystem 
			- fileName = "IDLPrimitives";
			- _persistAs = "D:\\workspaces9\\runtime-NGC\\BasicPubSub_Example_WithTemplatesAndDeployment\\models\\IDLPrimitives\\IDLPrimitives_rpy";
			- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			- _isReference = 1;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID 9fad4517-d9a3-46ac-a4f8-c2bf7ed71e4a;
			- _myState = 8192;
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "6.9.2014::17:11:32";
			- _graphicChart = { CGIClassChart 
				- _id = GUID 97ea5e95-a8ae-44b9-adf8-2458b0ff5b62;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID 9fad4517-d9a3-46ac-a4f8-c2bf7ed71e4a;
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
					- _id = GUID 9f009e4a-3ce1-42f7-b2cb-03fc4443edfe;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "CCM_DDS.sbs";
						- _subsystem = "CCM_DDS";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 860b4414-0210-49d0-9585-d78e4a55fee0;
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
						- size = 2;
						- value = 
						{ CGICompartment 
							- _id = GUID 4d585070-d335-459c-a603-1da5c405b32a;
							- m_name = "Attribute";
							- m_displayOption = Explicit;
							- m_bShowInherited = 0;
							- m_bOrdered = 0;
							- Items = { IRPYRawContainer 
								- size = 0;
							}
						}
						{ CGICompartment 
							- _id = GUID 168508bf-2a43-4535-947c-ed82ae725ed5;
							- m_name = "Operation";
							- m_displayOption = Explicit;
							- m_bShowInherited = 0;
							- m_bOrdered = 0;
							- Items = { IRPYRawContainer 
								- size = 0;
							}
						}
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
				- m_pRoot = GUID 9f009e4a-3ce1-42f7-b2cb-03fc4443edfe;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "CCM_DDS.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "CCM_DDS";
				- _id = GUID 073f877f-cf70-473c-bfbc-df3202c99fb4;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID 25115994-be1a-4708-9d49-39f5b0a5fcb7;
		}
	}
}

