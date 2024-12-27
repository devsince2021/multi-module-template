package com.iwsaitw.utils.persistence.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class EditableEntity extends BaseEntity {

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public EditableEntity() {}

    public EditableEntity(Long id) {
        super(id);
    }

    protected void delete() {
        this.deletedAt = LocalDateTime.now();
    }

    protected boolean isDeleted() {
        return !Objects.isNull(this.deletedAt);
    }
}
