package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import vo.User;
import util.DBConnection;
import util.DateConvert;


public class IUserDAOImp implements IUserDAO {
    private DBConnection dbc = null;
    private Connection conn = null;

    public IUserDAOImp() {
        this.dbc = new DBConnection();
        this.conn = dbc.getConnection();
    }

    //增加人员
    public boolean doInsert(User user) {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "insert into user(id,name,sex,birthday) values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSex());
            pstmt.setDate(4, new DateConvert().uDToSD(user.getBirthday()));
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;

    }

    //按照id删除
    public boolean doDelete(int id) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM user WHERE id=? ";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id); // 所有的内容从user类中取出
            if (pstmt.executeUpdate() > 0) {// 至少已经更新了一行
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally { // 不管如何抛出，最终肯定是要进行数据库的关闭操作的
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return flag;
    }


    // 修改人员信息
    public boolean doUpdate(int id, User user) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "update user set name=?,sex=?,birthday=? WHERE id=?";//set到where之间后有空格

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSex());
            pstmt.setDate(3, new DateConvert().uDToSD(user.getBirthday()));
            pstmt.setInt(4, user.getId());
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;

    }


    //按id查询
    public User findById(int id) throws Exception {
        User user = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT id,name,sex,birthday FROM user WHERE id=?";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery(); // 执行查询操作
            if (rs.next()) {
                user = new User(id);
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setBirthday(rs.getDate(4));
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally { // 不管如何抛出，最终肯定是要进行数据库的关闭操作的
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return user;
    }

    //按照关键字查询
    public List<User> findByKey(String keyword) throws Exception {
        List<User> list = new ArrayList<User>();
        PreparedStatement pstmt = null;

        String sql1 = "select * from user where name like ? or sex like ?";

        try {
            pstmt = this.conn.prepareStatement(sql1);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(keyword);
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setBirthday(rs.getDate(4));
                list.add(user); // 所有的内容向集合中插入
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally { // 不管如何抛出，最终肯定是要进行数据库的关闭操作的
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return list;
    }

}

		
