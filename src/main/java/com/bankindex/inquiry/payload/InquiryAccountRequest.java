package com.bankindex.inquiry.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class InquiryAccountRequest implements PrintJson{
	
    @JsonProperty("BVRequest") 
    private BVRequest bVRequest;
    

}
