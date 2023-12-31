package com.example.course.core.model.utilis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.course.MyCustomClickListener
import com.example.course.core.model.body.Post
import com.example.course.databinding.PostItemBinding

class CustomeAdapter (var Postslist:List<Post>, var listener: MyCustomClickListener) :
    RecyclerView.Adapter<CustomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Postslist.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.usernameText.text = "userId: ${Postslist[position].userId}"
        viewHolder.binding.dateText.text = "postId: ${Postslist[position].id}"
        viewHolder.binding.postText.text = "${Postslist[position].body}"
        viewHolder.binding.titleText.text = "${Postslist[position].title}"


        viewHolder.binding.detailButton.setOnClickListener {
            listener.onItemClick(Postslist[position], position)
        }

    }
}