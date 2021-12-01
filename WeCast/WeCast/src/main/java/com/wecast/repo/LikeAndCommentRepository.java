package com.wecast.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecast.request.LikeAndComment;
import com.wecast.request.User;

@Repository
public interface LikeAndCommentRepository extends JpaRepository<LikeAndComment, Integer> {

	LikeAndComment save(Integer likeById);
	
	 //select * from profile where profile_id=39 and liked_by is not null;
	 @Query("SELECT lc FROM LikeAndComment lc WHERE lc.profileId=:profile_id AND lc.likedById is NOT NULL")
	 public List<LikeAndComment> findLikesOnProfile(@Param("profile_id") Integer profile_id);
	 
	 @Query("SELECT lc FROM LikeAndComment lc WHERE lc.profileId=:profile_id AND lc.commentById is NOT NULL")
	 public List<LikeAndComment> findCommentsOnProfile(@Param("profile_id") Integer profile_id);

}
