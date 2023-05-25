package com.example.recyclerviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nameTextView =  itemView.findViewById<TextView>(R.id.contact_name)
        val messageButton =  itemView.findViewById<Button>(R.id.message_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        //context represents the current state and environment of the application
        val context = parent.context
        //layoutinflater is responsible for inflating or creating the view hierarchy
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_contact,parent,false)
        return ViewHolder(contactView)
    }

    //returns the total count of items in the list
    override fun getItemCount(): Int {
       return mContacts.size
    }

    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        val contact: Contact = mContacts.get(position)
        val textView = viewHolder.nameTextView
        textView.setText(contact.name)
        val button = viewHolder.messageButton
        button.text = if (contact.isOnline) "Message" else "Offline"
        button.isEnabled = contact.isOnline
    }

}