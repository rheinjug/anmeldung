package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.VeranstaltungsAnmeldung;
import org.springframework.data.repository.CrudRepository;


public interface VeranstaltungsAnmeldungRepository extends CrudRepository<VeranstaltungsAnmeldung, Long> {

}
