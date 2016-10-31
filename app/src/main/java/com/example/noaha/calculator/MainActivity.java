package com.example.noaha.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //声明组件
    TextView txtAll;
    TextView txtEnter;

    Button btnRoot;
    Button btnSqure;
    Button btnSin;
    Button btnCos;

    Button btnAllClean;
    Button btnCleanEnter;
    Button btnBack;
    Button btnDiv;

    Button btnKey7;
    Button btnKey8;
    Button btnKey9;
    Button btnMul;

    Button btnKey4;
    Button btnKey5;
    Button btnKey6;
    Button btnSub;

    Button btnKey1;
    Button btnKey2;
    Button btnKey3;
    Button btnAdd;

    Button btnOpp;
    Button btnKey0;
    Button btnPoint;
    Button btnEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //组件配对


        btnRoot = (Button) findViewById(R.id.buttonRoot);
        btnSqure = (Button) findViewById(R.id.buttonSqure);
        btnSin = (Button) findViewById(R.id.buttonSin);
        btnCos = (Button) findViewById(R.id.buttonCos);

        btnAllClean = (Button) findViewById(R.id.buttonAllClean);
        btnCleanEnter = (Button) findViewById(R.id.buttonCleanEnter);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnDiv = (Button) findViewById(R.id.buttonDiv);

        btnKey7 = (Button) findViewById(R.id.buttonKey7);
        btnKey8 = (Button) findViewById(R.id.buttonKey8);
        btnKey9 = (Button) findViewById(R.id.buttonKey9);
        btnMul = (Button) findViewById(R.id.buttonMul);

        btnKey4 = (Button) findViewById(R.id.buttonKey4);
        btnKey5 = (Button) findViewById(R.id.buttonKey5);
        btnKey6 = (Button) findViewById(R.id.buttonKey6);
        btnSub = (Button) findViewById(R.id.buttonSub);

        btnKey1 = (Button) findViewById(R.id.buttonKey1);
        btnKey2 = (Button) findViewById(R.id.buttonKey2);
        btnKey3 = (Button) findViewById(R.id.buttonKey3);
        btnAdd = (Button) findViewById(R.id.buttonAdd);

        btnOpp = (Button) findViewById(R.id.buttonOpp);
        btnKey0 = (Button) findViewById(R.id.buttonKey0);
        btnPoint = (Button) findViewById(R.id.buttonPoint);
        btnEqual = (Button) findViewById(R.id.buttonEqual);

        //触发器

        btnSin.setOnClickListener(this);
        btnRoot.setOnClickListener(this);
        btnSqure.setOnClickListener(this);
        btnCos.setOnClickListener(this);

        btnAllClean.setOnClickListener(this);
        btnCleanEnter.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnKey7.setOnClickListener(this);
        btnKey8.setOnClickListener(this);
        btnKey9.setOnClickListener(this);
        btnMul.setOnClickListener(this);

        btnKey4.setOnClickListener(this);
        btnKey5.setOnClickListener(this);
        btnKey6.setOnClickListener(this);
        btnSub.setOnClickListener(this);

        btnKey1.setOnClickListener(this);
        btnKey2.setOnClickListener(this);
        btnKey3.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        btnOpp.setOnClickListener(this);
        btnKey0.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }

    /*
    触发器

    数字按钮 0、1、2、3、4、5、6、7、8、9
    判断计算完成计数是否为true，是就重置num1,num2,txtEnter，然后将数字加入txtEnter
    否则直接键入txtEnter

    小数点按钮 .
    先判断之前是否有小数点，如果有则加入""，否则继续，
    再判断txtEnter是否为空，为空的话就把"0."加入txtEnter，否则直接加"."

    基本运算按钮 +-x÷
    先判断op内是否有值，有(此时num1、num2应该均有值，num1无值时默认为0)则先提取op的运算符，进行运算，结果给num1，然后将运算符直接赋给op，运算符加入txtAll；
    没有值则提取txtEnter的数，其值赋给num1，数字+运算符字符串加入txtAll，运算符赋给op


    等于按钮
    计算num1 op num2结果给num1，显示在txtEnter，计算完成计数true

    back按钮
    txtEnter字符串去掉最后一位

    CE按钮
    重置txtEnter

    AE按钮
    重置所有变量
     */
    boolean flag = false;//记录是否刚完成一次计算

    String strAll = "";
    String strEnter = "";

    public void onClick(View v){

        txtAll = (TextView) findViewById(R.id.textAll);
        txtEnter = (TextView) findViewById(R.id.testEnter);

        strEnter = txtEnter.getText().toString();
        strAll = txtAll.getText().toString();



        switch (v.getId()){

            /*
        数字按钮 0、1、2、3、4、5、6、7、8、9
        判断计算完成计数是否为true，是就重置num1,num2,txtEnter,txtAll，然后将数字加入txtEnter
        否则直接键入txtEnter
             */
            case R.id.buttonKey0:
            case R.id.buttonKey1:
            case R.id.buttonKey2:
            case R.id.buttonKey3:
            case R.id.buttonKey4:
            case R.id.buttonKey5:
            case R.id.buttonKey6:
            case R.id.buttonKey7:
            case R.id.buttonKey8:
            case R.id.buttonKey9:
                if ("0".equals(strEnter) || flag == true) {
                    txtEnter.setText(((Button)v).getText());
                    flag = false;
                } else
                    txtEnter.setText(strEnter + ((Button)v).getText());
                break;

            /*
            小数点按钮 .
            先判断之前是否有小数点，如果有则加入""，否则继续，
            再判断txtEnter是否为空，为空的话就把"0."加入txtEnter，否则直接加"."
             */
            case R.id.buttonPoint:
                if(flag == true){
                    txtEnter.setText("0.");
                    flag = false;
                }else {
                    if(!strEnter.contains("."))
                        txtEnter.setText(strEnter + ".");
                }
                break;


            /*
            基本运算按钮 +-x÷
    先判断strAll内是否有值，再判断txtEnter有没有值默认值除外有则进行运算，新运算符加入txtAll；
    没有则提取txtEnter的数，数字+运算符字符串加入txtAll


    txtAll
    有数有运算符  计算，txtAll加新运算符
    有数无运算符  不可能
    无数无运算符  此时txtEnter应该有值（或默认值）,txtEnter的字符串加入txtAll再加运算符
    连续按运算符按钮时，有bug
             */
            case R.id.buttonMul:
            case R.id.buttonDiv:
            case R.id.buttonSub:
            case R.id.buttonAdd:
                if ("error".equals(strEnter))      //判断是否为error
                    break;
                strEnter = predigest(strEnter);       //将输入框内的字符串多余的后缀去掉

                if ("".equals(strAll)) {
                    txtAll.setText(strEnter + " " + ((Button) v).getText().toString());
                    txtEnter.setText("0");
                } else {
                    String result = getResult();
                    txtAll.setText(result + " " + ((Button) v).getText().toString());
                    txtEnter.setText("0");
                }break;

            case R.id.buttonBack:
                if(strEnter.length()>=1) txtEnter.setText(strEnter.substring(0, strEnter.length()-1));
                break;

            case R.id.buttonCleanEnter:
                txtEnter.setText("");
                break;

            case R.id.buttonAllClean:
                txtAll.setText("");
                txtEnter.setText("");
                break;

            //相反数
            case R.id.buttonOpp:
                if(!strEnter.equals("")||strEnter==null){
                    if(strEnter.contains("-")) txtEnter.setText(strEnter.substring(1,strEnter.length()));
                    else txtEnter.setText("-" + strEnter);
                }
                break;

            //sin
            case R.id.buttonSin:
                if(!strEnter.equals("")||strEnter==null)
                {
                    double n = Double.parseDouble(strEnter);
                    n = Math.sin(n*Math.PI/180);
                    String s = n + "";
                    txtEnter.setText(s);
                    flag = true;
                }
                break;


            //平方根
            case R.id.buttonRoot:
                if(!strEnter.equals("")||strEnter==null){
                    double n = Double.parseDouble(strEnter);
                    n = StrictMath.sqrt(n);
                    String s = n + "";
                    txtEnter.setText(s);
                    flag = true;
                }
                break;

            //平方
            case R.id.buttonSqure:
                if(!strEnter.equals("")||strEnter==null){
                    double n = Double.parseDouble(strEnter);
                    n = n*n;
                    String s = n + "";
                    txtEnter.setText(s);
                    flag = true;
                }
                break;

            //cos
            case R.id.buttonCos:
                if(!strEnter.equals("")||strEnter==null){
                    double n = Double.parseDouble(strEnter);
                    n = Math.cos(n*Math.PI/180);
                    String s = n + "";
                    txtEnter.setText(s);
                    flag = true;
                }
                break;

            case R.id.buttonEqual:
                if (!"".equals(strAll)) {
                    String result = getResult();
                    txtEnter.setText(result);
                    txtAll.setText("");
                    flag = true;
                }

        }
    }

    /*
    计算
    先取txtAll的最后为运算符，去掉运算符和空格，剩下的就是num1
    txtEnter为num2
     */
    //计算结果，获取两个框内的字符串，分解为两个数和一个运算符，再进行运算
    public String getResult() {
        txtAll = (TextView) findViewById(R.id.textAll);
        txtEnter = (TextView) findViewById(R.id.testEnter);
        String s1 = txtAll.getText().toString();
        String s2 = txtEnter.getText().toString();

        double firstNumber = Double.parseDouble(s1.substring(0, s1.length() - 2));
        double secondNumber = Double.parseDouble(s2);
        double result = 0;
        int isnull = 0;             //判断做除法时除数为0的情况
        String resultString = "";

        switch (s1.charAt(s1.length() - 1)) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case 'X':
                result = firstNumber * secondNumber;
                break;
            case '÷':
                if (secondNumber != 0)
                    result = firstNumber / secondNumber;
                else
                    isnull = 1;
                break;
            default:
        }
        if (isnull == 1)
            return "error";

        resultString = result + "";
        resultString = predigest(resultString);

        if ("-0".equals(resultString))
            resultString = "0";

        return resultString;
    }

    //简化字符串
    public String predigest(String s) {
        int tip = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                tip = 1;
                break;
            }
        }
        if (tip == 1) {
            while (s.charAt(s.length() - 1) == '0') {
                s = s.substring(0, s.length() - 1);
            }
            if (s.charAt(s.length() - 1) == '.')
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent intent=new Intent(MainActivity.this,HelpActivity.class);
            startActivity(intent);
        }

        if(id == R.id.action_turn){
            Intent intent=new Intent(MainActivity.this,TurnActivity.class);
            startActivity(intent);
        }

        if(id == R.id.action_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
