package com.example.admin.myapplication.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.example.admin.myapplication.Contact
import com.example.admin.myapplication.MyApplication
import com.example.admin.myapplication.R

class Banner : Fragment(), Contact.BannerView {
    var image: String
    private var imageView: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.top_image, container, false)
        initId(view)
        loadPic()
        return view
    }

    override fun initId(view: View) {
        imageView = view.findViewById(R.id.top_image_view)
    }

    override fun loadPic() {
        Glide.with(MyApplication.context!!)
                .load(image)
                .into(imageView!!)
    }

    companion object {

        fun getBannerInstance(image: String): Banner {
            val banner = Banner()
            banner.image = image
            return banner
        }
    }
}
