package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.entity.UserEntity;
import cybersoft.example.cozastore_java21.exception.CustomException;
import cybersoft.example.cozastore_java21.payload.request.SignupRequest;
import cybersoft.example.cozastore_java21.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSucess = false;
        try{
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSucess=true;
        }catch(Exception e){
            throw new CustomException("Loi them user" + e.getMessage());
        }
        return isSucess;
    }
//    @Override
//    public void save(UserEntity user) {
//        String password = user.getPassword();
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//    }

}
