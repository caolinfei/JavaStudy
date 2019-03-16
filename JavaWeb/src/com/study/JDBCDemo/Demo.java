package com.study.JDBCDemo;

public class Demo {
    public static void main(String[] args) throws Exception {

        /*Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mytest",
                        "root", "root");

        String sql="UPDATE test SET  name='曹麟飞' WHERE Id=1";
        Statement stm=connection.createStatement();
        int i = stm.executeUpdate(sql);
        System.out.println(i);*/

        //1首先加载包
        /**
         *这里有一个静态代码块 我们知道静态代码块是优先执行的
         *  static {
         try {
         DriverManager.registerDriver(new Driver());
         } catch (SQLException var1) {
         throw new RuntimeException("Can't register driver!");
         }
         }
         * */
        Class.forName("com.mysql.jdbc.Driver");



    }
}
class Test<T>
{
    public void  say(T model)
    {
        System.out.println(model.getClass());
    }
}
