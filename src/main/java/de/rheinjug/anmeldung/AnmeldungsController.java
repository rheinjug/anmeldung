package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.Formular;
import de.rheinjug.anmeldung.model.NewsletterAnmeldung;
import de.rheinjug.anmeldung.model.Veranstaltung;
import de.rheinjug.anmeldung.model.VeranstaltungsAnmeldung;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class AnmeldungsController {

    private VeranstaltungRepository veranstaltungen;
    private NewsletterAnmeldungRepository newsletter;
    private VeranstaltungsAnmeldungRepository anmeldungen;

    public AnmeldungsController(VeranstaltungRepository veranstaltungen, NewsletterAnmeldungRepository newsletter, VeranstaltungsAnmeldungRepository anmeldungen) {
        this.veranstaltungen = veranstaltungen;
        this.newsletter = newsletter;
        this.anmeldungen = anmeldungen;
    }

    @GetMapping("anmelden/{id}")
    public String anmeldeseite(@PathVariable("id") UUID link) {
        return "anmeldung";
    }

    @PostMapping("anmelden/{id}")
    public String anmeldeseite(@PathVariable("id") UUID link, Formular formular) {
        if (formular.isSubscribe()) {
            NewsletterAnmeldung newsletterAnmeldung = new NewsletterAnmeldung(formular.getMail());
            newsletter.save(newsletterAnmeldung);
        }
        VeranstaltungsAnmeldung veranstaltungsAnmeldung = new VeranstaltungsAnmeldung(link, formular.getName(), formular.getMail());
        anmeldungen.save(veranstaltungsAnmeldung);
        return "anmeldung";
    }

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("veranstaltungen", veranstaltungen.findAllByOrderByDatum());
        return "veranstaltungen";
    }

    @GetMapping("/create")
    public String veranstaltungAnlegen() {
        return "anlegenform";
    }

    @PostMapping("/create")
    public String veranstaltungAnlegen(String titel, String sprecher, String datum) {
        Veranstaltung veranstaltung = new Veranstaltung(titel, sprecher, LocalDate.parse(datum));
        veranstaltungen.save(veranstaltung);
        return "redirect:/";
    }


}
