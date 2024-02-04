package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inventory_items")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String productName;
    private String category;
    private int availableQuantity;
    private int totalQuantity;
    private int reservedQuantity;
    private BigDecimal price;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
