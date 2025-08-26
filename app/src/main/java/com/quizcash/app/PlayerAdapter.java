package com.quizcash.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AdminActivity.Player> players;

    public PlayerAdapter(Context context, ArrayList<AdminActivity.Player> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_player, parent, false);
        }

        TextView name = convertView.findViewById(R.id.playerName);
        TextView phone = convertView.findViewById(R.id.playerPhone);
        TextView balance = convertView.findViewById(R.id.playerBalance);
        Button approveBtn = convertView.findViewById(R.id.approveBtn);
        Button blockBtn = convertView.findViewById(R.id.blockBtn);

        AdminActivity.Player player = players.get(i);

        name.setText("الاسم: " + player.name);
        phone.setText("الموبايل: " + player.phone);
        balance.setText("الرصيد: " + player.balance + " ج");

        approveBtn.setOnClickListener(v -> {
            player.active = true;
            Toast.makeText(context, player.name + " تم تفعيل حسابه ✅", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });

        blockBtn.setOnClickListener(v -> {
            player.active = false;
            Toast.makeText(context, player.name + " تم حظر حسابه ❌", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });

        return convertView;
    }
}
