package com.example.gogappe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 06-Mar-15.
 */
public class fragmentTwo  extends Fragment {

    TextView tvItemName;

    public static final String ITEM_NAME = "itemName";

    public fragmentTwo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container, false);

        tvItemName = (TextView) view.findViewById(R.id.frag2_text);

        tvItemName.setText(getArguments().getString(ITEM_NAME));

        return view;
    }

}