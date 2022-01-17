package com.safetynetalerts.api.services;

import java.io.IOException;
import java.util.List;
import com.safetynetalerts.api.entities.Firestation;

public interface FirestationService {
	
	public List<Firestation> getFirestations() throws IOException;
	
	public Firestation getFirestation(String station) throws IOException;
	
	public Firestation addFirestation(Firestation firestation) throws IOException;
	
	public Firestation updateFirestation(Firestation firestation) throws IOException;
	
	public boolean deleteFirestation(String station) throws IOException;

}
