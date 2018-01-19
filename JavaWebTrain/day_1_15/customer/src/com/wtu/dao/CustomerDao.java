package com.wtu.dao;

import java.util.*;

import com.wtu.utils.DateUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import com.wtu.entity.Customer;
import com.wtu.entity.PageBean;
import com.wtu.utils.JDBCUtils;

public class CustomerDao {


    private QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());

    /**
     * 添加客户
     *
     * @param c 客户对象
     * @throws Exception
     */
    public void addCustomer(Customer c) throws Exception {
        String sql = "insert into `customer` values(?,?,?,?,?,?,?)";
        Object[] obj = {c.getCid(), c.getCname(), c.getGender(), DateUtil.dateToStr(c.getBirthday()), c.getCellPhone(), c.getEmail(), c.getDescription()};
        qr.update(sql, obj);
    }


    /**
     * 修改客户信息
     *
     * @param c
     * @throws Exception
     */
    public void editCustomer(Customer c) throws Exception {
        String sql = "update customer set cname = ?, gender=?,birthday=?,cellphone=?,email=?,description=? where cid = ?";
        Object[] obj = {c.getCname(), c.getGender(), c.getBirthday(), c.getCellPhone(), c.getEmail(), c.getDescription(), c.getCid()};
        qr.update(sql, obj);
    }

    public void deleteCustomer(Integer cid) throws Exception {

    }

    /**
     * 查询所有用户
     *
     * @return 返回封装了所有客户的list集合
     * @throws Exception
     */
    public PageBean<Customer> findAllCustomer(PageBean pageBean) throws Exception {
        String sql = "select * from customer limit ?,?";
        Object[] obj = {(pageBean.getCp() - 1) * pageBean.getPr(), pageBean.getPr()};
        List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(Customer.class), obj);
        pageBean.setList(list);

        // 查询总记录数
        sql = "select count(*) from customer";
        Number n = (Number) qr.query(sql, new ScalarHandler());
        Integer tr = n.intValue();
        pageBean.setTr(tr);

        return pageBean;
    }

    /**
     * 根据id对客户进行查询
     *
     * @param cid
     */
    public Customer findCustomerById(String cid) throws Exception {
        String sql = "select * from customer where cid = ?";
        Object[] obj = {cid};
        Customer c = qr.query(sql, new BeanHandler<Customer>(Customer.class), obj);
        return c;
    }

    /**
     * 删除
     *
     * @param cid
     * @throws Exception
     */
    public void deleteCustomerById(String cid) throws Exception {
        String sql = "delete from customer where cid = ?";
        Object[] obj = {cid};
        qr.update(sql, obj);
    }

    @Test
    public void test() throws Exception {
        //使用UUID生成一个客户的id
        for (int i = 0; i < 50; i++) {
            UUID uuid = UUID.randomUUID();
            String cid = uuid.toString();
            cid = cid.replace("-", "");

            String sql = "insert into `customer` values(?,?,?,?,?,?,?)";
            Customer c = new Customer(cid, "lili", "男", new Date(), "111", "111", "777");
            Object[] obj = {c.getCid(), c.getCname(), c.getGender(), DateUtil.dateToStr(c.getBirthday()), c.getCellPhone(), c.getEmail(), c.getDescription()};
            qr.update(sql, obj);
        }


//        Customer c1 = new Customer("sdfsd54fsd31fsd3", "狗娃", "男", new Date(), "sdfs", "sdfsdf", "会计法");
//        editCustomer(c1);

//        Customer c = findCustomerById("c07c314126f94d92aef262b3f0b9a9f8");
//        System.out.println(c);

//        List<Customer> list = findAllCustomer();
//        System.out.println(list);
    }

    @Test
    public void test2() throws Exception {
//		String sql = "select * from customer where cid = ?";
//		Object[] obj = {"679534e9505f480b96e8c6e0f869b4c2"};
//		Map<String, Object> map = qr.query(sql, new MapHandler(), obj);
//		System.out.println(map);

//		String sql = "select * from customer";
//		List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
//		System.out.println(list);

        String sql = "select count(*) from customer";
        Number number = (Number) qr.query(sql, new ScalarHandler());
        Integer i = number.intValue();
        System.out.println(i);
    }


    /**
     * 根据多条件  查询
     *
     * @param customer
     * @param cp
     * @param pr
     * @return
     * @throws Exception
     */
    public PageBean<Customer> query(Customer customer, Integer cp, Integer pr) throws Exception {
        //创建PageBean对象
        PageBean<Customer> pb = new PageBean<Customer>();
        pb.setCp(cp);
        pb.setPr(pr);

        //查询总记录数
        StringBuilder sql = new StringBuilder("select count(*) from customer where 1 = 1");


        //定义初始sql语句
        StringBuilder baseSql = new StringBuilder("select * from customer where 1 = 1");
        //定义集合存储参数
        List<Object> params = new ArrayList<Object>();

        //获取用户名  并且判断
        String cname = customer.getCname();
        if (cname != null && !"".equals(cname.trim())) {
            sql.append(" and cname like ?");
            baseSql.append(" and cname like ?");
            params.add("%" + cname + "%");
        }

        String gender = customer.getGender();
        if (gender != null && !"".equals(gender.trim())) {
            sql.append(" and gender = ?");
            baseSql.append(" and gender = ?");
            params.add(gender);
        }

        String cellphone = customer.getCellPhone();
        if (cellphone != null && !"".equals(cellphone.trim())) {
            sql.append(" and cellphone like ?");
            baseSql.append(" and cellphone like ?");
            params.add("%" + cellphone + "%");
        }

        String email = customer.getEmail();
        if (email != null && !"".equals(email.trim())) {
            sql.append(" and email like ?");
            baseSql.append(" and email like ?");
            params.add("%" + email + "%");
        }

        //查询总记录数的参数  是不需要带limit限制的
        Number nb = (Number) qr.query(sql.toString(), new ScalarHandler(), params.toArray());
        Integer tr = nb.intValue();//将Number类型的数转换成Integer类型
        pb.setTr(tr);

        baseSql.append(" limit ?,?");
        params.add((cp - 1) * pr);
        params.add(pr);
        //将集合转换成为数组   将baseSql转换成为String 类型
        List<Customer> list = qr.query(baseSql.toString(), new BeanListHandler<Customer>(Customer.class), params.toArray());

        pb.setList(list);
        return pb;
    }
}
