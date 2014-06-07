package br.com.rolesoft.ica_client_sample.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GridAdapter extends BaseAdapter{

	ArrayList<Bitmap> images;
	Context context;
	
	public GridAdapter(Context context,
			ArrayList<Bitmap> images) {
		this.context = context;
		this.images = images;
	}
	

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 175));
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);

        } else {
            imageView = (ImageView) convertView;
        }
        
        if(images.get(position) != null)
        	imageView.setImageBitmap(images.get(position));

        //imageView.setBackgroundColor(Color.GREEN);
        return imageView;

	}

	public void setBitmaps(ArrayList<Bitmap> images) {
		this.images = images;
		notifyDataSetChanged();
	}

}
