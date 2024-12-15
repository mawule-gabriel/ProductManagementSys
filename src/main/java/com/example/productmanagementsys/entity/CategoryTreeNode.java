package com.example.productmanagementsys.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTreeNode {

    private Category category;         // The actual category
    private CategoryTreeNode left;     // Left child category
    private CategoryTreeNode right;    // Right child category
}
