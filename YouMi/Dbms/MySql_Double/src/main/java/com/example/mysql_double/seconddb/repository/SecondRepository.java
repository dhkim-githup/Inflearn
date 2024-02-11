package com.example.mysql_double.seconddb.repository;

import com.example.mysql_double.seconddb.entity.SecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondRepository extends JpaRepository<SecondEntity, Integer> {
}
