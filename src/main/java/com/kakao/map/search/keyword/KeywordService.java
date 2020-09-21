package com.kakao.map.search.keyword;

import java.util.List;

import com.kakao.map.search.keyword.entity.Location;

public interface KeywordService {

	public List<Location> searchByKeyword(String keyword, int page, int size);
}
