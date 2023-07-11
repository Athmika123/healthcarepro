package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule","","","","50"},
                    {"HeralthVit Chromium Picolinate 200mcg Capsule","","","","305"},
                    {"Vitamin B Complex Capsule","","","","448"},
                    {"Inlife Vitamin E Wheat Germ Oil  Capsule","","","","539"},
                    {"Dolo 650 Tablet ","","","","30"},
                    {"Crosin 650 Advanced Tablet","","","","50"},
                    {"Strepsils","","","","40"},
                    {"Tata 1mg Calcium +Vitamin D3","","","","30"},
                    {"Feronia -Xt Tablet ","","","","130"},
            };

    private String[] package_details ={
            "Building and keeping the bones and teeth strong\n" +
                    "Reducing Stress and Muscular Pains\n"+
                    "Boosting Immunity",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulation",
            "provides relief from vitamin B deficiencies \n"+
                    "Helps in formation of red blood cells\n"+
                    "Maintans healthy nervous system",
            "It promotes health as well as skin benefits\n"+
                    "Reduces skin pigmentation\n"+
                    "Protects from UVB sunrays",
            "Dolo 650 tablet helps relieve pain and fever",
            "Helps to bring down the body temperature\n"+
                    "suitable for heart patients also",
            "Releives throat pain and throat infection\n"+
                    "Provides warm feeling during sore throat",
            "Reduces the risk of calcium deficiecies\n" +
                    "promotes mobility and flexibility of joints",
            "helps to reduce the iron deficiency due to low intake of iron"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack =findViewById(R.id.buttonBMBack);
        btnGoToCart =findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost :"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter( this,list,
                R.layout.multi_lines,
                new String[] { "line1","line2","line3","line4","line5"},
                new int[] { R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}