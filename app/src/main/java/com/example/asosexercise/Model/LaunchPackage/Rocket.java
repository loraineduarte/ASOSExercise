package com.example.asosexercise.Model.LaunchPackage;

public class Rocket {

    String rocket_id;
    String rocket_name;
    String rocket_type;
    FirstStage first_stage;
    SecondStage second_stage;
    Fairings fairings;

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }

    public FirstStage getFirst_stage() {
        return first_stage;
    }

    public void setFirst_stage(FirstStage first_stage) {
        this.first_stage = first_stage;
    }

    public SecondStage getSecond_stage() {
        return second_stage;
    }

    public void setSecond_stage(SecondStage second_stage) {
        this.second_stage = second_stage;
    }

    public Fairings getFairings() {
        return fairings;
    }

    public void setFairings(Fairings fairings) {
        this.fairings = fairings;
    }
}
