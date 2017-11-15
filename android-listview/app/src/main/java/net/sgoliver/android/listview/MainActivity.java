package net.sgoliver.android.listview;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private TextView lblEtiqueta;
    private ListView lstOpciones;

    private Alumno[] datos =
            new Alumno[]{
                    new Alumno("Garrido", "Alejandro", "2º", "DAM"),
                    new Alumno("Garrido", "Juan Manuel", "2º", "DAM"),
                    new Alumno("Calado", "Carlos", "2º", "DAM"),
                    new Alumno("Hernandez", "Daniel", "2º", "DAM"),
                    new Alumno("Arroyo", "Francisco", "2º", "DAM"),
                    new Alumno("Ramos", "Maikel", "2º", "DAM"),
                    new Alumno("Nuez", "Guillermo", "2º", "DAM"),};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ejemplo básico
        //final String[] datos =
        //        new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        //
        //ArrayAdapter<String> adaptador =
        //        new ArrayAdapter<String>(this,
        //                android.R.layout.simple_list_item_1, datos);
        //
        //lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        //
        //lstOpciones.setAdapter(adaptador);

        lblEtiqueta = (TextView)findViewById(R.id.LblEtiqueta);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        //Cabecera
        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones.addHeaderView(header);

        //Adaptador
        AdaptadorAlumno adaptador =
                new AdaptadorAlumno(this, datos);

        lstOpciones.setAdapter(adaptador);

        //Eventos
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Alumno)a.getItemAtPosition(position)).getApellidos();

                //Alternativa 2:
                //String opcionSeleccionada =
                //		((TextView)v.findViewById(R.id.LblTitulo))
                //			.getText().toString();

                lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class AdaptadorAlumno extends ArrayAdapter<Alumno> {

        public AdaptadorAlumno(Context context, Alumno[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;

            if (item == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.listitem_titular, null);
            }
            TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
            lblNombre.setText(datos[position].getApellidos()+" "+datos[position].getNombre());

            TextView lblNivel = (TextView)item.findViewById(R.id.LblNivel);
            lblNivel.setText(datos[position].getClase()+" "+datos[position].getNivel());

            return(item);
        }
    }
}
