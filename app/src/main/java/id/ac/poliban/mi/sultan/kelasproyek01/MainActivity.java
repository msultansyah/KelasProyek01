package id.ac.poliban.mi.sultan.kelasproyek01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_STORAGE = 100;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Aplikasi Catatan Proyek 1");
        listview = findViewById(R.id.listview);
        listview.setOnItemClickListener(((parent, view, position, id) -> {
            Map<String, Object> data = (Map<String, Object>) parent.getAdapter().getItem(position);
            Intent intent = new Intent(this, InsertAndViewActivity.class);
            intent.putExtra("filename", data.get("name").toString());
            startActivity(intent);
        }));

        listview.setOnItemClickListener((parent, view, position, id) -> {
            Map<String, Object> data = (Map<String, Object>) parent.getAdapter().getItem(position);
            String namaFile = data.get("name").toString();

            new AlertDialog.Builder(this)
                    .setTitle("Konfirmasi hapus")
                    .setMessage(String.format("hapus catatan %s", namaFile))
                    .setIcon(android)
        });

    }
}
