package com.bit.bookclub.modules.account.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class AuditingEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime joinedAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
