package com.example.jstore_android_mahdiyusuf;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class HistoryRequest extends StringRequest {
    private static final String HISTORY_URL = GlobalData.getIpAddres() + "/invoicehistorycust/";

    public HistoryRequest(int id_customer, Response.Listener<String> listener) {
        super(Method.GET, HISTORY_URL+id_customer, listener, null);
        Log.d("", "History Request: "+id_customer);
    }
}