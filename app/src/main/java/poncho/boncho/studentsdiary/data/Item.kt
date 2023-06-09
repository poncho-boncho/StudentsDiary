package poncho.boncho.studentsdiary.data

import androidx.room.*
import org.w3c.dom.Text
import java.sql.Date
import java.sql.Time
import java.text.NumberFormat

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "event")
    val itemEvent: String,
    @ColumnInfo(name = "time")
    var itemTime: String,
    @ColumnInfo(name = "date")
    var itemDate: String,
    @ColumnInfo(name = "address")
    val itemAddress: String,
)