package com.example.carbcon1.model;
import com.google.gson.annotations.SerializedName;



    public class Notice {

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("brief")
        private String brief;

        public Notice(String id, String title, String brief) {
            this.id = id;
            this.title = title;
            this.brief = brief;

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

    }

