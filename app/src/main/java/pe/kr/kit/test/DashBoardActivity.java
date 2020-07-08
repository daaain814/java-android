package pe.kr.kit.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pe.kr.kit.test.adapters.MainAdapter;
import pe.kr.kit.test.data.Item;

public class DashBoardActivity extends AppCompatActivity {

    //1. ListView View 생성 -> 완료
    //2. ListView 바인딩 -> 바인딩
    //3. Data 클래스 생성 -> 완료
    //4. ListView Adapter 생성
    //5. ListView에 Adatper 연결
    //6. ListView에 클릭 이벤트 추가

    ListView lv;
    List<Item> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        lv = findViewById(R.id.liseview);
        list = makeData();
        Log.d("TEST", "list size : " + list.size());

        MainAdapter myAdapter = new MainAdapter(DashBoardActivity.this, list);
        lv.setAdapter(myAdapter);


    }

    private List<Item> makeData() {
        // 데이터를 생성합니다
        //여러개의 아이템을 만든다
        //반복문을 사용해서 여러개의 아이템을 추가
        List list = new ArrayList<Item>();
        for (int i=0; i<10; i++) {
            Item item = new Item("title" + i, "content1" + i);
            list.add(item);
        }
        return list;
    }

}