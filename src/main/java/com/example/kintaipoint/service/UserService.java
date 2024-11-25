package com.example.kintaipoint.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kintaipoint.entity.User;
import com.example.kintaipoint.form.SignupForm;
import com.example.kintaipoint.form.UserEditForm;
import com.example.kintaipoint.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;		
		this.passwordEncoder = passwordEncoder;
	}
	
	//会員登録機能
	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		
		user.setName(signupForm.getName());
		user.setTelephone(signupForm.getTelephone());
		user.setEmergencyContact(signupForm.getEmergencyContact());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		
		return userRepository.save(user);
	}
	
	//会員登録機能
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
	
	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.getReferenceById(userEditForm.getId());
		
		user.setName(userEditForm.getName());
		user.setTelephone(userEditForm.getTelephone());
		user.setEmergencyContact(userEditForm.getEmergencyContact());
		user.setEmail(userEditForm.getEmail());
		
		userRepository.save(user);
	}
}
