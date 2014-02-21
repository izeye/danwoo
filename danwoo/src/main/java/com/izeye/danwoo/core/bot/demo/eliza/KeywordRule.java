package com.izeye.danwoo.core.bot.demo.eliza;

import java.util.List;

public class KeywordRule implements Comparable<KeywordRule> {

	private String keyword;
	private int rank;
	private List<DecompositionRule> decompositionRules;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<DecompositionRule> getDecompositionRules() {
		return decompositionRules;
	}

	public void setDecompositionRules(List<DecompositionRule> decompositionRules) {
		this.decompositionRules = decompositionRules;
	}

	@Override
	public String toString() {
		return "KeywordRule [keyword=" + keyword + ", rank=" + rank
				+ ", decompositionRules=" + decompositionRules + "]";
	}

	@Override
	public int compareTo(KeywordRule o) {
		return Integer.compare(getRank(), o.getRank());
	}

}
