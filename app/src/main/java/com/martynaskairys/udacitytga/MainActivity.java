package com.martynaskairys.udacitytga;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int vilniusImage = R.drawable.pic_cover_vilnius;
    private int kaunasImage = R.drawable.pic_cover_kaunas;
    private int klaipedaImage = R.drawable.pic_cover_klaipeda;
    private int nidaImage = R.drawable.pic_cover_nida;

    private String vilniusToDo = "VilniusToDo";
    private String kaunasToDo = "KaunasToDo";
    private String klaipedaToDo = "KlaipedaToDo";
    private String nidaToDo = "NidaToDo";

    private ImageView buttonVilnius;
    private ImageView buttonKaunas;
    private ImageView buttonKlaipeda;
    private ImageView buttonNida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupButtons();

    }

    private void findViews() {



        buttonVilnius = (ImageView) findViewById(R.id.button_folder_a);
        buttonKaunas = (ImageView) findViewById(R.id.button_folder_b);
        buttonKlaipeda = (ImageView) findViewById(R.id.button_folder_c);
        buttonNida = (ImageView) findViewById(R.id.button_folder_d);

    }

    private void setupButtons() {

        setupButton( buttonVilnius,  R.string.city_name_a, vilniusImage,  R.string.city_description_a,vilniusToDo);
        setupButton( buttonKaunas, R.string.city_name_b,  kaunasImage,  R.string.city_description_b,kaunasToDo);
        setupButton( buttonKlaipeda,  R.string.city_name_c, klaipedaImage,  R.string.city_description_c,klaipedaToDo);
        setupButton( buttonNida,  R.string.city_name_d, nidaImage,  R.string.city_description_d,nidaToDo);

    }

    private void setupButton(ImageView button,
                             @StringRes final int cityName,
                             final int coverImage,
                             @StringRes final int cityDescription,
                             final String toDo) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                intent.putExtra(CityActivity.TEXTS, getString(cityName));
                intent.putExtra(CityActivity.COVER_IMAGE, coverImage);
                intent.putExtra(CityActivity.EXPLANATION, getString(cityDescription));
                intent.putExtra("TODO", toDo);

                ActivityUtils.startActivityWithTransitionAnimation(MainActivity.this,
                        intent,
                        new Pair<View, String>(v, getString(R.string.transition_cover)));
            }
        });
    }
}
