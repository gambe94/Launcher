package hu.bme.aut.amorg.examples.launcher.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import hu.bme.aut.amorg.examples.launcher.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialerFragment extends Fragment {

    private EditText editText;
    private Button callBtn;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private Button b_hash;
    private Button b_csillag;

    private ImageView backSpace;




    public DialerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.callEditText);
        b1 = view.findViewById(R.id.on1);
        b2 = view.findViewById(R.id.on2);
        b3 = view.findViewById(R.id.on3);
        b4 = view.findViewById(R.id.on4);
        b5 = view.findViewById(R.id.on5);
        b6 = view.findViewById(R.id.on6);
        b7 = view.findViewById(R.id.on7);
        b8 = view.findViewById(R.id.on8);
        b9 = view.findViewById(R.id.on9);
        b_csillag = view.findViewById(R.id.on_csillag);
        b_hash = view.findViewById(R.id.on_hash);

        b1.setOnClickListener(myonclickListener());
        b2.setOnClickListener(myonclickListener());
        b3.setOnClickListener(myonclickListener());
        b4.setOnClickListener(myonclickListener());
        b5.setOnClickListener(myonclickListener());
        b6.setOnClickListener(myonclickListener());
        b7.setOnClickListener(myonclickListener());
        b8.setOnClickListener(myonclickListener());
        b9.setOnClickListener(myonclickListener());
        b_hash.setOnClickListener(myonclickListener());
        b_csillag.setOnClickListener(myonclickListener());



        callBtn = view.findViewById(R.id.call_button);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "tel:";
                phoneNumber += String.valueOf(editText.getText());

                Log.d("Call_btn", phoneNumber);

                Intent i = new Intent(
                        Intent.ACTION_CALL,
                        Uri.parse(phoneNumber)
                );
                startActivity(i);
            }
        });


        backSpace = view.findViewById(R.id .callBackSpaceButton);
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbers = String.valueOf(editText.getText());
                if(numbers.length()>=1){
                    editText.setText(numbers.substring(0, numbers.length() - 1));

                }

            }
        });
    }

    public  View.OnClickListener myonclickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;
                editText.append(b.getText());
            }
        };
    }

}
