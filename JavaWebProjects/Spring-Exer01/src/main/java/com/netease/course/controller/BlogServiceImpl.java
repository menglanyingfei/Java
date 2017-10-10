package com.netease.course.controller;

public class BlogServiceImpl implements BlogService {
    private BlogDAOImpl blog;

    public void setBlog(BlogDAOImpl blog) {
        this.blog = blog;
    }

    public void pressblog(String title, String content) {
        this.blog.insertArticle(title,content);
    }
}
