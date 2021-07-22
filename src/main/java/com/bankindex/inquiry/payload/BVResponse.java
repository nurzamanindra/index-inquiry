package com.bankindex.inquiry.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BVResponse implements PrintJson{
    private String rrn;
    private String pCode;
    private String currCode;
    private String accNo;
    private String branchNo;
    private String accName;
    private String accStatus;
    private String availableBalance;
    private String ledgerBalance;
    private String rCode;
    private String message;
    
}