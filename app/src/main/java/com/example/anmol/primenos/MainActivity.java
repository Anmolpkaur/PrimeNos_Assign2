package com.example.anmol.primenos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private static Button getstarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartBtnclick();
    }

    public void StartBtnclick()
    {
        getstarted=(Button)findViewById(R.id.button);
        getstarted.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        Intent intent=new Intent("com.example.anmol.primenos.Questions");
                        startActivity(intent);

                    }
                }
        );
    }
}
