/**  
 * @Title: UserSvcTest.java
 * @Package com.atm.svc
 * @author daluosi
 * @date 2020年10月24日
 * @version V1.0  
 */
package com.atm.svc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.atm.pojo.BankCardInfo;
import org.junit.Test;

import com.atm.BaseTest;
import com.atm.pojo.BankUserDetail;

/**
 * @ClassName: UserSvcTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author daluosi
 * @date 2020年10月24日
 * @since JDK 1.8
 */
public class UserSvcTest extends BaseTest {

	@Resource
	private UserSvc userSvc;

	@Test
	public void getUserByUnAndPwdTest() {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("username", "10000");
		paramMap.put("pwd", "111111");
		BankCardInfo bankUserDetail = userSvc.getUserByUnAndPwd(paramMap);
		assertNotNull(bankUserDetail);
	}
}
