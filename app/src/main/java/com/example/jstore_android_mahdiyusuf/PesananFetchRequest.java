package com.example.jstore_android_mahdiyusuf;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


public class PesananFetchRequest extends StringRequest {
    private static final String REGIS_URL = GlobalData.getIpAddres() + "/invoicecustomer/";

    public PesananFetchRequest(int id_customer, Response.Listener<String> listener) {
        super(Method.GET, REGIS_URL+id_customer, listener, null);
        Log.d("", "PesananFetchRequest: "+id_customer);
    }
}