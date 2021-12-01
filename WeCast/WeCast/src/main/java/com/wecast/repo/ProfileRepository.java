package com.wecast.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecast.request.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	void save(Optional<Profile> retProfile);

}
