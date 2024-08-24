package com.pkpm.smartvillage.home.struktur

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.R

class StrukturAdapter(private val itemList: List<Struktur>, private val showDusun: Boolean, private val showBagian: Boolean) : RecyclerView.Adapter<StrukturAdapter.MyViewHolder>() {

    private var filteredList: List<Struktur> = itemList

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val namaTextView: TextView = itemView.findViewById(R.id.namaTextView)
        val dusunTextView: TextView = itemView.findViewById(R.id.dusun)
        val hubungiButton: Button = itemView.findViewById(R.id.hubungiButton)
        val bagian: TextView = itemView.findViewById((R.id.bagian))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_struktur, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = filteredList[position]
        holder.namaTextView.text = "Nama : ${item.nama}"
        holder.imageView.setImageResource(item.gambar)

        if (showDusun) {
            holder.dusunTextView.visibility = View.VISIBLE
            holder.dusunTextView.text = "Dusun : ${item.dusun}"
        } else {
            holder.dusunTextView.visibility = View.GONE
        }

        if (showBagian) {
            holder.bagian.visibility = View.VISIBLE
            holder.bagian.text = "Bagian : ${item.bagian}"
        } else {
            holder.bagian.visibility = View.GONE
        }

        holder.hubungiButton.setOnClickListener {
            val nomorWa = item.nomorWa
            if (!nomorWa.isNullOrEmpty()) {
                val uri = Uri.parse("https://wa.me/$nomorWa")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                it.context.startActivity(intent)
            } else {
                Toast.makeText(it.context, "Nomor WhatsApp tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun getItemCount() = filteredList.size

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            itemList
        } else {
            itemList.filter {
                it.nama.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}
