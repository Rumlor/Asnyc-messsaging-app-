package com.sixtyone.server.model;

public abstract class GenericModel<MODEL,DTO> {
	

	protected abstract void mapFromCorrespondingDTO(DTO dtoObject); 
	
	protected abstract DTO mapToCorrespondingDTO();
}
