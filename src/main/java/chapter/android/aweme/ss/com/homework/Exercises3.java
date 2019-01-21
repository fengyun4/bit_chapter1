package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity implements MyAdapter.ListItemClickListener {

    private static final String TAG = "This is the Exercise_third";

    private MyAdapter myAdapter;
    public List<Message>messages;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        recyclerView=findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter=new MyAdapter(messages, this);

        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent=new Intent(this,Chatroom.class);
        intent.putExtra("message",messages.get(clickedItemIndex).getTitle());
        startActivity(intent);
    }
}
