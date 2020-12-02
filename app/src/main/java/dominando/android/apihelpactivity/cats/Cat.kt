package dominando.android.apihelpactivity.cats

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(val name:String, val img:String):Parcelable