package com.kakao.map.search.login.entity;

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
public class User {

	@Id
	private String id;
	private String password;
	
	public User erasePassword() {
		this.password = "";
		return this;
	}
}
