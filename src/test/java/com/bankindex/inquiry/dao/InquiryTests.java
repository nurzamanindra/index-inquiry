package com.bankindex.inquiry.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankindex.inquiry.model.InquiryAccountInfo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class InquiryTests {

//	@Autowired
//	private GetDataInquiryAccount get;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void printRequest() {
	log.info("Start get Data");
	List<InquiryAccountInfo> data = null;

	try {
//		 get.getData("7307002799");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	log.info("Data -- " + data.get(0).toStringJson());

		
	}
}
