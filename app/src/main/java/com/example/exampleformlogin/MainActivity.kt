package com.example.exampleformlogin

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.ButtonLogin)
        buttonLogin.setOnClickListener {
            val namaEditText = findViewById<EditText>(R.id.nama)
            val emailEditText = findViewById<EditText>(R.id.email)
            val jurusanEditText = findViewById<EditText>(R.id.jurusan)
            val semesterEditText = findViewById<EditText>(R.id.semester)

            val nama = namaEditText.text.toString()
            val email = emailEditText.text.toString()
            val jurusan = jurusanEditText.text.toString()
            val semester = semesterEditText.text.toString()

            if (isValidEmail(email) && isAllFieldsFilled(nama, email, jurusan, semester)) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("NAMA_KEY", nama)
                intent.putExtra("EMAIL_KEY", email)
                intent.putExtra("JURUSAN_KEY", jurusan)
                intent.putExtra("SEMESTER_KEY", semester)
                startActivity(intent)
            } else {
                if (!isValidEmail(email)) {
                    showInvalidEmailDialog()
                } else if (!isAllFieldsFilled(nama, email, jurusan, semester)) {
                    showFieldsEmptyDialog()
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isAllFieldsFilled(nama: String, email: String, jurusan: String, semester: String): Boolean {
        return nama.isNotEmpty() && email.isNotEmpty() && jurusan.isNotEmpty() && semester.isNotEmpty()
    }

    private fun showInvalidEmailDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Validasi Gagal")
        builder.setMessage("Email tidak sesuai dengan format yang benar.")
        builder.setPositiveButton("Tutup") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showFieldsEmptyDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Validasi Gagal")
        builder.setMessage("Mohon isi semua field dengan benar.")
        builder.setPositiveButton("Tutup") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
