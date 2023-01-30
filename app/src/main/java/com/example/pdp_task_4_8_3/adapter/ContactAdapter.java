package com.example.pdp_task_4_8_3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdp_task_4_8_3.databinding.ItemContactBinding;
import com.example.pdp_task_4_8_3.model.ContactList;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.VH>{

    private List<ContactList> contactList;
    OnItemClick onItemClick;

    public ContactAdapter(List<ContactList> contactList, OnItemClick onItemClick) {
        this.contactList = contactList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(ItemContactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.binding.name.setText(contactList.get(position).getName());
        holder.binding.phone.setText(contactList.get(position).getPhone());

        holder.itemView.setOnClickListener(view -> {
           onItemClick.onClickListener(contactList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ItemContactBinding binding;
        public VH(@NonNull ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    public interface OnItemClick{
        void onClickListener(ContactList contactList);
    }
}
