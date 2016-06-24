package com.hemax.jkt.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the msg database table.
 * 
 */
@Entity
@Table(name="msg")
@NamedQuery(name="Msg.findAll", query="SELECT m FROM Msg m")
public class Msg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String account;

	@Column(name="batch_seq_no")
	private String batchSeqNo;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="msg_channel")
	private String msgChannel;

	@Column(name="msg_sp")
	private String msgSp;

	@Column(name="msg_type")
	private int msgType;

	private String params;

	@Column(name="partner_code")
	private String partnerCode;

	@Column(name="product_code")
	private String productCode;

	private String reason;

	@Column(name="seq_no")
	private String seqNo;

	@Column(name="source_system")
	private String sourceSystem;

	private int status;

	@Column(name="template_code")
	private String templateCode;

	private String tunnel;

	@Column(name="tunnel_seq_no")
	private String tunnelSeqNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	@Column(name="user_id")
	private BigInteger userId;

	public Msg() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBatchSeqNo() {
		return this.batchSeqNo;
	}

	public void setBatchSeqNo(String batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMsgChannel() {
		return this.msgChannel;
	}

	public void setMsgChannel(String msgChannel) {
		this.msgChannel = msgChannel;
	}

	public String getMsgSp() {
		return this.msgSp;
	}

	public void setMsgSp(String msgSp) {
		this.msgSp = msgSp;
	}

	public int getMsgType() {
		return this.msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getPartnerCode() {
		return this.partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getSourceSystem() {
		return this.sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTunnel() {
		return this.tunnel;
	}

	public void setTunnel(String tunnel) {
		this.tunnel = tunnel;
	}

	public String getTunnelSeqNo() {
		return this.tunnelSeqNo;
	}

	public void setTunnelSeqNo(String tunnelSeqNo) {
		this.tunnelSeqNo = tunnelSeqNo;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}