package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        if (userService.passwordRequirementFulfilled(user.getPassword())) {
            userService.addUser(user);
        } else {
            model.addAttribute("messagePasswordRequirement", "Password harus mengandung angka dan huruf serta minimal memiliki 8 karakter");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePassword(@ModelAttribute UserModel user, String oldPassword, String newPassword, String confirmationPassword, Model model) {
        UserModel updatedUser = userService.getByUsername(user.getUsername());
        if (userService.passwordMatch(oldPassword, updatedUser.getPassword())) {
            if (newPassword.equals(confirmationPassword)) {
                if (userService.passwordRequirementFulfilled(newPassword)) {
                    updatedUser.setPassword(newPassword);
                    userService.addUser(updatedUser);
                    model.addAttribute("message", "Password berhasil diubah");
                } else {
                    model.addAttribute("messagePasswordRequirement", "Password harus mengandung angka dan huruf serta minimal memiliki 8 karakter");
                }
            } else {
                model.addAttribute("message", "Password baru tidak cocok dengan konfirmasi password baru tidak cocok");
            }
        } else {
            model.addAttribute("message", "Password lama salah");
        }
        return "home";
    }
}
