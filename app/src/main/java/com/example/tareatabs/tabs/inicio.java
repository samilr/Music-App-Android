package com.example.tareatabs.tabs;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.tareatabs.R;

public class inicio extends Fragment {
    VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        videoView = view.findViewById(R.id.videoView);
        String urlVideo = "android.resource://" + getContext().getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(urlVideo);

        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.requestFocus();
        videoView.start();

        return view;
    }
}