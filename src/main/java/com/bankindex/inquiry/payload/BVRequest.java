package com.bankindex.inquiry.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BVRequest implements PrintJson{
    
	@JsonProperty("rrn") 
    private String rrn;
	
    @JsonProperty("pCode") 
    private String pCode;
    
    @JsonProperty("currCode") 
    private String currCode;
    
    @JsonProperty("accNo") 
    private String accNo;
} 