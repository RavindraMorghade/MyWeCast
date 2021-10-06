package com.wecast.request;

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
@Table(name = "messages")
public class Messages {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int sender_id;
	private int recipient_id;

}
