package dev.rugi.aot;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        BigDecimal price
) {
}