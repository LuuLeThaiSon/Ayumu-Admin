package com.example.ayumuadmin.service.impl;

import com.example.ayumuadmin.entity.UserEntity;
import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.request.LoginRegisterRequest;
import com.example.ayumuadmin.model.response.StatusResponse;
import com.example.ayumuadmin.repository.UserRepository;
import com.example.ayumuadmin.service.UserService;
import com.example.ayumuadmin.utils.AyumuErrorCode;
import com.example.ayumuadmin.utils.Common;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public StatusResponse register(LoginRegisterRequest requestBody) throws AyumuException {
		try {
			StatusResponse responseBody = new StatusResponse();
			if (userRepository.findByUsername(requestBody.getUsername()) == null) {
				UserEntity user = new UserEntity();

				user.setUsername(requestBody.getUsername());
				user.setPassword(passwordEncoder.encode(requestBody.getPassword()));
				user.setRoleId(1);
				user.setStatus(Common.STATUS_ACTIVE);

				userRepository.save(user);

				responseBody.setStatus(Common.STATUS_SUCCESS);
				return responseBody;
			}

			responseBody.setStatus(Common.STATUS_FAILED);
			return responseBody;
		} catch (Exception e) {
			throw new AyumuException(AyumuErrorCode.BAD_REQUEST, "BAD_REQUEST");
		}
	}
}
