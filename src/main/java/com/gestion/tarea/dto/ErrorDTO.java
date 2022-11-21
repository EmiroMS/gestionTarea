package com.gestion.tarea.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
	private String code;
	private String message;
	
}
