package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.config.Constants;
import com.complus.internalbooking.config.ErrorConstants;
import com.complus.internalbooking.repository.BrokerEntityRepository;
import com.complus.internalbooking.repository.ProductEntityRepository;
import com.complus.internalbooking.repository.TradeEntityRepository;
import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.BrokerProduct;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public TradeBizSvcImpl(TradeEntityRepository tradeEntityRepository, BrokerEntityRepository brokerEntityRepository) {
        this.tradeEntityRepository = tradeEntityRepository;
        this.brokerEntityRepository = brokerEntityRepository;
    }
    @Override
    public Trade postCreateTrade(CreateTradeRequest request) throws EntityNotFoundException{

        //Check if broker exists
        Broker broker = brokerEntityRepository.findById(request.getBrokerId())
                .orElseThrow(()-> new EntityNotFoundException(ErrorConstants.BROKER_NOT_FOUND));

        //Check if broker has the product
        BrokerProduct brokerProduct = broker.getBrokerProductSet()
                .stream().filter(p -> p.getProduct().getId().equals(request.getProductId()))
                .findAny()
                .orElseThrow(()-> new EntityNotFoundException(ErrorConstants.PRODUCT_NOT_FOUND));

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

        return savedTrade;
    }

    @Override
    public void postGenerateReport(GenerateReportRequest request) throws IOException {


        List<SearchCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(new SearchCriteria("type", request.getProductType()));
        criteriaList.add(new SearchCriteria("subType", request.getProductSubType()));
        criteriaList.add(new SearchCriteria("brokerId", request.getBrokerId()));
        if(request.getTradeDate() != null){
            criteriaList.add(new SearchCriteria("tradeDate", request.getTradeDate()));
        }

        TradeSpecification spec = new TradeSpecification(criteriaList);

        List<Trade> trades = tradeEntityRepository.findAll(spec);

        String csvName = request.getProductSubType() + "_" +
                request.getProductType() + "_" +
                request.getBrokerId() +
                (request.getTradeDate() != null ?
                        "_" + dateFormatter(OffsetDateTime.parse(request.getTradeDate()))
                        : "") + ".csv";

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
