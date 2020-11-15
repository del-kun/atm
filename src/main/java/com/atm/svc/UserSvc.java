/**  
 * @Title: UserSvc.java
 * @Package com.atm.svc
 * @author daluosi
 * @date 2020年10月24日
 * @version V1.0  
 */
package com.atm.svc;

import java.util.List;
import java.util.Map;

import com.atm.pojo.BankCardInfo;
import com.atm.pojo.BankCardLog;

/**
 * @ClassName: UserSvc
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author daluosi
 * @date 2020年10月24日
 * @since JDK 1.8
 */
public interface UserSvc {

	/**
	 * 
	 * @Title: getUserByUnAndPwd
	 * @Description: 通过用户名和密码获取用户信息
	 * @param map
	 *            用户名和密码
	 * @return 用户信息
	 */
	public BankCardInfo getUserByUnAndPwd(Map<String, String> map);

	public BankCardInfo getUserByCardId(String cardId);

	/**
	 *
	 */
	public boolean saveMoney(BankCardInfo info, BankCardLog cardLog);

	public List<BankCardLog> getRecentLog(String bankCardId);

	public boolean dropMoney(BankCardInfo info, BankCardLog cardLog);

	public boolean changePassword(BankCardInfo info);
}