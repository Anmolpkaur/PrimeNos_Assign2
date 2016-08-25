package com.example.anmol.primenos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class HintActivity extends AppCompatActivity {

    private static EditText edit_text;
    private static String return_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        fill_editText();
    }

    @Override
    public void onBackPressed() {
        Intent returndata = new Intent();
        returndata.putExtra("MsgfromHintActivity",return_msg);
        setResult(Activity.RESULT_OK,returndata);
        finish();
    }

    public void fill_editText()
    {
        edit_text=(EditText)findViewById(R.id.editText3);
        Bundle extra_msg= getIntent().getExtras();
        if(extra_msg==null)
        {
            return;
        }
        String hint_msg=extra_msg.getString("HintMessage");
        edit_text.setText(hint_msg);

        return_msg="You are here after seeing Hint";


    }
}
