package de.rheinjug.anmeldung.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Veranstaltung {

    @Id
    @GeneratedValue
    private Long id;
    private UUID link;
    private String titel;
    private String sprecher;
    private LocalDate datum;

    public Veranstaltung(String titel, String sprecher, LocalDate datum) {
        this.titel = titel;
        this.sprecher = sprecher;
        this.datum = datum;
        this.link = UUID.randomUUID();
    }
}
