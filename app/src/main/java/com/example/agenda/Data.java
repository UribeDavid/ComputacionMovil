package com.example.agenda;

import android.support.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Data {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference contactsFirebase = database.getReference("contacts");
    private static ArrayList<Contact> Contacts = new ArrayList<>();

    //public static void Save(Contact c){Contacts.add(c);}
    public static void Save(Contact c){
        contactsFirebase.push().setValue(c);
    }


    public static void sync(){
        contactsFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Contacts.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    Contacts.add(child.getValue(Contact.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public static ArrayList<Contact> Get(){
        return Contacts;
    }
}
