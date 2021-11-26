package ru.coronavirus.testapp.ui.utils.customviews

import android.content.Context
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import ru.coronavirus.testapp.R

class ChartMarkerView(context: Context, @LayoutRes layoutRes: Int) :
    MarkerView(context, layoutRes) {

        private val textView: TextView = findViewById(R.id.textView)

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        textView.text = (e?.data as? Int).toString()

        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-(width / 2).toFloat(), -height.toFloat())
    }
}