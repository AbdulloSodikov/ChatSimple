package sodikov.ak.chatsample.dialog.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sodikov.ak.chatsample.R
import sodikov.ak.chatsample.databinding.ItemChatMessageLeftBinding
import sodikov.ak.chatsample.databinding.ItemChatMessageRightBinding
import sodikov.ak.chatsample.models.ItemData
import sodikov.ak.chatsample.models.LeftMessageItemData
import sodikov.ak.chatsample.models.RightMessageItemData

class DialogDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val LEFT = 1
        const val RIGHT = 2
    }

    private val list = arrayListOf<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == LEFT) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message_left, parent, false)
            LeftMessageViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message_right, parent, false)
            RightMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (getItemViewType(position) == LEFT){
            (holder as LeftMessageViewHolder).bind(model as LeftMessageItemData)
        } else {
            (holder as RightMessageViewHolder).bind(model as RightMessageItemData)
        }
    }

    override fun getItemCount(): Int = list.size


    override fun getItemViewType(position: Int): Int =
        if (list[position] is LeftMessageItemData)
            LEFT
        else
            RIGHT

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<ItemData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class LeftMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemChatMessageLeftBinding.bind(view)
        fun bind(model: LeftMessageItemData) = with(binding){
            text.text = model.message
        }
    }

    inner class RightMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemChatMessageRightBinding.bind(view)
        fun bind(model: RightMessageItemData) = with(binding){
            text.text = model.message
        }
    }

}