package com.jdbc.jdbcspring.service.impl;

import com.jdbc.newspaperstore.entity.Laptop;
import com.jdbc.newspaperstore.repo.LaptopRepo;
import com.jdbc.newspaperstore.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LaptopImpl implements LaptopService {
    private final LaptopRepo laptopRepo;
    @Override
    public List<Laptop> getAll() {
        return laptopRepo.findAll();
    }

    @Override
    public Laptop findById(int id) {
        return laptopRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        laptopRepo.deleteById(id);
    }

    @Override
    public Laptop save(Laptop laptopRequest) {
        Laptop laptop = new Laptop();
        laptop.setModel(laptopRequest.getModel());
        laptop.setBrand(laptopRequest.getBrand());
        laptop.setPrice(laptopRequest.getPrice());
//        byte[] laptopPhoto = Base64.getDecoder().decode(laptopRequest.getLaptopPhoto());

        byte[] laptopPhoto = laptopRequest.getLaptopPhoto();
        if (laptopPhoto != null) {
            String base64EncodedPhoto = encodeToBase64(laptopPhoto);
            laptop.setLaptopPhoto(base64EncodedPhoto.getBytes());
        } else {
            laptop.setLaptopPhoto(null);
        }

        return laptopRepo.save(laptop);
    }

    private String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}

