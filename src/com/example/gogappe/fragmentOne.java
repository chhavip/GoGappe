package com.example.gogappe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 06-Mar-15.
 */
public class fragmentOne  extends Fragment {

    TextView tvItemName;

    public static final String ITEM_NAME = "itemName";

    public fragmentOne() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
      // ActionBar actionbar = getsuppo
        tvItemName = (TextView) view.findViewById(R.id.frag1_text);

        tvItemName.setText(getArguments().getString(ITEM_NAME));

        return view;
    }

}