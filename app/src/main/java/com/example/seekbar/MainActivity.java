package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekbar);
        textView = findViewById(R.id.text);

        textView.setText("Skala : "+seekBar.getProgress()+ "/"+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { ////Pobiera informacje podczas wciśniecie przez uzytkownika
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Skala : "+progress+ "/"+seekBar.getMax());
                ///Wyświetla poszczególne numery na skali podczas przesuwania paska
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Start", Toast.LENGTH_SHORT).show();
                ///Wyświetla komunikat start kiedy uśytkownik używa pasek (śledzi zmiany)
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                ///Wyświetla komunikat stop kiedy użytkownik używa pasek (śledzi zmiany)
            }
        });
    }
}