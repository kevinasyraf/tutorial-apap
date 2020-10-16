package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;

public interface ResepService {
    //Method untuk menambah resep
    void addResep(ResepModel resep);

    //Method untuk mendapatkan semua data Resep yang telah tersimpan
    List<ResepModel> getResepList();

    //Method untuk mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(Long noResep);

    //Method untuk menghapus data sebuah resep berdasarkan nomor resep
    void deleteResepByNomorResep(Long noResep);

    //Method untuk update resep
    ResepModel updateResep(ResepModel resepModel);
}
