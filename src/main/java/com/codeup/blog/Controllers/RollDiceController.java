package com.codeup.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {
    private double diceRoll;

    @GetMapping ("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping ("/roll-dice/{number}")
    public String rollDice(@PathVariable double number, Model model) {
        model.addAttribute("number", number);
        diceRoll = Math.floor(Math.random() * 6) + 1;
        model.addAttribute("diceRoll", diceRoll);
        return "dice-results";
    }
}
