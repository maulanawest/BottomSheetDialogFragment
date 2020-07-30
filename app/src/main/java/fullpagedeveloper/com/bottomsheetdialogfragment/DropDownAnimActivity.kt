package fullpagedeveloper.com.bottomsheetdialogfragment

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_drop_down_anim.*

class DropDownAnimActivity : AppCompatActivity() {

    private var array = """
        |1. Login Mandiri Online dengan memasukkan username dan password
        |2. Pilih menu “pembayaran”
        |3. Pilih menu “Multipayment”
        |4. Masukan “nomor virtual account” dan “nominal” yang akan dibayarkan, lalu pilih lanjut
        |5. Setelah muncul tagihan, pilih konfirmasi
        |6. Masukan PIN atau kode token
        |7. Transaksi selesai, simpan bukti pembayaran Anda
        |8. Jangan gunakan fitur “simpan daftar transfer” untuk pembayaran melalui internet banking karena dapat menggangu proses pembayaran berikutnya
        |
        |Untuk menghapus daftar transfer tersimpan ikuti langkah berikut:
        |1. Login mandiri online
        |2. pilih menu pembayaran
        |3. pilih menu daftar pembayaran
        |4. pilih pada pembayaran yang tersimpan, lalu pilih menu untuk hapus
    """.trimMargin()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_down_anim)


        textView18.text = array

        var swich_number = 0
        textView_Lorem.setOnClickListener {
            if (swich_number == 0) {
                textView18.visibility = View.VISIBLE
                playAnimation(R.drawable.avd_arrow_1)
                fadeIn()
                swich_number++

            } else if (swich_number == 1) {
                textView18.visibility = View.GONE
                playAnimation(R.drawable.avd_arrow_2)
                fadeOut()
                swich_number--
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun playAnimation(resourceId: Int){
        textView_Lorem.setImageResource(resourceId)
        val drawable = textView_Lorem.drawable

        if (drawable is AnimatedVectorDrawable){
            drawable.start()
        } else if (drawable is AnimatedVectorDrawableCompat){
            drawable.start()
        }

    }

    fun fadeIn(){
        val fadeIn = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)
        textView18.animation = fadeIn
    }

    fun fadeOut(){
        val fadeOut = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_out)
        textView18.animation = fadeOut
    }

}