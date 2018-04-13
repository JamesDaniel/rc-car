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

public class DirectRcCarControls extends AppCompatActivity implements View.OnClickListener{

    private Button instruction0Btn;
    private Button instruction1Btn;
    private Button instruction2Btn;
    private Button instruction3Btn;
    private Button instruction4Btn;
    private Button instruction5Btn;
    private Button instruction6Btn;
    private Button instruction7Btn;
    private Button instruction8Btn;
    private Button instruction9Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_rc_car_controls);

        instruction0Btn = findViewById(R.id.instruction0Btn);
        instruction1Btn = findViewById(R.id.instruction1Btn);
        instruction2Btn = findViewById(R.id.instruction2Btn);
        instruction3Btn = findViewById(R.id.instruction3Btn);
        instruction4Btn = findViewById(R.id.instruction4Btn);
        instruction5Btn = findViewById(R.id.instruction5Btn);
        instruction6Btn = findViewById(R.id.instruction6Btn);
        instruction7Btn = findViewById(R.id.instruction7Btn);
        instruction8Btn = findViewById(R.id.instruction8Btn);
        instruction9Btn = findViewById(R.id.instruction9Btn);


        instruction0Btn.setOnClickListener(this);
        instruction1Btn.setOnClickListener(this);
        instruction2Btn.setOnClickListener(this);
        instruction3Btn.setOnClickListener(this);
        instruction4Btn.setOnClickListener(this);
        instruction5Btn.setOnClickListener(this);
        instruction6Btn.setOnClickListener(this);
        instruction7Btn.setOnClickListener(this);
        instruction8Btn.setOnClickListener(this);
        instruction9Btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.instruction0Btn:
                HttpUtils.get(AppConstants.INSTRUCTION3_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction1Btn:
                HttpUtils.get(AppConstants.INSTRUCTION4_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction2Btn:
                HttpUtils.get(AppConstants.INSTRUCTION0_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction3Btn:
                HttpUtils.get(AppConstants.INSTRUCTION1_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction4Btn:
                HttpUtils.get(AppConstants.INSTRUCTION2_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction5Btn:
                HttpUtils.get(AppConstants.INSTRUCTION5_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction6Btn:
                HttpUtils.get(AppConstants.INSTRUCTION6_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction7Btn:
                HttpUtils.get(AppConstants.INSTRUCTION7_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction8Btn:
                HttpUtils.get(AppConstants.INSTRUCTION8_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
            case R.id.instruction9Btn:
                HttpUtils.get(AppConstants.INSTRUCTION9_COMMAND, new RequestParams(), new JsonHttpResponseHandler());
                break;
        }
    }


}
