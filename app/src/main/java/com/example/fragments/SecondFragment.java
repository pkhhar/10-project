package com.example.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.LinkedList;
import java.util.List;

import kotlinx.coroutines.CompletionHandlerException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    private  Button nextPage;

private String string;

private  static List<String> list = new LinkedList<>();
private TableLayout tableLayout;
    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment



        view = inflater.inflate(R.layout.fragment_second, container, false);
        Run();
        return  view;


    }


    private void Run()
    {
    nextPage = view.findViewById(R.id.nextPage);
    Bundle bundle = this.getArguments();
    if(bundle != null)
    {
        string = bundle.getString("product");

        list.add(string);

    }
    tableLayout = view.findViewById(R.id.tavlaFragmentSecond);


        for (int i = 0; i <list.size(); i++) {


        TableRow.LayoutParams params = new TableRow.LayoutParams(-2,100);
        TableRow.LayoutParams params2 = new TableRow.LayoutParams(-2,100);

        params2.gravity = Gravity.CENTER;
        TableRow tableRow = new TableRow(requireActivity());
        tableRow.setBackground(getResources().getDrawable(R.drawable.stroketable));
        tableRow.setLayoutParams(params);
        CheckBox checkBox = new CheckBox(requireActivity());
        TextView textView = new TextView(requireActivity());
        textView.setBackground(getResources().getDrawable(R.drawable.stroketable));
        checkBox.setLayoutParams(params2);
        textView.setLayoutParams(new TableRow.LayoutParams(-2,100));
        textView.setGravity(Gravity.RIGHT);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setText(list.get(i));




        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked())
                {
                    textView.setTextColor(Color.BLUE);


                }
                else
                {
                    textView.setTextColor(Color.BLACK);
                }
            }
        });

        tableRow.addView(checkBox);
        tableRow.addView(textView);
        tableLayout.addView(tableRow);

    }
        if(nextPage != null)
        {
            nextPage.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(requireActivity(),MainActivity2.class);

                    startActivity(intent);
                }
            });

        }

    }
}