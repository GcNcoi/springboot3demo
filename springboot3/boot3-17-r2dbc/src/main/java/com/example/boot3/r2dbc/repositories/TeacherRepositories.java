package com.example.boot3.r2dbc.repositories;

import com.example.boot3.r2dbc.entity.Teacher;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import java.util.Collection;

@Repository
public interface TeacherRepositories extends R2dbcRepository<Teacher, Long> {

    Flux<Teacher> findAllByIdInAndNameLike(Collection<Long> ids, String name);

}
