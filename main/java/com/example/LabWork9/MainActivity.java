import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView numberTextView;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.numberTextView);
        registerForContextMenu(numberTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.colorRed:
                numberTextView.setTextColor(Color.RED);
                Toast.makeText(this, "Текст изменен на красный", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.colorGreen:
                numberTextView.setTextColor(Color.GREEN);
                Toast.makeText(this, "Текст изменен на зеленый", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.colorBlue:
                numberTextView.setTextColor(Color.BLUE);
                Toast.makeText(this, "Текст изменен на синий", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.increase:
                number += 10;
                numberTextView.setText(String.valueOf(number));
                Toast.makeText(this, "Число увеличено на 10", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.decrease:
                number -= 10;
                numberTextView.setText(String.valueOf(number));
                Toast.makeText(this, "Число уменьшено на 10", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
