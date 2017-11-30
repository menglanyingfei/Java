package view;

import util.InputData;
import dao.IUserDAOImp;
import vo.User;

import java.util.List;

public class Menu {
    IUserDAOImp iu = new IUserDAOImp();
    InputData input = new InputData();

    public Menu() {
        while (true) {
            this.show();
        }
    }

    public void show() {
        System.out.println("--------人员信息管理系统-------");
        System.out.println("1.增加人员");
        System.out.println("2.按编号删除人员");
        System.out.println("3.按编号修改人员信息");
        System.out.println("4.按编号查询人员信息");
        System.out.println("5.按关键字查询人员信息");
        System.out.println("0.退出");

        User user = null;
        int i = input.getInt("请选择：", "请输入正确的选项！");
        switch (i) {
            case 1:
                int id = input.getInt("请输入人员编号:", "格式不对,请重新输入!");
                String name = input.getString("请输入人员姓名:");
                String sex = input.getString("请输入性别:");
                java.util.Date birthday = input.getDate("请输入出生日期:", "格式不对,请重新输入!");
                user = new User(id, name, sex, birthday);
                if (iu.doInsert(user)) {
                    System.out.println("添加成功！");
                } else {
                    System.out.println("添加失败！");
                }
                break;
            case 2:
                int id2 = input.getInt("请输入人员编号:", "格式不对,请重新输入!");
                try {
                    if (iu.doDelete(id2)) {
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("删除失败！");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 3:
                int id3 = input.getInt("请输入人员编号:", "格式不对,请重新输入!");
                String name3 = input.getString("请输入人员姓名:");
                String sex3 = input.getString("请输入性别:");
                java.util.Date birthday3 = input.getDate("请输入出生日期:", "格式不对,请重新输入!");
                user = new User(id3, name3, sex3, birthday3);
                try {
                    if (iu.doUpdate(id3, user)) {
                        System.out.println("修改成功！");
                    } else {
                        System.out.println("修改失败！");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 4:
                int id4 = input.getInt("请输入人员编号:", "格式不对,请重新输入!");
                try {
                    user = iu.findById(id4);
                    System.out.println(user);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case 5:
                String keyword5 = input.getString("请输入查询关键字");
                try {
                    List<User> list = iu.findByKey(keyword5);
                    for (User u : list) {
                        System.out.println(u);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 0:
                System.exit(1);
                break;
            default:
                System.out.println("请选择正确的操作！");
        }
    }
}
