package com.bankindex.inquiry.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class InquiryAccountResponse implements PrintJson{
    @JsonProperty("BVResponse") 
    private BVResponse bVResponse;
}