package com.example.gogappe;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CuisinesCardAdapter extends ArrayAdapter<CusinesCard> {
  Context context;
	public CuisinesCardAdapter(Context context, int resource,
			List<CusinesCard> objects) {
		super(context, resource, objects);
		this.context = context;
		
		
		// TODO Auto-generated constructor stub
	}
	
	  public class ViewHolder{
	       // ImageView image;
	        TextView title;
	      
	        LinearLayout layout;
	    }
	  
	  @Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				//return super.getView(position, convertView, parent);
				ViewHolder holder;
				CusinesCard card = getItem(position);
				   LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			        if (convertView == null){
			            convertView = mInflater.inflate(R.layout.cuisines_card_list_ui, null);
			            holder = new ViewHolder();
			            holder.layout = (LinearLayout) convertView.findViewById(R.id.card);
			            holder.title = (TextView)convertView.findViewById(R.id.title);
			         
			            
			            convertView.setTag(holder);
			        } else
			            holder = (ViewHolder)convertView.getTag();

			        holder.title.setText(card.title);
			       
			        Animation animation = AnimationUtils.loadAnimation(context, R.anim.card_animation);
			        holder.layout.startAnimation(animation);
			      //  holder.layout.setBackgroundResource(card.BackgroundColor);
			        return convertView;
				
			}


}
