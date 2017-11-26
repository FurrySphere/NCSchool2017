package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
