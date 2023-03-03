package com.web.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.web.entities.Citizen;
import com.web.entities.RequiredResponse;
import com.web.model.VaccinationCenter;
import com.web.repo.VaccinationCenterRepo;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter newCenter)
	{
		VaccinationCenter center=centerRepo.save(newCenter);
		return new ResponseEntity<>(center,HttpStatus.OK);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDadaBasedonCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse =  new RequiredResponse();
		//1st get vaccination center detail
		VaccinationCenter center  = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		
		// then get all citizen registerd to vaccination center
		
		java.util.List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getOne/{id}")
	public VaccinationCenter getOne(@PathVariable Integer id)
	{
		return centerRepo.findById(id).get();
	}
	
	@GetMapping("/findAll")
	public List<VaccinationCenter> getAll()
	{
		return centerRepo.findAll();
	}
}
