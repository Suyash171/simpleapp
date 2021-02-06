package com.gipl.simpleapp.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.gipl.simpleapp.R
import com.gipl.simpleapp.base.ViewModelFactory
import com.gipl.simpleapp.models.Response
import kotlinx.android.synthetic.main.fragment_splash_screen.*

class SplashScreenFragment : Fragment() {
    private val splashScreenViewModel: SplashScreenViewModel by viewModels { ViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenViewModel.mutableLiveData.observe(this, Observer { process(it) })
    }

    private fun process(it: Response) {
        when (it.status) {
            Response.STATUS.LOADING -> {
            }
            Response.STATUS.SUCCESS -> {
                Navigation.findNavController(iv_splash).navigate(R.id.action_splashScreenFragment_to_login_register)
            }
            Response.STATUS.FAILED -> {
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashScreenViewModel.checkPreviousLogin()
    }
}