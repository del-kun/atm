package com.atm.mapper;

import com.atm.pojo.BankCardLog;

import java.util.List;

public interface BankCardLogMapper {
    /**
     * 插入记录
     * @param log
     * @return
     */
    int insertLog(BankCardLog log);

    List<BankCardLog> selectLogList(String cardId);
}
