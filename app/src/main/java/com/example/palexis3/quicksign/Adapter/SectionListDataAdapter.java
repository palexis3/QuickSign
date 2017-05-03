package com.example.palexis3.quicksign.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.palexis3.quicksign.Models.Templates;
import com.example.palexis3.quicksign.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>{

    private ArrayList<Templates> templatesArrayList;
    private Context context;


    public SectionListDataAdapter(Context context, ArrayList<Templates> templatesArrayList) {
        this.context = context;
        this.templatesArrayList = templatesArrayList;
    }

    public static class SingleItemRowHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;


        public SingleItemRowHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.itemTitle);
            image = (ImageView) v.findViewById(R.id.itemImage);

            /** Todo
            // a view has been clicked, initialize template
             */
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String t = String.format("Title: %s", title.getText());
                    Toast.makeText(view.getContext(), t, Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    // inflate single card layout
    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_single_card, parent, false);
        SingleItemRowHolder sir = new SingleItemRowHolder(v);
        return sir;
    }

    // bind template items to specific views
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int position) {
        Templates template = templatesArrayList.get(position);
        holder.title.setText(template.getName());

        // reset holder image
        holder.image.setImageResource(0);

        Picasso.with(context).load(template.getImageUrl()).transform(new RoundedCornersTransformation(10, 10)).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return templatesArrayList != null ? templatesArrayList.size() : 0;
    }
}
