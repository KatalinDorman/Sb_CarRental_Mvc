package homework.sb_carrental_mvc.controller;

import homework.sb_carrental_mvc.dto.AdminDto;
import homework.sb_carrental_mvc.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    @GetMapping("/admin")
    public String loadAdminPage(Model model) {

        AdminDto adminDto = adminService.getAdminDto();

        model.addAttribute("adminDto", adminDto);

        return "admin.html";
    }
}
