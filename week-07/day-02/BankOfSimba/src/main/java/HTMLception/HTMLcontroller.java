package HTMLception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLcontroller {

    @RequestMapping(value = "/htmlception")
    public String displayTag(Model model) {
        String str = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("tagtext", str);
        return "htmlception";
    }
}
