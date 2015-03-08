package com.example.gogappe;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Cuisines extends Fragment {
	
	private List<CusinesCard> cards;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View layout = inflater.inflate(R.layout.cuisines_layout, null);
		
		
		ListView lv =(ListView) layout.findViewById(R.id.cusines_list);
		cards = new ArrayList<CusinesCard>();
		cards.add(new CusinesCard("Chineese"));
		cards.add(new CusinesCard("South Indian"));
		cards.add(new CusinesCard("Chaat"));
		cards.add(new CusinesCard("North Indian"));
		cards.add(new CusinesCard("Fast Food"));
		cards.add(new CusinesCard("Snacks Stall"));
		cards.add(new CusinesCard("Juices and Shakes"));
		cards.add(new CusinesCard("Paan Bhandaar"));
		cards.add(new CusinesCard("Bakery"));
		
		
		CuisinesCardAdapter adapter = new CuisinesCardAdapter(getActivity(), R.layout.cuisines_card_list_ui, cards);
		lv.setAdapter(adapter);
	
		return layout;
		//return super.onCreateView(inflater, container, savedInstanceState);
		
		
	}

}
