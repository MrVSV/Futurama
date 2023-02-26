package com.example.person_list.presentation

import com.example.core.databinding.PersonViewHolderBinding
import com.example.core.model.Person
import com.example.core.tools.ClickableView
import com.example.core.tools.loadImage

class PersonViewHolder(private val binding: PersonViewHolderBinding) :
    com.example.core.base.BaseViewHolder<Person>(binding) {

    override fun bind(item: Person, onClick: (ClickableView, item: Person) -> Unit) {

        with(binding){
            name.text = item.name
            species.text = item.species
            avatar.loadImage(item.images)
            isLiked.isSelected = item.isFavorite
            isLiked.setOnClickListener {
                onClick(ClickableView.FAVORITE, item)
//                isLiked.isSelected =! isLiked.isSelected
            }

        }

//        val viewDragHelperCallback = object : ViewDragHelper.Callback() {
//
//            override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
//                if (capturedChild is MaterialCardView) {
//                    binding.root.isDragged = true
//                }
//            }
//
//            override fun onViewReleased(releaseChild: View, xVel: Float, yVel: Float) {
//                if (releaseChild is MaterialCardView) {
//                    binding.root.isDragged = false
//                }
//            }
//
//            override fun tryCaptureView(child: View, pointerId: Int): Boolean {
//                return true
//            }
//        }
    }
}