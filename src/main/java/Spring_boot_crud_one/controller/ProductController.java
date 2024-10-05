package Spring_boot_crud_one.controller;

import Spring_boot_crud_one.model.Product;
import Spring_boot_crud_one.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService service;

    //PostMappings methods
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
@PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    // GetMapping methods
    @GetMapping("/allProducts")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/ProductById/{id}")
    public Product findProductById( @PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/ProductByName/{name}")
    public Product findProductName( @PathVariable String name){
        return service.getProductByName(name);
    }

    // Delete mapping
    @DeleteMapping("/delete/{id}")
    public  String deleteProduct(@PathVariable int id){

     return service.deleteProduct(id);

    }

    // Update mapping

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

}
