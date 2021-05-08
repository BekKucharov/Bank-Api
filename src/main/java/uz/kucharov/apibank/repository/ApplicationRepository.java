package uz.kucharov.apibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kucharov.apibank.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
