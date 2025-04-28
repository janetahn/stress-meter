package com.example.janet_ahn_stressmeter.ui.stressmeter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.janet_ahn_stressmeter.MainActivity

class ImageViewAdapter constructor(context: Context, gridNumber: Int?) : BaseAdapter() {

    private var context: Context? = context
    private var gridNumber: Int? = gridNumber

    override fun getCount(): Int {
        var imageArray = StressMeterFragment()
        return imageArray.getGridArray(gridNumber!!)!!.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        // no imageview in xml so we make one here for the grids
        val imageView: ImageView

        //view is created only when convertView is NULL else it returns an already created view
        if (convertView == null) {
            imageView = ImageView(context)
            // size of imageview
            imageView.layoutParams = AbsListView.LayoutParams(300, 300)
            // maintain image aspect ratio and scale
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            imageView = convertView as ImageView
        }
        var imageArray = StressMeterFragment()
        imageView.setImageResource(imageArray.getGridArray(gridNumber!!)!![position])
        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}