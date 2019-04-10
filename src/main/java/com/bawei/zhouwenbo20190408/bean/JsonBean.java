package com.bawei.zhouwenbo20190408.bean;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: Machenike
 * Date: 2019/4/8 9:57,周文博
 * Description:
 */
public class JsonBean {
    public String message;
    public List<Result> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result{
        public String followMovie;
        public int id;
        public String imageUrl;
        public  String name;
        public int rank;
        public  String summary;

        public String getFollowMovie() {
            return followMovie;
        }

        public void setFollowMovie(String followMovie) {
            this.followMovie = followMovie;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }


}
