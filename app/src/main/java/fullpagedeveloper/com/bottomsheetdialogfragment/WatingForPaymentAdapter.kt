package fullpagedeveloper.com.bottomsheetdialogfragment

//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
//import org.jetbrains.anko.sdk25.coroutines.onClick

//class WatingForPaymentAdapter(var items: ArrayList<VirtualAccountPaymentAdapter>) :
//    RecyclerView.Adapter<WatingForPaymentAdapter.WatingForPaymentAdapterViewHolder>() {
//    var listener: WatingForPaymentAdapterListener? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): WatingForPaymentAdapterViewHolder {
//        return WatingForPaymentAdapterViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.activity_waiting_for_payment,
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun getItemCount() = items.size
//
//    override fun onBindViewHolder(holder: WatingForPaymentAdapterViewHolder, position: Int) {
//        listener?.let { holder.bind(it, items[position]) }
//    }
//
//    interface WatingForPaymentAdapterListener {
//        fun OnItemClick(model: VirtualAccountPaymentAdapter)
//    }
//
//    class WatingForPaymentAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(listener: WatingForPaymentAdapterListener, model: VirtualAccountPaymentAdapter) {
//
//        }
//    }
//}