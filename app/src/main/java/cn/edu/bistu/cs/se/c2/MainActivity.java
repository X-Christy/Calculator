package cn.edu.bistu.cs.se.c2;

import android.view.Menu;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity{
    private Button[] btn = new Button[10];
    private EditText input;       //显示输出结果
    private TextView mem;        //记录上一次计算结果

    private TextView tip;
    private Button
            div, mul, sub, add, equal,
            sin, cos, tan, log, ln,
            factorial, bksp,          //阶乘、退格
            left, right, dot,
            mc, c;                       // mem清屏键、input清屏键

    public String str_old;
    public String str_new;
    public boolean vbegin = true;      //true为重新输入，false为接着输入
    public boolean drg_flag = true;
    public double pi=4*Math.atan(1);    //π值：3.14
    public boolean tip_lock = true;    //true表示可以继续输入；false表示输入被锁定
    public boolean equals_flag = true;

    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        //获取界面元素
        input = (EditText) findViewById(R.id.input);
        mem = (TextView) findViewById(R.id.mem);
        tip = (TextView) findViewById(R.id.tip);
        btn[0] = (Button) findViewById(R.id.zero);
        btn[1] = (Button) findViewById(R.id.one);
        btn[2] = (Button) findViewById(R.id.two);
        btn[3] = (Button) findViewById(R.id.three);
        btn[4] = (Button) findViewById(R.id.four);
        btn[5] = (Button) findViewById(R.id.five);
        btn[6] = (Button) findViewById(R.id.six);
        btn[7] = (Button) findViewById(R.id.seven);
        btn[8] = (Button) findViewById(R.id.eight);
        btn[9] = (Button) findViewById(R.id.nine);
        div = (Button) findViewById(R.id.divide);
        mul = (Button) findViewById(R.id.mul);
        sub = (Button) findViewById(R.id.sub);
        add = (Button) findViewById(R.id.add);
        equal = (Button) findViewById(R.id.equal);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        log = (Button) findViewById(R.id.log);
        ln = (Button) findViewById(R.id.ln);
        factorial = (Button) findViewById(R.id.factorial);
        bksp = (Button) findViewById(R.id.bksp);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        dot = (Button) findViewById(R.id.point);
        mc = (Button) findViewById(R.id.mc);
        c = (Button) findViewById(R.id.c);

        //数字监听器
        for (int i = 0; i < 10; ++i) {
            btn[i].setOnClickListener(actionPerformed);
        }

        //加减乘除监听器
        div.setOnClickListener(actionPerformed);
        mul.setOnClickListener(actionPerformed);
        sub.setOnClickListener(actionPerformed);
        add.setOnClickListener(actionPerformed);
        equal.setOnClickListener(actionPerformed);
        sin.setOnClickListener(actionPerformed);
        cos.setOnClickListener(actionPerformed);
        tan.setOnClickListener(actionPerformed);
        log.setOnClickListener(actionPerformed);
        ln.setOnClickListener(actionPerformed);
        factorial.setOnClickListener(actionPerformed);
        bksp.setOnClickListener(actionPerformed);
        left.setOnClickListener(actionPerformed);
        right.setOnClickListener(actionPerformed);
        dot.setOnClickListener(actionPerformed);
        mc.setOnClickListener(actionPerformed);
        c.setOnClickListener(actionPerformed);
    }

    String[] Tipcommand = new String[500];   //Tipcommand的指针

    int tip_i = 0;
    private View.OnClickListener actionPerformed = new View.OnClickListener() {
        public void onClick(View v) {
            String command = ((Button)v).getText().toString();    //按键上的命令获取
            String str = input.getText().toString();

            //检测输入是否合法
            if(equals_flag == false && "0123456789.()sincostanlnlogn!+-×÷√^".indexOf(command) != -1) {
                if(right(str)) {
                    if("+-×÷√^)".indexOf(command) != -1) {
                        for(int i =0 ; i < str.length(); i++) {
                            Tipcommand[tip_i] = String.valueOf(str.charAt(i));
                            tip_i++;
                        }
                        vbegin = false;
                    }
                } else {
                    input.setText("0");
                    vbegin = true;
                    tip_i = 0;
                    tip_lock = true;
                    tip.setText("开始计算");
                }
                equals_flag = true;
            }

            if("0123456789.()sincostanlnlogn!+-×÷√^".indexOf(command) != -1 && tip_lock) {
                Tipcommand[tip_i] = command;
                tip_i++;
            }
            if("0123456789.()sincostanlnlogn!+-×÷√^".indexOf(command) != -1 && tip_lock) {
                print(command);
            } else if(command.compareTo("B") == 0 && equals_flag) {
                //删除3个字符
                if(TTO(str) == 3) {
                    if(str.length() > 3)
                        input.setText(str.substring(0, str.length() - 3));
                    else if(str.length() == 3) {
                        input.setText("0");
                        vbegin = true;
                        tip_i = 0;
                        tip.setText("欢迎使用！");
                    }
                    //删除2个字符
                } else if(TTO(str) == 2) {
                    if(str.length() > 2)
                        input.setText(str.substring(0, str.length() - 2));
                    else if(str.length() == 2) {
                        input.setText("0");
                        vbegin = true;
                        tip_i = 0;
                        tip.setText("欢迎使用！");
                    }
                    //删除一个字符
                } else if(TTO(str) == 1) {
                    if(right(str)) {
                        if(str.length() > 1)
                            input.setText(str.substring(0, str.length() - 1));
                        else if(str.length() == 1) {
                            input.setText("0");
                            vbegin = true;
                            tip_i = 0;
                            tip.setText("欢迎使用！");
                        }
                    } else {
                        input.setText("0");
                        vbegin = true;
                        tip_i = 0;
                        tip.setText("欢迎使用！");
                    }
                }

                if(input.getText().toString().compareTo("-") == 0 || equals_flag == false) {
                    input.setText("0");
                    vbegin = true;
                    tip_i = 0;
                    tip.setText("欢迎使用！");
                }
                tip_lock = true;
                if(tip_i > 0)
                    tip_i--;
            } else if(command.compareTo("B") == 0 && equals_flag ==false) {
                input.setText("0");
                vbegin = true;
                tip_i = 0;
                tip_lock = true;
                tip.setText("欢迎使用！");

                //清除键
            } else if(command.compareTo("C") == 0) {
                input.setText("0");
                vbegin = true;
                tip_i = 0;
                tip_lock = true;
                equals_flag = true;
                tip.setText("欢迎使用！");
            } else if(command.compareTo("MC") == 0) {
                mem.setText("0");
            } else if(command.compareTo("exit") == 0) {
                System.exit(0);
            } else if(command.compareTo("=") == 0 && tip_lock && right(str) && equals_flag) {
                tip_i = 0;
                tip_lock = false;
                equals_flag = false;
                str_old = str;
                str = str.replaceAll("sin", "s");
                str = str.replaceAll("cos", "c");
                str = str.replaceAll("tan", "t");
                str = str.replaceAll("log", "g");
                str = str.replaceAll("ln", "l");
                str = str.replaceAll("n!", "!");

                vbegin = true;
                str_new = str.replaceAll("-", "-1×");
                new calc().process(str_new);
            }
            tip_lock = true;
        }
    };

    private void print(String str) {
        if(vbegin)
            input.setText(str);
        else
            input.append(str);
        vbegin = false;
    }

    //判断str是否合法
    private boolean right(String str) {
        int i = 0;
        for(i = 0;i < str.length();i++) {
            if(str.charAt(i)!='0' && str.charAt(i)!='1' && str.charAt(i)!='2' &&
                    str.charAt(i)!='3' && str.charAt(i)!='4' && str.charAt(i)!='5' &&
                    str.charAt(i)!='6' && str.charAt(i)!='7' && str.charAt(i)!='8' &&
                    str.charAt(i)!='9' && str.charAt(i)!='.' && str.charAt(i)!='-' &&
                    str.charAt(i)!='+' && str.charAt(i)!='×' && str.charAt(i)!='÷' &&
                    str.charAt(i)!='√' && str.charAt(i)!='^' && str.charAt(i)!='s' &&
                    str.charAt(i)!='i' && str.charAt(i)!='n' && str.charAt(i)!='c' &&
                    str.charAt(i)!='o' && str.charAt(i)!='t' && str.charAt(i)!='a' &&
                    str.charAt(i)!='l' && str.charAt(i)!='g' && str.charAt(i)!='(' &&
                    str.charAt(i)!=')' && str.charAt(i)!='!')
                break;
        }
        if(i == str.length()) {
            return true;
        } else {
            return false;
        }
    }

    //检测函数
    private int TTO(String str) {
        if((str.charAt(str.length() - 1) == 'n' &&
                str.charAt(str.length() - 2) == 'i' &&
                str.charAt(str.length() - 3) == 's') ||
                (str.charAt(str.length() - 1) == 's' &&
                        str.charAt(str.length() - 2) == 'o' &&
                        str.charAt(str.length() - 3) == 'c') ||
                (str.charAt(str.length() - 1) == 'n' &&
                        str.charAt(str.length() - 2) == 'a' &&
                        str.charAt(str.length() - 3) == 't') ||
                (str.charAt(str.length() - 1) == 'g' &&
                        str.charAt(str.length() - 2) == 'o' &&
                        str.charAt(str.length() - 3) == 'l')) {
            return 3;
        } else if((str.charAt(str.length() - 1) == 'n' &&
                str.charAt(str.length() - 2) == 'l') ||
                (str.charAt(str.length() - 1) == '!' &&
                        str.charAt(str.length() - 2) == 'n')) {
            return 2;
        } else { return 1; }
    }


    //计算函数
    public class calc {
        public calc(){

        }
        final int MAXLEN = 500;

        //计算部分，用栈实现，分运算数栈和运算符栈，有优先级
        public void process(String str) {
            int weightPlus = 0, topOp = 0,
                    topNum = 0, flag = 1, weightTemp = 0;
            int weight[];         //保存operator栈中运算符的优先级，以topOp计数
            double number[];                      //保存数字，以topNum计数
            char ch, ch_gai, operator[];          //operator[]保存运算符，以topOp计数
            String num;     //记录数字
            weight = new int[MAXLEN];
            number = new double[MAXLEN];
            operator = new char[MAXLEN];
            String expression = str;
            StringTokenizer expToken = new StringTokenizer(expression,"+-×÷()sctgl!");
            int i = 0;
            while (i < expression.length()) {
                ch = expression.charAt(i);
                //判断正负数
                if (i == 0) {
                    if (ch == '-')
                        flag = -1;
                } else if(expression.charAt(i-1) == '(' && ch == '-')
                    flag = -1;
                //取得数字，并将正负符号转移给数字
                if (ch <= '9' && ch >= '0'|| ch == '.' || ch == 'E') {
                    num = expToken.nextToken();
                    ch_gai = ch;
                    Log.e("guojs",ch+"--->"+i);
                    //取得整个数字
                    while (i < expression.length() &&
                            (ch_gai <= '9' && ch_gai >= '0'|| ch_gai == '.' || ch_gai == 'E'))
                    {
                        ch_gai = expression.charAt(i++);
                        Log.e("guojs","i的值为："+i);
                    }
                    //将指针退回之前的位置
                    if (i >= expression.length()) i-=1; else {i-=2;}
                    if (num.compareTo(".") == 0) number[topNum++] = 0;
                        //将正负符号转移给数字
                    else {
                        number[topNum++] = Double.parseDouble(num)*flag;
                        flag = 1;
                    }
                }

                //计算运算符的优先级
                if (ch == '(') weightPlus+=4;
                if (ch == ')') weightPlus-=4;
                if (ch == '-' && flag == 1 || ch == '+' || ch == '×'|| ch == '÷' ||
                        ch == 's' ||ch == 'c' || ch == 't' || ch == 'g' || ch == 'l' ||
                        ch == '!' || ch == '√' || ch == '^') {
                    switch (ch) {
                        //+-的优先级 1
                        case '+':
                        case '-':
                            weightTemp = 1 + weightPlus;
                            break;
                        //x÷的优先级 2
                        case '×':
                        case '÷':
                            weightTemp = 2 + weightPlus;
                            break;
                        //sin、cos之类函数的优先级 3
                        case 's':
                        case 'c':
                        case 't':
                        case 'g':
                        case 'l':
                        case '!':
                            weightTemp = 3 + weightPlus;
                            break;
                        //其余优先级为4
                        default:
                            weightTemp = 4 + weightPlus;
                            break;
                    }

                    if (topOp == 0 || weight[topOp-1] < weightTemp) {    //如果当前优先级大于栈顶部元素，则入栈
                        weight[topOp] = weightTemp;
                        operator[topOp] = ch;
                        topOp++;

                    }else {    //否则将栈中运算符逐个取出，直到当前栈顶运算符的优先级小于当前运算符
                        while (topOp > 0 && weight[topOp-1] >= weightTemp) {
                            switch (operator[topOp-1]) {
                                //取出数字数组的相应元素进行运算
                                case '+':
                                    number[topNum-2]+=number[topNum-1];
                                    break;
                                case '-':
                                    number[topNum-2]-=number[topNum-1];
                                    break;
                                case '×':
                                    number[topNum-2]*=number[topNum-1];
                                    break;
                                case '÷':
                                    if (number[topNum-1] == 0) {   //判断除数为0的情况
                                        showError(1,str_old);
                                        return;
                                    }
                                    number[topNum-2]/=number[topNum-1];
                                    break;
                                case '√':
                                    if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                                            number[topNum-1] % 2 == 0)) {
                                        showError(2,str_old);
                                        return;
                                    }
                                    number[topNum-2] =
                                            Math.pow(number[topNum-2], 1/number[topNum-1]);
                                    break;
                                case '^':
                                    number[topNum-2] =
                                            Math.pow(number[topNum-2], number[topNum-1]);
                                    break;
                                //sin
                                case 's':
                                    if(drg_flag == true) {
                                        number[topNum-1] = Math.sin((number[topNum-1]/180)*pi);
                                    } else {
                                        number[topNum-1] = Math.sin(number[topNum-1]);
                                    }
                                    topNum++;
                                    break;
                                //cos
                                case 'c':
                                    if(drg_flag == true) {
                                        number[topNum-1] = Math.cos((number[topNum-1]/180)*pi);
                                    } else {
                                        number[topNum-1] = Math.cos(number[topNum-1]);
                                    }
                                    topNum++;
                                    break;
                                //tan
                                case 't':
                                    if(drg_flag == true) {
                                        if((Math.abs(number[topNum-1])/90)%2 == 1) {
                                            showError(2,str_old);
                                            return;
                                        }
                                        number[topNum-1] = Math.tan((number[topNum-1]/180)*pi);
                                    } else {
                                        if((Math.abs(number[topNum-1])/(pi/2))%2 == 1) {
                                            showError(2,str_old);
                                            return;
                                        }
                                        number[topNum-1] = Math.tan(number[topNum-1]);
                                    }
                                    topNum++;
                                    break;
                                //log
                                case 'g':
                                    if(number[topNum-1] <= 0) {
                                        showError(2,str_old);
                                        return;
                                    }
                                    number[topNum-1] = Math.log10(number[topNum-1]);
                                    topNum++;
                                    break;
                                //ln
                                case 'l':
                                    if(number[topNum-1] <= 0) {
                                        showError(2,str_old);
                                        return;
                                    }
                                    number[topNum-1] = Math.log(number[topNum-1]);
                                    topNum++;
                                    break;
                                //阶乘
                                case '!':
                                    if(number[topNum-1] > 170) {
                                        showError(3,str_old);
                                        return;
                                    } else if(number[topNum-1] < 0) {
                                        showError(2,str_old);
                                        return;
                                    }
                                    number[topNum-1] = N(number[topNum-1]);
                                    topNum++;
                                    break;
                            }
                            //继续取堆栈的下一个元素进行判断
                            topNum--;
                            topOp--;
                        }
                        //将运算符入堆栈
                        weight[topOp] = weightTemp;
                        operator[topOp] = ch;
                        topOp++;
                    }
                }
                i++;
            }

            //依次取出堆栈的运算符进行运算
            while (topOp>0) {
                //+-x直接将数组的后两位数取出运算
                switch (operator[topOp-1]) {
                    case '+':
                        number[topNum-2]+=number[topNum-1];
                        break;
                    case '-':
                        number[topNum-2]-=number[topNum-1];
                        break;
                    case '×':
                        number[topNum-2]*=number[topNum-1];
                        break;
                    //除
                    case '÷':
                        if (number[topNum-1] == 0) {
                            showError(1,str_old);
                            return;
                        }
                        number[topNum-2]/=number[topNum-1];
                        break;
                    case '√':
                        if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                                number[topNum-1] % 2 == 0)) {
                            showError(2,str_old);
                            return;
                        }
                        number[topNum-2] =
                                Math.pow(number[topNum-2], 1/number[topNum-1]);
                        break;
                    case '^':
                        number[topNum-2] =
                                Math.pow(number[topNum-2], number[topNum-1]);
                        break;
                    //sin
                    case 's':
                        if(drg_flag == true) {
                            number[topNum-1] = Math.sin((number[topNum-1]/180)*pi);
                        } else {
                            number[topNum-1] = Math.sin(number[topNum-1]);
                        }
                        topNum++;
                        break;
                    //cos
                    case 'c':
                        if(drg_flag == true) {
                            number[topNum-1] = Math.cos((number[topNum-1]/180)*pi);
                        } else {
                            number[topNum-1] = Math.cos(number[topNum-1]);
                        }
                        topNum++;
                        break;
                    //tan
                    case 't':
                        if(drg_flag == true) {
                            if((Math.abs(number[topNum-1])/90)%2 == 1) {
                                showError(2,str_old);
                                return;
                            }
                            number[topNum-1] = Math.tan((number[topNum-1]/180)*pi);
                        } else {
                            if((Math.abs(number[topNum-1])/(pi/2))%2 == 1) {
                                showError(2,str_old);
                                return;
                            }
                            number[topNum-1] = Math.tan(number[topNum-1]);
                        }
                        topNum++;
                        break;
                    //对数log
                    case 'g':
                        if(number[topNum-1] <= 0) {
                            showError(2,str_old);
                            return;
                        }
                        number[topNum-1] = Math.log10(number[topNum-1]);
                        topNum++;
                        break;
                    //自然对数ln
                    case 'l':
                        if(number[topNum-1] <= 0) {
                            showError(2,str_old);
                            return;
                        }
                        number[topNum-1] = Math.log(number[topNum-1]);
                        topNum++;
                        break;
                    //阶乘
                    case '!':
                        if(number[topNum-1] > 170) {
                            showError(3,str_old);
                            return;
                        } else if(number[topNum-1] < 0) {
                            showError(2,str_old);
                            return;
                        }
                        number[topNum-1] = N(number[topNum-1]);
                        topNum++;
                        break;
                }
                //取堆栈下一个元素计算
                topNum--;
                topOp--;
            }
            //如果数字太大，提示错误
            if(number[0] > 7.3E306) {
                showError(3,str_old);
                return;
            }
            //输出最终结果
            input.setText(String.valueOf(FP(number[0])));
            tip.setText("计算完毕，继续请按归零键 C");
            mem.setText(str_old+"="+String.valueOf(FP(number[0])));
        }


        //数据格式化
        public double FP(double n) {
            DecimalFormat format = new DecimalFormat("0.#############");
            return Double.parseDouble(format.format(n));
        }


        //阶乘算法
        public double N(double n) {
            int i = 0;
            double sum = 1;
            for(i = 1;i <= n;i++) {
                sum = sum*i;
            }
            return sum;
        }

       //错误提示
        public void showError(int code ,String str) {
            String message="";
            switch (code) {
                case 1:
                    message = "零不能作除数";
                    break;
                case 2:
                    message = "函数格式错误";
                    break;
                case 3:
                    message = "数值太大，超出范围";
            }
            input.setText("\""+str+"\""+": "+message);
            tip.setText(message+"\n"+"计算完毕，继续请按归零键 C");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //菜单 “计算器、长度单位转换、进制转换”
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.calculator:
                Toast.makeText(this, "当前正是计算器", Toast.LENGTH_SHORT).show();
                break;
            case R.id.transformLength:
                Intent intent = new Intent(MainActivity.this, TransformateLength.class);
                startActivity(intent);
                break;
            case R.id.transformBase:
                Intent intent2 = new Intent(MainActivity.this, TransformateBase.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}