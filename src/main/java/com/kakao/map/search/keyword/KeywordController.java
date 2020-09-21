package com.kakao.map.search.keyword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kakao.map.search.keyword.entity.Location;
import com.kakao.map.search.recommend.RecommendService;
import com.kakao.map.search.recommend.entity.Keyword;

@Controller
public class KeywordController {
	
	@Autowired
	KeywordService keywordService;
	
	@Autowired
	RecommendService recommendService;

	@GetMapping("/search")
	public ModelAndView searchByKeyword(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
		List<Location> locationList = keywordService.searchByKeyword(keyword, page, size);
		List<Keyword> keywordList = recommendService.getTopTenKeywords();
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("locationList", locationList);
		view.addObject("keywordList", keywordList);
		
		view.setViewName("main");
		
		return view;
	}
}
