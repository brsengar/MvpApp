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
        @JvmStatic val EXTRA_TITLE = "title"
    }

    val mToolbar: Toolbar by bindView(R.id.home_toolbar)
    val mTitleTextView: TextView by bindView(R.id.details_content_textview_title)
    val mPriceTextView: TextView by bindView(R.id.details_content_textview_price)
    val mDescriptionTextView: TextView by bindView(R.id.details_content_textview_description)
    val mTitleImageView: ImageView by bindView(R.id.title_details_imageview_title)

    private var mTitle: Title? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_details)

        ButterKnife.bind(this)

        mTitle = intent.getParcelableExtra<Title>(EXTRA_TITLE)

        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.title = getTitle()

        initViews()
    }

    fun initViews() {
        mTitleTextView!!.text = mTitle!!.title()
        mDescriptionTextView!!.text = Html.fromHtml(if (mTitle!!.description() != null)
            mTitle!!.description()
        else
            getString(R.string.message_no_content))
        mPriceTextView!!.text = if (mTitle!!.prices().size > 0)
            DecimalFormat("£#.##").format(mTitle!!.prices()[0].price().toDouble())
        else
            getString(R.string.message_free)
        Glide.with(this)
                .load(mTitle!!.thumbnail().path() + "." + mTitle!!.thumbnail().extension())
                .into(mTitleImageView!!)
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
