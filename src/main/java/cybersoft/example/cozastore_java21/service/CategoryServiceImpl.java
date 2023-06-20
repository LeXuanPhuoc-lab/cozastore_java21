package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.entity.CategoryEntity;
import cybersoft.example.cozastore_java21.payload.response.CategoryResponse;
import cybersoft.example.cozastore_java21.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryResponse> responseList = new ArrayList<>();
        for(CategoryEntity cEntity : list){
            responseList.add(
                    new CategoryResponse(cEntity.getId(), cEntity.getName())
            );
        }
        return responseList;
    }
}
