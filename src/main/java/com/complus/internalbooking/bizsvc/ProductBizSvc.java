package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.swagger.modal.CreateTradeRequest;
import com.complus.internalbooking.swagger.modal.GenerateReportRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

// This is for own testing purpose
@Service
public interface ProductBizSvc {

    void addProductToBroker () throws IOException;

}