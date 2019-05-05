package np.com.softwarica.onlineclothshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etName, etPrice, etDesc;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setTitle("Add Item");

        spinner = findViewById(R.id.spinner);
        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        etDesc = findViewById(R.id.etDesc);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageName = spinner.getSelectedItem().toString();
                String name = etName.getText().toString();
                String price = etPrice.getText().toString();
                String desc = etDesc.getText().toString();

                try {
                    PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE | MODE_APPEND));
                    printStream.println(name + "->" + price + "->" + desc + "->" + imageName);
                    Toast.makeText(AddItemActivity.this, "Saved.", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(AddItemActivity.this, "Failed to save item.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
