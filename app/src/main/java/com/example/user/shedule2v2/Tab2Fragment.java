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
import android.widget.TextView;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    public RecyclerView recyclerView;
    static public String[] Items1 = {"Русский язык семинар", "Лекция Ан.Хар.Произв.", "Лекция Ан.Хар.Произв.", "Беспр. сети лаба", "Беспр. сети лаба", "---", "---"};
    static public String[] Items2 = {"418ю", "418ю", "418ю", "306э", "306э", "Пьем чай", "Пьем чай"};
    static public String[] Items1w = {"Русский язык семинар", "Русский язык семинар", "Лекция Ан.Хар.Произв.", "Беспр. сети лаба", "Беспр. сети лаба", "---", "---"};
    static public String[] Items2w = {"418ю", "418ю", "418ю", "306э", "306э", "Пьем чай", "Пьем чай"};
    int[] Images = {R.drawable.para1, R.drawable.para2, R.drawable.para3, R.drawable.para4, R.drawable.para5, R.drawable.para6, R.drawable.para7};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        SwitchCompat switchCompat = (SwitchCompat) getActivity().findViewById(R.id.switch1);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (switchCompat.isChecked()){
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1w, Items2w, Images));
        }else {
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1, Items2, Images));
        }

        return view;
    }
}
