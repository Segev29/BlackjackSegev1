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
/*                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    users.sort(new Comparator<User>() {
                        @Override
                        public int compare(User user, User t1) {
                            return 0;
                        }
                    });
                }*/
                /*((MainActivity)context).dataChange();*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        DatabaseReference myRef = database.getReference(FirebaseAuth.getInstance().getUid());   // קבלת מזהה המשתמש מתוך Firebase Authentication
        myRef = database.getReference("Money/" + FirebaseAuth.getInstance().getUid());    // יצירת קישור למידע הפרטי של המשתמש תחת "Money/[UserID]"
        //DatabaseReference myRef = database.getReference().child(FirebaseAuth.getInstance().getUid());
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
                //Toast.makeText(context, "name onCancelled", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void setRecord( int record)
    {
        // Write a message to the database
        DatabaseReference myRef = database.getReference("Money").push(); // push adds new node with unique value

        //DatabaseReference myRef = database.getReference("records/" + FirebaseAuth.getInstance().getUid());

        MyMoney rec = new MyMoney(record);
        myRef.setValue(rec);    // שמירת האובייקט במסד הנתונים
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
