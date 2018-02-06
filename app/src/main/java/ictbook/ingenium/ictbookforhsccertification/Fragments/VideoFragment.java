package ictbook.ingenium.ictbookforhsccertification.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ictbook.ingenium.ictbookforhsccertification.R;


public class VideoFragment extends Fragment {
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_video,
                container, false);

        Button buttonOne = (Button) view.findViewById(R.id.videoOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.videoOne:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new VideoOneFragment()).addToBackStack("video").commit();
                }
            }
        });
        Button buttonTwo = (Button) view.findViewById(R.id.videoTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.videoTwo:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new VideoTwoFragment()).addToBackStack("video").commit();
                }
            }
        });
        return view;
    }
}
