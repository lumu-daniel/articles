package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.AsyncListUtil.DataCallback
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter : RecyclerView.Adapter<RVCustomAdapter.RVHolder>(){

    val callback = object: ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer<Article>(this,callback)

    var articleList: List<Article> ?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    class RVHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val mImageViewCardViewItem = itemView.findViewById<ImageView>(R.id.mImageViewCardViewItem)
        val mTextViewTitle = itemView.findViewById<TextView>(R.id.mTextViewTitle)
        val mTextViewContent = itemView.findViewById<TextView>(R.id.mTextViewContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        return RVHolder(
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        val article = differ.currentList[position]
        holder.apply {
//            mImageViewCardViewItem.
            mTextViewContent.text = article.content
            mTextViewTitle.text = article.title
        }
    }

}