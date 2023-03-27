package com.example.ast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userNameInent");
        String goodsName = orderIntent.getStringExtra("GoodsName");
        int quantity = orderIntent.getIntExtra("Quantity", 0);
        double orderPrice = orderIntent.getDoubleExtra("OrderPrice",0);
        TextView orderTextView = findViewById(R.id.textView2);
        orderTextView.setText(userName + "\n" +  goodsName + "\n" + quantity + "\n" + orderPrice);



    }
}