package cybersoft.example.cozastore_java21.controller;

import cybersoft.example.cozastore_java21.payload.response.BaseResponse;
import cybersoft.example.cozastore_java21.payload.response.CategoryResponse;
import cybersoft.example.cozastore_java21.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(categoryService.getAllCategory());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
