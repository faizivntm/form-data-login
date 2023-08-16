package com.example.exampleformlogin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val nama = intent.getStringExtra("NAMA_KEY")
        val email = intent.getStringExtra("EMAIL_KEY")
        val jurusan = intent.getStringExtra("JURUSAN_KEY")
        val semester = intent.getStringExtra("SEMESTER_KEY")

        // Tampilkan data pada TextView atau komponen lain di layout DetailActivity
        val detailTextView = findViewById<TextView>(R.id.detailTextView)
        val detailText = "Nama: $nama\nEmail: $email\nJurusan: $jurusan\nSemester: $semester"
        detailTextView.text = detailText
    }
}
