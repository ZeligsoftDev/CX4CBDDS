package com.zeligsoft.cx.langc.test.util;

import java.util.Arrays;

import com.zeligsoft.base.oaw.test.XTendTestRunner;

@SuppressWarnings("nls")
public class LangCTestRunner {

	private static final Iterable<String> emfMMPackages = Arrays.asList(
		"com.zeligsoft.cx.langc.LangCPackage"
	);

	public static <T> T run(Iterable<String> zdlMMUris, String xtendTopRule, Object...vargs) {
		return XTendTestRunner.run(zdlMMUris, emfMMPackages, xtendTopRule, vargs);
	}

	public static <T> T run(String xtendTopRule, Object...vargs) {
		return run(null, xtendTopRule, vargs);
	}
}
