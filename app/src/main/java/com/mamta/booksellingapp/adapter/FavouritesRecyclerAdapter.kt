package com.mamta.booksellingapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mamta.booksellingapp.R
import com.mamta.booksellingapp.database.BookEntity
import com.squareup.picasso.Picasso

//class FavouritesRecyclerAdapter(context: Context, dbFavBookList: List<BookEntity>) {
class FavouritesRecyclerAdapter(val context: Context, val bookList: List<BookEntity>):
    RecyclerView.Adapter<FavouritesRecyclerAdapter.FavouriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_favorite_single_row,parent,false)
        return FavouriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val book = bookList[position]

        holder.txtBookName.text = book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text= book.bookPrice
        holder.txtBookRating.text=book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
        holder.llContent.setOnClickListener{
            Toast.makeText(context,"You clicked ${book.bookName}",Toast.LENGTH_SHORT).show()
        }
    }
    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtBookName: TextView =view.findViewById(R.id.txtFavBookTitle)
        val txtBookAuthor: TextView =view.findViewById(R.id.txtFavBookAuthor)
        val txtBookPrice: TextView =view.findViewById(R.id.txtFavBookPrice)
        val txtBookRating: TextView =view.findViewById(R.id.txtFavBookRating)
        val imgBookImage: ImageView =view.findViewById(R.id.imgFavBookImage)
        val llContent: LinearLayout =view.findViewById(R.id.llFavContent)
    }


}
//}