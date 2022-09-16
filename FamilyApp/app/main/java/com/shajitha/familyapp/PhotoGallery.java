package com.shajitha.familyapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class PhotoGallery extends Activity {
    private static final int CAMERA_REQUEST = 100;
    ImageView imageView;
TextView msg;
    Button takePhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);



        imageView = findViewById(R.id.imageView1);
        takePhoto = findViewById(R.id.button1);
        msg = findViewById(R.id.msg);
        takePhoto.setVisibility(View.VISIBLE);
        takePhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            msg.setVisibility(View.VISIBLE);
            msg.setText("See Your Smile!!!");
            takePhoto.setVisibility(View.GONE);
        }
    }

 //   private void galleryAddPic() {
  //      Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
   //     File f = new File(mCurrentPhotoPath);
  //      Uri contentUri = Uri.fromFile(f);
  //      mediaScanIntent.setData(contentUri);
  //      this.sendBroadcast(mediaScanIntent);
   // }


}