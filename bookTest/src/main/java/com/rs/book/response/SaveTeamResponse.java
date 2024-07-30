package com.rs.book.response;

import java.util.List;

import com.rs.book.entity.Team;

import lombok.Data;

@Data
public class SaveTeamResponse {
	String message;
	List<String> errorMessages;
	Team team;
}
