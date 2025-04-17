package com.onehome.socialsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "CREATED_ON", updatable = false)
    @CreatedDate
    private LocalDateTime createdOn;

    // if col name is CREATED_ON and if variable name is like createdBy no need
    // to add col name mapping
    @Column(updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(updatable = false)
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    @Column(updatable = false)
    @LastModifiedBy
    private String modifiedBy;

}

