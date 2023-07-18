package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",schema = "bootcamp", uniqueConstraints = {@UniqueConstraint(name = "unique_number_type_id", columnNames = {"type_id", "number_id"})})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type_id", nullable = false)
    private String typeId;
    @Column(name = "number_id", nullable = false)
    private String numberId;
    @Column(name = "name", nullable = false)
    private String name;
}
