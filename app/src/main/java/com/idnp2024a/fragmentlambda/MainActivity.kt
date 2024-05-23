package com.idnp2024a.fragmentlambda

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var txtMensaje:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtMensaje = findViewById<TextView>(R.id.txtMensaje)

        // val blankFragment=BlankFragment.newInstance(response)
        val registerFragment = RegisterFragment.newInstance { user ->
            displayUserInfo(user)
        }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout,registerFragment)
        }
    }

    private fun displayUserInfo(user: User) {
        txtMensaje.text = """
            First Name: ${user.firstName}
            Last Name: ${user.lastName}
            Email: ${user.email}
            Phone: ${user.phone}
        """.trimIndent()
    }

/*    val response:(String)->Unit={mensaje ->

        txtMensaje.text=mensaje


    }*/
}