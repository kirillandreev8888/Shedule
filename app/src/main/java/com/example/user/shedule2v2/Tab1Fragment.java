package com.example.user.shedule2v2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    public RecyclerView recyclerView;
    static public String[] Items1 = {"---", "Ан.Хар.Произв.", "Ан.Хар.Произв.", "---", "---", "---", "---"};
    static public String[] Items2 = {"Пьем чай", "306э", "306э", "Пьем чай", "Пьем чай", "Пьем чай", "Пьем чай"};
    static public String[] Items1w = {"---", "Ан.Хар.Произв.", "Ан.Хар.Произв.", "---", "---", "---", "---"};
    static public String[] Items2w = {"Пьем чай", "306э", "306э", "Пьем чай", "Пьем чай", "Пьем чай", "Пьем чай"};
    int[] Images = {R.drawable.para1, R.drawable.para2, R.drawable.para3, R.drawable.para4, R.drawable.para5, R.drawable.para6, R.drawable.para7};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        SwitchCompat switchCompat = (SwitchCompat) getActivity().findViewById(R.id.switch1);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (switchCompat.isChecked()){
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1w, Items2w, Images));
        }else {
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1, Items2, Images));
        }

        return view;
    }
}
