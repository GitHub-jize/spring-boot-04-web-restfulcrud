package com.ji.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBoot04WebRestfulcrudApplicationTests {

  /*  @Autowired
    DataSource dataSource;
*/
    @Test
    public void contextLoads() throws SQLException {

       /* System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();*/
    }
}
