package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategory();
}
