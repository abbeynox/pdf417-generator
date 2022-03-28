package ch.bbw.pdf417generator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
    CodeGenerator generator = new CodeGenerator();

    @GetMapping("/")
    public String startPage(Model model){
        model.addAttribute("ticketModel", new TicketModel());
        return "startpage";
    }
    @GetMapping("/flightticket")
    public String ticketPage() {
        return "flightticket";
    }
    @PostMapping("/generate")
    public String ticketSubmit(@ModelAttribute TicketModel TicketModel, Model model){
        model.addAttribute("ticketModel", TicketModel);
        System.out.println("In der To String Methode wurde folgendes gespeichert: " + TicketModel.toString());
        //generator.generateCode(TicketModel.toString());
        return "flightticket";
    }
}
