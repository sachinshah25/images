package com.example.image;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.image.databinding.ActivityTutorialOneBinding;
import com.example.image.databinding.ActivityTutorialTwoBinding;

import org.jetbrains.annotations.NotNull;

public class tutorialTwoActivity extends AppCompatActivity {


    // Tutorial Two
    ActivityTutorialTwoBinding binding; // for using binding features
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTutorialTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // now call
                activityResultLauncher.launch("image/*"); // set Type which you want
                // let's run
                //  Thanks For WAtching
            }
        });
    }

    // Open Gallery using Activity result Launcher
   ActivityResultLauncher<String> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
       @Override
       public void onActivityResult(Uri uri) {
           if (uri!=null){
               binding.image.setImageURI(uri);
           }
       }
   });
}