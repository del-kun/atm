/**  
 * @Title: UserSvcImpl.java
 * @Package com.atm.svc.impl
 * @author daluosi
 * @date 2020年10月24日
 * @version V1.0  
 */
package com.atm.svc.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.atm.mapper.BankCardInfoMapper;
import com.atm.mapper.BankCardLogMapper;
import com.atm.pojo.BankCardInfo;
import com.atm.pojo.BankCardLog;
import org.springframework.stereotype.Service;

import com.atm.svc.UserSvc;

/**
 * @ClassName: UserSvcImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author daluosi
 * @date 2020年10月24日
 * @since JDK 1.8
 */
@Service
public class UserSvcImpl implements UserSvc {

	@Resource
	private BankCardInfoMapper mapper;

	@Resource
	private BankCardLogMapper logMapper;
	@Override
	public BankCardInfo getUserByUnAndPwd(Map<String, String> map) {
		BankCardInfo resultInfo = mapper.selectByIdAndPassword(map.get("username"),map.get("pwd"));
		return resultInfo;
	}

	@Override
	public BankCardInfo getUserByCardId(String cardId) {
		BankCardInfo resultInfo = mapper.selectByPrimaryKey(cardId);
		return resultInfo;
	}

	@Override
	public boolean saveMoney(BankCardInfo info, BankCardLog cardLog) {
		logMapper.insertLog(cardLog);
		return mapper.updateByPrimaryKey(info)>0;
	}

	@Override
	public List<BankCardLog> getRecentLog(String bankCardId) {
		List<BankCardLog> logs = logMapper.selectLogList(bankCardId);
		return logs;
	}

	@Override
	public boolean dropMoney(BankCardInfo info, BankCardLog cardLog) {
		logMapper.insertLog(cardLog);
		return mapper.updateByPrimaryKey(info)>0;
	}

	public boolean changePassword(BankCardInfo info){
		return mapper.updateByPrimaryKey(info)>0;
	}

}
