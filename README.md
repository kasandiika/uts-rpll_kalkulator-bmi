<h2>Soal no 3</h2>
<p>Repositori ini berisi file-file yang digunakan untuk menjalankan program yang saya buat berdasarkan studi kasus kalkulator BMI.</p>
<h3>Deskripsi Umum Sistem</h3>
<p>Sistem yang dikembangkan adalah sebuah aplikasi web-based berskala kecil berupa Kalkulator Body Mass Index (BMI). Aplikasi ini dirancang untuk mendemonstrasikan implementasi Business Process Management (BPM) di dalam arsitektur J2EE modern menggunakan framework Spring Boot dan engine Camunda BPM (versi 7).</p>
<h3>Alur Arsitektur</h3>
<p>Layer 1: View (form-bmi.html) yang bertindak sebagai antarmuka (UI).</p>
<p>Layer 2: REST Controller (BmiController.java) yang berfungsi sebagai jembatan (API).</p>
<p>Layer 3: BPMN Engine (proses-bmi.bpmn) yang bertindak sebagai workflow.</p>
<p>Layer 4: Java Delegate (BmiWorker.java) Bertindak sebagai tempat eksekusi.</p>
