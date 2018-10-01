package eci.cosw.data;

import eci.cosw.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);
	User findByEmail(String email);
    

}