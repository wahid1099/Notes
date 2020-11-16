package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(val context:Context,val listener:INotesRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    val allNotes=ArrayList<Note>()
    inner class NoteViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val  textView=itemview.findViewById<TextView>(R.id.text)
        val deletebutton=itemview.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
     val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))

       viewHolder.deletebutton.setOnClickListener {
           listener.onItemClicked(allNotes[viewHolder.adapterPosition])
       }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }
        fun updateList(newList:ArrayList<Note>){
            allNotes.clear()
            allNotes.addAll(newList)
            notifyDataSetChanged()
        }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}



interface INotesRVAdapter{
    fun onItemClicked(note:Note)
}