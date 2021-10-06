package com.wecast.request;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="friend")
public class Friend {
	
	@Id
	@GeneratedValue
	@Column(name="friend_id")
	private int id;
	
	@Column(name="sender_Id")
	private int sender_id;
	
	@Column(name="reciever_id")
	private int reciever_id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="request_DT")
	private Instant request_DT;
	
	@Column(name="accept_DT")
	private Instant accept_DT;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	public int getReciever_id() {
		return reciever_id;
	}
	public void setReciever_id(int reciever_id) {
		this.reciever_id = reciever_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Instant getRequest_DT() {
		return request_DT;
	}
	public void setRequest_DT(Instant request_DT) {
		this.request_DT = request_DT;
	}
	public Instant getAccept_DT() {
		return accept_DT;
	}
	public void setAccept_DT(Instant accept_DT) {
		this.accept_DT = accept_DT;
	}
	
	
	
	

}
