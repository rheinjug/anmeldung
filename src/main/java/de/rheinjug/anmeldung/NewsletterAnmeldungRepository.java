package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.NewsletterAnmeldung;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsletterAnmeldungRepository extends CrudRepository<NewsletterAnmeldung, Long> {
    List<NewsletterAnmeldung> findAllByConfirmedIsTrue();
}
