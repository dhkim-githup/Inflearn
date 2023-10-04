package com.hodolog.request;

public class PostCreate {
    public String title;
    public String contents;

    @Override
    public String toString() {
        return "PostCreate{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
