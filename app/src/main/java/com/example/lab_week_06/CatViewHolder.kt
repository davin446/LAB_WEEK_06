package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener // pakai dari CatAdapter
) : RecyclerView.ViewHolder(containerView) {

    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.cat_biography) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.cat_breed) }
    private val catGenderView: TextView by lazy { containerView.findViewById(R.id.cat_gender) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.cat_name) }
    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.cat_photo) }

    fun bindData(cat: CatModel) {
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = cat.breed.toString()
        catBiographyView.text = cat.biography
        catGenderView.text = cat.gender.toString()
    }
}
