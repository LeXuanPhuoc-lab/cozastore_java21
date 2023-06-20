package cybersoft.example.cozastore_java21.controller;

import cybersoft.example.cozastore_java21.payload.response.BaseResponse;
import cybersoft.example.cozastore_java21.payload.response.ProductResponse;
import cybersoft.example.cozastore_java21.service.CategoryService;
import cybersoft.example.cozastore_java21.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productService.getProductByCategory(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
