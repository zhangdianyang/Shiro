package test.cglib;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.pojo.User;

import java.io.InputStream;

public class Person {
    
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void info(){
        System.out.println("name:"+getName()+" age:"+getAge());
    }

    public static class test {

        public  void test1(){
            String resource = "Configuration.xml";
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            InputStream is = test.class.getClassLoader().getResourceAsStream(resource);
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

            SqlSession session = sessionFactory.openSession();
            /**
             * 映射sql的标识字符串，
             * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            String statement = "test.dao.UserDao.getUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            User user = session.selectOne(statement, "1");
            System.out.println(user.toString());
        }
    }
}
