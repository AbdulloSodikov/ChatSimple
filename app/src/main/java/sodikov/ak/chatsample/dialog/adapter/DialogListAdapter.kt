package sodikov.ak.chatsample.dialog.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sodikov.ak.chatsample.databinding.ItemDialogBinding
import sodikov.ak.chatsample.models.DialogItemData

class DialogListAdapter : RecyclerView.Adapter<DialogListAdapter.DialogViewHolder>() {
    private var dialogList = arrayListOf<DialogItemData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val binding = ItemDialogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DialogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        holder.bind(dialogList[position])
    }

    override fun getItemCount(): Int = dialogList.size


    data class DialogViewHolder(private val binding: ItemDialogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: DialogItemData) {
            binding.dialogTV.text = model.message
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<DialogItemData>) {
        dialogList.clear()
        dialogList.addAll(newList)
        notifyDataSetChanged()
    }
}