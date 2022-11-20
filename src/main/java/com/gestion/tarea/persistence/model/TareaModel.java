package com.gestion.tarea.persistence.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_tarea")
public class TareaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private Date eta; //tiempo estimado
    private boolean finished;
    private TareaStatus tareaStatus; 
    
    
    
	public TareaModel() {
		super();
	}
	public TareaModel(Long id, String title, String description, LocalDateTime createdDate, Date eta,
			boolean finished, TareaStatus tareaStatus) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.eta = eta;
		this.finished = finished;
		this.tareaStatus = tareaStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public TareaStatus getTareaStatus() {
		return tareaStatus;
	}
	public void setTareaStatus(TareaStatus tareaStatus) {
		this.tareaStatus = tareaStatus;
	}
	
	
}
