package com.example.asosexercise.Model;

import java.sql.Array;
import java.util.ArrayList;

public class CompanyModel {
    String name;
    String founder;
    Integer founded;
    Integer employees;
    Integer vehicles;
    Integer launch_sites;
    Integer test_sites;
    String ceo;
    String cto;
    String coo;
    String cto_propulsion;
    Float valuation;
    Headquarters headquarters;
    String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Integer getVehicles() {
        return vehicles;
    }

    public void setVehicles(Integer vehicles) {
        this.vehicles = vehicles;
    }

    public Integer getLaunch_sites() {
        return launch_sites;
    }

    public void setLaunch_sites(Integer launch_sites) {
        this.launch_sites = launch_sites;
    }

    public Integer getTest_sites() {
        return test_sites;
    }

    public void setTest_sites(Integer test_sites) {
        this.test_sites = test_sites;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getCto() {
        return cto;
    }

    public void setCto(String cto) {
        this.cto = cto;
    }

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getCto_propulsion() {
        return cto_propulsion;
    }

    public void setCto_propulsion(String cto_propulsion) {
        this.cto_propulsion = cto_propulsion;
    }

    public Float getValuation() {
        return valuation;
    }

    public void setValuation(Float valuation) {
        this.valuation = valuation;
    }

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public class Headquarters {
        String address;
        String city;
        String state;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

}
