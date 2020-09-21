package com.kakao.map.search.recommend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.map.search.recommend.entity.Keyword;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	KeywordRepository keywordRepository;
	
	@Override
	public List<Keyword> getTopTenKeywords() {
		
		return keywordRepository.findTop10ByOrderByCountDesc();
	}

	@Override
	public void addKeywordCount(String keyword) {
		
		Keyword key = keywordRepository.findById(keyword).map(v -> v).orElse(Keyword.builder().keyword(keyword).count(0).build()).countUp();
		
		keywordRepository.save(key);
	}

}
