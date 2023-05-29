package poncho.boncho.studentsdiary

import android.app.Application
import poncho.boncho.studentsdiary.data.ItemRoomDatabase

class DiaryApplication : Application(){
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}