package com.example.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
  List<ChatDetails> list=new ArrayList<>();
  Context context;

    public MessageAdapter(Context context,List<ChatDetails> list) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1 ){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View sender = layoutInflater.inflate(R.layout.chat_left, parent, false);
            ViewHolder viewHolder = new ViewHolder(sender);
            return viewHolder;
        }
        else

        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View receiver = layoutInflater.inflate(R.layout.chat_right, parent, false);
            ViewHolder viewHolder = new ViewHolder(receiver);
            return viewHolder;
        }

    }
@Override
    public int getItemViewType(int position)
    {
        if(list.get(position).getUsername().equals("me"))
            return 1;
           else
    return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ChatDetails chat=list.get(position);
    holder.show_message.setText(chat.getMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView show_message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            show_message=(itemView).findViewById(R.id.user_message);
        }
    }
}
