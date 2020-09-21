package com.kakao.map.search.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.map.search.common.EncryptionUtil;
import com.kakao.map.search.login.entity.User;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	public User login(String id, String password) {
		System.out.println(EncryptionUtil.encrypt(password));
		Optional<User> user = userRepository.findByIdAndPassword(id, EncryptionUtil.encrypt(password));
		
		if(user.isPresent()) return user.get().erasePassword();
		else return null;
	}
}
