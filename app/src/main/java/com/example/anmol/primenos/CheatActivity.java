package com.example.anmol.primenos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CheatActivity extends AppCompatActivity {

    private static EditText edit_text;
    private static String cheatreturn_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        fill_edittext();
    }

    public void onBackPressed() {
        Intent returndata = new Intent();
        returndata.putExtra("MsgfromCheatActivity",cheatreturn_msg);
        setResult(Activity.RESULT_OK,returndata);
        finish();
    }

    public void fill_edittext()
    {
        edit_text=(EditText)findViewById(R.id.editText2);
        Bundle extra_msg= getIntent().getExtras();
        if(extra_msg==null)
        {
            return;
        }
        String cheat_msg=extra_msg.getString("CheatMessage");
        edit_text.setText(cheat_msg);
        cheatreturn_msg="You are here after seeing Cheat";
    }
}
