public application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.user;
public interface UserRepository extends CrudRepository<User, Long>{
    public User findByUsername(String username);
}