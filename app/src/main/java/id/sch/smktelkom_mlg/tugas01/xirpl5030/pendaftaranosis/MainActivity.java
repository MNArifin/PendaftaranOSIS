package id.sch.smktelkom_mlg.tugas01.xirpl5030.pendaftaranosis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
    RadioGroup rgJK;
    Spinner spKelas;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb7 = (CheckBox) findViewById(R.id.checkBox7);
        cb8 = (CheckBox) findViewById(R.id.checkBox8);
        cb9 = (CheckBox) findViewById(R.id.checkBox9);
        cb10 = (CheckBox) findViewById(R.id.checkBox10);
        cb11 = (CheckBox) findViewById(R.id.checkBox11);

        findViewById(R.id.buttonDaftar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String hasil2 = null;
        String hasil4 = "Jabatan                   : ";
        int startlen = hasil4.length();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 3) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("Selamat Anda Telah Terdaftar \n Nama                     : " + nama);

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil2 = rb.getText().toString();
        }
        if (hasil2 == null) {
            tvHasil2.setText("Jenis Kelamin            : -");
        } else {
            tvHasil2.setText("Jenis Kelamin            : " + hasil2);
        }

        tvHasil3.setText("Kelas                         : " + spKelas.getSelectedItem().toString());

        if (cb1.isChecked()) hasil4 += cb1.getText() + ", ";
        if (cb2.isChecked()) hasil4 += cb2.getText() + ", ";
        if (cb3.isChecked()) hasil4 += cb3.getText() + ", ";
        if (cb4.isChecked()) hasil4 += cb4.getText() + ", ";
        if (cb5.isChecked()) hasil4 += cb5.getText() + ", ";
        if (cb6.isChecked()) hasil4 += cb6.getText() + ", ";
        if (cb7.isChecked()) hasil4 += cb7.getText() + ", ";
        if (cb8.isChecked()) hasil4 += cb8.getText() + ", ";
        if (cb9.isChecked()) hasil4 += cb9.getText() + ", ";
        if (cb10.isChecked()) hasil4 += cb10.getText() + ", ";
        if (cb11.isChecked()) hasil4 += cb11.getText() + ", ";

        if (hasil4.length() == startlen) hasil4 += "Tidak ada pada Pilihan";
        tvHasil4.setText(hasil4);
    }
}
