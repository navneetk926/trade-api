package com.trade.utils;

import com.trade.dto.TradeDto;
import com.trade.entity.Trade;
import org.springframework.beans.BeanUtils;

public class AppUtils {


    public static TradeDto entityToDto(Trade product) {
        TradeDto productDto = new TradeDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Trade dtoToEntity(TradeDto productDto) {
        Trade product = new Trade();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
