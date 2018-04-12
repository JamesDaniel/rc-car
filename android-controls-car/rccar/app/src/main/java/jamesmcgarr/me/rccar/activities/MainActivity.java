package jamesmcgarr.me.rccar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import jamesmcgarr.me.rccar.R;
import jamesmcgarr.me.rccar.utils.AppConstants;
import jamesmcgarr.me.rccar.utils.HttpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button forwardBtn;
    private Button backwardBtn;
    private Button stopBtn;
    private Button clockwiseBtn;
    private Button anticlockwiseBtn;
    private Button speed1Btn;
    private Button speed2Btn;
    private Button speed3Btn;
    private Button speed4Btn;
    private Button speed5Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forwardBtn = findViewById(R.id.forwardBtn);
        backwardBtn = findViewById(R.id.backwardBtn);
        stopBtn = findViewById(R.id.stopBtn);
        clockwiseBtn = findViewById(R.id.clockwiseBtn);
        anticlockwiseBtn = findViewById(R.id.anticlockwiseBtn);
        speed1Btn = findViewById(R.id.speed1Btn);
        speed2Btn = findViewById(R.id.speed2Btn);
        speed3Btn = findViewById(R.id.speed3Btn);
        speed4Btn = findViewById(R.id.speed4Btn);
        speed5Btn = findViewById(R.id.speed5Btn);


        forwardBtn.setOnClickListener(this);
        backwardBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        clockwiseBtn.setOnClickListener(this);
        anticlockwiseBtn.setOnClickListener(this);
        speed1Btn.setOnClickListener(this);
        speed2Btn.setOnClickListener(this);
        speed3Btn.setOnClickListener(this);
        speed4Btn.setOnClickListener(this);
        speed5Btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forwardBtn:
                HttpUtils.get(AppConstants.FORWARD_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.backwardBtn:
                HttpUtils.get(AppConstants.BACKWARD_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.stopBtn:
                HttpUtils.get(AppConstants.STOP_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.clockwiseBtn:
                HttpUtils.get(AppConstants.CLOCKWISE_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.anticlockwiseBtn:
                HttpUtils.get(AppConstants.ANTICLOCKWISE_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.speed1Btn:
                HttpUtils.get(AppConstants.SPEED1_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.speed2Btn:
                HttpUtils.get(AppConstants.SPEED2_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.speed3Btn:
                HttpUtils.get(AppConstants.SPEED3_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.speed4Btn:
                HttpUtils.get(AppConstants.SPEED4_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.speed5Btn:
                HttpUtils.get(AppConstants.SPEED5_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
        }
    }


}
