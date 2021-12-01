package com.wecast.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="likes_and_comments")
public class LikeAndComment {

	@Id
	@GeneratedValue
	@Column(name="like_and_comment_id")
	private int id;
	
	@Column(name="liked_by_id")
	private Integer likedById;
	
	@Column(name="comment_by_id")
	private Integer commentById;
	
	@Column(name="profile_id")
	private Integer profileId;
	
	@Column(name="text_comments")
	private String textComments;
}
