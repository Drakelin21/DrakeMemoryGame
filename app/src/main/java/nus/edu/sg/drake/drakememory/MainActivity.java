package nus.edu.sg.drake.drakememory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.view.View;
import android.app.*;
import android.content.*;
import android.os.Handler;
import android.os.SystemClock;

import java.util.ArrayList;
import android.os.CountDownTimer;




public class MainActivity extends AppCompatActivity {


    TextView p1,p2,timerView;

    ImageView imageView01_1,imageView01_2,imageView01_3,imageView01_4;
    ImageView imageView02_1,imageView02_2,imageView02_3,imageView02_4;
    ImageView imageView03_1,imageView03_2,imageView03_3,imageView03_4;

    //array for images
    Integer[] cardsArray ={101,102,103,104,105,106,201,202,203,204,205,206};

    //actual images
    int image101,image102,image103,image104,image105,image106;
    int image201,image202,image203,image204,image205,image206;

    int firstCard,secondCard;
    int clickedFirst,clickedSecond;
    int cardNum = 1;

    int turn = 1;
    int p1Points = 1;
    int p2Points = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        timerView = (TextView) findViewById(R.id.timerView);

        //first row
        imageView01_1 = (ImageView) findViewById(R.id.imageView01_1);
        imageView01_2 = (ImageView) findViewById(R.id.imageView01_2);
        imageView01_3 = (ImageView) findViewById(R.id.imageView01_3);
        imageView01_4 = (ImageView) findViewById(R.id.imageView01_4);

        //second row
        imageView02_1 = (ImageView) findViewById(R.id.imageView02_1);
        imageView02_2 = (ImageView) findViewById(R.id.imageView02_2);
        imageView02_3 = (ImageView) findViewById(R.id.imageView02_3);
        imageView02_4 = (ImageView) findViewById(R.id.imageView02_4);

        //third row
        imageView03_1 = (ImageView) findViewById(R.id.imageView03_1);
        imageView03_2 = (ImageView) findViewById(R.id.imageView03_2);
        imageView03_3 = (ImageView) findViewById(R.id.imageView03_3);
        imageView03_4 = (ImageView) findViewById(R.id.imageView03_4);

        imageView01_1.setTag("0");
        imageView01_2.setTag("1");
        imageView01_3.setTag("2");
        imageView01_4.setTag("3");
        imageView02_1.setTag("4");
        imageView02_2.setTag("6");
        imageView02_3.setTag("7");
        imageView02_4.setTag("8");
        imageView03_1.setTag("9");
        imageView03_2.setTag("10");
        imageView03_3.setTag("11");
        imageView03_4.setTag("12");

        //load the card images
        cardFrontResources();

        //shuffle the cards
        Collections.shuffle(Arrays.asList(cardsArray));

        //set colour to texts
        p1.setTextColor(Color.BLUE);
        //(inactive)
        p2.setTextColor(Color.GRAY);

        CountUpTimer timer = new CountUpTimer(999999999) {
            public void onTick(int second) {
                timerView.setText(String.valueOf(second));
            }
        };

        timer.start();

        //FIRST ROW------------------------------------------------
        imageView01_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                    int theCard = Integer.parseInt((String)view.getTag());
                    magic(imageView01_1,theCard);
            }
        });

        imageView01_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView01_2,theCard);
            }
        });

        imageView01_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView01_3,theCard);
            }
        });

        imageView01_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView01_4,theCard);
            }
        });
        //--------------------------------------------------------

        //SECOND ROW------------------------------------------------
        imageView02_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView02_1,theCard);
            }
        });

        imageView02_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView02_2,theCard);

            }
        });

        imageView02_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView02_3,theCard);

            }
        });

        imageView02_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView02_4,theCard);

            }
        });
        //--------------------------------------------------------

        //THIRD ROW------------------------------------------------
        imageView03_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView03_1,theCard);

            }
        });

        imageView03_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView03_2,theCard);

            }
        });

        imageView03_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView03_3,theCard);

            }
        });

        imageView03_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                int theCard = Integer.parseInt((String)view.getTag());
                magic(imageView03_4,theCard);

            }
        });
        //--------------------------------------------------------

    }

    private void cardFrontResources(){
        //first half
        image101 = R.drawable.image01;
        image102 = R.drawable.image02;
        image103 = R.drawable.image03;
        image104 = R.drawable.image04;
        image105 = R.drawable.image05;
        image106 = R.drawable.image06;

        //duplicated half
        image201 = R.drawable.image01;
        image202 = R.drawable.image02;
        image203 = R.drawable.image03;
        image204 = R.drawable.image04;
        image205 = R.drawable.image05;
        image206 = R.drawable.image06;
    }

    private void magic(ImageView iv,int card){
        if(cardsArray[card]==101){
            iv.setImageResource(image101);
        }
        else if(cardsArray[card]==102){
            iv.setImageResource(image102);
        }
        else if(cardsArray[card]==103){
            iv.setImageResource(image103);
        }
        else if(cardsArray[card]==104){
            iv.setImageResource(image104);
        }
        else if(cardsArray[card]==105){
            iv.setImageResource(image105);
        }
        else if(cardsArray[card]==106){
            iv.setImageResource(image106);
        }
        else if(cardsArray[card]==201){
            iv.setImageResource(image201);
        }
        else if(cardsArray[card]==202){
            iv.setImageResource(image202);
        }
        else if(cardsArray[card]==203){
            iv.setImageResource(image203);
        }
        else if(cardsArray[card]==204){
            iv.setImageResource(image204);
        }
        else if(cardsArray[card]==205){
            iv.setImageResource(image205);
        }
        else if(cardsArray[card]==206){
            iv.setImageResource(image206);
        }

        //check which image is selected and store it to a temp variable

        if (cardNum == 1){
            firstCard = cardsArray[card];
            if(firstCard>200){
                firstCard = firstCard - 100;
            }
            cardNum = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        }
        else if (cardNum == 2){
            secondCard = cardsArray[card];
            if(secondCard>200){
                secondCard = secondCard - 100;
            }
            cardNum = 1;
            clickedSecond = card;

            imageView01_1.setEnabled(false);
            imageView01_2.setEnabled(false);
            imageView01_3.setEnabled(false);
            imageView01_4.setEnabled(false);
            imageView02_1.setEnabled(false);
            imageView02_2.setEnabled(false);
            imageView02_3.setEnabled(false);
            imageView02_4.setEnabled(false);
            imageView03_1.setEnabled(false);
            imageView03_2.setEnabled(false);
            imageView03_3.setEnabled(false);
            imageView03_4.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    //check if selected images match
                    matchculation();
                }
            },1000);
        }
    }

    private void matchculation(){

        //remove similar matches and add points
        if (firstCard == secondCard){
            if(clickedFirst == 0){
                imageView01_1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1){
                imageView01_2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 2){
                imageView01_3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 3){
                imageView01_4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 4){
                imageView02_1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 5){
                imageView02_2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 6){
                imageView02_3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 7){
                imageView02_4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 8){
                imageView03_1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 9){
                imageView03_2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 10){
                imageView03_3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 11){
                imageView03_4.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                imageView01_1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 1){
                imageView01_2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 2){
                imageView01_3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 3){
                imageView01_4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 4){
                imageView02_1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 5){
                imageView02_2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 6){
                imageView02_3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 7){
                imageView02_4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 8){
                imageView03_1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 9){
                imageView03_2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 10){
                imageView03_3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 11){
                imageView03_4.setVisibility(View.INVISIBLE);
            }

            if (turn == 1){
                p1Points++;
                p1.setText("P1: "+ p1Points);
            }else if (turn == 2){
                p2Points++;
                p2.setText("P2: "+ p2Points);
            }
        }else{
            imageView01_1.setImageResource(R.drawable.image00);
            imageView01_2.setImageResource(R.drawable.image00);
            imageView01_3.setImageResource(R.drawable.image00);
            imageView01_4.setImageResource(R.drawable.image00);
            imageView02_1.setImageResource(R.drawable.image00);
            imageView02_2.setImageResource(R.drawable.image00);
            imageView02_3.setImageResource(R.drawable.image00);
            imageView02_4.setImageResource(R.drawable.image00);
            imageView03_1.setImageResource(R.drawable.image00);
            imageView03_2.setImageResource(R.drawable.image00);
            imageView03_3.setImageResource(R.drawable.image00);
            imageView03_4.setImageResource(R.drawable.image00);

            //change Turns
            if(turn == 1){
                turn = 2;
                p1.setTextColor(Color.GRAY);
                p2.setTextColor(Color.BLUE);
            }else  if(turn == 2){
                turn = 1;
                p2.setTextColor(Color.GRAY);
                p1.setTextColor(Color.BLUE);
            }

        }
        imageView01_1.setEnabled(true);
        imageView01_2.setEnabled(true);
        imageView01_3.setEnabled(true);
        imageView01_4.setEnabled(true);
        imageView02_1.setEnabled(true);
        imageView02_2.setEnabled(true);
        imageView02_3.setEnabled(true);
        imageView02_4.setEnabled(true);
        imageView03_1.setEnabled(true);
        imageView03_2.setEnabled(true);
        imageView03_3.setEnabled(true);
        imageView03_4.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if(imageView01_1.getVisibility() == View.INVISIBLE &&
                imageView01_2.getVisibility() == View.INVISIBLE &&
                imageView01_3.getVisibility() == View.INVISIBLE &&
                imageView01_4.getVisibility() == View.INVISIBLE &&
                imageView02_1.getVisibility() == View.INVISIBLE &&
                imageView02_2.getVisibility() == View.INVISIBLE &&
                imageView02_3.getVisibility() == View.INVISIBLE &&
                imageView02_4.getVisibility() == View.INVISIBLE &&
                imageView03_1.getVisibility() == View.INVISIBLE &&
                imageView03_2.getVisibility() == View.INVISIBLE &&
                imageView03_3.getVisibility() == View.INVISIBLE &&
                imageView03_4.getVisibility() == View.INVISIBLE ) {
            AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("Game Over!\nP1: "+ p1Points+ "\nP2: "+ p2Points)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            Intent intent  = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            finish();
                        }
                    });
            AlertDialog alertdialog = alertDialogBuilder.create();
            alertdialog.show();
        }
    }

    public abstract class CountUpTimer extends CountDownTimer {
        private static final long INTERVAL_MS = 1000;
        private final long duration;

        protected CountUpTimer(long durationMs) {
            super(durationMs, INTERVAL_MS);
            this.duration = durationMs;
        }

        public abstract void onTick(int second);

        @Override
        public void onTick(long msUntilFinished) {
            int second = (int) ((duration - msUntilFinished) / 1000);
            onTick(second);
        }

        @Override
        public void onFinish() {
            onTick(duration / 1000);
        }
    }

}
