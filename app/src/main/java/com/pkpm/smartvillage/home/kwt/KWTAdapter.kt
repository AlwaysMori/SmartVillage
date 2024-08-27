package com.pkpm.smartvillage.home.kwt

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.databinding.ItemTaniBinding

class KWTAdapter(private val items: List<KWTItem>) : RecyclerView.Adapter<KWTAdapter.KWTViewHolder>(), Filterable {

    private var filteredItems: List<KWTItem> = items

    inner class KWTViewHolder(val binding: ItemTaniBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KWTViewHolder {
        val binding = ItemTaniBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KWTViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KWTViewHolder, position: Int) {
        val item = filteredItems[position]
        holder.binding.dusun.text = item.dusun
        holder.binding.fotokwt.setImageResource(item.fotoKWT)
        holder.binding.namaketua.text = "Ketua : ${item.namaKetua}"
        holder.binding.namatumbuhan.text = "Tanaman : ${item.namaTumbuhan}"
        holder.binding.lokasi.text = "Nama KWT : ${item.lokasi}"
        holder.binding.gmap.text = "Google Maps : ${item.gmap}"
        holder.binding.deskripsi.text = "Deskripsi : ${item.deskripsi}"

        holder.binding.contact.setOnClickListener {
            val contact = item.contact

            if (contact.isNullOrBlank()) {
                Toast.makeText(holder.binding.root.context, "Whatsapp tidak tersedia", Toast.LENGTH_SHORT).show()
            } else {
                val uri = Uri.parse("https://wa.me/$contact")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                holder.binding.root.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return filteredItems.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = if (constraint.isNullOrEmpty()) {
                    items
                } else {
                    val query = constraint.toString().lowercase()
                    items.filter {
                        it.dusun.lowercase().contains(query) ||
                                it.namaKetua.lowercase().contains(query) ||
                                it.namaTumbuhan.lowercase().contains(query) ||
                                it.lokasi.lowercase().contains(query) ||
                                it.gmap.lowercase().contains(query) ||
                                it.deskripsi.lowercase().contains(query)
                    }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredItems = results?.values as List<KWTItem>
                notifyDataSetChanged()
            }
        }
    }
}
