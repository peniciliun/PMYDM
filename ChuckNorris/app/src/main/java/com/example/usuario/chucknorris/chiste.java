package com.example.usuario.chucknorris;

/**
 * Created by Usuario on 14/11/2017.
 */

public class chiste {
    private String icon_url="";
    private String id="";
    private String url="";
    private String value="";

    public chiste(String icon_url, String id, String url, String value) {
        this.icon_url = icon_url;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
