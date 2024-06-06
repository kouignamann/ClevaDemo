package demo.cleva.web.controller;

import demo.cleva.core.Aventure;
import demo.cleva.web.dto.PositionDto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("aventure")
public class AventureController {

    private final Aventure uneAventure;

    public AventureController() throws IOException {
        this.uneAventure = new Aventure();
    }

    @PostMapping("position")
    public String setNewPosition(@RequestBody PositionDto position) {
        this.uneAventure.setPositionAventurier(position.x, position.y);
        return uneAventure.getAventurier().printPosition();
    }

    @GetMapping("carte")
    public String deplacer() {
        return uneAventure.printCarte();
    }

    @PostMapping("deplacer")
    public String deplacer(@RequestBody String deplacement) {
        uneAventure.deplacerAventurier(deplacement);
        return uneAventure.getAventurier().printPosition();
    }

    @GetMapping("textCleva1")
    public String getTestCleva1() {
        this.uneAventure.setPositionAventurier(3,0);
        uneAventure.deplacerAventurier("SSSSEEEEEENN");
        return uneAventure.getAventurier().printPosition();
    }

    @GetMapping("textCleva2")
    public String getTestCleva2() {
        this.uneAventure.setPositionAventurier(6, 9);
        uneAventure.deplacerAventurier("OONOOOSSO");
        return uneAventure.getAventurier().printPosition();
    }
}
