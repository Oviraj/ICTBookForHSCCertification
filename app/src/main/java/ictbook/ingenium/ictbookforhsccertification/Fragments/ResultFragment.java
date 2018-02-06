package ictbook.ingenium.ictbookforhsccertification.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import ictbook.ingenium.ictbookforhsccertification.R;


public class ResultFragment extends Fragment {

    TextView tv;
    Button btnreset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_result,
                container, false);
        tv=(TextView)view.findViewById(R.id.textView);
        btnreset=(Button)view.findViewById(R.id.button);

        StringBuffer sb= new StringBuffer();
        sb.append("Correct Ans: "+QuizFragment.correct);
        sb.append("\nWrong Ans: "+QuizFragment.wrong);
        sb.append("\nFinal Score: "+QuizFragment.marks);
        tv.setText(sb);

        QuizFragment.correct=0;
        QuizFragment.wrong=0;
        QuizFragment.marks=0;
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                switch(v.getId()){

                    case R.id.button:
                        fm.beginTransaction().replace(R.id.content_frame, new QuizFragment()).commit();
                }
            }
        });
        return view;
    }
}
