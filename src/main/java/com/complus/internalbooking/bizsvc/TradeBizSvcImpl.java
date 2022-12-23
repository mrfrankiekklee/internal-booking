package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.config.Constants;
import com.complus.internalbooking.repository.BrokerEntityRepository;
import com.complus.internalbooking.repository.ProductEntityRepository;
import com.complus.internalbooking.repository.TradeEntityRepository;
import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.BrokerProduct;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TradeBizSvcImpl implements TradeBizSvc{

    @Autowired
    private TradeEntityRepository tradeEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private BrokerEntityRepository brokerEntityRepository;
    @Override
    public String postCreateTrade(CreateTradeRequest request) {

        //Check if broker exists
        Broker broker = brokerEntityRepository.findById(request.getBrokerId())
                .orElseThrow(()-> new EntityNotFoundException("Broker Not Found"));

        //Check if broker has the product
        BrokerProduct brokerProduct = broker.getBrokerProductSet()
                .stream().filter(p -> p.getProduct().getId().equals(request.getProductId()))
                .findAny()
                .orElseThrow(()-> new EntityNotFoundException("Product does not exist in this Broker"));

        Product product = brokerProduct.getProduct();

        Trade newTrade = new Trade(
                product,
                "T-"+product.getType()+"-"+product.getId(),
                request.getTradeDate(),
                request.getQty(),
                request.isIsBuy(),
                broker,
                request.getPrice().toString()
                );

        Trade savedTrade = tradeEntityRepository.save(newTrade);

        return savedTrade.getId();
    }

    @Override
    public void postGenerateReport(GenerateReportRequest request) throws IOException {


        List<SearchCriteria> criteriaList = new ArrayList<>();
        SearchCriteria s1 = new SearchCriteria("productId", request.getProductId());
        SearchCriteria s2 = new SearchCriteria("brokerId", request.getBrokerId());
        criteriaList.add(s1);
        criteriaList.add(s2);
        if(request.getTradeDate() != null){
            SearchCriteria s3 = new SearchCriteria("tradeDate", request.getTradeDate());
            criteriaList.add(s3);
        }

        Product product = productEntityRepository.findById(request.getProductId())
                .orElseThrow(()-> new EntityNotFoundException("Product Not Found"));

        TradeSpecification spec = new TradeSpecification(criteriaList);

        List<Trade> trades = tradeEntityRepository.findAll(spec);

        String csvName = product.getSubType() + "_" +
                product.getName() + "_" +
                dateFormatter(OffsetDateTime.parse(request.getTradeDate())) +".csv";

        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(Constants.productList);
        for(Trade trade : trades){
            dataLines.add(convertEntityToDTO(trade).toStringArray());
        }
        outputCsv(dataLines, csvName);

    }

    public String dateFormatter (OffsetDateTime date) {
        //20221022
        return Integer.toString(date.getYear())
                +date.getMonthValue()
                +date.getDayOfMonth();
    }
    public TradeDTO convertEntityToDTO(Trade trade) {
        return new TradeDTO(trade.getRef(),
                trade.getProduct().getId(),
                trade.getProduct().getName(),
                dateFormatter(OffsetDateTime.parse(trade.getTradeDate())),
                trade.getQty().toString(),
                trade.getBuy() ? "B" : "S",
                trade.getPrice());
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data).collect(Collectors.joining(","));
    }

    public void outputCsv(List<String[]> dataLines, String csvName) throws IOException {
        File csvOutputFile = new File(csvName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }
}
