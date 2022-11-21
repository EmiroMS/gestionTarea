package com.gestion.tarea.controller;
//prueba
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tarea.dto.TareaDTO;
import com.gestion.tarea.exception.RequestException;
import com.gestion.tarea.persistence.model.TareaModel;
import com.gestion.tarea.persistence.model.TareaStatus;
import com.gestion.tarea.service.TareaService;

@RestController
@RequestMapping("/api")
public class TareaController {

	private final TareaService tareaService;
	
	public TareaController(TareaService tareaService) {
		this.tareaService=tareaService;
	}
	
	
	@PostMapping("/create")
	public TareaModel createTarea(@RequestBody TareaDTO tareaDTO) {
		if(tareaDTO.getTitle().equals("") || tareaDTO.getTitle() == null) {
			throw new RequestException("400","the title is required");
		}
		if(tareaDTO.getDescription().equals("") || tareaDTO.getDescription() == null) {
			throw new RequestException("400","the description is required");
		}
		/*if(tareaDTO.getEta().equals("") || tareaDTO.getEta() == null) {
			throw new RequestException("400","the eta is required");
		}*/
		return this.tareaService.createTarea(tareaDTO);
		
	}
	
	@GetMapping("/finall")
	public List<TareaModel> finAll() {
		return this.tareaService.finAll();
	}
	
	@GetMapping("/finall/{status}")
	public List<TareaModel> finAllByStatus(@PathVariable("status")TareaStatus status) {
		return this.tareaService.finAllStatus(status);
	}
	
	@PatchMapping("/updatefinished/{id}")
	public ResponseEntity<Void> tareaFinished(@PathVariable("id") Long id){
		this.tareaService.updateTareaFinished(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> tareaDelete(@PathVariable("id") Long id){
		this.tareaService.deleteByid(id);
		return ResponseEntity.noContent().build();
	}
}
