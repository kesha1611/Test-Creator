package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class jaActivity extends AppCompatActivity {
    EditText etName, etNoTlp, etJmlOne, etJmlTwo,etJml3,etJml4,etJml5,etJml6,etJml7,etJml8,etJml9,etJml10;
    Spinner itemSpinnerOne, itemSpinnerTwo,itemSpinner3,itemSpinner4,itemSpinner5,itemSpinner6,itemSpinner7,itemSpinner8,itemSpinner9,itemSpinner10;
    Button btnPrint;
    Bitmap bitmap, scaleBitmap;
    int pageWidth = 1150;
    Date dateTime;
    DateFormat dateFormat;
    // float[] harga = new float[]{0, 21000, 22000, 25000, 22500, 21500};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ja);


        etName = findViewById(R.id.etName);
        etNoTlp = findViewById(R.id.etNoTlp);
        etJmlOne = findViewById(R.id.etJmlOne);
        etJmlTwo = findViewById(R.id.etJmlTwo);
        etJml3 = findViewById(R.id.etJml3);
        etJml4 = findViewById(R.id.etJml4);
        etJml5 = findViewById(R.id.etJml5);
        etJml6 = findViewById(R.id.etJml6);
        etJml7 = findViewById(R.id.etJml7);
        etJml8 = findViewById(R.id.etJml8);
        etJml9 = findViewById(R.id.etJml9);
        etJml10 = findViewById(R.id.etJml10);

        itemSpinnerOne = findViewById(R.id.itemSpinnerOne);
        itemSpinnerTwo = findViewById(R.id.itemSpinnerTwo);
        itemSpinner3 = findViewById(R.id.itemSpinner3);
        itemSpinner4 = findViewById(R.id.itemSpinner4);
        itemSpinner5 = findViewById(R.id.itemSpinner5);
        itemSpinner6 = findViewById(R.id.itemSpinner6);
        itemSpinner7 = findViewById(R.id.itemSpinner7);
        itemSpinner8 = findViewById(R.id.itemSpinner8);
        itemSpinner9 = findViewById(R.id.itemSpinner9);
        itemSpinner10 = findViewById(R.id.itemSpinner10);
        btnPrint = findViewById(R.id.btnPrint);

        //cover header
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_cover);
        scaleBitmap = Bitmap.createScaledBitmap(bitmap, 1200, 518, false);

        //permission
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        createPDF();
    }

    private void createPDF() {
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public void onClick(View v) {

                dateTime = new Date();

                //get input
                if (etName.getText().toString().length() == 0 ||
                        etNoTlp.getText().toString().length() == 0 ||
                        etJmlOne.getText().toString().length() == 0 ||
                        etJmlTwo.getText().toString().length() == 0 ||
                        etJml3.getText().toString().length() == 0 ||
                        etJml4.getText().toString().length() == 0 ||
                        etJml5.getText().toString().length() == 0) {
                    Toast.makeText(jaActivity.this, "Insert Atleast 5 Questions ", Toast.LENGTH_LONG).show();
                } else {

                    PdfDocument pdfDocument = new PdfDocument();
                    Paint paint = new Paint();
                    Paint titlePaint = new Paint();

                    PdfDocument.PageInfo pageInfo
                            = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                    PdfDocument.Page page = pdfDocument.startPage(pageInfo);

                    Canvas canvas = page.getCanvas();
                    //   canvas.drawBitmap(scaleBitmap, 0, 0, paint);

                    paint.setColor(Color.WHITE);
                    paint.setTextSize(30f);
                    paint.setTextAlign(Paint.Align.RIGHT);

                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize(35f);
                    canvas.drawText("Subject Name : " + etName.getText(), 20, 190, paint);
                    canvas.drawText("Subject Code : " + etNoTlp.getText(), 20, 240, paint);


                    dateFormat = new SimpleDateFormat("dd/MM/yy");
                    canvas.drawText("Date: " + dateFormat.format(dateTime), pageWidth - 190, 190, paint);

                    dateFormat = new SimpleDateFormat("HH:mm:ss");
                    canvas.drawText("Time: " + dateFormat.format(dateTime), pageWidth - 190, 240, paint);

                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2);
                    // canvas.drawRect(20, 380, pageWidth - 20, 460, paint);
                    canvas.drawText("------ JAVA Question Paper ------",330,340,paint);
                    paint.setTextAlign(Paint.Align.LEFT);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawText("--------Best of Luck !!--------",330,1530,paint);
                  /*  canvas.drawText("No.", 40, 830, paint);
                    canvas.drawText("Menu Pesanan", 200, 830, paint);
                    canvas.drawText("Harga", 700, 830, paint);
                    canvas.drawText("Jumlah", 900, 830, paint);
                    canvas.drawText("Total", 1050, 830, paint);

                    canvas.drawLine(180, 790, 180, 840, paint);
                    canvas.drawLine(680, 790, 680, 840, paint);
                    canvas.drawLine(880, 790, 880, 840, paint);
                    canvas.drawLine(1030, 790, 1030, 840, paint);
*/
                    int totalOne = 0, totalTwo = 0,total3 = 0,total4 = 0,total5 = 0,total6 = 0,total7 = 0,total8 = 0,total9 = 0,total10 = 0;
                    if (itemSpinnerOne.getSelectedItemPosition() != 0) {
                        canvas.drawText("1.", 40, 450, paint);
                        canvas.drawText(itemSpinnerOne.getSelectedItem().toString(), 100, 450, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        totalOne = Integer.parseInt(etJmlOne.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(totalOne), pageWidth - 20, 450, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinnerTwo.getSelectedItemPosition() != 0) {
                        canvas.drawText("2.", 40, 550, paint);
                        canvas.drawText(itemSpinnerTwo.getSelectedItem().toString(), 100, 550, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerTwo.getSelectedItemPosition()]), 700, 1050, paint);
                        // canvas.drawText(etJmlTwo.getText().toString(), 900, 1050, paint);
                        totalTwo = Integer.parseInt(etJmlTwo.getText().toString());// * harga[itemSpinnerTwo.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(totalTwo), pageWidth - 20, 550, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner3.getSelectedItemPosition() != 0) {
                        canvas.drawText("3.", 40, 650, paint);
                        canvas.drawText(itemSpinner3.getSelectedItem().toString(), 100, 650, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total3 = Integer.parseInt(etJml3.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total3), pageWidth - 20, 650, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner4.getSelectedItemPosition() != 0) {
                        canvas.drawText("4.", 40, 750, paint);
                        canvas.drawText(itemSpinner4.getSelectedItem().toString(), 100, 750, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total4 = Integer.parseInt(etJml4.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total4), pageWidth - 20, 750, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner5.getSelectedItemPosition() != 0) {
                        canvas.drawText("5.", 40, 850, paint);
                        canvas.drawText(itemSpinner5.getSelectedItem().toString(), 100, 850, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total5 = Integer.parseInt(etJml5.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total5), pageWidth - 20, 850, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner6.getSelectedItemPosition() != 0) {
                        canvas.drawText("6.", 40, 950, paint);
                        canvas.drawText(itemSpinner6.getSelectedItem().toString(), 100, 950, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total6 = Integer.parseInt(etJml6.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total6), pageWidth - 20, 950, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner7.getSelectedItemPosition() != 0) {
                        canvas.drawText("7.", 40, 1050, paint);
                        canvas.drawText(itemSpinner7.getSelectedItem().toString(), 100, 1050, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total7 = Integer.parseInt(etJml7.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total7), pageWidth - 20, 1050, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner8.getSelectedItemPosition() != 0) {
                        canvas.drawText("8.", 40, 1150, paint);
                        canvas.drawText(itemSpinner8.getSelectedItem().toString(), 100, 1150, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total8 = Integer.parseInt(etJml8.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total8), pageWidth - 20, 1150, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    if (itemSpinner9.getSelectedItemPosition() != 0) {
                        canvas.drawText("9.", 40, 1250, paint);
                        canvas.drawText(itemSpinner9.getSelectedItem().toString(), 100, 1250, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total9 = Integer.parseInt(etJml9.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total9), pageWidth - 20, 1250, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }
                    if (itemSpinner10.getSelectedItemPosition() != 0) {
                        canvas.drawText("10.", 40, 1350, paint);
                        canvas.drawText(itemSpinner10.getSelectedItem().toString(), 100, 1350, paint);
                        //  canvas.drawText(String.valueOf(harga[itemSpinnerOne.getSelectedItemPosition()]), 700, 950, paint);
                        //canvas.drawText(etJmlOne.getText().toString(), 900, 950, paint);
                        total10 = Integer.parseInt(etJml10.getText().toString());// * harga[itemSpinnerOne.getSelectedItemPosition()];
                        paint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(String.valueOf(total10), pageWidth - 20, 1350, paint);
                        paint.setTextAlign(Paint.Align.LEFT);
                    }

                    float subTotal = totalOne + totalTwo + total3 + total4 + total5  + total6 + total7 + total8 + total9 + total10;
                    // canvas.drawLine(400, 1200, pageWidth - 20, 1200, paint);
                  /*  canvas.drawText("Sub Total", 700, 1250, paint);
                    canvas.drawText(":", 900, 1250, paint);
                    paint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(String.valueOf(subTotal), pageWidth - 40, 1250, paint);

                  paint.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText("PPN (10%)", 700, 1300, paint);
                    canvas.drawText(":", 900, 1300, paint);
                    paint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(String.valueOf(subTotal * 10 / 100), pageWidth - 40, 1300, paint);
                    paint.setTextAlign(Paint.Align.LEFT);
*/
                    // paint.setColor(Color.rgb(247, 147, 30));
                    //canvas.drawRect(680, 1350, pageWidth - 20, 1450, paint);

                    paint.setColor(Color.BLACK);
                    paint.setTextSize(40f);
                    paint.setTextAlign(Paint.Align.LEFT);
                    canvas.drawText("Marks", 950, 290, paint);
                    paint.setTextAlign(Paint.Align.RIGHT);
                    canvas.drawText(String.valueOf(subTotal), 1150, 290, paint);

                    pdfDocument.finishPage(page);

                    File file = new File(Environment.getExternalStorageDirectory(), "/javaPaper.pdf");
                    try {
                        pdfDocument.writeTo(new FileOutputStream(file));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    pdfDocument.close();
                    Toast.makeText(jaActivity.this, "PDF named javaPaper Created", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}