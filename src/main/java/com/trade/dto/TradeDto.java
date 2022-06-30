package com.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeDto {
    private ObjectId _id;
    private String tradeId;
    private int version;
    private String countryPartyId;
    private String bookId;
    private Date maturityDate;
    private Date createdDate;
    private String expired;

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public int getVersion() {
        return version;
    }

    public String getCountryPartyId() {
        return countryPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getExpired() {
        return expired;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCountryPartyId(String countryPartyId) {
        this.countryPartyId = countryPartyId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
}
