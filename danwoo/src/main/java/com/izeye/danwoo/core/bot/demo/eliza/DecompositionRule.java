package com.izeye.danwoo.core.bot.demo.eliza;

import java.util.List;

public class DecompositionRule {

	private String decompositionPattern;
	private boolean forMemory;
	private List<String> reassemblyRules;

	private int currentReassemblyRuleIndex = 0;

	public String getDecompositionPattern() {
		return decompositionPattern;
	}

	public void setDecompositionPattern(String decompositionPattern) {
		this.decompositionPattern = decompositionPattern;
	}

	public boolean isForMemory() {
		return forMemory;
	}

	public void setForMemory(boolean forMemory) {
		this.forMemory = forMemory;
	}

	public List<String> getReassemblyRules() {
		return reassemblyRules;
	}

	public void setReassemblyRules(List<String> reassemblyRules) {
		this.reassemblyRules = reassemblyRules;
	}

	public int getCurrentReassemblyRuleIndex() {
		return currentReassemblyRuleIndex;
	}

	public void setCurrentReassemblyRuleIndex(int currentReassemblyRuleIndex) {
		this.currentReassemblyRuleIndex = currentReassemblyRuleIndex;
	}

	public String nextReassemblyRule() {
		String reassemblyRule = reassemblyRules.get(currentReassemblyRuleIndex);

		currentReassemblyRuleIndex++;
		if (currentReassemblyRuleIndex == reassemblyRules.size()) {
			currentReassemblyRuleIndex = 0;
		}
		return reassemblyRule;
	}

	@Override
	public String toString() {
		return "DecompositionRule [decompositionPattern="
				+ decompositionPattern + ", forMemory=" + forMemory
				+ ", reassemblyRules=" + reassemblyRules
				+ ", currentReassemblyRuleIndex=" + currentReassemblyRuleIndex
				+ "]";
	}

}
