package ictbook.ingenium.ictbookforhsccertification.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import ictbook.ingenium.ictbookforhsccertification.R;


public class VideoOneFragment extends Fragment implements FragmentManager.OnBackStackChangedListener{

    MediaController mediaC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_video_one,
                container, false);
        Button buttonPlayVideo2 = (Button)view.findViewById(R.id.play);
        //   getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView mVideoView2 = (VideoView)view.findViewById(R.id.videoView);
        String uriPath2 = "android.resource://ictbook.ingenium.ictbookforhsccertification/"+R.raw.algorithm;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();
        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaC = new MediaController(getActivity());
                VideoView mVideoView2 = (VideoView) view.findViewById(R.id.videoView);
                String uriPath = "android.resource://ictbook.ingenium.ictbookforhsccertification/" + R.raw.algorithm;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.setMediaController(mediaC);
                mediaC.setAnchorView(mVideoView2);
                mVideoView2.start();
            }
        });


        return view;
    }

    @Override
    public void onBackStackChanged() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.remove(new VideoOneFragment());


    }
}
