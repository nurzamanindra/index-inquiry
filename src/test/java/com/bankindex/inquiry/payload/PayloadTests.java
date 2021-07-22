package com.bankindex.inquiry.payload;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class PayloadTests {

	
	@Test
	void contextLoads() {
	}
	
	@Test
	void printRequest() {
		InquiryAccountRequest req = new InquiryAccountRequest();
		BVRequest b = new BVRequest();
		b.setAccNo("test").setCurrCode("test")
			.setPCode("test")
				.setRrn("teset");
				
		req.setBVRequest(b);
		
		log.info("Request --> " + req.toStringJson());
		
	}
}
