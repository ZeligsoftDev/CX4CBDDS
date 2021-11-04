# About Papyrus patches

Papyrus patches use Eclipse 'feature patches' to replace an original papyrus plugin with
and updated one.

At the time of writing, we were based on Papyrus 4.4.0 (2019-06), but in anticipation of
moving to newer versions, the folder is organized by papyrus versions.

Under each version folder, there should be:

- a `feature-com.zeligsoft.papyruspatch` 'feature patch' project
- copies of the patched papyrus plugin source(s). See `v4.4.0/org.eclipse.papyrus.uml.tools/README.md` as an example.
- a `site-papyrus-patch` 'update site' project
- a `pom.xml` including each of these projects

## Some notes on the patching process and integrating it with builds

- Tycho does not fully understand feature patches. As such, some Tycho features fail to
work when they are present. In particular, building P2 repositories fails.
- Ideally, we would reference the feature patch from are main feature, for example
`features/com.zeligsoft.domain.ngc.ccm.axioma-feature/feature.xml`. The P2 repository
build would then integrate it. Unfortunately, this does not work.
- It was discovered that an legacy Tycho `eclipse-update-site` can
package a feature patch. The generated `eclipse-update-site` is a P2 repository
- However the main P2 repositories we build are too complex to be built
with `eclipse-update-site` repos.
- As a work around, the `site-papyrus-patch` is an `eclipse-update-site`, but the built
P2 feature patch is not referenced in `features/com.zeligsoft.domain.ngc.ccm.axioma-feature/feature.xml`.
- Thus, installation of a Papyrus CX build is now a two step projects: 1) install CX, 2)
install the feature patch. These can be done any order.
- RPMs can be updated to install both, but users installing from GitHub downloads must
be instructed to download both and install them both.

## Possible solutions to allow a single P2 repository

The following are some ideas for returning to a single P2 repository:

- we attempted to build `releng/com.zeligsoft.dds4ccm.update.axcioma` as an `eclipse-update-site`
by modifying the `pom.xml` element `<packaging>` to `eclipse-update-site`.
We copied `category.xml` to `site.xml` to satisfy the expectations of `eclipse-update-site`.
- However, but build failed because of the presence of `<bundle>` elements.
- To workaround this, we could create a new feature `com.zeligsoft.depenencies.orphaned`
and include these bundles.
- The `site.xml` would then be updated to reference the new feature, and remove the `<bundle>`
elements.
- If the P2 repo builds correctly, then the next step would be to add the patch feature to
`features/com.zeligsoft.domain.ngc.ccm.axioma-feature/feature.xml`, and attempt another
build.
- If the build succeeds, the resulting P2 site would solve the problem.
- Note that the `eclipse-update-site` packaging always builds a file `site.zip`. See
`papyrus-patch/v4.4.0/site-papyrus-patch/pom.xml` for changes to copy this to a more
meaningfully named file.
