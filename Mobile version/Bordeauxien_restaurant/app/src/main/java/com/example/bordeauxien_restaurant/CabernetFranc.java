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

public class CabernetFranc extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, drinnkName, winePrice, des;
    CheckBox addToppings, addExtraCream;
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
        addToppings = findViewById(R.id.addExpressDelivery);
        addtoCart = findViewById(R.id.addtocart);
        addExtraCream = findViewById(R.id.addGiftWrap);
        des = findViewById(R.id.descriptioninfo);
        drinnkName.setText("Cabernet Franc");
        imageView.setImageResource(R.drawable.cabernetfranc);
        winePrice.setText("$54 per bottle");
        des.setText(getString(R.string.cabernetfranc));
        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CabernetFranc.this, SummaryActivity.class);
                startActivity(intent);

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 54;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                winePrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = CalculatePrice(addExtraCream, addToppings);
                winePrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 54;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(CabernetFranc.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    winePrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(addExtraCream, addToppings);
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

        if (addExtraCream.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_GIFT, "Gift Wrap: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_GIFT, "Gift Wrap: NO");

        }

        if (addToppings.isChecked()) {
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

    private int CalculatePrice(CheckBox addExtraCream, CheckBox addToppings) {

        int basePrice = 54;

        if (addExtraCream.isChecked()) {
            // add the cream cost $2
            basePrice = basePrice + 2;
        }

        if (addToppings.isChecked()) {
            // topping cost is $3
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
                OrderContract.OrderEntry.COLUMN_QUANTITY
                /* OrderContract.OrderEntry.COLUMN_GIFT,
                 OrderContract.OrderEntry.COLUMN_EXPRESS*/
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
            String yeshasExpressDelivery = cursor.getString(hasExpressDelivery);

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