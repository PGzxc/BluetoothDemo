package com.example.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       BluetoothManager bluetoothManager= (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//       bluetoothAdapter= bluetoothManager.getAdapter();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        findViewById(R.id.btn_close).setOnClickListener(this);
        findViewById(R.id.btn_open).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_close:
                bluetoothAdapter.disable();
                break;
            case R.id.btn_open:
                bluetoothAdapter.enable();
//                if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
//                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        Toast.makeText(this, "蓝牙已启用", Toast.LENGTH_SHORT).show();
    }
}
