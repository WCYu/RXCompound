package com.rxjy.rxcompound.entity;

import java.util.List;

/**
 * Created by hjh on 2017/11/14.
 */

public class FindDataBean {

    private String spare1;
    private String name;
    private String author;
    private String cover;
    private String releaseDate;
    private int id;
    private int tid;
    private int did;
    private int praise;
    private int view;
    private int type;
    private int courseId;
    private List<String> contentPic;
    private String content;
    private String summary;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getContentPic() {
        return contentPic;
    }

    public void setContentPic(List<String> contentPic) {
        this.contentPic = contentPic;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public FindDataBean() {super();
    }

    @Override
    public String toString() {
        return "FindDataBean{" +
                "spare1='" + spare1 + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", id=" + id +
                ", tid=" + tid +
                ", did=" + did +
                ", praise=" + praise +
                ", view=" + view +
                ", type=" + type +
                ", courseId=" + courseId +
                '}';
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
