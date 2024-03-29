package lk.ijse.gdse65.aad.HelloSpringBoot.repostory;

import lk.ijse.gdse65.aad.HelloSpringBoot.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
