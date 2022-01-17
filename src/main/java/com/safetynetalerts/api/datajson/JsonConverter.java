package com.safetynetalerts.api.datajson;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.api.entities.Firestation;
import com.safetynetalerts.api.entities.Medicalrecord;
import com.safetynetalerts.api.entities.Person;

public class JsonConverter {
	
	private final static String fileName = "C:\\Users\\Juviva\\Desktop\\projet5\\api\\src\\main\\resources\\data.json";
	
	public static String convertObjectToJson(Object obj) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File resultFile = new File("result.json");
		objectMapper.writeValue(resultFile, obj);
		return objectMapper.writeValueAsString(obj);
	}
	
	public static String updatePersons(List<Person> persons) throws IOException {
		DataFile fullData = new DataFile();
		File resultFile = new File(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		fullData = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class));
		fullData.setPersons(persons);
		objectMapper.writeValue(resultFile, fullData);
		return objectMapper.writeValueAsString(fullData);
	}
	
	public static String updateFirestations(List<Firestation> firestations) throws IOException {
		DataFile fullData = new DataFile();
		File resultFile = new File(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		fullData = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class));
		fullData.setFirestations(firestations);
		objectMapper.writeValue(resultFile, fullData);
		return objectMapper.writeValueAsString(fullData);
	}
	
	public static String updateMedicalrecords(List<Medicalrecord> medicalrecords) throws IOException {
		DataFile fullData = new DataFile();
		File resultFile = new File(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		fullData = ((DataFile) JsonConverter.ReadObjectFromJson(DataFile.class));
		fullData.setMedicalrecords(medicalrecords);
		objectMapper.writeValue(resultFile, fullData);
		return objectMapper.writeValueAsString(fullData);
	}
	
	public static Object ReadObjectFromJson(Class<?> c) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(Paths.get(fileName).toFile(), c);
	}

}
