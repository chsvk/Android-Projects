package com.example.vamshi.baseimage;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView ig;
    private StorageReference mStorageRef;
    public List<LinkObject> links;
    public RecyclerView myView;
    public RecyclerView.Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ig = (ImageView) findViewById(R.id.image);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        links = new ArrayList<>();
        myView = (RecyclerView)findViewById(R.id.myView);
        myView.setHasFixedSize(true);
        myView.setLayoutManager(new LinearLayoutManager(this));

         for (int i = 1; i <9; i++) {
             final int j = i;
            String link = "TestImages/" + i + ".jpg";
            mStorageRef.child(link).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    //Toast.makeText(MainActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
                    LinkObject newObject = new LinkObject(uri.toString().trim(),1);
                    links.add(newObject);
                    myAdapter.notifyDataSetChanged();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Toast.makeText(MainActivity.this, "unknown error blah blah blah", Toast.LENGTH_SHORT).show();
                }
            });
            //Picasso.with(this).load("https://firebasestorage.googleapis.com/v0/b/pictures-9129a.appspot.com/o/TestImages%2F2.jpg?alt=media&token=8b2953e7-ec15-4469-af0b-e7737593bd1c").into(ig);

        }

        myAdapter = new RecyclerViewAdapter(links, this);
        myView.setAdapter(myAdapter);
    }
}