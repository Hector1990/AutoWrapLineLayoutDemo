package cn.wolfspider.autowraplinelayoutdemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import cn.wolfspider.autowraplinelayout.AutoWrapLineLayout;

public class MainActivity extends AppCompatActivity {

    private AutoWrapLineLayout mAutoWrapLineLayout;
    private int[] colors = {android.R.color.holo_red_light, android.R.color.holo_blue_light,
            android.R.color.holo_orange_light, android.R.color.holo_green_light,
            android.R.color.holo_purple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAutoWrapLineLayout = (AutoWrapLineLayout) findViewById(R.id.auto_wrap_line_layout);
        mAutoWrapLineLayout.setFillMode(AutoWrapLineLayout.MODE_WRAP_CONTENT);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Enter some text");
                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String message = input.getText().toString();
                                if (!TextUtils.isEmpty(message)) {
                                    addItem(message);
                                }
                            }
                        });

                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialog.show();
            }
        });
    }

    private void addItem(String message) {
        TextView tv = new TextView(this);
        tv.setText(message);
        Random random = new Random();
        tv.setBackgroundColor(getResources().getColor(colors[random.nextInt(colors.length)]));
        tv.setPadding(DensityUtils.dpToPx(this, 16), 0, DensityUtils.dpToPx(this, 16), 0);
        mAutoWrapLineLayout.addView(tv);
    }
}
