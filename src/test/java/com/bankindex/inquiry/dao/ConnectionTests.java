package com.bankindex.inquiry.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankindex.inquiry.model.InquiryAccountInfo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ConnectionTests {


	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER;
	
	@Value("${spring.datasource.url}")
	private String URL;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void printRequest() {

    try {

        log.info("Properties file loaded... \n");
        String test = "test";
        log.info("SELECT DMACCT, DMBRN, DMSNAM, DMSTAT, DMBLAV, DMBLPB FROM VISIONB.DBAL WHERE DMACCT ='"+test+"'");
//        String DRIVER = "com.ibm.as400.access.AS400JDBCDriver";
//        String URL = "jdbc:as400://" + props.getProperty("server").trim() + ";naming=system;errors=full";
        Connection conn = null;

        System.out.println("Connection URL configured... -> " + URL);

        // Connect to iSeries
        Class.forName(DRIVER);

        System.out.println("Driver loaded... -> " + DRIVER);

        conn = DriverManager.getConnection(URL, username, password);

        System.out.println("Connection created... -> " + conn.toString());

        conn.close();

    } catch (Exception e) {
        System.out.println(e);
    }
		
	}
}
