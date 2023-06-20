package cybersoft.example.cozastore_java21.service;

import cybersoft.example.cozastore_java21.entity.ProductEntity;
import cybersoft.example.cozastore_java21.payload.response.ProductResponse;
import cybersoft.example.cozastore_java21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> responseList = new ArrayList<>();

        for(ProductEntity pEntity : list){
            responseList.add(
                    new ProductResponse(
                              pEntity.getId()
                            , pEntity.getName()
                            , pEntity.getPrice()
                            , pEntity.getImage()
                    )
            );
        }
        return responseList;
    }
}