Model diff/merge in Papyrus CX for AXCIOMA
==========================================

Updated: 2020-07-27

Table of Contents
-----------------

  * [Introduction](#introduction)
  * [Setup and configuration](#setup-and-configuration)
  * [User interface and basic usage](#user-interface-and-basic-usage)
  * [Limitations](#limitations)
  * [Additional resources](#additional-resources)


Introduction
------------

This guide describes the user interface and basic usage of the Papyrus Compare feature included in Papyrus CX for AXCIOMA.

The Papyrus Compare feature is integrated with EGit (included in Papyrus CX for AXCIOMA as well) to support collaborative modelling. It provides the capability to compare (Papyrus) models (a.k.a. model diff), and, in combination with EGit, git operations such as merge, cherry-pick and rebase for (Papyrus) models.

AXCIOMA models are Papyrus models, which are UML models (along with so-called "notation models"), which in turn are ECore (EMF) models. Therefore, Papyrus Compare is built on top of EMF Compare. Some links to the EMF Compare documentation and tutorial videos are provided below.

This guide assumes that the user is familiar with git and EGit, as well as basic modelling with Papyrus CX for AXCIOMA.


Setup and configuration
-----------------------

Papyrus Compare, EMF Compare, EGit and all their required features are included in the Papyrus CX for AXCIOMA update site, so no separate installation is required. However, some preferences must be configured for the feature to work correctly.

To configure the preferences, open the dialog Window &rarr; Preferences.

The first configuration option is necessary to allow Papyrus Compare to handle Papyrus models during the git merge operations.

* **Enable the model merge strategy in git (required)**: Go to Team &rarr; Git &rarr; Synchronize and select Recursive Model Merge Strategy.

* **Enable the Scalable Conflict Detector in EMF Compare (strongly recommended)**: Go to EMF Compare &rarr; Engines, open the tab Conflict, and check Scalable Conflict Detector.

* **Enable pre-merging non-conflicting changes (optional but recommended)**: Go to EMF Compare &rarr; Merge and check Pre-merge models when a real conflict is detected.

* **Enable workspace resolution of cross-references (optional but recommended)**: Go to EMF Compare &rarr; Resolution Strategy and select Workspace in the drop-down box Resolution scope. IMPORTANT: This may affect the performance negatively if your workspace contains many projects and many models. If you are confident that the models to be compared and all their cross references are within the same project, you can select the Project scope.

* **Disable selecting the next unresolved difference after a merge action (optional)**: Go to EMF Compare &rarr; Editor, open the tab Model Difference Tree, and uncheck Select next unresolved difference after a merge action.


User interface and basic usage
------------------------------

The main operations are described in separate pages:

* [Model comparison and local updates](papyrus-compare-model-diff.md) a.k.a. model diff. Follow this guide if you only want to compare models or if you want to incorporate changes from some commit into a workspace model without merging branches in the git repository. **It is strongly recommended to read this guide first.**

* [Model merge](papyrus-compare-model-merge.md). Follow this guide if you would like to merge branches in the git repository.



Limitations
-----------

There are several known limitations to this feature at the time of this writing (2020-07-23):

* Model diff is supported only from the Project Explorer view (select model &rarr; right-click &rarr; Compare With...), as it does not work well when launched from the Git views (Git History, Git Staging, etc.)

* Two models in the workspace can be compared with each other, and a model in the workspace can be compared with some version in a git repository but only if the model in question has been checked out from that repository. This is, it is not possible to compare a two models from different repositories unless they have both been checked out and imported into the workspace. Furthermore, comparing models from the History view is not well supported (see above.)

* Papyrus Compare is not specifically customized for AXCIOMA models, which leads to showing several differences (and possibly conflicts) in the models that correspond to the underlying UML structure, rather than the AXCIOMA abstractions and constructs. While there are several filters that are applied to the differences views (and most are enabled by default), the tool does not yet include filters to show only the AXCIOMA structure.

* Papyrus Compare reports some model differences which appear to be unexpected at the time of this writing. Some of these may be due to the lack of AXCIOMA customization described above, they may be due to bugs in the model editing tooling, in Papyrus Compare, EMF Compare or Papyrus itself. Some of these unexpected differences are being tracked in this issue on GitHub: [Papyrus Compare unexplained model differences #156](https://github.com/ZeligsoftDev/CX4CBDDS/issues/156).


Additional resources
--------------------

* The official [Papyrus Compare](https://wiki.eclipse.org/Papyrus_Compare) website.

* The official [EMF Compare](https://www.eclipse.org/emf/compare/) website.

* A series of videos describing [Papyrus Compare in CX for AXCIOMA](https://www.youtube.com/playlist?list=PL1ZUU08cM_3JVK3-v3OVnKNheOjESjcS_). Note that these videos are a bit outdated and some of the problems reported in it have been fixed.

* A video tutorial of [Papyrus Compare in plain Papyrus](https://www.youtube.com/watch?v=NSCfYAukYgk). Note: the title mentions EMF Compare. This is because previously, Papyrus Compare was included within EMF Compare, but it is now a separate feature.

* The [EMF Compare User Guide](https://www.eclipse.org/emf/compare/documentation/latest/user/user-guide.html), in particular:

  - The [EMF Compare user interface](https://www.eclipse.org/emf/compare/documentation/latest/user/user-guide.html#User_Interface_Breakdown)
  - [Comparing models with EGit](https://www.eclipse.org/emf/compare/documentation/latest/user/user-guide.html#Compare_with_remote_models_.28EGit.29)
