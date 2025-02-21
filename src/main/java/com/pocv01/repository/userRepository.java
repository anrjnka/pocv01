package com.pocv01.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pocv01.Entity.UserEntity;

public interface userRepository extends  JpaRepository<UserEntity, Long>{
	//List<UserEntity> findById(Long id);
	
	 // Custom query to fetch users by their status (isActive)
    //@Query("SELECT u FROM UserEntity u WHERE u.isActive = ?1")
    //List<UserEntity> findByIsActive(String isActive);

    // Native query to fetch users by userId
    @Query(value = "SELECT * FROM user_entity WHERE user_id = ?1", nativeQuery = true)
    UserEntity findByUserId(String userId);

    // Example of another custom query to fetch users who are active
    @Query(value = "SELECT * FROM user_entity WHERE is_active = 'true'", nativeQuery = true)
    List<UserEntity> findActiveUsers();
    
    @Query("SELECT u FROM UserEntity u WHERE (:isActive IS NULL OR u.isActive = :isActive) AND (:userId IS NULL OR u.userId = :userId)")
    List<UserEntity> findUsersByStatusAndUserId(String isActive, String userId);
	
	//return addUser.save(useEntity);

    // Custom query to delete a user by userId
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_entity WHERE id = ?1", nativeQuery = true)
    void deleteByUserId(Long id);
}