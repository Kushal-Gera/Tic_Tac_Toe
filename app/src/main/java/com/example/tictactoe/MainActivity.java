package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextView header;
    String[][] arr = new String[3][3];
    Button[][] b_arr;
    boolean player1 = true;
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i <3; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = "";

        setupbtn();

        b_arr = new Button[][]{{b1, b2, b3}, {b4, b5, b6}, {b7, b8, b9}};


    }

    @SuppressLint("SetTextI18n")
    private void markBoard() {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = b_arr[i][j].getText().toString();

        checkForWin();

        if (win){
            for (int i = 0; i <3; i++)
                for (int j = 0; j < 3; j++)
                    b_arr[j][i].setEnabled(false);

            header.setText("WIN WIN WIN !");
            win = false;

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clear_all();
                }
            }, 2500);
        }

    }

    private void checkForWin() {

        for (int i = 0; i < 3; i++) {
            //check for Horizontal rows
            if (arr[i][0].equals(arr[i][1]) && arr[i][2].equals(arr[i][1]) &&!arr[i][0].equals("") ){
                win = true;
            }

            //check for Vertical rows
            if (arr[0][i].equals(arr[1][i]) && arr[2][i].equals(arr[1][i]) &&!arr[0][i].equals("") ){
                win = true;
                }
            }

            //check for Diagonal 1
            if (arr[0][0].equals(arr[1][1]) && arr[1][1].equals(arr[2][2]) &&!arr[1][1].equals("") ){
                win = true;
            }

            //check for Diagonal 2
            if (arr[0][2].equals(arr[1][1]) && arr[1][1].equals(arr[2][0]) &&!arr[1][1].equals("") ){
                win = true;
            }


    }

    private void setupbtn() {
        header = findViewById(R.id.header);

        b1 = findViewById(R.id.btn1);   b2 = findViewById(R.id.btn2);   b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);   b5 = findViewById(R.id.btn5);   b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);   b8 = findViewById(R.id.btn8);   b9 = findViewById(R.id.btn9);

        b1.setOnClickListener(this);    b2.setOnClickListener(this);    b3.setOnClickListener(this);
        b4.setOnClickListener(this);    b5.setOnClickListener(this);    b6.setOnClickListener(this);
        b7.setOnClickListener(this);    b8.setOnClickListener(this);    b9.setOnClickListener(this);

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_all();
            }
        });

    }

    private void clear_all() {
        header.setText("Tic Tac Toe");

        for (int i = 0; i <3; i++)
            for (int j = 0; j < 3; j++) {
                b_arr[j][i].setEnabled(true);
                b_arr[j][i].setText("");
            }
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;
        if (player1){
            b.setText("X");
            player1 = false;
        }
        else{
            b.setText("O");
            player1 = true;

        }
        b.setEnabled(false);
        markBoard();






    }



}
