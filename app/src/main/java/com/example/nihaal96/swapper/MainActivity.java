package com.example.nihaal96.swapper;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button2;
    private ImageSwitcher imageSwitcher;
    int imageno[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    int countimage = imageno.length;
    int current = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageChange);
//convert imageswitcher to imageview
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

    }


    @Override
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.button2) {
                current++;
                imageSwitcher.setImageResource(imageno[current]);
            }
            }
            catch(Exception e)
            {

                Toast.makeText(getApplicationContext(), "Last", Toast.LENGTH_SHORT).show();
            }


            try{ if (view.getId() == R.id.button)

            {
                current = current - 1;
                imageSwitcher.setImageResource(imageno[current]);
            } }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "first", Toast.LENGTH_SHORT).show();
            }
        }
    }




