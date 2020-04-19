package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class Programmer implements Serializable {

   private int id;
   private String company;
   private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programmer)) return false;
        Programmer that = (Programmer) o;
        return id == that.id &&
                Objects.equals(company, that.company) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
