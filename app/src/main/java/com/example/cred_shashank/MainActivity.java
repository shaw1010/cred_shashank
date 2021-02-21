package com.example.cred_shashank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getDummyDataToPass());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(recyclerAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private ArrayList<ParentDataItem> getDummyDataToPass() {
        ArrayList<ParentDataItem> arrDummyData = new ArrayList<>();
        ArrayList<ChildDataItem> childDataItems;
        /////////
       /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem("A Child 1", "HDFC Regalia", null,"No"));
        arrDummyData.add(new ParentDataItem("Select Card", childDataItems));
        /////////xx
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem("C Child 8", "HDFC Regalia", "12000", "No"));
        arrDummyData.add(new ParentDataItem("Add Amount", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new ChildDataItem("D Child 1", "HDFC Regalia", "12000", "Yes"));
        arrDummyData.add(new ParentDataItem("Approve Transaction", childDataItems));
        /////////
        ////////
        return arrDummyData;
    }
}
