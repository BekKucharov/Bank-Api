package uz.kucharov.apibank.repository;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kucharov.apibank.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPassportSerial(@Length(max = 9) String passportSerial);
    Optional<User> findByUsername(String username);
}
