package mx.fing.uach.proyecto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import mx.fing.uach.proyecto3.models.CV;

public class Curriculum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView txtNm = findViewById(R.id.txtNm);
        TextView txtB = findViewById(R.id.txtB);
        TextView txtSklls = findViewById(R.id.txtSklls);
        TextView txtDccn = findViewById(R.id.txtDccn);

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CV cv = new Gson().fromJson(response.toString(), CV.class);
                txtNm.setText(cv.name);
                txtB.setText(cv.bio);
                txtSklls.setText(cv.skills);
                txtDccn.setText(cv.education);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(sr);

    }
}