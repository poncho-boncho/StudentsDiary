package poncho.boncho.studentsdiary

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import poncho.boncho.studentsdiary.data.Item
import poncho.boncho.studentsdiary.data.ItemDao

class DiaryViewModel (private val itemDao: ItemDao) : ViewModel(){

    val allItems: LiveData<List<Item>> = itemDao.getItems().asLiveData()
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }
    private fun getNewItemEntry(itemName: String, itemPrice: String, itemDate: String, itemCount: String): Item {
        return Item(
            itemEvent = itemName,
            itemTime = itemPrice,
            itemDate = itemDate,
            itemAddress = itemCount
        )
    }
    fun addNewItem(itemName: String, itemPrice: String, itemDate: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemDate, itemCount)
        insertItem(newItem)
    }
    fun isEntryValid(itemName: String, itemPrice: String, itemDate: String, itemCount: String): Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemDate.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }

    private fun updateItem(item: Item) {
    }

}

class DiariViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiaryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}