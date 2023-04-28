package com.example.mvpkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mvpkotlin.presenter.MainPresenter
import com.example.mvpkotlin.view.MainView
/*Instrucciones
  1-  se leen el dato   atraves del TEXTINPUT , TEXTVIEW BUTTON
  2-  btn se envia el numero al presentador 
  3-  el modelo se encarga de duplicar el numero
  4-  El presenntador se encarga de traer la respuesta de dicho duplicacion
* */
class MainActivity : AppCompatActivity(),MainView {
    private lateinit var numberEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView

    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberEditText = findViewById(R.id.numberEditText)
        submitButton = findViewById(R.id.submitButton)
        resultTextView = findViewById(R.id.resultTextView)

        presenter = MainPresenter(this)

        submitButton.setOnClickListener {
            val number = numberEditText.text.toString().toInt()
            presenter.calculateResult(number)
        }
    }

    override fun showResult(result: Int) {
        resultTextView.text="Result: $result"
    }
}
