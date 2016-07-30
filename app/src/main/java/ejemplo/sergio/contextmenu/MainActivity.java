package ejemplo.sergio.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
 int  item_selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.listView);
        registerForContextMenu(lista);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu, v, menuinfo);

        MenuInflater menuinflater= getMenuInflater();
        menuinflater.inflate(R.menu.contextmenu, menu);
        MenuItem uno = menu.findItem(R.id.item1);
        MenuItem dos = menu.findItem(R.id.item2);

        if(item_selection ==1){
            uno.setChecked(true);

        }else if(item_selection==2){
            dos.setChecked(true);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch ( item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "ha seleccionado mostrar " + item, Toast.LENGTH_SHORT).show();
                item.setChecked(true);

                item_selection = 1;
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "ha seleccionado borrar " + item, Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                item_selection = 2;
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }




}

