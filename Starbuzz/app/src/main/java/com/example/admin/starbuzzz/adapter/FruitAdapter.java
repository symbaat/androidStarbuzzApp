package com.example.admin.starbuzzz.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
//import com.bumptech.glide.Glide;
import com.example.admin.starbuzzz.R;
import com.example.admin.starbuzzz.model.Fruit;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ItemHolder> {

    private List<Fruit> fruitList;
    private Context context;

    public FruitAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.bind(fruitList.get(position));
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivStar)
        ImageView ivStar;

        @BindView(R.id.name)
        TextView name;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Fruit fruit) {
            name.setText(fruit.name);

            final SharedPreferences sharedPreferences = context.getSharedPreferences("starbuzz", 0);
            if (sharedPreferences.getBoolean(fruit.getName(), false)) {
                ivStar.setBackgroundResource(R.drawable.ic_star);
            } else {
                ivStar.setBackgroundResource(R.drawable.ic_empty_star);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("starbuzz", 0);

                    if (sharedPreferences.getBoolean(fruit.getName(), false)) {
                        ivStar.setBackgroundResource(R.drawable.ic_empty_star);
                        fruit.setFavourite(false);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(fruit.getName(), false);
                        editor.apply();

                        Log.d("ADA", fruit.getName());

                    } else {
                        ivStar.setBackgroundResource(R.drawable.ic_star);
                        fruit.setFavourite(true);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(fruit.name, true);
                        editor.apply();

                        Log.d("ADA", fruit.getName());
                    }
                }
            });
        }
    }
}
