package com.mahedi.service;

import com.mahedi.model.Lab;
import com.mahedi.repository.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabService {

    @Autowired
    private LabRepository labRepository;

    public List<Lab> getAllTest(){
        return labRepository.findAll();
    }

    public void save(Lab lab){
        this.labRepository.save(lab);
    }

    public Lab updatetest(long id){
        Optional<Lab> optional=labRepository.findById(id);
        Lab lab=optional.get();
        return lab;
    }
}
