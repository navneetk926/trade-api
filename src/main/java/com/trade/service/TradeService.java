package com.trade.service;

import com.trade.dto.TradeDto;
import com.trade.repository.TradeRepository;
import com.trade.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public Flux<TradeDto> processTrades(Flux<TradeDto> trade){
        trade.groupBy(TradeDto:: getTradeId)
                .flatMap(g-> g.reduce((a,b)-> a.getVersion()> b.getVersion()? a: b))
                .doOnNext(md ->{
                    if(md.getMaturityDate().compareTo(new Date())>0){
                        md.setExpired("N");
                        saveTrades(Mono.just(md));
                    }
                })
                .subscribe(System.out::println);
        return trade;
    }

    public Flux<TradeDto> findAllTrades(){
        return tradeRepository.findAll().map(AppUtils:: entityToDto).doOnComplete(()-> System.out.println("Success"));
    }

    private void saveTrades(Mono<TradeDto> trade){
        trade.map(AppUtils:: dtoToEntity)
                .flatMap(tradeRepository:: insert)
                .doOnError(serverError->
                        System.out.println("Error"));
    }
}
