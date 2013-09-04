package web;

import config.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.RandomService;

import javax.servlet.http.HttpSession;

/**
 * User: AKutuzov
 * Date: 8/7/13
 * Time: 12:30 PM
 */
@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired private RandomService randomService;

    @RequestMapping("/")
    public String info(HttpSession ses, Model model) {
        model.addAttribute("login_enabled", Features.LOGIN.isActive());
        model.addAttribute("random_enabled", Features.RANDOM.isActive());
        model.addAttribute("cached_enabled", Features.CACHED_RANDOM.isActive());
        model.addAttribute("disabled_enabled", Features.DISABLED.isActive());
        model.addAttribute("login", ses.getAttribute("login"));
        model.addAttribute("random", randomService.random());
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpSession ses, @RequestParam("login") String login, @RequestParam("password") String password) {
        ses.setAttribute("login", login);
        return "redirect:/";
    }
}
