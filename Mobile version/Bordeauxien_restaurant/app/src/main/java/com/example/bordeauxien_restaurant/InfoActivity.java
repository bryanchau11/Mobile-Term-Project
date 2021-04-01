package com.example.bordeauxien_restaurant;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bordeauxien_restaurant.Database.OrderContract;

public class InfoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, drinnkName, winePrice, hasGiftWrap, hasExpressDelivery;
    CheckBox expressDelivery, giftWrap;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        drinnkName = findViewById(R.id.drinkNameinInfo);
        winePrice = findViewById(R.id.winePrice);
        expressDelivery = findViewById(R.id.addExpressDelivery);
        addtoCart = findViewById(R.id.addtocart);
        giftWrap = findViewById(R.id.addGiftWrap);
        hasGiftWrap = findViewById(R.id.hasGiftWrap);
        hasExpressDelivery = findViewById(R.id.hasExpressDelivery);


        drinnkName.setText("Pinot Noir");
        imageView.setImageResource(R.drawable.pinotnoir);
        winePrice.setText("$30 per bottle");
        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, SummaryActivity.class);
                startActivity(intent);

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 30;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                winePrice.setText(setnewPrice);

                int ifCheckBox = CalculatePrice(giftWrap, expressDelivery);
                winePrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 30;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(InfoActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    winePrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(giftWrap, expressDelivery);
                    winePrice.setText("$ " + ifCheckBox);
                }
            }
        });



    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = drinnkName.getText().toString();
        String price = winePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);


        if (giftWrap.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_GIFT, "Gift Wrap: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_GIFT, "Gift Wrap: NO");

        }

        if (expressDelivery.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_EXPRESS, "Express Delivery: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_EXPRESS, "Express Delivery: NO");

        }


        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox giftWrap, CheckBox expressDelivery) {

        int basePrice = 30;

        if (giftWrap.isChecked()) {

            basePrice = basePrice + 2;
        }

        if (expressDelivery.isChecked()) {

            basePrice = basePrice + 3;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_GIFT,
                OrderContract.OrderEntry.COLUMN_EXPRESS
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasGiftWrap = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_GIFT);
            int hasExpressDelivery = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_EXPRESS);


            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);
            String yeshasGiftWrap = cursor.getString(hasGiftWrap);
            String yeshastopping = cursor.getString(hasExpressDelivery);

            drinnkName.setText(nameofdrink);
            winePrice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);

        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        drinnkName.setText("");
        winePrice.setText("");
        quantitynumber.setText("");

    }
}