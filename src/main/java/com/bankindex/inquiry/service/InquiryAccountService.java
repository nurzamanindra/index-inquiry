package com.bankindex.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankindex.inquiry.dao.GetInquiryData;
import com.bankindex.inquiry.model.InquiryAccountInfo;
import com.bankindex.inquiry.payload.BVRequest;
import com.bankindex.inquiry.payload.BVResponse;
import com.bankindex.inquiry.payload.InquiryAccountRequest;
import com.bankindex.inquiry.payload.InquiryAccountResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class InquiryAccountService {

	@Autowired
	private GetInquiryData get_inquiry_data;

	public InquiryAccountResponse getInquiryAccount(InquiryAccountRequest req) {

		// =========query to database===========
		List<InquiryAccountInfo> accountInfo = get_inquiry_data.getAccountInfo(req.getBVRequest().getAccNo());
		
		if(accountInfo.size()==0) {
			throw new RuntimeException("No Data Found");
		}
		// =====================================
		
		//============mapping response data=====
		InquiryAccountResponse res = mappingResponse(req,accountInfo);
		log.info("get InquiryAccountResponse -- " + res.toStringJson());
		//======================================

		return res;
	}

	private InquiryAccountResponse mappingResponse(InquiryAccountRequest req, List<InquiryAccountInfo> accInfo) {
		InquiryAccountResponse res = new InquiryAccountResponse();
		BVRequest breq = req.getBVRequest();

		BVResponse b = new BVResponse();
		b.setRrn(breq.getRrn()).setPCode(breq.getPCode()).setCurrCode(breq.getCurrCode()).setRCode("00")
				.setMessage("Transaksi Berhasil");


		if(accInfo.size()==0) {
			res.setBVResponse(b);
			return res;
		}
		
		InquiryAccountInfo inq_data = accInfo.get(0);
		log.info("get accountInfo -- " + inq_data.toStringJson());

		b.setAccNo(inq_data.getDMACCT()).setBranchNo(inq_data.getDMBRN())
			.setAccName(inq_data.getDMSNAM().trim()).setAccStatus(inq_data.getDMSTAT())
				.setAvailableBalance(inq_data.getDMBLAV()).setLedgerBalance(inq_data.getDMBLPB());
			
		res.setBVResponse(b);

		return res;
	}

}
