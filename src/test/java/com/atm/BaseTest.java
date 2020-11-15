/**  
 * @Title: BaseTests.java
 * @Package com.atm
 * @author daluosi
 * @date 2020年6月30日
 * @version V1.0  
 */
package com.atm;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: BaseTest
 * @Description: 测试接口，所有测试类必须实现
 * @author daluosi
 * @date 2020年6月30日
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
// 事务回滚
@Transactional

public class BaseTest {

}
