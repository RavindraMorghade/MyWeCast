package com.wecast.request;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "friend")
@Builder
public class Friend {

	@Id
	@GeneratedValue
	@Column(name = "friend_id")
	private int id;

	@Column(name = "sender_Id")
	private int sender_id;

	@Column(name = "reciever_id")
	private int reciever_id;

	@Column(name = "status")
	private String status;

	@Column(name = "request_DT")
	private Instant request_DT;

	@Column(name = "accept_DT")
	private Instant accept_DT;

}
