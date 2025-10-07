package com.github.chore.repository.entity.shoe_detail;

import com.github.chore.repository.entity.shoe.Shoe;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.github.chore.repository.entity.shoe_detail.Season.ALL_SEASON;

@Getter
@Setter
@Entity
@Table(name = "shoe_detail")
public class ShoeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_detail_id", nullable = false)
    private Integer shoeDetailId;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "model_name", nullable = false, length = 100)
    private String modelName;

    @Column(name = "model_number", length = 50)
    private String modelNumber;

    @Column(name = "collection",length = 50)
    private String collection;

    @Column(name = "collaboration",length = 50)
    private String collaboration;

    @Column(name= "all_description", nullable = false)
    private String allDescription;

    @Column(name= "short_description", nullable = false, length = 500)
    private String shortDescription;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "season")
    private Season season = ALL_SEASON;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Builder.Default
    @Column(name = "is_limited_edition")
    private Boolean isLimitedEdition = Boolean.valueOf(false);

    @Builder.Default
    @Column(name = "is_collaboration")
    private Boolean isCollaboration = Boolean.valueOf(false);

}
