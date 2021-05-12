package com.example.hw1_b10733040;

import android.os.Parcel;
import android.os.Parcelable;

public class BlueToothData implements Parcelable {

    private String deviceName;
    private String rssi;
    private String deviceByteInfo;
    private String address;

    public BlueToothData(String deviceName, String rssi, String deviceByteInfo, String address) {
        this.deviceName = deviceName;
        this.rssi = rssi;
        this.deviceByteInfo = deviceByteInfo;
        this.address = address;
    }

    protected BlueToothData(Parcel in) {
        deviceName = in.readString();
        rssi = in.readString();
        deviceByteInfo = in.readString();
        address = in.readString();
    }

    public static final Creator<BlueToothData> CREATOR = new Creator<BlueToothData>() {
        @Override
        public BlueToothData createFromParcel(Parcel in) {
            return new BlueToothData(in);
        }

        @Override
        public BlueToothData[] newArray(int size) {
            return new BlueToothData[size];
        }
    };

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getDeviceByteInfo() {
        return deviceByteInfo;
    }

    public void setDeviceByteInfo(String deviceByteInfo) {
        this.deviceByteInfo = deviceByteInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BlueToothData{" +
                "deviceName='" + deviceName + '\'' +
                ", rssi='" + rssi + '\'' +
                ", deviceByteInfo='" + deviceByteInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(deviceName);
        dest.writeString(rssi);
        dest.writeString(deviceByteInfo);
        dest.writeString(address);
    }
}
