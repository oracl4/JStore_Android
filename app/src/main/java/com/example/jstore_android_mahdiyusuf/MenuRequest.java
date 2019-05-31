package com.example.jstore_android_mahdiyusuf;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MenuRequest extends StringRequest {
    private static final String BASE_URL = GlobalData.getIpAddres() + "/items";
    private Map<String, String> params;

    public MenuRequest(Response.Listener<String> listener) {
        super(Method.GET, BASE_URL, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}