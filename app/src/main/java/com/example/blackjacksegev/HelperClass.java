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
        database = FirebaseDatabase.getInstance();
        this.context = context;
        this.myRecords = myRecords;

        Query myQuery = database.getReference("Money").orderByChild("score");

        myQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRecords.clear();  // clear the array list
                for(DataSnapshot userSnapshot : snapshot.getChildren())
                {
                    MyMoney currentMyRecord =userSnapshot.getValue(MyMoney.class);
                    myRecords.add(0, currentMyRecord);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        DatabaseReference myRef = database.getReference(FirebaseAuth.getInstance().getUid());   // קבלת מזהה המשתמש מתוך Firebase Authentication
        myRef = database.getReference("Money/" + FirebaseAuth.getInstance().getUid());    // יצירת קישור למידע הפרטי של המשתמש תחת "Money/[UserID]"
        myRef.addValueEventListener(new ValueEventListener() {   // מאזין לשינויים בנתונים של המשתמש הספציפי המחובר
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MyMoney currentRecord =snapshot.getValue(MyMoney.class);  // קבלת הרשומה של המשתמש
                if(currentRecord != null)
                {
                    ((MainActivity)context).userDataChange(currentRecord); // אם הרשומה קיימת, מעדכן את הנתונים ב-MainActivity
                }
                else
                    Log.d("TAG", "onDataChange: ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void setPrivateRecord(int record)
    {
        // Write a message to the database
        //DatabaseReference myRef = database.getReference("records").push(); // push adds new node with unique value

        DatabaseReference myRef = database.getReference("Money/" + FirebaseAuth.getInstance().getUid()); // יצירת נתיב ייחודי למשתמש המחובר

        MyMoney rec = new MyMoney(record);
        myRef.setValue(rec);// שמירת האובייקט במסד הנתונים
    }
}
