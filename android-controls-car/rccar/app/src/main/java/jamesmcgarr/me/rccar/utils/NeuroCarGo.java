package jamesmcgarr.me.rccar.utils;

import android.os.CountDownTimer;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class NeuroCarGo {

    private static final String TAG = "NeuroCarGo";
    private int rawEeg;
    private int rawEegSum = 0;
    private int rawEegMax;
    private int rawEegMin;

    public NeuroCarGo() {
        monitorEegForCarGo();
    }

    public void setRawEeg(int rawEeg) {
        this.rawEeg = rawEeg;
        if (rawEeg > rawEegMax)
            rawEegMax = rawEeg;
        if (rawEeg < rawEegMin)
            rawEegMin = rawEeg;
        rawEegSum += rawEeg;
    }

    public void monitorEegForCarGo() {
        new CountDownTimer(100000000, 2000) {
            @Override
            public void onTick(long l) {
                Log.d(TAG, "tick");
                if (rawEegMax > 1600) {
                    carGo();
                    rawEegMax = 0;
                }
                else
                    carNoGo();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void carGo() {
        HttpUtils.get(AppConstants.INSTRUCTION3_COMMAND, new RequestParams(), new JsonHttpResponseHandler()); // direction forward
        HttpUtils.get(AppConstants.INSTRUCTION9_COMMAND, new RequestParams(), new JsonHttpResponseHandler()); // speed full
    }

    public void carNoGo() {
        HttpUtils.get(AppConstants.INSTRUCTION0_COMMAND, new RequestParams(), new JsonHttpResponseHandler()); // speed stop
    }

}
