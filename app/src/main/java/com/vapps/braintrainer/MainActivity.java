package com.vapps.braintrainer;




import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;






public class MainActivity extends AppCompatActivity {

    int correctAnswer;

    int score=0;

    int total;



    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button go;




    TextView questionTextView;
    TextView messageTextView;
    TextView scoreTextView;
    TextView timerTextView;
    TextView messageTextView1;
    TextView messageTextView2;


    GridLayout gridLayout;


    ArrayList<Integer> answers= new ArrayList<Integer>();




    public void appStart(View view)
    {


        scoreTextView.setVisibility(View.VISIBLE);

        questionTextView.setVisibility(View.VISIBLE);

        gridLayout.setVisibility(View.VISIBLE);

        timerTextView.setVisibility(View.VISIBLE);

        messageTextView.setVisibility(View.VISIBLE);

        messageTextView.setText("");

        go.setVisibility(View.INVISIBLE);

        total=0;

        score=0;

        timerMethod();

        questionCreator();


    }



    public void questionCreator()

      {


        Random random = new Random();

          int a = random.nextInt(25);

          int b=random.nextInt(23);

          questionTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

          correctAnswer=random.nextInt(4);


        for (int i=0;i<4;++i)
        {
            if(i==correctAnswer)
            {
                answers.add(a+b);
            }
            else {
                int c=random.nextInt(49);

                while (c==a+b)

                {
                    c=random.nextInt(49);
                }

                answers.add(c);

            }


        }



          button0.setText(Integer.toString(answers.get(0)));

          button1.setText(Integer.toString(answers.get(1)));

          button2.setText(Integer.toString(answers.get(2)));

          button3.setText(Integer.toString(answers.get(3)));

          answers.clear();


          ++total;



    }




public void answerClicked(View view)
{


    if(view.getTag().toString().equals (Integer.toString(correctAnswer)))

    {

        ++score;
        messageTextView.setText("Correct!");

    }
    else{

        messageTextView.setText("Incorrect!");
    }



    scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(total));

    questionCreator();


}





public void timerMethod()
{

    new CountDownTimer(30000,1000)
    {
        @Override
        public void onTick(long millisUntilFinished)
        {

            timerTextView.setText("0"+":"+String.format("%02d",((int)millisUntilFinished)/1000));
        }

        @Override
        public void onFinish() {
            messageTextView2.setText("Your Score:\n"+"   "+ Integer.toString(score)+"/"+Integer.toString(total));

            messageTextView1.setText("Time Up!");

            scoreTextView.setVisibility(View.INVISIBLE);

            questionTextView.setVisibility(View.INVISIBLE);

            gridLayout.setVisibility(View.INVISIBLE);

            timerTextView.setVisibility(View.INVISIBLE);

            messageTextView.setVisibility(View.INVISIBLE);

            scoreTextView.setText("0"+"/"+"0");

            messageTextView1.setVisibility(View.VISIBLE);

            messageTextView2.setVisibility(View.VISIBLE);


            new CountDownTimer(2000,1000)
            {
                @Override
                public void onTick(long millisUntilFinished)
                {

                }

                @Override
                public void onFinish() {

                    go.setText("Play\nAgain!");

                    go.setTextSize(40f);

                    go.setPadding(30,30,30,30);

                    go.setVisibility(View.VISIBLE);

                    messageTextView2.setVisibility(View.INVISIBLE);

                    messageTextView1.setVisibility(View.INVISIBLE);


                }
            }.start();

        }



    }.start();


}





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



         button0=(Button)findViewById(R.id.button0);

         button1=(Button)findViewById(R.id.button1);

         button2=(Button)findViewById(R.id.button2);

         button3=(Button)findViewById(R.id.button3);

         go=(Button)findViewById(R.id.appStart);



         questionTextView=(TextView)findViewById(R.id.questionTextView);

         messageTextView=(TextView)findViewById(R.id.messageTextView);

         scoreTextView=(TextView)findViewById(R.id.scoreTextView);

         timerTextView=(TextView)findViewById(R.id.timerTextView);

         messageTextView1=(TextView)findViewById(R.id.messageTextView1);

         messageTextView2=(TextView)findViewById(R.id.messageTextView2);

         gridLayout = (GridLayout)findViewById(R.id.grid);




    }
}
