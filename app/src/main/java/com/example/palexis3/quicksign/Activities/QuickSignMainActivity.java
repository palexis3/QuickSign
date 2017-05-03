package com.example.palexis3.quicksign.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.palexis3.quicksign.Adapter.RecyclerTemplateAdapter;
import com.example.palexis3.quicksign.Models.SectionTemplates;
import com.example.palexis3.quicksign.Models.Templates;
import com.example.palexis3.quicksign.R;

import java.util.ArrayList;
import java.util.Map;

public class QuickSignMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    ArrayList<SectionTemplates> sectionTemplatesArrayList;


    private final String[] descriptions_array = new String[]{"Personal Relationship", "Events", "Households"};

    Map<String, String[]> personalMap;
    Map<String, String[]> eventsMap;
    Map<String, String[]> houseHoldsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sign_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        sectionTemplatesArrayList = new ArrayList<>();

        String[] personalArray = new String[]{"Best Friend", "Break-Up", "Love", "Divorce"};
        String[] eventsArray = new String[]{"Wedding Planner", "DJ Contract", "Bartending", "Vendor"};
        String[] householdsArray = new String[]{"Remodeling", "Gardening", "HouseKeeping", "Swimming Pool"};

        // populating
        personalMap.put(descriptions_array[0], personalArray);
        eventsMap.put(descriptions_array[1], eventsArray);
        houseHoldsMap.put(descriptions_array[2], householdsArray);

        if(toolbar == null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("Quick Sign");
        }

        populateArrayList();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        recyclerAdapter = new RecyclerTemplateAdapter(this, sectionTemplatesArrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(recyclerAdapter);

    }

    // pre-populate our list with items
    private void populateArrayList() {


        String break_up = "On this day, {date}, {Party 1 Name} (hereafter \"Party 1\") and {Party 2 Name} (hereafter \"Party 2\"), both desiring to dissolve their romantic relationship, agree to abide by the following rules and stipulations:\n" +
                "\n" +
                "To respect and honor requests from the other party regarding distance or dedicated time to grieve. This includes not calling, texting, emailing, or visiting the other person if they have asked to be left alone.\n" +
                "To address frustrations and disagreements without malice or anger, and to only address the issues that remain relevant for the relationship going forward.\n" +
                "To divide shared property fairly and to be accommodating with the understanding that some items might have more significance and value to one party over the other.\n" +
                "To be honest with regards to the expression of emotions, but not to speak harmfully or maliciously about the other party to others, especially mutual friends.\n" +
                "To allow both parties to feel their feelings honestly and without shame, without trying to force a change in the other party to accommodate the other's needs.\n" +
                "Not to share or disperse the other party's private, personal, and/or sensitive material with others.\n" +
                "____________________________________\n" +
                "\n" +
                "Party 1, signature & date\n" +
                "\n" +
                "____________________________________\n" +
                "\n" +
                "Party 2, signature & date";

        for(int i = 0; i < descriptions_array.length; i++) {

            SectionTemplates sectionTemplate = new SectionTemplates();

            sectionTemplate.setDescription(descriptions_array[i]);

            String[] arr = null;
            String[] imageArr = null;

            // getting the arrays of each theme
            switch (i) {
                case 0:
                    arr = personalMap.get(descriptions_array[0]);
                    break;
                case 1:
                    arr = eventsMap.get(descriptions_array[1]);
                    break;
                case 2:
                    arr = houseHoldsMap.get(descriptions_array[2]);
                    break;
                default:
                    Toast.makeText(this, "Could not get list to this particular description", Toast.LENGTH_LONG).show();
                    break;
            }

            if(arr == null) {
                Toast.makeText(this, "Could not get list to this particular description", Toast.LENGTH_LONG).show();
                continue;
            }

            ArrayList<Templates> list = new ArrayList<>();

            for(int j = 0; j < arr.length; j++) {
                list.add(new Templates(arr[j], descriptions_array[i], imageArr[j]));
                // special case when break is our item being added
                if(arr[j].equalsIgnoreCase("Break-Up")) {
                    Templates temp = list.get(j);
                    temp.setText(break_up);
                }
            }

            sectionTemplate.setTemplatesArrayList(list);

        }
    }


}
