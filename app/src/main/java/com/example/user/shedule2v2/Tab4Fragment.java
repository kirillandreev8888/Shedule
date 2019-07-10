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

public class Tab4Fragment extends Fragment {
    private static final String TAG = "Tab4Fragment";

    public RecyclerView recyclerView;
    static public String[] Items1 = {"---", "---", "Лекция Мобильные сети", "Лекция Мобильные сети", "Лекция Эксп.АСОИУ", "Лекция Беспр. сети", "---"};
    static public String[] Items2 = {"Пьем чай", "Пьем чай", "на каф.", "на каф.", "515ю", "515ю", "Пьем чай"};
    static public String[] Items1w = {"---", "---", "Лекция Мобильные сети", "Лекция Эксп.АСОИУ", "Лекция Эксп.АСОИУ", "Лекция Беспр. сети", "---"};
    static public String[] Items2w = {"Пьем чай", "Пьем чай", "на каф.", "515ю", "515ю", "515ю", "Пьем чай"};
    int[] Images = {R.drawable.para1, R.drawable.para2, R.drawable.para3, R.drawable.para4, R.drawable.para5, R.drawable.para6, R.drawable.para7};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment, container, false);

        SwitchCompat switchCompat = (SwitchCompat) getActivity().findViewById(R.id.switch1);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview4);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (switchCompat.isChecked()){
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1w, Items2w, Images));
        }else {
            recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), Items1, Items2, Images));
        }

        return view;
    }
}
