package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.CreateTradeRequest;
import com.complus.internalbooking.swagger.modal.GenerateReportRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface TradeBizSvc {

    Trade postCreateTrade (CreateTradeRequest request);

    void postGenerateReport (GenerateReportRequest request) throws IOException;
}
