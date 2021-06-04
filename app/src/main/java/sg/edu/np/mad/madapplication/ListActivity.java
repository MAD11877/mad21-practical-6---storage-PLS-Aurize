package sg.edu.np.mad.madapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {


    private final static String TAG = "List Activity";
    public static ArrayList<user> Userlist = new ArrayList<user>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG, "On Create list activity!");

        MyDBHandler db = new MyDBHandler(this,null, null ,1 );
        Userlist = db.getUser();
        Log.v(TAG, String.valueOf(Userlist.size()));


        RecyclerView recyclerView = findViewById(R.id.RecycleView);
        BrandsAdaptor mAdapter = new BrandsAdaptor(Userlist,this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start list activity!");
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause list activity!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop list activity!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy list activity!");
    }


}
