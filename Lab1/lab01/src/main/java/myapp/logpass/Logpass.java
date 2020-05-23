package myapp.logpass;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class Logpass {

    @Bean
    public DataSource dataSource() throws SQLException {
        var dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://localhost:3306/javalab?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("12232");
        return dataSource;
    }

}
