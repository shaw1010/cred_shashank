package com.example.cred_shashank;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<ParentDataItem> parentDataItems;
    MyViewHolder vh0;MyViewHolder vh1;MyViewHolder vh2;
    int i=0;
    RecyclerAdapter(ArrayList<ParentDataItem> parentDataItems) {
        this.parentDataItems = parentDataItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("onCreateViewHolder: ", String.valueOf(i));

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_child_list,
                parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ParentDataItem parentDataItem = parentDataItems.get(position);
        holder.textView_parentName.setText(parentDataItem.getParentName());
        //
        Log.i("onBindViewHolder: ", String.valueOf(position));
        switch (position){
            case 0:

                int noOfChild1_tv = holder.linearLayout_childItems.getChildCount();
                for (int index = 0; index < noOfChild1_tv; index++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                    currentTextView.setVisibility(View.VISIBLE);
                }
                holder.linearLayout_childItems.setVisibility(View.VISIBLE);
                int noOfChild1 = parentDataItem.getChildDataItems().size();
                if (noOfChild1 < noOfChild1_tv) {
                    for (int index = noOfChild1; index < noOfChild1_tv; index++) {
                        TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                        currentTextView.setVisibility(View.GONE);
                    }
                }
                for (int textViewIndex = 0; textViewIndex < noOfChild1; textViewIndex++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
                    currentTextView.setText("Credit Card: " + parentDataItem.getChildDataItems().get(textViewIndex).getCreditCard());
                }
                break;

            case 1:

                int noOfChild2_tv = holder.linearLayout_childItems.getChildCount();
                for (int index = 0; index < noOfChild2_tv; index++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                    currentTextView.setVisibility(View.VISIBLE);
                }
                holder.linearLayout_childItems.setVisibility(View.GONE);
                int noOfChilds2 = parentDataItem.getChildDataItems().size();
                if (noOfChilds2 < noOfChild2_tv) {
                    for (int index = noOfChilds2; index < noOfChild2_tv; index++) {
                        TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                        currentTextView.setVisibility(View.GONE);
                    }
                }
                for (int textViewIndex = 0; textViewIndex < noOfChilds2; textViewIndex++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
                    currentTextView.setText("Amount: "  + parentDataItem.getChildDataItems().get(textViewIndex).getAmount());
                }
                break;

            case 2:

                int noOfChild3_tv = holder.linearLayout_childItems.getChildCount();
                for (int index = 0; index < noOfChild3_tv; index++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                    currentTextView.setVisibility(View.VISIBLE);
                }
                holder.linearLayout_childItems.setVisibility(View.GONE);
                int noOfChilds3 = parentDataItem.getChildDataItems().size();
                if (noOfChilds3 < noOfChild3_tv) {
                    for (int index = noOfChilds3; index < noOfChild3_tv; index++) {
                        TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                        currentTextView.setVisibility(View.GONE);
                    }
                }
                for (int textViewIndex = 0; textViewIndex < noOfChilds3; textViewIndex++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
                    currentTextView.setText("Approve: " + parentDataItem.getChildDataItems().get(textViewIndex).getApprove());
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return parentDataItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        private TextView textView_parentName;
        private LinearLayout linearLayout_childItems;
        private int i;
        MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            Log.i( "MyViewHolder:Item Id ", String.valueOf(this));
            textView_parentName = itemView.findViewById(R.id.tv_parentName);
            linearLayout_childItems = itemView.findViewById(R.id.ll_child_items);
            linearLayout_childItems.setVisibility(View.GONE);
            int intMaxNoOfChild = 0;
            for (int index = 0; index < parentDataItems.size(); index++) {
                int intMaxSizeTemp = parentDataItems.get(index).getChildDataItems().size();
                if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
            }
            for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                TextView textView = new TextView(context);
                textView.setId(indexView);
                textView.setPadding(0, 20, 0, 20);
                textView.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textView.setOnClickListener(this);
                linearLayout_childItems.addView(textView, layoutParams);
            }
            textView_parentName.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Log.i("onClick: ", String.valueOf(this.i));
            if (view.getId() == R.id.tv_parentName) {
                if (linearLayout_childItems.getVisibility() == View.VISIBLE) {
                    linearLayout_childItems.setVisibility(View.GONE);
                } else {
                    linearLayout_childItems.setVisibility(View.VISIBLE);
                }
            } else {
                TextView textViewClicked = (TextView) view;
                Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}