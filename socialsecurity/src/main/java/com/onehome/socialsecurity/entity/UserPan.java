package com.onehome.socialsecurity.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPan extends BaseEntity {

    @Id
    private long id;

    private String pan;

    private String name;

    private String mobileNo;
}
