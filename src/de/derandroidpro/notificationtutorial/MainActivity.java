package de.derandroidpro.notificationtutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	public Button btnshow, btnhide;
	
	public Notification.Builder notif;
	public NotificationManager nm1;
	
	public Intent i1;
	public PendingIntent pi1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnshow = (Button) findViewById(R.id.buttonshow);
		btnshow.setOnClickListener(this);
		btnhide = (Button) findViewById(R.id.buttonhide);
		btnhide.setOnClickListener(this);
		
		
		notif = new Notification.Builder (this);
		nm1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		
		case R.id.buttonshow:{
			
			i1 = new Intent (this, MainActivity.class);
			pi1 = PendingIntent.getActivity(getApplicationContext(), 0, i1, 0);
			
			notif.setContentTitle("Android 5.0");
			notif.setContentText("Material Design hat Swag!");
			notif.setSmallIcon(R.drawable.ic_notif);
			notif.setAutoCancel(true);
			notif.setContentIntent(pi1);
			
			nm1.notify(15, notif.build());
			
			
			break;
		}
		
		case R.id.buttonhide:{
			
			nm1.cancel(15);
			
			break;
		}
		
		
		
		}
		
	}


}
