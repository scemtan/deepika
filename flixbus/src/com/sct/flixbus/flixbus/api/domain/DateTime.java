package com.sct.flixbus.flixbus.api.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTime {

    private int timestamp;
    private String tz;

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getTz() {
        return this.tz;
    }

    public LocalDateTime getLocalizedDateTime(){
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(this.timestamp), ZoneId.of(this.tz));
    }
}
