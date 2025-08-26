package com.quizcash.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminActivity extends Activity {

    private ListView playersListView;
    private PlayerAdapter adapter;
    private ArrayList<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        playersListView = findViewById(R.id.playersListView);

        // بيانات افتراضية (ممكن تخزنها بقايا في قاعدة بيانات لاحقاً)
        players = new ArrayList<>();
        players.add(new Player("أحمد", "01012345678", 35, false));
        players.add(new Player("سارة", "01198765432", 0, false));
        players.add(new Player("محمد", "01234567890", 70, true));

        adapter = new PlayerAdapter(this, players);
        playersListView.setAdapter(adapter);
    }

    // اللاعب
    public static class Player {
        String name;
        String phone;
        int balance;
        boolean active;

        public Player(String name, String phone, int balance, boolean active) {
            this.name = name;
            this.phone = phone;
            this.balance = balance;
            this.active = active;
        }
    }
}
