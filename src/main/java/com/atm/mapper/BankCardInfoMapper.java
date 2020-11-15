package com.atm.mapper;

import com.atm.pojo.BankCardInfo;

public interface BankCardInfoMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String bankCardId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	int insert(BankCardInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	int insertSelective(BankCardInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	BankCardInfo selectByPrimaryKey(String bankCardId);

	/**
	 * 根据id和密码查询用户
	 * @param bankCardId
	 * @param password
	 * @return
	 */
	BankCardInfo selectByIdAndPassword(String bankCardId, String password);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(BankCardInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bank_card_info
	 *
	 * @mbg.generated
	 */
	int updateByPrimaryKey(BankCardInfo record);
}