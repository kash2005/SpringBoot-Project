package lk.ijse.gdse65.aad.HelloSpringBoot.repostory;

import lk.ijse.gdse65.aad.HelloSpringBoot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,Integer> {
}
