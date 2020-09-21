package com.kakao.map.search.recommend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kakao.map.search.recommend.entity.Keyword;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, String> {

	public List<Keyword> findTop10ByOrderByCountDesc();
}
