package com.bankindex.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankindex.inquiry.payload.BVResponse;
import com.bankindex.inquiry.payload.InquiryAccountRequest;
import com.bankindex.inquiry.payload.InquiryAccountResponse;
import com.bankindex.inquiry.service.InquiryAccountService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class InquiryAccountController {
	
	@Autowired
	private InquiryAccountService get_inq_acc_svc;
	
	
	@PostMapping("/inquiry/account")
	public ResponseEntity<InquiryAccountResponse> getInquiryAccount(@RequestBody InquiryAccountRequest req){
		log.info("======================START [INQUIRY ACCOUNT]======================================");
		
		log.info("Req --> " + req.toStringJson());
		
		InquiryAccountResponse inquiryAccount = get_inq_acc_svc.getInquiryAccount(req);
		
		log.info("Res --> " + inquiryAccount.toStringJson());

		
		log.info("======================END [INQUIRY ACCOUNT]======================================");
		log.info("\n\n");

		return ResponseEntity.status(200).body(inquiryAccount);
	}
	
	
	
}
