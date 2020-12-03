package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ResepController {
    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @Autowired
    private ObatService obatService;

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model) {
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());

        return "add-resep";
    }

    @GetMapping("/resep/change/{noResep}")
    private String changeResepFormPage(
            @PathVariable Long noResep,
            Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);

        return "form-update-resep";
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep);

        return "update-resep";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
            @RequestParam(value = "noResep") Long noResep,
            Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        List<ObatModel> listObat = resep.getListObat();

        model.addAttribute("resep", resep);
        model.addAttribute("listObat", listObat);

        return "view-resep";
    }

    @GetMapping("/resep/view/{noResep}")
    public String viewDetailResepByNoResep(
            @PathVariable(value = "noResep") Long noResep,
            Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        List<ObatModel> listObat = resep.getListObat();

        model.addAttribute("resep", resep);
        model.addAttribute("listObat", listObat);

        return "view-resep";
    }

    @GetMapping("/resep/viewall")
    public String viewAllResep(
            Model model
    ) {
        List<ResepModel> listResep = resepService.getResepList();

        model.addAttribute("listResep", listResep);

        return "viewall-resep";
    }

    @RequestMapping({"/resep/delete/{noResep}","/resep/delete"})
    public String deleteHotel (
            @PathVariable(value = "noResep", required = false) Optional<Long> noResep,
            Model model
    ) {

        try {
            resepService.deleteResepByNomorResep(noResep.get());

            model.addAttribute("noResep", noResep.get());
        } catch (Exception err) {
            model.addAttribute("status","Nomor resep tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
            return "error-1";
        }
        return "delete-resep";
    }

}
