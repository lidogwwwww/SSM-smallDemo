import com.ssm.bean.Account;
import com.ssm.controller.accountController;
import com.ssm.mapper.accountMapper;
import com.ssm.service.accountService;
import com.ssm.serviceImpl.accountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
public class testMybatis {
    @Test
    public void testMybatis(){
        try {
            InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            accountMapper accountMapper=sqlSession.getMapper(accountMapper.class);
            List<Account> list=accountMapper.getAllAccount();
            list.forEach(account -> System.out.println(account));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
