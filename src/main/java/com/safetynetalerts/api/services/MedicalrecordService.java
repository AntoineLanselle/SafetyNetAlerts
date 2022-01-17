package com.safetynetalerts.api.services;

import java.io.IOException;
import java.util.List;
import com.safetynetalerts.api.entities.Medicalrecord;

public interface MedicalrecordService {

	public List<Medicalrecord> getMedicalrecords() throws IOException;	
	
	public Medicalrecord getMedicalrecord(String firstName, String lastName) throws IOException;
	
	public Medicalrecord addMedicalrecord(Medicalrecord medicalrecord) throws IOException;
	
	public Medicalrecord updateMedicalrecord(Medicalrecord medicalrecord) throws IOException;
	
	public boolean deleteMedicalrecord(String firstName, String lastName) throws IOException;
	
}
