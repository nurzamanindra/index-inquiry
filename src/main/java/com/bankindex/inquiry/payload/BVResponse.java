package com.bankindex.inquiry.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BVResponse implements PrintJson{
    
	@JsonProperty("rrn") 
	private String rrn;
    
    @JsonProperty("pCode") 
    private String pCode;
    
    @JsonProperty("currCode") 
    private String currCode;
    
    @JsonProperty("accNo") 
    private String accNo;
    
    @JsonProperty("branchNo") 
    private String branchNo;
    
    @JsonProperty("accName") 
    private String accName;
    
    @JsonProperty("accStatus") 
    private String accStatus;
    
    @JsonProperty("availableBalance") 
    private String availableBalance;
    
    @JsonProperty("ledgerBalance") 
    private String ledgerBalance;
    
    @JsonProperty("rCode") 
    private String rCode;
    
    @JsonProperty("message") 
    private String message;
    
}