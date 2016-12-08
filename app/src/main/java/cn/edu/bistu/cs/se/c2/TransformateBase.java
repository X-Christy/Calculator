package cn.edu.bistu.cs.se.c2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//进制转换
public class TransformateBase extends AppCompatActivity {
    EditText e2, e10, e16;
    String s2, s10, s16;
    Button b2, b10, b16, re2, clear22;
    int i2, i10, i16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformate_base);

        b2 = (Button) findViewById(R.id.btwo);
        b10 = (Button) findViewById(R.id.bten);
        b16 = (Button) findViewById(R.id.bsixt);
        re2 = (Button) findViewById(R.id.returnn2);
        clear22 = (Button) findViewById(R.id.clear22);

        e2 = (EditText) findViewById(R.id.two);
        e10 = (EditText) findViewById(R.id.ten);
        e16 = (EditText) findViewById(R.id.sixt);

        re2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransformateBase.this, MainActivity.class);
                startActivity(intent);
            }
        });
        clear22.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                e2.setText("");
                e10.setText("");
                e16.setText("");
            }
        }));
        //二进制
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s2 = e2.getText().toString();

                s10 = Integer.valueOf(s2, 2).toString();
                s16 = Integer.toHexString(Integer.parseInt(s2, 2));

                e10.setText(s10);
                e16.setText(s16);
            }
        });
        //十进制
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s10 = e10.getText().toString();
                i10 = Integer.parseInt(s10);

                s2 = Integer.toBinaryString(i10);
                ;
                s16 = Integer.toHexString(i10);

                e2.setText(s2);
                e16.setText(s16);
            }
        });
        //十六进制
        b16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                s16 = e16.getText().toString();

                s2 = Integer.toBinaryString(Integer.valueOf(s16, 16));
                s10 = Integer.valueOf(s16, 16).toString();

                e2.setText(s2);
                e10.setText(s10);
            }
        });
    }

}
