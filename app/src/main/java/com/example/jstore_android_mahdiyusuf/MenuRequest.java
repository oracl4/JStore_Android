package com.example.jstore_android_mahdiyusuf;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class MenuRequest extends StringRequest {
    private static final String Regis_URL = "http://192.168.0.107:8080/items";

    public MenuRequest(Response.Listener<String> listener) {
        super(Request.Method.GET, Regis_URL, listener, null);
    }
}
