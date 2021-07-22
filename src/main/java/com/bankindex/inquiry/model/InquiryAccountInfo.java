package com.bankindex.inquiry.model;

import com.bankindex.inquiry.payload.PrintJson;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class InquiryAccountInfo implements PrintJson{
	
	private String DMACCT;
	private String DMBRN;
	private String DMSNAM;
	private String DMSTAT;
	private String DMBLAV;
	private String DMBLPB;

}
