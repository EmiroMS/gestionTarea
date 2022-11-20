package com.gestion.tarea.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gestion.tarea.dto.TareaDTO;
import com.gestion.tarea.persistence.model.TareaModel;
import com.gestion.tarea.persistence.model.TareaStatus;

@Component
public class TareaDTOToTarea implements IMapper<TareaDTO,TareaModel>{

	@Override
	public TareaModel map(TareaDTO in) {
		
		TareaModel tarea = new TareaModel();
		tarea.setTitle(in.getTitle());
		tarea.setDescription(in.getDescription());
		tarea.setEta(in.getEta());
		tarea.setCreatedDate(LocalDateTime.now());
		tarea.setFinished(false);
		tarea.setTareaStatus(TareaStatus.ON_TIME);
		return tarea;
	}

	
}
