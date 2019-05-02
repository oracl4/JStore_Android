package com.example.jstore_android_mahdiyusuf;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    private ArrayList<Supplier> listSupplier = new ArrayList<>();
    private ArrayList<Item> listItem = new ArrayList<>();
    private HashMap<Supplier, ArrayList<Item>> childMapping = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        refreshList();
    }

    protected void refreshList() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    for (int i=0; i<jsonResponse.length(); i++) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

                        JSONObject item = jsonResponse.getJSONObject(i);
                        JSONObject supplier = item.getJSONObject("supplier");
                        JSONObject location = supplier.getJSONObject("location");

                        Location newLocation = new Location(
                                location.getString("province"),
                                location.getString("description"),
                                location.getString("city")
                        );

                        Supplier newSupplier = new Supplier(
                                supplier.getInt("id"),
                                supplier.getString("name"),
                                supplier.getString("email"),
                                supplier.getString("phoneNumber"),
                                newLocation
                        );

                        Item newItem = new Item(
                                item.getInt("id"),
                                item.getString("name"),
                                item.getInt("price"),
                                item.getString("category"),
                                item.getString("status"),
                                newSupplier
                        );

                        listItem.add(newItem);

                        //Check if the Supplier already Exists
                        boolean tempStatus = true;
                        for(Supplier supplierPtr : listSupplier) {
                            if(supplierPtr.getId() == newSupplier.getId()){
                                tempStatus = false;
                            }
                        }
                        if(tempStatus==true){
                            listSupplier.add(newSupplier);
                        }
                    }

                    for(Supplier supplierPtr : listSupplier){
                        ArrayList<Item> tempItemList = new ArrayList<>();
                        for(Item itemPtr : listItem){
                            if(itemPtr.getSupplier().getId() == supplierPtr.getId()){
                                tempItemList.add(itemPtr);
                            }
                        }
                        childMapping.put(supplierPtr, tempItemList);
                    }
                    listAdapter = new MainListAdapter(MainActivity.this, listSupplier, childMapping);
                    expListView.setAdapter(listAdapter);
                }
                catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Load Data Failed.").create().show();
                }
            }
        };

        MenuRequest menuRequest = new MenuRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(menuRequest);
    }
}