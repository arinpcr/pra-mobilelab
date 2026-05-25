package com.example.arinapps.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.Message.tutorial.TutorialMessageActivity
import com.example.arinapps.R
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
            title = "Message"

            setHasOptionsMenu(true)
        }

        // Terapkan Custom Adapter
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}