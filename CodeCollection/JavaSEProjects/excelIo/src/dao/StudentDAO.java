package dao;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import vo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class StudentDAO {

    // 实现读学生文件，将读出的信息存放于student集合中
    public List<Student> ReadFromExcel(String fileName) {

        List<Student> list = new ArrayList<>();

		/*
         * 请补充
		 */
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            HSSFWorkbook book = new HSSFWorkbook(in);
            // 得到第一个Sheet页
            HSSFSheet sheet = book.getSheetAt(0);
            HSSFRow row;

            for (int i = sheet.getFirstRowNum() + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Student student = new Student();

                row = sheet.getRow(i);
                int j = row.getFirstCellNum();
                student.setId(row.getCell(j).toString());
                student.setName(row.getCell(j + 1).toString());
                student.setGender(row.getCell(j + 2).toString());
                student.setJava(Float.parseFloat(row.getCell(j + 3).toString()));
                student.setEnglish(Float.parseFloat(row.getCell(j + 4).toString()));
                student.setMath(Float.parseFloat(row.getCell(j + 5).toString()));
                student.setTotalScore();
                student.setAverage();

                list.add(student);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 从文本文件中读，将读出的数据存放于集合中
    public List<Student> ReadFromTxt(String fileName) {

        List<Student> list = new ArrayList<>();
        /*
		 * 请补充
		 */
        File file = new File(fileName);
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            String content = "";

            while (content != null) {
                content = bf.readLine();

                if (content == null) {
                    break;
                }
                // 设置正则将多余空格或Tab键都转为一个空格
                String[] str = content.trim().split("\\s{2,}|\t");
                Student student = new Student();

                student.setId(str[0]);
                student.setName(str[1]);
                student.setGender(str[2]);
                student.setJava(Float.parseFloat(str[3]));
                student.setEnglish(Float.parseFloat(str[4]));
                student.setMath(Float.parseFloat(str[5]));
                student.setTotalScore();
                student.setAverage();

                list.add(student);
            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 从键盘中输入一条数据，将数据存放于对象中，若student对象为null，表示输入错误
    public Student ReadFromKeyBoard(List<Student> list) {
        Student student = new Student();
		/*
		 * 请补充
		 */
		// 创建输入对象
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        if ("-1".equals(first)) {
            return null;
        }
        for (Student stu : list) {
            if (first.equals(stu.getId())) {
                System.out.println("输入学号重复, 请重新输入:");
                return null;
            }
        }

        student.setId(first);

        student.setName(scanner.next());
        student.setGender(scanner.next());
        student.setJava(scanner.nextFloat());
        student.setEnglish(scanner.nextFloat());
        student.setMath(scanner.nextFloat());
        student.setTotalScore();
        student.setAverage();

        return student;
    }

    // 根据学号查询,返回的结果存放于集合中，若集合为空，表示没找到
    public List<Student> QueryById(String id, List<Student> list) {

        List<Student> list1 = new ArrayList<>();
        String id1 = id + ".0"; // 1 -> 1.0
		/*
		 * 请补充
		 */
        for (Student student : list) {
            if (id1.equals(student.getId())) {
                list1.add(student);
            }
        }

        return list1;
    }


    /*
     * 将List集合数据写入excel（单个sheet）
     *
     * @param excelTitle    文件表头
     * @param list          要写入的数据集合
     * @param sheetName     sheet名称
     */
    // 将集合中的数据写入到excel文件中
    public void WriteExcel(List<Student> list, String fileName) {
		/*
		 * 请补充
		 */
        Workbook workbook = new HSSFWorkbook();

        //create sheet
        String sheetName = "student";
        String[] excelTitle = {"学号", "姓名", "性别", "总分", "平均分"};
        Sheet sheet = workbook.createSheet(sheetName);
        int rowIndex = 0; // 标识位，用于标识sheet的行号
        // 遍历数据集，将其写入excel中
        try {
            // 写表头数据
            Row titleRow = sheet.createRow(rowIndex);
            for (int i = 0; i < excelTitle.length; i++) {
                // 创建表头单元格,填值
                titleRow.createCell(i).setCellValue(excelTitle[i]);
            }
//            System.out.println("表头写入完成>>>>>>>>");
            rowIndex++;
            // 循环写入主表数据
            for (Iterator<Student> iterator = list.iterator();
                 iterator.hasNext(); ) {
                Student student = iterator.next();
                // create sheet row
                Row row = sheet.createRow(rowIndex);
                // create sheet column(单元格)
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(student.getId());
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(student.getName());
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(student.getGender());
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(student.getTotalScore());
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(student.getAverage());
                rowIndex++;
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
//            System.out.println(fileName + "写入文件成功>>>>>>>>>>>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将集合中的数据写入到txt文件中, 思路: 使用打印流
    public void WriteTxt(List<Student> list, String fileName) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(fileName));
            printStream.printf("学号\t姓名\t性别\t总分\t平均分\n");
            for (int i = 0; i < list.size(); i++) {
                printStream.printf("%s\t%s\t%s\t%.2f\t%.2f\n", list.get(i).getId(),
                    list.get(i).getName(), list.get(i).getGender(),
                        list.get(i).getTotalScore(), list.get(i).getAverage());
            }
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}





















