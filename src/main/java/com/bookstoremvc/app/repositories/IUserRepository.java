package com.bookstoremvc.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstoremvc.app.entities.UserEntity;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Integer> {
	public Optional<UserEntity> findByUserName(String userName);
}
