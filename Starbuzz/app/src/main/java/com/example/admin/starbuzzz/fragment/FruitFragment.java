package com.example.admin.starbuzzz.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.adapter.FruitAdapter;
import com.example.admin.starbuzzz.model.Fruit;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FruitFragment extends Fragment {

    ArrayList<Fruit> fruitArrayList = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    FruitAdapter adapter;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_one, container, false);
            ButterKnife.bind(this, view);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("starbuzz", 0);

            fruitArrayList.add(new Fruit("Apple", sharedPreferences.getBoolean("Apple", false)));
            fruitArrayList.add(new Fruit("Banana", sharedPreferences.getBoolean("Banana", false)));
            fruitArrayList.add(new Fruit("Bilberry", sharedPreferences.getBoolean("Bilberry", false)));
            fruitArrayList.add(new Fruit("Blackberry", sharedPreferences.getBoolean("Blackberry", false)));
            fruitArrayList.add(new Fruit("Boysenberry", sharedPreferences.getBoolean("Boysenberry", false)));

            onSetUpRecyclerView(fruitArrayList);
        }

        return view;
    }

    private void onSetUpRecyclerView(ArrayList<Fruit> fruitArrayList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitArrayList, getActivity());
        recyclerView.setAdapter(adapter);
    }

}
