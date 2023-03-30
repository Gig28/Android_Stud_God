package com.example.ast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {" rrgig28@gmail.com "};
    String subject = "Order from Music Shop";
    String emailText;

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

        emailText = "Имя клиента: "+ userName + "\n" +
                "Товар: " +  goodsName + "\n" +
                "Кол-во: " + quantity + " шт" +"\n" +
                "Цена за шт: " + Price + "\n" +
                "Итоговая стоимость: " + orderPrice;

        orderTextView.setText("Имя клиента: "+ userName + "\n" +
               "Товар: " +  goodsName + "\n" +
               "Кол-во: " + quantity + " шт" +"\n" +
                "Цена за шт: " + Price + "\n" +
                "Итоговая стоимость: " + orderPrice );



    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should hanc
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);}
    }
}