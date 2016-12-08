package cn.edu.bistu.cs.se.c2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//长度转换
public class TransformateLength extends AppCompatActivity {
    EditText e_li, e_m, e_chi, e_zhang, e_cun, e_fen, e_mile, e_foot, e_inch;
    String s_li, s_m, s_chi, s_zhang, s_cun, s_fen, s_mile, s_foot, s_inch;
    Button b_li, b_m, b_chi, b_zhang, b_cun, b_fen, b_mile, b_foot, b_inch, re, clear2;
    double d_li, d_m, d_chi, d_zhang, d_cun, d_fen, d_mile, d_foot, d_inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformate_length);

        b_li = (Button) findViewById(R.id.btn_li);
        b_m = (Button) findViewById(R.id.btn_m);
        b_zhang = (Button) findViewById(R.id.btn_zhang);
        b_chi = (Button) findViewById(R.id.btn_chi);
        b_cun = (Button) findViewById(R.id.btn_cun);
        b_fen = (Button) findViewById(R.id.btn_fen);
        b_mile = (Button) findViewById(R.id.btn_mile);
        b_foot = (Button) findViewById(R.id.btn_foot);
        b_inch = (Button) findViewById(R.id.btn_inch);
        re = (Button) findViewById(R.id.returnn);
        clear2 = (Button) findViewById(R.id.clear2);
        e_li = (EditText) findViewById(R.id.et_li);
        e_m = (EditText) findViewById(R.id.et_m);
        e_zhang = (EditText) findViewById(R.id.et_zhang);
        e_chi = (EditText) findViewById(R.id.et_chi);
        e_cun = (EditText) findViewById(R.id.et_cun);
        e_fen = (EditText) findViewById(R.id.et_fen);
        e_mile = (EditText) findViewById(R.id.et_mile);
        e_foot = (EditText) findViewById(R.id.et_foot);
        e_inch = (EditText) findViewById(R.id.et_inch);

        re.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransformateLength.this, MainActivity.class);
                startActivity(intent);
            }
        });
        clear2.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                e_li.setText("");
                e_m.setText("");
                e_zhang.setText("");
                e_chi.setText("");
                e_cun.setText("");
                e_fen.setText("");
                e_mile.setText("");
                e_foot.setText("");
                e_inch.setText("");
            }
        }));
        //米
        b_m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_m = e_m.getText().toString();
                d_m = Double.parseDouble(s_m);
                d_li = d_m * 0.002;
                d_zhang = d_m * 0.3;
                d_chi = d_m * 3;
                d_cun = d_m * 30;
                d_fen = d_m * 300;
                d_mile = d_m * 0.00062137119;
                d_foot = d_m * 3.2808399;
                d_inch = d_m * 39.370079;

                e_fen.setText(String.format("%.5f", d_fen));
                e_li.setText(String.format("%.5f", d_li));
                e_zhang.setText(String.format("%.5f", d_zhang));
                e_chi.setText(String.format("%.5f", d_chi));
                e_cun.setText(String.format("%.5f", d_cun));
                e_mile.setText(String.format("%.5f", d_mile));
                e_foot.setText(String.format("%.5f", d_foot));
                e_inch.setText(String.format("%.5f", d_inch));
            }
        });
        //里
        b_li.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_li = e_li.getText().toString();
                d_li = Double.parseDouble(s_li);

                d_m = d_li * 500;
                d_zhang = d_li * 150;
                d_chi = d_li * 1500;
                d_cun = d_li * 15000;
                d_fen = d_li * 150000;
                d_mile = d_li * 0.3106856;
                d_foot = d_li * 1640.4199;
                d_inch = d_li * 19685.039;

                e_m.setText(String.format("%.5f", d_m));
                e_fen.setText(String.format("%.1f", d_fen));
                e_zhang.setText(String.format("%.5f", d_zhang));
                e_chi.setText(String.format("%.3f", d_chi));
                e_cun.setText(String.format("%.2f", d_cun));
                e_mile.setText(String.format("%.5f", d_mile));
                e_foot.setText(String.format("%.5f", d_foot));
                e_inch.setText(String.format("%.5f", d_inch));
            }
        });
        //丈
        b_zhang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_zhang = e_zhang.getText().toString();
                d_zhang = Double.parseDouble(s_zhang);

                d_m = d_zhang * 3.3333333;
                d_li = d_zhang * 0.0066666667;
                d_chi = d_zhang * 10;
                d_cun = d_zhang * 100;
                d_fen = d_zhang * 1000;
                d_mile = d_zhang * 0.0020712373;
                d_foot = d_zhang * 10.936133;
                d_inch = d_zhang * 131.2336;

                e_m.setText(String.format("%.5f", d_m));
                e_fen.setText(String.format("%.2f", d_fen));
                e_li.setText(String.format("%.5f", d_li));
                e_chi.setText(String.format("%.3f", d_chi));
                e_cun.setText(String.format("%.2f", d_cun));
                e_mile.setText(String.format("%.5f", d_mile));
                e_foot.setText(String.format("%.2f", d_foot));
                e_inch.setText(String.format("%.2f", d_inch));
            }
        });
        //尺
        b_chi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_chi = e_chi.getText().toString();
                d_chi = Double.parseDouble(s_chi);

                d_m = d_chi * 0.33333333;
                d_li = d_chi * 0.00066666667;
                d_zhang = d_chi * 0.1;
                d_cun = d_chi * 10;
                d_fen = d_chi * 100;
                d_mile = d_chi * 0.00020712373;
                d_foot = d_chi * 1.0936133;
                d_inch = d_chi * 13.12336;

                e_m.setText(String.format("%.5f", d_m));
                e_fen.setText(String.format("%.2f", d_fen));
                e_li.setText(String.format("%.5f", d_li));
                e_zhang.setText(String.format("%.3f", d_zhang));
                e_cun.setText(String.format("%.2f", d_cun));
                e_mile.setText(String.format("%.5f", d_mile));
                e_foot.setText(String.format("%.2f", d_foot));
                e_inch.setText(String.format("%.2f", d_inch));
            }
        });
        //寸
        b_cun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_cun = e_cun.getText().toString();
                d_cun = Double.parseDouble(s_cun);

                d_m = d_cun * 0.033333333;
                d_li = d_cun * 0.000066666667;
                d_zhang = d_cun * 0.01;
                d_chi = d_cun * 0.1;
                d_fen = d_cun * 10;
                d_mile = d_cun * 0.000020712373;
                d_foot = d_cun * 0.10936133;
                d_inch = d_cun * 1.312336;

                e_m.setText(String.format("%.5f", d_m));
                e_fen.setText(String.format("%.2f", d_fen));
                e_li.setText(String.format("%.8f", d_li));
                e_zhang.setText(String.format("%.3f", d_zhang));
                e_chi.setText(String.format("%.2f", d_chi));
                e_mile.setText(String.format("%.8f", d_mile));
                e_foot.setText(String.format("%.2f", d_foot));
                e_inch.setText(String.format("%.2f", d_inch));
            }
        });
        //分
        b_fen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_fen = e_fen.getText().toString();
                d_fen = Double.parseDouble(s_fen);

                d_m = d_fen * 0.0033333333;
                d_li = d_fen * 0.0000066666667;
                d_zhang = d_fen * 0.001;
                d_chi = d_fen * 0.01;
                d_cun = d_fen * 0.1;
                d_mile = d_fen * 0.0000020712373;
                d_foot = d_fen * 0.010936133;
                d_inch = d_fen * 0.1312336;

                e_m.setText(String.format("%.5f", d_m));
                e_cun.setText(String.format("%.2f", d_cun));
                e_li.setText(String.format("%.8f", d_li));
                e_zhang.setText(String.format("%.3f", d_zhang));
                e_chi.setText(String.format("%.2f", d_chi));
                e_mile.setText(String.format("%.8f", d_mile));
                e_foot.setText(String.format("%.2f", d_foot));
                e_inch.setText(String.format("%.2f", d_inch));
            }
        });
        //英里
        b_mile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_mile = e_mile.getText().toString();
                d_mile = Double.parseDouble(s_mile);

                d_m = d_mile * 1609.344;
                d_li = d_mile * 3.218688;
                d_zhang = d_mile * 482.8032;
                d_chi = d_mile * 4828.032;
                d_cun = d_mile * 48280.32;
                d_fen = d_mile * 482803.2;
                d_foot = d_mile * 5280;
                d_inch = d_mile * 63360;

                e_m.setText(String.format("%.3f", d_m));
                e_cun.setText(String.format("%.2f", d_cun));
                e_li.setText(String.format("%.5f", d_li));
                e_zhang.setText(String.format("%.3f", d_zhang));
                e_chi.setText(String.format("%.2f", d_chi));
                e_fen.setText(String.format("%.2f", d_fen));
                e_foot.setText(String.format("%.2f", d_foot));
                e_inch.setText(String.format("%.2f", d_inch));
            }
        });
        //英尺
        b_foot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_foot = e_foot.getText().toString();
                d_foot = Double.parseDouble(s_foot);

                d_m = d_foot * 0.3048;
                d_li = d_foot * 0.0006096;
                d_zhang = d_foot * 0.09144;
                d_chi = d_foot * 0.9144;
                d_cun = d_foot * 9.144;
                d_fen = d_foot * 91.44;
                d_mile = d_foot * 0.33333333;
                d_inch = d_foot * 12;

                e_m.setText(String.format("%.5f", d_m));
                e_cun.setText(String.format("%.8f", d_cun));
                e_li.setText(String.format("%.5f", d_li));
                e_zhang.setText(String.format("%.5f", d_zhang));
                e_chi.setText(String.format("%.5f", d_chi));
                e_fen.setText(String.format("%.5f", d_fen));
                e_mile.setText(String.format("%.5f", d_mile));
                e_inch.setText(String.format("%.4f", d_inch));
            }
        });
        //英寸
        b_inch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s_inch = e_inch.getText().toString();
                d_inch = Double.parseDouble(s_inch);

                d_m = d_inch * 0.0254;
                d_li = d_inch * 0.0000508;
                d_zhang = d_inch * 0.00762;
                d_chi = d_inch * 0.0762;
                d_cun = d_inch * 0.762;
                d_fen = d_inch * 7.62;
                d_mile = d_inch * 0.027777778;
                d_foot = d_inch * 0.083333333;

                e_m.setText(String.format("%.5f", d_m));
                e_cun.setText(String.format("%.8f", d_cun));
                e_li.setText(String.format("%.8f", d_li));
                e_zhang.setText(String.format("%.5f", d_zhang));
                e_chi.setText(String.format("%.5f", d_chi));
                e_fen.setText(String.format("%.5f", d_fen));
                e_mile.setText(String.format("%.5f", d_mile));
                e_foot.setText(String.format("%.4f", d_foot));
            }
        });
    }
}

