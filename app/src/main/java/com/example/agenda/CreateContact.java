package com.example.agenda;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateContact extends AppCompatActivity {
    private EditText Name, LastName, Phone, Cellphone;
    private Resources Resources;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_contact);

        Name = (EditText)findViewById(R.id.TxtName);
        LastName = (EditText)findViewById(R.id.TxtLastName);
        Phone = (EditText)findViewById(R.id.TxtPhone);
        Cellphone = (EditText)findViewById(R.id.TxtCellphone);
        Resources = this.getResources();
    }

    public void Save(View view){
        contacts = Data.Get();
        String NameV, LastNameV, PhoneV, CellphoneV;
        int ID;

        ID = contacts.size()+1;
        NameV = Name.getText().toString();
        LastNameV = LastName.getText().toString();
        PhoneV = Phone.getText().toString();
        CellphoneV = Cellphone.getText().toString();

        Contact C = new Contact(ID, NameV, LastNameV, PhoneV, CellphoneV);
        C.SaveContact();
        Toast.makeText(this, R.string.done, Toast.LENGTH_LONG).show();
        contacts.clear();
    }
}
