package org.javaportfolio.quizapp.models.data;

import org.javaportfolio.quizapp.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByEmail(String email);

}