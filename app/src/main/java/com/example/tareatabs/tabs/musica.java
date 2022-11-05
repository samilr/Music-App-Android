package com.example.tareatabs.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tareatabs.R;

public class musica extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        saludo();
        return inflater.inflate(R.layout.fragment_musica, container, false);
    }

    public void saludo(){
        Toast.makeText(getActivity(), "Estas en música.",
                Toast.LENGTH_SHORT).show();
    }
}