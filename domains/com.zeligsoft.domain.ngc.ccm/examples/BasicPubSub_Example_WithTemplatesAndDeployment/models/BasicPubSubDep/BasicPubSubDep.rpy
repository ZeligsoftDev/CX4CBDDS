I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID 2972b81b-fdc4-45e1-b41d-69309539348e;
	- _myState = 8192;
	- _properties = { IPropertyContainer 
		- Subjects = { IRPYRawContainer 
			- size = 1;
			- value = 
			{ IPropertySubject 
				- _Name = "Browser";
				- Metaclasses = { IRPYRawContainer 
					- size = 1;
					- value = 
					{ IPropertyMetaclass 
						- _Name = "Settings";
						- Properties = { IRPYRawContainer 
							- size = 1;
							- value = 
							{ IProperty 
								- _Name = "DisplayMode";
								- _Value = "Meta-class";
								- _Type = Enum;
								- _ExtraTypeInfo = "Flat,Meta-class";
							}
						}
					}
				}
			}
		}
	}
	- _name = "BasicPubSubDep";
	- _modifiedTimeWeak = 7.15.2014::17:16:18;
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
		- _id = GUID 657adefe-b334-4124-90fc-25bf1d779342;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID 1a4be6c5-7ab9-42f9-b84e-0c6c127bb378;
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
			- _id = GUID 657adefe-b334-4124-90fc-25bf1d779342;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "C:\\Users\\Paul Elder\\IBM\\rationalsdp\\runtime-workbench\\BasicPubSub_Example_WithTemplatesAndDeployment\\profiles\\DDS4CCM\\DDS4CCM_rpy";
			- _id = GUID a6a6e7f8-334e-4c1c-bfbb-9a7608dd05c5;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "IDLPrimitives";
			- _persistAs = "C:\\Users\\Paul Elder\\IBM\\rationalsdp\\runtime-workbench\\BasicPubSub_Example_WithTemplatesAndDeployment\\models\\IDLPrimitives\\IDLPrimitives_rpy";
			- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "CCM_DDS";
			- _persistAs = "C:\\Users\\Paul Elder\\IBM\\rationalsdp\\runtime-workbench\\BasicPubSub_Example_WithTemplatesAndDeployment\\models\\DDS_DCPS\\DDS_DCPS_rpy";
			- _id = GUID 073f877f-cf70-473c-bfbc-df3202c99fb4;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "PEExample";
			- _id = GUID c6b3bd15-4c24-4bfd-a062-c3729ebbb784;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID 1baea16b-a905-43ec-b507-05c17393f74c;
			- _myState = 8192;
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "5.22.2014::15:8:0";
			- _graphicChart = { CGIClassChart 
				- _id = GUID b4ff67a0-b2bc-443e-b54f-03eb75e39530;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID 1baea16b-a905-43ec-b507-05c17393f74c;
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
					- _id = GUID b54cd1fd-cb07-4c2a-82e4-259659bf442d;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "Default.sbs";
						- _subsystem = "Default";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 68f100de-ba35-45bb-91b7-8b9109fefa56;
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
							- _id = GUID 8b05ea9e-8832-461b-8476-a1d8db78400d;
							- m_name = "Attribute";
							- m_displayOption = Explicit;
							- m_bShowInherited = 0;
							- m_bOrdered = 0;
							- Items = { IRPYRawContainer 
								- size = 0;
							}
						}
						{ CGICompartment 
							- _id = GUID 0e94beff-51ed-4f9d-a097-708ccab87d8c;
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
				- m_pRoot = GUID b54cd1fd-cb07-4c2a-82e4-259659bf442d;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "Default.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "Default";
				- _id = GUID 657adefe-b334-4124-90fc-25bf1d779342;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID 1a4be6c5-7ab9-42f9-b84e-0c6c127bb378;
		}
	}
}

