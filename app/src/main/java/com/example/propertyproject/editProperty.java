package com.example.propertyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class editProperty extends AppCompatActivity {

    Intent data;
    EditText mediteircode, meditaddress, meditbeds, meditbaths, meditrent, medittenantname, medittenantemail, medittenantphone;
    FloatingActionButton msaveproperty;


    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);

        mediteircode = findViewById(R.id.editeircode);
        meditaddress = findViewById(R.id.editaddress);
        meditbeds = findViewById(R.id.editbeds);
        meditbaths = findViewById(R.id.editbaths);
        meditrent = findViewById(R.id.editrent);
        medittenantname = findViewById(R.id.edittenantname);
        medittenantemail = findViewById(R.id.edittenantemail);
        medittenantphone = findViewById(R.id.edittenantphone);

        msaveproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEircode = mediteircode.getText().toString();
                String newAddress = meditaddress.getText().toString();
                String newBeds = meditbeds.getText().toString();
                String newBaths = meditbaths.getText().toString();
                String newRent = meditrent.getText().toString();
                String newTenantname = medittenantname.getText().toString();
                String newTenantemail = medittenantemail.getText().toString();
                String newTenantphone = medittenantphone.getText().toString();

                if(newEircode.isEmpty() || newAddress.isEmpty() || newBeds.isEmpty() || newBaths.isEmpty()
                || newRent.isEmpty() || newTenantname.isEmpty() || newTenantemail.isEmpty() || newTenantphone.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Not all fields are populated", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    DocumentReference documentReference = firebaseFirestore.collection("properties").document(firebaseUser.getUid()).collection("myProperties").document(data.getStringExtra("propertyId"));
                    Map<String, Object> property = new HashMap<>();
                    property.put("eircode", newEircode);
                    property.put("address", newAddress);
                    property.put("beds", newBeds);
                    property.put("baths", newBaths);
                    property.put("rent", newRent);
                    property.put("tenantName", newTenantname);
                    property.put("tenantEmail", newTenantemail);
                    property.put("tenantPhone", newTenantphone);
                    documentReference.set(property).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Property has been updated", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(editProperty.this, PropertyActivity.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Failed to update", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }
}