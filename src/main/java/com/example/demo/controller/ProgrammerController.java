package com.example.demo.controller;

import com.example.demo.model.Programmer;
import com.example.demo.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ProgrammerController {
    @Autowired
    ProgrammerService programmerService;

    // String operations
    @RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
    public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), om.writeValueAsString(programmer));
    }

    @GetMapping("/programmer-string/{id}")
    public String readString(@PathVariable String id) {
     return programmerService.getProgrammerAsString(id);
    }

    // *******************LIST Demo*******************//

    // add programmer to list
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-list")
    public void addToProgrammerList(@RequestBody Programmer programmer) {
        programmerService.AddToProgrammersList(programmer);

    }

    // get all programmers from a list
    @RequestMapping("/programmers-list")
    public List<Programmer> getProgrammerListMembers() {
        return programmerService.getProgrammersListMembers();

    }

    // count all programmers in a list
    @RequestMapping("/programmers-list/count")
    public Long getProgrammerListCount() {
        return programmerService.getProgrammersListCount();

    }
}
