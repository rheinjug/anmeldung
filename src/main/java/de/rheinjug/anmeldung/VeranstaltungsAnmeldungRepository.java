package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.VeranstaltungsAnmeldung;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface VeranstaltungsAnmeldungRepository extends CrudRepository<VeranstaltungsAnmeldung, Long> {
    List<VeranstaltungsAnmeldung> findAllNameByNameIsNotNullAndVeranstaltung(UUID veranstaltung);
}
