package ru.joy_media.testapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ru.joy_media.testapp.R;
import ru.joy_media.testapp.adapters.ListAdapter;
import ru.joy_media.testapp.adapters.MyList;

/**
 * Created by root on 05.07.2017.
 */

public class TabFragment2 extends Fragment {
    public List<MyList> mMyList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setInitialData();
        View view = inflater.inflate(R.layout.content_tab2, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_list);
        ListAdapter adapter = new ListAdapter(mMyList, new ListAdapter.ListViewHolder.CustomClickListener() {
            @Override
            public void onUserItemClickListener(int position) {
                Toast.makeText(getActivity().getApplicationContext(), mMyList.get(position).getMonth(), Toast.LENGTH_LONG).show();
            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setAdapter(adapter);
        rv.setLayoutManager(llm);
        return view;
    }

    private void setInitialData() {
        mMyList= new ArrayList<>();
        for (int i = 0; i < 2; i++) {

            mMyList.add(new MyList("Январь"));
            mMyList.add(new MyList("Февраль"));
            mMyList.add(new MyList("Март"));
            mMyList.add(new MyList("Апрель"));
            mMyList.add(new MyList("Май"));
            mMyList.add(new MyList("Июнь"));
            mMyList.add(new MyList("Июль"));
            mMyList.add(new MyList("Август"));
            mMyList.add(new MyList("Сентябрь"));
            mMyList.add(new MyList("Октябрь"));
            mMyList.add(new MyList("Ноябрь"));
            mMyList.add(new MyList("Декабрь"));

        }

    }
}
