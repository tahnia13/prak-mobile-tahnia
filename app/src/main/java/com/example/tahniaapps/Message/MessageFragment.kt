package com.example.tahniaapps.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tahniaapps.R
import com.example.tahniaapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // 🔥 GANTI URL dengan yang lebih stabil
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://cdn.pixabay.com/photo/2023/09/01/21/03/ai-generated-8227361_1280.jpg"),
        MessageModel("Budi", "Sudah makan?", "https://cdn.pixabay.com/photo/2023/06/25/17/07/ai-generated-8088132_1280.jpg"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://cdn.pixabay.com/photo/2023/09/18/13/21/ai-8259884_1280.jpg"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://cdn.pixabay.com/photo/2023/06/17/14/13/ai-generated-8070987_1280.jpg"),
        MessageModel("Eka", "Nice job kemarin!", "https://cdn.pixabay.com/photo/2023/10/03/13/10/ai-generated-8291447_1280.jpg"),
        MessageModel("Fajar", "Lagi ngapain?", "https://cdn.pixabay.com/photo/2023/10/28/10/42/ai-generated-8347435_1280.jpg"),
        MessageModel("Gita", "Boleh minta tolong?", "https://cdn.pixabay.com/photo/2024/01/15/12/45/ai-generated-8510433_1280.jpg"),
        MessageModel("Hana", "Lihat email ya!", "https://cdn.pixabay.com/photo/2023/11/28/14/03/ai-8416873_1280.jpg"),
        MessageModel("Irfan", "Oke noted", "https://cdn.pixabay.com/photo/2023/10/10/06/17/ai-generated-8305696_1280.jpg"),
        MessageModel("Joko", "Sampai jumpa besok", "https://cdn.pixabay.com/photo/2023/11/24/22/40/ai-generated-8409606_1280.jpg")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItem.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}