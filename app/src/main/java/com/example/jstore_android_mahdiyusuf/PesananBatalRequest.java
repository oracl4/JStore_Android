package com.example.jstore_android_mahdiyusuf;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PesananBatalRequest extends StringRequest {
    private static final String REGIS_URL = GlobalData.getIpAddres() + "/canceltransaction";
    private Map<String, String> params;

    public PesananBatalRequest(String id, Response.Listener<String> listener) {
        super(Method.POST, REGIS_URL, listener, null);
        params = new HashMap<>();
        params.put("id",id);
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}