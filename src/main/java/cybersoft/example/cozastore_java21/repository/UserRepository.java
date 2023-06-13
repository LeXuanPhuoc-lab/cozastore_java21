package cybersoft.example.cozastore_java21.repository;

import cybersoft.example.cozastore_java21.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
   // Cach 1
   //   @Query("SELECT * FROM Employee WHERE username = ?1")
   //   ArrayList<UserEntity> getUserByUsername(String username);
   // Cach 2
   UserEntity findByEmail(String email);
}
