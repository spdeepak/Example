package com.github.spdeepak.multipledb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@NoArgsConstructor
public class Dummy implements Serializable {

    private Date created;
    private String description;

    public Dummy(String description) {
        this.created = new Date();
        this.description = description;
    }
}
