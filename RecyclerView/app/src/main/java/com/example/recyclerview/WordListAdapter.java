package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    //the inflater creates the single item layout
    //see it used in onCreateViewHolder below
    private LayoutInflater mInflater;
    private LinkedList<String> mWordList;
    private Context context;

    //the constructor can take any parameters we need
    public WordListAdapter(Context context,
                           LinkedList<String> wordList) {
        //use this to create the layout
        mInflater = LayoutInflater.from(context);
        mWordList = wordList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        //its called with the position which will be the cell that it is filling
        //so if position 0 we want to put word O there
        String mCurrent = mWordList.get(position);
        holder.mWordItemView.setText("hello");
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    //have to tell this class how many items are in our data source
    //The RecyclerView.ViewHolder class must be an inner class
    //of the adapter class.
    //WordViewHolder is the Java class that represents the wordlist_item.xml layout
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //instantiate any views used in the item layout here
        //implement onClickListener so that when we click on one of the items it will do something which we will put in onClick
        private TextView mWordItemView;
        private WordListAdapter adapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            //inner class where we have to instantiate our text view

            super(itemView);
            mWordItemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            //int position = getLayoutPosition();
            //String word = mWordList.get(position);
            //mWordList.set(position, "Clicked! "+ word);
            //adapter.notifyDataSetChanged();
            //if you want the click to lead to activity create an intent and a new activity
           Intent intent = new Intent(context, WordClickedActivity.class);
            context.startActivity(intent);
        }
    }

}
