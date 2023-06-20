package cybersoft.example.cozastore_java21.controller;

import cybersoft.example.cozastore_java21.entity.UserEntity;
import cybersoft.example.cozastore_java21.payload.request.SignupRequest;
import cybersoft.example.cozastore_java21.payload.response.BaseResponse;
import cybersoft.example.cozastore_java21.service.UserService;
import cybersoft.example.cozastore_java21.utils.JWTHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(
            @RequestParam String email,
            @RequestParam String password){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,password);
        authenticationManager.authenticate(token);

        // token khong luu tru password --> token co the bi hack
        String jwt = jwtHelper.generateToken(email);

        // tra  kqa trang login theo cau truc
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
//    public ResponseEntity<?> signup(@Valid @RequestBody UserEntity userEntity){
////        BaseResponse response = new BaseResponse();
////        BaseR request = new BaseRequest();
////        boolean isSucess = request.matchPattern(userEntity.getEmail(),"^(.+)@(\\\\S+)$");
//        if(isSucess){
//            userService.save(userEntity);
//            response.setStatusCode(200);
//            response.setMessage("All fields signup is valid");
//        }else{
//            response.setStatusCode(400);
//            response.setMessage("Wrong email format");
//        }
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }
    public ResponseEntity<?> signup(@Valid SignupRequest request){

        boolean isSucess = userService.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSucess);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
