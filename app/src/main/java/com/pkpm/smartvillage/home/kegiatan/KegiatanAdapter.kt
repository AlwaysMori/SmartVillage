package com.pkpm.smartvillage.home.kegiatan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.R

class KegiatanAdapter(private val kegiatanList: List<Kegiatan>) : RecyclerView.Adapter<KegiatanAdapter.KegiatanViewHolder>() {

    class KegiatanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoKegiatan: ImageView = itemView.findViewById(R.id.fotoKegiatan)
        val judulKegiatan: TextView = itemView.findViewById(R.id.judulKegiatan)
        val date: TextView = itemView.findViewById(R.id.date)
        val captionKegiatan: TextView = itemView.findViewById(R.id.captionKegiatan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KegiatanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_kegiatan, parent, false)
        return KegiatanViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KegiatanViewHolder, position: Int) {
        val currentItem = kegiatanList[position]
        holder.fotoKegiatan.setImageResource(currentItem.foto)
        holder.judulKegiatan.text = currentItem.judul
        holder.date.text = currentItem.tanggal
        holder.captionKegiatan.text = currentItem.caption
    }

    override fun getItemCount() = kegiatanList.size
}
