package sodikov.ak.chatsample.dialog.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sodikov.ak.chatsample.models.ItemData
import sodikov.ak.chatsample.models.LeftMessageItemData
import sodikov.ak.chatsample.models.RightMessageItemData

class DialogDetailViewModel : ViewModel() {
    var messageListLiveData = MutableLiveData<List<ItemData>>()

    init {
        mockData()
    }

    private fun mockData() {
        val list = arrayListOf<ItemData>()

        repeat(20) {
            val message = if (it % 2 == 0) {
                LeftMessageItemData(
                    message = "left_message #$it"
                )
            } else {
                RightMessageItemData(
                    message = "right_message #$it"
                )
            }
            list.add(message)
        }
        messageListLiveData.postValue(list)
    }
}