package com.neorevolt.drawimage.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neorevolt.drawimage.R
import java.util.ArrayList

/**
 * @author [Burhanuddin Rashid](https://github.com/example)
 * @version 0.1.2
 * @since 5/23/2018
 */
class EditingToolsAdapter(private val mOnItemSelected: OnItemSelected) :
    RecyclerView.Adapter<EditingToolsAdapter.ViewHolder>() {
    private val mToolList: MutableList<ToolModel> = ArrayList()

    interface OnItemSelected {
        fun onToolSelected(toolType: ToolType?)
    }

    internal inner class ToolModel(
        val mToolName: String,
        val mToolIcon: Int,
        val mToolType: ToolType
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_editing_tools, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mToolList[position]
        holder.txtTool.text = item.mToolName
        holder.imgToolIcon.setImageResource(item.mToolIcon)
    }

    override fun getItemCount(): Int {
        return mToolList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgToolIcon: ImageView = itemView.findViewById(R.id.imgToolIcon)
        val txtTool: TextView = itemView.findViewById(R.id.txtTool)

        init {
            itemView.setOnClickListener { _: View? ->
                mOnItemSelected.onToolSelected(
                    mToolList[layoutPosition].mToolType
                )
            }
        }
    }

    init {
        mToolList.add(ToolModel("Brush", R.drawable.ic_brush, ToolType.BRUSH))
        mToolList.add(ToolModel("Eraser", R.drawable.ic_eraser, ToolType.ERASER))
        mToolList.add(ToolModel("Text", R.drawable.ic_text, ToolType.TEXT))
        mToolList.add(ToolModel("Adjust", R.drawable.ic_adjust, ToolType.ADJUST))
//        mToolList.add(ToolModel("Emoji", R.drawable.ic_insert_emoticon, ToolType.EMOJI))
        mToolList.add(ToolModel("Pest", R.drawable.ic_mouse, ToolType.STICKER))
    }
}