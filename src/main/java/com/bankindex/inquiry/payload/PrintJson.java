package com.bankindex.inquiry.payload;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface PrintJson {
	
	default String toStringJson() {
		try {
			return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
