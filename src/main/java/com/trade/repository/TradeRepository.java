package com.trade.repository;

import com.trade.dto.TradeDto;
import com.trade.entity.Trade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TradeRepository extends ReactiveMongoRepository<Trade, String> {
    Mono<Trade> insertTrade(Mono<TradeDto> trade);
}
