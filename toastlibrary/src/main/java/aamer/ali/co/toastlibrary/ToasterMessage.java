package aamer.ali.co.toastlibrary;

import android.app.Activity;
import android.app.job.JobInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;

public class ToasterMessage extends Toast
{
    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_INFO = 2;
    public static final int TYPE_WARNING = 3;
    public static final int TYPE_ERROR = 4;

    public static int LENGTH_LONG = Toast.LENGTH_LONG;
    public static int LENGTH_SHORT = Toast.LENGTH_SHORT;

    private Context mContext;
    private View view;
    private int type;

    public ToasterMessage(Context mContext)
    {
        super(mContext);
        this.mContext = mContext;
    }

    public static ToasterMessage makeToast(Context context, String message)
    {
        return makeToast(context, message, LENGTH_SHORT, null, null, TYPE_INFO);
    }

    public static ToasterMessage makeToast(Context context, String message, Integer duration)
    {
        return makeToast(context, message, duration, null, null, TYPE_INFO);
    }

    public static ToasterMessage makeToast(Context context, String message, Integer duration, Integer colorId)
    {
        return makeToast(context, message, duration, colorId, null, TYPE_INFO);
    }

    public static ToasterMessage makeToast(Context context, String message, Integer duration, Integer colorId, Integer icon)
    {
        return makeToast(context, message, duration, colorId, icon, TYPE_INFO);
    }

    public static ToasterMessage makeToast(Context context, String message, Integer duration, Integer colorId, Integer icon, Integer type)
    {
        ToasterMessage toasterMessage = new ToasterMessage(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_toast_view, null);

        ImageView mIcon = view.findViewById(R.id.iconToast);
        TextView tvMessage = view.findViewById(R.id.tvMessage);

        if (colorId == null)
        {
            switch (type)
            {
                case TYPE_SUCCESS:
                    mIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_check_circle_white));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    {
                        view.setBackground(ContextCompat.getDrawable(context, R.drawable.success_background));
                    }
                    else
                    {
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSuccess));
                    }
                    break;

                case TYPE_INFO:
                    mIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_info_white));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    {
                        view.setBackground(ContextCompat.getDrawable(context, R.drawable.info_background));
                    }
                    else
                    {
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorInfo));

                    }
                    break;

                case TYPE_WARNING:
                    mIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_warning_white));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    {
                        view.setBackground(ContextCompat.getDrawable(context, R.drawable.warning_background));
                    }
                    else
                    {
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWarning));

                    }
                    break;

                case TYPE_ERROR:
                    mIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_error_white));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    {
                        view.setBackground(ContextCompat.getDrawable(context, R.drawable.error_background));
                    }
                    else
                    {
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorError));
                    }
                    break;
            }
        }
        else
        {
            if (icon == null)
            {
//                mIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_check_circle_white));
                mIcon.setVisibility(View.GONE);
            }
            else
            {
                mIcon.setBackgroundResource(icon);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            {
                Drawable tempDrawable = context.getResources().getDrawable(R.drawable.default_background);
                LayerDrawable bubble = (LayerDrawable) tempDrawable;
                GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.defaultToastBg);
                solidColor.setColor(context.getResources().getColor(colorId));
                view.setBackground(ContextCompat.getDrawable(context, R.drawable.default_background));
            }
            else
            {
                view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorInfo));
            }
        }

        tvMessage.setText(message);
        if(duration != null)
        {
            toasterMessage.setDuration(duration);
        }
        toasterMessage.setView(view);
        toasterMessage.view = view;
        if (type != null)
        {
            toasterMessage.type = type;
        }
        return toasterMessage;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
