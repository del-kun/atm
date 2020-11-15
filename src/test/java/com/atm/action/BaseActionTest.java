/**  
 * @Title: BaseActionTest.java
 * @Package com.atm.action
 * @author daluosi
 * @date 2020年10月20日
 * @version V1.0  
 */
package com.atm.action;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atm.BaseTest;

/**
 * @ClassName: BaseActionTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author daluosi
 * @date 2020年10月20日
 * @since JDK 1.8
 */
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BaseActionTest extends BaseTest {

}
