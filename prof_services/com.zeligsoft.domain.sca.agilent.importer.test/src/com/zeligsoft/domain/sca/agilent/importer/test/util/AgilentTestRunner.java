package com.zeligsoft.domain.sca.agilent.importer.test.util;

import java.util.Arrays;

import com.zeligsoft.base.oaw.test.XTendTestRunner;

@SuppressWarnings("nls")
public class AgilentTestRunner {

	private static final Iterable<String> emfMMPackages = Arrays.asList(
		"com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage"
	);

	public static <T> T run(Iterable<String> zdlMMUris, String xtendTopRule, Object...vargs) {
		return XTendTestRunner.run(zdlMMUris, emfMMPackages, xtendTopRule, vargs);
	}

	public static <T> T run(String xtendTopRule, Object...vargs) {
		return run(null, xtendTopRule, vargs);
	}
}
