/**  
 * @Title: UserAction.java
 * @Package com.atm.action
 * @author daluosi
 * @date 2020年10月20日
 * @version V1.0  
 */
package com.atm.action;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.atm.pojo.BankCardInfo;
import com.atm.pojo.BankCardLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.atm.pojo.BankUserDetail;
import com.atm.svc.UserSvc;

/**
 * @ClassName: UserAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author daluosi
 * @date 2020年10月20日
 * @since JDK 1.8
 */
@RestController
public class UserAction {

	private static final Logger log = LoggerFactory.getLogger(UserAction.class);

	@Resource
	private UserSvc UserSvc;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}

	@GetMapping("/save")
	public ModelAndView save() {
		ModelAndView view = new ModelAndView();
		view.setViewName("deposit");
		return view;
	}

	;

	/**
	 * @param session
	 * @return
	 * @Title: validateUser
	 * @Description: 验证用户登录信息
	 */
	@PostMapping("vu")
	public Map<String, String> validateUser(@RequestParam Map<String, String> paramMap, HttpSession session) {
		log.info("登录参数{}", paramMap);
		BankCardInfo bankCardInfo = UserSvc.getUserByUnAndPwd(paramMap);
		Map<String, String> resultMap = new HashMap<>();

		// 判断是否为空，空则用户名或密码错误
		if (bankCardInfo == null) {
			resultMap.put("status", "0");
			return resultMap;
		}
		session.setAttribute("user", bankCardInfo);
		resultMap.put("status", "1");
		return resultMap;
	}

	@GetMapping("main")
	public ModelAndView main() {
		ModelAndView view = new ModelAndView();
		view.setViewName("main");
		return view;
	}


	@GetMapping("balance")
	public ModelAndView balance() {
		ModelAndView view = new ModelAndView();
		view.setViewName("balance");
		return view;
	}

	@GetMapping("drop")
	public ModelAndView drop(){
		ModelAndView view = new ModelAndView();
		view.setViewName("withdraw");
		return view;
	}

	@GetMapping("log")
	public ModelAndView getlog() {
		ModelAndView view = new ModelAndView();
		view.setViewName("bill");
		return view;
	}

	@GetMapping("pwd")
	public ModelAndView pwd() {
		ModelAndView view = new ModelAndView();
		view.setViewName("changePwd");
		return view;
	}

	@GetMapping("trans")
	public ModelAndView trans() {
		ModelAndView view = new ModelAndView();
		view.setViewName("transferAccounts");
		return view;
	}

	@GetMapping("gu")
	public Map<String, Object> getUser(HttpSession session) {
		BankCardInfo bankCardInfo = (BankCardInfo) session.getAttribute("user");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "1");
		resultMap.put("user", bankCardInfo);
		return resultMap;
	}

	@GetMapping("moneyGet")
	public Map<String, Object> getMoney(HttpSession session) {
		BankCardInfo bankCardInfo = (BankCardInfo) session.getAttribute("user");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("leftMoney", bankCardInfo.getBankMoney());
		resultMap.put("leftlimit", bankCardInfo.getBankCreditLimit());
		return resultMap;
	}

	@RequestMapping("saveMoney")
	public Map<String, Object> saveMoney(@RequestParam Map<String, Object> paramMap, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		//格式检验
		if (Integer.parseInt((String) paramMap.get("money"))  % 100 != 0) {
			resultMap.put("status", false);
			return resultMap;
		}
		//存储
		BankCardInfo newInfo = (BankCardInfo) session.getAttribute("user");
		newInfo.setBankMoney(newInfo.getBankMoney().add(BigDecimal.valueOf(Double.parseDouble((String) paramMap.get("money")) )));
		session.setAttribute("user", newInfo);
		BankCardLog loging = new BankCardLog();
		loging.setEnumWay(1);
		loging.setCardId(newInfo.getBankCardId());
		loging.setMoney(Double.parseDouble((String) paramMap.get("money")));
		loging.setTime(LocalDateTime.now());
		boolean flag = UserSvc.saveMoney(newInfo, loging);

		resultMap.put("status", flag);
		return resultMap;
	}

	@RequestMapping("/getlog")
	public Map<String, Object> getLog(HttpSession session) {
		HashMap<String, Object> resultMap = new HashMap<>();
		BankCardInfo info = (BankCardInfo) session.getAttribute("user");
		resultMap.put("data", UserSvc.getRecentLog(info.getBankCardId()));
		return resultMap;
	}

	@RequestMapping("/dropMoney")
	public Map<String, Object> dropMoney (@RequestParam Map<String, Object> paramMap, HttpSession session){
		Map<String, Object> resultMap = new HashMap<>();
		BankCardInfo newInfo = (BankCardInfo) session.getAttribute("user");
		newInfo.setBankMoney(newInfo.getBankMoney().subtract(BigDecimal.valueOf(Double.parseDouble((String) paramMap.get("money")) )));
		session.setAttribute("user", newInfo);
		BankCardLog loging = new BankCardLog();
		loging.setEnumWay(0);
		loging.setCardId(newInfo.getBankCardId());
		loging.setMoney(Double.parseDouble((String) paramMap.get("money")));
		loging.setTime(LocalDateTime.now());
		boolean flag = UserSvc.dropMoney(newInfo, loging);
		resultMap.put("status", flag);
		return resultMap;
	}
	@RequestMapping("/changePassword")
	public Map<String, Object> changePassword(@RequestParam Map<String, Object> paramMap,HttpSession session){
		Map<String, Object> resultMap = new HashMap<>();
		BankCardInfo newInfo = (BankCardInfo) session.getAttribute("user");
		newInfo.setBankCardPassword((String) paramMap.get("password"));
		session.setAttribute("user",newInfo);
		boolean flag = UserSvc.changePassword(newInfo);
		resultMap.put("status", flag);
		return resultMap;
	}

	@RequestMapping("/transfer")
	public Map<String, Object> transfer(@RequestParam Map<String, Object> paramMap,HttpSession session){
		Map<String, Object> resultMap = new HashMap<>();
		BankCardInfo newInfo = (BankCardInfo) session.getAttribute("user");

		String getCardId = (String) paramMap.get("cardId");
		BankCardInfo waitCardInfo = UserSvc.getUserByCardId(getCardId);
		//原账户支出
		double money = Double.parseDouble((String) paramMap.get("money"));
		newInfo.setBankMoney(newInfo.getBankMoney().subtract(BigDecimal.valueOf(money)));
		session.setAttribute("user", newInfo);
		BankCardLog loging = new BankCardLog();
		loging.setEnumWay(0);
		loging.setCardId(newInfo.getBankCardId());
		loging.setMoney(Double.parseDouble((String) paramMap.get("money")));
		loging.setTime(LocalDateTime.now());
		UserSvc.dropMoney(newInfo, loging);
		//新账户收入
		waitCardInfo.setBankMoney(waitCardInfo.getBankMoney().add(BigDecimal.valueOf(money) ));
		loging.setEnumWay(1);
		loging.setCardId(waitCardInfo.getBankCardId());
		loging.setMoney(Double.parseDouble((String) paramMap.get("money")));
		loging.setTime(LocalDateTime.now());
		UserSvc.saveMoney(newInfo,loging);
		resultMap.put("status",true);
		return resultMap;
	}
}
