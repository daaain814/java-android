package pe.kr.kit.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.kr.kit.test.data.Item;

public class DetailAcitivity extends AppCompatActivity {

    TextView titleTv, contentTv;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acitivity);


//        String title = getIntent().getStringExtra("title");
//        String content = getIntent().getStringExtra("content");
        item = getIntent().getParcelableExtra("item");

        titleTv = findViewById(R.id.title);
        contentTv = findViewById(R.id.content);

        titleTv.setText(item.title);
        contentTv.setText(item.content);

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 작업할 예정
                //1.외부
                //2.내부(final)
                if(item!=null) {
                    int id = item.id;
                    Log.d("TEST", "delete click id => " + id);
                    Intent intent = new Intent();
                    intent.putExtra("mode", "delete");
                    intent.putExtra("id", id);
                    setResult(RESULT_OK, intent);

                    finish();
                }

            }
        });

    }
}