package com.example.ayumuadmin.service;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.request.LoginRegisterRequest;
import com.example.ayumuadmin.model.response.StatusResponse;

public interface UserService {
	StatusResponse register(LoginRegisterRequest requestBody) throws AyumuException;
}
