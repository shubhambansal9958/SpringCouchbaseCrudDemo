package com.inventory.model;

import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;


public class ServiceCentreWrapper {
	
	private List<String> serviceCentre;

	public List<String> getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(List<String> serviceCentre) {
		this.serviceCentre = serviceCentre;
	}

}
