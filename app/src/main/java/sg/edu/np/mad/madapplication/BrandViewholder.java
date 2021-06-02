package sg.edu.np.mad.madapplication;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class BrandViewholder extends RecyclerView.ViewHolder {
    TextView name;
    TextView id;
    TextView Description;
    ImageView image;

    public BrandViewholder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView2);
        id = itemView.findViewById(R.id.textView3);
        Description = itemView.findViewById(R.id.textView5);
        image = itemView.findViewById(R.id.imageView2);
    }
}

