package fullpagedeveloper.com.bottomsheetdialogfragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_Content_Detail.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        button_Pay.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }

}
