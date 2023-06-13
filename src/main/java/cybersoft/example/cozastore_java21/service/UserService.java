package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.entity.UserEntity;
import cybersoft.example.cozastore_java21.payload.request.SignupRequest;

public interface UserService {
    //void save(UserEntity user);
    boolean addUser(SignupRequest request);
}
