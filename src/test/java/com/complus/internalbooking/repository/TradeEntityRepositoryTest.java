package com.complus.internalbooking.repository;

import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TradeEntityRepositoryTest {

    @Autowired
    private TradeEntityRepository tradeEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private BrokerEntityRepository brokerEntityRepository;

    @BeforeEach
    void init() {

        productEntityRepository.save(new Product(
                "p1",
                "5Fix6Flex SWP Exp14Jul2021",
                "SWP",
                "Interest Rate",
                "2022-10-05T14:48:00.000Z"
        ));
        productEntityRepository.save(new Product(
                "p2",
                "5Fix6Flex SWP Exp14Jul2021",
                "SWP",
                "Currency",
                "2022-10-05T14:48:00.000Z"
        ));
        brokerEntityRepository.save(new Broker(
                "b1",
                "brokerA",
                "2022-10-05T14:48:00.000Z"
        ));


    }

    @Test
    void itShouldCheckIfSave() {
    }

    @Test
    void itShouldCheckIfFindAll() {
        //given
        Product product = productEntityRepository.findById("p1")
                .orElseThrow(()-> new EntityNotFoundException("Product Not Found"));
        Broker broker = brokerEntityRepository.findById("b1")
                .orElseThrow(()-> new EntityNotFoundException("Broker Not Found"));

        Trade trade1 = new Trade(
                product,
                "T-IRS",
                "2022-12-13T07:00:00.000Z",
                10000,
                true,
                broker,
                "1.067591"
        );
        Trade trade2 = new Trade(
                product,
                "T-IRS",
                "2022-12-13T07:00:00.000Z",
                10000,
                true,
                broker,
                "1.067591"
        );
        tradeEntityRepository.save(trade1);
        tradeEntityRepository.save(trade2);

        List<Trade> tradeList = tradeEntityRepository.findAll();

        assertEquals(2, tradeList.size());

    }
}