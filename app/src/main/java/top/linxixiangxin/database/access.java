package top.linxixiangxin.database;

public class access {
    // I WANT SOMETHING JUST LIKE THIS
    // JDBC 驱动名及数据库 URL//全包调用
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://112.74.184.181/guess?useUnicode=true&characterEncoding=UTF-8";//设置个字符集，解决上传SQL的时候乱码的问题(神坑。。
    // 数据库的用户名与密码
    static final String USER = "root";//全局变量
    static final String PASS = "ac908148781";
    private static final String TAG = "access";
//    public static void main(String[] args) { //2019年3月21日调通咯，main仅测试服务器是否通联。
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // 打开链接
//            System.out.println("连接数据库...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM main";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                String id  = rs.getString("username");
//                String na = rs.getString("password");
//                String ty = rs.getString("score");
//                String rank = rs.getString("rank");
//
//                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 姓名: " + na);
//                System.out.print(", type: " + ty);
//                System.out.print(", Rank: " + rank);
//                System.out.print("\n");
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Goodbye!");
//    }
}
