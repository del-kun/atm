package com.atm.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class BankCardLog implements Serializable {

    /**
     * 自增主键
     */
    private int id;

    /**
     * 银行卡号
     */
    private String cardId;

    /**
     * 操作方法
     */
    private int enumWay;

    /**
     * 操作金额
     */
    private double money;

    @Override
    public String toString() {
        return "BankCardLog{" +
                "id=" + id +
                ", cardId='" + cardId + '\'' +
                ", enumWay=" + enumWay +
                ", money=" + money +
                ", time=" + time +
                '}';
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * 操作时间
     */
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getEnumWay() {
        return enumWay;
    }

    public void setEnumWay(int enumWay) {
        this.enumWay = enumWay;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
