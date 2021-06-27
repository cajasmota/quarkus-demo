package org.acme.books.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
@Entity
@Table(name="book")
public class Book  extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String name;
    private Long pages;

}
