package com.example.ayumuadmin.controller.admin;

import com.example.ayumuadmin.model.request.LoginRegisterRequest;
import com.example.ayumuadmin.model.response.JwtResponse;
import com.example.ayumuadmin.model.response.StatusResponse;
import com.example.ayumuadmin.service.UserService;
import com.example.ayumuadmin.service.impl.JwtUserDetailsService;
import com.example.ayumuadmin.utils.Common;
import com.example.ayumuadmin.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/ayumu/v1/auth")
public class AuthController {
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final JwtUserDetailsService jwtUserDetailsService;

	@PostMapping("/register")
	public ResponseEntity<StatusResponse> register(@RequestBody LoginRegisterRequest requestBody) throws Exception {
		return ResponseEntity.ok(userService.register(requestBody));
	}

	@GetMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRegisterRequest requestBody) throws Exception {

		authenticate(requestBody.getUsername(), requestBody.getPassword());

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(requestBody.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token, Common.STATUS_SUCCESS));
	}


	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
