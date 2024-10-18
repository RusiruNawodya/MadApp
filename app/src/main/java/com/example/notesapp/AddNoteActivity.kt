package com.example.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityAddNoteBinding
class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)



        binding.SaveButton.setOnClickListener {

            val title = binding.titleEditText.text.toString().trim()
            val content = binding.contentEditText.text.toString().trim()


            if (validateInputs(title, content)) {

                val note = Note(0, title, content)
                db.insertNote(note)


                Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }


    private fun validateInputs(title: String, content: String): Boolean {
        return when {
            title.isEmpty() -> {

                binding.titleEditText.error = "Title is required"
                binding.titleEditText.requestFocus()
                false
            }
            else -> {

                true
            }
        }
    }
}
