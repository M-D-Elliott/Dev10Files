package com.sg.llamaparty.controllers;

import com.sg.llamaparty.objects.RSVP;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PartyController {

    List<RSVP> rsvps = new ArrayList<>();

    public PartyController() {
        RSVP rsvp1 = new RSVP("Johnny", 3, true);
        rsvps.add(rsvp1);
        RSVP rsvp2 = new RSVP("Todd", 10, true);
        rsvps.add(rsvp2);
        RSVP rsvp3 = new RSVP("Bobby", 0, true);
        rsvps.add(rsvp3);
        RSVP rsvp4 = new RSVP("Phyllis", 3, false);
        rsvps.add(rsvp4);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("rsvps", rsvps);
        return "home";
    }

    @GetMapping("/addRSVP")
    public String displayAddRSVP() {
        return "rsvps/add";
    }

    @GetMapping("/deny")
    public String deny() {
        return "deny";
    }

    @GetMapping("/confirm")
    public String confirm(Model model) {
        model.addAttribute("totalLlamas", getTotalLlamas());
        model.addAttribute("rsvps", rsvps);
        return "confirm";
    }

    @PostMapping("/addRSVP")
    public String addRSVP(Model model, RSVP rsvp) {
        rsvps.add(rsvp);
        if (rsvp.isAttending() == false) {
            return "redirect:/deny";
        } else {
            return "redirect:/confirm";
        }
    }

    // helper
    private int getTotalLlamas() {
        int total = 0;
        for (RSVP rsvp : rsvps) {
            if (rsvp.isAttending()) {
                total += rsvp.getLlamas();
            }
        }
        return total;
    }
}
