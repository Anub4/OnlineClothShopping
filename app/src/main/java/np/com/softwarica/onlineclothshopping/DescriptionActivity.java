package np.com.softwarica.onlineclothshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView tvName, tvPrice, tvDesc;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setTitle("Description");

        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDesc = findViewById(R.id.tvDesc);
        imgView = findViewById(R.id.imgView);

        tvName.setText(getIntent().getStringExtra("name"));
        tvPrice.setText("Rs." + getIntent().getIntExtra("price", 0));
        tvDesc.setText(getIntent().getStringExtra("desc"));
        imgView.setImageResource(getResources().getIdentifier(getIntent().getStringExtra("imageName"), "drawable", getPackageName()));
    }
}
