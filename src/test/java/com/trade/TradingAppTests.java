package com.trade;

import com.trade.controller.TradeController;
import com.trade.dto.TradeDto;
import com.trade.service.TradeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(TradeController.class)
class TradingAppTests {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private TradeService service;

    @Test
    public void processTradeTest(){
    	ArrayList<TradeDto> trades = new ArrayList<TradeDto>();
		trades.add(new TradeDto());
		Flux<TradeDto> tradeDtoMono=Flux.just(new TradeDto());
		when(service.processTrades(tradeDtoMono)).thenReturn(tradeDtoMono);
	}

}
