package com.kakao.map.search.recommend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.map.search.recommend.entity.Keyword;

@RestController
public class RecommendController {

	@Autowired
	RecommendService recommendService;
	
	@GetMapping("/recommend")
	public List<Keyword> getTopTenKeywords() {
		
		return recommendService.getTopTenKeywords();
	}
}
