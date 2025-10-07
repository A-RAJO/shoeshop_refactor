package com.github.chore.repository.entity.image;

import com.github.chore.repository.entity.shoe_option.ShoeOption;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "image")
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Integer imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_option_id", nullable = false)
    private ShoeOption shoeOption;

    @Column(name = "image_link",length = 500)
    private String imageLink;

    @Column(name="image_type")
    private ImageType imageType;

    @Column(name = "file_name",nullable = false, length = 100)
    private String file_name;

    @Builder.Default // 필드에 기본값이 필요하면서 @Builder를 쓰고 싶을 때 사용. 보통 빌더는 초기값 안 넣으면 null 처리함
    @Column(name="is_primary", nullable = false)
    private Boolean isPrimary = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}