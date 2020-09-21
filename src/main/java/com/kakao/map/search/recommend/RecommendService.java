package com.kakao.map.search.recommend;

import java.util.List;

import com.kakao.map.search.recommend.entity.Keyword;

public interface RecommendService {

	public List<Keyword> getTopTenKeywords();
	public void addKeywordCount(String keyword);
}
