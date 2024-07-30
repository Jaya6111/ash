package com.rs.book.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.book.entity.Team;
import com.rs.book.entity.TeamData;
import com.rs.book.response.SaveTeamResponse;
import com.rs.book.response.SearchTeamResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class BookTestController {

	@GetMapping("/ipl/getTeams/{name}")
	public SearchTeamResponse searchTeam(@PathVariable String name) {
		SearchTeamResponse response = new SearchTeamResponse();
		List<TeamData> teams = new ArrayList<TeamData>();

		TeamData team = new TeamData();
		team.setName(name);
		team.setTeamId(5);
		team.setTeamCode(1111);
		team.setCreated(new Date().toString());
		team.setUpdated(new Date().toString());

		teams.add(team);

		response.setMessage("");
		response.setName(name);
		response.setTeams(teams);

		return response;
	}

	@GetMapping("/get")
	public String search() {
		return "method called seccessfully";
	}

	@PostMapping("/register")
	public SaveTeamResponse saveTeam(@RequestBody Team team) {

		SaveTeamResponse response = new SaveTeamResponse();
		List<String> errorMessages = new ArrayList<String>();
		String message = "";

		if (team.getName().equals("")) {
			errorMessages.add("Team name is empty");
		} else if (team.getTeamCode().equals("")) {
			errorMessages.add("Team code is empty");
		} else if (team.getName().equals("IND")) {
			message = "Team is already find with the given Team Name";
		} else if (team.getTeamCode().equals("111")) {
			message = "Team already find with given team Code";
		}

		response.setMessage(message);
		response.setErrorMessages(errorMessages);
		response.setTeam(team);

		return response;
	}
}
