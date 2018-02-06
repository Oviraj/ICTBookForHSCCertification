package ictbook.ingenium.ictbookforhsccertification.Fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import ictbook.ingenium.ictbookforhsccertification.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    Integer Identifier=1;
    Button TextLectures, Videos;
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        textView = (TextView) view.findViewById(R.id.Content_TextView_ChapterName);
        TextLectures = (Button) view.findViewById(R.id.Content_Button_One);
        Videos = (Button) view.findViewById(R.id.Content_Button_Two);


        Videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Content_Button_Two:
                        FragmentTransaction fragmentTransaction;
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new VideoFragment());
                        fragmentTransaction.addToBackStack("video");
                        fragmentTransaction.commit();
                }
            }
        });




        switch (Identifier){

            case 1:

                textView.setText(R.string.Chapter_One_Name);

                break;
            case 2:

                textView.setText(R.string.Chapter_Two_Name);
                break;


            case 3:
                textView.setText(R.string.Chapter_Three_Name);
                break;

            case 4:
                textView.setText(R.string.Chapter_Four_Name);
                break;

            case 5:
                textView.setText(R.string.Chapter_Five_Name);
                break;

            case 6:
                textView.setText(R.string.Chapter_Six_Name);
                break;
        }

        TextLectures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();

                FragmentTransaction fragmentTransaction = fm.beginTransaction();

                textView = (TextView) getActivity().findViewById(R.id.Content_TextView_ChapterName);

                switch (Identifier) {

                    case 1:

                        fragmentTransaction.replace(R.id.content_frame, new ChapterOneFragment()).addToBackStack("Chapter_One").commit();


                        break;
                    case 2:


                        fragmentTransaction.replace(R.id.content_frame, new ChapterTwoFragment()).addToBackStack("Chapter_Two").commit();
                        break;
                    case 3:


                        fragmentTransaction.replace(R.id.content_frame, new ChapterThreeFragment()).addToBackStack("Chapter_Three").commit();
                        break;
                    case 4:


                        fragmentTransaction.replace(R.id.content_frame, new ChapterFourFragment()).addToBackStack("Chapter_Four").commit();
                        break;
                    case 5:


                        fragmentTransaction.replace(R.id.content_frame, new ChapterFiveFragment()).addToBackStack("Chapter_Five").commit();
                        break;
                    case 6:


                        fragmentTransaction.replace(R.id.content_frame, new ChapterSixFragment()).addToBackStack("Chapter_Six").commit();
                        break;
                    default:
                }


            }
        });

        return view;

    }

    public void putIdentifier(int i){


        Identifier=i;

        Log.e("rob","identifier"+Identifier);

    }
}