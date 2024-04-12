package com.example.test0319;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class ListDetailActivity extends AppCompatActivity {

    public ImageView imageView;
    public Button back_btn;
    public TextView id_text, owner_text, secret_text, server_text, farm_text, title_text,
            ispublic_text, isfriend_text, isfamily_text;
    public String id, owner, secret, server, farm, title, ispublic, isfriend, isfamily, image_url;

    private ImageLoader imageLoader = new PicassoImageLoader();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("id");
            owner = bundle.getString("owner");
            secret = bundle.getString("secret");
            server = bundle.getString("server");
            farm = bundle.getString("farm");
            title = bundle.getString("title");
            ispublic = bundle.getString("ispublic");
            isfriend = bundle.getString("isfriend");
            isfamily = bundle.getString("isfamily");
            image_url = bundle.getString("image_url");
        }

        init_view();
        init_Data(image_url, imageView);
    }


    public void init_view(){

        imageView = findViewById(R.id.image);

        id_text = findViewById(R.id.id_data);
        id_text.setText(id);
        owner_text = findViewById(R.id.owner_data);
        owner_text.setText(owner);
        secret_text = findViewById(R.id.secret_data);
        secret_text.setText(secret);
        server_text = findViewById(R.id.server_data);
        server_text.setText(server);
        farm_text = findViewById(R.id.farm_data);
        farm_text.setText(farm);
        title_text = findViewById(R.id.title_data);
        title_text.setText(title);
        ispublic_text = findViewById(R.id.ispublic_data);
        ispublic_text.setText(ispublic);
        isfriend_text = findViewById(R.id.isfriend_data);
        isfriend_text.setText(isfriend);
        isfamily_text = findViewById(R.id.isfamily_data);
        isfamily_text.setText(isfamily);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(actionBtnOnClick);

    }

    public void init_Data(String image_url, ImageView imageView) {
        imageLoader.loadImage(image_url, imageView);
    }

    private final View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            if(view.getId() == R.id.back_btn){

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setClass(ListDetailActivity.this, MainActivity.class);

                bundle.putString("title", title);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        }
    };
}