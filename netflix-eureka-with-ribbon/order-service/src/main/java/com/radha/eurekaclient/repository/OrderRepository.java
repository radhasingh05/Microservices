package com.radha.eurekaclient.repository;

import com.radha.eurekaclient.core.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Override
    <S extends Orders> S save(S s);

    @Override
    Optional<Orders> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    List<Orders> findAll();
}
