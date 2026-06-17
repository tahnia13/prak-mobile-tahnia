package com.example.tahniaapps.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tahniaapps.AuthActivity
import com.example.tahniaapps.Data.api.PhotoApiClient
import com.example.tahniaapps.Home.Pertemuan_10.TenthActivity
import com.example.tahniaapps.Home.pertemuan_13.ThirteenthActivity
import com.example.tahniaapps.Home.pertemuan_3.ThirdActivity
import com.example.tahniaapps.Home.pertemuan_4.FourthActivity
import com.example.tahniaapps.Home.pertemuan_7.SeventhActivity
import com.example.tahniaapps.Home.pertemuan9.NinthActivity
import com.example.tahniaapps.Home.photo.PhotoAdapter
import com.example.tahniaapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Panggil fungsi loadPhoto saat view dibuat
        loadPhoto()

        binding.btntoFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }

        binding.btnToNinth.setOnClickListener {
            val intent = Intent(activity, NinthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToTenth.setOnClickListener {
            val intent = Intent(activity, TenthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Pertemuan 13
        binding.btnToThirteenth.setOnClickListener {
            val intent = Intent(activity, ThirteenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val sharedPref = requireActivity().getSharedPreferences("user_pref", android.content.Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", false)
                    editor.apply()

                    dialog.dismiss()
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            } catch (_: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
