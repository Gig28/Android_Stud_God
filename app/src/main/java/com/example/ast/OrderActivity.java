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

        setTitle("Your Order");

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userNameInent");
        String goodsName = orderIntent.getStringExtra("GoodsName");
        int quantity = orderIntent.getIntExtra("Quantity", 0);
        double Price = orderIntent.getDoubleExtra("Price",0);
        double orderPrice = orderIntent.getDoubleExtra("OrderPrice",0);
        TextView orderTextView = findViewById(R.id.textView2);
        orderTextView.setText("Имя клиента: "+ userName + "\n" +
               "Товар: " +  goodsName + "\n" +
               "Кол-во: " + quantity + " шт" +"\n" +
                "Цена за шт: " + Price + "\n" +
                "Итоговая стоимость: " + orderPrice );



    }
}