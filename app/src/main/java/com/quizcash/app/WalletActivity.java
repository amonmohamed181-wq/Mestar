package com.quizcash.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WalletActivity extends Activity {

    private int balance = 0; // الرصيد يبدأ من 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        TextView balanceText = findViewById(R.id.balanceText);
        Button addMoney = findViewById(R.id.addMoneyButton);
        Button startGame = findViewById(R.id.startGameButton);

        balanceText.setText("رصيدك: " + balance + " ج");

        addMoney.setOnClickListener(v -> {
            // هنا اللاعب هيكون دخل بيانات التحويل، هنفترض انه دفع
            balance = 35;
            balanceText.setText("رصيدك: " + balance + " ج");
            Toast.makeText(this, "تم إضافة الرصيد بنجاح!", Toast.LENGTH_SHORT).show();
        });

        startGame.setOnClickListener(v -> {
            if (balance >= 35) {
                Intent i = new Intent(WalletActivity.this, QuizActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "رصيدك غير كافي، لازم يكون 35 ج", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
