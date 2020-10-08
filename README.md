# Tutorial APAP

## Authors

* **Kevin Asyraf Putra Priyatna** - *1806191660* - *B*

## Tutorial 1
### What I have learned today
Hari ini, saya mempelajari beberapa hal yang sangat baru untuk saya, yaitu membuat project Java dengan menggunakan Springboot Framework, mulai dari mengoperasikan repository untuk menyimpan projectnya dengan menggunakan GitHub, lalu mulai membuat project Java dengan Spring Boot framework dan menggunakan IntellijIDE untuk membuild dan menjalankan project tersebut. Saya juga belajar dengan alur Model View Controller yang diaplikasikan pada project perhitungan BMI ini. 
### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**  
Issue tracker merupakan fitur yang dapat melakukan tracking masalah-masalah yang ada, sehingga kita dapat dengan mudah mengetahui jika terdapat masalah yang mengalami perubahan seperti sudah diperbaiki ataupun adanya orang-orang yang mencoba untuk menyelesaikan masalah tersebut. Masalah yang dapat diselesaikan oleh Issue Tracker yaitu masalah bug pada program.  
  
**2. Apa perbedaan dari git merge dan git merge --squash?**   
Git merge akan menggabungkan dua branch menjadi satu dan commit yang terdapat pada branch yang melakukan merge akan diikutsertakan dalam merge tersebut sehingga akan tetap ada semuanya. Pada git merge --squash, commit yang terdapat pada branch yang melakukan merge request akan digabungkan seluruhnya menjadi hanya satu commit pada saat setelah merge. 
  
**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?**  
Keunggulan dari menggunakan Version Control System adalah dapat memudahkan pengembangan aplikasi karena kerja sama dengan orang lain atau programmer lain akan menjadi jauh lebih mudah jika dibandingkan dengan tidak menggunakan Version Control System. Selain itu, kita juga dapat melihat history dari program tersebut yang dapat berguna ketika suatu program diupdate mengalami masalah maka bisa kita revert ke versi yang sebelumnya.
### Spring
**4. Apa itu library & dependency?**  
Library merupakan suatu kumpulan package atau fungsi yang dapat digunakan untuk mengerjakan suatu task tertentu, seperti contohnya library Math pada Java yang isi dari librarynya berfungsi untuk mengolah operasi-operasi matematika.  
Dependancy merupakan ketergantungan dari suatu class terhadap class yang lainnya, seperti adanya method dalam suatu class yang akan mengoperasikan class lain, maka kedua class tersebut memiliki dependancy.
  
**5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**  
Kita menggunakan Maven karena untuk memudahkan dalam pengembangan project website dan juga untuk menyesuaikan tools yang digunakan dengan orang lain. Kesesuaian ini akan memudahkan antara project manager dan juga sang programmer dalam mengelola aplikasi. Salah satu alternatif dari Maven adalah Gradle.
  
**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?**  
Spring bisa digunakan juga untuk pengembangan aplikasi dan juga untuk pengelolaan data.
  
**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?**  
@RequestParam berfungsi untuk mendapatkan parameter dari URI, sedangkan @PathVariable berfungsi untuk mengekstrak value dari URI.  
Kita sebaiknya menggunakan @RequestParam saat web tersebut merupakan web konvensional karena data diteruskan melalui URI, sedangkan @PathVariable sebaiknya digunakan untuk web yang menggunakan data dari API.
  
### What I did not understand
- [ ] Apa yang sebenarnya terjadi di belakang layar pada framework Spring Boot?
- [ ] Apa yang sebenarnya terjadi di belakang layar pada Maven?
- [ ] Apa yang sebenarnya terjadi di belakang layar pada method method seperti @RequestParam dan @PathVariable?  
  
  
## Tutorial 2
### What I have learned today  
Hari ini, saya sudah belajar lebih dalam mengenai prinsip MVC pada spring boot dengan membuat aplikasi hai dokter. Saya belajar menggunakan method method seperti request mapping dan path variable lebih dalam daripada minggu sebelumnya. Saya juga belajar mengenai kemungkinan-kemungkinan kesalahan yang terjadi pada Spring Boot karena saya mencoba menjalankan program ini dengan banyaknya trial and error.
### Pertanyaan
**1.  Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
     http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom&catatan=Semangat
     Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**  
     Yang terjadi adalah munculnya halaman Whitelabel Error Page karena belum dibuatnya template html untuk add-resep yang direturn dari Controller saat menambahkan resep.  
       
**2.  Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan
      implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam
      konteks service dan controller yang telah kamu buat**  
      Anotasi @Autowired pada class Controller merupakan implementasi dari konsep Dependency Injection. Cara kerja @Autowired adalah dia akan melakukan auto dependancy injection terhadap class yang kita berikan @Autowired  
        
**3.  Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
      http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**  
      Akan muncul Whitelabel Error Page karena pada link tersebut tidak terdapat parameter untuk catatan, yang di mana pada Controller parameter catatan dan juga parameter yang lainnya untuk add resep merupakan parameter yang required, sehingga harus ada keempat parameter yaitu noPasien, namaDokter, namaPasien, dan catatan.  
        
**4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang
     harus diakses?**  
     Link yang harus diakses oleh Papa APAP adalah http://localhost:8080/resep/viewall untuk melihat semua resep yang tersedia, lalu bisa juga melihat detail pada resep tersebut dengan mencari nomor resepnya lalu membuka link http://localhost:8080/resep/view/no-resep/<noResep> yang di mana pasien Quanta memiliki nomor resep 1 sehingga link yang harus dibuka adalah http://localhost:8080/resep/view/no-resep/1  
       
**5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses
     http://localhost:8080/resep/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**  
     ![SS Pertanyaan No 5](https://ibb.co/N954S3L)   https://ibb.co/N954S3L
     ![SS Pertanyaan No 5](https://ibb.co/1Rqz4SL)   https://ibb.co/1Rqz4SL
     Yang akan ditampilkan adalah semua resep yang sudah dibuat di web, dalam kasus ini yang ditampilkan merupakan resep dengan nomor resep 1 yang sudah dibuat sebelumnya pada saat tutorial dan juga 1 resep lagi yaitu resep dengan nomor resep 2 yang sudah saya buat.  
       
 ### What I did not understand
 [ ] Apa yang sebenarnya terjadi di belakang layar pada method @Autowire?  
 [ ] Bagaimana cara mengimplementasikan automated error page pada Spring Boot?                         


