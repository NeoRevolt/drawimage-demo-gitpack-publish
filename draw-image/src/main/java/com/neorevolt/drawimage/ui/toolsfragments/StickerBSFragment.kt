package com.neorevolt.drawimage.ui.toolsfragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetBehavior
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.neorevolt.drawimage.R
import com.neorevolt.drawimage.data.offline.IconViewModel
import com.neorevolt.drawimage.data.offline.entity.IconEntity

/**
 * Added by NeoRevolt on 7/1/2022.
 */
class StickerBSFragment : BottomSheetDialogFragment() {

    private lateinit var mIconViewModel: IconViewModel


    private var mStickerListener: StickerListener? = null
    fun setStickerListener(stickerListener: StickerListener?) {
        mStickerListener = stickerListener
    }

    interface StickerListener {
        fun onStickerClick(bitmap: Bitmap?)
    }

    private val mBottomSheetBehaviorCallback: BottomSheetCallback = object : BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.fragment_bottom_sticker_emoji_dialog, null)
        dialog.setContentView(contentView)

        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior
        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            behavior.addBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))
        val rvEmoji: RecyclerView = contentView.findViewById(R.id.rvEmoji)
        val gridLayoutManager = GridLayoutManager(activity, 3)
        rvEmoji.layoutManager = gridLayoutManager
        val stickerAdapter = StickerAdapter()
        rvEmoji.adapter = stickerAdapter
        rvEmoji.setHasFixedSize(true)

        //TODO : Try to fix the logic for sticker
        mIconViewModel = ViewModelProvider(this).get(IconViewModel::class.java)
        if (iconPestList.isNotEmpty()) {
            mIconViewModel.deleteIconFromDB()
        }

        mIconViewModel.readAllIcon.observe(this, Observer { icon ->
            if (icon.isNullOrEmpty()) {
                addIconToDatabase()
                stickerAdapter.setData(icon)
            }
            stickerAdapter.setData(icon)
        })
    }

    private fun addIconToDatabase() {
        mIconViewModel.apply {
            addIcon(
                IconEntity(
                    null,
                    "Fly",
                    "https://cdn-icons-png.flaticon.com/512/2849/2849909.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Ant",
                    "https://cdn-icons-png.flaticon.com/512/1850/1850279.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Bug",
                    "https://cdn-icons-png.flaticon.com/512/854/854649.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Centipede",
                    "https://cdn-icons-png.flaticon.com/512/1850/1850261.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Roach",
                    "https://cdn-icons-png.flaticon.com/512/1553/1553874.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Mosquito",
                    "https://cdn-icons-png.flaticon.com/512/2865/2865206.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Spider",
                    "https://cdn-icons-png.flaticon.com/512/1850/1850190.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Wasp",
                    "https://cdn-icons-png.flaticon.com/512/311/311590.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Beetle",
                    "https://cdn-icons-png.flaticon.com/512/2975/2975299.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Mouse",
                    "https://cdn-icons-png.flaticon.com/512/2297/2297338.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Bat",
                    "https://cdn-icons-png.flaticon.com/512/616/616620.png"
                )
            );
            addIcon(
                IconEntity(
                    null,
                    "Bird",
                    "https://cdn-icons-png.flaticon.com/512/7197/7197073.png"
                )
            );
        }
        Toast.makeText(requireContext(), "Icons have been added to DB", Toast.LENGTH_SHORT).show()
    }


    inner class StickerAdapter : RecyclerView.Adapter<StickerAdapter.ViewHolder>() {
        private var iconList = emptyList<IconEntity>()

        fun setData(icon: List<IconEntity>) {
            this.iconList = icon
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_sticker, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            // Load sticker image from remote url
            Glide.with(requireContext())
                .asBitmap()
                .load(iconList[position].iconUrl)
                .into(holder.imgSticker)
        }

        override fun getItemCount(): Int {
            return iconList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgSticker: ImageView = itemView.findViewById(R.id.imgSticker)

            init {
                itemView.setOnClickListener {
                    if (mStickerListener != null) {
                        Glide.with(requireContext())
                            .asBitmap()
                            .load(iconList[layoutPosition].iconUrl)
                            .into(object : CustomTarget<Bitmap?>(256, 256) {
                                override fun onResourceReady(
                                    resource: Bitmap,
                                    transition: Transition<in Bitmap?>?
                                ) {
                                    mStickerListener!!.onStickerClick(resource)
                                }

                                override fun onLoadCleared(placeholder: Drawable?) {}
                            })
                    }
                    dismiss()
                }
            }
        }

    }

    companion object {
        private val iconPestList = ArrayList<IconEntity>()
    }
}