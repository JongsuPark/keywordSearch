package com.kakao.map.search.keyword.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Location {
	
	private String addressName;
	private String categoryGroupCode;
	private String categoryGroupName;
	private String categoryName;
	private String distance;
	private String id;
	private String phone;
	private String placeName;
	private String placeUrl;
	private String roadAddressName;
	private String x;
	private String y;
	
}
