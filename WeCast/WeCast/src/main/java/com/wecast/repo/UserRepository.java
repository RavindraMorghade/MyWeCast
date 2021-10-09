package com.wecast.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecast.request.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmailAndPassword(String email, String password);
	
//@Query("SELECT u FROM User u INNER JOIN Address  ON u.address.id=Address.id WHERE u.address.city= :'city' ")
//List<User> getFriendsSuggestion(@Param("city")String city);
	//select * from user inner join address on user.address_address_id=address.address_id where address.city='Pune'

    @Query("SELECT u FROM User u JOIN Address a ON "+"a.id=u.address WHERE a.city=:city")
	List<User> getFriendsSuggestion(@Param("city")String city);

 //@Query("SELECT u.id, u.name, u.lastName FROM User u JOIN Address a ON "+"a.id=u.address WHERE a.city=:city")

   //@Query(" select * from user where user_id in(4,12,15)")
   @Query("SELECT u FROM User u WHERE u.id in(:userlist)")
   List<User> findAllUsers(@Param("userlist")List<Integer> userlist);
   // List<T> findAllById(Iterable<ID> ids);
}
