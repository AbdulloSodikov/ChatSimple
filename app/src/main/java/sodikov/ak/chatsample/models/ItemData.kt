package sodikov.ak.chatsample.models

open class ItemData()

data class LeftMessageItemData(
    val message: String,
) : ItemData()

data class RightMessageItemData(
    val message: String,
) : ItemData()