package fullpagedeveloper.com.bottomsheetdialogfragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_transaction.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class TransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        textView_Content_PaymentDetail.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_bottom_sheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        button_Check_Payment_Status.setOnClickListener {
            startActivity(Intent(this, WaitingForPaymentActivity::class.java))
        }

        //TimeCountDown()

        countDown()
    }

//    fun TimeCountDown() {
//
//        val countDownTimer = object : CountDownTimer(86400000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                //Convert milliseconds into hour,minute and seconds
//                val hms = String.format(
//                    "%02d Hour:%02d Minute:%02d Second",
//                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
//                    ),
//                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
//                    )
//                )
//                textView_TimeCountDown.setText(hms) //set text
//            }
//
//            override fun onFinish() {
//                textView_TimeCountDown.setText("TIME'S UP!!") //On finish change timer text
//            }
//        }.start()
//
//        val calendar: Calendar = Calendar.getInstance()
//        val simpleDateFormat = SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss a", Locale.getDefault())
//        val strDate: String = simpleDateFormat.format(calendar.getTime())
//
//        runOnUiThread { textView_Day.setText("(Before " + strDate + ")") }
//    }


    private fun countDown() {
        val countDownTimer = object : CountDownTimer(86400 * 1000, 1000) {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onTick(millisUntilFinished: Long) {
                //Convert milliseconds into hour,minute and seconds
                val hhmmss =
                    "<b>%02d</b>" + " Hours " + "<b> : </b>" + "<b>%02d</b>" + " Minute " + "<b> : </b>" + "<b>%02d</b>" + " Second"
                val hms = String.format(
                    hhmmss,
                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    ),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )
                textView_TimeCountDown.text = Html.fromHtml(hms, Html.FROM_HTML_MODE_LEGACY) //set text
                Log.d("pesan", hms)
            }

            override fun onFinish() {
                textView_TimeCountDown.setText("TIME'S UP!!") //On finish change timer text
            }
        }
        countDownTimer.start()

        dateTimeToday()
    }

    fun dateTimeToday() {
        val today = Calendar.getInstance()
        val thatday = 86400 * 1000 + today.timeInMillis
        Log.e("thatday", thatday.toString())
        Log.e("today", today.timeInMillis.toString())
        val fmt = Calendar.getInstance()
        fmt.timeInMillis = thatday
        val formatter = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
        Log.e("pesan", formatter.format(fmt.time))
        textView_Day.text = "(Before " + formatter.format(fmt.time) + ")"
    }
}