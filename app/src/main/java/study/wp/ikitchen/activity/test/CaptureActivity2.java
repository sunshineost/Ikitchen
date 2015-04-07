package study.wp.ikitchen.activity.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by wp on 2015-03-04.
 */
public class CaptureActivity2 extends ActionBarActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScanner=new ZXingScannerView(this);
        setContentView(mScanner);

    }




    @Override
    public void handleResult(Result result) {
        Log.v("handleResult", result.getText()); // Prints scan results
        Log.v("handleResult", result.getBarcodeFormat().toString()); // Prints the scan formatBFImage (qrcode, pdf417 etc.)
        Intent intent = new Intent();
        intent.putExtra("scan_result", result.getText());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScanner.setResultHandler(this);
        mScanner.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanner.stopCamera();
    }
}
