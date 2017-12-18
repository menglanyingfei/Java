package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import util.DBConnection;

public class TestJDBC {

	static int count = 1;

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		double unitPrice = sc.nextDouble();
		int sum = sc.nextInt();
		String saleman = sc.next();

		PreparedStatement pstmt = null;
		
		String sqlQuery = "select * from saleDetail";
		String sql = "insert into saleDetail(number,name,unitPrice,sum, time, saleman) "
				+ "values(?, ?, ?, ?, NOW(), ?)";
		
		try {
			pstmt = db.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
			}
			// System.out.println("count = " + count);
			pstmt.close();
			rs.close();

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			// System.out.println(sdf.format(date));
			// System.out.println(sdf.format(date).replaceAll("-", ""));
			// 数据格式化
			String number = String.format("%04d", count);
			pstmt = db.getConnection().prepareStatement(sql);

			pstmt.setString(1, sdf.format(date) + number);
			pstmt.setString(2, name);
			pstmt.setDouble(3, unitPrice);
			pstmt.setInt(4, sum);
			pstmt.setString(5, saleman);

			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("插入数据成功!");
			System.out.println("输入商品名称和日期:");
			name = sc.next();
			String queryDate = sc.next();
			String sqlQuerySum = "select * from saleDetail where name=? and time LIKE '%" + queryDate + "%' ";
			pstmt = db.getConnection().prepareStatement(sqlQuerySum);
			
			
			pstmt.setString(1, name);
//			pstmt.setString(2, queryDate);
			
			ResultSet rs1 = pstmt.executeQuery();
			
			double saleMoney = 0;
			while (rs1.next()) {
				saleMoney += rs1.getDouble("unitPrice") * rs1.getDouble("sum");
			}
			// huawei 2017-12-17
			System.out.println("该商品该日期的总销售额: " + saleMoney);
			rs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			db.close();
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
