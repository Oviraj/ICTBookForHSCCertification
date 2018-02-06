package ictbook.ingenium.ictbookforhsccertification.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ictbook.ingenium.ictbookforhsccertification.R;


public class QuizFragment extends Fragment {


    TextView tv;
    Button btnNext;
    RadioGroup rg;
    RadioButton rb1, rb2, rb3;
    String Questions[]={"একটি প্রোগ্রাম তৈরির ধাপ কতটি?","বৃত্তের ব্যাসার্ধ (r) জানা থাকলে ক্ষেত্রফল বের করার সূত্র কোনটি?","সি ভাষা তৈরি করেছেন কে?",
            "কোনটি সোর্স কোড কম্পাইলেশনের পরের ধাপ?","C language এর মৌলিক data type কয়টি?","চারটি বিড়ালের দাম ১০০০১ টাকা হলে, একটি বিড়ালের দাম ২৫০০.২৫ টাকা। ২৫০০.২৫ কি ধরনের ডাটা?",
            "কোনটি C language এর মৌলিক data type নয়?","Compilation Error কখন হয়?","কোনটি কম্পাইলারের আউটপুট?"};
    String ans[]= {"৪","π x r x r","ডেনিস রিচি","লিঙ্কিং","৩","Floating-point","String","প্রোগ্রামের ভাষাগত নিয়মে কোন ভুল থাকলে","অবজেক্ট কোড"};
    String opt[]={"৩","৪","৫","2 x π x r","π x r","π x r x r","চার্লস ব্যাবেজ","বেল ল্যাব","ডেনিস রিচি","লিঙ্কিং","লিন্টিং","এক্সিকিউশন",
            "২","৩","৪","String","Integer","Floating-point","Integer","String","Character","প্রোগ্রামটি ঠিকমত কাজ না করলে","প্রোগ্রামটি রান না করলে",
            "প্রোগ্রামের ভাষাগত নিয়মে কোন ভুল থাকলে", "অবজেক্ট কোড","এক্সিকিউটেবল (exe) ফাইল","বাইট কোড"};

    int flag=0;
    public static int marks,correct,wrong;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quiz,
                container, false);
        tv=(TextView)view.findViewById(R.id.tvque);
        btnNext=(Button)view.findViewById(R.id.button1);
        rg=(RadioGroup)view.findViewById(R.id.radioGroup1);
        rb1=(RadioButton)view.findViewById(R.id.radio0);
        rb2=(RadioButton)view.findViewById(R.id.radio1);
        rb3=(RadioButton)view.findViewById(R.id.radio2);

        tv.setText(Questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton uans=(RadioButton) view.findViewById(rg.getCheckedRadioButtonId());

               if(rb1.isChecked()|| rb2.isChecked()|| rb3.isChecked()){
                   String ansText=uans.getText().toString();
                   FragmentManager fm = getFragmentManager();
                   switch(v.getId()){

                       case R.id.button1:
                           if(ansText.equalsIgnoreCase(ans[flag]))
                           {
                               correct++;
                           }
                           else
                           {
                               wrong++;
                           }flag++;
                           if(flag<Questions.length){
                               tv.setText(Questions[flag]);
                               rb1.setText(opt[flag*3]);
                               rb2.setText(opt[(flag*3)+1]);
                               rb3.setText(opt[(flag*3)+2]);
                           }
                           else {
                               marks=correct;
                               fm.beginTransaction().replace(R.id.content_frame, new ResultFragment()).commit();
                           }


                   }
               }
                else {

                   Toast.makeText(getActivity().getApplicationContext(),"Please select an option",Toast.LENGTH_LONG).show();
               }

            }
        });
        return view;
    }
}
