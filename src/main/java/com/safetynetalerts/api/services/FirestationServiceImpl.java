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
import com.safetynetalerts.api.entities.Firestation;

/**
 * @author Antoine
 *
 */
@Service
public class FirestationServiceImpl implements FirestationService {

	@Override
	public List<Firestation> getFirestations() throws IOException {
		List<Firestation> listFirestations = new ArrayList<Firestation>();
		listFirestations = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class)).getFirestations();
		JsonConverter.convertObjectToJson(listFirestations);
		return listFirestations;
	}

	@Override
	public Firestation getFirestation(String station) throws IOException {
		Firestation firestation = new Firestation();		
		Predicate<Firestation> byStation = s -> s.getStation().contains(station);
		firestation = this.getFirestations().stream().filter(byStation).collect(Collectors.toList()).get(0);
		return firestation;
	}

	@Override
	public Firestation addFirestation(Firestation firestation) throws IOException {
		List<Firestation> listFirestations = new ArrayList<Firestation>();
		listFirestations = this.getFirestations();
		listFirestations.add(firestation);
		JsonConverter.updateFirestations(listFirestations);
		return firestation;
	}

	@Override
	public Firestation updateFirestation(Firestation firestation) throws IOException {
		this.deleteFirestation(firestation.getStation());
		this.addFirestation(firestation);
		return firestation;
	}

	@Override
	public boolean deleteFirestation(String station) throws IOException {
		List<Firestation> listFirestations = new ArrayList<Firestation>();
		listFirestations = this.getFirestations();
		Predicate<Firestation> byStation = s -> s.getStation().contains(station);
		listFirestations.removeIf(byStation);
		JsonConverter.updateFirestations(listFirestations);
		return true;
	}

}
