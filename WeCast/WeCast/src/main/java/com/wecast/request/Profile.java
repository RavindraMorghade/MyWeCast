package com.wecast.request;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="profile")
@Builder
public class Profile {
	
	@Id
	@GeneratedValue
	@Column(name="profile_id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="profile_Name")
	private String profileName;
	
	@Column(name="liked_By")
	private int likeBy;
	
	@Column(name="comment_By")
	private int commentBy;
	
	@Column(name="text_Comments")
	private String textComments;

}
