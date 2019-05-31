package com.example.jstore_android_mahdiyusuf;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class ItemFetchRequest extends StringRequest {
    private static final String BASE_URL = GlobalData.getIpAddres() + "/items/";
    public ItemFetchRequest(int id, Response.Listener<String> listener) {
        super(Method.GET, BASE_URL+id, listener, null);
    }
}
