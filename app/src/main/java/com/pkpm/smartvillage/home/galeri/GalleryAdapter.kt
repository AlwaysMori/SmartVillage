package com.pkpm.smartvillage.home.galeri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pkpm.smartvillage.R


import android.app.AlertDialog
import android.content.Context
import android.widget.Button


class GalleryAdapter(
    private val items: List<GalleryItem>,
    private val context: Context
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    data class GalleryItem(val imageResId: Int, val placeName: String)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_galeri, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.placeName.text = item.placeName

        holder.imageView.setOnClickListener {
            showImageDialog(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun showImageDialog(item: GalleryItem) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_image, null)
        val dialogImageView: ImageView = dialogView.findViewById(R.id.dialogImageView)
        val dialogPlaceName: TextView = dialogView.findViewById(R.id.dialogPlaceName)

        dialogImageView.setImageResource(item.imageResId)
        dialogPlaceName.text = item.placeName

        val alertDialog = AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .setView(dialogView)
            .setPositiveButton("Tutup", null)
            .create()

        alertDialog.setOnShowListener {
            val positiveButton: Button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setTextColor(context.resources.getColor(R.color.black, null))
        }

        alertDialog.show()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val placeName: TextView = itemView.findViewById(R.id.placeName)
    }
}

