package sg.edu.np.mad.madapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private final static String TAG = "Main Activity";
    MyDBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");
        db = MyDBHandler.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    protected void onResume() {

        Intent receivedData = getIntent();
        int user_pos = receivedData.getIntExtra("User position",0);
        user user = Userlist.get(user_pos);
        Button button = findViewById(R.id.button3);
        TextView hello =findViewById(R.id.hello);
        TextView des = findViewById(R.id.textView);
        des.setText(user.getDescription());
        hello.setText("Hello " + user.getName() + user.getId());
        Log.v(TAG, toString().valueOf(user.isFollowed()));

        if (user.isFollowed() == false){
            button.setText("Follow");
        }
        else{
            button.setText("Unfollow");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed() == false){

                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                    button.setText("Unfollow");
                    user.setFollowed(true);
                    Log.v(TAG, "Followed toast dialog");
                    Log.v(TAG, toString().valueOf(user.isFollowed()));
                    db.updateUser(user);
                }
                else{
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                    button.setText("Follow");
                    user.setFollowed(false);
                    Log.v(TAG, "Unfollowed toast dialog");
                    Log.v(TAG, toString().valueOf(user.isFollowed()));
                    db.updateUser(user);

                }
            }
        });
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy!");
    }

}