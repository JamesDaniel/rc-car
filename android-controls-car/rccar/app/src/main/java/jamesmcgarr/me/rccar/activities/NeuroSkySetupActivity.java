package jamesmcgarr.me.rccar.activities;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.neurosky.thinkgear.TGDevice;

import jamesmcgarr.me.rccar.R;
import jamesmcgarr.me.rccar.utils.NeuroCarGo;

public class NeuroSkySetupActivity extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private TGDevice tgDevice;
    private TextView rawEegTv;
    private NeuroCarGo neuroCarGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neuro_sky_setup);

        tgDevice = new TGDevice(bluetoothAdapter, handler);
        rawEegTv = findViewById(R.id.rawEegTv);

        neuroCarGo = new NeuroCarGo();
    }

    @Override
    public void onStart() {
        super.onStart();
        tgDevice.connect(true);
    }

    private final Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch( msg.what ) {
                case TGDevice.MSG_STATE_CHANGE:

                    switch( msg.arg1 ) {
                        case TGDevice.STATE_IDLE:
                            break;
                        case TGDevice.STATE_CONNECTING:
                            break;
                        case TGDevice.STATE_CONNECTED:
                            tgDevice.start();
                            break;
                        case TGDevice.STATE_NOT_FOUND:
                            break;
                        case TGDevice.STATE_ERR_NO_DEVICE:
                            break;
                        case TGDevice.STATE_ERR_BT_OFF:
                            break;
                        case TGDevice.STATE_DISCONNECTED:
                    } /* end switch on msg.arg1 */

                    break;

                case TGDevice.MSG_POOR_SIGNAL:
                    break;

                case TGDevice.MSG_HEART_RATE:
                    break;

                case TGDevice.MSG_RAW_DATA:
                    neuroCarGo.setRawEeg(msg.arg1);
                    rawEegTv.setText( "Raw EEG: " + msg.arg1 );
                    break;
                case TGDevice.MSG_ATTENTION:
                    break;
                case TGDevice.MSG_MEDITATION:
                    break;
                case TGDevice.MSG_BLINK:
                    break;
                default:
                    break;

            } /* end switch on msg.what */
        }
    };
}
