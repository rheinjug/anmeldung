package de.rheinjug.anmeldung;

import de.rheinjug.anmeldung.model.Veranstaltung;
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

    public AnmeldungsController(VeranstaltungRepository veranstaltungen) {
        this.veranstaltungen = veranstaltungen;
    }

    @GetMapping("anmelden/{id}")
    public String anmeldeseite(@PathVariable("id") UUID id) {
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
