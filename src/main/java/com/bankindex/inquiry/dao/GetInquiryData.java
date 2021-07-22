package com.bankindex.inquiry.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bankindex.inquiry.model.InquiryAccountInfo;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class GetInquiryData {

	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER;

	@Value("${spring.datasource.url}")
	private String URL;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	public List<InquiryAccountInfo> getAccountInfo(String accNo) {
		List<InquiryAccountInfo> response = new ArrayList<InquiryAccountInfo>();

		String query = "SELECT DMACCT, DMBRN, DMSNAM, DMSTAT, DMBLAV, DMBLPB FROM VISIONB.DBAL WHERE DMACCT ='" + accNo
				+ "'";

		try {
			Connection conn = null;

			System.out.println("Connection URL configured... -> " + URL);

			Class.forName(DRIVER);

			System.out.println("Driver loaded... -> " + DRIVER);

			conn = DriverManager.getConnection(URL, username, password);

			System.out.println("Connection created... -> " + conn.toString());

			// ==============logic here===========
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				InquiryAccountInfo info = new InquiryAccountInfo();
				String DMACCT = rs.getString("DMACCT");
				String DMBRN = rs.getString("DMBRN");
				String DMSNAM = rs.getString("DMSNAM");
				String DMSTAT = rs.getString("DMSTAT");
				String DMBLAV = rs.getString("DMBLAV");
				String DMBLPB = rs.getString("DMBLPB");

				info.setDMACCT(DMACCT).setDMBRN(DMBRN).setDMSNAM(DMSNAM).setDMSTAT(DMSTAT).setDMBLAV(DMBLAV)
						.setDMBLPB(DMBLPB);

				response.add(info);

			}

			// ==============logic here===========

			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	}

}
