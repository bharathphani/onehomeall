package com.onehome.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

// @Table anno is not required if Class camel case matches table name
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OnehomeUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "active")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;

    private String email;

    private String mobileNo;

    private String addressLine1;

    private String addressLine2;

    private String pincode;

    private String city;

    private String state;
}
