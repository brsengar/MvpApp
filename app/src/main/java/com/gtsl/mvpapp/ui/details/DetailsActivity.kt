package com.gtsl.mvpapp.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.gtsl.mvpapp.R
import com.gtsl.mvpapp.data.model.Title
import com.gtsl.mvpapp.utils.bindView
import java.text.DecimalFormat

class DetailsActivity : AppCompatActivity() {
    companion object {
        @JvmStatic val EXTRA_COMIC = "comic"
    }

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val title: TextView by bindView(R.id.comic_detail_title)
    val creators: TextView by bindView(R.id.comic_detail_creators)
    val price: TextView by bindView(R.id.comic_detail_price)
    val description: TextView by bindView(R.id.comic_detail_description)
    val comicImage: ImageView by bindView(R.id.comic_image)

    private var mTitle: Title? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_detail)

        ButterKnife.bind(this)

        mTitle = intent.getParcelableExtra<Title>(EXTRA_COMIC)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.title = getTitle()

        initViews()
    }

    fun initViews() {
        title!!.text = mTitle!!.title()
        creators!!.text = getCreators()
        description!!.text = Html.fromHtml(if (mTitle!!.description() != null)
            mTitle!!.description()
        else
            getString(R.string.message_no_content))
        price!!.text = if (mTitle!!.prices().size > 0)
            DecimalFormat("£#.##").format(mTitle!!.prices()[0].price().toDouble())
        else
            getString(R.string.message_free)
        Glide.with(this)
                .load(mTitle!!.thumbnail().path() + "." + mTitle!!.thumbnail().extension())
                .into(comicImage!!)
    }

    private fun getCreators(): String {
        val creators = StringBuilder()
        for (creatorSummary in mTitle!!.creators()!!.items()) {
            creators.append(creatorSummary.name()).append(", ")
        }
        if (creators.length > 0) {
            creators.delete(creators.length - 2, creators.length)
        }
        return creators.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
