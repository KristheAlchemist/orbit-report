package org.javaportfolio.quizapp.models.data;

import org.javaportfolio.quizapp.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    Teacher findByEmail(String email);

}