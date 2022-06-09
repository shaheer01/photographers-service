package com.photographers.dal.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Photographers")
@Configuration
@Getter
@Setter
//@Builder
public class Photographers {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private Long contact;

    @Column(columnDefinition = "ENUM('wedding','birthdays','wildlife','sports')", name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

}
