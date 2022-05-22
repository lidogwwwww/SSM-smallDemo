import com.ssm.bean.Account;
import com.ssm.service.accountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
public class testSpring {
    @Test
    public  void testSpring(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        accountService accountService=ac.getBean("accountService", accountService.class);
        List<Account> list=accountService.getAllAccount();
        list.forEach(account -> System.out.println(account));
    }
}
