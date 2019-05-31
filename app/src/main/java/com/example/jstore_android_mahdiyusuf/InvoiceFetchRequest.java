package com.example.jstore_android_mahdiyusuf;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class InvoiceFetchRequest extends StringRequest {
    private static final String BASE_URL = GlobalData.getIpAddres() + "/invoice/";
    public InvoiceFetchRequest(int id, Response.Listener<String> listener) {
        super(Method.GET, BASE_URL+id, listener, null);
    }
}