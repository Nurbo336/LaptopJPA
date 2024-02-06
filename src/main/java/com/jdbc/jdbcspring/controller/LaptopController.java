package com.jdbc.jdbcspring.controller;

import com.jdbc.newspaperstore.entity.Laptop;
import com.jdbc.newspaperstore.entity.NewsPaper;
import com.jdbc.newspaperstore.service.LaptopService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }
    @GetMapping
    public List<Laptop> getAllLaptop(){
        return laptopService.getAll();
    }
    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable int id){
        return laptopService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        laptopService.deleteById(id);
    }
    @PostMapping
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return laptopService.save(laptop);
    }
}
