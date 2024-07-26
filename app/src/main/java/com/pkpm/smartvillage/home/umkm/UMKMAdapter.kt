package com.pkpm.smartvillage.home.umkm

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.databinding.ItemUmkmBinding

class UMKMAdapter(private val umkmList: List<UMKM>) : RecyclerView.Adapter<UMKMAdapter.ViewHolder>() {

    private val umkmListFiltered: MutableList<UMKM> = umkmList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUmkmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val umkm = umkmListFiltered[position]
        holder.bind(umkm)
    }

    override fun getItemCount(): Int = umkmListFiltered.size

    fun filter(query: String) {
        umkmListFiltered.clear()
        if (query.isEmpty()) {
            umkmListFiltered.addAll(umkmList)
        } else {
            umkmListFiltered.addAll(
                umkmList.filter { it.name.contains(query, ignoreCase = true) }
            )
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemUmkmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(umkm: UMKM) {
            binding.textViewName.text = umkm.name
            binding.textViewOwner.text = umkm.owner
            binding.textViewPrice.text = umkm.price
            binding.imageViewUmkm.setImageResource(umkm.imageResId)

            binding.buttonContact.setOnClickListener {
                val whatsappUrl = umkm.link
                if (!TextUtils.isEmpty(whatsappUrl)) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl))
                    val packageManager = itemView.context.packageManager
                    val installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
                    val isWhatsAppInstalled = installedApps.any { it.packageName.startsWith("com.whatsapp") }

                    if (isWhatsAppInstalled) {
                        itemView.context.startActivity(intent)
                    } else {
                        Toast.makeText(itemView.context, "WhatsApp tidak terpasang di perangkat ini", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(itemView.context, "URL tidak valid", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
