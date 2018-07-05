package com.sayeedul.newsapp;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadlineFragment extends ListFragment {

    public interface OnHeadlineSelectedListener{

        public void onArticleSelected(int position);
    }

    OnHeadlineSelectedListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,News.headline));

    }

    @Override
    public void onStart() {
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.fragment)!=null){

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        }

    }

    /** The First Method is this to be called**/
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position,true);
    }
}
