package com.wtu.entity;

import java.util.List;

/**
 * 封装了 分页查询的所有参数
 *
 * @author Administrator
 */
public class PageBean<T> {

    private Integer cp; //当前页
    private Integer tp; //总页数
    private Integer tr; //总记录数
    private Integer pr;//每页记录数
    private List<T> list;//每页数据

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getTp() {
        int count = tr / pr;
        return (tr % pr == 0) ? count : count + 1;
    }

    //	public void setTp(Integer tp) {
//		this.tp = tp;
//	}
    public Integer getTr() {
        return tr;
    }

    public void setTr(Integer tr) {
        this.tr = tr;
    }

    public Integer getPr() {
        return pr;
    }

    public void setPr(Integer pr) {
        this.pr = pr;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
