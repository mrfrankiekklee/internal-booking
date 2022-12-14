package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.repository.BrokerEntityRepository;
import com.complus.internalbooking.repository.ProductEntityRepository;
import com.complus.internalbooking.repository.TradeEntityRepository;
import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.CreateTradeRequest;
import com.complus.internalbooking.swagger.modal.GenerateReportRequest;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.*;
import java.nio.file.Files;
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

        Product product = productEntityRepository.findById(request.getProductId())
                .orElseThrow(()-> new EntityNotFoundException("Product Not Found"));
        Broker broker = brokerEntityRepository.findById(request.getBrokerId())
                .orElseThrow(()-> new EntityNotFoundException("Broker Not Found"));
        Trade newTrade = new Trade(
                product,
                "T-IRS",
                request.getTradeDate(),
                request.getQty(),
                request.isIsBuy(),
                broker,
                request.getPairs().toString(),
                request.getPrice().toString(),
                request.getExpiryDate()
                );

        Trade savedTrade = tradeEntityRepository.save(newTrade);

        return savedTrade.getId();
    }

    @Override
    public void postGenerateReport(GenerateReportRequest request) throws IOException {

        List<Trade> trades = tradeEntityRepository.findAll();
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]{"tradeRef","productId", "productName", "tradeDate", "qty", "buySell", "price"});
        for(Trade trade : trades){
            dataLines.add(new String[]{
                    trade.getRef(),
                    trade.getProduct().getId(),
                    trade.getPairs() + " " + trade.getProduct().getName() + " Exp" + trade.getExpiry(),
                    Integer.toString(OffsetDateTime.parse (trade.getTradeDate()).getYear())+OffsetDateTime.parse (trade.getTradeDate()).getMonthValue()+OffsetDateTime.parse (trade.getTradeDate()).getDayOfMonth(),
                    trade.getQty().toString(),
                    trade.getBuy() ? "B" : "S",
                    trade.getPrice()
            });
        }

        outputCsv(dataLines);


    }

    public String convertToCSV(String[] data) {
        return Stream.of(data).collect(Collectors.joining(","));
    }

    public void outputCsv(List<String[]> dataLines) throws IOException {
        File csvOutputFile = new File("test.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }
}
