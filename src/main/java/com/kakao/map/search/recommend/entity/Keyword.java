package com.kakao.map.search.recommend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {

	@Id
	private String keyword;
	
	private Integer count;
	
	public Keyword countUp() {
		this.count++;
		return this;
	}
}
