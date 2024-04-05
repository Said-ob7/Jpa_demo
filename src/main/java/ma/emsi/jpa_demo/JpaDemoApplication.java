package ma.emsi.jpa_demo;

import ma.emsi.jpa_demo.entities.Product;
import ma.emsi.jpa_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"computer", 4330, 3));
        //productRepository.save(new Product(null,"printer", 3000, 10));
        //productRepository.save(new Product(null,"Mouse", 433, 50));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("****************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("****************");
        System.out.println("-------------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(c->{
            System.out.println(c.toString());
        });
        System.out.println("-----------------");
        List<Product> productList2 = productRepository.search("%r%");
        productList2.forEach(c->{
            System.out.println(c.toString());
        });

        Product product1 = productRepository.findById(Long.valueOf(2)).get();
        System.out.println("******************");
        product1.setId(6L);
        product1.setName("Laptop");
        product1.setPrice(5000L);
        product1.setQuantity(2);
        System.out.println("******************");

        productRepository.deleteById(2L);
    }
}
