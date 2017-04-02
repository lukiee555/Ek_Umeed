package com.ekumid.socorro.ekumid;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverActivity extends AppCompatActivity {
    TextView Close, Driver_Name, DriverNumber, Vicheal_Number;
    ImageView Driverimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        DriverNumber = (TextView) findViewById(R.id.Driver_num);
        Driver_Name = (TextView) findViewById(R.id.Driver_name);
        Driverimg = (ImageView) findViewById(R.id.Driver_image);
        Vicheal_Number = (TextView) findViewById(R.id.Vicheal_Number);
        Close = (TextView) findViewById(R.id.Close);

        DriverNumber.setText(MapsActivity.drivermobile);
        Driver_Name.setText(MapsActivity.drivername);
        Vicheal_Number.setText(MapsActivity.drivervcnumber);

        DriverNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:91-" + MapsActivity.drivermobile));
                if (ActivityCompat.checkSelfPermission(DriverActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(phoneIntent);
            }
        });

        Close.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent i=new Intent (DriverActivity.this,MapsActivity.class);
                i.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity (i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent (DriverActivity.this,MapsActivity.class);
        i.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity (i);

    }
}
