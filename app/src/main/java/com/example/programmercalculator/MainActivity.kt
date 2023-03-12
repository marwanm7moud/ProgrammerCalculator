package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.programmercalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numericalConverter: NumericalConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numericalConverter = NumericalConverter()

        binding.clear.setOnClickListener {clear()}
        binding.Decimal.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int
                ) {
                    if(binding.Decimal.isFocused &&binding.Decimal.text!=null) {
                        binding.Hexadecimal.setText(numericalConverter.toHexaDecimal(s.toString()))
                        binding.Octal.setText(numericalConverter.toOctal(s.toString()))
                        binding.Binary.setText(numericalConverter.toBinary(s.toString()))
                    }

                }

            })
        binding.Hexadecimal.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(binding.Hexadecimal.isFocused&&binding.Hexadecimal.text!=null) {
                        binding.Decimal.setText(numericalConverter.hexaToDecimal(s.toString()))
                        binding.Octal.setText(numericalConverter.toOctal(numericalConverter.hexaToDecimal(s.toString())))
                        binding.Binary.setText(numericalConverter.toBinary(numericalConverter.hexaToDecimal(s.toString())))
                    }
                }

            })
        binding.Octal.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (binding.Octal.isFocused&&binding.Octal.text!=null) {
                        binding.Hexadecimal.setText(numericalConverter.toHexaDecimal(numericalConverter.octalToDecimal(s.toString())))
                        binding.Decimal.setText(numericalConverter.octalToDecimal(s.toString()))
                        binding.Binary.setText(numericalConverter.toBinary(numericalConverter.octalToDecimal(s.toString())))
                    }
                }
            })
        binding.Binary.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (binding.Binary.isFocused&&binding.Binary.text!=null) {
                        binding.Hexadecimal.setText(numericalConverter.toHexaDecimal(numericalConverter.binaryToDecimal(s.toString())))
                        binding.Octal.setText(numericalConverter.toOctal(numericalConverter.binaryToDecimal(s.toString())))
                        binding.Decimal.setText(numericalConverter.binaryToDecimal(s.toString()))
                    }
                }

            })
    }
    private fun clear() {
        binding.Decimal.setText("")
        binding.Octal.setText("")
        binding.Binary.setText("")
        binding.Hexadecimal.setText("")
    }
}

class NumericalConverter {
    fun toHexaDecimal(number: String): String {
        if (number==""){
           return number
        }else {
            return try {
                number.toLong().toString(16)
            } catch (e: NumberFormatException) {
                "N/A"
            }
        }
    }

    fun toOctal(number: String): String {
        if (number==""){
            return number
        }else {
        return try {
            number.toLong().toString(8)
        }catch (e:NumberFormatException){
            "N/A"
        }
        }
    }

    fun toBinary(number: String): String {
        if (number==""){
            return number
        }else {
            return try {
                number.toLong().toString(2)
            } catch (e: NumberFormatException) {
                "N/A"
            }
        }
    }

    fun binaryToDecimal(number: String): String {
        if (number==""){
            return number
        }else {
            return try {
                number.toLong(2).toString()
            } catch (e: NumberFormatException) {
                "N/A"
            }
        }
    }

    fun hexaToDecimal(number: String): String {
        if (number==""){
            return number
        }else {
            return try {
                number.toLong(16).toString()
            } catch (e: NumberFormatException) {
                "N/A"
            }
        }
    }

    fun octalToDecimal(number: String): String {
        if (number==""){
            return number
        }else {
            return try {
                number.toLong(8).toString()
            } catch (e: NumberFormatException) {
                "N/A"
            }
        }
    }
}


