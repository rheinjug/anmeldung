package de.rheinjug.anmeldung.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class VeranstaltungsAnmeldung {
    @Id
    @GeneratedValue
    private Long id;
    private UUID veranstaltung;
    private String name;
    private String mail;

    public VeranstaltungsAnmeldung(UUID veranstaltung, String name, String mail) {
        this.veranstaltung = veranstaltung;
        this.name = name;
        this.mail = mail;
    }
}
