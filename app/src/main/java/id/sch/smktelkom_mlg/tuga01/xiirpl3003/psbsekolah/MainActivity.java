package id.sch.smktelkom_mlg.tuga01.xiirpl3003.psbsekolah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etAlamat;
    RadioButton rbL, rbP;
    CheckBox cbsmp, cbmts;
    EditText etAsalSekolah;
    Spinner spJalur;
    TextView tvHasil1, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvHasil6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editnama);
        etAlamat = (EditText) findViewById(R.id.editalamat);
        rbL = (RadioButton) findViewById(R.id.laki);
        rbP = (RadioButton) findViewById(R.id.perempuan);
        cbsmp = (CheckBox) findViewById(R.id.smp);
        cbmts = (CheckBox) findViewById(R.id.mts);

        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if(isValid()) {
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            tvHasil1.setText("Nama : " + nama + "Alamat : " + alamat);
        }

        String hasil = null;
        if (rbL.isChecked()) {
            hasil = rbL.getText().toString();
        } else if (rbP.isChecked()) {
            hasil = rbP.getText().toString();
        }

        if (hasil == null) {
            tvHasil2.setText("Belum memilih Status");
        } else {
            tvHasil2.setText("Jenis Kelamin : " + hasil);
        }

        String hasill="Asal Sekolah : ";
        int startlen = hasill.length();
        if(cbsmp.isChecked()) hasill+=cbsmp.getText().toString();
        if(cbmts.isChecked()) hasill+=cbmts.getText().toString();

        if(hasill.length()==startlen) hasill+="Tidak ada pada Pilihan";
        tvHasil3.setText(hasill);

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        return valid;
    }
}
