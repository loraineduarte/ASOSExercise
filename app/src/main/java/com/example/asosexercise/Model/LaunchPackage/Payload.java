package com.example.asosexercise.Model.LaunchPackage;

public class Payload {

    String payload_id;
    String[] norad_id;
    boolean reused;
    String[] customers;
    String nationality;
    String manufacturer;
    String payload_type;
    float payload_mass_kg;
    float payload_mass_lbs;
    String orbit;
    OrbitParams orbit_params;

    public String getPayload_id() {
        return payload_id;
    }

    public void setPayload_id(String payload_id) {
        this.payload_id = payload_id;
    }

    public String[] getNorad_id() {
        return norad_id;
    }

    public void setNorad_id(String[] norad_id) {
        this.norad_id = norad_id;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public String[] getCustomers() {
        return customers;
    }

    public void setCustomers(String[] customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayload_type() {
        return payload_type;
    }

    public void setPayload_type(String payload_type) {
        this.payload_type = payload_type;
    }

    public float getPayload_mass_kg() {
        return payload_mass_kg;
    }

    public void setPayload_mass_kg(float payload_mass_kg) {
        this.payload_mass_kg = payload_mass_kg;
    }

    public float getPayload_mass_lbs() {
        return payload_mass_lbs;
    }

    public void setPayload_mass_lbs(float payload_mass_lbs) {
        this.payload_mass_lbs = payload_mass_lbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbit_params() {
        return orbit_params;
    }

    public void setOrbit_params(OrbitParams orbit_params) {
        this.orbit_params = orbit_params;
    }
}
