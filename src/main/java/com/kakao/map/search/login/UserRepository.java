package com.kakao.map.search.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakao.map.search.login.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByIdAndPassword(String id, String password);
}
