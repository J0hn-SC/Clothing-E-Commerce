package com.jesc.service;

import org.springframework.stereotype.Service;

import com.jesc.exception.UserException;
import com.jesc.model.User;

@Service
public interface UserService {
	public User findUserById(Long userId) throws UserException;
	public User findUserProfileByJwt(String jwt) throws UserException;
}
