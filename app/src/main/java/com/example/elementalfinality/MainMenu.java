package com.example.elementalfinality;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainMenu extends AppCompatActivity {

    Button obStart;
    TextView tvLon;

    LocationManager locationManager;
    LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        tvLon = findViewById(R.id.tvLon);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                useNewLocation(location);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        } catch (SecurityException e) {
            tvLon.setText(e.getMessage());
            e.printStackTrace();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        obStart = (Button) findViewById(R.id.btnStartGame);

        obStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent goToGame = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToGame);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.rateUs) {
            displayNotification();
            return true;
        }
        if (id == R.id.resetScoreboard) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void useNewLocation(Location location) {
        tvLon.setText("He knows your location!\n ( " + location.getLongitude() + ", " + location.getLatitude() + ")" + "\n" + "finish him off for good this time!");
    }

    //When the app stops temporarily
    protected void onStop() {
        locationManager.removeUpdates(locationListener);
        super.onStop();
    }

    protected void onResume() {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        } catch (SecurityException e) {
            tvLon.setText(e.getMessage());
            e.printStackTrace();
        }
        super.onResume();
    }


    public void displayNotification() {


        Intent intent = new Intent(this, RateUs.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        String CHANNEL_ID = "111";
        int notificationId = 101;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.finality)
                .setContentTitle("Rate Us!")
                .setContentText("Please Rate Us at https://ElementalFinality.com")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Please Rate Us at https://ElementalFinality.com"))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Rate Us";
            String description = "Please Rate Us at https://ElementalFinality.com";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());





    }

}
