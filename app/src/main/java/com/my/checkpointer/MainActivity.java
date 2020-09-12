package com.my.checkpointer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button record_btn = findViewById(R.id.record_btn);
        Button share_btn = findViewById(R.id.share_btn);

        // RadioButtons
        final RadioGroup radios = findViewById(R.id.radios);
        final RadioButton radio1, radio2, radio3, radio4, radio5, radio6;
        radio1 = findViewById(R.id.radio1);
        radio1.setChecked(true);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        radio6 = findViewById(R.id.radio6);

        final SimpleDateFormat my_format = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");

        record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record(radios, my_format);
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Sorry, not implemented yet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void record(final RadioGroup radios, final SimpleDateFormat my_format)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to record?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date now = new Date();
                        RadioButton checked = findViewById(radios.getCheckedRadioButtonId());
                        checked.setText(my_format.format(now));
                        String toastmsg = "Recorded at " + checked.getTag();
                        Toast.makeText(MainActivity.this, toastmsg, Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Record cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }
}
