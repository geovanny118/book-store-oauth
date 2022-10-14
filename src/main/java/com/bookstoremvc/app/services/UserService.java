package com.bookstoremvc.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bookstoremvc.app.entities.UserEntity;
import com.bookstoremvc.app.repositories.IUserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder encoder;
	
	public UserEntity findByUserName(String userName) {
		return userRepository.findByUserName(userName).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username).orElse(null);
		if(user == null) {
			throw new UsernameNotFoundException("Error no existe el usuario");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	}
	
	public ResponseEntity<Object> addUser(UserEntity user){
		ResponseEntity<Object> response;
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Error creando usuario",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
