I-Logix-RPY-Archive version 8.9.0 C++ 7155907
{ IProject 
	- _id = GUID cd381587-6a34-41f7-af8c-6a0eefc28f36;
	- _myState = 8192;
	- _properties = { IPropertyContainer 
		- Subjects = { IRPYRawContainer 
			- size = 2;
			- value = 
			{ IPropertySubject 
				- _Name = "Format";
				- Metaclasses = { IRPYRawContainer 
					- size = 1;
					- value = 
					{ IPropertyMetaclass 
						- _Name = "CCMPart";
						- Properties = { IRPYRawContainer 
							- size = 14;
							- value = 
							{ IProperty 
								- _Name = "DefaultSize";
								- _Value = "0,34,84,148";
								- _Type = String;
							}
							{ IProperty 
								- _Name = "Fill.FillColor";
								- _Value = "255,255,255";
								- _Type = Color;
							}
							{ IProperty 
								- _Name = "Font.Font";
								- _Value = "Tahoma";
								- _Type = String;
							}
							{ IProperty 
								- _Name = "Font.Font@Child.Template Params";
								- _Value = "Tahoma";
								- _Type = String;
							}
							{ IProperty 
								- _Name = "Font.Italic@Child.Template Params";
								- _Value = "0";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Size";
								- _Value = "8";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Size@Child.NameCompartment@Multiplicity";
								- _Value = "7";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Size@Child.NameCompartment@Stereotype";
								- _Value = "7";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Size@Child.Template Params";
								- _Value = "8";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Weight@Child.NameCompartment@Name";
								- _Value = "700";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Font.Weight@Child.Template Params";
								- _Value = "400";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Line.LineColor";
								- _Value = "109,163,217";
								- _Type = Color;
							}
							{ IProperty 
								- _Name = "Line.LineStyle";
								- _Value = "0";
								- _Type = Int;
							}
							{ IProperty 
								- _Name = "Line.LineWidth";
								- _Value = "1";
								- _Type = Int;
							}
						}
					}
				}
			}
			{ IPropertySubject 
				- _Name = "ObjectModelGe";
				- Metaclasses = { IRPYRawContainer 
					- size = 1;
					- value = 
					{ IPropertyMetaclass 
						- _Name = "CCMPart";
						- Properties = { IRPYRawContainer 
							- size = 9;
							- value = 
							{ IProperty 
								- _Name = "Compartments";
								- _Value = "";
								- _Type = MultiLine;
							}
							{ IProperty 
								- _Name = "ShowAttributes";
								- _Value = "None";
								- _Type = Enum;
								- _ExtraTypeInfo = "All,None,Public,Explicit";
							}
							{ IProperty 
								- _Name = "ShowInheritedAttributes";
								- _Value = "False";
								- _Type = Bool;
							}
							{ IProperty 
								- _Name = "ShowInheritedOperations";
								- _Value = "False";
								- _Type = Bool;
							}
							{ IProperty 
								- _Name = "ShowName";
								- _Value = "Relative";
								- _Type = Enum;
								- _ExtraTypeInfo = "Full_path,Relative,Name_only,Type,Label";
							}
							{ IProperty 
								- _Name = "ShowOperations";
								- _Value = "None";
								- _Type = Enum;
								- _ExtraTypeInfo = "All,None,Public,Explicit";
							}
							{ IProperty 
								- _Name = "ShowPorts";
								- _Value = "True";
								- _Type = Bool;
							}
							{ IProperty 
								- _Name = "ShowPortsInterfaces";
								- _Value = "False";
								- _Type = Bool;
							}
							{ IProperty 
								- _Name = "ShowStereotype";
								- _Value = "Label";
								- _Type = Enum;
								- _ExtraTypeInfo = "Label,Bitmap,None";
							}
						}
					}
				}
			}
		}
	}
	- _name = "ArtGallery";
	- Stereotypes = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IHandle 
			- _m2Class = "IStereotype";
			- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\CX4CBDDS.sbs";
			- _subsystem = "CX4CBDDS";
			- _class = "";
			- _name = "CX4CBDDS";
			- _id = GUID fe257762-9188-4c17-9a97-9225244b6a2f;
		}
	}
	- _modifiedTimeWeak = 10.29.2014::19:21:58;
	- _lastID = 3;
	- _UserColors = { IRPYRawContainer 
		- size = 16;
		- value = 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 16777215; 
	}
	- _defaultSubsystem = { ISubsystemHandle 
		- _m2Class = "ISubsystem";
		- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\IDLPrimitives.sbs";
		- _subsystem = "";
		- _class = "";
		- _name = "IDLPrimitives";
		- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
	}
	- _component = { IHandle 
		- _m2Class = "IComponent";
		- _filename = "DefaultComponent.cmp";
		- _subsystem = "";
		- _class = "";
		- _name = "DefaultComponent";
		- _id = GUID e6fb1abd-4388-498a-9a91-b465bae93bcc;
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
		- size = 7;
		- value = 
		{ IProfile 
			- fileName = "CX4CBDDS";
			- _persistAs = "$OMROOT\\Profiles\\CX4CBDDS";
			- _id = GUID 2173cb78-d7b9-4000-8aeb-c411d58d1f48;
			- _isReference = 1;
		}
		{ IProfile 
			- fileName = "cxDDS4CCM";
			- _persistAs = "$OMROOT\\Profiles\\CX4CBDDS";
			- _id = GUID 758154e3-4a6b-4690-9e6d-d67cd7505774;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "IDLPrimitives";
			- _persistAs = "$OMROOT\\Profiles\\CX4CBDDS";
			- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "DDS_DCPS";
			- _persistAs = "$OMROOT\\Profiles\\CX4CBDDS";
			- _id = GUID 2fab8e32-403f-4402-83ca-91952c6cafd0;
			- _isReference = 1;
		}
		{ ISubsystem 
			- fileName = "ArtGallery";
			- _id = GUID e4a4c7db-d9a3-4ced-8a22-ea74ba1470e0;
		}
		{ ISubsystem 
			- fileName = "CCM_PSAT";
			- _persistAs = "$OMROOT\\Profiles\\CX4CBDDS";
			- _id = GUID 6e0ec8a2-577d-405e-9e37-84b4b1e132a0;
			- _isReference = 1;
		}
		{ ISubsystem 
			- _id = GUID 63439522-8ff8-4786-902b-41203497a714;
			- _myState = 8192;
			- _name = "ExtraStuff";
			- _modifiedTimeWeak = 10.29.2014::19:22:19;
			- _lastID = 1;
			- Declaratives = { IRPYRawContainer 
				- size = 1;
				- value = 
				{ ISubsystem 
					- _id = GUID b7c461ba-2b38-488a-9d78-61f200e73250;
					- _myState = 8192;
					- _name = "MessMeUp";
					- _modifiedTimeWeak = 10.29.2014::19:22:19;
					- Declaratives = { IRPYRawContainer 
						- size = 1;
						- value = 
						{ IComponentDiagram 
							- _id = GUID fc8864d0-01bf-4630-93ca-94fb8e320b0f;
							- _myState = 8192;
							- _name = "MessMeUp_diag";
							- _modifiedTimeWeak = 1.2.1990::0:0:0;
							- _lastModifiedTime = "10.29.2014::19:22:19";
							- _graphicChart = { CGIClassChart 
								- _id = GUID b6eb78cb-edfb-4413-9ba9-53e664b7fe96;
								- m_type = 0;
								- m_pModelObject = { IHandle 
									- _m2Class = "IComponentDiagram";
									- _id = GUID fc8864d0-01bf-4630-93ca-94fb8e320b0f;
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
								{ CGIBox 
									- _id = GUID b9205bdb-eb6b-4602-b182-08c785f4a6cc;
									- m_type = 146;
									- m_pModelObject = { IHandle 
										- _m2Class = "ISubsystem";
										- _id = GUID b7c461ba-2b38-488a-9d78-61f200e73250;
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
									- m_polygon = 0 ;
									- m_nNameFormat = 0;
									- m_nIsNameFormat = 0;
									- Compartments = { IRPYRawContainer 
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
								- m_pRoot = GUID b9205bdb-eb6b-4602-b182-08c785f4a6cc;
								- m_currentLeftTop = 0 0 ;
								- m_currentRightBottom = 0 0 ;
							}
							- _defaultSubsystem = { IHandle 
								- _m2Class = "ISubsystem";
								- _id = GUID b7c461ba-2b38-488a-9d78-61f200e73250;
							}
						}
					}
					- weakCGTime = 10.29.2014::19:22:19;
					- strongCGTime = 10.29.2014::19:22:19;
					- _defaultComposite = GUID 9af5f633-efa9-4100-854d-9aa4810765b2;
					- _eventsBaseID = -1;
					- Classes = { IRPYRawContainer 
						- size = 3;
						- value = 
						{ IClass 
							- _id = GUID 9af5f633-efa9-4100-854d-9aa4810765b2;
							- _myState = 40960;
							- _name = "TopLevel";
							- _modifiedTimeWeak = 1.2.1990::0:0:0;
							- weakCGTime = 1.2.1990::0:0:0;
							- strongCGTime = 1.2.1990::0:0:0;
							- _multiplicity = "";
							- _itsStateChart = { IHandle 
								- _m2Class = "";
							}
							- _classModifier = Unspecified;
						}
						{ IClass 
							- _id = GUID 5d281d21-103b-4345-ae61-7d66bb48d99f;
							- _myState = 8192;
							- _name = "MessMeUp";
							- Stereotypes = { IRPYRawContainer 
								- size = 1;
								- value = 
								{ IHandle 
									- _m2Class = "IStereotype";
									- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\cxDDS4CCM.sbs";
									- _subsystem = "cxDDS4CCM";
									- _class = "";
									- _name = "CCMComponent";
									- _id = GUID e9dcdd36-6cc0-4301-b7cc-b1866b9229fb;
								}
							}
							- _modifiedTimeWeak = 10.29.2014::19:22:19;
							- weakCGTime = 10.29.2014::19:22:19;
							- strongCGTime = 10.29.2014::19:22:19;
							- _multiplicity = "";
							- _itsStateChart = { IHandle 
								- _m2Class = "";
							}
							- _classModifier = Unspecified;
						}
						{ IClass 
							- _id = GUID 66dd31a0-7ba4-48ed-a6e8-d837473342c6;
							- _myState = 8192;
							- _name = "MessMeUp_asm";
							- Stereotypes = { IRPYRawContainer 
								- size = 1;
								- value = 
								{ IHandle 
									- _m2Class = "IStereotype";
									- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\cxDDS4CCM.sbs";
									- _subsystem = "cxDDS4CCM";
									- _class = "";
									- _name = "AssemblyImplementation";
									- _id = GUID 5ab34e14-ab6e-49f9-b2f9-bac142e3ecd3;
								}
							}
							- _modifiedTimeWeak = 10.29.2014::19:22:19;
							- Declaratives = { IRPYRawContainer 
								- size = 1;
								- value = 
								{ IStructureDiagram 
									- _id = GUID b5ce21cc-d6d9-42d0-a791-b5375a061bd1;
									- _myState = 8192;
									- _properties = { IPropertyContainer 
										- Subjects = { IRPYRawContainer 
											- size = 1;
											- value = 
											{ IPropertySubject 
												- _Name = "Format";
												- Metaclasses = { IRPYRawContainer 
													- size = 1;
													- value = 
													{ IPropertyMetaclass 
														- _Name = "Class";
														- Properties = { IRPYRawContainer 
															- size = 8;
															- value = 
															{ IProperty 
																- _Name = "DefaultSize";
																- _Value = "0,34,84,148";
																- _Type = String;
															}
															{ IProperty 
																- _Name = "Fill.FillColor";
																- _Value = "255,255,255";
																- _Type = Color;
															}
															{ IProperty 
																- _Name = "Font.Font";
																- _Value = "Tahoma";
																- _Type = String;
															}
															{ IProperty 
																- _Name = "Font.Size";
																- _Value = "8";
																- _Type = Int;
															}
															{ IProperty 
																- _Name = "Font.Weight@Child.NameCompartment@Name";
																- _Value = "700";
																- _Type = Int;
															}
															{ IProperty 
																- _Name = "Line.LineColor";
																- _Value = "109,163,217";
																- _Type = Color;
															}
															{ IProperty 
																- _Name = "Line.LineStyle";
																- _Value = "0";
																- _Type = Int;
															}
															{ IProperty 
																- _Name = "Line.LineWidth";
																- _Value = "1";
																- _Type = Int;
															}
														}
													}
												}
											}
										}
									}
									- _name = "MessMeUp_diag";
									- _modifiedTimeWeak = 1.2.1990::0:0:0;
									- _lastModifiedTime = "10.29.2014::19:22:19";
									- _graphicChart = { CGIClassChart 
										- _id = GUID 89eb80f1-2531-40aa-a842-b71b695bf7cd;
										- m_type = 0;
										- m_pModelObject = { IHandle 
											- _m2Class = "IStructureDiagram";
											- _id = GUID b5ce21cc-d6d9-42d0-a791-b5375a061bd1;
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
										- elementList = 2;
										{ CGIClass 
											- _id = GUID 97f47b64-14e6-4076-86a8-a0b8e8901d6d;
											- m_type = 78;
											- m_pModelObject = { IHandle 
												- _m2Class = "IClass";
												- _id = GUID 9af5f633-efa9-4100-854d-9aa4810765b2;
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
													- _id = GUID 38578e4b-4520-4a6a-b86c-69315d6a8ceb;
													- m_name = "Attribute";
													- m_displayOption = Explicit;
													- m_bShowInherited = 0;
													- m_bOrdered = 0;
													- Items = { IRPYRawContainer 
														- size = 0;
													}
												}
												{ CGICompartment 
													- _id = GUID dc208b25-34e5-442c-afae-4af91fdd604c;
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
										{ CGIClass 
											- _id = GUID 33d11e13-43d3-4049-a5bc-a5be7f55343e;
											- m_type = 105;
											- m_pModelObject = { IHandle 
												- _m2Class = "IClass";
												- _id = GUID 66dd31a0-7ba4-48ed-a6e8-d837473342c6;
											}
											- m_pParent = GUID 97f47b64-14e6-4076-86a8-a0b8e8901d6d;
											- m_name = { CGIText 
												- m_str = "MessMeUp_asm";
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
											- m_drawBehavior = 2056;
											- m_transform = 0.419463 0 0 0.393013 48.7416 -54.1485 ;
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
											- m_polygon = 4 3 265  3 1410  1195 1410  1195 265  ;
											- m_nNameFormat = 0;
											- m_nIsNameFormat = 0;
											- Compartments = { IRPYRawContainer 
												- size = 2;
												- value = 
												{ CGICompartment 
													- _id = GUID 15c03645-ba89-42af-8ff2-0151fbe5b359;
													- m_name = "Attribute";
													- m_displayOption = Explicit;
													- m_bShowInherited = 0;
													- m_bOrdered = 0;
													- Items = { IRPYRawContainer 
														- size = 0;
													}
												}
												{ CGICompartment 
													- _id = GUID 20709af0-459b-4127-8206-2fc1862ec7fd;
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
										- m_pRoot = GUID 97f47b64-14e6-4076-86a8-a0b8e8901d6d;
										- m_currentLeftTop = 0 0 ;
										- m_currentRightBottom = 0 0 ;
									}
									- _defaultSubsystem = { IHandle 
										- _m2Class = "ISubsystem";
										- _id = GUID b7c461ba-2b38-488a-9d78-61f200e73250;
									}
								}
							}
							- weakCGTime = 10.29.2014::19:22:19;
							- strongCGTime = 10.29.2014::19:22:19;
							- Inheritances = { IRPYRawContainer 
								- size = 1;
								- value = 
								{ IGeneralization 
									- _id = GUID 28c13226-c74b-4cea-99a7-7a31e1c02d3e;
									- _modifiedTimeWeak = 1.2.1990::0:0:0;
									- _dependsOn = { INObjectHandle 
										- _m2Class = "IClass";
										- _id = GUID 5d281d21-103b-4345-ae61-7d66bb48d99f;
									}
									- _inheritanceType = iPublic;
									- _isVirtual = 0;
								}
							}
							- _multiplicity = "";
							- _itsStateChart = { IHandle 
								- _m2Class = "";
							}
							- _classModifier = Unspecified;
						}
					}
					- _configurationRelatedTime = 1.2.1990::0:0:0;
				}
			}
			- weakCGTime = 10.29.2014::19:22:19;
			- strongCGTime = 10.29.2014::19:22:2;
			- _defaultComposite = GUID 582a9ca3-0527-4e60-8f71-71a19a23647a;
			- _eventsBaseID = -1;
			- Classes = { IRPYRawContainer 
				- size = 1;
				- value = 
				{ IClass 
					- _id = GUID 582a9ca3-0527-4e60-8f71-71a19a23647a;
					- _myState = 40960;
					- _name = "TopLevel";
					- _modifiedTimeWeak = 1.2.1990::0:0:0;
					- weakCGTime = 1.2.1990::0:0:0;
					- strongCGTime = 1.2.1990::0:0:0;
					- _multiplicity = "";
					- _itsStateChart = { IHandle 
						- _m2Class = "";
					}
					- _classModifier = Unspecified;
				}
			}
			- _configurationRelatedTime = 10.29.2014::19:22:19;
		}
	}
	- Diagrams = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IDiagram 
			- _id = GUID 4762e784-b5a8-413e-bd82-f4a053fb8b3a;
			- _myState = 8192;
			- _properties = { IPropertyContainer 
				- Subjects = { IRPYRawContainer 
					- size = 1;
					- value = 
					{ IPropertySubject 
						- _Name = "Format";
						- Metaclasses = { IRPYRawContainer 
							- size = 1;
							- value = 
							{ IPropertyMetaclass 
								- _Name = "CCMPart";
								- Properties = { IRPYRawContainer 
									- size = 14;
									- value = 
									{ IProperty 
										- _Name = "DefaultSize";
										- _Value = "0,34,84,148";
										- _Type = String;
									}
									{ IProperty 
										- _Name = "Fill.FillColor";
										- _Value = "255,255,255";
										- _Type = Color;
									}
									{ IProperty 
										- _Name = "Font.Font";
										- _Value = "Tahoma";
										- _Type = String;
									}
									{ IProperty 
										- _Name = "Font.Font@Child.Template Params";
										- _Value = "Tahoma";
										- _Type = String;
									}
									{ IProperty 
										- _Name = "Font.Italic@Child.Template Params";
										- _Value = "0";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Size";
										- _Value = "8";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Size@Child.NameCompartment@Multiplicity";
										- _Value = "7";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Size@Child.NameCompartment@Stereotype";
										- _Value = "7";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Size@Child.Template Params";
										- _Value = "8";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Weight@Child.NameCompartment@Name";
										- _Value = "700";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Font.Weight@Child.Template Params";
										- _Value = "400";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Line.LineColor";
										- _Value = "109,163,217";
										- _Type = Color;
									}
									{ IProperty 
										- _Name = "Line.LineStyle";
										- _Value = "0";
										- _Type = Int;
									}
									{ IProperty 
										- _Name = "Line.LineWidth";
										- _Value = "1";
										- _Type = Int;
									}
								}
							}
						}
					}
				}
			}
			- _name = "Model1";
			- _modifiedTimeWeak = 1.2.1990::0:0:0;
			- _lastModifiedTime = "9.17.2014::19:17:14";
			- _graphicChart = { CGIClassChart 
				- _id = GUID 53fbe2a8-cf02-48f7-96ab-0337131b4f92;
				- m_type = 0;
				- m_pModelObject = { IHandle 
					- _m2Class = "IDiagram";
					- _id = GUID 4762e784-b5a8-413e-bd82-f4a053fb8b3a;
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
					- _id = GUID 83e51f30-6c63-49b1-9657-215be8964f7c;
					- m_type = 78;
					- m_pModelObject = { IHandle 
						- _m2Class = "IClass";
						- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\IDLPrimitives.sbs";
						- _subsystem = "IDLPrimitives";
						- _class = "";
						- _name = "TopLevel";
						- _id = GUID 2e78c6e8-3970-4ca3-a1ba-a6f139b9a914;
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
							- _id = GUID 84b1f36d-4e7d-4f9a-b417-7b9e2f033617;
							- m_name = "Attribute";
							- m_displayOption = Explicit;
							- m_bShowInherited = 0;
							- m_bOrdered = 0;
							- Items = { IRPYRawContainer 
								- size = 0;
							}
						}
						{ CGICompartment 
							- _id = GUID 187e7091-2ee4-4985-9f3c-d03583721e7b;
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
				- m_pRoot = GUID 83e51f30-6c63-49b1-9657-215be8964f7c;
				- m_currentLeftTop = 0 0 ;
				- m_currentRightBottom = 0 0 ;
			}
			- _defaultSubsystem = { IHandle 
				- _m2Class = "ISubsystem";
				- _filename = "$OMROOT\\Profiles\\CX4CBDDS\\IDLPrimitives.sbs";
				- _subsystem = "";
				- _class = "";
				- _name = "IDLPrimitives";
				- _id = GUID 32e5b23a-3e69-45e3-a578-4bece4e48f68;
			}
		}
	}
	- Components = { IRPYRawContainer 
		- size = 1;
		- value = 
		{ IComponent 
			- fileName = "DefaultComponent";
			- _id = GUID e6fb1abd-4388-498a-9a91-b465bae93bcc;
		}
	}
}

