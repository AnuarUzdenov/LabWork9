import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private float rotation = 0f;
    private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.image1) {
            imageView.setImageResource(imageResources[0]);
            return true;
        } else if (id == R.id.image2) {
            imageView.setImageResource(imageResources[1]);
            return true;
        } else if (id == R.id.image3) {
            imageView.setImageResource(imageResources[2]);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.rotate_clockwise) {
            rotation += 90f;
            imageView.setRotation(rotation);
            return true;
        } else if (id == R.id.rotate_counter_clockwise) {
            rotation -= 90f;
            imageView.setRotation(rotation);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}