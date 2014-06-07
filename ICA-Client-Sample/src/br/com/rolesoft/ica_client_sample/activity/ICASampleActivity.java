package br.com.rolesoft.ica_client_sample.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import br.com.rolesoft.ica_client.task.ReceiveImageTask;
import br.com.rolesoft.ica_client_sample.R;
import br.com.rolesoft.ica_client_sample.adapter.GridAdapter;

public class ICASampleActivity extends Activity{
	
	private ProgressDialog progressDialog;  
	ArrayList<Bitmap> images;
	GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		images = new ArrayList<Bitmap>();
		receiveImage();
	}
	
	public void receiveImage() {
		String[] imagesIds = new String[12];
		imagesIds[0] = "01.jpg";
		imagesIds[1] = "02.jpg";
		imagesIds[2] = "03.jpg";
		imagesIds[3] = "04.jpg";
		imagesIds[4] = "05.jpg";
		imagesIds[5] = "06.jpg";
		imagesIds[6] = "07.jpg";
		imagesIds[7] = "08.jpg";
		imagesIds[8] = "09.jpg";
		imagesIds[9] = "10.jpg";
		imagesIds[10] = "11.jpg";
		imagesIds[11] = "12.jpg";
		new ReceiveImageTask(images, this, "http://ica.rolesoft.com.br:8080/ICA-Server-Sample/image/", imagesIds, imagesIds.length).execute();
		new LoadViewTask().execute();
	}
	
	private class LoadViewTask extends AsyncTask<Void, Integer, Void>  
    {  
        //Before running code in separate thread  
        @Override  
        protected void onPreExecute()  
        {  
            progressDialog = ProgressDialog.show(ICASampleActivity.this,"Loading...",  
                    "Loading application View, please wait...", false, false);  
        }  
  
        //The code to be executed in a background thread.  
        @Override  
        protected Void doInBackground(Void... params)  
        {  
            //Get the current thread's token  
			synchronized (this)  
			{  
			    while(images.size() < 1){
			    	
			    }
			}  
            return null;  
        }  
  
        //Update the progress  
        @Override  
        protected void onProgressUpdate(Integer... values)  
        {  
            //set the current progress of the progress dialog  
            progressDialog.setProgress(values[0]);  
        }  
  
        //after executing the code in the thread  
        @Override  
        protected void onPostExecute(Void result)  
        {  
            //close the progress dialog  
            progressDialog.dismiss();  
            setContentView(R.layout.ica_sample_activity_layout);
    		gridView = (GridView) findViewById(R.id.gridview);
    		GridAdapter imageAdapter = new GridAdapter(ICASampleActivity.this, images);
    		gridView.setAdapter(imageAdapter);
    		imageAdapter.notifyDataSetChanged();
        }  
    }
}
