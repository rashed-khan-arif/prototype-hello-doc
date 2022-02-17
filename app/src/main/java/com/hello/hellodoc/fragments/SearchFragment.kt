package com.hello.hellodoc.fragments

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.hello.hellodoc.CallingActivity
import com.hello.hellodoc.DoctorActivity
import com.hello.hellodoc.DoctorAdapter
import com.hello.hellodoc.R
import com.hello.hellodoc.databinding.FragmentSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        setupDoctorList()

        binding.root.setOnClickListener {
            hideKeyboard()
            binding.searchText.clearFocus()
        }

        binding.ivFilter.setOnClickListener {
            showDialog()
        }

        return binding.root
    }


    private fun setupDoctorList() {
        val list = arrayListOf(
            "Dr. Sayma Shahadat",
            "Dr. Md. Rafiqul Islam",
            "Dr. Debraj Malakar",
            "Dr. M. A. Mannan",
            "Dr. Ujjal Mitra",
            "Dr. Mir Abeed Rahman",
            "Prof. Dr. Shyamal Debnath",
            "Dr. Mir Rasekh Alam Ovi"
        )

        val rcv = binding.rcvDoctors
        rcv.itemAnimator = DefaultItemAnimator()
        rcv.setHasFixedSize(true)
        rcv.layoutManager = LinearLayoutManager(activity)

        val adapter = DoctorAdapter(list) {
            showItemDialog()
        }
        rcv.adapter = adapter

    }

    private fun showItemDialog() {
        activity?.let {
            val dialog = Dialog(it)
            val content = LayoutInflater.from(it).inflate(R.layout.doctor_dialog, null)
            dialog.setContentView(content)
            dialog.show()

            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation

            val profile = content?.findViewById<Button>(R.id.profile)
            val call = content?.findViewById<Button>(R.id.call_now)
            call?.setOnClickListener {
                startActivity(Intent(activity, CallingActivity::class.java))
            }

            profile?.setOnClickListener {
                startActivity(Intent(activity, DoctorActivity::class.java))
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun showDialog() {
        val dialogFragment = SearchFilterDialogFragment {
            binding.searchText.clearFocus()
        }
        dialogFragment.show(childFragmentManager, "signature")
    }

    fun hideKeyboard() {
        val view = activity?.currentFocus
        if (view != null) {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}