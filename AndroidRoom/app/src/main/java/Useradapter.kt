package com.generation.androidroom.adapter


import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.androidactivity.UserDao
import com.generation.androidactivity.databinding.CardLayoutBinding
import com.generation.androidroom.Usuario
import com.generation.androidroom.databinding.CardLayoutBinding
import com.generation.androidroom.databinding.FragmentAddfragmnetBinding
import com.generation.androidroom.userDao
import java.text.FieldPosition


class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var listUser = emptyList<Usuario>()

    class UserViewHolder (binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
    val user = listUser(position)

    holder.binding.textId.text= user.id.toString()
    holder.binding.textNome.text= user.nome
    holder.binding.textSobrenome.text= user.sobrenme
    holder.binding.textidade.text= user.idade.toString()


}

   override fun  getItemCount(): Int {
     return listUser.size
   }

    fun setList(list: List<Usuario>){
        listUser = list
        notifyDataSetChanged()
    }
}

