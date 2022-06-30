package com.trade.controller;

import com.trade.dto.TradeDto;
import com.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @Autowired
    private TradeService service;

    @PostMapping("/processTrades")
    public Flux<TradeDto> processTrades(Flux<TradeDto> trade){
        return service.processTrades(trade);
    }

    @GetMapping("/getAllTrades")
    public Flux<TradeDto> getAllTrades(){
        return service.findAllTrades();
    }
}
