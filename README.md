<h2>Soal no 3</h2>
<p>Repositori ini berisi file-file yang digunakan untuk menjalankan program yang saya buat berdasarkan studi kasus kalkulator BMI.</p>
<h3>Deskripsi Umum Sistem</h3>
<p>Sistem yang dikembangkan adalah sebuah aplikasi web-based berskala kecil berupa Kalkulator Body Mass Index (BMI). Aplikasi ini dirancang untuk mendemonstrasikan implementasi Business Process Management (BPM) di dalam arsitektur J2EE modern menggunakan framework Spring Boot dan engine Camunda BPM (versi 7).</p>
<h3>Alur Arsitektur</h3>
<p>Layer 1: View (form-bmi.html) yang bertindak sebagai antarmuka (UI).</p>
<p>Layer 2: REST Controller (BmiController.java) yang berfungsi sebagai API.</p>
<p>Layer 3: BPMN Engine (proses-bmi.bpmn) yang bertindak sebagai workflow.</p>
<p>Layer 4: Java Delegate (BmiWorker.java) yang bertindak sebagai alat eksekusi.</p>
<h3>Tampilan Web</h3>
<img width="794" height="820" alt="Cuplikan layar 2026-10-13 132843" src="https://github.com/user-attachments/assets/0006a9e7-3f14-40b9-b527-d74306c029d4" />
