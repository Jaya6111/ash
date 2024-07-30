package com.rs.book.response;

import java.util.List;

import com.rs.book.entity.TeamData;

import lombok.Data;


@Data
public class SearchTeamResponse {

	List<TeamData> teams;
	String name;
	String message;

}
