package com.kakao.map.search.keyword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.kakao.map.search.keyword.entity.Location;
import com.kakao.map.search.recommend.RecommendService;

@Service
public class KakaoKeywordServiceImpl implements KeywordService {

	@Value("${rest.kakao.apiKey}")
	String apiKey;
	
	@Value("${rest.kakao.url}")
	String url;
	
	@Autowired
	RecommendService recommendService;
	
	@Override
	public List<Location> searchByKeyword(String keyword, int page, int size) {
		
		RestTemplate rest = new RestTemplateBuilder().build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", apiKey);

		HttpEntity entity = new HttpEntity(headers);
		
		UriComponents comp = UriComponentsBuilder.fromHttpUrl(url).queryParam("query", keyword).queryParam("page", page).queryParam("size", size).build();
		
		ResponseEntity<String> response = rest.exchange(comp.toUriString(), HttpMethod.GET, entity, String.class);
		
		Gson gson = new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).serializeNulls().create();
		
		String documents = JsonParser.parseString(response.getBody()).getAsJsonObject().get("documents").toString();
		System.out.println(documents);
		
		List<Location> list = gson.fromJson(documents, TypeToken.getParameterized(List.class, Location.class).getType());
		recommendService.addKeywordCount(keyword);
		
		return list;
	}

	
}
