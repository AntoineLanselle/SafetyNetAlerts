package com.safetynetalerts.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.api.entities.Firestation;
import com.safetynetalerts.api.services.FirestationService;

@RestController
public class FirestationController {

	@Autowired
	private FirestationService firestationService;
	
	//get la liste de toutes les personnes
	@GetMapping("/firestations")
	public List<Firestation> getFirestations() throws IOException {
		return this.firestationService.getFirestations();
	}
	
	//get une personne en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@GetMapping("/firestation")
	public Firestation getFirestation(@RequestParam(name="station", required=true) String station) throws IOException {
		return this.firestationService.getFirestation(station);
	}
	
	//ajouter une nouvelle personne 
	@PostMapping("/firestation")
	public Firestation addFirestation(@RequestBody Firestation firestation) throws IOException {
		return this.firestationService.addFirestation(firestation);
	}
	
	//update une personne avec une requete PUT
	@PutMapping("/firestation")
	public Firestation updateFirestation(@RequestBody Firestation firestation) throws IOException {
		return this.firestationService.updateFirestation(firestation);
	}		
	
	// /!\ ajouter request body
	//supprime une personne en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@DeleteMapping("/firestation")
	public boolean deleteFirestation(@RequestParam(name="station", required=true) String station) throws IOException {
		return this.firestationService.deleteFirestation(station);
	}
	
}
