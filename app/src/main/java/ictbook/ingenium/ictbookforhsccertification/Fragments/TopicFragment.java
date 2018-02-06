package ictbook.ingenium.ictbookforhsccertification.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ictbook.ingenium.ictbookforhsccertification.R;


public class TopicFragment extends Fragment {
   TextView ProgramOneText;
  // DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
   //DatabaseReference mConditionRef = mRootRef.child("CprogramOne");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_topic,
                container, false);
        ProgramOneText = (TextView) view.findViewById(R.id.TextView);

        ProgramOneText.setText(R.string.programOne);

        Button buttonNext = (Button) view.findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch (v.getId()) {

                    case R.id.next:
                        Toast.makeText(getActivity().getApplicationContext(),"Next button is working.",Toast.LENGTH_SHORT).show();

                }
            }
        });
        Button buttonBack = (Button) view.findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                switch (v.getId()) {

                    case R.id.back:
                        Toast.makeText(getActivity().getApplicationContext(),"Back button is working.",Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;
    }

 /*   @Override
    public void onStart() {
        super.onStart();
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Text = dataSnapshot.getValue(String.class);
                ProgramOneText.setText(Text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }*/
}
