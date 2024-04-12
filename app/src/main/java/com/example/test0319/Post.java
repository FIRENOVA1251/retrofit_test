package com.example.test0319;

import java.util.List;

public class Post {

    Photos photos;
    public class Photos {
        int page, pages, perpage, total;
        List<Photo> photo;
    }

    public class Photo {

        String id;
        String owner;
        String secret;
        String server;
        int farm;
        String title;
        int ispublic;
        int isfriend;
        int isfamily;

        public String getId() {
            return id;
        }

        public String getSecret() {
            return secret;
        }

        public String getServer() {
            return server;
        }

        public String getOwner() {
            return owner;
        }

        public int getFarm() {
            return farm;
        }

        public int getIspublic() {
            return ispublic;
        }

        public int getIsfriend() {
            return isfriend;
        }

        public int getIsfamily() {
            return isfamily;
        }

        public String getTitle() {
            return title;
        }

    }
}
