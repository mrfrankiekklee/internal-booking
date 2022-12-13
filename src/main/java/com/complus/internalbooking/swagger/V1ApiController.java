package com.complus.internalbooking.swagger;

import com.complus.internalbooking.bizsvc.TradeBizSvcImpl;
import com.complus.internalbooking.swagger.modal.CreateTradeRequest;
import com.complus.internalbooking.swagger.modal.CreateTradeResponse;
import com.complus.internalbooking.swagger.modal.GenerateReportRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-09T12:20:30.692Z[GMT]")
@Controller
public class V1ApiController implements V1Api {

    private static final Logger log = LoggerFactory.getLogger(V1ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final TradeBizSvcImpl tradeBizsvcImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(ObjectMapper objectMapper, HttpServletRequest request, TradeBizSvcImpl tradeBizsvcImpl) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.tradeBizsvcImpl = tradeBizsvcImpl;
    }

    public ResponseEntity<CreateTradeResponse> postCreateTrade(@ApiParam(value = "Body for create trade", required=true) @Valid @RequestBody CreateTradeRequest body) {
        String accept = request.getHeader("Accept");
        try {
            String tradeId = tradeBizsvcImpl.postCreateTrade(body);
            CreateTradeResponse createTradeResponse = new CreateTradeResponse();
            createTradeResponse.setTradeId(tradeId);
            return new ResponseEntity<CreateTradeResponse>(createTradeResponse, HttpStatus.OK);
        } catch (ApplicationContextException e) {
            System.out.println(e);
            throw new ApplicationContextException(e.getLocalizedMessage());
        }

    }

    public ResponseEntity<Void> postGenerateReport(@ApiParam(value = "Body for generate trade report", required=true) @Valid @RequestBody GenerateReportRequest body) {
        String accept = request.getHeader("Accept");
        try {
            tradeBizsvcImpl.postGenerateReport(body);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ApplicationContextException e) {
            System.out.println(e);
            throw new ApplicationContextException(e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
