package com.rs.book.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rs.book.entity.Product;
import com.rs.book.entity.Team;
import com.rs.book.entity.TeamData;
import com.rs.book.repository.ProductRepository;
import com.rs.book.response.SaveTeamResponse;
import com.rs.book.response.SearchTeamResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:4200")
public class BookTestController {

	@Autowired
	private ProductRepository repo;

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * 
	 * @param name
	 * @return {@link SearchTeamResponse}
	 */
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

	/**
	 * 
	 * @return
	 */
	@GetMapping("/get")
	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "detailsFallBack")
	public String search() {
		String url = "http://localhost:8080/demo/get/";
		restTemplate.getForEntity(url + 1, String.class);
		return "method called seccessfully";
	}

	/**
	 * It will give the response as team saved or not
	 * 
	 * @param team 
	 * 			Team
	 * @return {@link SaveTeamResponse}
	 */
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

	@GetMapping("/details")
	public List<Product> details() {
		return repo.findAllExcludingPlaceAndId();
	}

	@PostMapping("/setDetails")
	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "detailsFallBack")
	public String set(@RequestBody Product request) {
		// restTemplate.exchange("http://localhost:8080/api/tutorials/3",
		// HttpMethod.GET, ResponseEntity.class, String.class);

		restTemplate.getForEntity("http://localhost:8080/demo/get/" + 1, String.class);
		/*
		 * try { repo.save(request); return "Saved Successfully"; } catch (Exception e)
		 * { return "Failed to save"; }
		 */
		return "success";
	}

	public String detailsFallBack(Exception ex) {
		return "there is somthing went wrong";
	}

	// at 6 AM 0 value second, minute, hour,
	// day of month, month, day(s) of week
	@Scheduled()
	@Scheduled(cron = "0 0/15 * * * ?")
	public void prints() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println(LocalTime.now().format(formatter));
	}

}
