package kr.hs.emirim.w2036.project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView imgV = findViewById(R.id.imgv);
        TextView text1 = findViewById(R.id.text_result1);
        TextView text2 = findViewById(R.id.text_result2);
        Intent intent = new Intent();
        double w = intent.getDoubleExtra("weight", 0);
        double h = intent.getDoubleExtra("height", 0);
        // BMI : kg / ㎡ (체중 / 키의 제곱)
        double bmi = w / Math.pow(h/100, 2);

        String bmiStr = "";
        int imgSrcId = 0;

        if(bmi < 18.5) {
            bmiStr = "저";
            imgSrcId = R.drawable.bmi_1;
        }else if(bmi < 24) {
            bmiStr = "정상";
            imgSrcId = R.drawable.bmi_2;
        }else if(bmi < 30) {
            bmiStr = "보통";
            imgSrcId = R.drawable.bmi_3;
        }else if(bmi < 35) {
            bmiStr = "비만";
            imgSrcId = R.drawable.bmi_4;
        }else if(bmi < 40) {
            bmiStr = "고도비만";
            imgSrcId = R.drawable.bmi_5;
        }else{
            bmiStr = "초고도비만";
            imgSrcId = R.drawable.bmi_6;
        } //end of if

        imgV.setImageResource(imgSrcId);
        text1.setText(bmiStr + "체중");
    }
}