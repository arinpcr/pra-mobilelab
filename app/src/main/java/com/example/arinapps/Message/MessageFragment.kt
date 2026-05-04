package com.example.arinapps.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo Arin! Apa kabar?", "https://avatar.iran.liara.run/public/1"),
        MessageModel("Budi", "Tugas PFL udah kelar belom?", "https://avatar.iran.liara.run/public/2"),
        MessageModel("Citra", "Jangan lupa besok kita rapat jam 9", "https://avatar.iran.liara.run/public/3"),
        MessageModel("Dika", "Ajarin aku bikin layout dong!", "https://avatar.iran.liara.run/public/4"),
        MessageModel("Eka", "Nice job buat aplikasi Barbie-nya!", "https://avatar.iran.liara.run/public/5")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Kotak Masuk"
        }

        // Terapkan Custom Adapter
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}