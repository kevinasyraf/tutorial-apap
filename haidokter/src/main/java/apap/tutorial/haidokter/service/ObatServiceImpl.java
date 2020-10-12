package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObatServiceImpl implements ObatService {
    @Autowired
    ObatDb obatDb;

    @Override
    public void addObat(ObatModel obat) {
        obatDb.save(obat);
    }

    @Override
    public ObatModel getObatById(Long id) {
        return obatDb.findById(id).get();
    }

    @Override
    public ObatModel updateObat(ObatModel obat) {
        ObatModel targetObat = obatDb.findById(obat.getId()).get();

        targetObat.setNama(obat.getNama());
        targetObat.setBentuk(obat.getBentuk());
        targetObat.setKuantitas(obat.getKuantitas());
        targetObat.setResepModel(obat.getResepModel());
        obatDb.save(targetObat);

        return targetObat;
    }

    @Override
    public void deleteObat(Long id) {
        obatDb.deleteById(id);
    }
}
