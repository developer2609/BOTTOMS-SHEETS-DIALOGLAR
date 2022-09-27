package com.example.a18myhomework1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.media.TimedMetaData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a18myhomework1.databinding.ActivityMainBinding
import com.example.a18myhomework1.databinding.MyDialogViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


      binding.button1.setOnClickListener {
          val alertDialog=AlertDialog.Builder(this)

          alertDialog.setTitle("Ogahlantirish")
          alertDialog.setMessage("Rostan ham o'chirmoqchimisz ")

          alertDialog.setCancelable(false)


          alertDialog.setPositiveButton("ha",object:DialogInterface.OnClickListener{
              override fun onClick(dialog: DialogInterface?, which: Int) {
                  Toast.makeText(this@MainActivity, "ha", Toast.LENGTH_SHORT).show()
              }

          } )
        alertDialog.setNegativeButton("yo'q",object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity, "yo'q", Toast.LENGTH_SHORT).show()
            }
        })

          alertDialog.setNeutralButton("qaytish",object :DialogInterface.OnClickListener{
              override fun onClick(dialog: DialogInterface?, which: Int) {
                  Toast.makeText(this@MainActivity, "qaytildi", Toast.LENGTH_SHORT).show()
              }
          })
          alertDialog.show()

      }


        binding.button2.setOnClickListener {
          val alertDialog=AlertDialog.Builder(this,R.style.NewDialog).create()

            val myDialogViewBinding=MyDialogViewBinding.inflate(layoutInflater)
            myDialogViewBinding.btnPay.setOnClickListener {
                Toast.makeText(this, "to'lov", Toast.LENGTH_SHORT).show()
                alertDialog.cancel()

            }
            alertDialog.setView(myDialogViewBinding.root)
               alertDialog.show()
        }

        binding.button3.setOnClickListener {
            var blankFragment=BlankFragment()
            blankFragment.show(supportFragmentManager,blankFragment.toString())
        }

        binding.button4.setOnClickListener {
            val timePickerDialog=TimePickerDialog(
                this,
                object :TimePickerDialog.OnTimeSetListener{
                    override fun onTimeSet(view: TimePicker?, p1: Int, p2: Int) {
                        Toast.makeText(this@MainActivity, "$p1:$p2" , Toast.LENGTH_SHORT).show()
                    }
                },
                24,
                60,
                true

            )
            val date=Date()
            timePickerDialog.updateTime(date.hours,date.minutes)
            timePickerDialog.show()
        }


        binding.button5.setOnClickListener {
            val  datePickerDialog=DatePickerDialog(
                this,
                object :DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Toast.makeText(this@MainActivity, "$year.$month.$dayOfMonth", Toast.LENGTH_SHORT).show()
                    }
                },
            2022,
                7,
                30
            )
            datePickerDialog.show()

        }

        binding.button6.setOnClickListener {

            val bottomSheetDialog=BottomSheetDialog(this)
            val myDialogViewBinding=MyDialogViewBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(myDialogViewBinding.root)

            bottomSheetDialog.show()
        }

        binding.button7.setOnClickListener {
            val snackbar=Snackbar.make(it,"chiqish",Snackbar.LENGTH_SHORT)

            snackbar.setAction("click",object : View.OnClickListener{
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "bosildi", Toast.LENGTH_SHORT).show()
                }
            })
            snackbar.show()


        }

    }
}