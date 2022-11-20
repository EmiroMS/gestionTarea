package com.gestion.tarea.mapper;

public interface IMapper<I,O> {
	public O map(I in);
}
