package com.example.blackjacksegev;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class HelperClass {
    FirebaseDatabase database;
    Context context;
    ArrayList<MyMoney> myRecords;
    public HelperClass(Context context, ArrayList<MyMoney> myRecords) {
        //database = FirebaseDatabase.getInstance("https://fbrecordst-default-rtdb.firebaseio.com");
        database = FirebaseDatabase.getInstance();
        this.context = context;
        this.myRecords = myRecords;

        // read the records from the Firebase and order them by the record from highest to lowest
        // limit to only 8 items
        Query myQuery = database.getReference("records").orderByChild("score").limitToLast(8);

        myQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRecords.clear();  // clear the array list
                for(DataSnapshot userSnapshot : snapshot.getChildren())
                {
                    MyMoney currentMyRecord =userSnapshot.getValue(MyMoney.class);
                    myRecords.add(0, currentMyRecord);
                }
/*                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    users.sort(new Comparator<User>() {
                        @Override
                        public int compare(User user, User t1) {
                            return 0;
                        }
                    });
                }*/
                ((LeaderBoard)context).dataChange();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        DatabaseReference myRef = database.getReference(FirebaseAuth.getInstance().getUid());
        myRef = database.getReference("records/" + FirebaseAuth.getInstance().getUid());
        //DatabaseReference myRef = database.getReference().child(FirebaseAuth.getInstance().getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MyMoney currentRecord =snapshot.getValue(MyMoney.class);
                if(currentRecord != null)
                {
                    ((LeaderBoard)context).userDataChange(currentRecord);
                }
                else
                    Log.d("TAG", "onDataChange: ");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(context, "name onCancelled", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void setRecord(String name, int record)
    {
        // Write a message to the database
        DatabaseReference myRef = database.getReference("records").push(); // push adds new node with unique value

        //DatabaseReference myRef = database.getReference("records/" + FirebaseAuth.getInstance().getUid());

        MyMoney rec = new MyMoney(name, record);
        myRef.setValue(rec);
    }

    public void setPrivateRecord(String name, int record)
    {
        // Write a message to the database
        //DatabaseReference myRef = database.getReference("records").push(); // push adds new node with unique value

        DatabaseReference myRef = database.getReference("records/" + FirebaseAuth.getInstance().getUid());

        MyMoney rec = new MyMoney(name, record);
        myRef.setValue(rec);
    }
}
