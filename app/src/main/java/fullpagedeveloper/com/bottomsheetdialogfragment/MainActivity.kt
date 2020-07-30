package fullpagedeveloper.com.bottomsheetdialogfragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_bottom_sheet_payment.*


class MainActivity : AppCompatActivity() {

    internal lateinit var checkk: CheckedTextView

    var viewBottomSheet: View? = null
    var dialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_Content_Detail.setOnClickListener {
//            val view = layoutInflater.inflate(R.layout.dialog_bottom_sheet, null)
//            val dialog = BottomSheetDialog(this)
//            dialog.setContentView(view)
//            dialog.show()
            inflate(R.layout.dialog_bottom_sheet, null, this)
        }

        editText_Select_Method.setOnClickListener {
            val ss = false
            viewBottomSheet = layoutInflater.inflate(R.layout.dialog_bottom_sheet_payment, null)
            dialog = BottomSheetDialog(this)
            dialog!!.setContentView(viewBottomSheet!!)

            gokilAja()

            dialog!!.show()

        }

        button_Pay.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }

    fun inflate(resource: Int, root: ViewGroup?, context: Context){
        val layoutInflate = layoutInflater.inflate(resource, root)
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(layoutInflate)
        dialog.show()
    }

    fun checkId(postion:Int){
        when(postion){
            1 -> "r"
            2 -> "e"
            3 -> "w"
            4 -> "q"
        }
    }

    private fun gokilAja() {
        val CTView = viewBottomSheet?.findViewById<CheckedTextView>(R.id.tick)
        if (CTView != null) {
            Log.d("TAG", "1")
            CTView.isChecked = true
            Log.d("TAG", "2")
            CTView.setCheckMarkDrawable(R.color.colorAccent)
            Log.d("TAG", "3")

            CTView.setOnClickListener {
                CTView.isChecked = !CTView.isChecked
                Log.d("TAG", "4")
                CTView.setCheckMarkDrawable(
                    if (CTView.isChecked) {
                        R.color.colorAccent

                    } else {
                        R.drawable.ic_checklis_select_bank
                    })
                Log.d("TAG", "5")

                Log.d("TAG", "6")
                val msgs = "Mandiri Virtual Account"
                editText_Select_Method.setText(msgs)
                val msg = "ahay" + " " + if (CTView.isChecked) { "check" } else { "ahay" }
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                dialog!!.dismiss()

            }
        }
    }

    fun saveData(){
       // val sharedPreferences = getSharedPreferences(Context.MODE_PRIVATE)
    }
}
