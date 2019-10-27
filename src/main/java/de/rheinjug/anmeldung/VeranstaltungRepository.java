package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.Veranstaltung;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VeranstaltungRepository extends CrudRepository<Veranstaltung, Long> {
    List<Veranstaltung> findAllByOrderByDatum();
}
