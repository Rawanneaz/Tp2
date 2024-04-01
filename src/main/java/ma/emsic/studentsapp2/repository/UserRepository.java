package ma.emsic.studentsapp2.repository;

import ma.emsic.studentsapp2.entities.Patient;
import ma.emsic.studentsapp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
