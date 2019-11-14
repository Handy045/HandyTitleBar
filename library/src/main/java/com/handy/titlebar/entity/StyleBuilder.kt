package com.handy.titlebar.entity

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.handy.titlebar.R

/**
 * @title: StyleBuilder
 * @projectName HandyTitlebar
 * @description: 标题栏属性对象
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-11-13 09:22
 */
class StyleBuilder constructor(context: Context, attrs: AttributeSet?, resources: Resources) {

    //============================================================
    //  状态栏
    //============================================================

    var isShowCustomStatusbar: Boolean = false
    var statusbarHeight: Float = 0f
    @ColorInt
    var statusbarBackgroundColor: Int = 0

    //============================================================
    //  顶部分割线
    //============================================================

    var topLineHeight: Float = 0f
    @ColorInt
    var topLineColor: Int = 0

    //============================================================
    //  标题栏
    //============================================================

    var titlebarMargin: Float = 0f
    var titlebarMarginTop: Float = 0f
    var titlebarMarginLeft: Float = 0f
    var titlebarMarginRight: Float = 0f
    var titlebarMarginBottom: Float = 0f
    var titlebarHeight: Float = 0f
    var titlebarBackground: Drawable? = null

    var contentLayoutPadding: Float = 0f
    var contentLayoutOrientation: Int = 1
    var textMarginH: Float = 0f
    var textMarginV: Float = 0f

    var mainText: String? = null
    var mainTextSize: Float = 0f
    @ColorInt
    var mainTextColor: Int = 0
    @ColorInt
    var mainTextBackgroundColor: Int = 0
    var subText: String? = null
    var subTextSize: Float = 0f
    @ColorInt
    var subTextColor: Int = 0
    @ColorInt
    var subTextBackgroundColor: Int = 0

    //============================================================
    //  底部分割线
    //============================================================

    var bottomLineHeight: Float = 0f
    @ColorInt
    var bottomLineColor: Int = 0

    //============================================================
    //  按钮
    //============================================================

    var actionParentMargin: Float = 0f
    var actionViewPadding: Float = 0f
    var actionSpacing: Float = 0f
    var actionTextSize: Float = 0f
    @ColorInt
    var actionTextColor: Int = 0
    var actionImageSize: Float = 0f

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HandyTitlebarStyleable)

        // 状态栏
        this.isShowCustomStatusbar = typedArray.getBoolean(
            R.styleable.HandyTitlebarStyleable_handy_isShowCustomStatusbar,
            false
        )
        this.statusbarHeight = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_statusbarHeight,
            if (isShowCustomStatusbar) getStatusBarHeight(context) else 0f
        )
        this.statusbarBackgroundColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_statusbarBackgroundColor,
            ContextCompat.getColor(context, R.color.google_lightbluea700)
        )

        // 顶部分割线
        this.topLineHeight =
            typedArray.getDimension(
                R.styleable.HandyTitlebarStyleable_handy_topLineHeight,
                resources.getDimension(R.dimen.hdb_dp1)
            )
        this.topLineColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_topLineColor,
            ContextCompat.getColor(context, R.color.google_grey500)
        )

        // 标题栏
        this.titlebarMargin = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarMargin,
            resources.getDimension(R.dimen.hdb_dp0)
        )
        this.titlebarMarginTop = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarMarginTop,
            resources.getDimension(R.dimen.hdb_dp0)
        )
        this.titlebarMarginLeft = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarMarginLeft,
            resources.getDimension(R.dimen.hdb_dp0)
        )
        this.titlebarMarginRight = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarMarginRight,
            resources.getDimension(R.dimen.hdb_dp0)
        )
        this.titlebarMarginBottom = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarMarginBottom,
            resources.getDimension(R.dimen.hdb_dp0)
        )
        this.titlebarHeight = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_titlebarHeight,
            resources.getDimension(R.dimen.hdb_dp48)
        )
        this.titlebarBackground =
            typedArray.getDrawable(R.styleable.HandyTitlebarStyleable_handy_titlebarBackground)
        if (this.titlebarBackground == null) {
            this.titlebarBackground = ColorDrawable(
                ContextCompat.getColor(context, R.color.google_lightbluea700)
            )
        }

        this.contentLayoutPadding = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_contentLayoutPadding,
            resources.getDimension(R.dimen.hdb_dp8)
        )
        this.contentLayoutOrientation = typedArray.getInt(
            R.styleable.HandyTitlebarStyleable_handy_contentLayoutOrientation,
            1
        )
        this.textMarginH = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_textMarginH,
            resources.getDimension(R.dimen.hdb_dp2)
        )
        this.textMarginV = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_textMarginV,
            resources.getDimension(R.dimen.hdb_dp1)
        )

        this.mainText = typedArray.getString(R.styleable.HandyTitlebarStyleable_handy_mainText)
        this.mainTextSize = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_mainTextSize,
            resources.getDimension(R.dimen.hdb_sp16)
        )
        this.mainTextColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_mainTextColor,
            ContextCompat.getColor(context, R.color.web_white)
        )
        this.mainTextBackgroundColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_mainTextBackgroundColor,
            ContextCompat.getColor(context, R.color.web_transparent)
        )
        this.subText = typedArray.getString(R.styleable.HandyTitlebarStyleable_handy_subText)
        this.subTextSize = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_subTextSize,
            resources.getDimension(R.dimen.hdb_sp12)
        )
        this.subTextColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_subTextColor,
            ContextCompat.getColor(context, R.color.web_white)
        )
        this.subTextBackgroundColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_subTextBackgroundColor,
            ContextCompat.getColor(context, R.color.web_transparent)
        )

        // 底部分割线
        this.bottomLineHeight = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_bottomLineHeight,
            resources.getDimension(R.dimen.hdb_dp1)
        )
        this.bottomLineColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_bottomLineColor,
            ContextCompat.getColor(context, R.color.google_grey500)
        )

        // 按钮
        this.actionParentMargin = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_actionParentMargin,
            resources.getDimension(R.dimen.hdb_dp9)
        )
        this.actionViewPadding = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_actionViewPadding,
            resources.getDimension(R.dimen.hdb_dp4)
        )
        this.actionSpacing = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_actionSpacing,
            resources.getDimension(R.dimen.hdb_dp4)
        )
        this.actionTextSize = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_actionTextSize,
            resources.getDimension(R.dimen.hdb_sp12)
        )
        this.actionTextColor = typedArray.getColor(
            R.styleable.HandyTitlebarStyleable_handy_actionTextColor,
            ContextCompat.getColor(context, R.color.web_white)
        )
        this.actionImageSize = typedArray.getDimension(
            R.styleable.HandyTitlebarStyleable_handy_actionImageSize,
            resources.getDimension(R.dimen.hdb_dp16)
        )

        typedArray.recycle()
    }

    @SuppressLint("PrivateApi")
    private fun getStatusBarHeight(context: Context): Float {
        try {
            val obj = Class.forName("com.android.internal.R\$dimen").newInstance()
            val field = Class.forName("com.android.internal.R\$dimen").getField("status_bar_height")
            return context.resources.getDimension(Integer.parseInt(field.get(obj)!!.toString()))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0f
    }
}