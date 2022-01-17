package com.safetynetalerts.api.datajson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.safetynetalerts.api.entities.Firestation;
import com.safetynetalerts.api.entities.Medicalrecord;
import com.safetynetalerts.api.entities.Person;

import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "persons",
    "firestations",
    "medicalrecords"
})
@Getter
@Setter
public class DataFile {

    @JsonProperty("persons")
    public List<Person> persons = null;
    @JsonProperty("firestations")
    public List<Firestation> firestations = null;
    @JsonProperty("medicalrecords")
    public List<Medicalrecord> medicalrecords = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
   
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
  
}
