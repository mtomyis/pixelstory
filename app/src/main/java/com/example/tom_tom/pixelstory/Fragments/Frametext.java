package com.example.tom_tom.pixelstory.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tom_tom.pixelstory.FrameText.Lay1T;
import com.example.tom_tom.pixelstory.FrameText.Lay2T;
import com.example.tom_tom.pixelstory.FrameText.Lay3T;
import com.example.tom_tom.pixelstory.FrameText.Lay4T;
import com.example.tom_tom.pixelstory.FrameText.Lay5T;
import com.example.tom_tom.pixelstory.FrameText.Lay6T;
import com.example.tom_tom.pixelstory.FrameText.Lay7T;
import com.example.tom_tom.pixelstory.FrameText.Lay8T;
import com.example.tom_tom.pixelstory.FrameText.Lay9T;
import com.example.tom_tom.pixelstory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frametext extends Fragment {

    Button vbtnlay_1, vbtnlay_2,vbtnlay_3,vbtnlay_4,vbtnlay_5,
            vbtnlay_6,vbtnlay_7,vbtnlay_8,vbtnlay_9;

    public Frametext() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frametext, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //menyambungkan dr variabel ke layout
        vbtnlay_1 = (Button) view.findViewById(R.id.btn_lay1);
        vbtnlay_2 = (Button) view.findViewById(R.id.btn_lay2);
        vbtnlay_3 = (Button) view.findViewById(R.id.btn_lay3);
        vbtnlay_4 = (Button) view.findViewById(R.id.btn_lay4);
        vbtnlay_5 = (Button) view.findViewById(R.id.btn_lay5);
        vbtnlay_6 = (Button) view.findViewById(R.id.btn_lay6);
        vbtnlay_7 = (Button) view.findViewById(R.id.btn_lay7);
        vbtnlay_8 = (Button) view.findViewById(R.id.btn_lay8);
        vbtnlay_9 = (Button) view.findViewById(R.id.btn_lay9);


        vbtnlay_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay1T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay2T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay3T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay4T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay5T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay6T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay7T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay8T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        vbtnlay_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lay9T.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

    }

}
