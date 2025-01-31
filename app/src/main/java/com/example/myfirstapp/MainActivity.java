package com.example.myfirstapp;
//Modul
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edText;
    String oldNum;
    Boolean isNew;
    String opperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edText=findViewById(R.id.editText);
        isNew=Boolean.TRUE;
    }
//
    public void pressNum(View view) {
        if (isNew)
            edText.setText("");
        isNew=Boolean.FALSE;
        String el=edText.getText().toString();;
        if (view.getId()==R.id.but9)
        {
            el+="9";
        }
        else if (view.getId()==R.id.but8) {
            el+="8";
        }
        else if (view.getId()==R.id.but7)
        {
            el+="7";
        }
        else if (view.getId()==R.id.but6)
        {
            el+="6";
        }
        else if (view.getId()==R.id.but5)
        {
            el+="5";
        }
        else if (view.getId()==R.id.but4)
        {
            el+="4";
        }
        else if (view.getId()==R.id.but3)
        {
            el+="3";
        }
        else if (view.getId()==R.id.but2)
        {
            el+="2";
        }
        else if (view.getId()==R.id.but1)
        {
            el+="1";
        }
        else if (view.getId()==R.id.butZero)
        {
            el+="0";
        }
        else if (view.getId()==R.id.butAc)
        {
            el="0";
            isNew=Boolean.TRUE;
        }
        else if (view.getId()==R.id.butPoint)
        {
            if(NotExsitPoint(el))
            {
                el += ".";
            }
        }

        edText.setText(el);
    }

    public void Opperation(View view) {
        isNew=Boolean.TRUE;
        oldNum=edText.getText().toString();
        if (view.getId()==R.id.butDivision)
        {
            opperator="/";
        }
        else if (view.getId()==R.id.butMultiply)
        {
            opperator="*";
        }
        else if (view.getId()==R.id.butMunus)
        {
            opperator="-";
        }
        else if (view.getId()==R.id.butPlus)
        {
            opperator="+";
        }


    }

    public void Equal(View view)
    {
        double newNumber=Double.parseDouble(edText.getText().toString());
        double old_Num=Double.parseDouble(oldNum);
        Double res=0.0;
        switch (opperator)
        {
            case "+":res=old_Num+newNumber;
            break;
            case "-":res=old_Num-newNumber;
            break;
            case "/":
                if(newNumber!=0.0)
                    res=old_Num/newNumber;

                break;
            case "*":res=old_Num*newNumber;
            break;
        }
        edText.setText(res.toString());


    }
    public Boolean NotExsitPoint(String el)
    {
        int ind=el.indexOf(".");
        if(ind==-1)
        {
            return true;
        }
        return false;
    }
}