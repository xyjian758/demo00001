package demo00001.example.com.demo00001.widge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;

/**
 * Created by DELL on 2017/2/9.
 */

public class InputEditText extends EditText {
    private Context mContext;//上线文

    private int passwordLength = 5;//密码长度

    private Paint linePaint;//下面线
    private Paint passwordPaint;//文字
    private String text;//输入的文字
    private int textLength;//输入的文字长度

    private int jiangeWidth;//间隔的宽度
    private int jiangeHeight;//间隔的高度

    private int width;//当前控件的宽度
    private int height;//当前控件的高度
    private int textWidth;//文字的宽度
    private IWatchLetterNum iWatchLetterNum;//接口对象，回调监听

    public InputEditText(Context context) {
        super(context);
    }

    public InputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        initLinePaint();

        initPasswordPaint();

        //间隔的宽
        jiangeWidth = DisplayUtil.dip2px(context, 10f);
        //间隔的高
        jiangeHeight = DisplayUtil.dip2px(context, 15f);

    }

    private void initPasswordPaint() {
        passwordPaint = new Paint(ANTI_ALIAS_FLAG);
        passwordPaint.setStyle(Paint.Style.FILL);
        passwordPaint.setColor(Color.parseColor("#212121"));
        passwordPaint.setTextSize(DisplayUtil.sp2px(mContext, 24f));
    }

    private void initLinePaint() {
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#212121"));//设置下划线颜色
        linePaint.setStrokeWidth(DisplayUtil.dip2px(mContext, 1f));

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

        this.text = text.toString();
        this.textLength = text.toString().length();
        if (null != iWatchLetterNum) {
            if (this.textLength >= passwordLength) {//设置回调
                iWatchLetterNum.is4Letter(true, this.text);
            } else if (this.textLength == passwordLength - 1) {
                iWatchLetterNum.is4Letter(false, this.text);
            }else {}
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
        textWidth = (width - jiangeWidth * (passwordLength - 1)) / passwordLength;
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        //下划线
        for (int i = 0; i < passwordLength; i++) {
            paramCanvas.drawLine(textWidth * i + jiangeWidth * i, height, textWidth * (i + 1) + jiangeWidth * i, height, linePaint);
        }

        // 验证码
        if (TextUtils.isEmpty(text)) {
            return;
        }
        String substring = "";
        for (int i = 0; i < textLength; i++) {
            substring = text.substring(i, i + 1);
            paramCanvas.drawText(substring, textWidth * i + jiangeWidth * i + textWidth * 1 / 3, height - jiangeHeight, passwordPaint);
        }
    }

    public void setIWatchLetterNum(IWatchLetterNum iWatchLetterNum) {
        this.iWatchLetterNum = iWatchLetterNum;
    }


    public interface IWatchLetterNum {
        void is4Letter(Boolean b, String text);//是否 有4个字符
    }


}
