package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.ThreeWayComparisonGroupProvider.ConflictsGroupImpl;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.ConflictNode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.nodes.MatchNode;
import org.eclipse.emf.ecore.EObject;

public class ConflictNodeBuilder {

	private final Conflict conflict;

	private final ConflictsGroupImpl group;

	private final Map<Match, MatchNode> matchNodes;

	public ConflictNodeBuilder(Conflict conflict, ConflictsGroupImpl group) {
		this.conflict = conflict;
		this.group = group;
		matchNodes = new LinkedHashMap<Match, MatchNode>();
	}

	/**
	 * Build the node for the conflict.
	 * 
	 * @return The node of the conflict, complete with all its children.
	 */
	public ConflictNode buildNode() {
		ConflictNode conflictNode = group.createConflictNode(conflict);
		for (Diff diff : conflict.getDifferences()) {
			Match match = group.getTargetMatch(diff);
			if (match != null) {
				MatchNode matchNode = ensureMatchNode(match, conflictNode);
				group.addDiffNode(matchNode, diff);
			}
		}
		List<Match> nonRootMatches = Lists.newArrayListWithCapacity(matchNodes.size());
		outer: for (Match match : matchNodes.keySet()) {
			EObject container = match.eContainer();
			while (container instanceof Match) {
				if (matchNodes.containsKey(container)) {
					nonRootMatches.add(match);
					continue outer;
				}
				container = container.eContainer();
			}
		}
		for (Match match : nonRootMatches) {
			MatchNode matchNode = matchNodes.get(match);
			EObject container = match.eContainer();
			MatchNode childNode = matchNode;
			boolean stop = false;
			while (container instanceof Match && !stop) {
				MatchNode hierarchyNode;
				if (matchNodes.containsKey(container)) {
					hierarchyNode = matchNodes.get(container);
					stop = true;
				} else {
					hierarchyNode = group.createMatchNode((Match)container);
					matchNodes.put((Match)container, hierarchyNode);
				}
				hierarchyNode.addSubMatchNode(childNode);
				childNode = hierarchyNode;
				container = container.eContainer();
			}
		}
		return conflictNode;
	}

	private MatchNode ensureMatchNode(Match match, ConflictNode conflictNode) {
		MatchNode node;
		if (matchNodes.containsKey(match)) {
			node = matchNodes.get(match);
		} else {
			node = group.createMatchNode(match);
			conflictNode.addConflictingTree(node);
			matchNodes.put(match, node);
		}
		return node;
	}

}
