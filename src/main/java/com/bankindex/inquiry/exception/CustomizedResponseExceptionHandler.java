package com.bankindex.inquiry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bankindex.inquiry.payload.BVResponse;
import com.bankindex.inquiry.payload.InquiryAccountResponse;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings("rawtypes")
@Log4j2
@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

	public <T> ResponseEntity<T> CustomeExceptions(Exception e) {

		InquiryAccountResponse res = new InquiryAccountResponse();
		BVResponse b = new BVResponse();
		b.setRCode("99")
				.setMessage("Transaksi Gagal!");
		
		log.info("ERROR : " + e.getMessage());
		log.info("\n\n========================END PROCESS ====================================");
		log.info("\n\n");

		return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}

}
