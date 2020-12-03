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
 - [ ] Apa yang sebenarnya terjadi di belakang layar pada method @Autowire?  
 - [ ] Bagaimana cara mengimplementasikan automated error page pada Spring Boot?     
   
     
     
 ## Tutorial 3
 ### What I have learned today  
 Hari ini, saya sudah belajar mengenai repository pada spring boot dan juga penggunaan database yang dapat terintegrasi langsung dalam aplikasi spring boot.
 ### Pertanyaan
 **1.  Pada class ResepDb, terdapat method findByNoResep, apakah kegunaan dari method tersebut?**  
      Method findByNoResep pada class ResepDB adalah untuk mencari model resep berdasarkan nomor resepnya, yang di mana nomor resep merupakan id dalam database resep  
        
 **2.  Pada class ResepController, jelaskan perbedaan method addResepFormPage dan addResepSubmit**  
       addResepFormPage digunakan untuk mengarahkan ke page form add resep, sehingga pada method tersebut tidak menerima input apapun dan hanya membuat objek resep model baru untuk diisi datanya. Pada method addResepSubmit, data-data dari form yang sudah diisi akan dimasukkan pada database melalui service lalu akan memindahkan tampilan ke page berhasil add.  
         
 **3.  Jelaskan kegunaan dari JPA Repository!**  
       JPA Repository merupakan fitur dari Java Persistence API yang dapat membuat object pada java dengan database relasional terintegrasi, hal tersebut sangat berguna untuk modifikasi database seperti CRUD karena kita tidak perlu lagi membuat method method tersendiri.   
         
 **4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat?**  
      Relasi antara ResepModel dan ObatModel dibuat di kode bagian ResepModel.java line:32 dan ObatModel.java line:32-24. Relasi dari ResepModel dan ObatModel tersebut dibuat dengan skema one to many. ResepModel tersambung dengan ObatModel dengan anotasi @OneToMany dan ObatModel menggunakan @ManyToOne yang sudah disediakan oleh JPA Repository yang akan dimapping secara otomatis.
        
 **5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!**  
      FetchType merupakan berbagai cara fetching data atau mengambil data dari database. FetchType.LAZY berfungsi untuk memberitahu persistence provider agar data difetch secara "malas" saat pertama kali diakses, hal tersebut berguna ketika kita tidak butuh field terkait setiap data diambil, tetapi akan diambil nanti menggunakan getter. FetchType.EAGER berfungsi untuk memberitahu persistence provider agar data difetch secara "bersemangat", hal tersebut berguna ketika kita ingin mengambil field suatu data setiap data itu diambil.  
      CascadeType.ALL berguna untuk persistence menyediakan seluruh operasi cascade (PERSIST, REMOVE, REFRESH, MERGE, DETACH) ke entitas yang terhubung.    
        
  ### What I did not understand
  - [ ] Apa yang sebenarnya terjadi di belakang layar pada method JPA Repository?  
  - [ ] Bagaimana cara mengimplementasikan automated error page pada Spring Boot?    
  
## Tutorial 4
### What I have learned today  
   Saya sudah belajar Presentation Layer pada Spring Boot, seperti fragment, error handling, iteration pada html, dan lain-lain
   ### Pertanyaan
   **1.  Jelaskan perbedaan th:include dan th:replace**  
        th:include berfungsi untuk memasukkan atribut dari fragment ke dalam tag terkait, sedangkan th:replace berfungsi untuk menggantikan seluruh atribut pada tag dengan fragment
          
   **2.  Jelaskan apa fungsi dari th:object**  
         th:object berfungsi untuk mendefine objek yang digunakan pada data form  
           
   **3.  Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**  
         $ digunakan untuk mengakses variabel dari controller, sedangkan * digunakan untuk mengakses atribut dari objek yang digunakan dengan $   
           
   **4. Bagaimana kamu menyelesaikan latihan nomor 3**  
        Saya menggunakan fitur Flexible Layouts pada Thymeleaf, dengan cara merender bagian navbar dengan menggunakan variabel atau data lain, yaitu data dari tag title dengan menggunakan perintah fragment :: navbar(~{::title}). Title dari page diinclude pada bagian span untuk bagian paling kanan pada fragment.html  
      
          
### What I did not understand
- [ ] Apa yang sebenarnya terjadi di belakang layar pada method method untuk Presentation Layer?
  
    
## Tutorial 5
### What I have learned today  
   Saya sudah belajar REST API dan juga penggunaan postman untuk pengetesannya.
   ### Pertanyaan
   **1.  Apa itu Postman? Apa kegunaannya?**  
        Postman merupakan aplikasi untuk melakukan pengetesan terhadap API yang sudah dibuat. Postman dapat melakukan fungsi-fungsi request HTML dengan lebih mudah dan simpel, seperti POST dan GET, sehingga sering digunakan untuk mengetes fungsi API.
          
   **2.  Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.**  
         @JsonIgnoreProperties berfungsi untuk mencegah field tertentu untuk diserialize atau di deserialize. @JsonProperty berguna untuk melakukan mapping dari JSON property ke field di Java. 
           
   **3.  Apa kegunaan atribut WebClient?**  
         Atribut WebClient digunakan untuk menyimpan objek-objek yang yang akan digunakan pada client seperti URI.   
           
   **4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**  
        ResponseEntity merupakan objek yang merepresentasikan seluruh HTTP Response seperti status code, headers, dan body yang digunakan untuk mengkonfigurasi HTTP response. BindingResult adalah objek yang digunakan salah satunya untuk memvalidasi method validation dalam controller. 
      
          
### What I did not understand
- [ ] Apa yang sebenarnya terjadi di belakang layar pada Web Client?  
  
    
## Tutorial 6
### What I have learned today  
   Saya sudah belajar bagaimana cara mengaplikasikan aspek security pada Spring Boot seperti autentikasi dan otorisasi.
   ### Pertanyaan
   **1.  Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda
         buat) konsep tersebut diimplementasi?**  
        Otentikasi merupakan proses dari mengizinkan atau verifikasi user seperti dengan menggunakan username dan password, sedangkan otorisasi merupakan proses pemberian izin user dalam mengakses sesuatu sesuai dengan status user tersebut, seperti user yang tidak bisa melihat resep dan hanya apoteker yang hanya bisa melihat resep. Otentikasi diimplementasi pada bagian fitur login dengan menggunakan username dan password yang di mana username dan password tersebut akan dicek apakah terdapat pada database User atau tidak. Jika ada pada database, maka sistem akan memverifikasi user dan mengizinkan user untuk login, sedangkan jika username dan password tidak ada pada database, maka user tidak akan diverifikasi oleh sistem dan user tidak bisa login dan mengakses sistem. Otorisasi diimplementasikan pada bagian fitur view all resep yang hanya dibolehkan untuk role APOTEKER dan role yang lain tidak bisa melakukan view all resep.
          
   **2.  Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!**  
         BCryptPasswordEncoder merupakan suatu objek pada Java yang merupakan implementasi dari PasswordEncoder untuk melakukan fungsi hash dengan metode BCrypt. Cara kerjanya adalah objek tersebut memiliki salah satu method yaitu encode() yang menerima input suatu string dan string tersebut akan dilakukan hash atau encode dengan menggunakan metode BCrypt.
           
   **3.  Jelaskan secara singkat apa itu UUID beserta penggunaannya!**  
         UUID adalah Universally Unique Identifier yang merupakan angka 128-bit yang berarti suatu angka yang berkisar dari 0 sampai dengan 2^128 yang digunakan untuk mengidentifikasikan sesuatu secara unik karena kemungkinan adanya dua UUID yang sama sangatlah kecil karena range UUID yang sangat besar.  
           
   **4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah
        memiliki class UserServiceImpl.java?**  
        Class UserDetailsServiceImpl.java berguna untuk mengimplementasi UserDetailsService yang memiliki beberapa method yang berguna untuk mengambil data terkait user seperti loadUserByUsername. Class tersebut harus tetap ada karena fungsinya berbeda dengan UserServiceImpl yang di mana fungsi dari UserServiceImpl adalah untuk mengelola data user, bukan mengambil data.
      
          
### What I did not understand
- [ ] Apa yang sebenarnya terjadi di belakang layar pada User Details Service?                                              


