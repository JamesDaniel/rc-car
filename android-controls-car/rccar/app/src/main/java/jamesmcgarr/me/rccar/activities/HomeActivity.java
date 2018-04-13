package jamesmcgarr.me.rccar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jamesmcgarr.me.rccar.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button controllerBtn;
    private Button neuroskySetupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        controllerBtn = findViewById(R.id.controllerBtn);
        neuroskySetupBtn = findViewById(R.id.neuroskySetupBtn);
        controllerBtn.setOnClickListener(this);
        neuroskySetupBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.controllerBtn:
                startActivity(new Intent(this, DirectRcCarControls.class));
                break;
            case R.id.neuroskySetupBtn:
                startActivity(new Intent(this, NeuroSkySetupActivity.class));
                break;
            default:

        }
    }
}
