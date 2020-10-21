package no.ntnu.daiverse.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import no.ntnu.daiverse.R;


public class ItemActivity extends AppCompatActivity {

        private TextView textViewItemName, textViewDesc, textViewPrice;
        private Button buyBtn;
        private Toolbar toolbar;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_item);

            textViewItemName = findViewById(R.id.textItemName);
            textViewDesc = findViewById(R.id.textItemDesc);
            textViewPrice = findViewById(R.id.textItemPrice);
            buyBtn = findViewById(R.id.buyItemButton);
            toolbar = findViewById(R.id.mytoolbar);


            //Setting up the toolbar
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            textViewItemName.setText(getIntent().getStringExtra("item"));
            textViewDesc.setText(getIntent().getStringExtra("description"));
            textViewPrice.setText(getIntent().getStringExtra("price") + "kr");
        }

        private void setSupportActionBar(Toolbar toolbar) {
        }
    }
