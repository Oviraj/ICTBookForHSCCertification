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


public class ChapterOneFragment extends Fragment {

    FragmentTransaction fragmentTransaction;
    Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine, quiz;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_chapter_one,
                container, false);

        buttonOne = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_One);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();


                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_One:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_one");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonTwo = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Two);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Two:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_two");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonThree = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Three);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Three:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_three");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonFour = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Four);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Four:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_four");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonFive = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Five);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Five:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_five");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonSix = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Six);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Six:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_six");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonSeven = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Seven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Seven:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_seven");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonEight = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Eight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Eight:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_eight");
                        fragmentTransaction.commit();
                }
            }
        });
        buttonNine = (Button) view.findViewById(R.id.Button_Chapter_One_Topic_Nine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_Chapter_One_Topic_Nine:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new TopicFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_nine");
                        fragmentTransaction.commit();
                }
            }
        });

        quiz= (Button) view.findViewById(R.id.Button_quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.Button_quiz:
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new QuizFragment());
                        fragmentTransaction.addToBackStack("chapter_one_topic_quiz");
                        fragmentTransaction.commit();
                }
            }
        });
        return view;
    }
    }
