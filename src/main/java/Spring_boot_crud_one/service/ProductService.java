package Spring_boot_crud_one.service;

import Spring_boot_crud_one.model.Product;
import Spring_boot_crud_one.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
// Post methods
    public Product saveProduct(Product product){
        return repo.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repo.saveAll(products);
    }
    // Get methods

    public List<Product> getProducts(){
        return repo.findAll();
    }
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }
    //here,we have to define the method in our JPA repository
    //findBy is the prefix of the method and Name is the quantity we are looking

    public Product getProductByName(String name){
        return repo.findByName(name);
    }
    // delete product from the database
    public  String deleteProduct(int id){
        repo.deleteById(id);
       return "This product with ID has been removed " +id;
    }
     /*Update or Put method
     Here,the new  product as argument in the update function is the new product
     given to be updated in the postman*/
    public  Product updateProduct(Product product){
        Product existingProduct= repo.findById(product.getProductId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return repo.save(existingProduct);
    }

}
