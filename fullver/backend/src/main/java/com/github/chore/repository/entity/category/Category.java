package com.github.chore.repository.entity.category;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "category_name",nullable = false, length = 100)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", insertable=false, updatable=false)
    private Category parentcategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "targer_gender", nullable = false)
    private targetGender targetGender;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    private ageGroup ageGroup;

    @Enumerated(EnumType.STRING)
    @Column(name="shoe_type",nullable = false)
    private shoeType shoeType;

    @Column(name="cotegory_level")
    private Integer categoryLevel;

    @Column(name = "category_path",length = 500)
    private String categoryPath;

}
