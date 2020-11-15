package com.atm.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Database Table Remarks: 交易相关表
 *
 * This class was generated by MyBatis Generator. This class corresponds to the
 * database table bank_trans_detail
 */
public class BankTransDetail implements Serializable {
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bank_trans_detail.bank_serial_num
	 *
	 * @mbg.generated
	 */
	private Long bankSerialNum;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bank_trans_detail.bank_card_id
	 *
	 * @mbg.generated
	 */
	private String bankCardId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bank_trans_detail.bank_trans_amount
	 *
	 * @mbg.generated
	 */
	private BigDecimal bankTransAmount;

	/**
	 * Database Column Remarks: 1存款 2取款 3转账 4 信用卡还款 5缴费
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bank_trans_detail.bank_trans_type
	 *
	 * @mbg.generated
	 */
	private Integer bankTransType;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bank_trans_detail.timestamp
	 *
	 * @mbg.generated
	 */
	private Date timestamp;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table bank_trans_detail
	 *
	 * @mbg.generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bank_trans_detail.bank_serial_num
	 *
	 * @return the value of bank_trans_detail.bank_serial_num
	 *
	 * @mbg.generated
	 */
	public Long getBankSerialNum() {
		return bankSerialNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bank_trans_detail.bank_serial_num
	 *
	 * @param bankSerialNum
	 *            the value for bank_trans_detail.bank_serial_num
	 *
	 * @mbg.generated
	 */
	public void setBankSerialNum(Long bankSerialNum) {
		this.bankSerialNum = bankSerialNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bank_trans_detail.bank_card_id
	 *
	 * @return the value of bank_trans_detail.bank_card_id
	 *
	 * @mbg.generated
	 */
	public String getBankCardId() {
		return bankCardId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bank_trans_detail.bank_card_id
	 *
	 * @param bankCardId
	 *            the value for bank_trans_detail.bank_card_id
	 *
	 * @mbg.generated
	 */
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bank_trans_detail.bank_trans_amount
	 *
	 * @return the value of bank_trans_detail.bank_trans_amount
	 *
	 * @mbg.generated
	 */
	public BigDecimal getBankTransAmount() {
		return bankTransAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bank_trans_detail.bank_trans_amount
	 *
	 * @param bankTransAmount
	 *            the value for bank_trans_detail.bank_trans_amount
	 *
	 * @mbg.generated
	 */
	public void setBankTransAmount(BigDecimal bankTransAmount) {
		this.bankTransAmount = bankTransAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bank_trans_detail.bank_trans_type
	 *
	 * @return the value of bank_trans_detail.bank_trans_type
	 *
	 * @mbg.generated
	 */
	public Integer getBankTransType() {
		return bankTransType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bank_trans_detail.bank_trans_type
	 *
	 * @param bankTransType
	 *            the value for bank_trans_detail.bank_trans_type
	 *
	 * @mbg.generated
	 */
	public void setBankTransType(Integer bankTransType) {
		this.bankTransType = bankTransType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bank_trans_detail.timestamp
	 *
	 * @return the value of bank_trans_detail.timestamp
	 *
	 * @mbg.generated
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bank_trans_detail.timestamp
	 *
	 * @param timestamp
	 *            the value for bank_trans_detail.timestamp
	 *
	 * @mbg.generated
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}