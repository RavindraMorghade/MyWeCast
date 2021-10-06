package com.wecast.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecast.request.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
	
	@Query("SELECT f from Friend f where f.sender_id = :sender_id and f.reciever_id= :reciever_id ")
	Friend acceptFriendRequest(@Param("sender_id") int sender_id, @Param("reciever_id") int reciever_id);
	
	@Query("SELECT f from Friend f where f.sender_id= :user_id or f.reciever_id=:user_id and status ='friend'")
	List<Friend> retriveFriendList(@Param("user_id")int userId);


}
