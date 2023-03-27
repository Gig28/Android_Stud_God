package com.example.ast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    
    int quantity = 0;
    Spinner spinner;
    ImageView ImageView;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    
    HashMap goodsMap;
    String goodsName;
    double price;
    EditText userNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R. id.editTextTextPersonName);
        createSpinner();
        createMap();

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Клубничное печенье");
        spinnerArrayList.add("Шоколадное печенье");
        spinnerArrayList.add("Овсяное печенье");

        spinnerAdapter = new ArrayAdapter( this, R.layout.spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("Клубничное печенье", 5.0);
        goodsMap.put("Шоколадное печенье", 7.0);
        goodsMap.put("Овсяное печенье", 10.0);
    }

    private void createMap() {
    }

    private void createSpinner() {
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.textView5);
        priceTextView.setText("" + quantity * price + "$");
    }
    public void decreaseQuantity(View view){
        quantity = quantity - 1;
        if (quantity < 0) quantity = 0;
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.textView5);
        priceTextView.setText("" + quantity * price + "$");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        ImageView elementImage = findViewById(R.id.imageView3);
        switch (goodsName) {
            case "Клубничное печенье":
                elementImage.setImageResource(R.drawable.clubporno);
                break;
            case "Шоколадное печенье":
                elementImage.setImageResource(R.drawable.wokolad);
                break;
            case "Овсяное печенье":
                elementImage.setImageResource(R.drawable.oves);
                break;
        }

            TextView priceTextView = findViewById(R.id.textView5);
            priceTextView.setText("" + quantity * price + "$");

    }
        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }

    public void addToCart(View view) {
        Order order = new Order();
        order.userName = userNameEditText.getText().toString();
        Log.d(  "printUserName", order.userName);

        order.goodsName = goodsName;
        Log.d(  "printGoodsName", order.goodsName);

        order.quantity = quantity;
        Log.d(  "printQuantity", "" + order.quantity);
        order.orderPrice = quantity * price;
        Log.d(  "printOrderPrice", "" + order.orderPrice);

        Intent orderINTENT = new Intent(MainActivity.this,OrderActivity.class);
        orderINTENT.putExtra("userNameInent", order.userName);
        orderINTENT.putExtra("GoodsName", order.goodsName);
        orderINTENT.putExtra("Quantity", order.quantity);
        orderINTENT.putExtra("OrderPrice", order.orderPrice);

        startActivity(orderINTENT);
    }
}