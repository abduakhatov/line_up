package uz.wiut.component.utils.ui

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.widget.PopupMenu
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*

import uz.wiut.component.R

/**
 * Created by Shohruh on 22-Mar-18.
 */

class CustomEditText @JvmOverloads
constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
    : FrameLayout (context, attrs, defStyleAttr), View.OnClickListener {

    private lateinit var tvTitle: TextView
    private lateinit var rlBody: RelativeLayout
    private lateinit var tvContent: TextView
    private lateinit var flRightView: FrameLayout
    private lateinit var ivIcon: ImageView
    private lateinit var tvEditTextValue: TextView

    private var listener: CustomEditTextListener? = null

    init {
        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false))

        attrs?.let {
            var typedArr = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0)
            try {
                var title = typedArr.getString(R.styleable.CustomEditText_title)
                if (title == null || title == ""){
                    var hint = typedArr.getString(R.styleable.CustomEditText_hint)
                    tvContent.hint = if(hint != null) hint else "Hint"
                    tvContent.text = null
                } else{
                    tvContent.hint = null
                    tvContent.text = title
                }

                var rightContVisblty = typedArr.getBoolean(R.styleable.CustomEditText_hideRightContainer, false)
                if (rightContVisblty){
                    flRightView.visibility = View.VISIBLE

                    var iconVisblt = typedArr.getBoolean(R.styleable.CustomEditText_iconHide, false)
                    if (iconVisblt) {
                        ivIcon.visibility = View.GONE
                        tvEditTextValue.visibility = View.VISIBLE

                        var rightText = typedArr.getString(R.styleable.CustomEditText_setRigthText)
                        tvEditTextValue.text = if (rightText != null || rightText != "") rightText else "Content"
                    } else {
                        ivIcon.visibility = View.VISIBLE
//                        var iconSrc = typedArr.getDrawable(R.styleable.CustomEditText_setIcon)
//                        ivIcon.setImageDrawable(if(iconSrc!=null) iconSrc else ivIcon.drawable)
                        tvEditTextValue.visibility = View.GONE
                    }
                }
                else {
                    flRightView.visibility = GONE
                }

                var inputType = if ( typedArr.getBoolean(R.styleable.CustomEditText_setIcon, false) ) InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_CLASS_TEXT
                tvContent.inputType = inputType
            } finally {
                typedArr.recycle()
            }
        }
    }

//    constructor(context: Context) : super(context) {
//        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false))
////        init()
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false))
////        init()
//    }
//
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false))
////        init()
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
//        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false))
////        init()
//    }

    private fun init() {
        rlBody = findViewById(R.id.rlBody)
        tvContent = findViewById(R.id.tvContent)
        flRightView = findViewById(R.id.flRightView)
        ivIcon = findViewById(R.id.ivIcon)
        tvEditTextValue = findViewById(R.id.tvEditTextValue)
        setIcon()
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        init()
    }

    override fun onClick(view: View) {
        if (listener != null)
            listener!!.click()
    }

    fun setSpinnerListener(listener: CustomEditTextListener) {
        this.listener = listener
    }

    fun setIcon(){
        ivIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_pass));
    }

}