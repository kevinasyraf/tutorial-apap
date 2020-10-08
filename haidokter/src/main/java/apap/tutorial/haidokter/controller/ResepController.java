package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    //Routing URL yang diinginkan
    @RequestMapping("/resep/add")
    public String addResep(
            //Request Parameter yang ingin dibawa
            @RequestParam(value = "noResep", required = true) String noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model
            ){
        //Membuat objek ResepModel
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        //Memanggil service addResep
        resepService.addResep(resep);

        //Add variabel nomor resep ke 'nomorResep' untuk dirender pada thymeleaf
        model.addAttribute("nomorResep", noResep);

        //Return view template yang ingin digunakan
        return "add-resep";
    }

    @RequestMapping("/resep/viewall")
    public String listResep(Model model) {
        //Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();

        //Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
        model.addAttribute("listResep", listResep);

        //Return view template yang ingin digunakan
        return "viewall-resep";
    }

    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") String noResep,
            Model model) {

        //Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        //Add variabel ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        //Return view template yang ingin digunakan
        return "view-resep";
    }

    @RequestMapping(
            {"/resep/view/no-resep/{noResep}", "/resep/view/no-resep"}
            )
    public String viewByNoResep(
            @PathVariable("noResep") Optional<String> noResep,
            Model model) {

        if (!noResep.isPresent()) {
            return "error-view";
        }

        //Mendapatkan detail resep yang sesuai dengan nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep.get());

        if (resep == null) {
            return "error-view";
        }

        //Menambahkan resep yang diinginkan ke model untuk ditampilkan pada html melalui thymeleaf
        model.addAttribute("resep", resep);

        return "view-resep";
    }

    @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String updateCatatanByNoResep(
            @PathVariable(value = "noResep") Optional<String> noResep,
            @PathVariable(value = "catatan", required = true) String catatan,
            Model model) {

        if (!noResep.isPresent()) {
            return "error-update-catatan";
        }

        //Mendapatkan detail resep yang sesuai dengan nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep.get());

        if (resep == null) {
            return "error-update-catatan";
        }

        //Mengganti catatan resep yang sudah diambil sebelumnya dengan catatan yang baru
        resep.setCatatan(catatan);

        return "update-catatan";
    }

    @RequestMapping("/resep/delete/no-resep/{noResep}")
    public String deleteResep(
            @PathVariable(value = "noResep") Optional<String> noResep) {

        if (!noResep.isPresent()) {
            return "error-delete";
        }

        //Menghapus data sebuah resep berdasarkan nomor resep
        resepService.deleteResepByNomorResep(noResep.get());

        return "delete-resep";
    }

}
