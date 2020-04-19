package com.example.demo.dao;

import com.example.demo.model.Programmer;

import java.util.List;

public interface ProgrammerRepository {

   void setProgrammerAsString(String idKey, String programmer);

   String getProgrammerAsString(String idKey);

   // list
   void AddToProgrammersList(Programmer programmer);

   List<Programmer> getProgrammersListMembers();

   Long getProgrammersListCount();

}
