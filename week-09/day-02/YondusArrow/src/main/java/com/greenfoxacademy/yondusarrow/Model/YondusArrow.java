package com.greenfoxacademy.yondusarrow.Model;

import org.springframework.stereotype.Component;

@Component
public class YondusArrow extends RestResponse{
    private double distance;
    private double time;
    private double speed;

    public YondusArrow(double distance, double time) {
        this.distance = distance;
        this.time = time;
        this.speed = distance/time;
    }

    public YondusArrow() {

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
