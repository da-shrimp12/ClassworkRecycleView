package com.example.classwork_recycleview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private Context mContext;
    private List<Categories> mListCategories;

    public CategoriesAdapter(Context mContext, List<Categories> mListCategories) {
        this.mContext = mContext;
        this.mListCategories = mListCategories;
    }

    public void setData(List<Categories> list) {
        this.mListCategories = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = mListCategories.get(position);
        if (categories == null) {
            return;
        }
        holder.image.setImageResource(categories.getResourceImage());
        holder.tvName.setText(categories.getName());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail(categories);
            }
        });
    }

    private void onClickGoToDetail(Categories categories) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_categories", categories);
        intent.putExtras(bundle);
        mContext.startActivity(intent);

    }

    public void release() {
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if (mListCategories != null) {
            return mListCategories.size();
        }
        return 0;
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {

        private CardView layoutItem;
        private ImageView image;
        private TextView tvName;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutItem = itemView.findViewById(R.id.layout_item);
            image = itemView.findViewById(R.id.image);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
