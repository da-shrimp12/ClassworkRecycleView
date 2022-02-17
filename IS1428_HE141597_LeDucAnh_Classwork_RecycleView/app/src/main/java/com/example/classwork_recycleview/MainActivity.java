package com.example.classwork_recycleview;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoriesAdapter mCategoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mCategoriesAdapter = new CategoriesAdapter(this, getListCategories());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        mCategoriesAdapter.setData(getListCategories());
        recyclerView.setAdapter(mCategoriesAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private List<Categories> getListCategories() {
        List<Categories> list = new ArrayList<>();
        list.add(new Categories(R.drawable.pharmacy, "pharmacy","a shop or part of a shop in which medicines are prepared and sold"));
        list.add(new Categories(R.drawable.registry, "registry","an official record of people or things relating to a business or other activity"));
        list.add(new Categories(R.drawable.carts, "cartwheel","a fast, skillful movement in which you stretch out your arms and throw yourself sideways and upside down onto one, then both, hands with your legs straight and pointing up, before landing on your feet again\n"));
        list.add(new Categories(R.drawable.clothing, "clothing","things you wear to cover your body"));
        list.add(new Categories(R.drawable.sneakers, "shoes","one of a pair of coverings for your feet, usually made of a strong material such as leather, with a thick leather or plastic sole"));
        list.add(new Categories(R.drawable.bags, "accessories","something added to a machine or to clothing that has a useful or decorative purpose"));
        list.add(new Categories(R.drawable.baby, "baby","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        list.add(new Categories(R.drawable.home, "home","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        list.add(new Categories(R.drawable.park, "patio & garden","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        list.add(new Categories(R.drawable.piano, "piano","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        list.add(new Categories(R.drawable.guitar, "guitar","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));
        list.add(new Categories(R.drawable.violin, "violin","Lorem Ipsum is simply dummy text of the printing and typesetting industry. "));

        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCategoriesAdapter != null) {
            mCategoriesAdapter.release();
        }
    }
}