package com.jdbc.jdbcspring.service;

import com.jdbc.newspaperstore.entity.Laptop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface LaptopService {
    public List<Laptop> getAll();
    public Laptop findById(int id);
    public void deleteById(int id);
    public Laptop save(Laptop laptop);

}
