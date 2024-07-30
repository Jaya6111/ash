package com.rs.app.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddMyBooksRequest {

	private String uId;
	private String pId;
	private String id;
}
