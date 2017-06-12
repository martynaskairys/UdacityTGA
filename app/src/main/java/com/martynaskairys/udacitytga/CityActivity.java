package com.martynaskairys.udacitytga;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class CityActivity extends AppCompatActivity {

    public static final String EXPLANATION = "explanation";
    public static final String TEXTS = "title_text";
    public static final String COVER_IMAGE = "cover_image";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        setExplanationText();
        setTitle();
        setCoverImage();




        final ArrayList<Info> vilniusInfo = new ArrayList<Info>();
        vilniusInfo.add(new Info(R.string.vilnius_to_do_one_name, R.string.vilnius_to_do_one,
                R.drawable.vilniusone));
        vilniusInfo.add(new Info(R.string.vilnius_to_do_two_name, R.string.vilnius_to_do_two,
                R.drawable.vilniustwo));
        vilniusInfo.add(new Info(R.string.vilnius_to_do_three_name, R.string.vilnius_to_do_three,
                R.drawable.vilniusthree));

        final ArrayList<Info> kaunasInfo = new ArrayList<Info>();
        kaunasInfo.add(new Info(R.string.kaunas_to_do_one_name, R.string.kaunas_to_do_one,
                R.drawable.kaunasone));
        kaunasInfo.add(new Info(R.string.kaunas_to_do_two_name, R.string.kaunas_to_do_two,
                R.drawable.kaunastwo));
        kaunasInfo.add(new Info(R.string.kaunas_to_do_three_name, R.string.kaunas_to_do_three,
                R.drawable.kaunasthree));
        kaunasInfo.add(new Info(R.string.kaunas_to_do_four_name, R.string.kaunas_to_do_four,
                R.drawable.kaunasfour));
        kaunasInfo.add(new Info(R.string.kaunas_to_do_five_name, R.string.kaunas_to_do_five,
                R.drawable.kaunasfice));

        final ArrayList<Info> klaipedaInfo = new ArrayList<Info>();
        klaipedaInfo.add(new Info(R.string.klaipeda_to_do_one_name, R.string.klaipeda_to_do_one,
                R.drawable.klp));
        klaipedaInfo.add(new Info(R.string.klaipeda_to_do_two_name, R.string.klaipeda_to_do_two,
                R.drawable.klpnew));
        klaipedaInfo.add(new Info(R.string.klaipeda_to_do_three_name, R.string.klaipeda_to_do_three,
                R.drawable.klaipedaoldtown));

        final ArrayList<Info> nidaInfo = new ArrayList<Info>();
        nidaInfo.add(new Info(R.string.nida_to_do_one_name, R.string.nida_to_do_one,
                R.drawable.dunes));
        nidaInfo.add(new Info(R.string.nida_to_do_two_name, R.string.nida_to_do_two,
                R.drawable.nidanew));
        nidaInfo.add(new Info(R.string.nida_to_do_three_name, R.string.nida_to_do_three,
                R.drawable.nida));


        InfoAdapter adapterVilniusToDoList = new InfoAdapter(this, vilniusInfo, R.color.colorPrimary);
        InfoAdapter adapterKaunasToDoList = new InfoAdapter(this, kaunasInfo, R.color.colorPrimary);
        InfoAdapter adapterKlaipedaToDoList = new InfoAdapter(this, klaipedaInfo, R.color.colorPrimary);
        InfoAdapter adapterNidaToDoList = new InfoAdapter(this, nidaInfo, R.color.colorPrimary);

        ListView listViewVilnius = (ListView) findViewById(R.id.list1);
        ListView listViewKaunas = (ListView) findViewById(R.id.list2);
        ListView listViewKlaipeda = (ListView) findViewById(R.id.list3);
        ListView listViewNida = (ListView) findViewById(R.id.list4);


        Intent intent = getIntent();
        String stringValue = intent.getExtras().getString("TODO");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.equals(stringValue, "VilniusToDo")) {
                listViewVilnius.setAdapter(adapterVilniusToDoList);
            } else if (Objects.equals(stringValue, "KaunasToDo")) {
                listViewKaunas.setAdapter(adapterKaunasToDoList);
            } else if (Objects.equals(stringValue, "KlaipedaToDo")) {
                listViewKlaipeda.setAdapter(adapterKlaipedaToDoList);
            } else if (Objects.equals(stringValue, "NidaToDo")) {
                listViewNida.setAdapter(adapterNidaToDoList);
            }
        }

        listViewVilnius.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(CityActivity.this, ThingsToDoActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.vilnius_to_do_one));
                        break;
                    case 1:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.vilnius_to_do_two));
                        break;
                    case 2:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.vilnius_to_do_three));
                        break;
                }
                startActivity(intent);

            }
        });

        listViewKaunas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(CityActivity.this, ThingsToDoActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.kaunas_to_do_one));
                        break;
                    case 1:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.kaunas_to_do_two));
                        break;
                    case 2:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.kaunas_to_do_three));
                        break;
                    case 3:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.kaunas_to_do_three));
                        break;
                    case 4:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.kaunas_to_do_three));
                        break;
                }
                startActivity(intent);

            }
        });

        listViewKlaipeda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(CityActivity.this, ThingsToDoActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.klaipeda_to_do_one));
                        break;
                    case 1:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.klaipeda_to_do_two));
                        break;
                    case 2:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.klaipeda_to_do_three));
                        break;
                }
                startActivity(intent);

            }
        });

        listViewNida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(CityActivity.this, ThingsToDoActivity.class);

                switch (position) {
                    case 0:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.nida_to_do_one));
                        break;
                    case 1:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.nida_to_do_two));
                        break;
                    case 2:
                        intent.putExtra(ThingsToDoActivity.THINGSTODO, getString(R.string.nida_to_do_three));
                        break;
                }
                startActivity(intent);

            }
        });
    }

    private void setTitle() {

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            String j = (String) b.get(TEXTS);
            setTitle(j);
        }
    }

    private void setCoverImage() {
        ImageView imageCover = (ImageView) findViewById(R.id.thumbnail_cover_image);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            int j = (int) b.get(COVER_IMAGE);
            imageCover.setImageResource(j);
        }

    }

    private void setExplanationText() {
        TextView textExplainingFolderChoice = (TextView) findViewById(R.id.text_explaining_folder_content);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            String j = (String) b.get(EXPLANATION);
            textExplainingFolderChoice.setText(j);
        }
    }


}
