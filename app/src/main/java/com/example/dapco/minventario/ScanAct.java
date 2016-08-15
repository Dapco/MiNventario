package com.example.dapco.minventario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;

public class ScanAct extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.Txt_Id)
    TextView Txt_Id;
    @BindView(R.id.Et_Nom)
    EditText Et_Nom;
    @BindView(R.id.Tipo_lista)
    EditText Tipo_lista;
    @BindView(R.id.Edt_Cant)
    EditText Edt_Cant;
    @BindView(R.id.TxtFecha_Ing)
    TextView Txt_FInicio;
    @BindView(R.id.Edt_fVenc)
    EditText Edt_fVenc;
    @BindView(R.id.Btn_Guardar)
    Button Btn_Guardar;

    private Button Btn_Escan;
    Contdatos cont = new Contdatos(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);


        Btn_Escan = (Button) findViewById(R.id.Btn_Scan);
        Btn_Escan.setOnClickListener(this);

    }

    public void Scan(View v){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        integrator.setPrompt("Scan a barcode");
        integrator.setResultDisplayDuration(0);
        integrator.setWide();  // Wide scanning rectangle, may work better for 1D barcodes
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.initiateScan();
    }

    /**
     * function handle scan result
     * @param requestCode
     * @param resultCode
     * @param intent
     */

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        try {
            if (scanningResult != null) {
                //we have a result
                String scanContent = scanningResult.getContents();
                String scanFormat = scanningResult.getFormatName();

                // display it on screen
                //
                //Txt_FInicio.setText(scanContent);
                Txt_Id.setText(scanContent);

            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "No scan data received!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch(Exception ex){
            Toast.makeText(getApplicationContext(), "error:"+ex, Toast.LENGTH_SHORT);
        } finally {
            Toast.makeText(getApplicationContext(),"No se pudo escanear el cofigo", Toast.LENGTH_SHORT);

        }
    }

    public void onClick(View v){

        switch (v.getId() ){
            case R.id.Btn_Scan:
                Scan(v);
                break;
            case R.id.Btn_Guardar:
                guardar();
                break;
        }

    }

    //se implementa en el onClick, basado en creaFActura(Polacosv3).
    public void guardar(){
        cont.guardar(Et_Nom.getText().toString(),Edt_Cant.getText().toString(), Edt_fVenc.getText().toString());
        Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show();
        ListaClientes.setAdapter(Ui.CargaArrayAdapter(this, CDT.ConsultaClientes()));

        Et_Nom.setText("");
        Edt_Cant.setText("");
        Edt_fVenc.setText("");
    }

}
