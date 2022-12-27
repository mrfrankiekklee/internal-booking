package com.complus.internalbooking.bizsvc;

import com.complus.internalbooking.config.ErrorConstants;
import com.complus.internalbooking.repository.BrokerEntityRepository;
import com.complus.internalbooking.repository.BrokerProductEntityRepository;
import com.complus.internalbooking.repository.ProductEntityRepository;
import com.complus.internalbooking.repository.TradeEntityRepository;
import com.complus.internalbooking.repository.entity.Broker;
import com.complus.internalbooking.repository.entity.BrokerProduct;
import com.complus.internalbooking.repository.entity.Product;
import com.complus.internalbooking.repository.entity.Trade;
import com.complus.internalbooking.swagger.modal.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TradeBizSvcImplTest {

    @Autowired
    private BrokerEntityRepository brokerEntityRepository;
    @Autowired
    BrokerProductEntityRepository brokerProductEntityRepository;
    @Mock
    private TradeEntityRepository tradeEntityRepository;
    private AutoCloseable autoCloseable;
    private TradeBizSvcImpl tradeBizSvcImpl;
    @BeforeEach
    public void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        tradeBizSvcImpl = new TradeBizSvcImpl(tradeEntityRepository, brokerEntityRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void postCreateTrade() {

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

        Broker broker = new Broker("b1",
                "brokerA",
                "2022-10-05T14:48:00.000Z");
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
        TradeDTO tradeDTO = new TradeDTO("T-SWP-p1","p1","5Fix6Flo SWP Exp14Jul2021","20221213","10000","B","1.067591");
        String[] data = tradeDTO.toStringArray();
        String expected = "T-SWP-p1,p1,5Fix6Flo SWP Exp14Jul2021,20221213,10000,B,1.067591";
        assertEquals(expected, tradeBizSvcImpl.convertToCSV(data));

    }

    @Test
    @Disabled
    void postGenerateReport() throws IOException {
        //Aim to compare the result of output csv with expected.
        GenerateReportRequest request = new GenerateReportRequest();
        request.setProductType("SWP");
        request.setProductSubType("Interest_Rate");
        request.setBrokerId("b1");

        tradeBizSvcImpl.postGenerateReport(request);
        List<SearchCriteria> criteriaList = new ArrayList<>();

        TradeSpecification spec = new TradeSpecification(criteriaList);
        verify(tradeEntityRepository).findAll(spec);

    }

    @Test
    void itShouldThrowBrokerNotFound() {
        CreateTradeRequest request = new CreateTradeRequest();
        request.setProductId("p1");
        request.setTradeDate("2022-12-13T07:00:00.000Z");
        request.setIsBuy(true);
        request.setQty(999);
        request.setPrice(BigDecimal.valueOf(1.067591));
        request.setBrokerId("b111");

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            tradeBizSvcImpl.postCreateTrade(request);

        });

        String expectedMessage = ErrorConstants.BROKER_NOT_FOUND;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void itShouldThrowProductNotFound() {
        brokerEntityRepository.save(new Broker(
                "b1",
                "brokerA",
                "2022-10-05T14:48:00.000Z"
        ));

        CreateTradeRequest request = new CreateTradeRequest();
        request.setProductId("p1");
        request.setTradeDate("2022-12-13T07:00:00.000Z");
        request.setIsBuy(true);
        request.setQty(999);
        request.setPrice(BigDecimal.valueOf(1.067591));
        request.setBrokerId("b1");

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            tradeBizSvcImpl.postCreateTrade(request);

        });

        String expectedMessage = ErrorConstants.PRODUCT_NOT_FOUND;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}