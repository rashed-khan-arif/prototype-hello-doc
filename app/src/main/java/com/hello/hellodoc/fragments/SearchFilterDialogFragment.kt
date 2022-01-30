package com.hello.hellodoc.fragments

import android.media.Image
import androidx.fragment.app.DialogFragment

import android.os.Bundle

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.hello.hellodoc.R


class SearchFilterDialogFragment(var callbackListener: () -> Unit) : DialogFragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        root = inflater.inflate(R.layout.layout_full_screen_dialog, container, false)
        val button = root.findViewById<Button>(R.id.button)
        val closeModal = root.findViewById<ImageView>(R.id.close_modal)
        button.setOnClickListener {
            callbackListener()
            dismiss()
        }
        closeModal.setOnClickListener {
            dismiss()
        }
        return root
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}