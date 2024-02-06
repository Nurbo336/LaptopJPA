package com.jdbc.jdbcspring.repo;

import com.jdbc.newspaperstore.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository <Laptop,Integer> {

}
