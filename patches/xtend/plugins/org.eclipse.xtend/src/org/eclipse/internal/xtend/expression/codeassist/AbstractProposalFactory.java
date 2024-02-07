package org.eclipse.internal.xtend.expression.codeassist;

import java.util.Set;

import org.eclipse.xtend.typesystem.Callable;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.ParameterizedCallable;
import org.eclipse.xtend.typesystem.Type;

public abstract class AbstractProposalFactory implements ProposalFactory {

	public boolean isDuplicate(Set<String> nameCache, Object proposal) {
		if (nameCache == null || proposal == null)
			throw new IllegalArgumentException("nameCache: " + nameCache + " proposal: " + proposal);

		Callable callable = castToCallable(proposal);
		return callable == null || nameCache.contains(getAsString(callable));
	}

	private String getAsString(Callable callable) {
		StringBuilder result = new StringBuilder(30);
		if (callable instanceof Feature)
			result.append(((Feature) callable).getOwner().getName()).append(".");
		result.append(callable.getName());
		if (callable instanceof ParameterizedCallable) {
			result.append('(');
			for(Type param: ((ParameterizedCallable) callable).getParameterTypes()) {
				result.append(param.toString());
				result.append(',');
			}
			result.append(')');
		}
		return result.toString();
	}

	public void addToCache(Set<String> nameCache, Object proposal) {
		Callable feature = castToCallable(proposal);
		if (feature != null) {
			nameCache.add(getAsString(feature));
		}
	}

	private Callable castToCallable(Object obj) {
		if (obj instanceof Callable)
			return (Callable) obj;

		return null;
	}
	
}
