package top.linxixiangxin.database;
import java.sql.*;
public class register extends access {
    public static void main(String[] args) {
        int n = rigisterrr("张三","woshimima");
        System.out.println(n);
    }
    public static int rigisterrr(String username,String password) {//score,rank默认为*0*和*初学乍到*
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
//        sql = "SELECT * FROM userr";//SQL语句位置
            int res = stmt.executeUpdate("insert into main values('"+username+"','"+password+"','0','初学乍到');");
            // 完成后关闭
            stmt.close();
            conn.close();
            System.out.println("数据库连接关闭");
            return res;
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
//    System.out.println("数据库连接已经关闭");
        return 0 ;
    }
}
