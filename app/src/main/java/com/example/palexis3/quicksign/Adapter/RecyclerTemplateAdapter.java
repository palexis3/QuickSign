package com.example.palexis3.quicksign.Adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.palexis3.quicksign.Models.SectionTemplates;
import com.example.palexis3.quicksign.Models.Templates;
import com.example.palexis3.quicksign.R;

import java.util.ArrayList;

public class RecyclerTemplateAdapter extends RecyclerView.Adapter<RecyclerTemplateAdapter.ItemViewHolder>{

    private ArrayList<SectionTemplates> sectionTemplatesArrayList;
    private Context context;


    // adapter constructor
    public RecyclerTemplateAdapter(Context context, ArrayList<SectionTemplates> sectionTemplatesArrayList) {
        this.context = context;
        this.sectionTemplatesArrayList = sectionTemplatesArrayList;
    }

    // view holder class for horizontal items
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recycler_view_list;

        public ItemViewHolder(View v) {
            super(v);
            this.title = (TextView) v.findViewById(R.id.descriptionTitle);
            this.recycler_view_list = (RecyclerView) v.findViewById(R.id.recycler_view_list);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        String sectionName = sectionTemplatesArrayList.get(position).getDescription();
        ArrayList<Templates> list = sectionTemplatesArrayList.get(position).getTemplatesArrayList();

        // set title for this section
        holder.title.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(context, list);


        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);
    }

    @Override
    public int getItemCount() {
        return sectionTemplatesArrayList != null ? sectionTemplatesArrayList.size() : 0;
    }
}
