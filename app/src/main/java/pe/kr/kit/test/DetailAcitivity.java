package pe.kr.kit.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.kr.kit.test.data.Item;

public class DetailAcitivity extends AppCompatActivity {

    TextView titleTv, contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acitivity);


//        String title = getIntent().getStringExtra("title");
//        String content = getIntent().getStringExtra("content");
        Item item = getIntent().getParcelableExtra("item");

        titleTv = findViewById(R.id.title);
        contentTv = findViewById(R.id.content);

        titleTv.setText(item.title);
        contentTv.setText(item.content);

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}