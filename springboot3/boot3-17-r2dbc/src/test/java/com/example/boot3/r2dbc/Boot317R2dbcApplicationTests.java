package com.example.boot3.r2dbc;

import com.example.boot3.r2dbc.entity.Teacher;
import com.example.boot3.r2dbc.repositories.TeacherRepositories;
import com.jayway.jsonpath.Criteria;
import io.asyncer.r2dbc.mysql.MySqlConnectionConfiguration;
import io.asyncer.r2dbc.mysql.MySqlConnectionFactory;
import io.asyncer.r2dbc.mysql.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class Boot317R2dbcApplicationTests {

    @Autowired
    R2dbcEntityTemplate r2dbcEntityTemplate;

    @Autowired
    DatabaseClient databaseClient;

    @Autowired
    TeacherRepositories teacherRepositories;

    @Test
    void teacherRepositories() throws IOException {
//        teacherRepositories.findAll()
//                .subscribe(teacher -> System.out.println("teacher = " + teacher));
        teacherRepositories.findAllByIdInAndNameLike(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), "陈%")
               .subscribe(teacher -> System.out.println("teacher = " + teacher));

        System.in.read();
    }

    @Test
    void databaseClient() throws IOException {
        databaseClient.sql("select * from teacher where id = ?")
                .bind(0, 3L)
                .fetch()
                .all()
                .map(map -> {
                    System.out.println("map = " + map);
                    String id = map.get("id").toString();
                    String name = map.get("name").toString();
                    return new Teacher(Long.parseLong(id), name, null);
                })
                .subscribe(teacher -> System.out.println("teacher = " + teacher));

        System.in.read();
    }

    @Test
    void connection() throws IOException {
        System.out.println("测试git");
        System.out.println("测试git hot-fix 分支");
        System.out.println("git master 分支");
        System.out.println("git hot-fix test 分支");
//        ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:mysql://localhost:3306/teachers");
        MySqlConnectionConfiguration configuration = MySqlConnectionConfiguration.builder()
                .host("localhost")
                .port(3306)
                .username("root")
                .password("1234")
                .database("teachers")
                .build();

        MySqlConnectionFactory connectionFactory = MySqlConnectionFactory.from(configuration);

        Mono.from(connectionFactory.create())
                .flatMapMany(connection ->
                        connection
                                .createStatement("select * from teacher where id = ?")
                                .bind(0, 1)
                                .execute()
                ).flatMap(result -> {
                    return result.map(readable -> {
                        Long id = readable.get("id", Long.class);
                        String name = readable.get("name", String.class);
                        String companyName = readable.get("company_name", String.class);
                        return new Teacher(id, name, companyName);
                    });
                })
                .subscribe(teacher -> System.out.println("teacher = " + teacher));

        System.in.read();
    }

}
