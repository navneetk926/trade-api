package com.trade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trades")
public class Trade {
    @Id
    private String id;
    private String tradeId;
    private int version;
    private String countryPartyId;
    private String bookId;
    private Date maturityDate;
    private Date createdDate;
    private String expired;
}
