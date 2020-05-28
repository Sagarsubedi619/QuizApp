package mnstate.example.projecttwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class categories extends AppCompatActivity {
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview=findViewById(R.id.rv);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        //temporary

        List<categoryModel>list=new ArrayList<>();
        list.add(new categoryModel("https://www.groovypost.com/wp-content/uploads/2018/10/woman_writing_computer_featured.jpg","Computers"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Mathematics"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Science"));
        list.add(new categoryModel("https://www.proprofs.com/quiz-school/topic_images/p1bgcucu5418fp1l1e1nk2n9gch13.jpg","Computer Programming"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Health"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Business"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Management"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Disease"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Movies"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","History"));
        list.add(new categoryModel("https://previews.123rf.com/images/roxanabalint/roxanabalint1612/roxanabalint161200147/67233408-work-in-progress-grunge-rubber-stamp-on-white-background-vector-illustration.jpg","Animals"));




        recyclerview.setLayoutManager(layoutManager);

        CatAdapter adapter=new CatAdapter(list);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
