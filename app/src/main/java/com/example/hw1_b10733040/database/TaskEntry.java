package com.example.hw1_b10733040.database;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class TaskEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String deviceName;
    private String address;
    private String info;
    private String rssi;


    @Ignore
    public TaskEntry(String deviceName, String address, String info, String rssi) {
        this.deviceName = deviceName;
        this.address = address;
        this.info = info;
        this.rssi = rssi;
    }

    public TaskEntry(int id, String deviceName, String address, String info, String rssi) {
        this.id = id;
        this.deviceName = deviceName;
        this.address = address;
        this.info = info;
        this.rssi = rssi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

}
