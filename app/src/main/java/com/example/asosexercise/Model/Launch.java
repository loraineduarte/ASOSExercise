package com.example.asosexercise.Model;

import com.example.asosexercise.Model.LaunchPackage.LaunchFailureDetails;
import com.example.asosexercise.Model.LaunchPackage.LaunchSite;
import com.example.asosexercise.Model.LaunchPackage.Links;
import com.example.asosexercise.Model.LaunchPackage.Rocket;
import com.example.asosexercise.Model.LaunchPackage.Telemetry;
import com.example.asosexercise.Model.LaunchPackage.Timeline;

import java.util.Date;

public class Launch {
    int flight_number;
    String mission_name;
    String[] mission_id;
    boolean upcoming;
    int launch_year;
    int launch_date_unix;
    Date launch_date_utc;
    Date launch_date_local;
    boolean is_tentative;
    String tentative_max_precision;
    boolean tbd;
    int launch_window;
    Rocket rocket;
    String[] ships;
    Telemetry telemetry;
    LaunchSite launch_site;
    boolean launch_success;
    LaunchFailureDetails launch_failure_details;
    Links links;
    String details;
    Date static_fire_date_utc;
    int static_fire_date_unix;
    Timeline timeline;

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String[] getMission_id() {
        return mission_id;
    }

    public void setMission_id(String[] mission_id) {
        this.mission_id = mission_id;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public int getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(int launch_year) {
        this.launch_year = launch_year;
    }

    public int getLaunch_date_unix() {
        return launch_date_unix;
    }

    public void setLaunch_date_unix(int launch_date_unix) {
        this.launch_date_unix = launch_date_unix;
    }

    public Date getLaunch_date_utc() {
        return launch_date_utc;
    }

    public void setLaunch_date_utc(Date launch_date_utc) {
        this.launch_date_utc = launch_date_utc;
    }

    public Date getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(Date launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public boolean isIs_tentative() {
        return is_tentative;
    }

    public void setIs_tentative(boolean is_tentative) {
        this.is_tentative = is_tentative;
    }

    public String getTentative_max_precision() {
        return tentative_max_precision;
    }

    public void setTentative_max_precision(String tentative_max_precision) {
        this.tentative_max_precision = tentative_max_precision;
    }

    public boolean isTbd() {
        return tbd;
    }

    public void setTbd(boolean tbd) {
        this.tbd = tbd;
    }

    public int getLaunch_window() {
        return launch_window;
    }

    public void setLaunch_window(int launch_window) {
        this.launch_window = launch_window;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String[] getShips() {
        return ships;
    }

    public void setShips(String[] ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunch_site() {
        return launch_site;
    }

    public void setLaunch_site(LaunchSite launch_site) {
        this.launch_site = launch_site;
    }

    public boolean isLaunch_success() {
        return launch_success;
    }

    public void setLaunch_success(boolean launch_success) {
        this.launch_success = launch_success;
    }

    public LaunchFailureDetails getLaunch_failure_details() {
        return launch_failure_details;
    }

    public void setLaunch_failure_details(LaunchFailureDetails launch_failure_details) {
        this.launch_failure_details = launch_failure_details;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getStatic_fire_date_utc() {
        return static_fire_date_utc;
    }

    public void setStatic_fire_date_utc(Date static_fire_date_utc) {
        this.static_fire_date_utc = static_fire_date_utc;
    }

    public int getStatic_fire_date_unix() {
        return static_fire_date_unix;
    }

    public void setStatic_fire_date_unix(int static_fire_date_unix) {
        this.static_fire_date_unix = static_fire_date_unix;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
}
