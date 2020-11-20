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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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

    @PostMapping(value = "obat/delete")
    public String deleteMenuFormSubmit(@ModelAttribute ResepModel resep, Model model) {
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()) {
            obatService.deleteObat(obat.getId());
        }
        return "delete-obat";
    }

    @GetMapping("/obat/add-multiple/{noResep}")
    private String addMultipleResepFormPage(
            @PathVariable Long noResep,
            Model model
    ) {
        ObatModel obat = new ObatModel();
        List<ObatModel> listObat = new ArrayList<>();
        listObat.add(obat);
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        resep.setListObat(listObat);
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/", params = {"addRow"})
    private String addRowObatForm(
            @ModelAttribute ResepModel resep,
            Model model
    ) {
        if (resep.getListObat() == null || resep.getListObat().size() == 0) {
            resep.setListObat(new ArrayList<ObatModel>());
        }
        resep.getListObat().add(new ObatModel());
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/", params = {"deleteRow"})
    private String deleteRowObatForm(
            @ModelAttribute ResepModel resep,
            HttpServletRequest request,
            Model model
    ) {
        Integer row = Integer.valueOf(request.getParameter("deleteRow"));
        resep.getListObat().remove(row.intValue());
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/", params = {"save"})
        private String addMultipleObatFormSubmit(
                @ModelAttribute ResepModel resep,
                Model model
        ) {
            for (int i = 0; i < resep.getListObat().size(); i++) {
                resep.getListObat().get(i).setResepModel(resep);
                obatService.addObat(resep.getListObat().get(i));
            }

            model.addAttribute("count", resep.getListObat().size());
            return "add-multiple-obat";
        }



//    @RequestMapping({"/obat/delete/{id}","/obat/delete"})
//    public String deleteHotel (
//            @PathVariable(value = "id", required = false) Optional<Long> id,
//            Model model
//    ) {
//
//        if (id.isEmpty()) {
//            model.addAttribute("status", "Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
//            return "error-1";
//        } else if (obatService.getObatById(id.get()) == null) {
//            model.addAttribute("status", "Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
//            return "error-1";
//        }
//
//        try {
//            obatService.deleteObat(id.get());
//
//            model.addAttribute("obat", id.get());
//        } catch (Exception err) {
//            model.addAttribute("status","Obat tidak ada atau tidak ditemukan sehingga proses delete dibatalkan");
//            return "error-1";
//        }
//        return "delete-obat";
//    }
}
