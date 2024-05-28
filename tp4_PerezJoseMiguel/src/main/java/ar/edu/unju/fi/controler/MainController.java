package ar.edu.unju.fi.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud")
public class MainController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "index"; // (archivo HTML) a renderizar
    }


}

