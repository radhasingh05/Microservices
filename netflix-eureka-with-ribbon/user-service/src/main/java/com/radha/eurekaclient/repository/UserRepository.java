package com.radha.eurekaclient.repository;

import com.radha.eurekaclient.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Override
    <S extends User> S saveAndFlush(S s);

    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    List<User> findAll();
}
