package com.example.tahniaapps.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tahniaapps.R
import com.example.tahniaapps.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataList = listOf(
        "Kotlin",
        "Java",
        "Python",
        "C++",
        "JavaScript",
        "Dart",
        "Swift",
        "Go",
        "Ruby",
        "R",
        "PHP",
        "C#",
        "TypeScript",
        "Shell",
        "SQL",
        "Perl",
        "Rust",
        "Scala",
        "Haskell",
        "Lua",
        "Erlang",
        "Prolog",
        "Assembly",
        "Objective-C",
        "VBA"
    )

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa pemrograman sistem"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa untuk web"),
        mapOf("title" to "Dart", "desc" to "Bahasa untuk Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa untuk iOS modern"),
        mapOf("title" to "Go", "desc" to "Bahasa dari Google"),
        mapOf("title" to "Ruby", "desc" to "Bahasa yang elegan"),
        mapOf("title" to "R", "desc" to "Bahasa untuk statistik"),
        mapOf("title" to "PHP", "desc" to "Bahasa untuk backend web"),
        mapOf("title" to "C#", "desc" to "Bahasa dari Microsoft"),
        mapOf("title" to "TypeScript", "desc" to "JavaScript dengan tipe"),
        mapOf("title" to "Shell", "desc" to "Bahasa untuk terminal"),
        mapOf("title" to "SQL", "desc" to "Bahasa untuk database"),
        mapOf("title" to "Perl", "desc" to "Bahasa yang fleksibel"),
        mapOf("title" to "Rust", "desc" to "Bahasa yang aman dan cepat"),
        mapOf("title" to "Scala", "desc" to "Bahasa fungsional di JVM"),
        mapOf("title" to "Haskell", "desc" to "Bahasa fungsional murni"),
        mapOf("title" to "Lua", "desc" to "Bahasa untuk game"),
        mapOf("title" to "Erlang", "desc" to "Bahasa untuk concurrent"),
        mapOf("title" to "Prolog", "desc" to "Bahasa logika"),
        mapOf("title" to "Assembly", "desc" to "Bahasa tingkat rendah"),
        mapOf("title" to "Objective-C", "desc" to "Bahasa legacy iOS"),
        mapOf("title" to "VBA", "desc" to "Bahasa untuk Excel")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Toolbar */
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

        /* Definisikan adapter sebagai penghubung dataList dengan layout simple_list_item_2 */
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // Hubungkan listViewItems dengan adapter
        binding.listViewItems.adapter = adapter

        // Tambahkan aksi saat item di-list diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}