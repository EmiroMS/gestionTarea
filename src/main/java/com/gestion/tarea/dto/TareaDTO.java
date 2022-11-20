package com.gestion.tarea.dto;

import java.util.Date;


public class TareaDTO {

    private String title;
    private String description;
	private Date eta; //fecha estimada
	
	
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}

}
