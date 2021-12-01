package com.wecast.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wecast.request.Apply;
import com.wecast.request.Friend;
import com.wecast.request.LikeAndComment;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {
	
	public List<Apply> findByJobId(int job_id);
	
	//@Query(" select * from apply where jobid=23 and apply_by_user_id=18;")
	//@Query("SELECT f from Friend f where f.sender_id = :sender_id and f.reciever_id= :reciever_id ")
	//Friend acceptFriendRequest(@Param("sender_id") int sender_id, @Param("reciever_id") int reciever_id);
	
	@Query(" SELECT a FROM Apply a WHERE a.jobId =:jobId and a.userId =:userId")
	public Apply findStatus(@Param("jobId") int jobId, @Param("userId") int userId);
	
	
	 //select * from apply where jobId=23 and status='selected';
	 @Query("SELECT a FROM Apply a WHERE a.jobId =:jobId and a.status='selected'")
	 public List<Apply> findSelectedUsers(@Param("jobId") int jobId);
	 

}
