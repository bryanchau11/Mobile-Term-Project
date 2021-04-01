package com.example.bordeauxien_restaurant;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.bordeauxien_restaurant.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView drinkName, yesGift, yesExpress, price, quantity;


        drinkName = view.findViewById(R.id.drinkNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        yesGift = view.findViewById(R.id.hasGiftWrap);
        yesExpress = view.findViewById(R.id.hasExpressDelivery);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofdrink = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofdrink = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int hasGiftWrap = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_GIFT);
        int hasExpressDelivery = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_EXPRESS);


        String nameofdrink = cursor.getString(name);
        String pricesofdrink = cursor.getString(priceofdrink);
        String quantitysofdrink = cursor.getString(quantityofdrink);
        String yeshasGiftWrap = cursor.getString(hasGiftWrap);
        String yeshasExpressDelivery = cursor.getString(hasExpressDelivery);



        drinkName.setText(nameofdrink);
        price.setText(pricesofdrink);
        yesGift.setText(yeshasGiftWrap);
        yesExpress.setText(yeshasExpressDelivery);
        quantity.setText(quantitysofdrink);





    }
}
