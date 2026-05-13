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

    private val messageList = listOf(
        MessageModel(senderName = "Alya", messageText = "Halo! Apa kabar?", avatarUrl = "https://avatar.iran.liara.run/public/1"),
        MessageModel(senderName = "Budi", messageText = "Sudah makan?", avatarUrl = "https://avatar.iran.liara.run/public/2"),
        MessageModel(senderName = "Citra", messageText = "Jangan lupa tugasnya ya!", avatarUrl = "https://avatar.iran.liara.run/public/3"),
        MessageModel(senderName = "Dika", messageText = "Besok kita rapat jam 9", avatarUrl = "https://avatar.iran.liara.run/public/4"),
        MessageModel(senderName = "Eka", messageText = "Nice job kemarin!", avatarUrl = "https://avatar.iran.liara.run/public/5"),
        MessageModel(senderName = "Fajar", messageText = "Lagi ngapain?", avatarUrl = "https://avatar.iran.liara.run/public/6"),
        MessageModel(senderName = "Gita", messageText = "Boleh minta tolong?", avatarUrl = "https://avatar.iran.liara.run/public/7"),
        MessageModel(senderName = "Hana", messageText = "Lihat email ya!", avatarUrl = "https://avatar.iran.liara.run/public/8"),
        MessageModel(senderName = "Irfan", messageText = "Oke noted", avatarUrl = "https://avatar.iran.liara.run/public/9"),
        MessageModel(senderName = "Joko", messageText = "Sampai jumpa besok", avatarUrl = "https://avatar.iran.liara.run/public/10")
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