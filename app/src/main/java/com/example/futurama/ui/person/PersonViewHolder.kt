package com.example.futurama.ui.person

import com.example.futurama.databinding.PersonViewHolderBinding
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.tools.loadImage
import com.example.futurama.ui.base.BaseViewHolder
import com.example.futurama.domain.tools.ClickableView

class PersonViewHolder(private val binding: PersonViewHolderBinding) :
    BaseViewHolder<Person>(binding) {

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