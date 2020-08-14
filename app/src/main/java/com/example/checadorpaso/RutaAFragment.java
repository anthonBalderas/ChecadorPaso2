package com.example.checadorpaso;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class RutaAFragment extends Fragment {

    private EditText editUnidad;
    private Spinner SpinnerRuta;
    private Button btnRegistar,btnRegistrar2;
    private TextView txtHora, txtHora2, txtHora3,unidadTxt;
    RecyclerView recyclerViewA;
    SQLiteDatabase mDatabase;
    RutaAAdapter mAdapter;

    ArrayList<Tiempos> tiemposList = new ArrayList<Tiempos>();

    View vista;


    public RutaAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_ruta_a, container, false);

        UnidadesDBHelper dbHelper = new UnidadesDBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();


        btnRegistrar2 = vista.findViewById(R.id.button_add23);
        btnRegistar = vista.findViewById(R.id.button_add2);
        SpinnerRuta = vista.findViewById(R.id.rutas_spinner);
        txtHora = vista.findViewById(R.id.tvHora);
        txtHora2 = vista.findViewById(R.id.tvHora2);
        txtHora3 = vista.findViewById(R.id.tvHora3);
        unidadTxt = vista.findViewById(R.id.unidadTxt);
        editUnidad = vista.findViewById(R.id.edittext_unidad);
        recyclerViewA = vista.findViewById(R.id.recyclerViewA);


        recyclerViewA.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RutaAAdapter(getContext(), getAllItems());
        recyclerViewA.setAdapter(mAdapter);

      //  crearListaRuta();

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarHora();
                addItem();
                tiempo1();
                obtenerUnidad();
                imprimirDiferencia();
        btnRegistar.setVisibility(View.INVISIBLE);
        btnRegistrar2.setVisibility(View.VISIBLE);

            }
        });

        btnRegistrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarHora();
                addItem();
                tiempo2();
                obtenerUnidad();
                imprimirDiferencia();

                btnRegistrar2.setVisibility(View.INVISIBLE);
                btnRegistar.setVisibility(View.VISIBLE);
            }
        });
        return vista;


    }

    private Cursor getAllItems() {

        return mDatabase.query(
                UnidadesContract.UnidadesEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                UnidadesContract.UnidadesEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }
    public void obtenerUnidad(){
        String unidad="";
        unidad = editUnidad.getText().toString();

        unidadTxt.setText(unidad);
        editUnidad.getText().clear();

    }
    private void registrarHora() {

        SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
        Date horaRegistro = Calendar.getInstance().getTime();

        String horaa = formato.format(horaRegistro);
        txtHora2.setText(horaa);

    }

    public void tiempo1() {
        SimpleDateFormat formato = new SimpleDateFormat("mm");
        Date horaRegistro = Calendar.getInstance().getTime();

        String horaa = formato.format(horaRegistro);

        txtHora.setText(horaa);

    }

    public void tiempo2() {
        SimpleDateFormat formato = new SimpleDateFormat("mm");
        Date horaRegistro = Calendar.getInstance().getTime();

        String horaa = formato.format(horaRegistro);

        txtHora3.setText(horaa);

    }

    public void imprimirDiferencia(){


int tiempo1;
int tiempo2;

String a = txtHora.getText().toString().trim();
String b = txtHora3.getText().toString().trim();

if (b.isEmpty()) {

    Toast.makeText(getContext(), "Va de primero", Toast.LENGTH_SHORT).show();
}else {
    tiempo1 = Integer.parseInt(a);
    tiempo2 = Integer.parseInt(b);
    String unidad = unidadTxt.getText().toString();

    int restante = tiempo2 - tiempo1;
    Toast.makeText(getContext(),  restante+" Minutos de diferencia", Toast.LENGTH_SHORT).show();

}



    }
    private void addItem() {

        String unidad = editUnidad.getText().toString();
        String hora = txtHora2.getText().toString();
        String ruta = SpinnerRuta.getSelectedItem().toString();


        ContentValues cv = new ContentValues();
        cv.put(UnidadesContract.UnidadesEntry.COLUMN_HORA, hora);
        cv.put(UnidadesContract.UnidadesEntry.COLUMN_UNIDAD, unidad);
        cv.put(UnidadesContract.UnidadesEntry.COLUMN_RUTA, ruta);

        mDatabase.insert(UnidadesContract.UnidadesEntry.TABLE_NAME, null, cv);
        mAdapter.swapCursor(getAllItems());

        ContentValues cvHist = new ContentValues();
        cvHist.put(UnidadesContract.UnidadesEntry4.COLUMN_HORA, hora);
        cvHist.put(UnidadesContract.UnidadesEntry4.COLUMN_UNIDAD, unidad);
        cvHist.put(UnidadesContract.UnidadesEntry4.COLUMN_RUTA, ruta);
        mDatabase.insert(UnidadesContract.UnidadesEntry4.TABLE_NAME, null, cvHist);




    }
/*
    public void crearListaRuta() {
        ArrayList<String> rutaList = new ArrayList<>();
        rutaList.add("3");
        rutaList.add("3 Reyes Portillo");
        rutaList.add("3 Reyes Andres Q.roo");
        rutaList.add("3 Reyes Nichupte");
        rutaList.add("4");
        rutaList.add("5");
        rutaList.add("6");
        rutaList.add("7X4");
        rutaList.add("8");
        rutaList.add("10");
        rutaList.add("11");
        rutaList.add("14");
        rutaList.add("15");
        rutaList.add("15-B");
        rutaList.add("15-C");
        rutaList.add("17");
        rutaList.add("18-A");
        rutaList.add("19");
        rutaList.add("21");
        rutaList.add("23");
        rutaList.add("33");
        rutaList.add("44");
        rutaList.add("48");
        rutaList.add("60");
        rutaList.add("68");
        rutaList.add("69");
        rutaList.add("71");
        rutaList.add("78");
        rutaList.add("80");
        rutaList.add("81");
        rutaList.add("87");
        rutaList.add("90");
        rutaList.add("94");
        rutaList.add("95-96");
        rutaList.add("95-96 Andres Quintana Roo");
        rutaList.add("97 - 99 Itzales");
        rutaList.add("97 - 99 Jardines");
        rutaList.add("97 - 99 Poligono");
        rutaList.add("100");
        rutaList.add("102 Palmas");
        rutaList.add("103");
        rutaList.add("227");
        rutaList.add("236");
        rutaList.add("259");
        rutaList.add("295");
        rutaList.add("510");
        rutaList.add("Avante Portillo");
        rutaList.add("Avante Nichupte");
        rutaList.add("Avante Andres Q,roo");
        rutaList.add("Bonfil");
        rutaList.add("Guayacan");
        rutaList.add("Kusamil");
        rutaList.add("La Joya");
        rutaList.add("Leona Vicario");
        rutaList.add("México");
        rutaList.add("Milagro Nichupte");
        rutaList.add("Milagro Portillo");
        rutaList.add("Milagro Andres Q.roo");
        rutaList.add("Niños Heroes");
        rutaList.add("Paraiso Maya Portillo");
        rutaList.add("Paraiso Maya Quintana. Roo");
        rutaList.add("Paraiso Maya Nichupte");
        rutaList.add("Playa Blanca");
        rutaList.add("Portillo");
        rutaList.add("Puerto Juarez");
        rutaList.add("Sta Cecilia Portillo");
        rutaList.add("Sta Cecilia Andres Q.roo");
        rutaList.add("Sta Cecilia Nichupte");
        rutaList.add("Talleres");
        rutaList.add("Tierra Maya");
        rutaList.add("Torito");
        rutaList.add("Urbi Nichupte");
        rutaList.add("Urbi Portillo");
        rutaList.add("Urbi Andres Q.roo");
        rutaList.add("Valle Verde Portillo");
        rutaList.add("Valle Verde Andres Q.roo");
        rutaList.add("Valle Verde Nichupte");
        rutaList.add("Villas del Mar");

        SpinnerRuta.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, rutaList));
        SpinnerRuta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                } else {
                    String sNumeroRuta = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }*/
}
