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

import com.safetynetalerts.api.entities.Medicalrecord;
import com.safetynetalerts.api.services.MedicalrecordService;

@RestController
public class MedicalrecordController {

	@Autowired
	private MedicalrecordService medicalrecordService;
	
	//get la liste de toutes les données medicales
	@GetMapping("/medicalrecords")
	public List<Medicalrecord> getMedicalrecords() throws IOException {
		return this.medicalrecordService.getMedicalrecords();
	}
	
	//get une données medicales en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@GetMapping("/medicalrecord")
	public Medicalrecord getMedicalrecord(@RequestParam(name="firstName", required=true) String firstName, @RequestParam(name="lastName", required=true)String lastName) throws IOException {
		return this.medicalrecordService.getMedicalrecord(firstName, lastName);
	}
	
	//ajouter une nouvelle données medicales
	@PostMapping("/medicalrecord")
	public Medicalrecord addMedicalrecord(@RequestBody Medicalrecord medicalrecord) throws IOException {
		return this.medicalrecordService.addMedicalrecord(medicalrecord);
	}
	
	//update une données medicales avec une requete PUT
	@PutMapping("/medicalrecord")
	public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) throws IOException {
		return this.medicalrecordService.updateMedicalrecord(medicalrecord);
	}		
	
	// /!\ ajouter request body
	//supprime une données medicales en particulier en utilisant une combinaison de prénom et de nom comme identificateur unique
	@DeleteMapping("/medicalrecord")
	public boolean deleteMedicalrecord(@RequestParam(name="firstName", required=true) String firstName, @RequestParam(name="lastName", required=true)String lastName) throws IOException {
		return this.medicalrecordService.deleteMedicalrecord(firstName, lastName);
	}
	
}
