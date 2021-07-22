package com.bankindex.inquiry.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BVRequest implements PrintJson{
	
    private String rrn;
    private String pCode;
    private String currCode;
    private String accNo;
} 