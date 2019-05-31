package com.example.jstore_android_mahdiyusuf;

public class GlobalData {
    private static GlobalData instance;
    private static String ipAddres = "http://192.168.0.104:8080";

    private GlobalData(){}

    public static String getIpAddres() {
        return ipAddres;
    }

    public static void setIpAddres(String ipAddres) {
        GlobalData.ipAddres = ipAddres;
    }

    public static synchronized GlobalData getInstance(){
        if(instance==null){
            instance = new GlobalData();
        }
        return instance;
    }
}
