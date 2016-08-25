package com.example.anmol.primenos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Questions extends AppCompatActivity {

    private static EditText ques;

    private static Button mcorrectbtn;
    private static Button mincorrectbtn;
    private static Button mcheatbtn;
    private static Button mhintbtn;
    private static Button mnextbtn;
    private static boolean cheat=false;
    private static boolean hint=false;
    int num;
    int res;
    Random r=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
         res=GenerateQues();
        CorrectBtnclick(res);
        IncorrectBtnclick(res);
        CheatBtnclick(res);
        HintBtnclick(res);
        NextBtnClick();
    }

    public int GenerateQues()
    {
        hint=false;
        cheat=false;
        ques=(EditText)findViewById(R.id.editText);
        num=r.nextInt(1000) + 1;
        String str="            "+num+" is a prime number.";
        ques.setText(str);
        return num;

    }

    public boolean Checkprime(int no)
    {
        int i;
        for(i=2;i<no;i++)
        {
            if((no%i)==0)
                return false;
        }
        return true;
    }

    public void CorrectBtnclick(final int no)
    {
        mcorrectbtn=(Button)findViewById(R.id.button2);
        mcorrectbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        boolean res=Checkprime(no);
                        if(res==true && cheat==false)
                            Toast.makeText(Questions.this," Your answer is Right", Toast.LENGTH_LONG).show();
                        else
                        if(res==false && cheat==false)
                            Toast.makeText(Questions.this,"Your answer is Wrong", Toast.LENGTH_LONG).show();
                        else
                        if(res==true && cheat==true)
                            Toast.makeText(Questions.this,"You Cheated!! Your answer is Right", Toast.LENGTH_LONG).show();
                        else
                        if(res==false && cheat==true)
                            Toast.makeText(Questions.this,"You Cheated!! Still your answer is Wrong", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


    public void IncorrectBtnclick(final int no)
    {
        mincorrectbtn=(Button)findViewById(R.id.button3);
        mincorrectbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        boolean res=Checkprime(no);
                        if(res==false && cheat==false)
                            Toast.makeText(Questions.this,"Your answer is Right", Toast.LENGTH_LONG).show();
                        else
                        if(res==true && cheat==false)
                            Toast.makeText(Questions.this,"Your answer is Wrong", Toast.LENGTH_LONG).show();
                        else
                        if(res==false && cheat==true)
                            Toast.makeText(Questions.this,"You Cheated!! Your answer is Right", Toast.LENGTH_LONG).show();
                        else
                        if(res==true && cheat==true)
                            Toast.makeText(Questions.this,"You Cheated!! Still your answer is Wrong", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void HintBtnclick(final int no)
    {
        mhintbtn=(Button)findViewById(R.id.button5);
        mhintbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        boolean res=Checkprime(no);
                        String hint_message;
                        if(res==true)
                            hint_message=" "+no+" has no factors other than 1 and itself.";
                        else
                            hint_message=" "+no+" has many factors other than 1 and itself.";

                        hint=true;
                        Intent intent2=new Intent(Questions.this,HintActivity.class);
                        intent2.putExtra("HintMessage",hint_message);
                        startActivityForResult(intent2,1);

                    }
                }
        );
    }

    protected void onActivityResult(int requestcode,int resultcode, Intent ReturnIntent)
    {

        String displayMsg=null;
        if(requestcode==1)
        {
            if(resultcode== RESULT_OK)
            {
                displayMsg= ReturnIntent.getStringExtra("MsgfromHintActivity");
                Toast.makeText(Questions.this,displayMsg, Toast.LENGTH_LONG).show();
            }
            if(resultcode == RESULT_CANCELED)
            {
                 displayMsg= "***";
                Toast.makeText(Questions.this,displayMsg, Toast.LENGTH_LONG).show();
            }
        }

        if(requestcode==2)
        {
            if(resultcode== RESULT_OK)
            {
                displayMsg= ReturnIntent.getStringExtra("MsgfromCheatActivity");
                Toast.makeText(Questions.this,displayMsg, Toast.LENGTH_LONG).show();
            }
            if(resultcode == RESULT_CANCELED)
            {
                displayMsg= "***";
                Toast.makeText(Questions.this,displayMsg, Toast.LENGTH_LONG).show();
            }
        }





    }

    public void CheatBtnclick(final int no)
    {
        mcheatbtn=(Button)findViewById(R.id.button6);
        mcheatbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        boolean res=Checkprime(no);
                        String ans_message;
                        if(res==true)
                            ans_message=" "+no+" is a prime number.";
                        else
                            ans_message=" "+no+" is not a prime number.";

                        cheat=true;
                        Intent intent1=new Intent(Questions.this,CheatActivity.class);
                        intent1.putExtra("CheatMessage",ans_message);
                        startActivityForResult(intent1,2);

                    }
                }
        );
    }

    public void NextBtnClick()
    {
        mnextbtn=(Button)findViewById(R.id.button4);
        mnextbtn.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                      /*  int res=GenerateQues();
                        CorrectBtnclick(res);
                        IncorrectBtnclick(res);
                        CheatBtnclick(res);
                        HintBtnclick(res);
                        NextBtnClick();*/

                        Intent intent=new Intent(Questions.this,Questions.class);
                        startActivity(intent);

                    }
                }
        );
    }




}
