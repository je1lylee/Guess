package top.linxixiangxin.database;
import android.util.Log;

import java.sql.*;

public class login extends access {
    private static final String TAG = "Entry";
//    public static void main(String[] args) {
//        login("test");
//    }

    public final static String[][] login(String usernamee){
        Connection conn = null;
        Statement stmt = null;
        int sample = 0;
        int counter = 0;
        int k = 4;//表里四个属性
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM main where username='"+usernamee+"';";//SQL语句位置
            //TODO 如果查询失败，结果集里什么都没有，RETURN需要处理一波
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sample++;
            }
            // 展开结果集数据库
            rs = stmt.executeQuery(sql);//重置结果集下标位置
            String [][] data = new String[sample][4];//包含sample个一维数组
            for (int i = 0; rs.next(); i++) {//已经存入二维数组可以调用！
                for (int j = 0; j < k; j++) {
                    data[i][j] = rs.getString(j + 1);
                    System.out.println(data[i][j]);
                }
            }
            rs.close();
            stmt.close();
            conn.close();
//            Log.d(TAG,"调试，数据连接关闭");
            return data;//返回二维数组
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
//        System.out.println("数据库连接已经关闭");
        return null;//没返回
    }
}
