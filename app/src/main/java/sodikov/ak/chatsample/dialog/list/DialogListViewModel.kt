package sodikov.ak.chatsample.dialog.list

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sodikov.ak.chatsample.base.BaseViewModel
import sodikov.ak.chatsample.models.DialogItemData

class DialogListViewModel:BaseViewModel() {

    private val _dialogs: MutableLiveData<List<DialogItemData>> by lazy {
        MutableLiveData<List<DialogItemData>>()
    }
    val dialogs : LiveData<List<DialogItemData>> = _dialogs


    init {
        getDialogs()
    }

    private fun getDialogs(){
        val list = arrayListOf<DialogItemData>()
        repeat(10){ index ->
            list.add(DialogItemData("Dialog #$index"))
        }
        android.os.Handler(Looper.getMainLooper()).postDelayed({
           _dialogs.postValue(list)
        }, 5000)
    }
}