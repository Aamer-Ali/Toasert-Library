package aamer.ali.co.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import aamer.ali.co.toastlibrary.ToasterMessage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnSuccess, btnInfo, btnWarning, btnError, btnCustomColor, btnCustomColorWithIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSuccess = findViewById(R.id.btnSuccess);
        btnInfo = findViewById(R.id.btnInfo);
        btnWarning = findViewById(R.id.btnWarning);
        btnError = findViewById(R.id.btnError);
        btnCustomColor = findViewById(R.id.btnCustomColor);
        btnCustomColorWithIcon = findViewById(R.id.btnCustomColorWithIcon);

        btnSuccess.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnWarning.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnCustomColor.setOnClickListener(this);
        btnCustomColorWithIcon.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        if (v == btnSuccess)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, "This is Success Toast", ToasterMessage.LENGTH_LONG, null, null, ToasterMessage.TYPE_SUCCESS);
            toasterMessage.show();
        }
        if (v == btnInfo)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, "This is Info Toast", null, null, null, ToasterMessage.TYPE_INFO);
            toasterMessage.show();
        }
        if (v == btnWarning)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, "This is Warning Toast", null, null, null, ToasterMessage.TYPE_WARNING);
            toasterMessage.show();
        }
        if (v == btnError)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, "This is Error Toast", null, null, null, ToasterMessage.TYPE_ERROR);
            toasterMessage.show();
        }
        if (v == btnCustomColor)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, " This is Custom Color Toast", ToasterMessage.LENGTH_LONG, R.color.colorAccent);
            toasterMessage.show();
        }
        if (v == btnCustomColorWithIcon)
        {
            ToasterMessage toasterMessage = ToasterMessage.makeToast(MainActivity.this, " This is Custom Color with Custom Icon Toast", ToasterMessage.LENGTH_LONG, R.color.colorBlack);
            toasterMessage.show();
        }

    }
}
