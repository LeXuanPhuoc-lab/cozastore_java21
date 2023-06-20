package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProductByCategory(int id);
}
