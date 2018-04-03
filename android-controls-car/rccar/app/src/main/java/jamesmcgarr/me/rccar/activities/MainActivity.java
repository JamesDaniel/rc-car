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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forwardBtn = findViewById(R.id.forwardBtn);
        forwardBtn.setOnClickListener(this);
        backwardBtn = findViewById(R.id.backwardBtn);
        backwardBtn.setOnClickListener(this);
        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(this);
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
        }
    }


}
