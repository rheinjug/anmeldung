package de.rheinjug.anmeldung.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Formular {
    @Id
    @GeneratedValue
    private Long id;
    private String mail;
    private String name;
    private boolean subscribe;
}
