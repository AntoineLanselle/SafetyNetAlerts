/**
 * 
 */
package com.safetynetalerts.api.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.safetynetalerts.api.datajson.DataFile;
import com.safetynetalerts.api.datajson.JsonConverter;
import com.safetynetalerts.api.entities.Medicalrecord;

/**
 * @author Antoine
 *
 */
@Service
public class MedicalrecordServiceImpl implements MedicalrecordService {

	@Override
	public List<Medicalrecord> getMedicalrecords() throws IOException {
		List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
		listMedicalrecords = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class)).getMedicalrecords();
		JsonConverter.convertObjectToJson(listMedicalrecords);
		return listMedicalrecords;
	}

	@Override
	public Medicalrecord getMedicalrecord(String firstName, String lastName) throws IOException {
		Medicalrecord medicalrecord = new Medicalrecord();		
		Predicate<Medicalrecord> byFirstLastName = m -> m.getFirstName().contains(firstName) && m.getLastName().contains(lastName);
		medicalrecord = this.getMedicalrecords().stream().filter(byFirstLastName).collect(Collectors.toList()).get(0);
		return medicalrecord;
	}

	@Override
	public Medicalrecord addMedicalrecord(Medicalrecord medicalrecord) throws IOException {
		List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
		listMedicalrecords = this.getMedicalrecords();
		listMedicalrecords.add(medicalrecord);
		JsonConverter.updateMedicalrecords(listMedicalrecords);
		return medicalrecord;
	}

	@Override
	public Medicalrecord updateMedicalrecord(Medicalrecord medicalrecord) throws IOException {
		this.deleteMedicalrecord(medicalrecord.getFirstName(), medicalrecord.getLastName());
		this.addMedicalrecord(medicalrecord);
		return medicalrecord;
	}

	@Override
	public boolean deleteMedicalrecord(String firstName, String lastName) throws IOException {
		List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
		listMedicalrecords = this.getMedicalrecords();
		Predicate<Medicalrecord> byFirstLastName = p -> p.getFirstName().contains(firstName) && p.getLastName().contains(lastName);
		listMedicalrecords.removeIf(byFirstLastName);
		JsonConverter.updateMedicalrecords(listMedicalrecords);
		return true;
	}

}
