package com.tapcom.expensemanager.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.gipl.simpleapp.R
import com.gipl.simpleapp.Utility.Validation
import com.gipl.simpleapp.base.ViewModelFactory
import com.gipl.simpleapp.exceptions.ErrorFactory
import com.gipl.simpleapp.models.Response
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels { ViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel.mutableLiveData.observe(this, Observer {
            if (it != null) {
                processLogin(it)
            }
        })
    }

    private fun processLogin(it: Response) {
        when (it.status) {
            Response.STATUS.LOADING -> {
               // showLoading()
            }
            Response.STATUS.SUCCESS -> {
               // hideLoading()
                Navigation.findNavController(btn_login).navigate(R.id.action_loginfragment_to_home)

            }
            Response.STATUS.FAILED -> {
               // hideLoading()
                Toast.makeText(
                    requireContext(),
                    ErrorFactory.getErrorMsg(requireContext(), it.error as Exception),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        loginViewModel.mutableLiveData.postValue(null)
    }

    /*private fun showLoading() {
        progress_login.visibility = View.VISIBLE
        til_email_id.visibility = View.GONE
        til_password.visibility = View.GONE
        btn_login.visibility = View.GONE
    }

    private fun hideLoading() {
        progress_login.visibility = View.GONE
        til_email_id.visibility = View.VISIBLE
        til_password.visibility = View.VISIBLE
        btn_login.visibility = View.VISIBLE
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_login.setOnClickListener {
            til_email_id.error = null
            til_password.error = null
            val email = et_email_id.text.toString()
            val password = et_password.text.toString()

            val emailError = Validation.validateEmailId(email)
            val passError = Validation.validatePassword(password)

            if (emailError != null || passError != null) {
                if (emailError != null)
                    til_email_id.error = emailError
                if (passError != null)
                    til_password.error = passError
                return@setOnClickListener
            }
            loginViewModel.login(email, password)

        }
    }

}