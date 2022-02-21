package com.madyan.mobiledevelopmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FurnitureDetails extends AppCompatActivity
{
    private TextView furnitureView;
    private TextView furniturePriceView;
    private ImageView furnitureImageView;
    private TextView furnitureDescriptionView;
    private AppCompatButton addCart;
    private AppCompatButton viewAR;
    String furnitureTitle;
    String furniturePrice;
    String furniture_Description;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.furniture_details);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        Furniture furniture = intent.getExtras().getParcelable("FurnitureItem");
        int furnitureimgid = furniture.getFurnitureImageId();
        furnitureTitle = furniture.getFurniture();
        furniturePrice = furniture.getFurniturePrice();
        furniture_Description = furniture.getFurnitureDescription();
        addCart = findViewById(R.id.AddtoCart);
        viewAR = findViewById(R.id.ARButton);
        furnitureView = findViewById(R.id.furnitureName);
        furniturePriceView = findViewById(R.id.furniturePrice);
        furnitureImageView = findViewById(R.id.furnitureImage);
        furnitureDescriptionView = findViewById(R.id.furnitureDescription);

        furnitureDescriptionView.setText(furniture_Description);
        furnitureView.setText(furnitureTitle);
        furniturePriceView.setText("Price including VAT " + furniturePrice);
        furnitureImageView.setImageResource(furniture.getFurnitureImageId());

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(view.getContext(), Cart.class);
                newIntent.putExtra("USERNAME", username);
                LoginActivity.userDB.addToCart(username, furnitureTitle, furnitureimgid);
                startActivity(newIntent);
            }
        });

        viewAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ARscene.class);
                if(furnitureTitle.equals("Office Chair"))
                {
                    intent.putExtra("FURNITURE_TITLE", "Office Chair");
                }
                else if(furnitureTitle.equals("Book Shelf"))
                {
                    intent.putExtra("FURNITURE_TITLE", "Book Shelf");
                }
                else if(furnitureTitle.equals("King size Bed"))
                {
                    intent.putExtra("FURNITURE_TITLE", "King size bed");
                }
                else
                {
                    intent.putExtra("FURNITURE_TITLE", "Desk");
                }
                startActivity(intent);
            }
        });
    }
}
