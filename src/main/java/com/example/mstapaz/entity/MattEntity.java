package com.example.mstapaz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "mattress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MattEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

//    @OneToOne(
//            mappedBy = "mattress",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @ToString.Exclude
//    private MattressDetailsEntity mattressDetails;

//    @OneToMany(
//            mappedBy = "mattress",
//            cascade = CascadeType.ALL
//    )
//    @ToString.Exclude
//    private List<CommentEntity>comments;

}
