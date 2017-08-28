package PersonaManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HumanController {

    @PostMapping("/register")
    public String register(){
        return "return a string";
    }

    @PostMapping("/signin")
    public String signIn(){
        return "Returns a string";
    }

    @GetMapping("/signout")
    public String signOut(){
        return "return a string";
    }

    @GetMapping("/connect")
    public String connect(){
        return "return a string";
    }
}
