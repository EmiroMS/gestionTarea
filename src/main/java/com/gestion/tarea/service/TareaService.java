package com.gestion.tarea.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gestion.tarea.dto.TareaDTO;
import com.gestion.tarea.mapper.TareaDTOToTarea;
import com.gestion.tarea.persistence.model.TareaModel;
import com.gestion.tarea.persistence.model.TareaStatus;
import com.gestion.tarea.persistence.repository.TareaRepository;

@Service
public class TareaService {
	
	//inyectamos repositorio por contructor
	private final TareaRepository tareaRepository;
	private final TareaDTOToTarea mapper;
	
	public TareaService(TareaRepository tareaRepository, TareaDTOToTarea mapper) {
		this.tareaRepository= tareaRepository;
		this.mapper = mapper;
	}
	
	
	public TareaModel createTarea(TareaDTO tareaDTO) {
		TareaModel tarea = mapper.map(tareaDTO); 
		 return this.tareaRepository.save(tarea);
	}
	
	public List<TareaModel>finAll(){
		return this.tareaRepository.findAll();
	}
	
	public List<TareaModel>finAllStatus(TareaStatus status){
		return this.tareaRepository.findAllByTareaStatus(status);
	}
	
	@Transactional
	public void updateTareaFinished(Long id) {
		this.tareaRepository.tareaFinished(id);
	}
	
	public void deleteByid(Long id) {
		this.tareaRepository.deleteById(id);
	}
	
}
