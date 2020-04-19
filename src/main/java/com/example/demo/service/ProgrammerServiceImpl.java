package com.example.demo.service;

import com.example.demo.dao.ProgrammerRepository;
import com.example.demo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {


    @Autowired
    ProgrammerRepository programmerRepository;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        programmerRepository.setProgrammerAsString(idKey,programmer);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return programmerRepository.getProgrammerAsString(idKey);
    }

    //list
    @Override
    public void AddToProgrammersList(Programmer programmer) {
        programmerRepository.AddToProgrammersList(programmer);

    }

    @Override
    public List<Programmer> getProgrammersListMembers() {
        return  programmerRepository.getProgrammersListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return programmerRepository.getProgrammersListCount();
    }
}
