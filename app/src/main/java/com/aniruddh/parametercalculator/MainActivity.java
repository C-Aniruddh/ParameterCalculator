package com.aniruddh.parametercalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.aniruddh.parametercalculator.technologies.Tech018;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = getValues();
                new MaterialStyledDialog.Builder(MainActivity.this)
                        .setTitle("Calculated Values : ")
                        .setDescription(message)
                        .show();
            }
        });
    }

    public String getValues(){
        EditText toxField = (EditText) findViewById(R.id.toxField);
        EditText uonField = (EditText) findViewById(R.id.uonField);
        EditText uopField = (EditText) findViewById(R.id.uopField);
        EditText vtnField = (EditText) findViewById(R.id.vtnField);
        EditText vtpField = (EditText) findViewById(R.id.vtpField);
        EditText vsatField = (EditText) findViewById(R.id.vsatField);
        EditText lengthField = (EditText) findViewById(R.id.lengthField);
        EditText irefFrield = (EditText) findViewById(R.id.irefField);
        //Code here
        float tox = (float) (Float.valueOf(String.valueOf(toxField.getText()))*Math.pow(10, -9));
        float uon = Float.valueOf(String.valueOf(uonField.getText()));
        float uop = Float.valueOf(String.valueOf(uopField.getText()));
        float vtn = Float.valueOf(String.valueOf(vtnField.getText()));
        float vtp = Float.valueOf(String.valueOf(vtpField.getText()));
        float vsat = (float) (Float.valueOf(String.valueOf(vsatField.getText()))*Math.pow(10, -3));
        float length = (float) (Float.valueOf(String.valueOf(lengthField.getText()))*Math.pow(10, -6));
        float iref = (float) (Float.valueOf(String.valueOf(irefFrield.getText()))*Math.pow(10, -6));

        Tech018 t = new Tech018(tox, uon, uop, vtn, vtp, vsat, length, iref);

        float kp = (float) t.getKp();
        float kn = (float) t.getKn();
        float wn = (float) t.getWn();
        float wp = (float) t.getWp();

        String kp_actual = "Kp = " + kp;
        String kp_readable = " = " + String.format("%.2f", kp*Math.pow(10, 6)) + "uA/V²";
        String kp_f = kp_actual + kp_readable + "\n";

        String kn_actual = "Kn = " + kn;
        String kn_readable = " = " + String.format("%.2f", kn*Math.pow(10, 6)) + "uA/V²";
        String kn_f = kn_actual + kn_readable + "\n";

        String wn_f = "Wn = " + wn + " micron\n";
        String wp_f = "Wp = " + wp + " micron\n";

        String print_f = kp_f + kn_f + wn_f + wp_f;
        return print_f;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
