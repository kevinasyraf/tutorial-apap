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

import java.util.Optional;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addResepFormPage(
            @PathVariable Long noResep,
            Model model
    ) {
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";
    }

    @PostMapping("/obat/add")
    private String addObatSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ) {
        obatService.addObat(obat);
        model.addAttribute("nama", obat.getNama());

        return "add-obat";
    }

    @GetMapping("/obat/change/{id}")
    private String changeResepFormPage(
            @PathVariable Long id,
            Model model
    ) {
        ObatModel obat = obatService.getObatById(id);
        model.addAttribute("obat", obat);
        model.addAttribute("listResep", resepService.getResepList());

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ) {
        ObatModel updatedObat = obatService.updateObat(obat);
        model.addAttribute("obat", updatedObat);

        return "update-obat";
    }

    @RequestMapping({"/obat/delete/{id}","/obat/delete"})
    public String deleteHotel (
            @PathVariable(value = "id", required = false) Optional<Long> id,
            Model model
    ) {

        if (id.isEmpty()) {
            model.addAttribute("status", "Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
            return "error";
        } else if (obatService.getObatById(id.get()) == null) {
            model.addAttribute("status", "Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
            return "error";
        }

        try {
            obatService.deleteObat(id.get());

            model.addAttribute("obat", id.get());
        } catch (Exception err) {
            model.addAttribute("status","Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
            return "error";
        }
        return "delete-obat";
    }
}
