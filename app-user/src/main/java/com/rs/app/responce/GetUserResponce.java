package com.rs.app.responce;

import java.util.Set;

import org.springframework.http.HttpStatus;

import com.rs.app.bean.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponce {
	
	private User user;
	private Set<String> errorMessages;
	private HttpStatus httpStatus;

}
