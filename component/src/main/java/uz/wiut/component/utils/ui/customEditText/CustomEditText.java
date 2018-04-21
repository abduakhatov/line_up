package uz.wiut.component.utils.ui.customEditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import uz.wiut.component.R;

/**
 * Created by Shohruh on 19-Apr-18.
 */

public class CustomEditText extends FrameLayout{

    private TextView tvTitle;
    private RelativeLayout rlBody;
    private TextView tvContent;
    private FrameLayout flRightView;
    private ImageView ivIcon;
    private TextView tvEditTextValue;

    public CustomEditText(@NonNull Context context) {
        super(context);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attrs) {
        addView(LayoutInflater.from(context).inflate(R.layout.view_custom_edittext, null, false));

        rlBody = findViewById(R.id.rlBody);
        tvContent = findViewById(R.id.tvContent);
        flRightView = findViewById(R.id.flRightView);
        ivIcon = findViewById(R.id.ivIcon);
        tvEditTextValue = findViewById(R.id.tvEditTextValue);
        setIcon(R.drawable.ic_android_black_24dp);

        final TypedArray typedArr = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0);

        String title = typedArr.getString(R.styleable.CustomEditText_title);
        if (title == null || title == "") {
             String hint = typedArr.getString(R.styleable.CustomEditText_hint);
            tvContent.setHint(hint != null ? hint : "Hint");
            tvContent.setText(null);
        } else {
            tvContent.setHint(null);
            tvContent.setText(null);
        }

         boolean rightContVisblty = typedArr.getBoolean(R.styleable.CustomEditText_hideRightContainer, false);
        if (rightContVisblty) {
            flRightView.setVisibility( View.VISIBLE );

             boolean iconVisblt = typedArr.getBoolean(R.styleable.CustomEditText_iconHide, false);
            if (iconVisblt) {
                ivIcon.setVisibility(View.GONE);
                tvEditTextValue.setVisibility(View.VISIBLE);

                 String rightText = typedArr.getString(R.styleable.CustomEditText_setRigthText);
                tvEditTextValue.setText( (rightText != null || rightText != "") ? rightText : "Content" );
            } else {
                ivIcon.setVisibility(View.VISIBLE);
//                         iconSrc = typedArr.getDrawable(R.styleable.CustomEditText_setIcon)
//                        ivIcon.setImageDrawable(if(iconSrc!=null) iconSrc else ivIcon.drawable)
                tvEditTextValue.setVisibility(View.GONE);
            }
        } else {
            flRightView.setVisibility(View.GONE);
        }

        tvContent.setInputType( (typedArr.getBoolean(R.styleable.CustomEditText_isPassword, false)) ? InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT );
        typedArr.recycle();

    }

    public void setIcon(int drawable) {
        ivIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), drawable));
    }

    public void changeInputType(int inputType){
        tvContent.setInputType(inputType);
    }

    public String getText(){
        return tvContent.getText().toString();
    }
}
