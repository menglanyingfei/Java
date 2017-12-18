package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;
import vo.Student;

public class Driver {
    //存放目前集合中的学生信息
    public static List<Student> list = new ArrayList<>();

    public static void main(String args[]) {
        int choice = menuChoice();
        while (choice != 7) {
            switch (choice) {
                case 1:
                    importFromExcel();
                    break;
                case 2:
                    importFromTxt();
                    break;
                case 3:
                    inputFromKeyboard();
                    break;
                case 4:
                    queryStudent();
                    break;
                case 5:
                    exportToExcel();
                    break;
                case 6:
                    exportToTxt();
                    break;
                default:
                    System.out.println("无效的选择");

            }
            choice = menuChoice();
        }
        System.out.println("程序成功退出");
        System.exit(0);

    }

    public static int menuChoice() {
        System.out.println("====学生成绩管理系统=====");
        System.out.println("1.	从excel中加载数据");
        System.out.println("2.	从文本文件加载数据");
        System.out.println("3.	键盘输入");
        System.out.println("4.	成绩查询");
        System.out.println("5.	输出到excel文件");
        System.out.println("6.	输出到纯文本文件");
        System.out.println("7.	退出");
        System.out.println("请输入选项：");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 7) {
            System.out.println("确认退出系统吗？");
            String c = scan.next();
            if (c.equals("Y")) {
                return choice;
            } else if (c.equals("N")) {
                return 0;
            }
        }

        return choice;
    }

    public static void importFromExcel() {
        /*
         * 调用dao中的方法
		 */
        StudentDAO dao = new StudentDAO();
        String fileName = "data/student.xls";
        List<Student> list1 = dao.ReadFromExcel(fileName);
        list.addAll(list1); //将list1集合中的数据增加到list集合中
        System.out.println("成功从excel中导入" + list1.size() + "个学生");
        printList(list1);
    }

    public static void importFromTxt() {
		/*
		 * 调用dao中的方法
		 */
        StudentDAO dao = new StudentDAO();
        String fileName = "data/student.txt";
        List<Student> list1 = dao.ReadFromTxt(fileName);
        list.addAll(list1); //将list1集合中的数据增加到list集合中
        System.out.println("成功从txt中导入" + list1.size() + "个学生");
        printList(list1);
    }

    public static void inputFromKeyboard() {
        StudentDAO dao = new StudentDAO();
        Student student;
        // 当student不为null时，将student对象增加到集合中
        System.out.println("输入-1结束从键盘增加对象:");
        while ((student = dao.ReadFromKeyBoard(list)) != null) {
            list.add(student);
            System.out.println("增加成功");
        }

        printList(list);
    }

    public static void queryStudent() {
        StudentDAO dao = new StudentDAO();
        System.out.println("请输入待查询学生的学号：");
        String id = new Scanner(System.in).nextLine();
        List<Student> list1 = dao.QueryById(id, list);
        if (list1.size() > 0) {
            printList(list1);
        } else {
            System.out.println("没找到该学生相关的成绩");
        }

    }

    public static void exportToExcel() {
        StudentDAO dao = new StudentDAO();
        String fileName = "data/score.xls";
        dao.WriteExcel(list, fileName);

        System.out.println("成功写入" + list.size() + "个学生到excel");
    }

    public static void exportToTxt() {
        StudentDAO dao = new StudentDAO();
        String fileName = "data/score.txt";
        dao.WriteTxt(list, fileName);
        System.out.println("成功写入" + list.size() + "个学生到txt");
    }

    //显示集合中的每一个学生信息
    public static void printList(List<Student> list) {
        for (Student student : list) {
            System.out.println(student.toString());
        }

    }


}
