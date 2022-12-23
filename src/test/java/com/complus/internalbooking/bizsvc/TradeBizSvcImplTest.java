package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.repository.TradeEntityRepository;
import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.TradeDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TradeBizSvcImplTest {

//    private TradeEntityRepository tradeEntityRepository;
    private TradeBizSvcImpl tradeBizSvcImpl;

    @BeforeClass
    public static void instantiate() {
//        tradeBizSvcImpl = new TradeBizSvcImpl();
    }

    @BeforeEach
    public void setUp() {
        tradeBizSvcImpl = new TradeBizSvcImpl();
    }
    @Test
    void dateFormatter() {
        OffsetDateTime dateTime = OffsetDateTime.parse("2022-10-22T07:00:00.000Z");
        assertEquals("20221022", tradeBizSvcImpl.dateFormatter(dateTime));
    }

    @Test
    void convertEntityToDTO() {
        Product product = new Product("p1",
                "5Fix6Flo SWP Exp14Jul2021",
                "SWP",
                "Interest_Rate",
                "2022-10-05T14:48:00.000Z");

        Broker broker = new Broker("b1", "brokerA", "2022-10-05T14:48:00.000Z");
        Trade trade1 = new Trade(
                product,
                "T-SWP-p1",
                "2022-12-13T07:00:00.000Z",
                10000,
                true,
                broker,
                "1.067591"
        );

        TradeDTO expected = new TradeDTO("T-SWP-p1","p1","5Fix6Flo SWP Exp14Jul2021","20221213","10000","B","1.067591");
        assertThat(tradeBizSvcImpl.convertEntityToDTO(trade1)).usingRecursiveComparison().isEqualTo(expected);


    }

    @Test
    void convertToCSV() {
    }

    @Test
    void outputCsv() {
    }
}