package me.proft.fabdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> basket = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ListView lvBasket;
    private Integer counter = 1;

    View.OnClickListener removeProduct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            basket.remove(basket.size() -1);
            adapter.notifyDataSetChanged();
            Snackbar.make(view, "Product removed", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBasket = (ListView) findViewById(R.id.basket);

        basket.add("Product " + counter.toString());
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, basket);
        lvBasket.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++counter;
                basket.add("Product " + counter.toString());
                adapter.notifyDataSetChanged();

                Snackbar.make(view, "Product added to basket", Snackbar.LENGTH_LONG).setAction("Undo", removeProduct).show();
            }
        });

    }
}
