package com.papps.bottomsheetcalendar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var datePicker: DatePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bottom.setOnClickListener {
            showDialogCalendar()
        }
    }
    private fun showDialogCalendar(){
        val viewDialog = layoutInflater.inflate(R.layout.bottom_sheet_calendar, null)
        val dialog = BottomSheetDialog(this)
        dialog.setOnShowListener {
            val bottomSheetDialogFragment = dialog.findViewById<View>(R.id.design_bottom_sheet)
            val behavior = bottomSheetDialogFragment?.let { BottomSheetBehavior.from(it) }
            behavior!!.state = BottomSheetBehavior.STATE_EXPANDED
        }
        datePicker = viewDialog.findViewById<DatePicker>(R.id.datePickerCalendar)
        val btnConfirm = viewDialog.findViewById<Button>(R.id.btnConfirm)
        btnConfirm.setOnClickListener {
            val day: Int = datePicker.dayOfMonth
            val month: Int = datePicker.month + 1
            val year: Int = datePicker.year
            Log.d("cuack","Date: $day - $month - $year")
            tv_result.text = "Date: $day - $month - $year"
            dialog.dismiss()
        }
        dialog.setContentView(viewDialog)
        dialog.show()
    }

}
