package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models;


import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 25/2/2561.
 */

public class DATA_mp3 implements Serializable {
    @NonNull
    private static List<DATA_mp3> audioSamples = new ArrayList<>();
public String ONLINE_MP3;
    public String id;
    public String cat_id;
    public  String mp3_type;
    public  String mp3_title;
    public  String mp3_url;

    public  String mp3_thumbnail_b;
    public  String mp3_thumbnail_s;
    public  String mp3_thumbnail_s2;
    public  String mp3_duration;
    public  String mp3_artist;
    public  String mp3_description;
    public  String cid;
    public  String category_name;




    public DATA_mp3() {
    }
    public DATA_mp3(String ONLINE_MP3) {
        this.ONLINE_MP3 = ONLINE_MP3;
    }
    public DATA_mp3(String id, String cat_id, String mp3_type, String mp3_title, String mp3_url, String mp3_thumbnail_b, String mp3_thumbnail_s, String mp3_duration, String mp3_artist, String mp3_description, String cid, String category_name) {
        this.id = id;
        this.cat_id = cat_id;
        this.mp3_type = mp3_type;
        this.mp3_title = mp3_title;
        this.mp3_url = mp3_url;
        this.mp3_thumbnail_b = mp3_thumbnail_b;
        this.mp3_thumbnail_s = mp3_thumbnail_s;

        this.mp3_duration = mp3_duration;
        this.mp3_artist = mp3_artist;
        this.mp3_description = mp3_description;
        this.cid = cid;
        this.category_name = category_name;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getMp3_type() {
        return mp3_type;
    }

    public void setMp3_type(String mp3_type) {
        this.mp3_type = mp3_type;
    }

    public String getMp3_title() {
        return mp3_title;
    }

    public void setMp3_title(String mp3_title) {
        this.mp3_title = mp3_title;
    }

    public String getMp3_url() {
        return mp3_url;
    }

    public void setMp3_url(String mp3_url) {
        this.mp3_url = mp3_url;
    }

    public String getMp3_thumbnail_b() {
        return mp3_thumbnail_b;
    }

    public void setMp3_thumbnail_b(String mp3_thumbnail_b) {
        this.mp3_thumbnail_b = mp3_thumbnail_b;
    }

    public String getMp3_thumbnail_s() {
        return mp3_thumbnail_s;
    }

    public void setMp3_thumbnail_s(String mp3_thumbnail_s) {
        this.mp3_thumbnail_s = mp3_thumbnail_s;
    }


    public String getMp3_thumbnail_s2() {
        return mp3_thumbnail_s2;
    }

    public void setMp3_thumbnail_s2(String mp3_thumbnail_s2) {
        this.mp3_thumbnail_s2 = mp3_thumbnail_s2;
    }

    public String getMp3_duration() {
        return mp3_duration;
    }

    public void setMp3_duration(String mp3_duration) {
        this.mp3_duration = mp3_duration;
    }

    public String getMp3_artist() {
        return mp3_artist;
    }

    public void setMp3_artist(String mp3_artist) {
        this.mp3_artist = mp3_artist;
    }

    public String getMp3_description() {
        return mp3_description;
    }

    public void setMp3_description(String mp3_description) {
        this.mp3_description = mp3_description;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @NonNull
    public static List<DATA_mp3> getAudioSamples() {
        return audioSamples;
    }
}
