package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.expensetracker.Activity.Homepage;
import com.example.expensetracker.databinding.ActivityMainBinding;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemsClick {
    ActivityMainBinding binding;
    private ExpensesAdapter expensesAdapter;
    private long income=0,expense=0;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        expensesAdapter=new ExpensesAdapter(this,this);
        binding.recycler.setAdapter(expensesAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        Intent intent= new Intent(MainActivity.this, AddExpenseActivity.class);
        binding.addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intent.putExtra("type","Income");
            startActivity(intent);

            }
        });
        binding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("type","Expense");
                startActivity(intent);

            }
        });




    }

    @Override
    protected void onStart(){
        super.onStart();

        }



    @Override
    protected void onResume() {
        super.onResume();
        income=0;expense=0;
        getData();
    }

    private void getData() {
        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .whereEqualTo("uid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        expensesAdapter.clear();

                        List<DocumentSnapshot>dsList =queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds:dsList){
                            ExpenseModel expenseModel=ds.toObject(ExpenseModel.class);
                            if (expenseModel.getType().equals("Income")){
                                income+=expenseModel.getAmount();

                            }else {
                                expense+=expenseModel.getAmount();
                            }
                            expensesAdapter.add(expenseModel);
                        }
                        setUpGraph();
                    }
                });
    }

    private void setUpGraph() {
        List<PieEntry>pieEntryList=new ArrayList<>();
        List<Integer>colorList=new ArrayList<>();
        if(income!=0){
            pieEntryList.add(new PieEntry(income,"Income"));
            colorList.add(getResources().getColor(R.color.blue));
        }
        if(expense!=0){
            pieEntryList.add(new PieEntry(expense,"Expense"));
            colorList.add(getResources().getColor(R.color.grey));
        }
        PieDataSet pieDataSet=new PieDataSet(pieEntryList,String.valueOf(income-expense));
        pieDataSet.setColors(colorList);
        pieDataSet.setValueTextColor(getResources().getColor(R.color.black));
        PieData pieData=new PieData(pieDataSet);
        binding.pieChart.setData(pieData);
        binding.pieChart.invalidate();
    }

    @Override
    public void onClick(ExpenseModel expenseModel) {
        Intent intent= new Intent(MainActivity.this, AddExpenseActivity.class);
    intent.putExtra("model",expenseModel);

    startActivity(intent);
    }
}