package com.sample.projects.myexam.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.projects.myexam.R;
import com.sample.projects.myexam.data.MySharedPreferences;
import com.sample.projects.myexam.databinding.LayoutRvMainRowBinding;
import com.sample.projects.myexam.interfaces.MainInterface;
import com.sample.projects.myexam.model.PersonModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/10/18.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private MainInterface.onClick onClickInterface;
    private List<PersonModel> personModelList;

    public MainAdapter(Context context,
                       List<PersonModel> personModelList,
                       MainInterface.onClick onClickInterface) {
        this.context = context;
        this.personModelList = personModelList;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewHolder vh = new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getLayoutResourceId(), parent, false));
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            final PersonModel model = personModelList.get(position);

            ItemViewHolder vh = (ItemViewHolder) holder;
            vh.getBinding().mTVFirstNameValue.setText(model.getFirstName());
            vh.getBinding().mTVLastNameValue.setText(model.getLastName());
            vh.getBinding().mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickInterface.onItemClick(model);
                }
            });
    }

    @Override
    public int getItemCount() {
        return personModelList == null ? 0 : personModelList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private LayoutRvMainRowBinding binding;

        public ItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LayoutRvMainRowBinding getBinding() {
            return binding;
        }
    }

    public int getLayoutResourceId() {
        return R.layout.layout_rv_main_row;
    }
}
