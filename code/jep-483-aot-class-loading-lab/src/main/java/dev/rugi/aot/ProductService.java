package dev.rugi.aot;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    public List<Product> findAll() {
        return List.of(
                new Product(
                        1L,
                        "Laptop",
                        new BigDecimal("15000.00")
                ),
                new Product(
                        2L,
                        "Monitor",
                        new BigDecimal("4500.00")
                ),
                new Product(
                        3L,
                        "Keyboard",
                        new BigDecimal("1200.00")
                )
        );
    }
}