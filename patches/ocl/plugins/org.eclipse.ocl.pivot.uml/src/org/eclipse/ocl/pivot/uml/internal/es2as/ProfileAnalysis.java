/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink (CEA List) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.es2as;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StereotypeExtender;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

/**
 * The ProfileAnalysis captures the overall analysis of the UML M2 Profiles and Stereotypes.
 */
public class ProfileAnalysis
{
	protected final UML2AS.@NonNull Outer converter;
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;

	/**
	 * All metatypes that are extended by a TypeExtension.
	 */
	private final @NonNull Set<Type> allExtendedMetatypes = new HashSet<Type>();

	/**
	 * All metatypes that are extended by a TypeExtension.
	 */
	private final @NonNull Set<org.eclipse.ocl.pivot.Package> allExtendedMetapackages = new HashSet<org.eclipse.ocl.pivot.Package>();

	/**
	 * All stereotypes that extend a metatype via a TypeExtension.
	 */
	private final @NonNull Set<Stereotype> allExtendingStereotypes = new HashSet<Stereotype>();

	/**
	 * All stereotypes.
	 */
	private final @NonNull Set<Stereotype> allStereotypes = new HashSet<Stereotype>();

	/**
	 * All profiles.
	 */
//	private final @NonNull Set<Profile> allProfiles = new HashSet<Profile>();

	private final @NonNull Map<Profile, Set<Stereotype>> profile2ownedStereotypes = new HashMap<Profile, Set<Stereotype>>();
	private final @NonNull Map<String, Type> metatypeName2metatype = new HashMap<String, Type>();
	private final @NonNull Map<Type, Set<Type>> metatype2superMetatypeClosure = new HashMap<Type, Set<Type>>();
	private final @NonNull Map<Type, Set<Type>> metatype2subMetatypeClosure = new HashMap<Type, Set<Type>>();
	private final @NonNull Map<Stereotype, Set<Stereotype>> stereotype2superStereotypeClosure = new HashMap<Stereotype, Set<Stereotype>>();
	private final @NonNull Map<Stereotype, Set<Stereotype>> stereotype2subStereotypeClosure = new HashMap<Stereotype, Set<Stereotype>>();
//	private final @NonNull Map<Type, Set<Stereotype>> metatype2stereotypeClosure = new HashMap<Type, Set<Stereotype>>();
//	private final @NonNull Map<Type, Set<Stereotype>> metatype2stereotypeClosureClosure = new HashMap<Type, Set<Stereotype>>();

	public ProfileAnalysis(UML2AS.@NonNull Outer converter) {
		this.converter = converter;
		this.environmentFactory = converter.getEnvironmentFactory();
	}
	
	public void addStereotype(@NonNull Stereotype asStereotype) {
		allStereotypes.add(asStereotype);
		org.eclipse.ocl.pivot.Package asPackage = asStereotype.getOwningPackage();
		if (asPackage instanceof Profile) {
			Profile asProfile = (Profile) asPackage;
			Set<Stereotype> ownedStereotypes = profile2ownedStereotypes.get(asProfile);
			if (ownedStereotypes == null) {
				ownedStereotypes = new HashSet<Stereotype>();
				profile2ownedStereotypes.put(asProfile, ownedStereotypes);
			}
			ownedStereotypes.add(asStereotype);
		}
	}
	
	public void addTypeExtension(@NonNull StereotypeExtender asTypeExtension) {
		org.eclipse.ocl.pivot.Class extendedMetatype = asTypeExtension.getClass_();
		Stereotype extendingStereotype = asTypeExtension.getOwningStereotype();
		if ((extendedMetatype != null) && (extendingStereotype != null)) {
			allExtendedMetatypes.add(extendedMetatype);
			allExtendingStereotypes.add(extendingStereotype);
			org.eclipse.ocl.pivot.Package metaPackage = extendedMetatype.getOwningPackage();
			if (metaPackage != null) {
				allExtendedMetapackages.add(metaPackage);
			}
		}
	}

/*		@Override
		public void addTypeExtension(@NonNull TypeExtension asTypeExtension) {
			List<TypeExtension> asTypeExtensions2 = asTypeExtensions;
			if (asTypeExtensions2 == null) {
				asTypeExtensions = asTypeExtensions2 = new ArrayList<TypeExtension>();
			}
			asTypeExtensions2.add(asTypeExtension);
/ *			org.eclipse.uml2.uml.Association umlExtension = umlExtensionEnd.getAssociation();
			if (umlExtension instanceof org.eclipse.uml2.uml.Extension) {
				org.eclipse.uml2.uml.Package umlProfile = umlExtension.getPackage();
				if (umlProfile instanceof org.eclipse.uml2.uml.Profile) {
					Map<org.eclipse.uml2.uml.Profile, List<org.eclipse.uml2.uml.ExtensionEnd>> profile2requiredExtensionEnds2 = profile2requiredExtensionEnds;
					if (profile2requiredExtensionEnds2 == null) {
						profile2requiredExtensionEnds = profile2requiredExtensionEnds2 = new HashMap<org.eclipse.uml2.uml.Profile, List<org.eclipse.uml2.uml.ExtensionEnd>>();
					}
					List<org.eclipse.uml2.uml.ExtensionEnd> umlRequiredExtensionEnds = profile2requiredExtensionEnds2.get(umlProfile);
					if (umlRequiredExtensionEnds == null) {
						umlRequiredExtensionEnds = new ArrayList<org.eclipse.uml2.uml.ExtensionEnd>();
						profile2requiredExtensionEnds2.put((org.eclipse.uml2.uml.Profile) umlProfile, umlRequiredExtensionEnds);
					}
					umlRequiredExtensionEnds.add(umlExtensionEnd);
				}
			} * /
		} */

	public void analyze() {
		computeMetatypeName2metatype();
		computeMetatypeClosure();
		computeStereotypeClosure();
//		computeMetatype2StereotypeClosure();
//		computeMetatype2StereotypeClosureClosure();
/*		if (UML2AS.APPLICABLE_STEREOTYPES.isActive()) {
			StringBuffer s = new StringBuffer();
			List<Type> asMetatypes = new ArrayList<Type>(metatype2stereotypeClosureClosure.keySet());
			Collections.sort(asMetatypes, PivotUtil.NAMEABLE_COMPARATOR);
			for (@SuppressWarnings("null")@NonNull Type asMetatype : asMetatypes) {
				s.append("\n\t" + EcoreUtils.qualifiedNameFor(asMetatype));
//					s.append(" " + ClassUtil.debugSimpleName(asMetatype));
				org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(asMetatype);
				if (asPackage != null) {
					s.append(" - " + asPackage.getNsURI());
				}
				s.append("\n\t\t");
				List<Stereotype> stereotypes = new ArrayList<Stereotype>(metatype2stereotypeClosureClosure.get(asMetatype));
				Collections.sort(stereotypes, PivotUtil.NAMEABLE_COMPARATOR);
				for (Stereotype asStereotype : stereotypes) {
					s.append(asStereotype + ", ");
//						s.append(" " + ClassUtil.debugSimpleName(asStereotype));
				}
			}
			UML2AS.APPLICABLE_STEREOTYPES.println("Stereotypes per Metatype" + s.toString());
		} */
/*				for (Type asMetatype1 : metatypeClosure.keySet()) {
					for (Type asMetatype2 : metatypeClosure.get(asMetatype1)) {
						for (TypeExtension asTypeExtension : asMetatype2.getExtendedBys()) {
							Stereotype asStereotype1 = asTypeExtension.getStereotype();
							for (Stereotype asStereotype2 : stereotypeClosure.get(asStereotype1)) {
								
							}
						}
					}
				} */
	}

	/**
	 * Compute the stereotypes that may be applied to each metatype within package.
	 *
	private @NonNull Map<org.eclipse.ocl.pivot.Package, Map<Type, Set<Stereotype>>> computeApplicableStereotypes(@NonNull List<ProfileApplication> asProfileApplications, @NonNull Map<Profile, Set<Profile>> appliedProfile2allProfiles) {
		//
		//	Create the closure of all profiles to each package for which any profile is applied
		//
		Map<org.eclipse.ocl.pivot.Package, Map<Type, Set<Stereotype>>> package2metatype2applicableStereotypes = new HashMap<org.eclipse.ocl.pivot.Package, Map<Type, Set<Stereotype>>>();
		for (ProfileApplication asProfileApplication : asProfileApplications) {
			org.eclipse.ocl.pivot.Package asPackage = asProfileApplication.getApplyingPackage();
			if (asPackage != null) {
				Profile asProfile = asProfileApplication.getAppliedProfile();
				if (asProfile != null) {
					Set<Profile> asProfileProfiles = appliedProfile2allProfiles.get(asProfile);
					if (asProfileProfiles != null) {
						Map<Type, Set<Stereotype>> metatype2applicableStereotypes = package2metatype2applicableStereotypes.get(asPackage);
						if (metatype2applicableStereotypes == null) {
							metatype2applicableStereotypes = new HashMap<Type, Set<Stereotype>>();
							package2metatype2applicableStereotypes.put(asPackage, metatype2applicableStereotypes);
						}
						for (Profile asProfile2 : asProfileProfiles) {
							for (Type type : asProfile2.getOwnedType()) {
								if (type instanceof Stereotype) {
									Set<Stereotype> applicableStereotypeClosure = stereotype2superStereotypeClosure.get(type);
									if (applicableStereotypeClosure != null) {
										for (Stereotype applicableStereotype : applicableStereotypeClosure) {
											if (applicableStereotype != null) {
												for (TypeExtension typeExtension : applicableStereotype.getExtensionOfs()) {
													if (typeExtension != null) {
														Type metatype = typeExtension.getType();
														if (metatype != null) {
															Set<Stereotype> applicableStereotypes = metatype2applicableStereotypes.get(metatype);
															if (applicableStereotypes == null) {
																applicableStereotypes = new HashSet<Stereotype>();
																metatype2applicableStereotypes.put(metatype, applicableStereotypes);
															}
															applicableStereotypes.add(applicableStereotype);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (UML2AS.ADD_PROFILE_APPLICATION.isActive()) {
			StringBuffer s = new StringBuffer();
			for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package asPackage : package2metatype2applicableStereotypes.keySet()) {
				s.append("\n\t" + EcoreUtils.qualifiedNameFor(asPackage) + " : " + asPackage.getNsURI());
				Map<Type, Set<Stereotype>> metatype2applicableStereotypes = package2metatype2applicableStereotypes.get(asPackage);
				for (Type metatype : metatype2applicableStereotypes.keySet()) {
					if (metatype != null) {
						s.append("\n\t\t" + EcoreUtils.qualifiedNameFor(metatype)); //+ " : " + asProfile.getNsURI());
						Set<Stereotype> asPackageStereotypes = metatype2applicableStereotypes.get(metatype);
						for (Stereotype asStereotype : asPackageStereotypes) {
							if (asStereotype != null) {
								s.append("\n\t\t\t" + EcoreUtils.qualifiedNameFor(asStereotype)); //+ " : " + asProfile.getNsURI());
							}
						}
					}
				}
			}
			UML2AS.ADD_PROFILE_APPLICATION.println("Applicable Stereotypes per Metatype per Package" + s.toString());
		}
		return package2metatype2applicableStereotypes;
	} */

	/**
	 * Compute the closure of all profiles applied to packages that have a profile application.
	 *
	protected static @NonNull Map<org.eclipse.ocl.pivot.Package, Set<Profile>> computeAppliedProfiles(@NonNull List<ProfileApplication> asProfileApplications) {
		//
		//	Determine all the profiles that are actually applied somewhere.
		//
		Set<Profile> appliedProfiles = new HashSet<Profile>();
		for (ProfileApplication asProfileApplication : asProfileApplications) {
			Profile asProfile = asProfileApplication.getAppliedProfile();
			if (asProfile != null) {
				appliedProfiles.add(asProfile);
			}
		}
		//
		//	Determine the closure of all profiles for each actually applied profile.
		//
		Map<Profile, Set<Profile>> appliedProfile2allProfiles = new HashMap<Profile, Set<Profile>>();
		for (@SuppressWarnings("null")@NonNull Profile asProfile : appliedProfiles) {
			Set<Profile> asProfiles = new HashSet<Profile>();
			computeProfileClosure(asProfiles, asProfile);
			appliedProfile2allProfiles.put(asProfile, asProfiles);
		}
		//
		//	Create the closure of all profiles to each package for which any profile is applied
		//
		Map<org.eclipse.ocl.pivot.Package, Set<Profile>> package2allAppliedProfiles = new HashMap<org.eclipse.ocl.pivot.Package, Set<Profile>>();
		for (ProfileApplication asProfileApplication : asProfileApplications) {
			org.eclipse.ocl.pivot.Package asPackage = asProfileApplication.getApplyingPackage();
			if (asPackage != null) {
				Profile asProfile = asProfileApplication.getAppliedProfile();
				if (asProfile != null) {
					Set<Profile> asProfileProfiles = appliedProfile2allProfiles.get(asProfile);
					if (asProfileProfiles != null) {
						Set<Profile> asPackageProfiles = package2allAppliedProfiles.get(asPackage);
						if (asPackageProfiles == null) {
							asPackageProfiles = new HashSet<Profile>();
							package2allAppliedProfiles.put(asPackage, asPackageProfiles);
						}
						asPackageProfiles.addAll(asProfileProfiles);
					}
				}
			}
		}
		if (ADD_PROFILE_APPLICATION.isActive()) {
			StringBuffer s = new StringBuffer();
			for (@SuppressWarnings("null")org.eclipse.ocl.pivot.@NonNull Package asPackage : package2allAppliedProfiles.keySet()) {
				s.append("\n\t" + EcoreUtils.qualifiedNameFor(asPackage) + " : " + asPackage.getNsURI());
				Set<Profile> asPackageProfiles = package2allAppliedProfiles.get(asPackage);
				for (Profile asProfile : asPackageProfiles) {
					if (asProfile != null) {
						s.append("\n\t\t" + EcoreUtils.qualifiedNameFor(asProfile) + " : " + asProfile.getNsURI());
					}
				}
			}
			ADD_PROFILE_APPLICATION.println("Profiles per Package" + s.toString());
		}
		return package2allAppliedProfiles;
	} */

/*	private void computeMetatype2StereotypeClosure() {
		for (Type asMetatype : allExtendedMetatypes) {
			if (asMetatype != null) {
				Set<Stereotype> asMetatypeClosure = new HashSet<Stereotype>();
				metatype2stereotypeClosure.put(asMetatype, asMetatypeClosure);
				for (TypeExtension asTypeExtension : asMetatype.getExtendedBys()) {
					Stereotype asStereotype = asTypeExtension.getStereotype();
					Set<Stereotype> superStereotypeClosure = stereotype2superStereotypeClosure.get(asStereotype);
					if (superStereotypeClosure != null) {
						asMetatypeClosure.addAll(superStereotypeClosure);
					}
					Set<Stereotype> subStereotypeClosure = stereotype2subStereotypeClosure.get(asStereotype);
					if (subStereotypeClosure != null) {
						asMetatypeClosure.addAll(subStereotypeClosure);
					}
				}
			}
		}
	} */

/*	private void computeMetatype2StereotypeClosureClosure() {
		for (Type asMetatype : metatype2stereotypeClosure.keySet()) {
			if (asMetatype != null) {
				Set<Stereotype> asMetatypeClosure = new HashSet<Stereotype>();
				metatype2stereotypeClosureClosure.put(asMetatype, asMetatypeClosure);
				for (DomainType asSuperMetatype : metamodelManager.getAllSuperClasses(asMetatype)) {
					if (asSuperMetatype instanceof TypeServer) {
						asSuperMetatype = ((TypeServer)asSuperMetatype).getPivotType();
					}
					if (asSuperMetatype instanceof Type) {
						Set<Stereotype> stereotypeClosure = metatype2stereotypeClosure.get(asSuperMetatype);
						if (stereotypeClosure != null) {
							asMetatypeClosure.addAll(stereotypeClosure);
						}
					}
				}
			}
		}
	} */

	private void computeMetatypeName2metatype() {
		for (org.eclipse.ocl.pivot.Package metapackage : allExtendedMetapackages) {
			for (org.eclipse.ocl.pivot.Class metatype : metapackage.getOwnedClasses()) {
				if (metatype != null) {
					metatypeName2metatype.put(metatype.getName(), metatype);
				}
			}
		}
	}

	private void computeMetatypeClosure() {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		for (org.eclipse.ocl.pivot.Package metapackage : allExtendedMetapackages) {
			for (org.eclipse.ocl.pivot.Class subMetatype : metapackage.getOwnedClasses()) {
				if (subMetatype != null) {
					Set<Type> superMetatypeClosure = new HashSet<Type>();
					metatype2superMetatypeClosure.put(subMetatype, superMetatypeClosure);
					for (CompleteClass superCompleteClass : metamodelManager.getAllSuperCompleteClasses(subMetatype)) {
						org.eclipse.ocl.pivot.Class asSuperMetatype = superCompleteClass.getPrimaryClass();
						superMetatypeClosure.add(asSuperMetatype);
						Set<Type> subMetatypeClosure = metatype2subMetatypeClosure.get(asSuperMetatype);
						if (subMetatypeClosure == null) {
							subMetatypeClosure = new HashSet<Type>();
							metatype2subMetatypeClosure.put(asSuperMetatype, subMetatypeClosure);
						}
						subMetatypeClosure.add(subMetatype);
					}
				}
			}
		}
	}

	private void computeStereotypeClosure() {
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		for (Stereotype subStereotype : allStereotypes) {
			if (subStereotype != null) {
				Set<Stereotype> superStereotypeClosure = new HashSet<Stereotype>();
				stereotype2superStereotypeClosure.put(subStereotype, superStereotypeClosure);
//				for (DomainClass asSuperStereotype : metamodelManager.getAllSuperClasses(subStereotype)) {
				for (CompleteClass superCompleteClass : metamodelManager.getAllSuperCompleteClasses(subStereotype)) {
					org.eclipse.ocl.pivot.Class asSuperStereotype = superCompleteClass.getPrimaryClass();
					if (asSuperStereotype instanceof Stereotype) {
						superStereotypeClosure.add((Stereotype)asSuperStereotype);
						Set<Stereotype> subStereotypeClosure = stereotype2subStereotypeClosure.get(asSuperStereotype);
						if (subStereotypeClosure == null) {
							subStereotypeClosure = new HashSet<Stereotype>();
							stereotype2subStereotypeClosure.put((Stereotype)asSuperStereotype, subStereotypeClosure);
						}
						subStereotypeClosure.add(subStereotype);
					}
				}
			}
		}
	}

	public @NonNull Map<Type, Set<StereotypeExtender>> computeMetatypes2typeExtensions() {
		Set<Stereotype> applicableStereotypes = allStereotypes; //getOwnedStereotypes(appliedProfileClosure);
		Map<Type, Set<StereotypeExtender>> extensibleMetatype2typeExtensions = getExtensibleMetatype2typeExtensions(applicableStereotypes);
/*		Map<Type, Set<TypeExtension>> metatype2typeExtensions = new HashMap<Type, Set<TypeExtension>>();
		for (Type metatype : extensibleMetatype2extendingStereotypes.keySet()) {
//			@SuppressWarnings("null")@NonNull Set<Stereotype> extendingStereotypes = extensibleMetatype2extendingStereotypes.get(metatype);
//			Set<Stereotype> extendingStereotypeClosure = getStereotypeSubSuperClosure(extendingStereotypes);
//			extensibleMetatypesClosure.put(metatype, extendingStereotypeClosure);
		}
//		Map<Type, Set<TypeExtension>> metatype2typeExtensions = new HashMap<Type, Set<TypeExtension>>();
		for (@SuppressWarnings("null")@NonNull Type metatype : extensibleMetatype2typeExtensions.keySet()) {
			Set<TypeExtension> someTypeExtensions = metatype2typeExtensions.get(metatype);
			if (someTypeExtensions != null) {
				Set<Type> metatypeSubClosure = getSubMetatypeClosure(metatype);
				if (metatypeSubClosure != null) {
					for (Type subMetatype : metatypeSubClosure) {
						Set<TypeExtension> allTypeExtensions = metatype2typeExtensions.get(subMetatype);
						if (allTypeExtensions == null) {
							allTypeExtensions = new HashSet<TypeExtension>();
							metatype2typeExtensions.put(subMetatype, allTypeExtensions);
						}
						allTypeExtensions.addAll(someTypeExtensions);
					}
				}
			}
		}
		return metatype2typeExtensions; */
		return extensibleMetatype2typeExtensions;
	}

	public @NonNull Map<Type, Set<StereotypeExtender>> computeMetatypes2typeExtensions(@NonNull Set<Profile> appliedProfileClosure) {
		Set<Stereotype> applicableStereotypes = getOwnedStereotypes(appliedProfileClosure);
		Map<Type, Set<StereotypeExtender>> extensibleMetatype2typeExtensions = getExtensibleMetatype2typeExtensions(applicableStereotypes);
//		Map<Type, Set<TypeExtension>> metatype2typeExtensions = new HashMap<Type, Set<TypeExtension>>();
//		for (Type metatype : extensibleMetatype2extendingStereotypes.keySet()) {
//			@SuppressWarnings("null")@NonNull Set<Stereotype> extendingStereotypes = extensibleMetatype2extendingStereotypes.get(metatype);
//			Set<Stereotype> extendingStereotypeClosure = getStereotypeSubSuperClosure(extendingStereotypes);
//			extensibleMetatypesClosure.put(metatype, extendingStereotypeClosure);
//		}
		Map<Type, Set<StereotypeExtender>> metatype2typeExtensions = new HashMap<Type, Set<StereotypeExtender>>();
		for (@SuppressWarnings("null")@NonNull Type metatype : extensibleMetatype2typeExtensions.keySet()) {
			Set<StereotypeExtender> someTypeExtensions = metatype2typeExtensions.get(metatype);
			if (someTypeExtensions != null) {
				Set<Type> metatypeSubClosure = getSubMetatypeClosure(metatype);
				if (metatypeSubClosure != null) {
					for (Type subMetatype : metatypeSubClosure) {
						Set<StereotypeExtender> allTypeExtensions = metatype2typeExtensions.get(subMetatype);
						if (allTypeExtensions == null) {
							allTypeExtensions = new HashSet<StereotypeExtender>();
							metatype2typeExtensions.put(subMetatype, allTypeExtensions);
						}
						allTypeExtensions.addAll(someTypeExtensions);
					}
				}
			}
		}
		return metatype2typeExtensions;
	}

/*	private @Nullable Set<Profile> computeProfileClosure(@NonNull ResourceSet asResourceSet) {
		Set<Profile> allProfiles = null;
		for (Resource asResource : asResourceSet.getResources()) {
			if (asResource != null) {
				for (EObject eRoot : asResource.getContents()) {
					if (eRoot instanceof Root) {
						for (org.eclipse.ocl.pivot.Package asNestedPackage : ((Root)eRoot).getNestedPackage()) {
							if (asNestedPackage instanceof Profile) {
								if (allProfiles == null) {
									allProfiles = new HashSet<Profile>();
								}
								computeProfileClosure(allProfiles, (Profile) asNestedPackage);
							}
						}
					}
				}
			}
		}
		return allProfiles;
	} */

/*	private @NonNull Map<Type, Set<Stereotype>> getExtensibleMetatype2extendingStereotypes(@NonNull Iterable<Stereotype> applicableStereotypes) {
		Map<Type, Set<Stereotype>> extensibleMetatype2extendingStereotypes = new HashMap<Type, Set<Stereotype>>();
		for (Stereotype applicableStereotype : applicableStereotypes) {
			for (TypeExtension typeExtension : applicableStereotype.getExtensionOfs()) {
				Type extensibleMetatype = typeExtension.getType();
				if (extensibleMetatype != null) {
					Set<Stereotype> extendingStereotypes = extensibleMetatype2extendingStereotypes.get(extensibleMetatype);
					if (extendingStereotypes == null) {
						extendingStereotypes = new HashSet<Stereotype>();
						extensibleMetatype2extendingStereotypes.put(extensibleMetatype, extendingStereotypes);
					}
					extendingStereotypes.add(applicableStereotype);
				}
			}
		}
		return extensibleMetatype2extendingStereotypes;
	} */

	private @NonNull Map<Type, Set<StereotypeExtender>> getExtensibleMetatype2typeExtensions(@NonNull Iterable<Stereotype> applicableStereotypes) {
		Map<Type, Set<StereotypeExtender>> extensibleMetatype2typeExtensions = new HashMap<Type, Set<StereotypeExtender>>();
		for (Stereotype applicableStereotype : applicableStereotypes) {
//			if (applicableStereotype.getName().contains("Parent")) {
//				System.out.println("Got it");
//			}
			for (StereotypeExtender typeExtension : applicableStereotype.getOwnedExtenders()) {
				Type extensibleMetatype = typeExtension.getClass_();
				if (extensibleMetatype != null) {
					Set<StereotypeExtender> typeExtensions = extensibleMetatype2typeExtensions.get(extensibleMetatype);
					if (typeExtensions == null) {
						typeExtensions = new HashSet<StereotypeExtender>();
						extensibleMetatype2typeExtensions.put(extensibleMetatype, typeExtensions);
					}
					typeExtensions.add(typeExtension);
				}
			}
		}
		return extensibleMetatype2typeExtensions;
	}

	public @Nullable Type getMetatype(@NonNull String packageName, @NonNull String className) {
		return metatypeName2metatype.get(className);
	}

/*	private @NonNull Map<Type, Set<Stereotype>> getMetatype2stereotypeClosure(@NonNull Iterable<Profile> asProfiles) {
		//
		//	Create the closure of all profiles to each package for which any profile is applied
		//
		Map<Type, Set<Stereotype>> metatype2applicableStereotypes = new HashMap<Type, Set<Stereotype>>();
		for (Profile asProfile2 : asProfiles) {
			for (Type type : asProfile2.getOwnedType()) {
				if (type instanceof Stereotype) {
					Set<Stereotype> applicableStereotypeClosure = stereotype2superStereotypeClosure.get(type);
					if (applicableStereotypeClosure != null) {
						for (Stereotype applicableStereotype : applicableStereotypeClosure) {
							if (applicableStereotype != null) {
								for (TypeExtension typeExtension : applicableStereotype.getExtensionOfs()) {
									if (typeExtension != null) {
										Type metatype = typeExtension.getType();
										if (metatype != null) {
											Set<Stereotype> applicableStereotypes = metatype2applicableStereotypes.get(metatype);
											if (applicableStereotypes == null) {
												applicableStereotypes = new HashSet<Stereotype>();
												metatype2applicableStereotypes.put(metatype, applicableStereotypes);
											}
											applicableStereotypes.add(applicableStereotype);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return metatype2applicableStereotypes;
	} */

	private @NonNull Set<Stereotype> getOwnedStereotypes(@NonNull Iterable<Profile> asProfiles) {
		Set<Stereotype> allOwnedStereotypes = new HashSet<Stereotype>();
		for (Profile asProfile : asProfiles) {
			Set<Stereotype> ownedStereotypes = profile2ownedStereotypes.get(asProfile);
			if (ownedStereotypes != null) {
				allOwnedStereotypes.addAll(ownedStereotypes);
			}
		}
		return allOwnedStereotypes;
	}

/*	private @NonNull Set<Stereotype> getStereotypeSubSuperClosure(@NonNull Iterable<Stereotype> asStereotypes) {
		Set<Stereotype> stereotypeClosure = new HashSet<Stereotype>();
		for (Stereotype asStereotype : asStereotypes) {
			Set<Stereotype> subStereotypeClosure = stereotype2subStereotypeClosure.get(asStereotype);
			if (subStereotypeClosure != null) {
				stereotypeClosure.addAll(subStereotypeClosure);
			}
			Set<Stereotype> subperStereotypeClosure = stereotype2superStereotypeClosure.get(asStereotype);
			if (subperStereotypeClosure != null) {
				stereotypeClosure.addAll(subperStereotypeClosure);
			}
		}
		return stereotypeClosure;
	} */

	private @Nullable Set<Type> getSubMetatypeClosure(@NonNull Type metatype) {
		return metatype2subMetatypeClosure.get(metatype);
	}
}
