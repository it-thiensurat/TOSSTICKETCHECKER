package com.tsr.tsrproblemreport_tossticket_checker.Monitoring_system.qrcode;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.MenuItem;


import com.tsr.tsrproblemreport_tossticket_checker.R;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import info.androidhive.barcode.BarcodeReader;
import com.google.android.gms.vision.barcode.Barcode;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

public class MainActivity_barcode extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
    private static final String TAG = MainActivity_barcode.class.getSimpleName();

    private BarcodeReader barcodeReader;
String conno="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_barcode);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getting barcode instance
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);
        conno=MyApplication.getInstance().getPrefManager().getPreferrence("conno_cf");

        /***
         * Providing beep sound. The sound file has to be placed in
         * `assets` folder
         */
        // barcodeReader.setBeepSoundFile("shutter.mp3");

        /**
         * Pausing / resuming barcode reader. This will be useful when you want to
         * do some foreground user interaction while leaving the barcode
         * reader in background
         * */
        // barcodeReader.pauseScanning();
        // barcodeReader.resumeScanning();
    }

    @Override
    public void onScanned(final Barcode barcode) {
        //Log.e(TAG, "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {                    // หลังจาก สแกนเสร็จ
              //  Toast.makeText(getApplicationContext(), "Barcode: " + barcode.displayValue, Toast.LENGTH_SHORT).show();


                Log.e("conno_scan",conno+","+barcode.displayValue);
                if(conno.equals(barcode.displayValue)){

                    MyApplication.getInstance().getPrefManager().setPreferrence("conno_intro", conno);
                    MyApplication.getInstance().getPrefManager().setPreferrence("conno_scan", barcode.displayValue);

                    new SweetAlertDialog(MainActivity_barcode.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("เสร็จสิ้น!")
                            //.setContentText("หมายเลขตรงกัน!")
                            .show();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);


                }
                else {
                    MyApplication.getInstance().getPrefManager().setPreferrence("conno_intro", conno);
                    MyApplication.getInstance().getPrefManager().setPreferrence("conno_scan", barcode.displayValue);
                    new SweetAlertDialog(MainActivity_barcode.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("เสร็จสิ้น!")
                            //.setContentText("หมายเลขตรงกัน!")
                            .show();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);
                }
                //finish();
            }
        });
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
       // Log.e(TAG, "onScannedMultiple: " + barcodes.size());

        String codes = "";
        for (Barcode barcode : barcodes) {
            codes += barcode.displayValue + ", ";
        }

        final String finalCodes = codes;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
         //       Toast.makeText(getApplicationContext(), "Barcodes: " + finalCodes, Toast.LENGTH_SHORT).show();
/*                finish();
                 if(conno.equals(finalCodes)){
                     new SweetAlertDialog(MainActivity_barcode.this, SweetAlertDialog.SUCCESS_TYPE)
                             .setTitleText("Are you sure?")
                             .setContentText("Won't be able to recover this file!")
                             .setConfirmText("Yes,delete it!")
                             .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                 @Override
                                 public void onClick(SweetAlertDialog sDialog) {
                                     sDialog.dismissWithAnimation();
                                 }
                             })
                             .show();
                 }
                 else {
                     new SweetAlertDialog(MainActivity_barcode.this, SweetAlertDialog.WARNING_TYPE)
                             .setTitleText("Are you sure?")
                             .setContentText("Won't be able to recover this file!")
                             .setCancelText("No,cancel plx!")
                             .setConfirmText("Yes,delete it!")
                             .showCancelButton(true)
                             .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                 @Override
                                 public void onClick(SweetAlertDialog sDialog) {
                                     sDialog.cancel();
                                 }
                             })
                             .show();
                 }*/
/*                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();

                finish();*/

            }
        });
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {
       // Toast.makeText(getApplicationContext(), "Camera permission denied!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}