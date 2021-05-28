package mx.fing.uach.proyecto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "mx.fing.uach.proyecto3.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendUrlDali(View view) {
        Intent intent = new Intent(this, Curriculum.class);
        String message = "https://e65f148e9ebd.ngrok.io/329881";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendUrlCota(View view) {
        Intent intent = new Intent(this, Curriculum.class);
        String message = "https://e65f148e9ebd.ngrok.io/329701";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}