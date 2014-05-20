package br.com.rolesoft.ica_client_sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import br.com.rolesoft.ica_client.activity.ICAActivity;
import br.com.rolesoft.ica_client.task.ReceiveImageTask;
import br.com.rolesoft.ica_client_sample.R;

public class ICASampleActivity extends Activity{
	
	RelativeLayout imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.ica_sample_activity_layout);
		imageView = (RelativeLayout) findViewById(R.id.imageView1);
		super.onCreate(savedInstanceState);
	}
	
	public void receiveImage(View v) {
		String[] imagesIds = new String[1];
		imagesIds[0] = "once_upon_a_time_by_daekazu-d5fsvt4.jpg";
		new ReceiveImageTask(imageView, this, "http://192.168.1.12:8080/ICA-Server-Sample/image/", imagesIds).execute();
	}
}
