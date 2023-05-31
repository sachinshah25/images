package com.example.image;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.image.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // Firstly Use Binding Features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Write This
//                Intent intent=new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*"); // it is important
//                startActivityForResult(intent,1); // After  Some Video , We will use ActivityResultLauncher instead of This
                // because it is deprecated 4


                // We can also use
                Intent intent1=new Intent(Intent.ACTION_GET_CONTENT); // We can also write this
                intent1.setType("image/*"); // But Type is Important
                startActivityForResult(intent1,1);

                // Thanks For Watching
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /// Result Code
        // Not run

        if (requestCode==1) {
            if (resultCode == RESULT_OK && data != null) {
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                Uri uri = data.getData();
                binding.image.setImageURI(uri);
            }
        }
    }
}