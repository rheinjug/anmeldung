package de.rheinjug.anmeldung.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class NewsletterAnmeldung {
    @Id
    @GeneratedValue
    private Long id;
    private String mail;
    private boolean confirmed;

    public NewsletterAnmeldung(String mail) {
        this.mail = mail;
    }
}
