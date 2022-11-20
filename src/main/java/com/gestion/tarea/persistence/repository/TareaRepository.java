package com.gestion.tarea.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.tarea.persistence.model.TareaModel;
import com.gestion.tarea.persistence.model.TareaStatus;

public interface TareaRepository extends JpaRepository<TareaModel,Long>{
	
	public List<TareaModel> findAllByTareaStatus(TareaStatus status);
	
	@Modifying
	@Query(value="UPDATE prueba_tecnica_empleados.t_tarea SET finished = true WHERE id=:id",nativeQuery= true)
	public void tareaFinished(@Param("id") Long id);

}
