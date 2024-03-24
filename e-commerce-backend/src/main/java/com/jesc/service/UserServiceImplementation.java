package com.jesc.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jesc.config.JwtProvider;
import com.jesc.exception.UserException;
import com.jesc.model.User;
import com.jesc.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserRepository userRepository, JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}
	
	@Override
	public User findUserById(Long userId) throws UserException {
		Optional<User> opt = userRepository.findById(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
		
		throw new UserException("User not found with id - "+ userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromToken(jwt);
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UserException("User not found with email - "+ email);
		}
		return user;
	}
	
}
