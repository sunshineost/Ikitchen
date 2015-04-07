package study.wp.ikitchen.activity.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import study.wp.ikitchen.R;
import study.wp.ikitchen.zxing.activity.CaptureActivity;
import study.wp.ikitchen.zxing.encoding.EncodingHandler;

public class TestZingActivity extends ActionBarActivity {
    private TextView resultTextView;
    private EditText qrStrEditText;
    private ImageView qrImgImageView;
    final int QR_WIDTH = 200;
    final int QR_HEIGHT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_zing);
        resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        Button scanBarCodeButton = (Button) this.findViewById(R.id.btn_scan_barcode);
        scanBarCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                //打开扫描界面扫描条形码或二维码
                Intent openCameraIntent = new Intent(TestZingActivity.this,CaptureActivity2.class);
                startActivityForResult(openCameraIntent, 101);
            }
        });
        Button generateQRCodeButton = (Button) this.findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                try {
                    String contentString = qrStrEditText.getText().toString();
//                    if (!contentString.equals("")) {
//                        //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
//                        Bitmap qrCodeBitmap = EncodingHandler.createQRCode(contentString, 350);
//                        qrImgImageView.setImageBitmap(qrCodeBitmap);
//                    }else {
//                        Toast.makeText(TestZingActivity.this, "Text can not be empty", Toast.LENGTH_SHORT).show();
//                    }
//
//                } catch (WriterException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
                createImage(contentString);
            }
        });
    }

    private void createImage(String contentString) {

        try {
            QRCodeWriter writer=new QRCodeWriter();
            HashMap<EncodeHintType,String> hints=new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            BitMatrix bitMatrix = new QRCodeWriter().encode(contentString,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }

                }
            }
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            qrImgImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //处理扫描结果（在界面上显示）
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            resultTextView.setText(scanResult);
        }
        if (resultCode==RESULT_OK&&requestCode==101){
            String result = data.getStringExtra("scan_result");
            resultTextView.setText(result);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_zing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
