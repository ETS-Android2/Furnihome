package com.madyan.mobiledevelopmentproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cart extends AppCompatActivity
{
    ListView cartList;
    ArrayList<Furniture> itemsInCart;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        cartList = findViewById(R.id.cartList);
        itemsInCart = LoginActivity.userDB.getCartItems(getIntent().getStringExtra("USERNAME"));
        FurnitureAdapter adapter = new FurnitureAdapter(this, R.layout.list_item, itemsInCart);
        cartList.setAdapter(adapter);
    }
}
