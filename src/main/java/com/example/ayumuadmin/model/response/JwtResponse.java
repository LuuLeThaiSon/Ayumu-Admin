package com.example.ayumuadmin.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
	private static final long serialVersionUID = -8091879091924046844L;
	private String jwt_token;
	private String status;
}
