package ru.denisqaa.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class TimestampEntity {
    @CreationTimestamp
    protected Date createdAt;

    @UpdateTimestamp
    protected Date updatedAt;
}