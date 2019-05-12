package my.demo.repository;

import my.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nid
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
