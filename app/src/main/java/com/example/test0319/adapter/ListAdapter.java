package com.example.test0319.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test0319.ImageLoader;
import com.example.test0319.ListDetailActivity;
import com.example.test0319.PicassoImageLoader;
import com.example.test0319.Post;
import com.example.test0319.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    public List<Post.Photo> listData;
    public ArrayList<String> id_list = new ArrayList<String>();
    public ArrayList<String> owner_list = new ArrayList<String>();
    public ArrayList<String> secret_list = new ArrayList<String>();
    public ArrayList<String> server_list = new ArrayList<String>();
    public ArrayList<String> farm_list = new ArrayList<String>();
    public ArrayList<String> title_list = new ArrayList<String>();
    public ArrayList<String> ispublic_list = new ArrayList<String>();
    public ArrayList<String> isfriend_list = new ArrayList<String>();

    public ArrayList<String> isfamily_list = new ArrayList<String>();
    public ArrayList<String> image = new ArrayList<String>();
    String imageUrl = "https://live.staticflickr.com/";

    public ListAdapter(Context context, List<Post.Photo> listData) {
        this.context = context;
        this.listData = listData;

        processData();
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        LinearLayout linearLayout = view.findViewById(R.id.layout);

        TextView textView = view.findViewById(R.id.text);
        textView.setText(title_list.get(position));

        ImageView imageView = view.findViewById(R.id.imageView);

        // Load Image from Picasso
        ImageLoader imageLoader = new PicassoImageLoader();
        imageLoader.loadImage(image.get(position), imageView);




        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pass the data into detail page
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setClass(context, ListDetailActivity.class);

                bundle.putString("id", id_list.get(position));
                bundle.putString("owner", owner_list.get(position));
                bundle.putString("secret", secret_list.get(position));
                bundle.putString("server", server_list.get(position));
                bundle.putString("farm", farm_list.get(position));
                bundle.putString("title", title_list.get(position));
                bundle.putString("ispublic", ispublic_list.get(position));
                bundle.putString("isfriend", isfriend_list.get(position));
                bundle.putString("isfamily", isfamily_list.get(position));

                bundle.putString("image_url", image.get(position));
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
        return view;
    }

    private void processData(){
        if(listData != null && !listData.isEmpty()){
            for(int i = 0; i < listData.size(); i++){

                String id = listData.get(0).getId();
                String owner = listData.get(0).getOwner();
                String secret = listData.get(0).getSecret();
                String server = listData.get(0).getServer();
                int farm = listData.get(0).getFarm();
                String title = listData.get(0).getTitle();
                int ispublic = listData.get(0).getIspublic();
                int isfriend = listData.get(0).getIsfriend();
                int isfamily = listData.get(0).getIsfamily();

                //Add all the data into arrayList
                id_list.add(id);
                owner_list.add(owner);
                secret_list.add(secret);
                server_list.add(server);
                farm_list.add(Integer.toString(farm));
                title_list.add(title);
                ispublic_list.add(Integer.toString(ispublic));
                isfriend_list.add(Integer.toString(isfriend));
                isfamily_list.add(Integer.toString(isfamily));

                // serverID/id_secret_size.jpg    Maybe no size?
                String temp = imageUrl + server + "/"
                        + id + "_"
                        + secret + ".jpg";
                image.add(temp);

            }
        }
    }
}
