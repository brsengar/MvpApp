package com.gtsl.mvpapp.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.gtsl.mvpapp.R
import com.gtsl.mvpapp.data.model.Title
import java.text.DecimalFormat

class ComicDetailActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null
    @BindView(R.id.comic_detail_title)
    internal var title: TextView? = null
    @BindView(R.id.comic_detail_creators)
    internal var creators: TextView? = null
    @BindView(R.id.comic_detail_price)
    internal var price: TextView? = null
    @BindView(R.id.comic_detail_description)
    internal var description: TextView? = null
    @BindView(R.id.comic_image)
    internal var comicImage: ImageView? = null

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

    companion object {
        val EXTRA_COMIC = "comic"
    }
}
