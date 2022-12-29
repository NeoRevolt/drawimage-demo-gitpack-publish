package com.neorevolt.drawimage.ui.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.example.photoediting.data.remote.ListStoryItem
//import com.example.photoeditor_module.databinding.ItemRemoteImagesBinding
//import java.text.SimpleDateFormat
//import java.util.*
//import kotlin.collections.ArrayList
//
//class RemoteImagesAdapter : RecyclerView.Adapter<RemoteImagesAdapter.ViewHolder>() {
//
//    private val list = ArrayList<ListStoryItem>()
//    private var onItemClickCallback: OnItemClickCallback? = null
//
//    fun setList(story: ArrayList<ListStoryItem>) {
//        list.clear()
//        list.addAll(story)
//        notifyDataSetChanged()
//    }
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    class ViewHolder(private val binding: ItemRemoteImagesBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(story: ListStoryItem){
//            binding.apply {
//                Glide.with(itemView)
//                    .load(story.photoUrl)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .fitCenter()
//                    .into(imgItemPhoto)
//                tvAuthor.text = "@${story.name}"
//                val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
//                val date2 = story.createdAt.let { dateFormat.parse(it) }
//                val formatter2 = SimpleDateFormat("dd/MM/yy'  'HH:mm:ss")
//                val dateStr = date2?.let { formatter2.format(it) }
//                tvItemName.text = dateStr
////                tvItemDesk.text = story.description
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = ItemRemoteImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(list[position])
//        holder.itemView.setOnClickListener {
//            onItemClickCallback?.onItemClicked(list[position])
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: ListStoryItem)
//    }
//}